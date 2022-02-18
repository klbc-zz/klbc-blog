/*
 Navicat MySQL Data Transfer

 Source Server         : python_book_m
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : nblog

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 18/02/2022 16:03:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `id` bigint(20) NOT NULL,
  `category_id` bigint(20) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1493470315022430209, NULL, '测试一则', 'aaaaaabbb  这是一个测试   二级标题  \n  一级标题\n^上角标^~下角标~\n> 段落引用\n搜索\n\n> 段落引用2\n\nsdasdsa![wl.jpg](http://localhost:8096/api/resource/QIXSmOkt.jpg)...', 'aaaaaabbb**这是一个测试## 二级标题**\n# 一级标题\n^上角标^~下角标~\n> 段落引用\n搜索\n\n> 段落引用2\n\nsdasdsa![wl.jpg](http://localhost:8096/api/resource/QIXSmOkt.jpg)', NULL, NULL, NULL, NULL);
INSERT INTO `article` VALUES (1493506254528622594, NULL, '这是第二篇文章', '第二\nsssaa aaaaa \n![qqqq.png](http://localhost:8095/api/resource/MKCOOOsw.png)...', '第二\nsssaa*aaaaa*\n![qqqq.png](http://localhost:8095/api/resource/MKCOOOsw.png)', NULL, NULL, NULL, NULL);
INSERT INTO `article` VALUES (1493508627883929601, NULL, '这是中文', '升大...', '升大', NULL, NULL, NULL, NULL);
INSERT INTO `article` VALUES (1494185050281906177, NULL, '我的第三篇测试', '  这是第三  篇文章  \n 前言 \n好好学习，天天向上\n![megabfl.jpg](http://localhost:8096/api/resource/TnBkaRsT.jpg)\n> 段落引用\n\nss\n   暴飞龙\n暴飞龙，也叫暴蝾螈，日本任天堂公司发行的掌机游戏系列《精灵宝可梦》（国内常称“口袋妖怪”）中登场精灵的一种，首次出现于第三世代游戏《精灵宝可梦：红宝石/蓝宝石》。\n经过长久的岁月，身体的细胞发生突变，而长出了翅膀。一旦发怒就会忘我地发狂\n> \n![yls.jpg](http:/...', '# 这是第三**篇文章**\n*前言*\n好好学习，天天向上\n![megabfl.jpg](http://localhost:8096/api/resource/TnBkaRsT.jpg)\n> 段落引用\n\nss\n## 暴飞龙\n暴飞龙，也叫暴蝾螈，日本任天堂公司发行的掌机游戏系列《精灵宝可梦》（国内常称“口袋妖怪”）中登场精灵的一种，首次出现于第三世代游戏《精灵宝可梦：红宝石/蓝宝石》。\n经过长久的岁月，身体的细胞发生突变，而长出了翅膀。一旦发怒就会忘我地发狂\n> \n![yls.jpg](http://localhost:8096/api/resource/ZQwRAoXo.jpg)\n## 圆陆鲨\n圆陆鲨，是在日本任天堂株式会社开发的掌机游戏《宝可梦》系列和根据它改编的动画中登场的宝可梦中的一种。全国图鉴编号443。过去是生活在热带地区，为了躲避寒冷居住在有地热的温暖洞窟里。圆陆鲨是第四世代准神兽烈咬陆鲨的未进化形。\n\n', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for article_images
-- ----------------------------
DROP TABLE IF EXISTS `article_images`;
CREATE TABLE `article_images`  (
  `id` bigint(20) NOT NULL,
  `article_id` bigint(20) NULL DEFAULT NULL,
  `image_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `image_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `base64_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `system_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` bigint(20) NULL DEFAULT NULL,
  `create_time` date NULL DEFAULT NULL,
  `update_by` bigint(20) NULL DEFAULT NULL,
  `update_time` date NULL DEFAULT NULL,
  `front_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of article_images
-- ----------------------------
INSERT INTO `article_images` VALUES (1493511572390260738, 1493506254528622594, 'ITltBRBJnull', 'image/jpeg', NULL, '/ITltBRBJnull', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `article_images` VALUES (1493512034447372290, 1493506254528622594, 'DXNjNWFxnull', 'image/jpeg', NULL, '/DXNjNWFxnull', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `article_images` VALUES (1493513164019515393, 1493506254528622594, 'noodbImgllNmFEtHnull', 'image/jpeg', NULL, '/noodbImgllNmFEtHnull', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `article_images` VALUES (1493514139182583810, 1493506254528622594, 'HrACMyHtnull', 'image/jpeg', NULL, '/noodbImg/HrACMyHtnull', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `article_images` VALUES (1493794734462820353, 1493506254528622594, 'XgaZDsXhnull', 'image/jpeg', NULL, '/noodbImg/XgaZDsXhnull', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `article_images` VALUES (1493800085333602306, 1493506254528622594, 'jvXBTwDqnull', 'image/jpeg', NULL, '/noodbImg/jvXBTwDqnull', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `article_images` VALUES (1493806047641595906, 1493506254528622594, 'gErflXfV.png', 'image/png', NULL, '/noodbImg/gErflXfV.png', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `article_images` VALUES (1493810513971355650, 1493506254528622594, 'EeUBRFKP.png', 'image/png', NULL, '/noodbImg/EeUBRFKP.png', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `article_images` VALUES (1493844138943074305, 1493506254528622594, 'gwhWgmfp.png', 'image/png', NULL, '/noodbImg/gwhWgmfp.png', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `article_images` VALUES (1493844688652840961, 1493506254528622594, 'MKCOOOsw.png', 'image/png', NULL, '/noodbImg/MKCOOOsw.png', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `article_images` VALUES (1493844890428223489, 1493470315022430209, 'QIXSmOkt.jpg', 'image/jpeg', NULL, '/noodbImg/QIXSmOkt.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `article_images` VALUES (1494185019155976194, NULL, 'TnBkaRsT.jpg', 'image/jpeg', NULL, '/noodbImg/TnBkaRsT.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `article_images` VALUES (1494299106162544641, 1494185050281906177, 'ZQwRAoXo.jpg', 'image/jpeg', NULL, '/noodbImg/ZQwRAoXo.jpg', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pid` bigint(20) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for common_field
-- ----------------------------
DROP TABLE IF EXISTS `common_field`;
CREATE TABLE `common_field`  (
  `create_by` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_by` bigint(20) NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of common_field
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'klbc', '$2a$10$my3PNuFfpEWdsrqvMqZ0t.3f.yopzofXWn57YHn8ybj54OE3JBxpG');
INSERT INTO `user` VALUES (2, 'qwewqew', 'ss');

SET FOREIGN_KEY_CHECKS = 1;
