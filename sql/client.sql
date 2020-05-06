/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : spring

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-05-06 17:20:43
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('1', 'spring-demo', '11', '0', '2020-04-30 17:12:25', '2020-04-30 17:12:27');
INSERT INTO `client` VALUES ('2', 'spring-demo2', '11', '0', '2020-04-30 17:12:25', '2020-04-30 17:12:27');
INSERT INTO `client` VALUES ('3', 'spring-demo2', '11', '0', '2020-04-30 17:12:25', '2020-04-30 17:12:27');
INSERT INTO `client` VALUES ('4', 'spring-demo2', '11', '0', '2020-04-30 17:12:25', '2020-05-06 15:48:50');
INSERT INTO `client` VALUES ('5', 'spring-demo2', '11', '0', '2020-04-30 17:12:25', '2020-05-06 15:48:50');
INSERT INTO `client` VALUES ('6', 'spring-demo2', '11', '0', '2020-05-06 15:47:43', '2020-05-06 15:47:43');
INSERT INTO `client` VALUES ('7', 'spring-demo2', '11', '0', '2020-05-06 15:47:44', '2020-05-06 15:47:44');
INSERT INTO `client` VALUES ('8', 'spring-demo2', '11', '0', '2020-05-06 15:53:00', '2020-05-06 15:53:00');
INSERT INTO `client` VALUES ('9', 'spring-demo2', '11', '0', '2020-05-06 15:53:00', '2020-05-06 15:53:00');
INSERT INTO `client` VALUES ('10', 'spring-demo2', '11', '0', '2020-05-06 15:53:01', '2020-05-06 15:53:01');
INSERT INTO `client` VALUES ('11', 'spring-demo2', '11', '0', '2020-05-06 15:53:01', '2020-05-06 15:53:01');
INSERT INTO `client` VALUES ('12', 'spring-demo2', '11', '0', '2020-05-06 15:53:03', '2020-05-06 15:53:03');
INSERT INTO `client` VALUES ('13', 'spring-demo2', '11', '0', '2020-05-06 15:53:03', '2020-05-06 15:53:03');
