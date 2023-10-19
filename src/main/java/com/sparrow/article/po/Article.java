package com.sparrow.article.po;

import com.sparrow.protocol.dao.PO;

import javax.persistence.*;

@Table(name = "article")
public class Article extends PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    private Long id;

    @Column(name = "category_id",
            columnDefinition = "int(11)  UNSIGNED DEFAULT 0 COMMENT '分类ID'",
            nullable = false)
    private Long categoryId;

    @Column(name = "column_id",
            columnDefinition = "int(11)  UNSIGNED DEFAULT 0 COMMENT '专栏ID'",
            nullable = false)
    private Long columnId;

    @Column(name = "title",
            columnDefinition = "varchar(256)  DEFAULT '' COMMENT '标题'",
            nullable = false)
    private String title;

    @Column(name = "abstracts",
            columnDefinition = "varchar(128)  DEFAULT '' COMMENT '摘要'",
            nullable = false)
    private String abstracts;

    @Column(name = "cover_image",
            columnDefinition = "varchar(128)  DEFAULT '' COMMENT '封面图'",
            nullable = false)
    private String coverImage;

    @Column(name = "tags",
            columnDefinition = "varchar(128)  DEFAULT '' COMMENT '标签'",
            nullable = false)
    private String tags;

    @Column(name = "view_count",
            columnDefinition = "int(11)  DEFAULT 0 COMMENT 'PV'",
            nullable = false, updatable = false)
    private Integer viewCount;

    @Column(name = "like_count",
            columnDefinition = "int(11)  DEFAULT 0 COMMENT '点赞数'",
            nullable = false, updatable = false)
    private Integer likeCount;

    @Column(name = "dislike_count",
            columnDefinition = "int(11)  DEFAULT 0 COMMENT '踩数'",
            nullable = false, updatable = false)
    private Integer dislikeCount;

    @Column(name = "audit_status",
            columnDefinition = "tinyint(1)  DEFAULT 0 COMMENT '审核状态'",
            nullable = false, updatable = false)
    private Integer auditStatus;

    @Column(name = "status",
            columnDefinition = "tinyint(1)  DEFAULT 0 COMMENT '状态'",
            nullable = false, updatable = false)
    private Integer status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(Integer dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
