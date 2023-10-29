/*
 Navicat Premium Data Transfer

 Source Server         : sparrow
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : sparrow

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 28/10/2023 22:52:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '相册名称',
  `code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '相册编码',
  `description` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '相册说明描述',
  `sort` int(0) NOT NULL DEFAULT 0 COMMENT '排序号',
  `create_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
  `gmt_create` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `modified_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
  `gmt_modified` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `create_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `modified_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'album' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of album
-- ----------------------------

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `category_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '分类ID',
  `column_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '专栏ID',
  `title` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '标题',
  `abstracts` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '摘要',
  `cover_image` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '封面图',
  `tags` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '标签',
  `view_count` int(0) NOT NULL DEFAULT 0 COMMENT 'PV',
  `like_count` int(0) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `dislike_count` int(0) NOT NULL DEFAULT 0 COMMENT '踩数',
  `audit_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '审核状态',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态',
  `create_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
  `gmt_create` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `modified_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
  `gmt_modified` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `create_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `modified_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'article' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for article_detail
-- ----------------------------
DROP TABLE IF EXISTS `article_detail`;
CREATE TABLE `article_detail`  (
  `id` int(0) UNSIGNED NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容',
  `create_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
  `gmt_create` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `modified_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
  `gmt_modified` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `create_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `modified_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'article_detail' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_detail
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '编码',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '名称',
  `parent_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父类别',
  `icon` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'icon',
  `depth` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '深度',
  `status` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '状态',
  `create_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
  `gmt_create` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `modified_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
  `gmt_modified` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `create_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `modified_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'category' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `article_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '文章ID',
  `content` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '评论内容',
  `like_count` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '喜欢数',
  `comment_count` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '评论数',
  `create_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
  `gmt_create` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `modified_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
  `gmt_modified` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `modified_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
  `create_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'comment' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for friend_link
-- ----------------------------
DROP TABLE IF EXISTS `friend_link`;
CREATE TABLE `friend_link`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '友链名称',
  `logo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'logo',
  `url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'URL',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态',
  `create_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
  `gmt_create` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `modified_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
  `gmt_modified` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `modified_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
  `create_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'friend_link' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of friend_link
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '菜单名称',
  `icon` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'icon',
  `url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'url',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态',
  `sort` int(0) NOT NULL DEFAULT 0 COMMENT '排序',
  `create_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
  `gmt_create` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `modified_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
  `gmt_modified` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `modified_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
  `create_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'menu' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `album_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '相册ID',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '相册名称',
  `url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '图片url',
  `description` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '图片说明描述',
  `link_url` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '链接地址',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态 0:无效，1:有效',
  `create_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
  `gmt_create` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `modified_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
  `gmt_modified` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `create_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `modified_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'picture' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of picture
-- ----------------------------

-- ----------------------------
-- Table structure for reply_comment
-- ----------------------------
DROP TABLE IF EXISTS `reply_comment`;
CREATE TABLE `reply_comment`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `article_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '文章ID',
  `root_reply_comment_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '根回复ID',
  `content` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '评论内容',
  `like_count` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '喜欢数',
  `reply_comment_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '回复评论id',
  `reply_to_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '回复用户ID',
  `reply_to_user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '回复用户名',
  `create_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
  `gmt_create` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `modified_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
  `gmt_modified` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `modified_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
  `create_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'reply_comment' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `tag_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '标签名',
  `front_color` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '前景色',
  `background_color` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '背景色',
  `weight` float(10, 2) NOT NULL DEFAULT 0.00 COMMENT '权重',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态',
  `create_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '创建人ID',
  `gmt_create` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `modified_user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '更新人ID',
  `gmt_modified` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  `create_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人',
  `modified_user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'tag' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `nick_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `email` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'E-MAIL',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '密码',
  `gender` tinyint(0) NOT NULL DEFAULT 0 COMMENT '性别',
  `avatar` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '头象',
  `nationality` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '国籍',
  `personal_signature` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '签名',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '手机号码',
  `last_login_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '最近登录时间',
  `activate` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否激活',
  `activate_time` bigint(0) NOT NULL DEFAULT 0 COMMENT '激活时间',
  `channel` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '渠道来源',
  `device` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '设备',
  `device_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '设备id',
  `device_model` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '设备模型',
  `ip` bigint(0) NOT NULL DEFAULT 0 COMMENT 'ip',
  `status` tinyint(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT 'STATUS',
  `gmt_create` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `gmt_modified` bigint(0) NOT NULL DEFAULT 0 COMMENT '更新时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'user' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_behavior
-- ----------------------------
DROP TABLE IF EXISTS `user_behavior`;
CREATE TABLE `user_behavior`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户ID',
  `event_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '事件类型',
  `business_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '业务类型',
  `business_id` int(0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '业务ID',
  `ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'IP',
  `device` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '设备',
  `device_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '设备ID',
  `device_model` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '设备型号',
  `longitude` double(10, 2) NOT NULL DEFAULT 0.00 COMMENT '经度',
  `latitude` double(10, 2) NOT NULL DEFAULT 0.00 COMMENT '纬度',
  `imei` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT 'IMEI',
  `gmt_create` bigint(0) NOT NULL DEFAULT 0 COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'user_behavior' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_behavior
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
