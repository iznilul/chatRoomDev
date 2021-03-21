/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3307
 Source Schema         : chatroom

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 21/03/2021 18:56:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for friendlist
-- ----------------------------
DROP TABLE IF EXISTS `friendlist`;
CREATE TABLE `friendlist`  (
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `friendId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of friendlist
-- ----------------------------
INSERT INTO `friendlist` VALUES ('002', '003');
INSERT INTO `friendlist` VALUES ('001', '003');
INSERT INTO `friendlist` VALUES ('001', '004');
INSERT INTO `friendlist` VALUES ('002', '004');
INSERT INTO `friendlist` VALUES ('002', '001');
INSERT INTO `friendlist` VALUES ('004', '001');
INSERT INTO `friendlist` VALUES ('004', '002');
INSERT INTO `friendlist` VALUES ('004', '002');
INSERT INTO `friendlist` VALUES ('003', '001');
INSERT INTO `friendlist` VALUES ('003', '004');
INSERT INTO `friendlist` VALUES ('003', '002');
INSERT INTO `friendlist` VALUES ('001', '002');

-- ----------------------------
-- Table structure for groupinfo
-- ----------------------------
DROP TABLE IF EXISTS `groupinfo`;
CREATE TABLE `groupinfo`  (
  `groupId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `groupName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `groupAvatarUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of groupinfo
-- ----------------------------
INSERT INTO `groupinfo` VALUES ('01', 'Group01', 'img/avatar/Group01.jpg');

-- ----------------------------
-- Table structure for grouplist
-- ----------------------------
DROP TABLE IF EXISTS `grouplist`;
CREATE TABLE `grouplist`  (
  `groupId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grouplist
-- ----------------------------
INSERT INTO `grouplist` VALUES ('01', '001');
INSERT INTO `grouplist` VALUES ('01', '002');
INSERT INTO `grouplist` VALUES ('01', '003');
INSERT INTO `grouplist` VALUES ('01', '004');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `avatarUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('001', 'Member001', '001', 'img/avatar/Member001.jpg');
INSERT INTO `user` VALUES ('002', 'Member002', '002', 'img/avatar/Member002.jpg');
INSERT INTO `user` VALUES ('003', 'Member003', '003', 'img/avatar/Member003.jpg');
INSERT INTO `user` VALUES ('004', 'Member004', '004', 'img/avatar/Member004.jpg');

SET FOREIGN_KEY_CHECKS = 1;
