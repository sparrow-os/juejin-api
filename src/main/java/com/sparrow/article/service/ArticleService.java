package com.sparrow.article.service;

import com.sparrow.article.assembler.ArticleAssembler;
import com.sparrow.article.dao.ArticleDao;
import com.sparrow.article.dao.ArticleDetailDao;
import com.sparrow.article.dao.query.MyArticleDBQuery;
import com.sparrow.article.dao.query.UserArticleDBQuery;
import com.sparrow.article.po.Article;
import com.sparrow.article.po.ArticleDetail;
import com.sparrow.article.protocol.param.PublishParam;
import com.sparrow.article.protocol.query.MyArticleQuery;
import com.sparrow.article.protocol.query.UserArticleQuery;
import com.sparrow.article.protocol.vo.AbstractArticleVO;
import com.sparrow.article.protocol.vo.ArticleVO;
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
    private ArticleDetailDao articleDetailDao;
    @Inject
    private ArticleAssembler articleAssembler;

    public PagerResult<AbstractArticleVO> userArticleList(UserArticleQuery userArticleQuery) throws BusinessException {
        Asserts.isTrue(userArticleQuery.getUserId() == null, ArticleError.ARTICLE_AUTHOR_ID_IS_NULL);
        Asserts.isTrue(userArticleQuery.getPageSize() > Digit.HUNDRED, ArticleError.ARTICLE_PAGE_SIZE_EXCEED);

        UserArticleDBQuery userArticleDBQuery = new UserArticleDBQuery(userArticleQuery);
        userArticleDBQuery.setUserId(userArticleQuery.getUserId());
        LoginUser loginUser = ThreadContext.getLoginToken();
        //这里可能拿不到，可能是游客
        userArticleDBQuery.setAccessUserId(loginUser.getUserId());
        List<Article> articles = this.articleDao.queryUserArticles(userArticleDBQuery);
        //根据条件查询记录数
        Long totalSize = this.articleDao.countUserArticle(userArticleDBQuery);
        List<AbstractArticleVO> abstractArticles = this.articleAssembler.assembleList(articles);
        PagerResult<AbstractArticleVO> pagerResult = new PagerResult<>(userArticleQuery);
        pagerResult.setList(abstractArticles);
        pagerResult.setRecordTotal(totalSize);
        return pagerResult;
    }


    public void publish(PublishParam publishParam) throws BusinessException {
        //这个代码比上边的代码要简洁
        Asserts.isTrue(StringUtility.isNullOrEmpty(publishParam.getTitle()), ArticleError.ARTICLE_TITLE_IS_NULL);
        Asserts.isTrue(StringUtility.isNullOrEmpty(publishParam.getContent()), ArticleError.ARTICLE_CONTENT_IS_NULL);
        Asserts.isTrue(StringUtility.isNullOrEmpty(publishParam.getAbstracts()), ArticleError.ARTICLE_ABSTRACT_IS_NULL);
        Asserts.isTrue(publishParam.getCategoryId() == null, ArticleError.ARTICLE_CATEGORY_IS_NULL);
        Asserts.isTrue(publishParam.getTags() == null, ArticleError.ARTICLE_TAGS_IS_NULL);
        Asserts.isTrue(publishParam.getAbstracts().length() > 200, ArticleError.ARTICLE_ABSTRACT_EXCEED_200);
        Article article = articleAssembler.assembleArticle(publishParam);
        if (publishParam.getId() != null) {
            Boolean exist = this.articleDao.exist(publishParam.getId());
            Asserts.isTrue(!exist, ArticleError.ARTICLE_IS_NOT_FOUND);
            this.articleDao.update(article);
            ArticleDetail articleDetail = this.articleAssembler.assembleDetail(publishParam, publishParam.getId());
            this.articleDetailDao.update(articleDetail);
            return;
        }
        // todo 2.0 有草搞业务
        Long articleId = this.articleDao.insert(article);
        ArticleDetail articleDetail = this.articleAssembler.assembleDetail(publishParam, articleId);
        this.articleDetailDao.insert(articleDetail);
    }

    public PagerResult<AbstractArticleVO> userArticleList(UserArticleQuery userArticleQuery) throws BusinessException {
        Asserts.isTrue(userArticleQuery.getUserId() == null, ArticleError.ARTICLE_AUTHOR_ID_IS_NULL);
        Asserts.isTrue(userArticleQuery.getPageSize() > Digit.HUNDRED, ArticleError.ARTICLE_PAGE_SIZE_EXCEED);

        UserArticleDBQuery userArticleDBQuery = new UserArticleDBQuery(userArticleQuery);
        userArticleDBQuery.setUserId(userArticleQuery.getUserId());
        LoginUser loginUser = ThreadContext.getLoginToken();
        //这里可能拿不到，可能是游客
        userArticleDBQuery.setAccessUserId(loginUser.getUserId());
        List<Article> articles = this.articleDao.queryUserArticles(userArticleDBQuery);
        //根据条件查询记录数
        Long totalSize = this.articleDao.countUserArticle(userArticleDBQuery);
        List<AbstractArticleVO> abstractArticles = this.articleAssembler.assembleList(articles);
        PagerResult<AbstractArticleVO> pagerResult = new PagerResult<>(userArticleQuery);
        pagerResult.setList(abstractArticles);
        pagerResult.setRecordTotal(totalSize);
        return pagerResult;
    }


    public PagerResult<AbstractArticleVO> myArticleList(MyArticleQuery myArticleQuery, Integer status) throws BusinessException {
        Asserts.isTrue(myArticleQuery.getPageSize() > Digit.HUNDRED, ArticleError.ARTICLE_PAGE_SIZE_EXCEED);
        MyArticleDBQuery myArticleDBQuery = new MyArticleDBQuery(myArticleQuery);
        LoginUser loginUser = ThreadContext.getLoginToken();
        myArticleDBQuery.setUserId(loginUser.getUserId());
        myArticleDBQuery.setAuditStatus(status);
        List<Article> articles = this.articleDao.queryMyArticles(myArticleDBQuery);
        //根据条件查询记录数
        Long totalSize = this.articleDao.countMyArticle(myArticleDBQuery);
        List<AbstractArticleVO> abstractArticles = this.articleAssembler.assembleList(articles);
        PagerResult<AbstractArticleVO> pagerResult = new PagerResult<>(myArticleDBQuery);
        pagerResult.setList(abstractArticles);
        pagerResult.setRecordTotal(totalSize);
        return pagerResult;
    }

    public ArticleVO detail(Long detailId) {
        Article article = this.articleDao.getEntity(detailId);
        ArticleDetail articleDetail = this.articleDetailDao.getEntity(detailId);
        return this.articleAssembler.assembleArticle(article, articleDetail);
    }
}
