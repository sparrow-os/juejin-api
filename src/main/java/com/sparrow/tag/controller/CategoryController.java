package com.sparrow.tag.controller;

import com.sparrow.tag.protocol.vo.CategoryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
@Api(value = "标签系统", tags = "标签系统")
public class CategoryController {
    @ApiOperation("类别列表")
    @GetMapping("list")
    public List<CategoryVO> categoryList() {
        return null;
    }
}
