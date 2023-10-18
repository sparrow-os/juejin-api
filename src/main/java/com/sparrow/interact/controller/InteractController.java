package com.sparrow.interact.controller;

import com.sparrow.interact.protocol.param.FavParam;
import com.sparrow.protocol.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("interact")
@Api(value = "交互系统", tags = "交互系统")
public class InteractController {
    @PostMapping("like/{articleId}")
    @ApiOperation("赞")
    public Result<Boolean> like(@PathVariable("articleId") Long articleId) {
        return new Result<>(true);
    }

    @PostMapping("dislike/{articleId}")
    @ApiOperation("踩")
    public Result<Boolean> dislike(@PathVariable("articleId") Long articleId) {
        return new Result<>(true);
    }

    @PostMapping("fav")
    @ApiOperation("收藏")
    public Result<Boolean> fav(@RequestBody FavParam favParam) {
        return new Result<>(true);
    }
}
