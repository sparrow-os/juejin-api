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
            columnDefinition = "varchar(256)  DEFAULT '' COMMENT '标题'",
            nullable = false)
    private String content;
}
