package com.sparrow.passport.controller;

import com.sparrow.passport.protocol.query.LoginQuery;
import com.sparrow.passport.service.UserService;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@Api(value = "Passport系统", tags = "Passport系统")
@RestController
public class LoginController {

    @Inject
    private UserService userService;

    @ApiOperation("密码登录")
    @PostMapping("login")
    public String login(@RequestBody LoginQuery userQuery) throws BusinessException {
        return this.userService.login(userQuery);
    }

    @ApiOperation("退出")
    @PostMapping("logout")
    public Result<Boolean> logout() {
        return new Result<>(true);
    }
}
