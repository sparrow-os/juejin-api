package com.sparrow.article.support;

import com.sparrow.protocol.ErrorSupport;
import com.sparrow.protocol.ModuleSupport;

public enum ArticleError implements ErrorSupport {
    ARTICLE_TITLE_IS_NULL(false,Modules.ARTICLE,"01","title can't be null"),
    ARTICLE_CONTENT_IS_NULL(false,Modules.ARTICLE,"02","content can't be null"),
    ARTICLE_ABSTRACT_IS_NULL(false,Modules.ARTICLE,"03","abstract can't be null");




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