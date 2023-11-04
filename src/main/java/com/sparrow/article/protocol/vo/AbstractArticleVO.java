package com.sparrow.article.protocol.vo;

import com.sparrow.protocol.VO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("文章摘要列表")
public class AbstractArticleVO implements VO {
    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("摘要")
    private String abstracts;
    @ApiModelProperty("创建人ID")
    private Long createUserId;
    @ApiModelProperty("创建人用户名")
    private String createUserName;
    @ApiModelProperty("创建人时间")
    private Long createTime;
    @ApiModelProperty("点赞数")
    private Integer likeCount;
    @ApiModelProperty("踩数")
    private Integer dislikeCount;

    @ApiModelProperty("展示数")
    private Integer viewCount;
    @ApiModelProperty("标签")
    private String tags;
    @ApiModelProperty("封面图")
    private String coverImage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(Integer dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
