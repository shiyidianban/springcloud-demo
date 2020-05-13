/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-05-13 16:37:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `client_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户端名称',
  `client_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户端路径',
  `del_flag` int DEFAULT '0' COMMENT '逻辑删除标志',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(255) DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('1', 'spring-demo', '11', '0', '2020-04-30 17:12:25', '2020-04-30 17:12:27', null, null);
INSERT INTO `client` VALUES ('2', 'spring-demo2', '11', '0', '2020-04-30 17:12:25', '2020-04-30 17:12:27', null, null);
INSERT INTO `client` VALUES ('3', 'spring-demo2', '11', '0', '2020-04-30 17:12:25', '2020-04-30 17:12:27', null, null);
INSERT INTO `client` VALUES ('4', 'spring-demo2', '11', '0', '2020-04-30 17:12:25', '2020-05-06 15:48:50', null, null);
INSERT INTO `client` VALUES ('5', 'spring-demo2', '11', '0', '2020-04-30 17:12:25', '2020-05-06 15:48:50', null, null);
INSERT INTO `client` VALUES ('6', 'spring-demo2', '11', '0', '2020-05-06 15:47:43', '2020-05-06 15:47:43', null, null);
INSERT INTO `client` VALUES ('7', 'spring-demo2', '11', '0', '2020-05-06 15:47:44', '2020-05-06 15:47:44', null, null);
INSERT INTO `client` VALUES ('8', 'spring-demo2', '11', '0', '2020-05-06 15:53:00', '2020-05-06 15:53:00', null, null);
INSERT INTO `client` VALUES ('9', 'spring-demo2', '11', '0', '2020-05-06 15:53:00', '2020-05-06 15:53:00', null, null);
INSERT INTO `client` VALUES ('10', 'spring-demo2', '11', '0', '2020-05-06 15:53:01', '2020-05-06 15:53:01', null, null);
INSERT INTO `client` VALUES ('11', 'spring-demo2', '11', '0', '2020-05-06 15:53:01', '2020-05-06 15:53:01', null, null);
INSERT INTO `client` VALUES ('12', 'spring-demo2', '11', '0', '2020-05-06 15:53:03', '2020-05-06 15:53:03', null, null);
INSERT INTO `client` VALUES ('13', 'spring-demo2', '11', '0', '2020-05-06 15:53:03', '2020-05-06 15:53:03', null, null);
INSERT INTO `client` VALUES ('14', 'spring-demo3', '11', '0', '2020-05-06 17:51:51', '2020-05-06 17:51:51', 'admin', 'admin');
INSERT INTO `client` VALUES ('15', 'spring-demo3', '11', '0', '2020-05-06 17:52:37', '2020-05-06 17:52:44', 'admin', 'admin');
INSERT INTO `client` VALUES ('16', 'spring-demo3', '11', '0', '2020-05-06 17:53:57', '2020-05-06 17:53:57', 'admin', 'admin');
INSERT INTO `client` VALUES ('17', 'spring-demo3', '11', '0', '2020-05-06 17:54:14', '2020-05-06 17:54:16', 'admin', 'admin');
INSERT INTO `client` VALUES ('18', 'spring-demo3', '11', '0', '2020-05-07 09:10:24', '2020-05-07 09:10:24', 'admin', 'admin');
INSERT INTO `client` VALUES ('19', 'spring-demo3', '11', '0', '2020-05-07 09:11:14', '2020-05-07 09:11:14', 'admin', 'admin');
INSERT INTO `client` VALUES ('20', 'spring-demo3', '11', '0', '2020-05-07 09:12:11', '2020-05-07 09:12:11', 'admin', 'admin');
INSERT INTO `client` VALUES ('21', 'spring-demo3', '11', '0', '2020-05-07 09:31:55', '2020-05-07 09:31:55', 'admin', 'admin');
INSERT INTO `client` VALUES ('22', 'spring-demo3', '11', '0', '2020-05-07 09:57:59', '2020-05-07 09:57:59', 'admin', 'admin');
INSERT INTO `client` VALUES ('23', 'spring-demo3', '11', '0', '2020-05-07 10:40:23', '2020-05-07 10:40:23', 'admin', 'admin');
INSERT INTO `client` VALUES ('24', 'spring-demo3', '11', '0', '2020-05-07 10:40:28', '2020-05-07 10:40:28', '1212', '1212');
INSERT INTO `client` VALUES ('25', 'spring-demo3', '11', '0', '2020-05-07 11:04:07', '2020-05-07 11:04:07', '1212', '1212');
INSERT INTO `client` VALUES ('26', 'spring-demo3', '11', '0', '2020-05-08 14:34:37', '2020-05-08 14:34:38', '1212', '1212');
INSERT INTO `client` VALUES ('27', 'spring-demo3', '11', '0', '2020-05-08 15:27:39', '2020-05-08 15:27:39', '1212', '1212');

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(48) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '终端id',
  `resource_ids` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源id',
  `client_secret` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '终端密码',
  `scope` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '终端域',
  `authorized_grant_types` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '认证授权类型',
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '网络重定向uri',
  `authorities` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '认证人',
  `access_token_validity` int DEFAULT NULL COMMENT 'AccessToken有效期',
  `refresh_token_validity` int DEFAULT NULL COMMENT 'RefreshToken有效期',
  `additional_information` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '附加数据',
  `autoapprove` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`client_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('app', null, 'app', 'app', 'password,refresh_token', null, null, null, null, null, null);
INSERT INTO `oauth_client_details` VALUES ('webApp', null, '$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', 'app', 'authorization_code,password,refresh_token,client_credentials', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `client_id` int DEFAULT NULL COMMENT '客户端Id',
  `orderNum` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_by` varchar(255) DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `del_flag` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '1', 'spring-demo3', '2020-05-11 10:17:10', '2020-05-11 10:17:10', '123', '23', '0');
