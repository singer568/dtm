/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50544
Source Host           : localhost:3306
Source Database       : hdggzy

Target Server Type    : MYSQL
Target Server Version : 50544
File Encoding         : 65001

Date: 2015-12-30 11:09:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dtm_logs`
-- ----------------------------
DROP TABLE IF EXISTS `dtm_logs`;
CREATE TABLE `dtm_logs` (
  `pk` varchar(40) NOT NULL,
  `startDate` datetime DEFAULT NULL,
  `longStartDate` varchar(255) DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `longEndDate` varchar(255) DEFAULT NULL,
  `costs` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `allIds` text,
  `successIds` text,
  `failIds` text,
  `failInfo` text,
  `noIds` text,
  PRIMARY KEY (`pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dtm_logs
-- ----------------------------
