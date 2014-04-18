/*
Navicat MySQL Data Transfer

Source Server         : adminkiss
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : adminkiss_crm

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2014-04-18 23:02:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auth_customer`
-- ----------------------------
DROP TABLE IF EXISTS `auth_customer`;
CREATE TABLE `auth_customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cid` bigint(20) NOT NULL,
  `auth_id` bigint(20) NOT NULL,
  `record_id` bigint(20) NOT NULL DEFAULT '0',
  `last_contact_time` datetime DEFAULT NULL,
  `next_contact_id` bigint(20) DEFAULT NULL,
  `next_contact_time` datetime DEFAULT NULL,
  `contact_count` int(11) NOT NULL DEFAULT '0',
  `star` tinyint(4) NOT NULL DEFAULT '0' COMMENT '客�',
  `importance` tinyint(4) NOT NULL DEFAULT '0' COMMENT '重要程度(0:一般1:重要)',
  `ctype` tinyint(4) NOT NULL DEFAULT '0' COMMENT '客户类型',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '关系状态(0:无效1:有效)',
  `created_time` datetime NOT NULL,
  `last_modifield_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `cid_uid_UNIQUE` (`cid`,`auth_id`),
  KEY `idx_auth_id` (`auth_id`),
  KEY `idx_cid` (`cid`),
  KEY `idx_status` (`status`),
  KEY `idx_star` (`star`),
  KEY `idx_contact_count` (`contact_count`),
  CONSTRAINT `fk_auth_customer1` FOREIGN KEY (`cid`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_auth_customer2` FOREIGN KEY (`auth_id`) REFERENCES `sys_account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_customer
-- ----------------------------

-- ----------------------------
-- Table structure for `contact_record`
-- ----------------------------
DROP TABLE IF EXISTS `contact_record`;
CREATE TABLE `contact_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cid` bigint(20) NOT NULL,
  `ccid` bigint(20) NOT NULL,
  `contact_type` tinyint(4) NOT NULL COMMENT '通话类型(1:呼入;2:呼出)',
  `contact_status` tinyint(4) NOT NULL COMMENT '通话结果（1：有效联系，2：无人接听，3：停机，4：关机，5：空号）',
  `content` text NOT NULL,
  `attachment` varchar(1000) DEFAULT NULL,
  `auth_id` bigint(20) NOT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_contact_record1_idx` (`cid`),
  KEY `fk_contact_record2_idx` (`ccid`),
  KEY `idx_contact_status` (`contact_status`),
  CONSTRAINT `fk_contact_record1` FOREIGN KEY (`cid`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_contact_record2` FOREIGN KEY (`ccid`) REFERENCES `customer_contact` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contact_record
-- ----------------------------

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `store_library` tinyint(4) NOT NULL DEFAULT '0' COMMENT '公司所在库(0:垃圾库;1:资源库;2:公海库;3:个人库;4:服务库)',
  `repeat_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '重复公司ID(存有效公司ID,0为无重复客户)',
  `sources` tinyint(4) NOT NULL COMMENT '信息来源',
  `integrity` int(11) NOT NULL DEFAULT '0' COMMENT '信息完整度（100分制）',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '客户状态(0:初始状态;1:正常状态;2:删除状态)',
  `company_name` varchar(255) NOT NULL,
  `industry` varchar(255) DEFAULT NULL,
  `company_scope` tinyint(4) DEFAULT NULL,
  `company_type` tinyint(4) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `area_code` varchar(40) DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `tags` varchar(1000) DEFAULT NULL,
  `website` varchar(1000) DEFAULT NULL,
  `profile` text,
  `created_uid` bigint(20) NOT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idx_store_library` (`store_library`),
  KEY `idx_repeat_id` (`repeat_id`),
  KEY `idx_status` (`status`),
  KEY `idx_integrity` (`integrity`),
  KEY `idx_created_uid` (`created_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------

-- ----------------------------
-- Table structure for `customer_buy_product`
-- ----------------------------
DROP TABLE IF EXISTS `customer_buy_product`;
CREATE TABLE `customer_buy_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cid` bigint(20) NOT NULL,
  `pid` bigint(20) NOT NULL,
  `discount` int(2) NOT NULL DEFAULT '10',
  `cheap` decimal(20,2) NOT NULL,
  `price` decimal(20,2) NOT NULL,
  `pay_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:未付款，1：客户已付款，等待财务审核，2：财务已收款，3：收款失败',
  `warranty_start_time` date DEFAULT NULL COMMENT '保修时间',
  `warranty_end_time` date DEFAULT NULL COMMENT '保修结束时间',
  `warranty_count` int(11) NOT NULL DEFAULT '0' COMMENT '保修次数',
  `auth_id` bigint(20) NOT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_customer_buy_product1_idx` (`cid`),
  KEY `fk_customer_buy_product2_idx` (`pid`),
  KEY `idx_auth_id` (`auth_id`),
  CONSTRAINT `fk_customer_buy_product1` FOREIGN KEY (`cid`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_buy_product2` FOREIGN KEY (`pid`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_buy_product
-- ----------------------------

-- ----------------------------
-- Table structure for `customer_contact`
-- ----------------------------
DROP TABLE IF EXISTS `customer_contact`;
CREATE TABLE `customer_contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cid` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `sex` tinyint(4) NOT NULL DEFAULT '0',
  `mobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `profile` varchar(1000) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '联系人状态(0：初始，1：正常，2：离职，3:删除)',
  `created_uid` bigint(4) NOT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_contact1_idx` (`cid`),
  KEY `idx_status` (`status`),
  CONSTRAINT `fk_contact1` FOREIGN KEY (`cid`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_contact
-- ----------------------------

-- ----------------------------
-- Table structure for `customer_range`
-- ----------------------------
DROP TABLE IF EXISTS `customer_range`;
CREATE TABLE `customer_range` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `option_type` tinyint(4) NOT NULL COMMENT '操作类型(1代表新增，2代表修改，3代表删除)',
  `cid` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_customer_range1_idx` (`cid`),
  CONSTRAINT `fk_customer_range1` FOREIGN KEY (`cid`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_range
-- ----------------------------

-- ----------------------------
-- Table structure for `customer_tags`
-- ----------------------------
DROP TABLE IF EXISTS `customer_tags`;
CREATE TABLE `customer_tags` (
  `id` varchar(40) NOT NULL,
  `color` varchar(45) NOT NULL,
  `name` varchar(255) NOT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_tags
-- ----------------------------

-- ----------------------------
-- Table structure for `email_record`
-- ----------------------------
DROP TABLE IF EXISTS `email_record`;
CREATE TABLE `email_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cid` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0：未发送，1：发送中，2：发送成功，3：发送失败',
  `created_uid` bigint(20) NOT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_email_record1_idx` (`cid`),
  CONSTRAINT `fk_email_record1` FOREIGN KEY (`cid`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of email_record
-- ----------------------------

-- ----------------------------
-- Table structure for `problem_order`
-- ----------------------------
DROP TABLE IF EXISTS `problem_order`;
CREATE TABLE `problem_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cid` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `situation` text NOT NULL,
  `urgency` tinyint(4) NOT NULL COMMENT '紧急程度（0：不紧急，1：紧急，2：十万火急）',
  `auth_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '处理中',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0：未分配，1：已分配，2：处理中，3：已处理，4：问题关闭',
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_problem_order1_idx` (`cid`),
  KEY `idx_status` (`status`),
  CONSTRAINT `fk_problem_order1` FOREIGN KEY (`cid`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of problem_order
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '产品名称',
  `quantity` int(11) NOT NULL,
  `quantity_unit` varchar(255) DEFAULT NULL,
  `price` decimal(20,2) NOT NULL,
  `price_unit` varchar(255) DEFAULT NULL,
  `property` text NOT NULL COMMENT '附加属性',
  `profile` text NOT NULL COMMENT '产品描述',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0：未上架，1：正常，2：已下架',
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for `repeat_order`
-- ----------------------------
DROP TABLE IF EXISTS `repeat_order`;
CREATE TABLE `repeat_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `repeat_ids` varchar(1000) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '审核状态(0:初始,1:已审核,2:取消审核)',
  `created_uid` bigint(20) NOT NULL,
  `check_uid` bigint(20) DEFAULT NULL,
  `repeat_id` bigint(20) DEFAULT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repeat_order
-- ----------------------------

-- ----------------------------
-- Table structure for `resolution_order`
-- ----------------------------
DROP TABLE IF EXISTS `resolution_order`;
CREATE TABLE `resolution_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpid` bigint(20) NOT NULL,
  `start_time` datetime NOT NULL COMMENT '处理开始时间',
  `end_time` datetime NOT NULL COMMENT '处理结束时间',
  `situation` text NOT NULL,
  `resolution` text NOT NULL,
  `result_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:初始，1:已解决，2：不能解决',
  `created_uid` bigint(20) NOT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_repair_order1_idx` (`cpid`),
  CONSTRAINT `fk_repair_order1` FOREIGN KEY (`cpid`) REFERENCES `customer_buy_product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resolution_order
-- ----------------------------

-- ----------------------------
-- Table structure for `sms_record`
-- ----------------------------
DROP TABLE IF EXISTS `sms_record`;
CREATE TABLE `sms_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cid` bigint(20) NOT NULL,
  `mobile` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `status` tinyint(4) NOT NULL COMMENT '状态：0：未发送，1：发送中，2：发送成功，3：发送失败',
  `created_uid` bigint(20) NOT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_sms_record1_idx` (`cid`),
  CONSTRAINT `fk_sms_record1` FOREIGN KEY (`cid`) REFERENCES `customer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sms_record
-- ----------------------------

-- ----------------------------
-- Table structure for `system_log`
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `auth_id` bigint(20) NOT NULL,
  `auth_name` varchar(255) NOT NULL,
  `log_type` tinyint(4) NOT NULL,
  `content` text NOT NULL,
  `created_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idx_log_type` (`log_type`),
  KEY `idx_auth_id` (`auth_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_log
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_account`
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `salt` varchar(64) NOT NULL,
  `name` varchar(255) NOT NULL,
  `dept_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `login_failure` int(11) NOT NULL DEFAULT '0',
  `login_time` datetime NOT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_sys_account1_idx` (`dept_id`),
  KEY `fk_sys_account2_idx` (`role_id`),
  KEY `idx_status` (`status`),
  KEY `idx_login_failure` (`login_failure`),
  CONSTRAINT `fk_sys_account1` FOREIGN KEY (`dept_id`) REFERENCES `sys_dept` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sys_account2` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_account
-- ----------------------------
INSERT INTO `sys_account` VALUES ('1', 'xtotly@gmail.com', '066d5452f390d096661e0014eaf97852b21b2c14', '67708db9d61ba694', '系统管理员', '2', '1', '1', '0', '2014-04-18 23:00:15', '2014-04-16 19:27:45', '2014-04-18 23:00:15');

-- ----------------------------
-- Table structure for `sys_area`
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `display_name` varchar(1000) NOT NULL,
  `hot_status` tinyint(4) NOT NULL DEFAULT '0',
  `sort` int(11) NOT NULL DEFAULT '0',
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_hot_status` (`hot_status`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_area
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL,
  `remark` varchar(1000) NOT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '0', '全公司', '', '2014-04-16 19:24:35', '2014-04-16 19:24:38');
INSERT INTO `sys_dept` VALUES ('2', '1', '技术部', '', '2014-04-16 19:24:59', '2014-04-16 19:25:02');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `right_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `parent_id` bigint(20) NOT NULL DEFAULT '0',
  `menu_url` varchar(45) NOT NULL,
  `menu_css` varchar(45) NOT NULL,
  `leaf` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否有子节点（0：无，1:有）',
  `sort` int(11) NOT NULL DEFAULT '0',
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `idx_parent_id` (`parent_id`),
  KEY `fk_sys_menu1_idx` (`right_id`),
  CONSTRAINT `fk_sys_menu1` FOREIGN KEY (`right_id`) REFERENCES `sys_right` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '1', '系统管理', '0', '#', 'fa-cogs', '1', '2', '2014-04-17 22:43:59', '2014-04-17 22:44:02');
INSERT INTO `sys_menu` VALUES ('2', '1', '系统设置', '1', '/system/setting', '', '0', '1', '2014-04-17 22:48:02', '2014-04-17 22:48:04');
INSERT INTO `sys_menu` VALUES ('3', '1', '权限管理', '1', '/system/right', '', '0', '2', '2014-04-17 22:49:18', '2014-04-17 22:49:20');
INSERT INTO `sys_menu` VALUES ('4', '1', '数据字典', '1', '/system/dictionary', '', '0', '3', '2014-04-17 22:50:21', '2014-04-17 22:50:24');
INSERT INTO `sys_menu` VALUES ('5', '1', '系统恢复/备份', '1', '/system/backup', '', '0', '4', '2014-04-17 22:51:12', '2014-04-17 22:51:14');
INSERT INTO `sys_menu` VALUES ('6', '2', '用户管理', '0', '#', 'fa-sitemap', '1', '1', '2014-04-17 23:14:58', '2014-04-17 23:15:01');
INSERT INTO `sys_menu` VALUES ('7', '2', '账号管理', '6', '/user/account', '', '0', '1', '2014-04-17 23:17:12', '2014-04-17 23:17:15');
INSERT INTO `sys_menu` VALUES ('8', '2', '组织管理', '6', '/user/dept', '', '0', '2', '2014-04-17 23:18:29', '2014-04-17 23:18:32');

-- ----------------------------
-- Table structure for `sys_param`
-- ----------------------------
DROP TABLE IF EXISTS `sys_param`;
CREATE TABLE `sys_param` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_param
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_param_item`
-- ----------------------------
DROP TABLE IF EXISTS `sys_param_item`;
CREATE TABLE `sys_param_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `param_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `value` varchar(1000) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `sort` int(11) NOT NULL DEFAULT '0',
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_sys_param_item1_idx` (`param_id`),
  CONSTRAINT `fk_sys_param_item1` FOREIGN KEY (`param_id`) REFERENCES `sys_param` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_param_item
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_right`
-- ----------------------------
DROP TABLE IF EXISTS `sys_right`;
CREATE TABLE `sys_right` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `remark` varchar(100) NOT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_right
-- ----------------------------
INSERT INTO `sys_right` VALUES ('1', '系统管理', '系统管理', '2014-04-17 22:41:52', '2014-04-17 22:41:54');
INSERT INTO `sys_right` VALUES ('2', '用户管理', '用户管理', '2014-04-17 23:11:30', '2014-04-17 23:11:33');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dept_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_sys_role1_idx` (`dept_id`),
  CONSTRAINT `fk_sys_role1` FOREIGN KEY (`dept_id`) REFERENCES `sys_dept` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '2', '系统管理员', '负责系统开发，维护。', '2014-04-16 19:26:18', '2014-04-16 19:26:21');

-- ----------------------------
-- Table structure for `sys_role_right`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_right`;
CREATE TABLE `sys_role_right` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `right_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_sys_role_right1_idx` (`role_id`),
  KEY `fk_sys_role_right2_idx` (`right_id`),
  CONSTRAINT `fk_sys_role_right1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sys_role_right2` FOREIGN KEY (`right_id`) REFERENCES `sys_right` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_right
-- ----------------------------
INSERT INTO `sys_role_right` VALUES ('1', '1', '1');
INSERT INTO `sys_role_right` VALUES ('2', '1', '2');

-- ----------------------------
-- Table structure for `sys_setting`
-- ----------------------------
DROP TABLE IF EXISTS `sys_setting`;
CREATE TABLE `sys_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `system_name` varchar(255) NOT NULL COMMENT '系统名称',
  `customer_protect_time` int(11) NOT NULL DEFAULT '0' COMMENT '新客户保护时间（多久不联系掉公海）',
  `customer_max_limit` int(11) NOT NULL DEFAULT '0' COMMENT '默认开发客户上限(0表示不限制)',
  `sea_customer_time` varchar(1000) NOT NULL,
  `backup_time` tinyint(11) NOT NULL COMMENT '备份类型(1:手动,2:每天备份一次,3:每周备份一次,4:每月备份一次)',
  `last_backup_time` datetime NOT NULL COMMENT '最后备份时间',
  `last_restore_time` datetime NOT NULL COMMENT '最后回复时间',
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_setting
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_url`
-- ----------------------------
DROP TABLE IF EXISTS `sys_url`;
CREATE TABLE `sys_url` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `right_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `right_url` varchar(1000) NOT NULL,
  `created_time` datetime NOT NULL,
  `last_modified_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_sys_url1_idx` (`right_id`),
  CONSTRAINT `fk_sys_url1` FOREIGN KEY (`right_id`) REFERENCES `sys_right` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_url
-- ----------------------------
INSERT INTO `sys_url` VALUES ('1', '1', '系统管理', '/system/*', '2014-04-17 22:42:42', '2014-04-17 22:42:44');
INSERT INTO `sys_url` VALUES ('2', '2', '用户管理', '/user/*', '2014-04-17 23:19:15', '2014-04-17 23:19:17');
