/*创建ahub数据库*/
CREATE DATABASE ahub;

/*使用ahub数据库*/
USE ahub;

/*组织表*/
DROP TABLE IF EXISTS `org_organization`;
CREATE TABLE `org_organization` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `name` VARCHAR(64) NOT NULL COMMENT '组织名',
  `address` VARCHAR(100) DEFAULT NULL COMMENT '地址',
  `code` VARCHAR(64) NOT NULL COMMENT '编号',
  `icon` VARCHAR(32) DEFAULT NULL COMMENT '图标',
  `parent_id` BIGINT(20) NOT NULL COMMENT '父级主键',
  `seq` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织表';
INSERT INTO `org_organization` VALUES ('1', '2018-07-24 15:56:37','2018-07-24 15:56:37','总经办', '余杭区', '10001', 'fi-social-windows', NULL, '0');
INSERT INTO `org_organization` VALUES ('3', '2018-07-24 15:56:37','2018-07-24 15:56:37','技术部', '余杭区', '10002', 'fi-social-github', NULL, '1');
INSERT INTO `org_organization` VALUES ('5', '2018-07-24 15:56:37','2018-07-24 15:56:37','产品部', '余杭区', '10003', 'fi-social-apple', NULL, '2');
INSERT INTO `org_organization` VALUES ('6', '2018-07-24 15:56:37','2018-07-24 15:56:37','测试组', '余杭区', '10004', 'fi-social-snapchat', '3', '0');

/*资源表*/
DROP TABLE IF EXISTS `res_resource`;
CREATE TABLE `res_resource` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `name` VARCHAR(64) NOT NULL COMMENT '资源名称',
  `url` VARCHAR(100) DEFAULT NULL COMMENT '资源路径',
  `open_mode` VARCHAR(32) DEFAULT NULL COMMENT '打开方式 ajax,iframe',
  `description` VARCHAR(255) DEFAULT NULL COMMENT '资源介绍',
  `icon` VARCHAR(32) DEFAULT NULL COMMENT '资源图标',
  `parent_id` BIGINT(20) DEFAULT NULL COMMENT '父级资源id',
  `seq` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '排序',
  `status` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '状态',
  `resource_type` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '资源类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源表';
