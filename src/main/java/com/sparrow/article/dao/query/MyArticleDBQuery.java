package com.sparrow.article.dao.query;

import com.sparrow.protocol.dao.DatabasePagerQuery;
import com.sparrow.protocol.pager.SimplePager;
import io.swagger.models.auth.In;

public class MyArticleDBQuery extends DatabasePagerQuery {

    public MyArticleDBQuery(SimplePager simplePager) {
        super(simplePager);
    }

    /**
     * 空间的用户ID
     */
    private Long userId;

    private Integer auditStatus;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }
}
