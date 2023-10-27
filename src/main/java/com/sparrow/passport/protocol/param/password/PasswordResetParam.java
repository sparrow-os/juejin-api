package com.sparrow.passport.protocol.param.password;

import com.sparrow.protocol.Param;

public class PasswordResetParam implements Param {
    private String token;
    private String password;
    private String  confirmPassword;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
