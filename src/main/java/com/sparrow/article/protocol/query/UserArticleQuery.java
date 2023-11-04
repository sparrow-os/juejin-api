package com.sparrow.article.protocol.query;

import com.sparrow.protocol.pager.SimplePager;

public class UserArticleQuery extends SimplePager {
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
