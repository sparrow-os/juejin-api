package com.sparrow.passport.protocol.param.register;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("手机号验证码")
public class MobileCaptchaParam {
    @ApiModelProperty("手机号")
    private String mobile;
    @ApiModelProperty("验证码")
    private String captcha;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
