package com.sparrow.tag.controller;

import com.sparrow.tag.assembler.TagAssembler;
import com.sparrow.tag.po.Tag;
import com.sparrow.tag.protocol.vo.SimpleTagVO;
import com.sparrow.tag.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "标签系统", tags = "标签系统")
@RequestMapping("tag")
public class TagController {
    @Inject
    private TagService tagService;

    @Inject
    private TagAssembler tagAssembler;

    @ApiOperation("标签列表")
    @GetMapping("list")
    public List<SimpleTagVO> list(@ApiParam("最后标签id") Long lastId) {
        List<Tag> tags = this.tagService.queryByLastId(lastId);
        return this.tagAssembler.assembleTagList(tags);
    }

    @ApiOperation("标签检索")
    @GetMapping("search")
    public List<SimpleTagVO> search(@ApiParam("标签名") String tag) {
        List<Tag> tags = this.tagService.queryByName(tag);
        return this.tagAssembler.assembleTagList(tags);
    }
}
