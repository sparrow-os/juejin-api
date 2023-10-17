package com.sparrow.article.protocol.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("专栏")
public class ColumnVO {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("专栏名称")
    private String name;
    @ApiModelProperty("专栏描述")
    private String desc;
    @ApiModelProperty("icon")
    private String icon;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
