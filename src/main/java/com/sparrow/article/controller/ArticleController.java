package com.sparrow.article.controller;


import com.sparrow.article.protocol.param.PublishParam;
import com.sparrow.protocol.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("article")
@Api(value = "文章系统", tags = "文章系统")
public class ArticleController {
    @PostMapping("publish")
    @ApiOperation("发布")
    public Result<Boolean> publish(@RequestBody PublishParam publishParam) {
        return new Result<>(true);
    }


    @PostMapping("draft")
    @ApiOperation("保存草稿")
    public Result<Boolean> draft(@RequestBody String content) {
        return new Result<>(true);
    }
}
