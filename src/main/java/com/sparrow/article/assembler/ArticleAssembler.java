package com.sparrow.article.assembler;

import com.sparrow.article.po.Article;
import com.sparrow.article.po.ArticleDetail;
import com.sparrow.article.protocol.param.PublishParam;
import com.sparrow.article.protocol.vo.AbstractArticleVO;
import com.sparrow.article.protocol.vo.ArticleVO;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.ThreadContext;
import com.sparrow.recommend.protocol.vo.RecommendArticleVO;
import com.sparrow.utility.CollectionsUtility;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ArticleAssembler {
    public ArticleDetail assembleDetail(PublishParam publishParam, Long articleId) {
        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setContent(publishParam.getContent());
        articleDetail.setId(articleId);
        //上下文的用户信息
        LoginUser loginUser = ThreadContext.getLoginToken();
        //需要手动设置
        articleDetail.setCreateUserName(loginUser.getUserName());
        articleDetail.setCreateUserId(loginUser.getUserId());
        articleDetail.setModifiedUserId(loginUser.getUserId());
        articleDetail.setModifiedUserName(loginUser.getUserName());
        articleDetail.setGmtCreate(System.currentTimeMillis());
        articleDetail.setGmtModified(System.currentTimeMillis());
        return articleDetail;
    }

    public Article assembleArticle(PublishParam publishParam) {
        Article article = new Article();
        BeanUtils.copyProperties(publishParam, article);
        if (publishParam.getTags() == null) {
            article.setTags("");
        } else {
            article.setTags(Arrays.toString(publishParam.getTags()));
        }
        //todo 需要到后台check标签是否存在，防止非法用户请求
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

    public ArticleVO assembleArticle(Article article, ArticleDetail detail) {
        ArticleVO articleVo = new ArticleVO();
        BeanUtils.copyProperties(article, articleVo);
        BeanUtils.copyProperties(detail, articleVo);
        return articleVo;
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

    public List<RecommendArticleVO> recommendAssembleList(List<Article> articles) {
        if (CollectionsUtility.isNullOrEmpty(articles)) {
            return null;
        }
        List<RecommendArticleVO> abstractArticles = new ArrayList<>(articles.size());
        for (Article article : articles) {
            RecommendArticleVO abstractArticle = new RecommendArticleVO();
            BeanUtils.copyProperties(article, abstractArticle);
            abstractArticles.add(abstractArticle);
        }
        return abstractArticles;
    }
}
