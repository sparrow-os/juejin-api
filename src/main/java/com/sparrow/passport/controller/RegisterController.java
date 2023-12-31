package com.sparrow.passport.controller;

import com.sparrow.passport.protocol.param.register.EmailRegisterParam;
import com.sparrow.passport.protocol.param.register.MobileCaptchaParam;
import com.sparrow.passport.protocol.param.register.MobileRegisterParam;
import com.sparrow.passport.service.UserService;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;


@Api(value = "Passport系统", tags = "Passport系统")
@RequestMapping("register")
@RestController
public class RegisterController {
    @Inject
    private UserService userService;

    @ApiOperation("邮箱注册")
    @PostMapping("email")
    public String register(@RequestBody EmailRegisterParam emailRegister) throws BusinessException {
        return this.userService.register(emailRegister);
    }

    @ApiOperation("手机号密码注册")
    @PostMapping("mobile")
    public Result<String> mobileRegister(@RequestBody MobileRegisterParam mobileRegister) {
        return new Result<>("token");
    }


    @ApiOperation("手机号验证码注册")
    @PostMapping("mobile-captcha")
    public Result<String> mobileCaptchaRegister(@RequestBody MobileCaptchaParam mobileCaptcha) {
        return new Result<>("token");
    }
}
