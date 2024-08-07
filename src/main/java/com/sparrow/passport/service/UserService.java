package com.sparrow.passport.service;

import com.sparrow.constant.Regex;
import com.sparrow.exception.Asserts;
import com.sparrow.passport.assembler.UserAssembler;
import com.sparrow.passport.dao.UserDAO;
import com.sparrow.passport.po.User;
import com.sparrow.passport.protocol.enums.PassportError;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.passport.protocol.query.LoginQuery;
import com.sparrow.passport.support.PassportRegex;
import com.sparrow.protocol.*;
import com.sparrow.protocol.constant.Constant;
import com.sparrow.protocol.constant.SparrowError;
import com.sparrow.protocol.constant.magic.Symbol;
import com.sparrow.protocol.enums.StatusRecord;
import com.sparrow.servlet.ServletContainer;
import com.sparrow.support.Authenticator;
import com.sparrow.support.CaptchaService;
import com.sparrow.support.web.HttpContext;
import com.sparrow.support.web.ServletUtility;
import com.sparrow.utility.RegexUtility;
import com.sparrow.utility.StringUtility;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserService {
    @Inject
    private UserDAO userDao;
    @Inject
    private EncryptionService encryptionService;
    @Inject
    private Authenticator authenticatorService;
    @Inject
    private UserAssembler userAssembler;

    @Inject
    CaptchaService captchaService;

    public String login(LoginQuery loginQuery) throws BusinessException {
        String captcha = captchaService.getCaptcha(HttpContext.getContext().getRequest().getRequestedSessionId());
        Asserts.isTrue(!loginQuery.getCaptcha().equalsIgnoreCase(captcha), SparrowError.GLOBAL_VALIDATE_CODE_ERROR);
        //刷呀 todo 防刷策略
        Asserts.isTrue(StringUtility.isNullOrEmpty(loginQuery.getUserName()), SparrowError.GLOBAL_PARAMETER_IS_ILLEGAL);
        Asserts.isTrue(StringUtility.isNullOrEmpty(loginQuery.getPassword()), SparrowError.GLOBAL_PARAMETER_IS_ILLEGAL);
        Asserts.isTrue(StringUtility.isNullOrEmpty(loginQuery.getCaptcha()), SparrowError.GLOBAL_PARAMETER_IS_ILLEGAL);
        ClientInformation clientInformation = ThreadContext.getClientInfo();
        User user = null;
        if (loginQuery.getUserName().contains(Symbol.AT)) {
            user = this.userDao.getUserByEmail(loginQuery.getUserName());
            Asserts.isTrue(user == null, PassportError.USER_EMAIL_NOT_EXIST);
        } else {
            user = this.userDao.getUserByName(loginQuery.getUserName());
            Asserts.isTrue(user == null, PassportError.USER_NAME_NOT_EXIST);
        }

        Asserts.isTrue(StatusRecord.DISABLE.ordinal() == user.getStatus(), PassportError.USER_DISABLED);

        String encryptedPassword = this.encryptionService.encryptPassword(loginQuery.getPassword());
        Asserts.isTrue(!encryptedPassword.equals(user.getPassword()), PassportError.USER_PASSWORD_ERROR);

        //TODO SEND LOGIN event mq

        Integer tokenExpireDays = loginQuery.getRememberMe() ? 14 : 1;
        LoginUser loginUser = LoginUser.create(user.getUserId(), user.getUserName(), user.getNickName(), user.getAvatar(), clientInformation.getDeviceId(), tokenExpireDays);
        //续期
        //踢除逻辑
        LoginUserStatus loginUserStatus = new LoginUserStatus(LoginUserStatus.STATUS_NORMAL, loginUser.getExpireAt());
        return this.authenticatorService.sign(loginUser, loginUserStatus);
    }

    /**
     * 1.邮箱的格式
     * 2.用户名的格式
     * 3.密码的格式
     * 4.密码是否一致
     * 5.用户名是否存在
     * 6.邮箱是否存在
     * 7.密码加密
     * 8.写数据库
     */
    public String register(EmailRegisterParam registerParam) throws BusinessException {
        String captcha = captchaService.getCaptcha(HttpContext.getContext().getRequest().getRequestedSessionId());
        Asserts.isTrue(!registerParam.getCaptcha().equalsIgnoreCase(captcha), SparrowError.GLOBAL_VALIDATE_CODE_ERROR);
        Asserts.isTrue(StringUtility.isNullOrEmpty(registerParam.getEmail()), PassportError.USER_REGISTER_EMAIL_NULL);
        Asserts.isTrue(StringUtility.isNullOrEmpty(registerParam.getUserName()), PassportError.USER_REGISTER_NAME_NULL);
        Asserts.isTrue(StringUtility.isNullOrEmpty(registerParam.getPassword()), PassportError.USER_PASSWORD_ERROR);
        Asserts.isTrue(!RegexUtility.matches(registerParam.getPassword(), Regex.PASSWORD), PassportError.USER_PASSWORD_FORMAT_ERROR);
        Asserts.isTrue(!RegexUtility.matches(registerParam.getConfirmPassword(), Regex.PASSWORD), PassportError.USER_PASSWORD_FORMAT_ERROR);
        Asserts.isTrue(!RegexUtility.matches(registerParam.getUserName(), PassportRegex.USER_NAME), PassportError.USER_REGISTER_USER_NAME_FORMAT_ERROR);
        Asserts.isTrue(!RegexUtility.matches(registerParam.getEmail(), PassportRegex.EMAIL), PassportError.USER_REGISTER_EMAIL_FORMAT_ERROR);

        Asserts.isTrue(!registerParam.getPassword().equals(registerParam.getConfirmPassword()), PassportError.USER_REGISTER_PASSWORD_NOT_CONFORM);
        User existUserName = this.userDao.getUserByName(registerParam.getUserName());
        Asserts.isTrue(existUserName != null, PassportError.USER_NAME_EXIST);
        User existEmail = this.userDao.getUserByEmail(registerParam.getEmail());
        Asserts.isTrue(existEmail != null, PassportError.USER_EMAIL_EXIST);
        String encryptionPassword = this.encryptionService.encryptPassword(registerParam.getPassword());
        User user = this.userAssembler.assemblerUser(registerParam, encryptionPassword);
        this.userDao.insert(user);
        ClientInformation clientInformation = ThreadContext.getClientInfo();
        LoginUser loginUser = LoginUser.create(user.getUserId(), user.getUserName(), user.getNickName(), user.getAvatar(), clientInformation.getDeviceId(), 1);
        LoginUserStatus loginUserStatus = new LoginUserStatus(LoginUserStatus.STATUS_NORMAL, loginUser.getExpireAt());
        return this.authenticatorService.sign(loginUser, loginUserStatus);
    }
}
