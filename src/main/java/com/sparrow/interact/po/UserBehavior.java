package com.sparrow.interact.po;

import com.sparrow.protocol.FieldOrder;

import javax.persistence.*;

@Table(name = "user_behavior")
public class UserBehavior {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED")
    @FieldOrder(order = 1)
    private Long id;

    @FieldOrder(order = 2)
    @Column(name = "user_id", columnDefinition = "int(11) UNSIGNED DEFAULT 0 COMMENT '用户ID'", nullable = false)
    private Long userId;
    @FieldOrder(order = 3)
    @Column(name = "event_type", columnDefinition = "varchar(32) DEFAULT '' COMMENT '事件类型'", nullable = false)
    private String eventType;

    @FieldOrder(order = 4)
    @Column(name = "business_type", columnDefinition = "varchar(32) DEFAULT '' COMMENT '业务类型'", nullable = false)
    private String businessType;

    @FieldOrder(order = 5)
    @Column(name = "business_id", columnDefinition = "int(11) UNSIGNED DEFAULT 0 COMMENT '业务ID'", nullable = false)
    private Long businessId;

    @FieldOrder(order = 6)
    @Column(name = "ip", columnDefinition = "varchar(32) DEFAULT '' COMMENT 'IP'", nullable = false)
    private String ip;

    @FieldOrder(order = 7)
    @Column(name = "device", columnDefinition = "varchar(32) DEFAULT '' COMMENT '设备'", nullable = false)
    private String device;

    @FieldOrder(order = 8)
    @Column(name = "device_id", columnDefinition = "varchar(64) DEFAULT '' COMMENT '设备ID'", nullable = false)
    private String deviceId;

    @FieldOrder(order = 9)
    @Column(name = "device_model", columnDefinition = "varchar(64) DEFAULT '' COMMENT '设备型号'", nullable = false)
    private String deviceModel;

    @FieldOrder(order = 10)
    @Column(name = "longitude", columnDefinition = "double(10,2) DEFAULT 0 COMMENT '经度'", nullable = false)
    private Double longitude;

    @FieldOrder(order = 11)
    @Column(name = "latitude", columnDefinition = "double(10,2) DEFAULT 0 COMMENT '纬度'", nullable = false)
    private Double latitude;

    @FieldOrder(order = 12)
    @Column(name = "imei", columnDefinition = "varchar(32) DEFAULT '' COMMENT 'IMEI'", nullable = false)
    private String imei;

    @FieldOrder(order = 13)
    @Column(name = "gmt_create", columnDefinition = "bigint(11) DEFAULT 0 COMMENT '创建时间'", nullable = false)
    private Long gmtCreate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
