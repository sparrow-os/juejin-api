package com.sparrow.tag.controller;

import com.sparrow.tag.protocol.vo.TopicVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(value = "标签系统", tags = "标签系统")
@RestController
@RequestMapping("topic")
public class TopicController {
    @GetMapping("list")
    @ApiOperation("话题列表")
    public List<TopicVO> list(@ApiParam("当前列表的最后id") Long lastId) {
        List<TopicVO> topics = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            topics.add(new TopicVO((long) i, "这里是话题" + i));
        }
        return topics;
    }

    @GetMapping("search")
    @ApiOperation("话题检索")
    public List<TopicVO> search(@ApiParam("当前列表的最后id") String  topic) {
        List<TopicVO> topics = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            topics.add(new TopicVO((long) i, "这里是话题" + i));
        }
        return topics;
    }
}
