package com.sparrow.tag.protocol.vo;

import io.swagger.annotations.ApiModelProperty;

public class TagVO extends SimpleTagVO {
    @ApiModelProperty("前景色")
    private String frontColor;
    @ApiModelProperty("背景色")
    private String background;
    @ApiModelProperty("权重")
    private Float weight;

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
}
