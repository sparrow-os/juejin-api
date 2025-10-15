package com.sparrow.passport.po;

import com.sparrow.protocol.POJO;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "user")
public class User implements Cloneable, POJO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "int(11) UNSIGNED")
    private Long userId;


    @Column(name = "user_name", columnDefinition = " varchar(64) DEFAULT '' COMMENT '用户名'", nullable = false, updatable = false, unique = true)
    private String userName;

    @Column(name = "nick_name", columnDefinition = "varchar(64)  DEFAULT '' COMMENT '昵称'", nullable = false, updatable = true)
    private String nickName;


    @Column(name = "email", columnDefinition = "varchar(256) DEFAULT '' comment 'E-MAIL'", unique = true, updatable = false, nullable = false)
    private String email;

    @Column(name = "password", columnDefinition = "varchar(32) DEFAULT '' COMMENT '密码'", updatable = false, nullable = false)

    private String password;


    @Column(name = "gender", columnDefinition = "tinyint(2) DEFAULT 0 COMMENT '性别'", nullable = false)
    private Integer gender;


    @Column(name = "avatar", columnDefinition = "varchar(256) DEFAULT '' COMMENT '头象'", updatable = false, nullable = false)
    private String avatar;

    @Column(name = "nationality", columnDefinition = "varchar(32) DEFAULT '' COMMENT '国籍'", updatable = false, nullable = false)
    private String nationality;


    @Column(name = "personal_signature", columnDefinition = "varchar(256) DEFAULT '' COMMENT '签名'", nullable = false)
    private String personalSignature;


    @Column(name = "birthday", columnDefinition = "date COMMENT '生日'")
    private Date birthday;


    @Column(name = "mobile", columnDefinition = "varchar(11) DEFAULT '0' COMMENT '手机号码'", updatable = false, nullable = false)
    private String mobile;

    @Column(name = "last_login_time", columnDefinition = "bigint(11) DEFAULT 0 COMMENT '最近登录时间'", updatable = false, nullable = false)
    private Long lastLoginTime;

    @Column(name = "activate", columnDefinition = "tinyint(1) DEFAULT 0 COMMENT '是否激活'", nullable = false)
    private Boolean activate;

    @Column(name = "activate_time", columnDefinition = "bigint(11) DEFAULT 0 COMMENT '激活时间'", nullable = false, updatable = false)
    private Long activateTime;
    @Column(name = "channel", columnDefinition = "varchar(128) DEFAULT '' COMMENT '渠道来源'", updatable = false, nullable = false)
    private String channel;


    @Column(name = "device", columnDefinition = "varchar(16) DEFAULT '' COMMENT '设备'", updatable = false, nullable = false)
    private String device;

    @Column(name = "device_id", columnDefinition = "varchar(64) DEFAULT '' COMMENT '设备id'", updatable = false, nullable = false)
    private String deviceId;

    @Column(name = "device_model", columnDefinition = "varchar(32) DEFAULT '' COMMENT '设备模型'", updatable = false, nullable = false)
    private String deviceModel;

    @Column(name = "ip", columnDefinition = "bigint(10) DEFAULT 0 COMMENT 'ip'", updatable = false, nullable = false)
    private Long ip;

    @Column(name = "status",
            columnDefinition = "tinyint(3) UNSIGNED DEFAULT 0 COMMENT 'STATUS'",
            nullable = false)
    private Integer status;

    @Column(name = "gmt_create",
            columnDefinition = "bigint(11)  DEFAULT 0 COMMENT '创建时间'",
            nullable = false,
            updatable = false)
    private Long gmtCreate;
    @Column(
            name = "gmt_modified",
            columnDefinition = "bigint(11)  DEFAULT 0 COMMENT '更新时间'",
            nullable = false)
    private Long gmtModified;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPersonalSignature() {
        return personalSignature;
    }

    public void setPersonalSignature(String personalSignature) {
        this.personalSignature = personalSignature;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Boolean getActivate() {
        return activate;
    }

    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    public Long getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(Long activateTime) {
        this.activateTime = activateTime;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public Long getIp() {
        return ip;
    }

    public void setIp(Long ip) {
        this.ip = ip;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
