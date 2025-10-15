package com.sparrow.cms.po;

import com.sparrow.protocol.dao.PO;

import javax.persistence.*;

@Table(name = "picture")
public class Picture extends PO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED")
    private Long id;

    @Column(name = "album_id", columnDefinition = "int(11) UNSIGNED DEFAULT 0 COMMENT '相册ID'", nullable = false)
    private Long albumId;

    @Column(name = "name", columnDefinition = "varchar(32)  DEFAULT '' COMMENT '相册名称'", nullable = false)
    private String name;

    @Column(name = "url", columnDefinition = "varchar(128)  DEFAULT '' COMMENT '图片url'", nullable = false)
    private String url;

    @Column(name = "description", columnDefinition = "varchar(128)  DEFAULT '' COMMENT '图片说明描述'", nullable = false)
    private String description;

    @Column(name = "link_url", columnDefinition = "varchar(128)  DEFAULT '' COMMENT '链接地址'", nullable = false)
    private String linkUrl;

    @Column(name = "status", columnDefinition = "tinyint(1)  DEFAULT 0 COMMENT '状态 0:无效，1:有效'", nullable = false)
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

}
