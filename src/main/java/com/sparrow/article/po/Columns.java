package com.sparrow.article.po;

import com.sparrow.protocol.dao.PO;

import javax.persistence.*;


@Table(name = "columns")
public class Columns extends PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED")
    private Long id;

    @Column(name = "name",
            columnDefinition = "varchar(32)  DEFAULT '' COMMENT '名称'",
            nullable = false)
    private String name;

    @Column(name = "sort",
            columnDefinition = "int(10) UNSIGNED  DEFAULT 0 COMMENT '排序'",
            nullable = false)
    private Integer sort;

    @Column(name = "desc",
            columnDefinition = "varchar(128)  DEFAULT '' COMMENT '简介'",
            nullable = false)
    private String desc;

    @Column(name = "cover",
            columnDefinition = "varchar(128)  DEFAULT '' COMMENT '封面图url'",
            nullable = false)
    private String cover;

    @Column(name = "status",
            columnDefinition = "tinyint(2)  DEFAULT 0 COMMENT '状态'",
            nullable = false)
    private Integer status;

    @Column(name = "audit_status",
            columnDefinition = "tinyint(2)  DEFAULT 0 COMMENT '审核状态'",
            nullable = false)
    private Integer auditStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }
}
