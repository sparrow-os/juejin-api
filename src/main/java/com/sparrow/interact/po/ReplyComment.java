package com.sparrow.interact.po;

import com.sparrow.protocol.FieldOrder;
import com.sparrow.protocol.dao.PO;

import javax.persistence.*;

@Table(name = "reply_comment")
public class ReplyComment extends PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    @FieldOrder(order = 1)
    private Long id;

    @FieldOrder(order = 2)
    @Column(name = "article_id", columnDefinition = "int(11) UNSIGNED DEFAULT 0 COMMENT '文章ID'", nullable = false)
    private Long articleId;

    @FieldOrder(order = 3)
    @Column(name = "root_reply_comment_id", columnDefinition = "int(11) UNSIGNED DEFAULT 0 COMMENT '根回复ID'", nullable = false)
    private Long rootReplyCommentId;

    @FieldOrder(order = 3)
    @Column(name = "content", columnDefinition = "varchar(256) DEFAULT 0 COMMENT '评论内容'", nullable = false)
    private Long content;

    @FieldOrder(order = 4)
    @Column(name = "like_count", columnDefinition = "int(11) DEFAULT 0 COMMENT '喜欢数'", nullable = false)
    private Integer likeCount;

    @FieldOrder(order = 3)
    @Column(name = "reply_comment_id", columnDefinition = "int(11) UNSIGNED DEFAULT 0 COMMENT '回复评论id'", nullable = false)
    private Long replyCommentId;

    @FieldOrder(order = 3)
    @Column(name = "reply_to_user_id", columnDefinition = "int(11) UNSIGNED DEFAULT 0 COMMENT '回复用户ID'", nullable = false)
    private Long replyToUserId;
    @FieldOrder(order = 3)
    @Column(name = "reply_to_user_name", columnDefinition = "varchar(32) DEFAULT '' COMMENT '回复用户名'", nullable = false)
    private String replyToUserName;


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

    public Long getRootReplyCommentId() {
        return rootReplyCommentId;
    }

    public void setRootReplyCommentId(Long rootReplyCommentId) {
        this.rootReplyCommentId = rootReplyCommentId;
    }

    public Long getContent() {
        return content;
    }

    public void setContent(Long content) {
        this.content = content;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Long getReplyCommentId() {
        return replyCommentId;
    }

    public void setReplyCommentId(Long replyCommentId) {
        this.replyCommentId = replyCommentId;
    }

    public Long getReplyToUserId() {
        return replyToUserId;
    }

    public void setReplyToUserId(Long replyToUserId) {
        this.replyToUserId = replyToUserId;
    }

    public String getReplyToUserName() {
        return replyToUserName;
    }

    public void setReplyToUserName(String replyToUserName) {
        this.replyToUserName = replyToUserName;
    }
}