INSERT INTO `res_resource` VALUES ('1', '2018-07-24 15:56:37','2018-07-24 15:56:37','权限管理', '', NULL, '系统管理', 'fi-folder', NULL, '0', '0', '0');
INSERT INTO `res_resource` VALUES ('11', '2018-07-24 15:56:37','2018-07-24 15:56:37','资源管理', '/resource/manager', 'ajax', '资源管理', 'fi-database', '1', '1', '0', '0');
INSERT INTO `res_resource` VALUES ('12', '2018-07-24 15:56:37','2018-07-24 15:56:37','角色管理', '/role/manager', 'ajax', '角色管理', 'fi-torso-business', '1', '2', '0', '0');
INSERT INTO `res_resource` VALUES ('13', '2018-07-24 15:56:37','2018-07-24 15:56:37','用户管理', '/user/manager', 'ajax', '用户管理', 'fi-torsos-all', '1', '3', '0', '0');
INSERT INTO `res_resource` VALUES ('14', '2018-07-24 15:56:37','2018-07-24 15:56:37','部门管理', '/organization/manager', 'ajax', '部门管理', 'fi-results-demographics', '1', '4', '0', '0');
INSERT INTO `res_resource` VALUES ('111', '2018-07-24 15:56:37','2018-07-24 15:56:37','列表', '/resource/treeGrid', 'ajax', '资源列表', 'fi-list', '11', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('112', '2018-07-24 15:56:37','2018-07-24 15:56:37','添加', '/resource/add', 'ajax', '资源添加', 'fi-page-add', '11', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('113', '2018-07-24 15:56:37','2018-07-24 15:56:37','编辑', '/resource/edit', 'ajax', '资源编辑', 'fi-page-edit', '11', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('114', '2018-07-24 15:56:37','2018-07-24 15:56:37','删除', '/resource/delete', 'ajax', '资源删除', 'fi-page-delete', '11', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('121', '2018-07-24 15:56:37','2018-07-24 15:56:37','列表', '/role/dataGrid', 'ajax', '角色列表', 'fi-list', '12', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('122', '2018-07-24 15:56:37','2018-07-24 15:56:37','添加', '/role/add', 'ajax', '角色添加', 'fi-page-add', '12', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('123', '2018-07-24 15:56:37','2018-07-24 15:56:37','编辑', '/role/edit', 'ajax', '角色编辑', 'fi-page-edit', '12', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('124', '2018-07-24 15:56:37','2018-07-24 15:56:37','删除', '/role/delete', 'ajax', '角色删除', 'fi-page-delete', '12', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('125', '2018-07-24 15:56:37','2018-07-24 15:56:37','授权', '/role/grant', 'ajax', '角色授权', 'fi-check', '12', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('131', '2018-07-24 15:56:37','2018-07-24 15:56:37','列表', '/user/dataGrid', 'ajax', '用户列表', 'fi-list', '13', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('132', '2018-07-24 15:56:37','2018-07-24 15:56:37','添加', '/user/add', 'ajax', '用户添加', 'fi-page-add', '13', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('133', '2018-07-24 15:56:37','2018-07-24 15:56:37','编辑', '/user/edit', 'ajax', '用户编辑', 'fi-page-edit', '13', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('134', '2018-07-24 15:56:37','2018-07-24 15:56:37','删除', '/user/delete', 'ajax', '用户删除', 'fi-page-delete', '13', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('141', '2018-07-24 15:56:37','2018-07-24 15:56:37','列表', '/organization/treeGrid', 'ajax', '用户列表', 'fi-list', '14', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('142', '2018-07-24 15:56:37','2018-07-24 15:56:37','添加', '/organization/add', 'ajax', '部门添加', 'fi-page-add', '14', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('143', '2018-07-24 15:56:37','2018-07-24 15:56:37','编辑', '/organization/edit', 'ajax', '部门编辑', 'fi-page-edit', '14', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('144', '2018-07-24 15:56:37','2018-07-24 15:56:37','删除', '/organization/delete', 'ajax', '部门删除', 'fi-page-delete', '14', '0', '0', '1');
INSERT INTO `res_resource` VALUES ('221', '2018-07-24 15:56:37','2018-07-24 15:56:37','日志监控', '', NULL, NULL, 'fi-folder', NULL, '2', '0', '0');
INSERT INTO `res_resource` VALUES ('222', '2018-07-24 15:56:37','2018-07-24 15:56:37','视频教程', '', NULL, NULL, 'fi-folder', NULL, '1', '0', '0');
INSERT INTO `res_resource` VALUES ('223', '2018-07-24 15:56:37','2018-07-24 15:56:37','官方网站', 'http://www.dreamlu.net/', 'iframe', NULL, 'fi-home', '222', '0', '0', '0');
INSERT INTO `res_resource` VALUES ('224', '2018-07-24 15:56:37','2018-07-24 15:56:37','jfinal视频', 'http://blog.dreamlu.net/blog/79', 'iframe', NULL, 'fi-video', '222', '1', '0', '0');
INSERT INTO `res_resource` VALUES ('226', '2018-07-24 15:56:37','2018-07-24 15:56:37','修改密码', '/user/editPwdPage', 'ajax', NULL, 'fi-unlock', NULL, '3', '0', '1');
INSERT INTO `res_resource` VALUES ('227', '2018-07-24 15:56:37','2018-07-24 15:56:37','登录日志', '/sysLog/manager', 'ajax', NULL, 'fi-info', '221', '0', '0', '0');
INSERT INTO `res_resource` VALUES ('228', '2018-07-24 15:56:37','2018-07-24 15:56:37','Druid监控', '/druid', 'iframe', NULL, 'fi-monitor', '221', '0', '0', '0');
INSERT INTO `res_resource` VALUES ('229', '2018-07-24 15:56:37','2018-07-24 15:56:37','系统图标', '/icons.html', 'ajax', NULL, 'fi-photo', '221', '0', '0', '0');

/*角色表*/
DROP TABLE IF EXISTS `acc_role`;
CREATE TABLE `acc_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `name` VARCHAR(64) NOT NULL COMMENT '角色名',
  `seq` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '排序号',
  `description` VARCHAR(255) DEFAULT NULL COMMENT '简介',
  `status` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
INSERT INTO `acc_role` VALUES ('1', '2018-07-24 15:56:37','2018-07-24 15:56:37','admin', '0', '超级管理员', '0');
INSERT INTO `acc_role` VALUES ('2', '2018-07-24 15:56:37','2018-07-24 15:56:37','de', '0', '技术部经理', '0');
INSERT INTO `acc_role` VALUES ('7', '2018-07-24 15:56:37','2018-07-24 15:56:37','pm', '0', '产品部经理', '0');
INSERT INTO `acc_role` VALUES ('8', '2018-07-24 15:56:37','2018-07-24 15:56:37','test', '0', '测试账户', '0');

/*角色资源表*/
DROP TABLE IF EXISTS `acc_role_resource`;
CREATE TABLE `acc_role_resource` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `role_id` BIGINT(20) NOT NULL COMMENT '角色id',
  `resource_id` BIGINT(20) NOT NULL COMMENT '资源id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源表';

-- ----------------------------
-- Records of acc_role_resource
-- ----------------------------
INSERT INTO `acc_role_resource` VALUES ('158','2018-07-24 15:56:37','2018-07-24 15:56:37', '3', '1');
INSERT INTO `acc_role_resource` VALUES ('159','2018-07-24 15:56:37','2018-07-24 15:56:37', '3', '11');
INSERT INTO `acc_role_resource` VALUES ('160', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '111');
INSERT INTO `acc_role_resource` VALUES ('161', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '112');
INSERT INTO `acc_role_resource` VALUES ('162', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '113');
INSERT INTO `acc_role_resource` VALUES ('163', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '114');
INSERT INTO `acc_role_resource` VALUES ('164', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '12');
INSERT INTO `acc_role_resource` VALUES ('165', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '121');
INSERT INTO `acc_role_resource` VALUES ('166', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '122');
INSERT INTO `acc_role_resource` VALUES ('167', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '123');
INSERT INTO `acc_role_resource` VALUES ('168', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '124');
INSERT INTO `acc_role_resource` VALUES ('169', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '125');
INSERT INTO `acc_role_resource` VALUES ('170', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '13');
INSERT INTO `acc_role_resource` VALUES ('171', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '131');
INSERT INTO `acc_role_resource` VALUES ('172', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '132');
INSERT INTO `acc_role_resource` VALUES ('173', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '133');
INSERT INTO `acc_role_resource` VALUES ('174', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '134');
INSERT INTO `acc_role_resource` VALUES ('175', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '14');
INSERT INTO `acc_role_resource` VALUES ('176', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '141');
INSERT INTO `acc_role_resource` VALUES ('177', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '142');
INSERT INTO `acc_role_resource` VALUES ('178', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '143');
INSERT INTO `acc_role_resource` VALUES ('179', '2018-07-24 15:56:37','2018-07-24 15:56:37','3', '144');
INSERT INTO `acc_role_resource` VALUES ('359', '2018-07-24 15:56:37','2018-07-24 15:56:37','7', '1');
INSERT INTO `acc_role_resource` VALUES ('360', '2018-07-24 15:56:37','2018-07-24 15:56:37','7', '14');
INSERT INTO `acc_role_resource` VALUES ('361', '2018-07-24 15:56:37','2018-07-24 15:56:37','7', '141');
INSERT INTO `acc_role_resource` VALUES ('362', '2018-07-24 15:56:37','2018-07-24 15:56:37','7', '142');
INSERT INTO `acc_role_resource` VALUES ('363', '2018-07-24 15:56:37','2018-07-24 15:56:37','7', '143');
INSERT INTO `acc_role_resource` VALUES ('364', '2018-07-24 15:56:37','2018-07-24 15:56:37','7', '222');
INSERT INTO `acc_role_resource` VALUES ('365', '2018-07-24 15:56:37','2018-07-24 15:56:37','7', '223');
INSERT INTO `acc_role_resource` VALUES ('366', '2018-07-24 15:56:37','2018-07-24 15:56:37','7', '224');
INSERT INTO `acc_role_resource` VALUES ('367', '2018-07-24 15:56:37','2018-07-24 15:56:37','7', '221');
INSERT INTO `acc_role_resource` VALUES ('368', '2018-07-24 15:56:37','2018-07-24 15:56:37','7', '226');
INSERT INTO `acc_role_resource` VALUES ('409', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '1');
INSERT INTO `acc_role_resource` VALUES ('410', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '11');
INSERT INTO `acc_role_resource` VALUES ('411', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '111');
INSERT INTO `acc_role_resource` VALUES ('412', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '112');
INSERT INTO `acc_role_resource` VALUES ('413', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '113');
INSERT INTO `acc_role_resource` VALUES ('414', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '114');
INSERT INTO `acc_role_resource` VALUES ('415', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '12');
INSERT INTO `acc_role_resource` VALUES ('416', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '121');
INSERT INTO `acc_role_resource` VALUES ('417', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '122');
INSERT INTO `acc_role_resource` VALUES ('418', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '123');
INSERT INTO `acc_role_resource` VALUES ('419', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '124');
INSERT INTO `acc_role_resource` VALUES ('420', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '125');
INSERT INTO `acc_role_resource` VALUES ('421', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '13');
INSERT INTO `acc_role_resource` VALUES ('422', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '131');
INSERT INTO `acc_role_resource` VALUES ('423', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '132');
INSERT INTO `acc_role_resource` VALUES ('424', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '133');
INSERT INTO `acc_role_resource` VALUES ('425', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '134');
INSERT INTO `acc_role_resource` VALUES ('426', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '14');
INSERT INTO `acc_role_resource` VALUES ('427', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '141');
INSERT INTO `acc_role_resource` VALUES ('428', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '142');
INSERT INTO `acc_role_resource` VALUES ('429', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '143');
INSERT INTO `acc_role_resource` VALUES ('430', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '144');
INSERT INTO `acc_role_resource` VALUES ('431', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '222');
INSERT INTO `acc_role_resource` VALUES ('432', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '223');
INSERT INTO `acc_role_resource` VALUES ('433', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '224');
INSERT INTO `acc_role_resource` VALUES ('434', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '221');
INSERT INTO `acc_role_resource` VALUES ('435', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '227');
INSERT INTO `acc_role_resource` VALUES ('436', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '228');
INSERT INTO `acc_role_resource` VALUES ('437', '2018-07-24 15:56:37','2018-07-24 15:56:37','2', '1');
INSERT INTO `acc_role_resource` VALUES ('438', '2018-07-24 15:56:37','2018-07-24 15:56:37','2', '13');
INSERT INTO `acc_role_resource` VALUES ('439', '2018-07-24 15:56:37','2018-07-24 15:56:37','2', '131');
INSERT INTO `acc_role_resource` VALUES ('440', '2018-07-24 15:56:37','2018-07-24 15:56:37','2', '132');
INSERT INTO `acc_role_resource` VALUES ('441', '2018-07-24 15:56:37','2018-07-24 15:56:37','2', '133');
INSERT INTO `acc_role_resource` VALUES ('442', '2018-07-24 15:56:37','2018-07-24 15:56:37','2', '222');
INSERT INTO `acc_role_resource` VALUES ('443', '2018-07-24 15:56:37','2018-07-24 15:56:37','2', '223');
INSERT INTO `acc_role_resource` VALUES ('444', '2018-07-24 15:56:37','2018-07-24 15:56:37','2', '224');
INSERT INTO `acc_role_resource` VALUES ('445', '2018-07-24 15:56:37','2018-07-24 15:56:37','2', '221');
INSERT INTO `acc_role_resource` VALUES ('446', '2018-07-24 15:56:37','2018-07-24 15:56:37','2', '227');
INSERT INTO `acc_role_resource` VALUES ('447', '2018-07-24 15:56:37','2018-07-24 15:56:37','2', '228');
INSERT INTO `acc_role_resource` VALUES ('448', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '1');
INSERT INTO `acc_role_resource` VALUES ('449', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '11');
INSERT INTO `acc_role_resource` VALUES ('450', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '111');
INSERT INTO `acc_role_resource` VALUES ('451', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '12');
INSERT INTO `acc_role_resource` VALUES ('452', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '121');
INSERT INTO `acc_role_resource` VALUES ('453', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '13');
INSERT INTO `acc_role_resource` VALUES ('454', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '131');
INSERT INTO `acc_role_resource` VALUES ('455', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '14');
INSERT INTO `acc_role_resource` VALUES ('456', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '141');
INSERT INTO `acc_role_resource` VALUES ('457', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '222');
INSERT INTO `acc_role_resource` VALUES ('458', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '223');
INSERT INTO `acc_role_resource` VALUES ('459', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '224');
INSERT INTO `acc_role_resource` VALUES ('460', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '221');
INSERT INTO `acc_role_resource` VALUES ('461', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '227');
INSERT INTO `acc_role_resource` VALUES ('462', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '228');
INSERT INTO `acc_role_resource` VALUES ('478', '2018-07-24 15:56:37','2018-07-24 15:56:37','8', '229');

/*系统日志表*/
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
   `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `user_id` BIGINT(20) DEFAULT NULL COMMENT '操作用户id',
  `opt_desc` VARCHAR(1024) DEFAULT NULL COMMENT '操作内容',
  `ip` VARCHAR(255) DEFAULT NULL COMMENT '客户端ip',
  `url` VARCHAR(128) NOT NULL COMMENT '请求路径'
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统日志表';

/*用户表*/
DROP TABLE IF EXISTS `acc_user`;
CREATE TABLE `acc_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `account` VARCHAR(64) NOT NULL COMMENT '登陆名',
  `name` VARCHAR(64) NOT NULL COMMENT '用户名',
  `salt` varchar(32) NOT NULL COMMENT '加盐',
  `password` VARCHAR(64) NOT NULL COMMENT '密码',
  `sex` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '性别',
  `age` TINYINT(2) DEFAULT '0' COMMENT '年龄',
  `phone` VARCHAR(20) DEFAULT NULL COMMENT '手机号',
  `user_type` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '用户类别',
  `status` TINYINT(2) NOT NULL DEFAULT '0' COMMENT '用户状态',
  `organization_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '所属机构',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
INSERT INTO `acc_user` VALUES ('1', '2018-07-24 15:56:37','2018-07-24 15:56:37','admin', 'admin', '9c6bdd0d12eefaf42ecf978779ac6b2a','46a9e4b7118f3a2b4c7568a26b5aefa5', '0', '25', '18707173376', '0', '0', '1');
INSERT INTO `acc_user` VALUES ('13', '2018-07-24 15:56:37','2018-07-24 15:56:37','snoopy', 'snoopy', '9c6bdd0d12eefaf42ecf978779ac6b2a','46a9e4b7118f3a2b4c7568a26b5aefa5', '0', '25', '18707173376', '1', '0', '3');
INSERT INTO `acc_user` VALUES ('14', '2018-07-24 15:56:37','2018-07-24 15:56:37','lisi', 'lisi', '9c6bdd0d12eefaf42ecf978779ac6b2a','46a9e4b7118f3a2b4c7568a26b5aefa5', '0', '25', '18707173376', '1', '0', '5');
INSERT INTO `acc_user` VALUES ('15', '2018-07-24 15:56:37','2018-07-24 15:56:37','test', 'test', '9c6bdd0d12eefaf42ecf978779ac6b2a','46a9e4b7118f3a2b4c7568a26b5aefa5', '0', '25', '18707173376', '1', '0', '6');

/*用户角色表*/
DROP TABLE IF EXISTS `acc_user_role`;
CREATE TABLE `acc_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';
INSERT INTO `acc_user_role` VALUES ('53', '2018-07-24 15:56:37','2018-07-24 15:56:37','15', '8');
INSERT INTO `acc_user_role` VALUES ('60', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '1');
INSERT INTO `acc_user_role` VALUES ('61', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '2');
INSERT INTO `acc_user_role` VALUES ('62', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '7');
INSERT INTO `acc_user_role` VALUES ('63', '2018-07-24 15:56:37','2018-07-24 15:56:37','13', '2');
INSERT INTO `acc_user_role` VALUES ('64', '2018-07-24 15:56:37','2018-07-24 15:56:37','14', '7');
INSERT INTO `acc_user_role` VALUES ('65', '2018-07-24 15:56:37','2018-07-24 15:56:37','1', '8');
