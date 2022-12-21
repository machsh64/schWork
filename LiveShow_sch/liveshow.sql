/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : liveshow

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 21/12/2022 08:09:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for live_player
-- ----------------------------
DROP TABLE IF EXISTS `live_player`;
CREATE TABLE `live_player`  (
  `p_id` int NOT NULL AUTO_INCREMENT,
  `p_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `score` int NOT NULL,
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of live_player
-- ----------------------------
INSERT INTO `live_player` VALUES (1, '蔡徐坤', 23);
INSERT INTO `live_player` VALUES (2, '吴亦凡', 21);
INSERT INTO `live_player` VALUES (3, '李金章', 13);
INSERT INTO `live_player` VALUES (4, '阿布都诺', 100);
INSERT INTO `live_player` VALUES (5, '阿里', 21);
INSERT INTO `live_player` VALUES (7, '迪亚波罗', 25);
INSERT INTO `live_player` VALUES (18, '乔鲁诺', 22);
INSERT INTO `live_player` VALUES (22, 'teriri', 24);

SET FOREIGN_KEY_CHECKS = 1;
