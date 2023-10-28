package com.sparrow.interact.protocol.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("回复评论")
public class ReplyCommentParam {
    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("文章ID")
    private Long articleId;
    @ApiModelProperty("根评论ID")
    private Long rootCommentId;
    @ApiModelProperty("父评论")
    private Long parentCommentId;
    @ApiModelProperty("回复人ID")
    private String replyToUserId;
    @ApiModelProperty("回复人昵称")
    private String replyToUserName;
    @ApiModelProperty("回复人icon")
    private String replyToIcon;
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

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyToUserId() {
        return replyToUserId;
    }

    public void setReplyToUserId(String replyToUserId) {
        this.replyToUserId = replyToUserId;
    }

    public String getReplyToUserName() {
        return replyToUserName;
    }

    public void setReplyToUserName(String replyToUserName) {
        this.replyToUserName = replyToUserName;
    }

    public String getReplyToIcon() {
        return replyToIcon;
    }

    public void setReplyToIcon(String replyToIcon) {
        this.replyToIcon = replyToIcon;
    }

    public Long getRootCommentId() {
        return rootCommentId;
    }

    public void setRootCommentId(Long rootCommentId) {
        this.rootCommentId = rootCommentId;
    }
}
