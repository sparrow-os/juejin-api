package com.sparrow.tag.po;

import com.sparrow.protocol.dao.PO;

import javax.persistence.*;

@Table(name = "category")
public class Category extends PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED")
    private Long id;

    @Column(name = "code",
            columnDefinition = "varchar(16)  DEFAULT '' COMMENT '编码'",
            nullable = false)
    private String code;

    @Column(name = "name",
            columnDefinition = "varchar(32)  DEFAULT '' COMMENT '名称'",
            nullable = false)
    private String name;

    @Column(name = "parent_id",
            columnDefinition = "int(11)  UNSIGNED DEFAULT 0 COMMENT '父类别'",
            nullable = false)
    private Long parentId;

    @Column(name = "icon",
            columnDefinition = "varchar(128)  DEFAULT '' COMMENT 'icon'",
            nullable = false)
    private String icon;

    @Column(name = "depth",
            columnDefinition = "tinyint(3)  UNSIGNED DEFAULT 0 COMMENT '深度'",
            nullable = false)
    private Integer depth;

    @Column(name = "status",
            columnDefinition = "tinyint(3)  UNSIGNED DEFAULT 0 COMMENT '状态'",
            nullable = false)
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
