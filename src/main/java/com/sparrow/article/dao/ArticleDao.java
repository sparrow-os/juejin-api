package com.sparrow.article.dao;

import com.sparrow.article.dao.query.MyArticleDBQuery;
import com.sparrow.article.po.Article;
import com.sparrow.article.dao.query.UserArticleDBQuery;
import com.sparrow.protocol.dao.DaoSupport;

import java.util.List;

public interface ArticleDao extends DaoSupport<Article, Long> {
    List<Article> queryUserArticles(UserArticleDBQuery myArticleQuery);

    Long countUserArticle(UserArticleDBQuery userArticleDBQuery);

    List<Article> queryMyArticles(MyArticleDBQuery myArticleDBQuery);

    Long countMyArticle(MyArticleDBQuery myArticleDBQuery);

}
