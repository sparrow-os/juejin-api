package com.sparrow.cms.protocol.vo;

import com.sparrow.protocol.VO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("菜单")
public class MenuVO implements VO {
    @ApiModelProperty("菜单ID")
    private Integer id;
    @ApiModelProperty("菜单名")
    private String name;
    @ApiModelProperty("菜单icon")
    private String icon;
    @ApiModelProperty("菜单描述")
    private String desc;

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
}
