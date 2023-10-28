package com.sparrow.interact.po;

import com.sparrow.protocol.FieldOrder;
import com.sparrow.protocol.dao.PO;

import javax.persistence.*;

@Table(name = "comment")
public class Comment extends PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    @FieldOrder(order = 1)
    private Long id;

    @FieldOrder(order = 2)
    @Column(name = "article_id", columnDefinition = "int(11) UNSIGNED DEFAULT 0 COMMENT '文章ID'", nullable = false)
    private Long articleId;

    @FieldOrder(order = 3)
    @Column(name = "content", columnDefinition = "varchar(256) DEFAULT 0 COMMENT '评论内容'", nullable = false)
    private String content;

    @FieldOrder(order = 4)
    @Column(name = "like_count", columnDefinition = "int(11) DEFAULT 0 COMMENT '喜欢数'", nullable = false)
    private Integer likeCount;

    @FieldOrder(order = 5)
    @Column(name = "comment_count", columnDefinition = "int(11) DEFAULT 0 COMMENT '评论数'", nullable = false)
    private Integer commentCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
}
