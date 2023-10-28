package com.sparrow.cms.po;

import com.sparrow.protocol.FieldOrder;
import com.sparrow.protocol.dao.PO;

import javax.persistence.*;

@Table(name = "menu")
public class Menu extends PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    @FieldOrder(order = 1)
    private Long id;

    @FieldOrder(order = 2)
    @Column(name = "name", columnDefinition = "varchar(32)  DEFAULT '' COMMENT '菜单名称'", nullable = false)
    private String name;

    @FieldOrder(order = 3)
    @Column(name = "icon", columnDefinition = "varchar(128)  DEFAULT '' COMMENT 'icon'", nullable = false)
    private String icon;

    @FieldOrder(order = 4)
    @Column(name = "url", columnDefinition = "varchar(128)  DEFAULT '' COMMENT 'url'", nullable = false)
    private String url;

    @FieldOrder(order = 4)
    @Column(name = "status", columnDefinition = "tinyint(1)  DEFAULT 0 COMMENT '状态'", nullable = false)
    private Integer status;

    @FieldOrder(order = 4)
    @Column(name = "sort", columnDefinition = "int(11)  DEFAULT 0 COMMENT '排序'", nullable = false)
    private Integer sort;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
