package com.sparrow.article.support;

import com.sparrow.protocol.ErrorSupport;
import com.sparrow.protocol.ModuleSupport;

public enum ArticleError implements ErrorSupport {
    ARTICLE_TITLE_IS_NULL(false, Modules.ARTICLE, "01", "title can't be null"),
    ARTICLE_CONTENT_IS_NULL(false, Modules.ARTICLE, "02", "content can't be null"),
    ARTICLE_ABSTRACT_IS_NULL(false, Modules.ARTICLE, "03", "abstract can't be null"),
    ARTICLE_ABSTRACT_EXCEED_200(false, Modules.ARTICLE, "04", "length of abstract  can't exceed 200"),
    ARTICLE_CATEGORY_IS_NULL(false, Modules.ARTICLE, "05", "category can't be null"),
    ARTICLE_TAGS_IS_NULL(false, Modules.ARTICLE, "06", "tags can't be null"),

    ARTICLE_AUTHOR_ID_IS_NULL(false, Modules.ARTICLE, "07", "author id can't be null"),

    ARTICLE_PAGE_SIZE_EXCEED(false, Modules.ARTICLE, "08", "page size exceed 100"),

    ARTICLE_IS_NOT_FOUND(false, Modules.ARTICLE, "09", "article is not found"),

    ARTICLE_PUBLISHED_TIMES_EXCEED(false, Modules.ARTICLE, "10", "article publish exceed times"),

    ARTICLE_CATEGORY_NOT_FOUND(false, Modules.ARTICLE, "11", "article category not found");


    private boolean system;
    private ModuleSupport module;
    private String code;
    private String message;

    ArticleError(boolean system, ModuleSupport module, String code, String message) {
        this.system = system;
        this.message = message;
        this.module = module;
        this.code = (system ? 0 : 1) + module.code() + code;
    }

    @Override
    public boolean system() {
        return this.system;
    }

    @Override
    public ModuleSupport module() {
        return this.module;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
