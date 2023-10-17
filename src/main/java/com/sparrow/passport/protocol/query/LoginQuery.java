package com.sparrow.passport.protocol.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("登录")
public class LoginQuery {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("记住我")
    private Boolean remember;

    @ApiModelProperty("验证码")
    private String captcha;

    @ApiModelProperty("重定向url")
    private String redirectUrl;
}
