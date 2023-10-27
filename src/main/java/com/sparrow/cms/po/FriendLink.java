package com.sparrow.cms.po;

import com.sparrow.protocol.FieldOrder;

import javax.persistence.*;

@Table(name = "friend_link")
public class FriendLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED AUTO_INCREMENT")
    @FieldOrder(order = 1)
    private Long id;

    @FieldOrder(order = 2)
    @Column(name = "name", columnDefinition = "varchar(32)  DEFAULT '' COMMENT '友链名称'", nullable = false)
    private String name;

    @FieldOrder(order = 3)
    @Column(name = "logo", columnDefinition = "varchar(128)  DEFAULT '' COMMENT 'logo'", nullable = false)
    private String logo;

    @FieldOrder(order = 4)
    @Column(name = "url", columnDefinition = "varchar(128)  DEFAULT '' COMMENT 'URL'", nullable = false)
    private String url;

    @FieldOrder(order = 5)
    @Column(name = "status", columnDefinition = "tinyint(1)  DEFAULT 0 COMMENT '状态'", nullable = false)
    private Integer status;
}
