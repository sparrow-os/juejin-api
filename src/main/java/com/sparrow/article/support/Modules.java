package com.sparrow.article.support;

import com.sparrow.protocol.ModuleSupport;

public class Modules {
    public static final ModuleSupport ARTICLE = new ModuleSupport() {
        @Override
        public String code() {
            return "01";
        }

        @Override
        public String name() {
            return "ARTICLE";
        }
    };
}
