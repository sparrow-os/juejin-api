package com.sparrow.interact.controller;

import com.sparrow.interact.protocol.param.FavParam;
import com.sparrow.protocol.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("interact")
@Api(value = "交互系统", tags = "交互系统")
public class FavController {
    @PostMapping("fav")
    @ApiOperation("收藏")
    public Result<Boolean> fav(@RequestBody FavParam favParam) {
        return new Result<>(true);
    }

}
