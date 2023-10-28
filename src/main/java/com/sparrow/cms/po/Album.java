package com.sparrow.cms.po;

import com.sparrow.protocol.FieldOrder;
import com.sparrow.protocol.dao.PO;

import javax.persistence.*;

@Table(name = "album")
public class Album extends PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    @FieldOrder(order = 1)
    private Long id;

    @FieldOrder(order = 2)
    @Column(name = "name", columnDefinition = "varchar(32)  DEFAULT '' COMMENT '相册名称'", nullable = false)
    private String name;

    @FieldOrder(order = 3)
    @Column(name = "code", columnDefinition = "varchar(16) DEFAULT '' COMMENT '相册编码'", nullable = false)
    private String code;


    @FieldOrder(order = 4)
    @Column(name = "description", columnDefinition = "varchar(32)  DEFAULT '' COMMENT '相册说明描述'", nullable = false)
    private String description;


    @FieldOrder(order = 11)
    @Column(name = "sort", columnDefinition = "int(10) DEFAULT 0 COMMENT '排序号'", nullable = false)
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
