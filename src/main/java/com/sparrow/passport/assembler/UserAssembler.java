package com.sparrow.passport.assembler;

import com.sparrow.enums.Gender;
import com.sparrow.passport.po.User;
import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.passport.protocol.param.register.RegisterParam;
import com.sparrow.protocol.ClientInformation;
import com.sparrow.protocol.ThreadContext;
import com.sparrow.protocol.constant.magic.Symbol;
import com.sparrow.support.IpSupport;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserAssembler {

    @Inject
    private IpSupport ipSupport;

    public User assemblerUser(EmailRegisterParam registerParam, String encryptionPassword) {
        ClientInformation clientInformation = ThreadContext.getClientInfo();
        User user = new User();
        user.setUserName(registerParam.getUserName());
        user.setEmail(registerParam.getEmail());
        user.setPassword(encryptionPassword);
        user.setChannel(clientInformation.getChannel());
        user.setActivate(false);
        user.setActivateTime(0L);
        user.setBirthday(null);
        user.setAvatar(Symbol.EMPTY);
        user.setDevice(clientInformation.getDevice());
        user.setDeviceId(clientInformation.getDeviceId());
        user.setDeviceModel(clientInformation.getDeviceModel());
        user.setGender(Gender.NULL.ordinal());
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(System.currentTimeMillis());
        user.setIp(this.ipSupport.toLong(clientInformation.getIp()));
        user.setLastLoginTime(System.currentTimeMillis());
        user.setNationality(Symbol.EMPTY);
        user.setPersonalSignature(Symbol.EMPTY);
        user.setMobile(Symbol.EMPTY);
        user.setStatus(1);
        user.setNickName(Symbol.EMPTY);
        return user;
    }
}
