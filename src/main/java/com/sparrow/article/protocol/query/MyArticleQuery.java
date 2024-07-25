package com.sparrow.article.protocol.query;

import com.sparrow.protocol.pager.SimplePager;

public class MyArticleQuery extends SimplePager {
    public static final Integer ALL = -1;
    public static final Integer AUDITING = 0;
    public static final Integer AUDITED = 1;
    public static final Integer REJECTED = 2;
}
