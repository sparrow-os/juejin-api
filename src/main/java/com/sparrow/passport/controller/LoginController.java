package com.sparrow.passport.controller;

import com.sparrow.passport.protocol.query.LoginQuery;
import com.sparrow.protocol.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Passport系统", tags = "Passport系统")
@RestController
public class LoginController {

    @ApiOperation("密码登录")
    @PostMapping("login")
    public Result<String> login(@RequestBody LoginQuery user) {
        return new Result<>("token");
    }
}
