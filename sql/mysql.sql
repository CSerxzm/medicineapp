/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : medicineapp

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2021-01-20 12:33:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment_tb
-- ----------------------------
DROP TABLE IF EXISTS `comment_tb`;
CREATE TABLE `comment_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `forum_id` int(11) DEFAULT NULL COMMENT '养生论坛id,外键',
  `name` varchar(100) DEFAULT NULL COMMENT '评论者,外键',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `content` text COMMENT '内容',
  PRIMARY KEY (`id`),
  KEY `name` (`name`),
  KEY `forum_id` (`forum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for food_tb
-- ----------------------------
DROP TABLE IF EXISTS `food_tb`;
CREATE TABLE `food_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '食谱名',
  `image` varchar(100) DEFAULT NULL COMMENT '图片',
  `compose` text COMMENT '用料',
  `method` text COMMENT '做法',
  `funs` text COMMENT '功效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for forum_tb
-- ----------------------------
DROP TABLE IF EXISTS `forum_tb`;
CREATE TABLE `forum_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '作者,外键',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
  `content` text COMMENT '内容',
  `keyword` varchar(100) DEFAULT NULL COMMENT '关键字',
  `comments` int(11) DEFAULT '0' COMMENT '评论数',
  PRIMARY KEY (`id`),
  KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for health_tb
-- ----------------------------
DROP TABLE IF EXISTS `health_tb`;
CREATE TABLE `health_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT '文章标题',
  `author` varchar(100) DEFAULT NULL COMMENT '作者,出处',
  `edit_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `image` varchar(100) DEFAULT NULL COMMENT '图片',
  `content` text COMMENT '内容',
  `main_type` int(11) DEFAULT NULL COMMENT '主类别，节气（0），四季（1），人群（2）',
  `sub_type` int(11) DEFAULT NULL COMMENT '子类别，气节则为二十四节气（0-23），四季则是春夏秋冬（0-3），人群则为中老幼（0-2）',
  `views` int(11) DEFAULT '0' COMMENT '浏览量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for medicine_tb
-- ----------------------------
DROP TABLE IF EXISTS `medicine_tb`;
CREATE TABLE `medicine_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '名字',
  `nickname` varchar(100) DEFAULT NULL COMMENT '别名',
  `image` varchar(100) DEFAULT NULL COMMENT '图片',
  `funs` text COMMENT '作用',
  `taboos` text COMMENT '禁忌',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for prescr_tb
-- ----------------------------
DROP TABLE IF EXISTS `prescr_tb`;
CREATE TABLE `prescr_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '方名',
  `compose` text COMMENT '组成',
  `funs` text COMMENT '作用',
  `source` text COMMENT '出处',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rumor_tb
-- ----------------------------
DROP TABLE IF EXISTS `rumor_tb`;
CREATE TABLE `rumor_tb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `image` varchar(100) DEFAULT NULL COMMENT '图片',
  `content` text COMMENT '内容',
  `source` varchar(60) DEFAULT NULL COMMENT '出处',
  `reality` int(11) DEFAULT NULL COMMENT '真实否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_tb
-- ----------------------------
DROP TABLE IF EXISTS `user_tb`;
CREATE TABLE `user_tb` (
  `name` varchar(100) NOT NULL COMMENT '用户名,主键',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `image` varchar(100) DEFAULT NULL COMMENT '头像',
  `authority` varchar(18) DEFAULT NULL COMMENT '权限',
  `sex` int(11) DEFAULT NULL,
  `constellation` varchar(255) DEFAULT '',
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
