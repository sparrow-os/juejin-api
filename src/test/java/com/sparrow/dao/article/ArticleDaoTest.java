package com.sparrow.dao.article;

import com.sparrow.article.dao.ArticleDao;
import com.sparrow.article.po.Article;
import com.sparrow.boot.ApplicationBoot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationBoot.class})
public class ArticleDaoTest {

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void insert() {
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
        article.setGmtCreate(1L);
        article.setGmtModified(2L);
        this.articleDao.insert(article);
    }

    @Test
    public void getEntity() {
        Article article = this.articleDao.getEntity(1L);
        Assert.isTrue(article != null);
    }

}
