package com.sparrow.article.po;

import com.sparrow.protocol.dao.PO;

import javax.persistence.*;

@Table(name = "article_detail")
public class ArticleDetail extends PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "content",
            columnDefinition = "text COMMENT '内容'")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
