package com.sparrow.article.service;

import com.sparrow.article.assembler.ArticleAssembler;
import com.sparrow.article.dao.ArticleDao;
import com.sparrow.article.po.Article;
import com.sparrow.article.protocol.param.PublishParam;
import com.sparrow.article.protocol.vo.AbstractArticleVO;
import com.sparrow.article.support.ArticleError;
import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.protocol.pager.SimplePager;
import com.sparrow.utility.StringUtility;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Inject
    private ArticleDao articleDao;
    @Inject
    private ArticleAssembler articleAssembler;

    public void publish(PublishParam publishParam) throws BusinessException {
        //这个代码比上边的代码要简洁
        Asserts.isTrue(StringUtility.isNullOrEmpty(publishParam.getTitle()), ArticleError.ARTICLE_TITLE_IS_NULL);
        Asserts.isTrue(StringUtility.isNullOrEmpty(publishParam.getContent()), ArticleError.ARTICLE_CONTENT_IS_NULL);
        Asserts.isTrue(StringUtility.isNullOrEmpty(publishParam.getAbstracts()), ArticleError.ARTICLE_ABSTRACT_IS_NULL);
        Article article = this.articleAssembler.assembleArticle(publishParam);
        //标签的优化
        article.setTags("tags");
        //article.setTags(publishParam.getTags());//todo 通过标签id 获取name 保存字符串json
        this.articleDao.insert(article);
    }

    public PagerResult<AbstractArticleVO> my(SimplePager pager) {
        List<Article> articles = this.articleDao.getList();
        Long totalSize=100L;//this.articleDao.getCountByUnique();
        //todo
        List<AbstractArticleVO> abstractArticles = this.articleAssembler.assembleList(articles);
        abstractArticles=new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            AbstractArticleVO abstractArticle = new AbstractArticleVO();
            abstractArticle.setId((long) i);
            abstractArticle.setTitle("标题" + i);
            abstractArticle.setAbstracts("摘要");
            abstractArticle.setCreateUserName("创建人");
            abstractArticle.setCreateUserId(0L);
            abstractArticle.setLikeCount(0);
            abstractArticle.setDislikeCount(0);
            abstractArticle.setTags("JAVA .NET");
            abstractArticle.setCoverImage("图片");
            abstractArticle.setViewCount(0);
            abstractArticle.setCreateTime(0L);
            abstractArticles.add(abstractArticle);
        }
        PagerResult<AbstractArticleVO> pagerResult=new PagerResult<>(pager);
        pagerResult.setList(abstractArticles);
        pagerResult.setRecordTotal(totalSize);
        return pagerResult;
    }
}
