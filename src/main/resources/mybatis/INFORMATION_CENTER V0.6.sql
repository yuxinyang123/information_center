/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50506
 Source Host           : localhost:3306
 Source Schema         : information_center

 Target Server Type    : MySQL
 Target Server Version : 50506
 File Encoding         : 65001

 Date: 06/11/2018 11:08:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_center
-- ----------------------------
DROP TABLE IF EXISTS `tbl_center`;
CREATE TABLE `tbl_center`  (
  `CENTER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_KEY` bigint(20) NOT NULL COMMENT '用户外键',
  `WEATHER_CODE` int(11) NOT NULL COMMENT '天气api',
  PRIMARY KEY (`CENTER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for tbl_center_degree
-- ----------------------------
DROP TABLE IF EXISTS `tbl_center_degree`;
CREATE TABLE `tbl_center_degree` (
  `DEGREE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `DEGREE_USERKEY` bigint(20) NOT NULL DEFAULT '0' COMMENT '外键',
  `DEGREE_TERM` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '学期',
  `DEGREE_CLASSNAME` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '课程名字',
  `DEGREE_CLASSNATURE` varchar(32) CHARACTER SET utf8 NOT NULL COMMENT '课程类型',
  `DEGREE_CREDIT` double(8,2) NOT NULL COMMENT '学分',
  `DEGREE_GRADE` double(12,2) NOT NULL COMMENT '成绩',
  `DEGREE_PERFORMANCEPOINT` double(8,2) NOT NULL COMMENT '绩点',
  `DEGREE_TESTNATURE` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '考试类型',
  `DEGREE_STUDENTID` int(11) NOT NULL COMMENT '学号',
  `DEGREE_STUDENTNAME` varchar(128) CHARACTER SET utf8 NOT NULL COMMENT '学生名字',
  PRIMARY KEY (`DEGREE_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;



-- ----------------------------
-- Table structure for tbl_comment
-- ----------------------------
DROP TABLE IF EXISTS `tbl_comment`;
CREATE TABLE `tbl_comment`  (
  `COMMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `RES_KEY` bigint(20) NOT NULL COMMENT '文章外键',
  `USER_KEY` bigint(20) NOT NULL COMMENT '用户外键',
  `COMMENT_CHILD_ID` bigint(20) NOT NULL COMMENT '子id',
  `COMMENT_PARENT_ID` bigint(20) NOT NULL COMMENT '评论父id',
  `COMMENT_DATE` datetime NOT NULL,
  `COMMENT_ISANONYMITY` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否匿名',
  `COMMENT_CONTEXT` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`COMMENT_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_hotpot
-- ----------------------------
DROP TABLE IF EXISTS `tbl_hotpot`;
CREATE TABLE `tbl_hotpot`  (
  `HOTPOT_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`HOTPOT_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_premission
-- ----------------------------
DROP TABLE IF EXISTS `tbl_premission`;
CREATE TABLE `tbl_premission`  (
  `PRMS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_KEY` bigint(20) NOT NULL COMMENT 'ROLE外键',
  `PRMS_PREMISSION` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  PRIMARY KEY (`PRMS_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_res_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_res_type`;
CREATE TABLE `tbl_res_type`  (
  `TYPE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`TYPE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '竞赛信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_resource
-- ----------------------------
DROP TABLE IF EXISTS `tbl_resource`;
CREATE TABLE `tbl_resource`  (
  `RES_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TYPE_KEY` bigint(20) NOT NULL,
  `RES_TITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `RES_AUTHOR` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `RES_SOURCE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `RES_DATE` datetime NOT NULL,
  `RES_CONTEXT` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `RES_COMMENTCOUNT` bigint(12) DEFAULT '0' COMMENT '文章评论数',
  PRIMARY KEY (`RES_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源表 所有信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_role`;
CREATE TABLE `tbl_role`  (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  `LEFT` bigint(255) NOT NULL COMMENT '左值',
  `RIGHT` bigint(255) NOT NULL COMMENT '右值',
  `LAYER` bigint(255) NOT NULL COMMENT '层级',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '使用左右值建立无限层级的角色表\n' ROW_FORMAT = Compact;


-- ----------------------------
-- Table structure for tbl_syllabus
-- ----------------------------
DROP TABLE IF EXISTS `tbl_syllabus`
CREATE TABLE `tbl_syllabus`(
   `SYLLABUS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
   `SYLLABUS_CLASSNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名',
   `SYLLABUS_STARTWEEK` INT(8) NOT NULL DEFAULT '0' COMMENT '起始周',
   `SYLLABUS_ENDWEEK` INT(8) NOT NULL DEFAULT '0' COMMENT '终止周',
   `SYLLABUS_STARTPART` INT(8) NOT NULL DEFAULT '0' COMMENT '起始节数',
   `SYLLABUS_ENDPART` INT(8) NOT NULL DEFAULT '0' COMMENT '终止节数',
   `SYLLABUS_WEEK` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT "" COMMENT '星期',
   `SYLLABUS_CLASSROOM` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT "" COMMENT '地址',
   `SYLLABUS_TEACHER` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT "佚名" COMMENT '教师',
   `USERKEY` bigint(20) NOT NULL COMMENT '用户外键',
   PRIMARY KEY (`SYLLABUS_ID`) USING BTREE
)ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;



-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `USER_EMAIL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录邮箱',
  `USER_PHONE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机（可用于注册',
  `USER_PASS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `USER_ISBAN` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_user_information
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_information`;
CREATE TABLE `tbl_user_information`  (
  `INF_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_KEY` bigint(20) NOT NULL COMMENT '用户外键',
  `INF_NUM` int(11) NULL DEFAULT NULL COMMENT '教务学号',
  `INF_PASS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教务密码',
  `INF_SIGNATURE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个人签名',
  `INF_ACADEMY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院',
  `INF_MAJOR` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `INF_CLASS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `INF_SEX` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INF_LOCALTION` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地理位置',
  `INF_AGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`INF_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user_role`;
CREATE TABLE `tbl_user_role`  (
  `UR_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_KEY` bigint(20) NOT NULL,
  `ROLE_KEY` bigint(20) NOT NULL,
  PRIMARY KEY (`UR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_weather
-- ----------------------------
DROP TABLE IF EXISTS `tbl_weather`;
CREATE TABLE `tbl_weather`  (
  `WEATHER_CODE` int(11) NOT NULL DEFAULT 0 COMMENT 'API中的code',
  `WEATHER_CITY_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `WEATHER_DATE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间',
  `WEATHER_SUNRISE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日出时间',
  `WEATHER_HIGH` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最高气温',
  `WEATHER_LOW` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最低气温',
  `WEATHER_SUNSET` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日落时间',
  `WEATHER_TEMPERATURE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '温度',
  `WEATHER_AQI` float NULL DEFAULT NULL,
  `WEATHER_NOTICE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '小提示',
  `WEATHER_TYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '天气类型',
  `WEATHER_FL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风力',
  `WEATHER_FX` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '风向',
  PRIMARY KEY (`WEATHER_CODE`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'api对应的天气表' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for tbl_hotspot
-- ----------------------------
DROP TABLE IF EXISTS `tbl_hotspot`;
CREATE TABLE `tbl_hotspot`(
  `HOTSPOT_ID` int(8) NOT NULL COMMENT '热点ID' AUTO_INCREMENT,
  `HOTSPOT_TITLE` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '热点标题',
  `HOTSPOT_HOTNUM` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '热点数',
  `HOTSPOT_HOTURL` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'url',
  PRIMARY KEY (`HOTSPOT_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '热点信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for `tbl_avg`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_avg`;
CREATE TABLE `tbl_avg` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CLASSNAME` varchar(128) NOT NULL COMMENT '班级名称',
  `FENGSHU` double(8,2) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET=utf8;