INSERT INTO `order` VALUES ('2', '1', 'spring-demo3', '2020-05-11 10:17:09', '2020-05-11 10:17:09', '23', '123', '1');
INSERT INTO `order` VALUES ('3', '1', 'spring-demo3', '2020-05-11 10:17:06', '2020-05-11 10:17:06', '123', '123', '1');
INSERT INTO `order` VALUES ('4', '1', 'spring-demo3', '2020-05-08 14:42:22', '2020-05-08 14:42:22', '1212', '1212', '0');
INSERT INTO `order` VALUES ('5', '1', 'spring-demo', '2020-05-09 14:35:21', '2020-05-09 14:35:21', '1212', '1212', '0');
INSERT INTO `order` VALUES ('6', '1', 'spring-demo', '2020-05-09 14:52:21', '2020-05-09 14:52:21', '1212', '1212', '0');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单编码',
  `p_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单父编码',
  `p_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父菜单ID',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '请求地址',
  `is_menu` int DEFAULT NULL COMMENT '是否是菜单(1.菜单。2.按钮)',
  `level` int DEFAULT NULL COMMENT '菜单层级',
  `sort` int DEFAULT NULL COMMENT '菜单排序',
  `status` int DEFAULT NULL COMMENT '菜单状态（是否激活）',
  `del_flag` int DEFAULT NULL COMMENT '是否删除',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '菜单图标',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后更新者',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `FK_CODE` (`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `role_id` int NOT NULL COMMENT '角色id',
  `menu_id` int NOT NULL COMMENT '菜单id',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`role_id`,`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色值',
  `tips` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后更新人',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最后更新时间',
  `status` int DEFAULT NULL COMMENT '状态（是否可用）',
  `del_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `unique_role_name` (`name`) USING BTREE,
  UNIQUE KEY `unique_role_value` (`value`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', 'admin', null, 'admin', 'admin', '2020-05-07 15:05:26', '2017-06-26 12:46:09', '1', '0');
INSERT INTO `sys_role` VALUES ('2', '超级管理员', 'super', null, 'admin', 'admin', '2020-05-07 15:05:26', '2019-06-05 10:55:23', '1', '0');
INSERT INTO `sys_role` VALUES ('3', '用户', 'user', null, 'admin', 'admin', '2020-05-07 15:05:26', '2017-07-21 09:41:28', '1', '0');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(45) NOT NULL COMMENT '用户名',
  `password` varchar(96) NOT NULL COMMENT '密码',
  `truename` varchar(45) DEFAULT NULL COMMENT '真实名称',
  `birthday` timestamp NULL DEFAULT NULL COMMENT '生日',
  `sex` int DEFAULT NULL COMMENT '性别（0男1女）',
  `email` varchar(45) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(45) DEFAULT NULL COMMENT '手机号',
  `status` int DEFAULT NULL COMMENT '账号状态（是否激活）',
  `del_flag` int DEFAULT NULL COMMENT '是否删除',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_user_username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'super', '$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', '超级管理员', '2019-06-13 18:44:36', '1', null, null, '1', '0', '2019-06-13 18:44:36', '2019-06-13 18:44:36');
