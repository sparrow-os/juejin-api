package com.sparrow.passport.protocol.param.register;

import com.sparrow.protocol.Param;

public abstract class RegisterParam implements Param {
    public RegisterParam() {
    }

    protected String password;

    protected String confirmPassword;

    protected String captcha;

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }



    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
