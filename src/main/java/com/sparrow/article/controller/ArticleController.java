package com.sparrow.article.controller;

import com.sparrow.article.protocol.param.PublishParam;
import com.sparrow.article.protocol.query.MyArticleQuery;
import com.sparrow.article.protocol.query.UserArticleQuery;
import com.sparrow.article.protocol.vo.AbstractArticleVO;
import com.sparrow.article.protocol.vo.ArticleVO;
import com.sparrow.article.service.ArticleService;
import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.constant.SparrowError;
import com.sparrow.protocol.pager.PagerResult;
import com.sparrow.spring.starter.SpringContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("article")
@Api(value = "文章系统", tags = "文章系统")
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("publish")
    @ApiOperation("发布")
    public Boolean publish(@RequestBody PublishParam publishParam) throws BusinessException {
        this.articleService.publish(publishParam);
        return Boolean.TRUE;
    }


    @PostMapping(value = "draft")
    @ApiOperation("保存草稿")
    public Boolean draft(@RequestBody String content) {
        return true;
    }

    @GetMapping("user")
    @ApiOperation("个人中心-文章列表")
    public PagerResult<AbstractArticleVO> userArticleList(UserArticleQuery userArticleQuery) throws BusinessException {
        return this.articleService.userArticleList(userArticleQuery);
    }

    @GetMapping("all")
    @ApiOperation("我的文章-全部")
    public PagerResult<AbstractArticleVO> all(MyArticleQuery myArticleQuery) throws BusinessException {
        return this.articleService.myArticleList(myArticleQuery, MyArticleQuery.ALL);
    }

    @GetMapping("published")
    @ApiOperation("我的文章-已发布")
    public PagerResult<AbstractArticleVO> published(MyArticleQuery myArticleQuery) throws BusinessException {
        return this.articleService.myArticleList(myArticleQuery, MyArticleQuery.AUDITED);
    }

    @GetMapping("auditing")
    @ApiOperation("我的文章-审核中")
    public PagerResult<AbstractArticleVO> auditing(MyArticleQuery myArticleQuery) throws BusinessException {
        return this.articleService.myArticleList(myArticleQuery, MyArticleQuery.AUDITING);
    }

    @GetMapping("rejected")
    @ApiOperation("我的文章-未通过")
    public PagerResult<AbstractArticleVO> rejected(MyArticleQuery myArticleQuery) throws BusinessException {
        return this.articleService.myArticleList(myArticleQuery, MyArticleQuery.REJECTED);
    }


    @ApiOperation("详情")
    @GetMapping("details")
    public ArticleVO detail(Long articleId) throws BusinessException {
        return this.articleService.detail(articleId);
    }
}
