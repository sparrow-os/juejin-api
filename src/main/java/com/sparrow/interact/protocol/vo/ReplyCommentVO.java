package com.sparrow.interact.protocol.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("评论的回复")
public class ReplyCommentVO {
    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("文章ID")
    private Long articleId;
    @ApiModelProperty("内容")
    private Long content;
    @ApiModelProperty("评论人昵称")
    private String createUserName;
    @ApiModelProperty("评论人头象")
    private String createUserAvatar;
    @ApiModelProperty("用户ID")
    private Long createUserId;
    @ApiModelProperty("创建时间")
    private Long gmtCreate;
    @ApiModelProperty("更新时间")
    private Long gmtModified;
    @ApiModelProperty("发帖时间的格式化")
    private String formatTime;
    @ApiModelProperty("被点赞数")
    private Integer likeCount;
    @ApiModelProperty("回复ID")
    private Long replyCommentId;
    @ApiModelProperty("回复的作者ID")
    private Long replyToUserId;
    @ApiModelProperty("回复的作者昵称")
    private String replyToUserName;
    @ApiModelProperty("回复的作者头象")
    private String replyToUserAvatar;


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

    public Long getContent() {
        return content;
    }

    public void setContent(Long content) {
        this.content = content;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCreateUserAvatar() {
        return createUserAvatar;
    }

    public void setCreateUserAvatar(String createUserAvatar) {
        this.createUserAvatar = createUserAvatar;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getFormatTime() {
        return formatTime;
    }

    public void setFormatTime(String formatTime) {
        this.formatTime = formatTime;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Long getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(Long replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public Long getReplyToUserId() {
        return replyToUserId;
    }

    public void setReplyToUserId(Long replyToUserId) {
        this.replyToUserId = replyToUserId;
    }

    public String getReplyToUserName() {
        return replyToUserName;
    }

    public void setReplyToUserName(String replyToUserName) {
        this.replyToUserName = replyToUserName;
    }

    public String getReplyToUserAvatar() {
        return replyToUserAvatar;
    }

    public void setReplyToUserAvatar(String replyToUserAvatar) {
        this.replyToUserAvatar = replyToUserAvatar;
    }
}
