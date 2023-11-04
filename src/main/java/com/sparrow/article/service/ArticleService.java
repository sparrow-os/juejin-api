package com.sparrow.article.service;

import com.sparrow.article.assembler.ArticleAssembler;
import com.sparrow.article.dao.ArticleDao;
import com.sparrow.article.po.Article;
import com.sparrow.article.protocol.param.PublishParam;
import com.sparrow.article.support.ArticleError;
import com.sparrow.exception.Asserts;
import com.sparrow.protocol.BusinessException;
import com.sparrow.protocol.constant.SparrowError;
import com.sparrow.protocol.Result;
import com.sparrow.utility.StringUtility;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

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
}
