package com.sparrow.interact.protocol.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("收藏")
public class FavParam {
    @ApiModelProperty("文章ID")
    private Long articleId;
    @ApiModelProperty("收藏夹")
    private Long favoriteId;
    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }
}
