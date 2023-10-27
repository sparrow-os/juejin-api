package com.sparrow.cms.protocol.vo;

import com.sparrow.protocol.VO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("图片")
public class PictureVO implements VO {
    @ApiModelProperty("图片ID")
    private Long id;
    @ApiModelProperty("图片名称")
    private String name;
    @ApiModelProperty("图片图标")
    private String icon;
    @ApiModelProperty("图片描述")
    private String desc;
    @ApiModelProperty("图片url")
    private String url;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
