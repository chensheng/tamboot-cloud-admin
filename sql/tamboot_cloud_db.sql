/*
Navicat MySQL Data Transfer

Source Server         : local-db
Source Server Version : 50719
Source Host           : 127.0.0.1:3306
Source Database       : tamboot_cloud_db

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-07-17 15:39:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for system_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu` (
  `id` bigint(20) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` int(11) DEFAULT NULL,
  `path` varchar(64) DEFAULT NULL,
  `locale` varchar(128) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `parent` bigint(20) DEFAULT NULL,
  `order_index` int(5) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_menu
-- ----------------------------
INSERT INTO `system_menu` VALUES ('6533916193823133696', '7', '2019-05-14 12:10:14', '1', '2019-05-16 11:23:41', '1', '/system', null, '系统配置', 'setting', null, '0');
INSERT INTO `system_menu` VALUES ('6533916677858398211', '19', '2019-05-14 12:12:10', '1', '2019-06-02 01:04:51', '1', '/system/menu', null, '菜单管理', null, '6533916193823133696', '2');
INSERT INTO `system_menu` VALUES ('6533916797031157764', '8', '2019-05-14 12:12:38', '1', '2019-06-02 01:04:56', '1', '/system/role', null, '角色管理', null, '6533916193823133696', '3');
INSERT INTO `system_menu` VALUES ('6533917218659373061', '10', '2019-05-14 12:14:19', '1', '2019-06-02 22:18:26', '1', '/user', null, '用户中心', 'user', null, '2');
INSERT INTO `system_menu` VALUES ('6533917345537069062', '3', '2019-05-14 12:14:49', '1', '2019-06-02 22:39:47', '1', '/user/password', null, '修改密码', null, '6533917218659373061', '0');
INSERT INTO `system_menu` VALUES ('6536608913624666112', '2', '2019-05-21 22:30:09', '1', '2019-06-02 01:04:59', '1', '/system/permission', null, '访问权限', null, '6533916193823133696', '4');
INSERT INTO `system_menu` VALUES ('6536612123282247681', '1', '2019-05-21 22:42:54', '1', '2019-06-02 01:04:39', '1', '/system/user', null, '用户管理', null, '6533916193823133696', '1');
INSERT INTO `system_menu` VALUES ('6541132351248797696', '0', '2019-06-03 10:04:40', '1', null, null, '/frontdocs', null, '前端文档', 'read', null, '3');
INSERT INTO `system_menu` VALUES ('6541132579280523265', '2', '2019-06-03 10:05:35', '1', '2019-06-04 14:33:49', '1', '/frontdocs/pageviewdoc', null, '分页组件', null, '6541132351248797696', '2');
INSERT INTO `system_menu` VALUES ('6541279034167267328', '1', '2019-06-03 19:47:32', '1', '2019-06-04 14:33:46', '1', '/frontdocs/quickstartdoc', null, '快速上手', null, '6541132351248797696', '1');
INSERT INTO `system_menu` VALUES ('6541562553728765952', '1', '2019-06-04 14:34:09', '1', '2019-06-04 16:04:28', '1', 'https://ant.design/docs/react/introduce-cn', null, 'Ant Design', null, '6541132351248797696', '6');
INSERT INTO `system_menu` VALUES ('6541585418129772545', '0', '2019-06-04 16:05:00', '1', null, null, '/frontdocs/createmodaldoc', null, '新建模态框', null, '6541132351248797696', '3');
INSERT INTO `system_menu` VALUES ('6541595299213742082', '0', '2019-06-04 16:44:16', '1', null, null, '/frontdocs/updatemodaldoc', null, '修改模态框', null, '6541132351248797696', '4');
INSERT INTO `system_menu` VALUES ('6541599417676337155', '0', '2019-06-04 17:00:38', '1', null, null, '/backdocs', null, '后端文档', 'read', null, '4');
INSERT INTO `system_menu` VALUES ('6541600006372069380', '0', '2019-06-04 17:02:58', '1', null, null, '/backdocs/quickstartdoc', null, '快速上手', null, '6541599417676337155', '1');
INSERT INTO `system_menu` VALUES ('6541630552024289280', '0', '2019-06-04 19:04:21', '1', null, null, 'https://github.com/chensheng/tamboot-admin-front', null, 'Github源码', null, '6541132351248797696', '5');
INSERT INTO `system_menu` VALUES ('6542019431285919744', '1', '2019-06-05 20:49:37', '1', '2019-06-07 22:22:22', '1', '/backdocs/codespecdoc', null, '编码规范', null, '6541599417676337155', '2');
INSERT INTO `system_menu` VALUES ('6543049996546084864', '1', '2019-06-08 17:04:43', '1', '2019-06-08 17:26:16', '1', '/backdocs/apiresponsedoc', null, '接口格式', null, '6541599417676337155', '3');
INSERT INTO `system_menu` VALUES ('6543076108609261569', '3', '2019-06-08 18:48:28', '1', '2019-06-09 13:03:45', '1', '/backdocs/advancedconfigdoc', null, '高级配置', null, '6541599417676337155', '5');
INSERT INTO `system_menu` VALUES ('6543352351741186048', '2', '2019-06-09 13:06:10', '1', '2019-06-09 19:24:36', '1', '/backdocs/mapperspecdoc', null, 'Mapper用法', null, '6541599417676337155', '4');
INSERT INTO `system_menu` VALUES ('6543441399805644801', '0', '2019-06-09 19:00:00', '1', null, null, 'https://github.com/chensheng/tamboot-admin-back', null, 'Github源码', null, '6541599417676337155', '6');
INSERT INTO `system_menu` VALUES ('6543445909932347394', '2', '2019-06-09 19:17:56', '1', '2019-06-09 19:21:20', '1', 'https://github.com/chensheng/tamboot', null, 'Tamboot', null, '6541599417676337155', '7');
INSERT INTO `system_menu` VALUES ('6543446417195667459', '0', '2019-06-09 19:19:57', '1', null, null, 'https://spring.io/projects/spring-boot', null, 'Spring Boot', null, '6541599417676337155', '9');

-- ----------------------------
-- Table structure for system_permission
-- ----------------------------
DROP TABLE IF EXISTS `system_permission`;
CREATE TABLE `system_permission` (
  `id` bigint(20) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` int(11) DEFAULT NULL,
  `url` varchar(64) DEFAULT NULL,
  `roles` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_permission
-- ----------------------------
INSERT INTO `system_permission` VALUES ('1', '3', null, null, '2019-06-09 19:29:32', '1', '/user/**', 'MANAGER,USER');
INSERT INTO `system_permission` VALUES ('2', '0', null, null, null, null, '/system/**', 'MANAGER');
INSERT INTO `system_permission` VALUES ('3', '0', null, null, null, null, '/**', 'MANAGER');

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `id` bigint(20) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` int(11) DEFAULT NULL,
  `role_code` varchar(16) DEFAULT NULL,
  `role_name` varchar(32) DEFAULT NULL,
  `role_desc` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_role_code` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES ('1', '0', null, null, '2019-06-02 17:03:25', '1', 'MANAGER', '管理员', '进行系统的日常运维');
INSERT INTO `system_role` VALUES ('2', '0', '2019-05-13 17:37:13', '1', null, null, 'USER', '用户', '普通用户');

-- ----------------------------
-- Table structure for system_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_role_menu`;
CREATE TABLE `system_role_menu` (
  `id` bigint(20) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` int(11) DEFAULT NULL,
  `role_code` varchar(16) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_role_menu
-- ----------------------------
INSERT INTO `system_role_menu` VALUES ('6533981267954765825', '0', '2019-05-14 16:28:49', '1', null, null, 'MANAGER', '6533916193823133696');
INSERT INTO `system_role_menu` VALUES ('6533981267984125954', '0', '2019-05-14 16:28:49', '1', null, null, 'MANAGER', '6533916677858398211');
INSERT INTO `system_role_menu` VALUES ('6533981268063817732', '0', '2019-05-14 16:28:49', '1', null, null, 'MANAGER', '6533916797031157764');
INSERT INTO `system_role_menu` VALUES ('6533981268088983557', '0', '2019-05-14 16:28:49', '1', null, null, 'MANAGER', '6533917345537069062');
INSERT INTO `system_role_menu` VALUES ('6533981268114149382', '0', '2019-05-14 16:28:49', '1', null, null, 'MANAGER', '6533917218659373061');
INSERT INTO `system_role_menu` VALUES ('6536481623137849344', '0', '2019-05-21 14:04:20', '1', null, null, 'USER', '6533917345537069062');
INSERT INTO `system_role_menu` VALUES ('6536481623225929729', '0', '2019-05-21 14:04:20', '1', null, null, 'USER', '6533917218659373061');
INSERT INTO `system_role_menu` VALUES ('6536609193594458112', '0', '2019-05-21 22:31:16', '1', null, null, 'MANAGER', '6536608913624666112');
INSERT INTO `system_role_menu` VALUES ('6538684744446513161', '0', '2019-05-27 15:58:45', '1', null, null, 'USER', '6533916193823133696');
INSERT INTO `system_role_menu` VALUES ('6540485233114877952', '0', '2019-06-01 15:13:15', '1', null, null, 'MANAGER', '6536612123282247681');
INSERT INTO `system_role_menu` VALUES ('6540856008242106372', '0', '2019-06-02 15:46:35', '1', null, null, 'USER', '6533916797031157764');
INSERT INTO `system_role_menu` VALUES ('6541132633567399936', '0', '2019-06-03 10:05:48', '1', null, null, 'MANAGER', '6541132351248797696');
INSERT INTO `system_role_menu` VALUES ('6541132633596760065', '0', '2019-06-03 10:05:48', '1', null, null, 'MANAGER', '6541132579280523265');
INSERT INTO `system_role_menu` VALUES ('6541279115025059840', '0', '2019-06-03 19:47:52', '1', null, null, 'MANAGER', '6541279034167267328');
INSERT INTO `system_role_menu` VALUES ('6541562618451070976', '0', '2019-06-04 14:34:24', '1', null, null, 'MANAGER', '6541562553728765952');
INSERT INTO `system_role_menu` VALUES ('6541585459720491009', '0', '2019-06-04 16:05:10', '1', null, null, 'MANAGER', '6541585418129772545');
INSERT INTO `system_role_menu` VALUES ('6541595421590949890', '0', '2019-06-04 16:44:45', '1', null, null, 'MANAGER', '6541595299213742082');
INSERT INTO `system_role_menu` VALUES ('6541600048646459395', '0', '2019-06-04 17:03:08', '1', null, null, 'MANAGER', '6541600006372069380');
INSERT INTO `system_role_menu` VALUES ('6541600048680013828', '0', '2019-06-04 17:03:08', '1', null, null, 'MANAGER', '6541599417676337155');
INSERT INTO `system_role_menu` VALUES ('6541630603253518336', '0', '2019-06-04 19:04:33', '1', null, null, 'MANAGER', '6541630552024289280');
INSERT INTO `system_role_menu` VALUES ('6542019458066550784', '0', '2019-06-05 20:49:43', '1', null, null, 'MANAGER', '6542019431285919744');
INSERT INTO `system_role_menu` VALUES ('6543050067832475648', '0', '2019-06-08 17:05:00', '1', null, null, 'MANAGER', '6543049996546084864');
INSERT INTO `system_role_menu` VALUES ('6543076158919938049', '0', '2019-06-08 18:48:40', '1', null, null, 'MANAGER', '6543076108609261569');
INSERT INTO `system_role_menu` VALUES ('6543352466006609920', '0', '2019-06-09 13:06:37', '1', null, null, 'MANAGER', '6543352351741186048');
INSERT INTO `system_role_menu` VALUES ('6543441453069111297', '0', '2019-06-09 19:00:13', '1', null, null, 'MANAGER', '6543441399805644801');
INSERT INTO `system_role_menu` VALUES ('6543445953142067202', '0', '2019-06-09 19:18:06', '1', null, null, 'MANAGER', '6543445909932347394');
INSERT INTO `system_role_menu` VALUES ('6543446445805015043', '0', '2019-06-09 19:20:04', '1', null, null, 'MANAGER', '6543446417195667459');

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` bigint(20) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('1', '0', null, null, '2019-06-02 22:43:43', '1', 'admin', '{bcrypt}$2a$10$XlxuthlC.aiqv4FQ0vk8N.2ECtkg4.4dKrAsRN9upqDLY5Or.YZja', '1');
INSERT INTO `system_user` VALUES ('2', '0', null, null, '2019-06-02 12:56:17', '1', 'user', '{bcrypt}$2a$10$3lRGVEr06pErbsUxDqh1JeNocMA.pn/9SrRbS4WfyrZgXqRC87tyO', '0');

-- ----------------------------
-- Table structure for system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role`;
CREATE TABLE `system_user_role` (
  `id` bigint(20) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `creator` int(11) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `role_code` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_user_role
-- ----------------------------
INSERT INTO `system_user_role` VALUES ('6540626859242033153', '0', '2019-06-02 00:36:02', '1', null, null, '2', 'USER');
INSERT INTO `system_user_role` VALUES ('6540633650185113600', '0', '2019-06-02 01:03:01', '1', null, null, '1', 'MANAGER');
