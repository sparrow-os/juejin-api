package com.sparrow.article.controller;

import com.sparrow.article.protocol.vo.ArticleVO;
import com.sparrow.article.service.ArticleService;
import com.sparrow.protocol.BusinessException;
import com.sparrow.spring.starter.ModelAndViewUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DetailController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("detail")
    public ModelAndView detail(Long threadId) throws BusinessException {
        ArticleVO detail = this.articleService.detail(threadId);
        return new ModelAndView("details", "article", detail);
    }
}