INSERT INTO `sys_user` VALUES ('2', 'admin', '$2a$10$cKRbR9IJktfmKmf/wShyo.5.J8IxO/7YVn8twuWFtvPgruAF8gtKq', '管理员', '2019-06-13 18:44:36', '1', null, null, '1', '0', '2019-06-13 18:44:36', '2019-06-13 18:44:36');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `role_id` int DEFAULT NULL COMMENT '角色id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', null);
INSERT INTO `sys_user_role` VALUES ('2', '1', '2', null);

-- ----------------------------
-- Table structure for zipkin_annotations
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_annotations`;
CREATE TABLE `zipkin_annotations` (
  `trace_id_high` bigint NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint NOT NULL COMMENT 'coincides with zipkin_spans.trace_id',
  `span_id` bigint NOT NULL COMMENT 'coincides with zipkin_spans.id',
  `a_key` varchar(255) NOT NULL COMMENT 'BinaryAnnotation.key or Annotation.value if type == -1',
  `a_value` blob COMMENT 'BinaryAnnotation.value(), which must be smaller than 64KB',
  `a_type` int NOT NULL COMMENT 'BinaryAnnotation.type() or -1 if Annotation',
  `a_timestamp` bigint DEFAULT NULL COMMENT 'Used to implement TTL; Annotation.timestamp or zipkin_spans.timestamp',
  `endpoint_ipv4` int DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_ipv6` binary(16) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null, or no IPv6 address',
  `endpoint_port` smallint DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  `endpoint_service_name` varchar(255) DEFAULT NULL COMMENT 'Null when Binary/Annotation.endpoint is null',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`span_id`,`a_key`,`a_timestamp`) COMMENT 'Ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`span_id`) COMMENT 'for joining with zipkin_spans',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) COMMENT 'for getTraces/ByIds',
  KEY `endpoint_service_name` (`endpoint_service_name`) COMMENT 'for getTraces and getServiceNames',
  KEY `a_type` (`a_type`) COMMENT 'for getTraces',
  KEY `a_key` (`a_key`) COMMENT 'for getTraces'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_annotations
