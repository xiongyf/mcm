/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : mcm

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-05-09 11:29:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_mm_consume_record
-- ----------------------------
DROP TABLE IF EXISTS `tb_mm_consume_record`;
CREATE TABLE `tb_mm_consume_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) DEFAULT NULL COMMENT '会员id',
  `consume_type` varchar(255) DEFAULT NULL COMMENT '消费类型，1：购买，2：预存',
  `consume_goods` varchar(255) DEFAULT NULL COMMENT '消费物品',
  `unit_price` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '单价',
  `count` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '数量',
  `amount` varchar(255) DEFAULT NULL COMMENT '金额',
  `consume_time` datetime DEFAULT NULL COMMENT '消费时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_mm_member
-- ----------------------------
DROP TABLE IF EXISTS `tb_mm_member`;
CREATE TABLE `tb_mm_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(255) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_sys_user`;
CREATE TABLE `tb_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '盐',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态，1：未消费，2：已消费',
  `create_by` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
