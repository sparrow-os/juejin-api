package com.sparrow.config;

import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.LoginUserStatus;
import com.sparrow.utility.StringUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultAuthenticator implements Authenticator {
    private Logger logger = LoggerFactory.getLogger(DefaultAuthenticator.class);

    @Override
    public String sign(LoginUser loginUser, LoginUserStatus loginUserStatus) {
        return null;
    }

    private LoginUser getVisitor(String deviceId) {
        return LoginUser.create(0L, "visitor", "游客", "default avator", deviceId, 0);
    }

    private String getDecryptKey() {
        //todo 获取解密的密钥
        return null;
    }

    private LoginUser verify(String token, String decryptKey) {
        return null;
    }

    private LoginUserStatus getUserStatus(Long userId) {
        return null;
    }

    private LoginUserStatus getUserStatusFromDB(Long userId) {
        return null;
    }

    private void reneal(LoginUser loginUser, LoginUserStatus loginUserStatus) {

    }

    @Override
    public LoginUser authenticate(String token, String deviceId) {
        LoginUser visitor = this.getVisitor(deviceId);
        //防止非法请求
        if (StringUtility.isNullOrEmpty(token)) {
            logger.error("token is empty");
            return visitor;
        }
        //验签
        LoginUser loginUser = this.verify(token, this.getDecryptKey());
        if (loginUser == null) {
            logger.error("token of user can't be verify");
            return visitor;
        }
        //防止token 被盗
        if (!loginUser.getDeviceId().equals(deviceId)) {
            logger.error("device id can't match sign's device id [{}] ,request device id [{}]", loginUser.getDeviceId(), deviceId);
            return visitor;
        }
        LoginUserStatus loginUserStatus = this.getUserStatus(loginUser.getUserId());
        long expireAt;
        //存在哪？一般会在缓存里  redis
        //什么时侯读不到呢？
        //redis 挂了！！
        if (loginUserStatus == null) {
            expireAt = loginUser.getExpireAt();
            //兜底策略
            loginUserStatus = this.getUserStatusFromDB(loginUser.getUserId());
            loginUserStatus.setExpireAt(expireAt);
        } else {
            expireAt = loginUser.getExpireAt();
        }

        if (expireAt < System.currentTimeMillis()) {
            logger.error("token is expired");
            return visitor;
        }

        if (!LoginUserStatus.STATUS_NORMAL.equals(loginUserStatus.getStatus())) {
            logger.error("user is disabled");
            return visitor;
        }

        this.reneal(loginUser, loginUserStatus);
        return loginUser;
    }
}
