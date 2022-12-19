CREATE DATABASE IF NOT EXISTS liveshow;

 -- ----------------------------
-- Table structure for live_player
-- ----------------------------
DROP TABLE IF EXISTS `live_player`;
CREATE TABLE `live_player`  (
  `pla_id` int NOT NULL AUTO_INCREMENT,
  `pla_name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `pla_score` int NOT NULL,
  PRIMARY KEY (`pla_id`) USING BTREE
);

-- ----------------------------
-- Records of live_player
-- ----------------------------
INSERT INTO `live_player` VALUES (1, '蔡徐坤', 23);
INSERT INTO `live_player` VALUES (2, '吴亦凡', 21);
INSERT INTO `live_player` VALUES (3, '李金章', 13);
INSERT INTO `live_player` VALUES (4, '阿布都诺', 100);
