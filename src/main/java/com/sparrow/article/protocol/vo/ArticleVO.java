package com.sparrow.article.protocol.vo;

import com.sparrow.recommend.protocol.vo.RecommendArticleVO;
import io.swagger.annotations.ApiModelProperty;

public class ArticleVO extends RecommendArticleVO {

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

    @ApiModelProperty("详情内容")
    private String content;
    @ApiModelProperty("话题")
    private String topic;
    @ApiModelProperty("收藏数")
    private Integer favCount;
    @ApiModelProperty("专栏ID")
    private Long columnId;
    @ApiModelProperty("专栏名")
    private String columnName;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getFavCount() {
        return favCount;
    }

    public void setFavCount(Integer favCount) {
        this.favCount = favCount;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String getCreateUserName() {
        return createUserName;
    }

    @Override
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    @Override
    public Long getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public Integer getLikeCount() {
        return likeCount;
    }

    @Override
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    @Override
    public Integer getDislikeCount() {
        return dislikeCount;
    }

    @Override
    public void setDislikeCount(Integer dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    @Override
    public Integer getViewCount() {
        return viewCount;
    }

    @Override
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String getTags() {
        return tags;
    }

    @Override
    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String getCoverImage() {
        return coverImage;
    }

    @Override
    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }
}
