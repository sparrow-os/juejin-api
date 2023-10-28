package com.sparrow.cms.protocol.vo;

import com.sparrow.protocol.VO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("友情链接")
public class FriendLinkVO implements VO {
    @ApiModelProperty("友链ID")
    private Integer id;
    @ApiModelProperty("友链名称")
    private String name;
    @ApiModelProperty("友链图标")
    private String icon;
    @ApiModelProperty("友链描述")
    private String desc;
    @ApiModelProperty("友链url")
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
