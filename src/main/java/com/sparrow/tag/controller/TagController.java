package com.sparrow.tag.controller;

import com.sparrow.tag.protocol.vo.SimpleTagVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "标签系统", tags = "标签系统")
public class TagController {

    @ApiOperation("标签列表")
    @GetMapping("list")
    public List<SimpleTagVO> list(@ApiParam("最后标签id") Long lastId) {
        List<SimpleTagVO> simpleTags = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SimpleTagVO simpleTag = new SimpleTagVO();
            simpleTag.setTagId((long) i);
            simpleTag.setTagName("TAG" + i);
            simpleTags.add(simpleTag);
        }
        return simpleTags;
    }

    @ApiOperation("标签检索")
    @GetMapping("search")
    public List<SimpleTagVO> search(@ApiParam("标签名") String  tag) {
        List<SimpleTagVO> simpleTags = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SimpleTagVO simpleTag = new SimpleTagVO();
            simpleTag.setTagId((long) i);
            simpleTag.setTagName("TAG" + i);
            simpleTags.add(simpleTag);
        }
        return simpleTags;
    }
}
