package com.sparrow.tag.protocol.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("标签")
public class SimpleTagVO {
    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("标签名")
    private String tagName;

    public Long getId() {
        return id;
    }

    public void setTagId(Long tagId) {
        this.id = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
