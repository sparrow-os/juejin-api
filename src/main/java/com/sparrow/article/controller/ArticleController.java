package com.sparrow.article.controller;

import com.sparrow.article.protocol.param.PublishParam;
import com.sparrow.article.protocol.vo.AbstractArticleVO;
import com.sparrow.article.protocol.vo.ColumnVO;
import com.sparrow.protocol.Result;
import com.sparrow.article.protocol.vo.ArticleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("article")
@Api(value = "文章系统", tags = "文章系统")
public class ArticleController {
    @PostMapping("publish")
    @ApiOperation("发布")
    public Result<Boolean> publish(@RequestBody PublishParam publishParam) {
        return new Result<>(true);
    }


    @PostMapping("draft")
    @ApiOperation("保存草稿")
    public Result<Boolean> draft(@RequestBody String content) {
        return new Result<>(true);
    }

    @GetMapping("my")
    @ApiOperation("我的文章")
    public List<AbstractArticleVO> my() {
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
