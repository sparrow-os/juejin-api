package com.sparrow.interact.protocol.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("评论")
public class CommentVO {
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
    @ApiModelProperty("评论数")
    private Integer commentCount;
    @ApiModelProperty("回复列表")
    private List<ReplyCommentVO> children;


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

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public List<ReplyCommentVO> getChildren() {
        return children;
    }

    public void setChildren(List<ReplyCommentVO> children) {
        this.children = children;
    }
}
