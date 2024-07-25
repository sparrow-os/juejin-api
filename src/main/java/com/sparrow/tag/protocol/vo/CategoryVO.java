package com.sparrow.tag.protocol.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("类别")
public class CategoryVO {
    public static CategoryVO root() {
        CategoryVO root = new CategoryVO();
        root.setId(0L);
        root.setParentId(-1L);
        root.setName("root");
        return root;
    }

    @ApiModelProperty("主键")
    private Long id;
    @ApiModelProperty("名称")
    private String name;
    @ApiModelProperty("父ID")
    private Long parentId;
    @ApiModelProperty("icon")
    private String icon;
    @ApiModelProperty("子类别")
    private List<CategoryVO> children;

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

    public List<CategoryVO> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryVO> children) {
        this.children = children;
    }
}
