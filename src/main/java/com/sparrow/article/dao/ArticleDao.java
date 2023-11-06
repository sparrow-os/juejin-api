package com.sparrow.article.dao;

import com.sparrow.article.po.Article;
import com.sparrow.article.dao.query.UserArticleDBQuery;
import com.sparrow.protocol.dao.DaoSupport;

import java.util.List;

public interface ArticleDao extends DaoSupport<Article, Long> {
    List<Article> userArticleList(UserArticleDBQuery myArticleQuery);
}