-- ----------------------------
INSERT INTO `zipkin_annotations` VALUES ('0', '-3702201745749729503', '-3702201745749729503', 'sr', null, '-1', '1589003948749358', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3702201745749729503', '-3702201745749729503', 'ss', null, '-1', '1589003949051075', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3702201745749729503', '-3702201745749729503', 'ca', 0x01, '0', '1589003948749358', null, 0x00000000000000000000000000000001, null, '');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3702201745749729503', '-3702201745749729503', 'http.method', 0x474554, '6', '1589003948749358', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3702201745749729503', '-3702201745749729503', 'http.path', 0x2F6F726465722F70616765, '6', '1589003948749358', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3702201745749729503', '-3702201745749729503', 'mvc.controller.class', 0x4F72646572436F6E74726F6C6C6572, '6', '1589003948749358', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3702201745749729503', '-3702201745749729503', 'mvc.controller.method', 0x6765744F7264657250616765, '6', '1589003948749358', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3160492054728698490', '1894547638422073357', 'cs', null, '-1', '1589003992277900', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3160492054728698490', '1894547638422073357', 'cr', null, '-1', '1589003992330653', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3160492054728698490', '1894547638422073357', 'http.method', 0x474554, '6', '1589003992277900', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3160492054728698490', '1894547638422073357', 'http.path', 0x2F636C69656E742F31, '6', '1589003992277900', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3160492054728698490', '-7261450959721719555', 'lc', '', '6', '1589003992179038', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3160492054728698490', '-3160492054728698490', 'sr', null, '-1', '1589003992003107', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3160492054728698490', '-3160492054728698490', 'ss', null, '-1', '1589003992349773', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3160492054728698490', '-3160492054728698490', 'ca', 0x01, '0', '1589003992003107', null, 0x00000000000000000000000000000001, null, '');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3160492054728698490', '-3160492054728698490', 'http.method', 0x474554, '6', '1589003992003107', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3160492054728698490', '-3160492054728698490', 'http.path', 0x2F6F726465722F32, '6', '1589003992003107', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3160492054728698490', '-3160492054728698490', 'mvc.controller.class', 0x4F72646572436F6E74726F6C6C6572, '6', '1589003992003107', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-3160492054728698490', '-3160492054728698490', 'mvc.controller.method', 0x6765744F7264657242794964, '6', '1589003992003107', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-4606328285533547995', '-4606328285533547995', 'sr', null, '-1', '1589004943098773', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-4606328285533547995', '-4606328285533547995', 'ss', null, '-1', '1589004943106903', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-4606328285533547995', '-4606328285533547995', 'ca', 0x01, '0', '1589004943098773', '-1062669823', null, '-8123', '');
INSERT INTO `zipkin_annotations` VALUES ('0', '-4606328285533547995', '-4606328285533547995', 'http.method', 0x504F5354, '6', '1589004943098773', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-4606328285533547995', '-4606328285533547995', 'http.path', 0x2F64727569642F62617369632E6A736F6E, '6', '1589004943098773', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-9054157223424177374', '-9054157223424177374', 'sr', null, '-1', '1589004946216179', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-9054157223424177374', '-9054157223424177374', 'ss', null, '-1', '1589004946218482', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-9054157223424177374', '-9054157223424177374', 'ca', 0x01, '0', '1589004946216179', '-1062669823', null, '-8111', '');
INSERT INTO `zipkin_annotations` VALUES ('0', '-9054157223424177374', '-9054157223424177374', 'http.method', 0x504F5354, '6', '1589004946216179', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-9054157223424177374', '-9054157223424177374', 'http.path', 0x2F64727569642F7765626170702E6A736F6E, '6', '1589004946216179', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '8435831639462554267', '8435831639462554267', 'sr', null, '-1', '1589005057786267', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '8435831639462554267', '8435831639462554267', 'ss', null, '-1', '1589005057788405', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '8435831639462554267', '8435831639462554267', 'ca', 0x01, '0', '1589005057786267', '-1062669823', null, '-8126', '');
INSERT INTO `zipkin_annotations` VALUES ('0', '8435831639462554267', '8435831639462554267', 'http.method', 0x504F5354, '6', '1589005057786267', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '8435831639462554267', '8435831639462554267', 'http.path', 0x2F64727569642F73716C2E6A736F6E, '6', '1589005057786267', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '8370391800402402039', '8370391800402402039', 'sr', null, '-1', '1589005075785229', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '8370391800402402039', '8370391800402402039', 'ss', null, '-1', '1589005075787348', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '8370391800402402039', '8370391800402402039', 'ca', 0x01, '0', '1589005075785229', '-1062669823', null, '-8126', '');
INSERT INTO `zipkin_annotations` VALUES ('0', '8370391800402402039', '8370391800402402039', 'http.method', 0x504F5354, '6', '1589005075785229', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '8370391800402402039', '8370391800402402039', 'http.path', 0x2F64727569642F73716C2E6A736F6E, '6', '1589005075785229', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-5793480958717107104', '-5793480958717107104', 'sr', null, '-1', '1589005177790253', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-5793480958717107104', '-5793480958717107104', 'ss', null, '-1', '1589005177792386', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-5793480958717107104', '-5793480958717107104', 'ca', 0x01, '0', '1589005177790253', '-1062669823', null, '-8126', '');
INSERT INTO `zipkin_annotations` VALUES ('0', '-5793480958717107104', '-5793480958717107104', 'http.method', 0x504F5354, '6', '1589005177790253', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-5793480958717107104', '-5793480958717107104', 'http.path', 0x2F64727569642F73716C2E6A736F6E, '6', '1589005177790253', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-7842048509723922726', '-7842048509723922726', 'sr', null, '-1', '1589005225778091', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-7842048509723922726', '-7842048509723922726', 'ss', null, '-1', '1589005225778822', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-7842048509723922726', '-7842048509723922726', 'ca', 0x01, '0', '1589005225778091', '-1062669823', null, '-8126', '');
INSERT INTO `zipkin_annotations` VALUES ('0', '-7842048509723922726', '-7842048509723922726', 'http.method', 0x504F5354, '6', '1589005225778091', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-7842048509723922726', '-7842048509723922726', 'http.path', 0x2F64727569642F73716C2E6A736F6E, '6', '1589005225778091', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '3139713687954886805', '3139713687954886805', 'sr', null, '-1', '1589005261785283', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '3139713687954886805', '3139713687954886805', 'ss', null, '-1', '1589005261787092', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '3139713687954886805', '3139713687954886805', 'ca', 0x01, '0', '1589005261785283', '-1062669823', null, '-8126', '');
INSERT INTO `zipkin_annotations` VALUES ('0', '3139713687954886805', '3139713687954886805', 'http.method', 0x504F5354, '6', '1589005261785283', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '3139713687954886805', '3139713687954886805', 'http.path', 0x2F64727569642F73716C2E6A736F6E, '6', '1589005261785283', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-1224935131471052629', 'cs', null, '-1', '1589007406051447', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-1224935131471052629', 'cr', null, '-1', '1589007406068965', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-1224935131471052629', 'http.method', 0x474554, '6', '1589007406051447', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-1224935131471052629', 'http.path', 0x2F636C69656E742F31, '6', '1589007406051447', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-4658816164250876531', 'lc', '', '6', '1589007406050671', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-2318429015802776677', 'sr', null, '-1', '1589007406037627', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-2318429015802776677', 'ss', null, '-1', '1589007406073721', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-2318429015802776677', 'ca', 0x01, '0', '1589007406037627', null, 0x00000000000000000000000000000001, null, '');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-2318429015802776677', 'http.method', 0x474554, '6', '1589007406037627', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-2318429015802776677', 'http.path', 0x2F6F726465722F32, '6', '1589007406037627', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-2318429015802776677', 'mvc.controller.class', 0x4F72646572436F6E74726F6C6C6572, '6', '1589007406037627', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-2318429015802776677', 'mvc.controller.method', 0x6765744F7264657242794964, '6', '1589007406037627', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-1224935131471052629', 'sr', null, '-1', '1589007406061574', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-1224935131471052629', 'ss', null, '-1', '1589007406068955', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-1224935131471052629', 'ca', 0x01, '0', '1589007406061574', '-1062669823', null, '-7153', '');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-1224935131471052629', 'http.method', 0x474554, '6', '1589007406061574', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-1224935131471052629', 'http.path', 0x2F636C69656E742F31, '6', '1589007406061574', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-1224935131471052629', 'mvc.controller.class', 0x436C69656E74436F6E74726F6C6C6572, '6', '1589007406061574', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2318429015802776677', '-1224935131471052629', 'mvc.controller.method', 0x676574436C69656E7442794964, '6', '1589007406061574', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '1128663244544274012', 'sr', null, '-1', '1589008032357142', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '1128663244544274012', 'ss', null, '-1', '1589008032366725', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '1128663244544274012', 'ca', 0x01, '0', '1589008032357142', '-1062669823', null, '-6460', '');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '1128663244544274012', 'http.method', 0x474554, '6', '1589008032357142', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '1128663244544274012', 'http.path', 0x2F636C69656E742F31, '6', '1589008032357142', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '1128663244544274012', 'mvc.controller.class', 0x436C69656E74436F6E74726F6C6C6572, '6', '1589008032357142', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '1128663244544274012', 'mvc.controller.method', 0x676574436C69656E7442794964, '6', '1589008032357142', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '1128663244544274012', 'cs', null, '-1', '1589008032352813', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '1128663244544274012', 'cr', null, '-1', '1589008032366533', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '1128663244544274012', 'http.method', 0x474554, '6', '1589008032352813', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '1128663244544274012', 'http.path', 0x2F636C69656E742F31, '6', '1589008032352813', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '6725492156269792026', 'lc', '', '6', '1589008032350311', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '-8679383329155899312', 'sr', null, '-1', '1589008032338330', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '-8679383329155899312', 'ss', null, '-1', '1589008032380173', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '-8679383329155899312', 'ca', 0x01, '0', '1589008032338330', null, 0x00000000000000000000000000000001, null, '');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '-8679383329155899312', 'http.method', 0x474554, '6', '1589008032338330', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '-8679383329155899312', 'http.path', 0x2F6F726465722F32, '6', '1589008032338330', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '-8679383329155899312', 'mvc.controller.class', 0x4F72646572436F6E74726F6C6C6572, '6', '1589008032338330', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-8679383329155899312', '-8679383329155899312', 'mvc.controller.method', 0x6765744F7264657242794964, '6', '1589008032338330', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '2723456745302465335', 'cs', null, '-1', '1589010275020745', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '2723456745302465335', 'cr', null, '-1', '1589010275038667', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '2723456745302465335', 'http.method', 0x474554, '6', '1589010275020745', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '2723456745302465335', 'http.path', 0x2F636C69656E742F31, '6', '1589010275020745', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '3946334065227760019', 'lc', '', '6', '1589010274715816', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '-2587244872652967748', 'sr', null, '-1', '1589010274404453', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '-2587244872652967748', 'ss', null, '-1', '1589010275107799', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '-2587244872652967748', 'ca', 0x01, '0', '1589010274404453', null, 0x00000000000000000000000000000001, null, '');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '-2587244872652967748', 'http.method', 0x474554, '6', '1589010274404453', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '-2587244872652967748', 'http.path', 0x2F6F726465722F34, '6', '1589010274404453', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '-2587244872652967748', 'mvc.controller.class', 0x4F72646572436F6E74726F6C6C6572, '6', '1589010274404453', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '-2587244872652967748', 'mvc.controller.method', 0x6765744F7264657242794964, '6', '1589010274404453', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '2723456745302465335', 'sr', null, '-1', '1589010275027895', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '2723456745302465335', 'ss', null, '-1', '1589010275035337', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '2723456745302465335', 'ca', 0x01, '0', '1589010275027895', '-1062669823', null, '-5476', '');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '2723456745302465335', 'http.method', 0x474554, '6', '1589010275027895', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '2723456745302465335', 'http.path', 0x2F636C69656E742F31, '6', '1589010275027895', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '2723456745302465335', 'mvc.controller.class', 0x436C69656E74436F6E74726F6C6C6572, '6', '1589010275027895', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-2587244872652967748', '2723456745302465335', 'mvc.controller.method', 0x676574436C69656E7442794964, '6', '1589010275027895', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '7083263313923890380', '-2219264879826866320', 'cs', null, '-1', '1589012728486811', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '7083263313923890380', '-2219264879826866320', 'cr', null, '-1', '1589012728487572', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '7083263313923890380', '-2219264879826866320', 'error', 0x636F6D2E6E6574666C69782E636C69656E742E436C69656E74457863657074696F6E3A204C6F61642062616C616E63657220646F6573206E6F74206861766520617661696C61626C652073657276657220666F7220636C69656E743A20737072696E67636C6F75642D636C69656E74, '6', '1589012728486811', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '7083263313923890380', '-2219264879826866320', 'http.method', 0x474554, '6', '1589012728486811', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '7083263313923890380', '-2219264879826866320', 'http.path', 0x2F636C69656E742F31, '6', '1589012728486811', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '7083263313923890380', '7083263313923890380', 'sr', null, '-1', '1589012728481727', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '7083263313923890380', '7083263313923890380', 'ss', null, '-1', '1589012728499402', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '7083263313923890380', '7083263313923890380', 'ca', 0x01, '0', '1589012728481727', null, 0x00000000000000000000000000000001, null, '');
INSERT INTO `zipkin_annotations` VALUES ('0', '7083263313923890380', '7083263313923890380', 'http.method', 0x474554, '6', '1589012728481727', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '7083263313923890380', '7083263313923890380', 'http.path', 0x2F6F726465722F34, '6', '1589012728481727', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '7083263313923890380', '7083263313923890380', 'mvc.controller.class', 0x4F72646572436F6E74726F6C6C6572, '6', '1589012728481727', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '7083263313923890380', '7083263313923890380', 'mvc.controller.method', 0x6765744F7264657242794964, '6', '1589012728481727', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '-7756465661651609617', 'cs', null, '-1', '1589012892841133', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '-7756465661651609617', 'cr', null, '-1', '1589012892850219', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '-7756465661651609617', 'http.method', 0x474554, '6', '1589012892841133', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '-7756465661651609617', 'http.path', 0x2F636C69656E742F31, '6', '1589012892841133', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '1024605667252672844', 'sr', null, '-1', '1589012889679095', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '1024605667252672844', 'ss', null, '-1', '1589012893619544', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '1024605667252672844', 'ca', 0x01, '0', '1589012889679095', null, 0x00000000000000000000000000000001, null, '');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '1024605667252672844', 'http.method', 0x474554, '6', '1589012889679095', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '1024605667252672844', 'http.path', 0x2F6F726465722F34, '6', '1589012889679095', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '1024605667252672844', 'mvc.controller.class', 0x4F72646572436F6E74726F6C6C6572, '6', '1589012889679095', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '1024605667252672844', 'mvc.controller.method', 0x6765744F7264657242794964, '6', '1589012889679095', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '-7756465661651609617', 'sr', null, '-1', '1589012892843132', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '-7756465661651609617', 'ss', null, '-1', '1589012892850625', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '-7756465661651609617', 'ca', 0x01, '0', '1589012892843132', '-1062669823', null, '-3805', '');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '-7756465661651609617', 'http.method', 0x474554, '6', '1589012892843132', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '-7756465661651609617', 'http.path', 0x2F636C69656E742F31, '6', '1589012892843132', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '-7756465661651609617', 'mvc.controller.class', 0x436C69656E74436F6E74726F6C6C6572, '6', '1589012892843132', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '1024605667252672844', '-7756465661651609617', 'mvc.controller.method', 0x676574436C69656E7442794964, '6', '1589012892843132', '-1062669823', null, null, 'springcloud-client');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6982342465567302610', '-6982342465567302610', 'sr', null, '-1', '1589016056044253', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6982342465567302610', '-6982342465567302610', 'ss', null, '-1', '1589016056055093', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6982342465567302610', '-6982342465567302610', 'ca', 0x01, '0', '1589016056044253', null, 0x00000000000000000000000000000001, null, '');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6982342465567302610', '-6982342465567302610', 'http.method', 0x474554, '6', '1589016056044253', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6982342465567302610', '-6982342465567302610', 'http.path', 0x2F6F726465722F70616765, '6', '1589016056044253', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6982342465567302610', '-6982342465567302610', 'mvc.controller.class', 0x4F72646572436F6E74726F6C6C6572, '6', '1589016056044253', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '-6982342465567302610', '-6982342465567302610', 'mvc.controller.method', 0x6765744F7264657250616765, '6', '1589016056044253', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '5380205382444376857', '5380205382444376857', 'sr', null, '-1', '1589016102053089', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '5380205382444376857', '5380205382444376857', 'ss', null, '-1', '1589016102062347', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '5380205382444376857', '5380205382444376857', 'ca', 0x01, '0', '1589016102053089', null, 0x00000000000000000000000000000001, null, '');
INSERT INTO `zipkin_annotations` VALUES ('0', '5380205382444376857', '5380205382444376857', 'http.method', 0x474554, '6', '1589016102053089', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '5380205382444376857', '5380205382444376857', 'http.path', 0x2F6F726465722F70616765, '6', '1589016102053089', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '5380205382444376857', '5380205382444376857', 'mvc.controller.class', 0x4F72646572436F6E74726F6C6C6572, '6', '1589016102053089', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '5380205382444376857', '5380205382444376857', 'mvc.controller.method', 0x6765744F7264657250616765, '6', '1589016102053089', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '8522538572285977300', '8522538572285977300', 'sr', null, '-1', '1589016103141100', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '8522538572285977300', '8522538572285977300', 'ss', null, '-1', '1589016103149869', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '8522538572285977300', '8522538572285977300', 'ca', 0x01, '0', '1589016103141100', null, 0x00000000000000000000000000000001, null, '');
INSERT INTO `zipkin_annotations` VALUES ('0', '8522538572285977300', '8522538572285977300', 'http.method', 0x474554, '6', '1589016103141100', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '8522538572285977300', '8522538572285977300', 'http.path', 0x2F6F726465722F70616765, '6', '1589016103141100', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '8522538572285977300', '8522538572285977300', 'mvc.controller.class', 0x4F72646572436F6E74726F6C6C6572, '6', '1589016103141100', '-1062669823', null, null, 'springcloud-order');
INSERT INTO `zipkin_annotations` VALUES ('0', '8522538572285977300', '8522538572285977300', 'mvc.controller.method', 0x6765744F7264657250616765, '6', '1589016103141100', '-1062669823', null, null, 'springcloud-order');

