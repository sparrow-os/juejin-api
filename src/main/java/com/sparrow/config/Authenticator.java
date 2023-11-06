package com.sparrow.config;

import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.LoginUserStatus;

public interface Authenticator {
    String sign(LoginUser loginUser, LoginUserStatus loginUserStatus);

    LoginUser authenticate(String token, String deviceId);
}
