/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50544
Source Host           : localhost:3306
Source Database       : hdggzy

Target Server Type    : MYSQL
Target Server Version : 50544
File Encoding         : 65001

Date: 2015-12-30 11:09:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dtm_task`
-- ----------------------------
DROP TABLE IF EXISTS `dtm_task`;
CREATE TABLE `dtm_task` (
  `taskpk` varchar(40) NOT NULL,
  `taskcode` varchar(500) DEFAULT NULL,
  `taskname` varchar(500) DEFAULT NULL,
  `taskgroup` varchar(200) DEFAULT NULL,
  `tasktype` varchar(500) DEFAULT NULL,
  `taskcron` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`taskpk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dtm_task
-- ----------------------------