-- ----------------------------
-- Table structure for zipkin_dependencies
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_dependencies`;
CREATE TABLE `zipkin_dependencies` (
  `day` date NOT NULL,
  `parent` varchar(255) NOT NULL,
  `child` varchar(255) NOT NULL,
  `call_count` bigint DEFAULT NULL,
  UNIQUE KEY `day` (`day`,`parent`,`child`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_dependencies
-- ----------------------------

-- ----------------------------
-- Table structure for zipkin_spans
-- ----------------------------
DROP TABLE IF EXISTS `zipkin_spans`;
CREATE TABLE `zipkin_spans` (
  `trace_id_high` bigint NOT NULL DEFAULT '0' COMMENT 'If non zero, this means the trace uses 128 bit traceIds instead of 64 bit',
  `trace_id` bigint NOT NULL,
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `parent_id` bigint DEFAULT NULL,
  `debug` bit(1) DEFAULT NULL,
  `start_ts` bigint DEFAULT NULL COMMENT 'Span.timestamp(): epoch micros used for endTs query and to implement TTL',
  `duration` bigint DEFAULT NULL COMMENT 'Span.duration(): micros used for minDuration and maxDuration query',
  UNIQUE KEY `trace_id_high` (`trace_id_high`,`trace_id`,`id`) COMMENT 'ignore insert on duplicate',
  KEY `trace_id_high_2` (`trace_id_high`,`trace_id`,`id`) COMMENT 'for joining with zipkin_annotations',
  KEY `trace_id_high_3` (`trace_id_high`,`trace_id`) COMMENT 'for getTracesByIds',
  KEY `name` (`name`) COMMENT 'for getTraces and getSpanNames',
  KEY `start_ts` (`start_ts`) COMMENT 'for getTraces ordering and range'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED;

-- ----------------------------
-- Records of zipkin_spans
-- ----------------------------
INSERT INTO `zipkin_spans` VALUES ('0', '-9054157223424177374', '-9054157223424177374', 'post', null, null, '1589004946216179', '2303');
INSERT INTO `zipkin_spans` VALUES ('0', '-8679383329155899312', '-8679383329155899312', 'get /order/{id}', null, null, '1589008032338330', '41843');
INSERT INTO `zipkin_spans` VALUES ('0', '-8679383329155899312', '1128663244544274012', 'get', '6725492156269792026', null, '1589008032352813', '13720');
INSERT INTO `zipkin_spans` VALUES ('0', '-8679383329155899312', '6725492156269792026', 'hystrix', '-8679383329155899312', null, '1589008032350311', '26256');
INSERT INTO `zipkin_spans` VALUES ('0', '-7842048509723922726', '-7842048509723922726', 'post', null, null, '1589005225778091', '731');
INSERT INTO `zipkin_spans` VALUES ('0', '-6982342465567302610', '-6982342465567302610', 'get /order/page', null, null, '1589016056044253', '10840');
INSERT INTO `zipkin_spans` VALUES ('0', '-5793480958717107104', '-5793480958717107104', 'post', null, null, '1589005177790253', '2133');
INSERT INTO `zipkin_spans` VALUES ('0', '-4606328285533547995', '-4606328285533547995', 'post', null, null, '1589004943098773', '8130');
INSERT INTO `zipkin_spans` VALUES ('0', '-3702201745749729503', '-3702201745749729503', 'get /order/page', null, null, '1589003948749358', '301717');
INSERT INTO `zipkin_spans` VALUES ('0', '-3160492054728698490', '-7261450959721719555', 'hystrix', '-3160492054728698490', null, '1589003992179038', '167657');
INSERT INTO `zipkin_spans` VALUES ('0', '-3160492054728698490', '-3160492054728698490', 'get /order/{id}', null, null, '1589003992003107', '346666');
INSERT INTO `zipkin_spans` VALUES ('0', '-3160492054728698490', '1894547638422073357', 'get', '-7261450959721719555', null, '1589003992277900', '52753');
INSERT INTO `zipkin_spans` VALUES ('0', '-2587244872652967748', '-2587244872652967748', 'get /order/{id}', null, null, '1589010274404453', '703346');
INSERT INTO `zipkin_spans` VALUES ('0', '-2587244872652967748', '2723456745302465335', 'get /client/{id}', '3946334065227760019', null, '1589010275020745', '17922');
INSERT INTO `zipkin_spans` VALUES ('0', '-2587244872652967748', '3946334065227760019', 'hystrix', '-2587244872652967748', null, '1589010274715816', '349751');
INSERT INTO `zipkin_spans` VALUES ('0', '-2318429015802776677', '-4658816164250876531', 'hystrix', '-2318429015802776677', null, '1589007406050671', '21862');
INSERT INTO `zipkin_spans` VALUES ('0', '-2318429015802776677', '-2318429015802776677', 'get /order/{id}', null, null, '1589007406037627', '36094');
INSERT INTO `zipkin_spans` VALUES ('0', '-2318429015802776677', '-1224935131471052629', 'get /client/{id}', '-4658816164250876531', null, '1589007406051447', '17518');
INSERT INTO `zipkin_spans` VALUES ('0', '1024605667252672844', '-7756465661651609617', 'get /client/{id}', '1024605667252672844', null, '1589012892841133', '9086');
INSERT INTO `zipkin_spans` VALUES ('0', '1024605667252672844', '1024605667252672844', 'get /order/{id}', null, null, '1589012889679095', '3940449');
INSERT INTO `zipkin_spans` VALUES ('0', '3139713687954886805', '3139713687954886805', 'post', null, null, '1589005261785283', '1809');
INSERT INTO `zipkin_spans` VALUES ('0', '5380205382444376857', '5380205382444376857', 'get /order/page', null, null, '1589016102053089', '9258');
INSERT INTO `zipkin_spans` VALUES ('0', '7083263313923890380', '-2219264879826866320', 'get', '7083263313923890380', null, '1589012728486811', '761');
INSERT INTO `zipkin_spans` VALUES ('0', '7083263313923890380', '7083263313923890380', 'get /order/{id}', null, null, '1589012728481727', '17675');
INSERT INTO `zipkin_spans` VALUES ('0', '8370391800402402039', '8370391800402402039', 'post', null, null, '1589005075785229', '2119');
INSERT INTO `zipkin_spans` VALUES ('0', '8435831639462554267', '8435831639462554267', 'post', null, null, '1589005057786267', '2138');
INSERT INTO `zipkin_spans` VALUES ('0', '8522538572285977300', '8522538572285977300', 'get /order/page', null, null, '1589016103141100', '8769');
