package com.sparrow.interact.protocol.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "评论列表", description = "文章评论，支持最新和最热排序，不支持盖楼")
public class CommentQuery {
    private static final int NEWEST = 0;
    private static final int HOT = 1;
    @ApiModelProperty("当前文章")
    private Long articleId;
    @ApiModelProperty(value = "排序", notes = "按最新和最热排序，不支持盖楼")
    private Integer sort;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
