package com.sparrow.article.service;

import com.sparrow.article.assembler.ArticleAssembler;
import com.sparrow.article.dao.ArticleDao;
import com.sparrow.article.dao.query.UserArticleDBQuery;
import com.sparrow.article.po.Article;
import com.sparrow.article.protocol.param.PublishParam;
import com.sparrow.article.protocol.query.UserArticleQuery;
import com.sparrow.article.protocol.vo.AbstractArticleVO;
import com.sparrow.article.support.ArticleError;
import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.ThreadContext;
import com.sparrow.protocol.constant.magic.Digit;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.utility.StringUtility;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
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
        Asserts.isTrue(publishParam.getCategoryId() == null, ArticleError.ARTICLE_CATEGORY_IS_NULL);
        Asserts.isTrue(publishParam.getTags() == null, ArticleError.ARTICLE_TAGS_IS_NULL);
        Asserts.isTrue(publishParam.getAbstracts().length() > 200, ArticleError.ARTICLE_ABSTRACT_EXCEED_200);
        Article article = articleAssembler.assembleArticle(publishParam);
        //防刷的问题
        this.articleDao.insert(article);
    }

    public PagerResult<AbstractArticleVO> userArticleList(UserArticleQuery userArticleQuery) throws BusinessException {
        Asserts.isTrue(userArticleQuery.getUserId() == null, ArticleError.ARTICLE_AUTHOR_ID_IS_NULL);
        Asserts.isTrue(userArticleQuery.getPageSize() > Digit.HUNDRED, ArticleError.ARTICLE_PAGE_SIZE_EXCEED);


        UserArticleDBQuery userArticleDBQuery = new UserArticleDBQuery(userArticleQuery);
        userArticleDBQuery.setUserId(userArticleQuery.getUserId());
        LoginUser loginUser = ThreadContext.getLoginToken();
        //这里可能拿不到，可能是游客
        userArticleDBQuery.setAccessUserId(loginUser.getUserId());
        List<Article> articles = this.articleDao.userArticleList(userArticleDBQuery);
        //根据条件查询记录数
        Long totalSize = 100L;//this.articleDao.getCountByUnique();
        List<AbstractArticleVO> abstractArticles = this.articleAssembler.assembleList(articles);
        PagerResult<AbstractArticleVO> pagerResult = new PagerResult<>(userArticleQuery);
        pagerResult.setList(abstractArticles);
        pagerResult.setRecordTotal(totalSize);
        return pagerResult;
    }
}
