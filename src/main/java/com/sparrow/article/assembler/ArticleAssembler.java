package com.sparrow.article.assembler;

import com.sparrow.article.po.Article;
import com.sparrow.article.protocol.param.PublishParam;
import com.sparrow.article.protocol.vo.AbstractArticleVO;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.ThreadContext;
import com.sparrow.utility.CollectionsUtility;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ArticleAssembler {
    public Article assembleArticle(PublishParam publishParam) {
        Article article = new Article();
        BeanUtils.copyProperties(publishParam, article);
        if (publishParam.getTags() == null) {
            article.setTags("");
        } else {
            article.setTags(Arrays.toString(publishParam.getTags()));
        }
        //todo 需要到后台check标签是否存在，防止非法用户请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                LoginUser loginUser=ThreadContext.getLoginToken();
            }
        }).start();
        //标签的优化
        article.setTags(Arrays.toString(publishParam.getTags()));
        //上下文的用户信息
        LoginUser loginUser = ThreadContext.getLoginToken();
        //需要手动设置
        article.setCreateUserName(loginUser.getUserName());
        article.setCreateUserId(loginUser.getUserId());
        article.setModifiedUserId(loginUser.getUserId());
        article.setModifiedUserName(loginUser.getUserName());
        article.setGmtCreate(System.currentTimeMillis());
        article.setGmtModified(System.currentTimeMillis());
        return article;
    }

    public List<AbstractArticleVO> assembleList(List<Article> articles) {
        if (CollectionsUtility.isNullOrEmpty(articles)) {
            return null;
        }
        List<AbstractArticleVO> abstractArticles = new ArrayList<>(articles.size());
        for (Article article : articles) {
            AbstractArticleVO abstractArticle = new AbstractArticleVO();
            BeanUtils.copyProperties(article, abstractArticle);
            abstractArticles.add(abstractArticle);
        }
        return abstractArticles;
    }
}
