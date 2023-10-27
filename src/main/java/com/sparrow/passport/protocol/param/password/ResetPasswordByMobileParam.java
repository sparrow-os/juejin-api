package com.sparrow.passport.protocol.param.password;

import com.sparrow.protocol.Param;

public class ResetPasswordByMobileParam implements Param {
    private String validateCode;
    private String password;
    private String confirmPassword;

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
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
