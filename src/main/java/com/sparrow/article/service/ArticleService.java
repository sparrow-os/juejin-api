package com.sparrow.article.service;

import com.sparrow.article.dao.ArticleDao;
import com.sparrow.article.po.Article;
import com.sparrow.article.protocol.param.PublishParam;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ArticleService {
    @Inject
    private ArticleDao articleDao;

    public void publish(PublishParam publishParam) {

        Article article = new Article();
        article.setId(publishParam.getId());
        article.setCategoryId(publishParam.getCategoryId());
        article.setColumnId(publishParam.getColumn());
        article.setTitle(publishParam.getTitle());
        article.setAbstracts(publishParam.getAbstracts());
        article.setTags("tags");
        //article.setTags(publishParam.getTags());//todo 通过标签id 获取name 保存字符串json
        article.setCreateUserName("harry");//todo 通过用户上下文获取当前用户信息
        article.setCreateUserId(1L);
        article.setModifiedUserId(1L);
        article.setModifiedUserName("harry");
        article.setGmtCreate(1L);
        article.setGmtModified(2L);
        this.articleDao.insert(article);
    }
}
