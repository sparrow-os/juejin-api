package com.sparrow.article.assembler;

import com.sparrow.article.po.Article;
import com.sparrow.article.protocol.param.PublishParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ArticleAssembler {
    public Article assembleArticle(PublishParam publishParam) {
        Article article = new Article();
        BeanUtils.copyProperties(publishParam, article);
        //需要手动设置
        article.setCreateUserName("harry");//todo 通过用户上下文获取当前用户信息
        article.setCreateUserId(1L);
        article.setModifiedUserId(1L);
        article.setModifiedUserName("harry");
        article.setGmtCreate(1L);
        article.setGmtModified(2L);
        //todo 创建时间 创建人问题 后续 完善
        return article;
    }
}
