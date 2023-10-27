package com.sparrow.passport.protocol.param.password;

import com.sparrow.protocol.Param;

public class PasswordModifyParam implements Param {
    private String password;
    private String newPassword;
    private String newConfirmPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewConfirmPassword() {
        return newConfirmPassword;
    }

    public void setNewConfirmPassword(String newConfirmPassword) {
        this.newConfirmPassword = newConfirmPassword;
    }
}
