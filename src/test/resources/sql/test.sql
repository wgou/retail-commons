/*
Navicat MySQL Data Transfer

Source Server         : 10.13.3.12
Source Server Version : 50628
Source Host           : 10.13.3.12:3306
Source Database       : pay_platform

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-03-28 13:32:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(10) DEFAULT NULL,
  `ADDRE` varchar(255) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'zhangsan1', '四川成都', '123456789');
INSERT INTO `test` VALUES ('2', 'zhangsan2', '四川成都', '123456789');
INSERT INTO `test` VALUES ('3', 'zhangsan', '四川成都', '123456789');
INSERT INTO `test` VALUES ('4', 'zhangsan4', '四川成都', '18612215231');
INSERT INTO `test` VALUES ('5', 'zhangsan0', '四川成都', '18612215231');
INSERT INTO `test` VALUES ('6', 'zhangsan1', '四川成都', '18612215231');
INSERT INTO `test` VALUES ('7', 'zhangsan2', '四川成都', '18612215231');
INSERT INTO `test` VALUES ('8', 'zhangsan3', '四川成都', '18612215231');
INSERT INTO `test` VALUES ('9', 'zhangsan4', '四川成都', '18612215231');
INSERT INTO `test` VALUES ('10', 'zhangsan10', '四川成都', '123456');
