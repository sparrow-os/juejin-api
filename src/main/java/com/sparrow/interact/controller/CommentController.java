package com.sparrow.interact.controller;

import com.sparrow.interact.protocol.param.CommentParam;
import com.sparrow.interact.protocol.param.ReplyCommentParam;
import com.sparrow.interact.protocol.query.CommentQuery;
import com.sparrow.interact.protocol.vo.CommentVO;
import com.sparrow.protocol.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("interact")
@Api(value = "交互系统", tags = "交互系统")
public class CommentController {


    @PostMapping("comment")
    @ApiOperation("评论")
    public Result<Boolean> comment(@RequestBody CommentParam commentParam) {
        return new Result<>(true);
    }


    @PostMapping("reply-comment")
    @ApiOperation("评论")
    public Result<Boolean> replayComment(@RequestBody ReplyCommentParam commentParam) {
        return new Result<>(true);
    }


    @ApiOperation("评论列表")
    @PostMapping("comment-list")
    public List<CommentVO> commentList(@RequestBody CommentQuery commentQuery) {
        return null;
    }
}
