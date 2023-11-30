package com.sparrow.dao.article;

import com.sparrow.article.dao.ArticleDao;
import com.sparrow.article.dao.query.MyArticleDBQuery;
import com.sparrow.article.po.Article;
import com.sparrow.boot.ApplicationBoot;
import com.sparrow.protocol.pager.SimplePager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.sql.SQLSyntaxErrorException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationBoot.class})
public class ArticleDaoTest {

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void insert() {
        for (int i = 0; i < 100; i++) {
            Article article = new Article();
            article.setCategoryId(1L);
            article.setColumnId(1L);
            article.setTitle("test");
            article.setAbstracts("abstract");
            article.setTags("tags");
            article.setViewCount(0);
            article.setLikeCount(0);
            article.setDislikeCount(0);
            article.setAuditStatus(0);
            article.setStatus(0);
            article.setCreateUserName("harry");
            article.setCreateUserId(1L);
            article.setModifiedUserId(1L);
            article.setModifiedUserName("harry");
            article.setGmtCreate(System.currentTimeMillis());
            article.setGmtModified(System.currentTimeMillis());
            this.articleDao.insert(article);
        }
    }

    @Test
    public void getEntity() {
        Article article = this.articleDao.getEntity(1L);
        Assert.isTrue(article != null);
        //org.junit.Assert.assertArrayEquals();
    }

    @Test
    public void myArticleList() {
        MyArticleDBQuery myArticleDBQuery = new MyArticleDBQuery(new SimplePager(10, 1));
        List<Article> articles = this.articleDao.queryMyArticles(myArticleDBQuery);

        Assert.isTrue(articles != null);
    }

}
