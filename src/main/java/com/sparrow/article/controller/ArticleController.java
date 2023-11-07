package com.sparrow.article.controller;

import com.sparrow.article.protocol.param.PublishParam;
import com.sparrow.article.protocol.query.UserArticleQuery;
import com.sparrow.article.protocol.vo.AbstractArticleVO;
import com.sparrow.article.protocol.vo.ArticleVO;
import com.sparrow.article.service.ArticleService;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.LoginUser;
import com.sparrow.protocol.ThreadContext;
import com.sparrow.protocol.pager.PagerResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("article")
@Api(value = "文章系统", tags = "文章系统")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

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
    @ApiOperation("我的文章")
    public PagerResult<AbstractArticleVO> userArticleList(UserArticleQuery userArticleQuery) throws BusinessException {
        //filter
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(1L);
        loginUser.setUserName("harry");
        loginUser.setNickName("harry");
        ThreadContext.bindLoginToken(loginUser);
        return this.articleService.userArticleList(userArticleQuery);
    }

    @GetMapping("published")
    @ApiOperation("我的文章-已发布")
    public List<AbstractArticleVO> published() {
        List<AbstractArticleVO> abstractArticles = new ArrayList<>();
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
        return abstractArticles;
    }

    @GetMapping("auditing")
    @ApiOperation("我的文章-审核中")
    public List<AbstractArticleVO> auditing() {
        List<AbstractArticleVO> abstractArticles = new ArrayList<>();
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
        return abstractArticles;
    }

    @GetMapping("rejected")
    @ApiOperation("我的文章-未通过")
    public List<AbstractArticleVO> rejected() {
        List<AbstractArticleVO> abstractArticles = new ArrayList<>();
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
        return abstractArticles;
    }


    @ApiOperation("详情")
    @GetMapping("details")
    public ArticleVO detail(Long articleId) {
        ArticleVO article = new ArticleVO();
        article.setContent("内容");
        article.setTopic("话题");
        article.setFavCount(10);
        article.setColumnId(1L);
        article.setColumnName("JAVA");
        article.setId(articleId);
        article.setTitle("一道简单的题目区分函数对象实例对象");
        article.setAbstracts("文章摘要");
        article.setCreateUserName("作者");
        article.setCreateUserId(0L);
        article.setLikeCount(0);
        article.setDislikeCount(0);
        article.setTags("JAVA");
        article.setCoverImage("");
        article.setViewCount(0);
        article.setCreateTime(0L);
        return article;
    }
}
