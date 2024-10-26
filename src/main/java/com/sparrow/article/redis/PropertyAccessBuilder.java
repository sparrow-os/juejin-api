package com.sparrow.article.redis;

import com.sparrow.support.PropertyAccessor;

public class PropertyAccessBuilder {
    public static class ArticlePropertyAccess implements PropertyAccessor {
        public ArticlePropertyAccess(Builder builder) {
            this.userId = builder.userId;
            this.threadId = builder.threadId;
        }

        private Long userId;

        private Long threadId;

        @Override
        public Object getProperty(String property) {
            if (property.equals("userId")) {
                return userId;
            }
            if (property.equals("threadId")) {
                return threadId;
            }
            return "";
        }

        public static class Builder {
            private Long userId;

            private Long threadId;

            public Builder userId(Long userId) {
                this.userId = userId;
                return this;
            }

            public Builder threadId(Long threadId) {
                this.threadId = threadId;
                return this;
            }

            public PropertyAccessor build() {
                return new ArticlePropertyAccess(this);
            }
        }
    }


    public static PropertyAccessor buildPublishLimitKey(Long userId) {
        return new ArticlePropertyAccess.Builder().userId(userId).build();
    }

    public static PropertyAccessor buildThreadLike(Long userId, Long threadId) {
        return new ArticlePropertyAccess.Builder().userId(userId).threadId(threadId).build();
    }
}
