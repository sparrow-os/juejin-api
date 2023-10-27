package com.sparrow.passport.protocol.param.register;

import com.sparrow.protocol.Param;

public class EmailActivateParam implements Param {
    /**
     * 对称加密
     * userId email 在token里的
     */
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
