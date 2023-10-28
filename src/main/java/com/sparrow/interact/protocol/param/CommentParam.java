package com.sparrow.interact.protocol.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("评论")
public class CommentParam {
    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("文章ID")
    private Long articleId;
    @ApiModelProperty("回复内容")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
