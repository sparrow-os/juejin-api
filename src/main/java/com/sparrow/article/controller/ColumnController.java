package com.sparrow.article.controller;

import com.sparrow.article.protocol.vo.ColumnVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("column")
@Api(value = "文章系统", tags = "文章系统")
public class ColumnController {
    @ApiOperation("专栏列表")
    @PostMapping("list")
    public List<ColumnVO> columnList() {
        List<ColumnVO> columnList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ColumnVO columnVO = new ColumnVO();
            columnVO.setId(0L);
            columnVO.setName("专栏" + i);
            columnVO.setDesc("专栏描述");
            columnVO.setIcon("icon");
            columnList.add(columnVO);
        }
        return columnList;
    }
}
