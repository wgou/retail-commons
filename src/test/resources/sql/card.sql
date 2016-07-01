/*
Navicat MySQL Data Transfer

Source Server         : 10.13.3.12
Source Server Version : 50628
Source Host           : 10.13.3.12:3306
Source Database       : pay_platform

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2016-03-28 13:31:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(11) NOT NULL,
  `cardNo` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1', '123132', '1');
INSERT INTO `card` VALUES ('2', '2232', '2');
INSERT INTO `card` VALUES ('3', '33333', '3');
