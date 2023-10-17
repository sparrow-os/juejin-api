package com.sparrow.passport.protocol.param.register;

import com.sparrow.protocol.Param;

public abstract class RegisterParam implements Param {
    public RegisterParam() {
    }

    protected String password;

    protected String passwordConfirm;

    protected String captcha;

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }


    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

}
