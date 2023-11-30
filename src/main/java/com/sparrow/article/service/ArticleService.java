package com.sparrow.article.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
import com.sparrow.article.redis.PlaceHolderParser;
import com.sparrow.article.redis.PropertyAccessBuilder;
import com.sparrow.article.redis.RedisKey;
import com.sparrow.article.support.ArticleError;
import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.ThreadContext;
import com.sparrow.protocol.constant.SparrowError;
import com.sparrow.protocol.constant.magic.Digit;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.recommend.protocol.vo.RecommendArticleVO;
import com.sparrow.spring.starter.redis.OperateLimiter;
import com.sparrow.tag.service.CategoryService;
import com.sparrow.utility.CollectionsUtility;
import com.sparrow.utility.StringUtility;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Comparator;
import java.util.List;

@Service
public class ArticleService {
    private static Logger logger = LoggerFactory.getLogger(ArticleService.class);
    @Inject
    private ArticleDao articleDao;
    @Inject
    private ArticleDetailDao articleDetailDao;
    @Inject
    private ArticleAssembler articleAssembler;
    @Inject
    private OperateLimiter operateLimiter;
    @Inject
    private CategoryService categoryService;

    public List<RecommendArticleVO> recommend() throws BusinessException {
        double likeWeight = 0.5;
        double favWeight = 0.2;
        double commentWeight = 0.3;
        int hours = 48;
        long startTime = System.currentTimeMillis() - 1000 * 60 * 60 * hours;
        List<Article> articles = this.articleDao.getArticles(startTime);
        List<RecommendArticleVO> abstractArticles = this.articleAssembler.recommendAssembleList(articles);
        Asserts.isTrue(CollectionsUtility.isNullOrEmpty(abstractArticles), ArticleError.ARTICLE_ABSTRACT_IS_NULL);
        for (RecommendArticleVO abstractArticle : abstractArticles) {
            int likeCount = abstractArticle.getLikeCount() == null ? 0 : abstractArticle.getLikeCount();
            int favCount = abstractArticle.getFavCount() == null ? 0 : abstractArticle.getFavCount();
            int dislikeCount = abstractArticle.getDislikeCount() == null ? 0 : abstractArticle.getDislikeCount();
            int commentCount = abstractArticle.getCommentCount() == null ? 0 : abstractArticle.getCommentCount();
            Double score = Math.max(likeCount - dislikeCount, 0) * likeWeight + favCount * favWeight + commentCount * commentWeight;
            abstractArticle.setScore(score);
        }
        abstractArticles.sort(new Comparator<RecommendArticleVO>() {
            @Override
            public int compare(RecommendArticleVO o1, RecommendArticleVO o2) {
                return o1.getScore().compareTo(o2.getScore());
            }
        });
        return abstractArticles;
    }


    public List<RecommendArticleVO> queryArticlesByCategory(Long categoryId) throws BusinessException {
        Asserts.isTrue(categoryId == null, SparrowError.GLOBAL_PARAMETER_IS_ILLEGAL);
        Asserts.isTrue(!this.categoryService.exist(categoryId), ArticleError.ARTICLE_CATEGORY_NOT_FOUND);
        double likeWeight = 0.5F;
        double favWeight = 0.2F;
        double commentWeight = 0.3F;
        List<Article> articles = this.articleDao.queryArticlesByCategory(categoryId);
        List<RecommendArticleVO> abstractArticles = this.articleAssembler.recommendAssembleList(articles);
        for (RecommendArticleVO abstractArticle : abstractArticles) {
            int likeCount = abstractArticle.getLikeCount() == null ? 0 : abstractArticle.getLikeCount();
            int favCount = abstractArticle.getFavCount() == null ? 0 : abstractArticle.getFavCount();
            int dislikeCount = abstractArticle.getDislikeCount() == null ? 0 : abstractArticle.getDislikeCount();
            int commentCount = abstractArticle.getCommentCount() == null ? 0 : abstractArticle.getCommentCount();

            Double score = Math.max(likeCount - dislikeCount, 0) * likeWeight + favCount * favWeight + commentCount * commentWeight;
            abstractArticle.setScore(score);
        }
        abstractArticles.sort(new Comparator<RecommendArticleVO>() {
            @Override
            public int compare(RecommendArticleVO o1, RecommendArticleVO o2) {
                return o1.getScore().compareTo(o2.getScore());
            }
        });
        return abstractArticles;
    }

    public void publish(PublishParam publishParam) throws BusinessException {
        LoginUser current = ThreadContext.getLoginToken();

        //published_{userId}==> published_1
        String publishedLimitKey = PlaceHolderParser.parse(RedisKey.PUBLISHED_LIMIT_KEY, PropertyAccessBuilder.buildPublishLimitKey(current.getUserId()));
        //用户ID 时间 次数 要不要续期？
        boolean passed = this.operateLimiter.renewalLimit(publishedLimitKey, 5, 1000 * 60 * 5L);

        Asserts.isTrue(!passed, ArticleError.ARTICLE_PUBLISHED_TIMES_EXCEED);


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
        //新增的逻辑
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

    public ArticleVO detail(Long detailId) throws BusinessException {
        Asserts.isTrue(detailId == null, ArticleError.ARTICLE_IS_NOT_FOUND);
        Article article = this.articleDao.getEntity(detailId);
        Asserts.isTrue(article == null, ArticleError.ARTICLE_IS_NOT_FOUND);
        ArticleDetail articleDetail = this.articleDetailDao.getEntity(detailId);
        Asserts.isTrue(articleDetail == null, ArticleError.ARTICLE_IS_NOT_FOUND);
        return this.articleAssembler.assembleArticle(article, articleDetail);
    }
}
