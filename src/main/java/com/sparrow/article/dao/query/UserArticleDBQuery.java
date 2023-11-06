package com.sparrow.article.dao.query;

import com.sparrow.protocol.dao.DatabasePagerQuery;
import com.sparrow.protocol.pager.SimplePager;

public class UserArticleDBQuery extends DatabasePagerQuery {
    public UserArticleDBQuery(SimplePager simplePager) {
        super(simplePager);
    }

    /**
     * 空间的用户ID
     */
    private Long userId;
    /**
     * 当前访问用户的ID
     */
    private Long accessUserId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAccessUserId() {
        return accessUserId;
    }

    public void setAccessUserId(Long accessUserId) {
        this.accessUserId = accessUserId;
    }
}
