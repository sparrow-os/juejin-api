package com.sparrow.tag.po;

import com.sparrow.protocol.dao.PO;

import javax.persistence.*;

@Table(name = "tag")
public class Tag extends PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED")
    private Long id;

    @Column(name = "tag_name",
            columnDefinition = "varchar(16)  DEFAULT '' COMMENT '标签名'",
            nullable = false)
    private String tagName;

    @Column(name = "front_color",
            columnDefinition = "varchar(8)  DEFAULT '' COMMENT '前景色'",
            nullable = false)
    private String frontColor;
    @Column(name = "background_color",
            columnDefinition = "varchar(8)  DEFAULT '' COMMENT '背景色'",
            nullable = false)
    private String background;

    @Column(name = "weight",
            columnDefinition = "float(10,2)  DEFAULT 0 COMMENT '权重'",
            nullable = false)
    private Float weight;

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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getFrontColor() {
        return frontColor;
    }

    public void setFrontColor(String frontColor) {
        this.frontColor = frontColor;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
