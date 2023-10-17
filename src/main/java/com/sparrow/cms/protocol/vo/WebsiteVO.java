package com.sparrow.cms.protocol.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("网站")
public class WebsiteVO {
    @ApiModelProperty(value = "标题", required = true)
    private String title;
    @ApiModelProperty(value = "关键词", required = true)
    private String keywords;
    @ApiModelProperty(value = "描述信息", required = true)
    private String description;
    @ApiModelProperty(value = "logo", required = true)
    private String logo;
    @ApiModelProperty("banner")
    private String banner;
    @ApiModelProperty(value = "视频banner")
    private String videoBanner;
    @ApiModelProperty(value = "ICP", required = true)
    private String icp;
    @ApiModelProperty(value = "联系方式")
    private String contact;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getVideoBanner() {
        return videoBanner;
    }

    public void setVideoBanner(String videoBanner) {
        this.videoBanner = videoBanner;
    }

    public String getIcp() {
        return icp;
    }

    public void setIcp(String icp) {
        this.icp = icp;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
