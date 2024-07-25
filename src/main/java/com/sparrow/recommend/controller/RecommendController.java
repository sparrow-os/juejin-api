package com.sparrow.recommend.controller;

import com.sparrow.article.service.ArticleService;
import com.sparrow.protocol.BusinessException;
import com.sparrow.recommend.protocol.vo.RecommendArticleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "推荐系统", tags = "推荐系统")
public class RecommendController {

    @Inject
    private ArticleService articleService;

    @ApiOperation("推荐")
    @GetMapping("recommend")
    public List<RecommendArticleVO> recommend() throws BusinessException {
        return this.articleService.recommend();
    }

    @ApiOperation("分类页")
    @GetMapping("recommend/category/{categoryId}")
    public List<RecommendArticleVO> category(@PathVariable("categoryId") Long categoryId) throws BusinessException {
        return this.articleService.queryArticlesByCategory(categoryId);
    }

    @ApiOperation("详情页相关推荐")
    @GetMapping("recommend/detail/relation/{detailId}")
    public List<RecommendArticleVO> detailRelation(@PathVariable("detailId") Long detailId) {
        List<RecommendArticleVO> abstractArticles = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            RecommendArticleVO abstractArticle = new RecommendArticleVO();
            abstractArticle.setId((long) i);
            abstractArticle.setTitle("文章标题");
            abstractArticle.setAbstracts("文章摘要");
            abstractArticle.setCreateUserId(1L);
            abstractArticle.setCreateUserName("张三" + i);
            abstractArticle.setLikeCount(i);
            abstractArticle.setDislikeCount(i);
            abstractArticle.setTags("JAVA,.NET JS ASP.NET");
            abstractArticle.setCoverImage("http://r.sparrowzoo.net/" + i + ".jpg");
            abstractArticles.add(abstractArticle);
        }
        return abstractArticles;
    }

    @ApiOperation("详情页为你推荐")
    @GetMapping("recommend/detail-for-your/{detailId}")
    public List<RecommendArticleVO> detailForYour(@ApiParam("detailId") @PathVariable("detailId") Long detailId) {
        List<RecommendArticleVO> abstractArticles = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            RecommendArticleVO abstractArticle = new RecommendArticleVO();
            abstractArticle.setId((long) i);
            abstractArticle.setTitle("文章标题");
            abstractArticle.setAbstracts("文章摘要");
            abstractArticle.setCreateUserId(1L);
            abstractArticle.setCreateUserName("张三" + i);
            abstractArticle.setLikeCount(i);
            abstractArticle.setDislikeCount(i);
            abstractArticle.setTags("JAVA,.NET JS ASP.NET");
            abstractArticle.setCoverImage("http://r.sparrowzoo.net/" + i + ".jpg");
            abstractArticles.add(abstractArticle);
        }
        return abstractArticles;
    }

}
