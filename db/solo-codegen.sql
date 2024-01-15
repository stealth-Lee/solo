/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50727 (5.7.27)
 Source Host           : 127.0.0.1:3306
 Source Schema         : solo-codegen

 Target Server Type    : MySQL
 Target Server Version : 50727 (5.7.27)
 File Encoding         : 65001

 Date: 05/01/2024 14:46:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gen_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_column`;
CREATE TABLE `gen_column`  (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '列id',
  `table_id` bigint(20) NULL DEFAULT NULL COMMENT '表id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列名',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列类型',
  `length` int(11) NULL DEFAULT NULL COMMENT '长度',
  `sort` int(11) NULL DEFAULT NULL COMMENT '列排序',
  `java_type` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Java类型',
  `java_field` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Java字段名',
  `java_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Java说明',
  `is_pk` bit(1) NULL DEFAULT b'0' COMMENT '是否主键[0:否 1:是]',
  `is_create` bit(1) NULL DEFAULT NULL COMMENT '是否插入字段[0:否 1:是]',
  `is_update` bit(1) NULL DEFAULT NULL COMMENT '是否更新字段[0:否 1:是]',
  `is_required` bit(1) NULL DEFAULT NULL COMMENT '是否必填字段[0:否 1:是]',
  `is_list` bit(1) NULL DEFAULT NULL COMMENT '是否列表字段[0:否 1:是]',
  `is_query` bit(1) NULL DEFAULT NULL COMMENT '是否查询字段[0:否 1:是]',
  `query_mode` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查询方式[EQ:等于 ]',
  `form_type` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表单类型',
  `dict_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除[0否 1是]',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 689 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成业务表字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_column
-- ----------------------------
INSERT INTO `gen_column` VALUES (514, 55, 'config_id', 'BIGINT(19)', NULL, 0, 'Long', 'configId', '配置id', b'1', b'0', b'1', b'1', b'0', b'0', 'eq', 'number', NULL, 'admin', '2023-11-07 15:13:01', 'admin', '2023-11-07 16:09:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (515, 55, 'name', 'VARCHAR(64)', NULL, 1, 'String', 'name', '配置名称', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-07 15:13:01', 'admin', '2023-11-07 16:09:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (516, 55, 'key', 'VARCHAR(64)', NULL, 2, 'String', 'key', '配置键', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-07 15:13:01', 'admin', '2023-11-07 16:09:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (517, 55, 'value', 'VARCHAR(512)', NULL, 3, 'String', 'value', '配置值', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, 'admin', '2023-11-07 15:13:01', 'admin', '2023-11-07 16:09:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (518, 55, 'is_sys', 'BIT(1)', NULL, 4, 'Boolean', 'isSys', '系统标识[0:否 1:是]', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'radio', NULL, 'admin', '2023-11-07 15:13:01', 'admin', '2023-11-07 16:09:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (519, 55, 'create_by', 'VARCHAR(64)', NULL, 5, 'String', 'createBy', '创建者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-07 15:13:01', 'admin', '2023-11-07 16:09:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (520, 55, 'create_time', 'DATETIME(19)', NULL, 6, 'LocalDateTime', 'createTime', '创建时间', b'0', b'0', b'0', b'1', b'1', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-07 15:13:01', 'admin', '2023-11-07 16:09:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (521, 55, 'update_by', 'VARCHAR(64)', NULL, 7, 'String', 'updateBy', '修改者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-07 15:13:01', 'admin', '2023-11-07 16:09:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (522, 55, 'update_time', 'DATETIME(19)', NULL, 8, 'LocalDateTime', 'updateTime', '修改时间', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-07 15:13:01', 'admin', '2023-11-07 16:09:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (523, 55, 'deleted', 'BIT(1)', NULL, 9, 'Boolean', 'deleted', '是否删除[0否 1是]', b'0', b'0', b'0', b'1', b'0', b'0', 'eq', 'switch', NULL, 'admin', '2023-11-07 15:13:01', 'admin', '2023-11-07 16:09:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (524, 55, 'remark', 'VARCHAR(512)', NULL, 10, 'String', 'remark', '备注', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, 'admin', '2023-11-07 15:13:01', 'admin', '2023-11-07 16:09:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (525, 56, 'type_id', 'BIGINT(19)', NULL, 0, 'Long', 'typeId', '字典类型id', b'1', b'0', b'1', b'1', b'0', b'0', 'eq', 'number', NULL, 'admin', '2023-11-08 09:09:44', 'admin', '2023-11-08 09:10:28', b'0', NULL);
INSERT INTO `gen_column` VALUES (526, 56, 'name', 'VARCHAR(32)', NULL, 1, 'String', 'name', '字典名称', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 09:09:44', 'admin', '2023-11-08 09:10:28', b'0', NULL);
INSERT INTO `gen_column` VALUES (527, 56, 'code', 'VARCHAR(32)', NULL, 2, 'String', 'code', '字典编码', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 09:09:44', 'admin', '2023-11-08 09:10:28', b'0', NULL);
INSERT INTO `gen_column` VALUES (528, 56, 'type', 'TINYINT(3)', NULL, 3, 'Integer', 'type', '字典类型[1:string 2:number 3:boolean]', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'number', NULL, 'admin', '2023-11-08 09:09:44', 'admin', '2023-11-08 09:10:28', b'0', NULL);
INSERT INTO `gen_column` VALUES (529, 56, 'status', 'BIT(1)', NULL, 4, 'Boolean', 'status', '状态[0停用 1正常]', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'switch', NULL, 'admin', '2023-11-08 09:09:44', 'admin', '2023-11-08 09:10:28', b'0', NULL);
INSERT INTO `gen_column` VALUES (530, 56, 'create_by', 'VARCHAR(64)', NULL, 5, 'String', 'createBy', '创建者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-08 09:09:44', 'admin', '2023-11-08 09:10:28', b'0', NULL);
INSERT INTO `gen_column` VALUES (531, 56, 'create_time', 'DATETIME(19)', NULL, 6, 'LocalDateTime', 'createTime', '创建时间', b'0', b'0', b'0', b'1', b'1', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-08 09:09:44', 'admin', '2023-11-08 09:10:28', b'0', NULL);
INSERT INTO `gen_column` VALUES (532, 56, 'update_by', 'VARCHAR(64)', NULL, 7, 'String', 'updateBy', '修改者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-08 09:09:44', 'admin', '2023-11-08 09:10:28', b'0', NULL);
INSERT INTO `gen_column` VALUES (533, 56, 'update_time', 'DATETIME(19)', NULL, 8, 'LocalDateTime', 'updateTime', '修改时间', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-08 09:09:44', 'admin', '2023-11-08 09:10:28', b'0', NULL);
INSERT INTO `gen_column` VALUES (534, 56, 'deleted', 'BIT(1)', NULL, 9, 'Boolean', 'deleted', '是否删除[0否 1是]', b'0', b'0', b'0', b'1', b'0', b'0', 'eq', 'switch', NULL, 'admin', '2023-11-08 09:09:44', 'admin', '2023-11-08 09:10:28', b'0', NULL);
INSERT INTO `gen_column` VALUES (535, 56, 'remark', 'VARCHAR(512)', NULL, 10, 'String', 'remark', '备注', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, 'admin', '2023-11-08 09:09:44', 'admin', '2023-11-08 09:10:28', b'0', NULL);
INSERT INTO `gen_column` VALUES (536, 57, 'data_id', 'BIGINT(19)', NULL, 0, 'Long', 'dataId', '字典数据id', b'1', b'0', b'1', b'1', b'0', b'0', 'eq', 'number', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (537, 57, 'code', 'VARCHAR(32)', NULL, 1, 'String', 'code', '字典编码', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (538, 57, 'value', 'VARCHAR(32)', NULL, 2, 'String', 'value', '字典键值', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (539, 57, 'label', 'VARCHAR(32)', NULL, 3, 'String', 'label', '字典标签', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (540, 57, 'tag_type', 'TINYINT(3)', NULL, 4, 'Integer', 'tagType', '标签类型[0:default 1:primary 2:success 3:info 4:warning 5:danger]', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'number', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (541, 57, 'tag_class', 'VARCHAR(64)', NULL, 5, 'String', 'tagClass', '标签样式', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (542, 57, 'dict_sort', 'INT(10)', NULL, 6, 'Integer', 'dictSort', '字典排序', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'number', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (543, 57, 'status', 'BIT(1)', NULL, 7, 'Boolean', 'status', '状态[0禁用 1正常]', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'switch', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (544, 57, 'create_by', 'VARCHAR(64)', NULL, 8, 'String', 'createBy', '创建者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (545, 57, 'create_time', 'DATETIME(19)', NULL, 9, 'LocalDateTime', 'createTime', '创建时间', b'0', b'0', b'0', b'1', b'1', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (546, 57, 'update_by', 'VARCHAR(64)', NULL, 10, 'String', 'updateBy', '修改者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (547, 57, 'update_time', 'DATETIME(19)', NULL, 11, 'LocalDateTime', 'updateTime', '修改时间', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (548, 57, 'deleted', 'BIT(1)', NULL, 12, 'Boolean', 'deleted', '是否删除[0否 1是]', b'0', b'0', b'0', b'1', b'0', b'0', 'eq', 'switch', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (549, 57, 'remark', 'VARCHAR(512)', NULL, 13, 'String', 'remark', '备注', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (550, 58, 'source_id', 'BIGINT(19)', NULL, 0, 'Long', 'sourceId', '数据源id', b'1', b'0', b'1', b'1', b'0', b'0', 'eq', 'number', NULL, 'admin', '2023-11-08 09:53:09', 'admin', '2023-11-08 09:53:49', b'0', NULL);
INSERT INTO `gen_column` VALUES (551, 58, 'name', 'VARCHAR(64)', 64, 1, 'String', 'name', '连接名', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 09:53:09', 'admin', '2023-12-22 14:02:24', b'0', NULL);
INSERT INTO `gen_column` VALUES (552, 58, 'url', 'VARCHAR(256)', 256, 2, 'String', 'url', '数据源URL', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'textarea', NULL, 'admin', '2023-11-08 09:53:09', 'admin', '2023-12-22 14:02:26', b'0', NULL);
INSERT INTO `gen_column` VALUES (553, 58, 'username', 'VARCHAR(64)', 64, 3, 'String', 'username', '用户名', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 09:53:09', 'admin', '2023-12-22 14:02:27', b'0', NULL);
INSERT INTO `gen_column` VALUES (554, 58, 'password', 'VARCHAR(64)', 64, 4, 'String', 'password', '密码', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 09:53:09', 'admin', '2023-12-22 14:02:28', b'0', NULL);
INSERT INTO `gen_column` VALUES (555, 58, 'create_by', 'VARCHAR(64)', 64, 5, 'String', 'createBy', '创建者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-08 09:53:09', 'admin', '2023-12-22 14:02:29', b'0', NULL);
INSERT INTO `gen_column` VALUES (556, 58, 'create_time', 'DATETIME(19)', NULL, 6, 'LocalDateTime', 'createTime', '创建时间', b'0', b'0', b'0', b'1', b'1', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-08 09:53:09', 'admin', '2023-11-08 09:53:49', b'0', NULL);
INSERT INTO `gen_column` VALUES (557, 58, 'update_by', 'VARCHAR(64)', 64, 7, 'String', 'updateBy', '修改者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-08 09:53:09', 'admin', '2023-12-22 14:02:31', b'0', NULL);
INSERT INTO `gen_column` VALUES (558, 58, 'update_time', 'DATETIME(19)', NULL, 8, 'LocalDateTime', 'updateTime', '修改时间', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-08 09:53:09', 'admin', '2023-11-08 09:53:49', b'0', NULL);
INSERT INTO `gen_column` VALUES (559, 58, 'deleted', 'BIT(1)', NULL, 9, 'Boolean', 'deleted', '是否删除[0否 1是]', b'0', b'0', b'0', b'1', b'0', b'0', 'eq', 'switch', NULL, 'admin', '2023-11-08 09:53:09', 'admin', '2023-11-08 09:53:49', b'0', NULL);
INSERT INTO `gen_column` VALUES (560, 58, 'remark', 'VARCHAR(512)', 512, 10, 'String', 'remark', '备注', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, 'admin', '2023-11-08 09:53:09', 'admin', '2023-12-22 14:02:35', b'0', NULL);
INSERT INTO `gen_column` VALUES (561, 59, 'table_id', 'BIGINT(19)', NULL, 0, 'Long', 'tableId', '业务表id', b'1', b'0', b'1', b'1', b'0', b'0', 'eq', 'number', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-11-08 10:32:52', b'0', NULL);
INSERT INTO `gen_column` VALUES (562, 59, 'source_id', 'BIGINT(19)', NULL, 1, 'Long', 'sourceId', '数据源id', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'number', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-11-08 10:32:52', b'0', NULL);
INSERT INTO `gen_column` VALUES (563, 59, 'name', 'VARCHAR(64)', 64, 2, 'String', 'name', '表名称', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-12-22 13:59:41', b'0', NULL);
INSERT INTO `gen_column` VALUES (564, 59, 'comment', 'VARCHAR(512)', 512, 3, 'String', 'comment', '表描述', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'textarea', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-12-22 13:59:48', b'0', NULL);
INSERT INTO `gen_column` VALUES (565, 59, 'author', 'VARCHAR(32)', 32, 4, 'String', 'author', '作者', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-12-22 13:59:50', b'0', NULL);
INSERT INTO `gen_column` VALUES (566, 59, 'tpl_type', 'TINYINT(3)', NULL, 5, 'Integer', 'tplType', '模版类型[1:单表结构 2:树表结构 3:主子表结构]', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'number', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-11-08 10:32:52', b'0', NULL);
INSERT INTO `gen_column` VALUES (567, 59, 'package_name', 'VARCHAR(128)', 128, 6, 'String', 'packageName', '生成包路径', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-12-22 13:59:54', b'0', NULL);
INSERT INTO `gen_column` VALUES (568, 59, 'module_name', 'VARCHAR(32)', 32, 7, 'String', 'moduleName', '生成模块名', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-12-22 13:59:55', b'0', NULL);
INSERT INTO `gen_column` VALUES (569, 59, 'business_name', 'VARCHAR(32)', 32, 8, 'String', 'businessName', '生成业务名', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-12-22 13:59:57', b'0', NULL);
INSERT INTO `gen_column` VALUES (570, 59, 'function_name', 'VARCHAR(64)', 64, 9, 'String', 'functionName', '生成功能名', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-12-22 13:59:58', b'0', NULL);
INSERT INTO `gen_column` VALUES (571, 59, 'class_name', 'VARCHAR(64)', 64, 10, 'String', 'className', '实体类名称', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-12-22 13:59:59', b'0', NULL);
INSERT INTO `gen_column` VALUES (572, 59, 'class_tail', 'VARCHAR(32)', 32, 11, 'String', 'classTail', '实体类尾巴', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-12-22 14:00:01', b'0', NULL);
INSERT INTO `gen_column` VALUES (573, 59, 'is_switch', 'BIT(1)', NULL, 12, 'Boolean', 'isSwitch', '是否启用开关按钮', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'switch', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-11-08 10:32:52', b'0', NULL);
INSERT INTO `gen_column` VALUES (574, 59, 'switch_field', 'VARCHAR(32)', 32, 13, 'String', 'switchField', '开关字段', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-12-22 14:00:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (575, 59, 'create_by', 'VARCHAR(64)', 64, 14, 'String', 'createBy', '创建者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-12-22 14:00:05', b'0', NULL);
INSERT INTO `gen_column` VALUES (576, 59, 'create_time', 'DATETIME(19)', NULL, 15, 'LocalDateTime', 'createTime', '创建时间', b'0', b'0', b'0', b'1', b'1', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-11-08 10:32:52', b'0', NULL);
INSERT INTO `gen_column` VALUES (577, 59, 'update_by', 'VARCHAR(64)', 64, 16, 'String', 'updateBy', '修改者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-12-22 14:00:07', b'0', NULL);
INSERT INTO `gen_column` VALUES (578, 59, 'update_time', 'DATETIME(19)', NULL, 17, 'LocalDateTime', 'updateTime', '修改时间', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-11-08 10:32:52', b'0', NULL);
INSERT INTO `gen_column` VALUES (579, 59, 'deleted', 'BIT(1)', NULL, 18, 'Boolean', 'deleted', '是否删除[0否 1是]', b'0', b'0', b'0', b'1', b'0', b'0', 'eq', 'switch', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-11-08 10:32:52', b'0', NULL);
INSERT INTO `gen_column` VALUES (580, 59, 'remark', 'VARCHAR(512)', 512, 19, 'String', 'remark', '备注', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, 'admin', '2023-11-08 10:32:15', 'admin', '2023-12-22 14:00:13', b'0', NULL);
INSERT INTO `gen_column` VALUES (581, 60, 'column_id', 'BIGINT(19)', NULL, 0, 'Long', 'columnId', '列id', b'1', b'0', b'1', b'1', b'0', b'0', 'eq', 'number', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-11-08 11:09:45', b'0', NULL);
INSERT INTO `gen_column` VALUES (582, 60, 'table_id', 'BIGINT(19)', NULL, 1, 'Long', 'tableId', '表id', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'number', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-11-08 11:09:45', b'0', NULL);
INSERT INTO `gen_column` VALUES (583, 60, 'name', 'VARCHAR(64)', 64, 2, 'String', 'name', '列名', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-12-22 14:00:18', b'0', NULL);
INSERT INTO `gen_column` VALUES (584, 60, 'type', 'VARCHAR(16)', 16, 3, 'String', 'type', '列类型', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-12-22 14:00:20', b'0', NULL);
INSERT INTO `gen_column` VALUES (585, 60, 'sort', 'INT(10)', NULL, 4, 'Integer', 'sort', '列排序', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'number', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-11-08 11:09:45', b'0', NULL);
INSERT INTO `gen_column` VALUES (586, 60, 'java_type', 'VARCHAR(16)', 16, 5, 'String', 'javaType', 'Java类型', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-12-22 14:00:21', b'0', NULL);
INSERT INTO `gen_column` VALUES (587, 60, 'java_field', 'VARCHAR(64)', 64, 6, 'String', 'javaField', 'Java字段名', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-12-22 14:00:22', b'0', NULL);
INSERT INTO `gen_column` VALUES (588, 60, 'java_comment', 'VARCHAR(255)', 255, 7, 'String', 'javaComment', 'Java说明', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'textarea', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-12-22 14:00:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (589, 60, 'is_pk', 'BIT(1)', NULL, 8, 'Boolean', 'isPk', '是否主键[0:否 1:是]', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'switch', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-11-08 11:09:45', b'0', NULL);
INSERT INTO `gen_column` VALUES (590, 60, 'is_create', 'BIT(1)', NULL, 9, 'Boolean', 'isCreate', '是否插入字段[0:否 1:是]', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'switch', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-11-08 11:09:45', b'0', NULL);
INSERT INTO `gen_column` VALUES (591, 60, 'is_update', 'BIT(1)', NULL, 10, 'Boolean', 'isUpdate', '是否更新字段[0:否 1:是]', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'switch', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-11-08 11:09:45', b'0', NULL);
INSERT INTO `gen_column` VALUES (592, 60, 'is_required', 'BIT(1)', NULL, 11, 'Boolean', 'isRequired', '是否必填字段[0:否 1:是]', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'switch', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-11-08 11:09:45', b'0', NULL);
INSERT INTO `gen_column` VALUES (593, 60, 'is_list', 'BIT(1)', NULL, 12, 'Boolean', 'isList', '是否列表字段[0:否 1:是]', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'switch', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-11-08 11:09:45', b'0', NULL);
INSERT INTO `gen_column` VALUES (594, 60, 'is_query', 'BIT(1)', NULL, 13, 'Boolean', 'isQuery', '是否查询字段[0:否 1:是]', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'switch', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-11-08 11:09:45', b'0', NULL);
INSERT INTO `gen_column` VALUES (595, 60, 'query_mode', 'VARCHAR(10)', 10, 14, 'String', 'queryMode', '查询方式[EQ:等于 ]', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-12-22 14:00:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (596, 60, 'form_type', 'VARCHAR(8)', 8, 15, 'String', 'formType', '表单类型', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-12-22 14:00:34', b'0', NULL);
INSERT INTO `gen_column` VALUES (597, 60, 'dict_code', 'VARCHAR(32)', 32, 16, 'String', 'dictCode', '字典', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-12-22 14:00:36', b'0', NULL);
INSERT INTO `gen_column` VALUES (598, 60, 'create_by', 'VARCHAR(64)', 64, 17, 'String', 'createBy', '创建者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-12-22 14:00:38', b'0', NULL);
INSERT INTO `gen_column` VALUES (599, 60, 'create_time', 'DATETIME(19)', NULL, 18, 'LocalDateTime', 'createTime', '创建时间', b'0', b'0', b'0', b'1', b'1', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-11-08 11:09:45', b'0', NULL);
INSERT INTO `gen_column` VALUES (600, 60, 'update_by', 'VARCHAR(64)', 64, 19, 'String', 'updateBy', '修改者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-12-22 14:00:40', b'0', NULL);
INSERT INTO `gen_column` VALUES (601, 60, 'update_time', 'DATETIME(19)', NULL, 20, 'LocalDateTime', 'updateTime', '修改时间', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-11-08 11:09:45', b'0', NULL);
INSERT INTO `gen_column` VALUES (602, 60, 'deleted', 'BIT(1)', NULL, 21, 'Boolean', 'deleted', '是否删除[0否 1是]', b'0', b'0', b'0', b'1', b'0', b'0', 'eq', 'switch', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-11-08 11:09:45', b'0', NULL);
INSERT INTO `gen_column` VALUES (603, 60, 'remark', 'VARCHAR(512)', 512, 22, 'String', 'remark', '备注', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, 'admin', '2023-11-08 11:08:36', 'admin', '2023-12-22 14:00:44', b'0', NULL);
INSERT INTO `gen_column` VALUES (604, 61, 'menu_id', 'BIGINT(19)', NULL, 0, 'Long', 'menuId', 'id', b'1', b'0', b'1', b'1', b'0', b'0', 'eq', 'number', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (605, 61, 'parent_id', 'BIGINT(19)', NULL, 1, 'Long', 'parentId', '父级id', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'number', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (606, 61, 'type', 'CHAR(1)', NULL, 2, 'String', 'type', '菜单类型[M:菜单 B:按钮]', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (607, 61, 'name', 'VARCHAR(32)', NULL, 3, 'String', 'name', '菜单名称', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (608, 61, 'icon', 'VARCHAR(255)', NULL, 4, 'String', 'icon', '菜单图标', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'textarea', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (609, 61, 'path', 'VARCHAR(128)', NULL, 5, 'String', 'path', '路由地址', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (610, 61, 'permission', 'VARCHAR(32)', NULL, 6, 'String', 'permission', '权限标识', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (611, 61, 'visible', 'BIT(1)', NULL, 7, 'Boolean', 'visible', '是否可见[0:否 1:是]', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'switch', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (612, 61, 'keep_alive', 'BIT(1)', NULL, 8, 'Boolean', 'keepAlive', '是否缓存[0:否 1:是]', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'switch', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (613, 61, 'sort', 'INT(10)', NULL, 9, 'Integer', 'sort', '菜单排序', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'number', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (614, 61, 'create_by', 'VARCHAR(64)', NULL, 10, 'String', 'createBy', '创建者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (615, 61, 'create_time', 'DATETIME(19)', NULL, 11, 'LocalDateTime', 'createTime', '创建时间', b'0', b'0', b'0', b'1', b'1', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (616, 61, 'update_by', 'VARCHAR(64)', NULL, 12, 'String', 'updateBy', '修改者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (617, 61, 'update_time', 'DATETIME(19)', NULL, 13, 'LocalDateTime', 'updateTime', '修改时间', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'dateTime', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (618, 61, 'deleted', 'BIT(1)', NULL, 14, 'Boolean', 'deleted', '是否删除[0否 1是]', b'0', b'0', b'0', b'1', b'0', b'0', 'eq', 'switch', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (619, 61, 'remark', 'VARCHAR(512)', NULL, 15, 'String', 'remark', '备注', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_column` VALUES (640, 63, 'operate_id', 'BIGINT(19)', NULL, 0, 'Long', 'operateId', 'id', b'1', b'0', b'1', b'1', b'0', b'0', 'eq', 'number', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (641, 63, 'title', 'VARCHAR(32)', NULL, 1, 'String', 'title', '日志标题', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (642, 63, 'type', 'TINYINT(3)', NULL, 2, 'Integer', 'type', '日志类型[0其它 1新增 2删除 3修改 4查询 5导入 6导出]', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'select', 'logger_type', '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (643, 63, 'method', 'VARCHAR(64)', NULL, 3, 'String', 'method', '方法名称', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (644, 63, 'request_url', 'VARCHAR(255)', NULL, 4, 'String', 'requestUrl', '请求地址', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (645, 63, 'request_method', 'VARCHAR(32)', NULL, 5, 'String', 'requestMethod', '请求方式', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'input', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (646, 63, 'request_data', 'VARCHAR(2000)', NULL, 6, 'String', 'requestData', '请求数据', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (647, 63, 'response_data', 'VARCHAR(2000)', NULL, 7, 'String', 'responseData', '响应数据', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (648, 63, 'exception_info', 'TEXT(21845)', NULL, 8, 'String', 'exceptionInfo', '异常信息', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (649, 63, 'user_ip', 'VARCHAR(16)', NULL, 9, 'String', 'userIp', '用户IP', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'input', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (650, 63, 'user_agent', 'VARCHAR(1024)', NULL, 10, 'String', 'userAgent', '用户代理', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (651, 63, 'device_name', 'VARCHAR(64)', NULL, 11, 'String', 'deviceName', '设备名称/操作系统', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'input', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (652, 63, 'browser_name', 'VARCHAR(64)', NULL, 12, 'String', 'browserName', '浏览器名称', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'input', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (653, 63, 'execution_time', 'INT(10)', NULL, 13, 'Integer', 'executionTime', '执行时间(单位:毫秒)', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'number', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (654, 63, 'create_by', 'VARCHAR(64)', NULL, 14, 'String', 'createBy', '创建者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (655, 63, 'create_time', 'DATETIME(19)', NULL, 15, 'LocalDateTime', 'createTime', '创建时间', b'0', b'0', b'0', b'1', b'1', b'1', 'between', 'dateTime', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (656, 63, 'update_by', 'VARCHAR(64)', NULL, 16, 'String', 'updateBy', '修改者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (657, 63, 'update_time', 'DATETIME(19)', NULL, 17, 'LocalDateTime', 'updateTime', '修改时间', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'dateTime', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (658, 63, 'deleted', 'BIT(1)', NULL, 18, 'Boolean', 'deleted', '是否删除[0否 1是]', b'0', b'0', b'0', b'1', b'0', b'0', 'eq', 'switch', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (659, 63, 'remark', 'VARCHAR(512)', NULL, 19, 'String', 'remark', '备注', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_column` VALUES (660, 64, 'role_id', 'BIGINT(19)', 19, 0, 'Long', 'roleId', '角色id', b'1', b'0', b'1', b'1', b'0', b'0', 'eq', 'number', NULL, '1', '2023-12-21 14:51:43', '1', '2023-12-21 14:56:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (661, 64, 'name', 'VARCHAR(32)', 32, 1, 'String', 'name', '角色名称', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, '1', '2023-12-21 14:51:43', '1', '2023-12-21 14:56:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (662, 64, 'code', 'VARCHAR(32)', 32, 2, 'String', 'code', '角色编码', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, '1', '2023-12-21 14:51:43', '1', '2023-12-21 14:56:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (663, 64, 'data_scope', 'TINYINT(3)', 3, 3, 'Integer', 'dataScope', '数据范围[1:全部数据权限 2:本部门数据权限 3:本部门及以下数据权限 4:自定数据权限 5:仅本人数据权限]', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'number', NULL, '1', '2023-12-21 14:51:43', '1', '2023-12-21 14:56:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (664, 64, 'status', 'BIT(1)', 1, 4, 'Boolean', 'status', '状态[0停用 1正常]', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'switch', NULL, '1', '2023-12-21 14:51:43', '1', '2023-12-21 14:56:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (665, 64, 'create_by', 'VARCHAR(64)', 64, 5, 'String', 'createBy', '创建者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, '1', '2023-12-21 14:51:43', '1', '2023-12-21 14:56:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (666, 64, 'create_time', 'DATETIME(19)', 19, 6, 'LocalDateTime', 'createTime', '创建时间', b'0', b'0', b'0', b'1', b'1', b'0', 'eq', 'dateTime', NULL, '1', '2023-12-21 14:51:43', '1', '2023-12-21 14:56:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (667, 64, 'update_by', 'VARCHAR(64)', 64, 7, 'String', 'updateBy', '修改者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, '1', '2023-12-21 14:51:43', '1', '2023-12-21 14:56:23', b'0', NULL);
INSERT INTO `gen_column` VALUES (668, 64, 'update_time', 'DATETIME(19)', 19, 8, 'LocalDateTime', 'updateTime', '修改时间', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'dateTime', NULL, '1', '2023-12-21 14:51:43', '1', '2023-12-21 14:56:24', b'0', NULL);
INSERT INTO `gen_column` VALUES (669, 64, 'deleted', 'BIT(1)', 1, 9, 'Boolean', 'deleted', '是否删除[0:否 1:是]', b'0', b'0', b'0', b'1', b'0', b'0', 'eq', 'switch', NULL, '1', '2023-12-21 14:51:43', '1', '2023-12-21 14:56:24', b'0', NULL);
INSERT INTO `gen_column` VALUES (670, 64, 'remark', 'VARCHAR(512)', 512, 10, 'String', 'remark', '备注', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, '1', '2023-12-21 14:51:43', '1', '2023-12-21 14:56:24', b'0', NULL);
INSERT INTO `gen_column` VALUES (671, 65, 'user_id', 'BIGINT(19)', 19, 0, 'Long', 'userId', '用户id', b'1', b'0', b'1', b'1', b'0', b'0', 'eq', 'number', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (672, 65, 'dept_id', 'BIGINT(19)', 19, 1, 'Long', 'deptId', '所属部门id', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'number', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (673, 65, 'username', 'VARCHAR(32)', 32, 2, 'String', 'username', '用户名', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (674, 65, 'password', 'VARCHAR(64)', 64, 3, 'String', 'password', '用户密码', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (675, 65, 'nickname', 'VARCHAR(32)', 32, 4, 'String', 'nickname', '用户昵称', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'input', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (676, 65, 'name', 'VARCHAR(32)', 32, 5, 'String', 'name', '用户姓名', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (677, 65, 'sex', 'BIT(1)', 1, 6, 'Boolean', 'sex', '用户性别[0男 1女]', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'switch', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (678, 65, 'mobile', 'VARCHAR(16)', 16, 7, 'String', 'mobile', '用户电话', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (679, 65, 'email', 'VARCHAR(64)', 64, 8, 'String', 'email', '用户邮箱', b'0', b'1', b'1', b'0', b'1', b'1', 'eq', 'input', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (680, 65, 'status', 'TINYINT(3)', 3, 9, 'Integer', 'status', '帐号状态[0正常 1锁定]', b'0', b'1', b'1', b'1', b'1', b'1', 'eq', 'number', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (681, 65, 'create_by', 'VARCHAR(64)', 64, 10, 'String', 'createBy', '创建者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (682, 65, 'create_time', 'DATETIME(19)', 19, 11, 'LocalDateTime', 'createTime', '创建时间', b'0', b'0', b'0', b'0', b'1', b'0', 'eq', 'dateTime', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (683, 65, 'update_by', 'VARCHAR(64)', 64, 12, 'String', 'updateBy', '修改者', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'input', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (684, 65, 'update_time', 'DATETIME(19)', 19, 13, 'LocalDateTime', 'updateTime', '修改时间', b'0', b'0', b'0', b'0', b'0', b'0', 'eq', 'dateTime', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (685, 65, 'deleted', 'BIT(1)', 1, 14, 'Boolean', 'deleted', '是否删除[0否 1是]', b'0', b'0', b'0', b'1', b'0', b'0', 'eq', 'switch', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (686, 65, 'remark', 'VARCHAR(512)', 512, 15, 'String', 'remark', '备注', b'0', b'1', b'1', b'0', b'1', b'0', 'eq', 'textarea', NULL, '1', '2023-12-22 13:42:09', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_column` VALUES (687, 66, 'role_id', 'BIGINT(19)', 19, 0, 'Long', 'roleId', '角色id', b'1', b'0', b'1', b'1', b'0', b'0', 'eq', 'number', NULL, '1', '2023-12-25 16:56:13', '1', '2023-12-25 16:56:56', b'0', NULL);
INSERT INTO `gen_column` VALUES (688, 66, 'menu_id', 'BIGINT(19)', 19, 1, 'Long', 'menuId', '菜单id', b'1', b'0', b'1', b'1', b'0', b'0', 'eq', 'number', NULL, '1', '2023-12-25 16:56:13', '1', '2023-12-25 16:56:56', b'0', NULL);

-- ----------------------------
-- Table structure for gen_datasource
-- ----------------------------
DROP TABLE IF EXISTS `gen_datasource`;
CREATE TABLE `gen_datasource`  (
  `source_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据源id',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '连接名',
  `url` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '数据源URL',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除[0否 1是]',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`source_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '数据源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_datasource
-- ----------------------------
INSERT INTO `gen_datasource` VALUES (1, 'master', 'jdbc:mysql://localhost:3306/solo', 'root', '123456', 'admin', '2023-10-09 11:20:59', 'admin', '2023-10-10 14:35:27', b'0', 'remark1');
INSERT INTO `gen_datasource` VALUES (2, 'codegen', 'jdbc:mysql://localhost:3306/solo-codegen', 'root', '123456', 'admin', '2023-10-09 13:41:49', 'admin', '2023-10-10 14:35:29', b'0', '60');
INSERT INTO `gen_datasource` VALUES (3, 'APPLYMATH', 'jdbc:oracle:thin:@localhost:1521:orcl', 'APPLYMATH', 'APPLYMATH', NULL, '2023-10-10 14:37:15', NULL, '2023-10-27 11:54:20', b'0', NULL);

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '业务表id',
  `source_id` bigint(20) NULL DEFAULT NULL COMMENT '数据源id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '表名称',
  `comment` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表描述',
  `author` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `tpl_type` tinyint(4) NOT NULL DEFAULT 1 COMMENT '模版类型[1:单表结构 2:树表结构 3:主子表结构]',
  `package_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生成包路径',
  `module_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生成模块名',
  `business_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '生成业务名',
  `function_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '生成功能名',
  `class_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '实体类名称',
  `class_tail` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实体类尾巴',
  `is_switch` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否启用开关按钮',
  `switch_field` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开关字段',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改者',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除[0否 1是]',
  `remark` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '代码生成业务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES (55, 1, 'sys_config', '系统配置表', '十一', 1, 'com.solo.system', 'system', 'config', '系统配置', 'SysConfig', '人生若只如初见，何事秋风悲画扇', b'0', '', 'admin', '2023-11-07 15:13:01', 'admin', '2023-11-07 16:09:06', b'0', NULL);
INSERT INTO `gen_table` VALUES (56, 1, 'sys_dict_type', '字典类型表', '十一', 1, 'com.solo.system', 'system', 'dict.type', '字典类型', 'SysDictType', '人生若只如初见，何事秋风悲画扇', b'0', '', 'admin', '2023-11-08 09:09:44', 'admin', '2023-11-08 09:10:28', b'0', NULL);
INSERT INTO `gen_table` VALUES (57, 1, 'sys_dict_data', '字典数据表', '十一', 1, 'com.solo.system', 'system', 'dict.data', '字典数据', 'SysDictData', '人生若只如初见，何事秋风悲画扇', b'0', '', 'admin', '2023-11-08 09:35:58', 'admin', '2023-11-08 09:36:23', b'0', NULL);
INSERT INTO `gen_table` VALUES (58, 2, 'gen_datasource', '数据源表', '十一', 1, 'com.solo.codegen', 'codegen', 'datasource', '数据源', 'GenDatasource', '人生若只如初见，何事秋风悲画扇', b'0', '', 'admin', '2023-11-08 09:53:09', 'admin', '2023-11-08 09:53:49', b'0', NULL);
INSERT INTO `gen_table` VALUES (59, 2, 'gen_table', '代码生成业务表', '十一', 1, 'com.solo.codegen', 'codegen', 'table', '代码生成业务', 'GenTable', '人生若只如初见，何事秋风悲画扇', b'0', '', 'admin', '2023-11-08 10:32:14', 'admin', '2023-11-08 10:32:52', b'0', NULL);
INSERT INTO `gen_table` VALUES (60, 2, 'gen_column', '代码生成业务字段表', '十一', 1, 'com.solo.codegen', 'codegen', 'column', '代码生成业务字段', 'GenColumn', '人生若只如初见，何事秋风悲画扇', b'0', '', 'admin', '2023-11-08 11:08:36', 'admin', '2023-11-08 11:09:45', b'0', NULL);
INSERT INTO `gen_table` VALUES (61, 1, 'sys_menu', '菜单表', '十一', 2, 'com.solo.system', 'system', 'menu', '菜单', 'SysMenu', '人生若只如初见，何事秋风悲画扇', b'0', '', 'admin', '2023-11-14 13:51:17', '1', '2023-12-22 09:14:04', b'0', NULL);
INSERT INTO `gen_table` VALUES (63, 1, 'sys_operate_log', '操作日志表', '十一', 1, 'com.solo.system', 'system', 'operate.log', '操作日志', 'SysOperateLog', '人生若只如初见，何事秋风悲画扇', b'0', NULL, '1', '2023-12-18 16:12:50', '1', '2023-12-18 16:14:06', b'0', NULL);
INSERT INTO `gen_table` VALUES (64, 1, 'sys_role', '角色表', '十一', 1, 'com.solo.system', 'system', 'role', '角色', 'SysRole', '人生若只如初见，何事秋风悲画扇', b'0', '', '1', '2023-12-21 14:51:43', '1', '2023-12-21 14:56:23', b'0', NULL);
INSERT INTO `gen_table` VALUES (65, 1, 'sys_user', '用户表', '十一', 1, 'com.solo.system', 'system', 'user', '用户', 'SysUser', '人生若只如初见，何事秋风悲画扇', b'0', '', '1', '2023-12-22 13:42:08', '1', '2023-12-22 13:43:32', b'0', NULL);
INSERT INTO `gen_table` VALUES (66, 1, 'sys_role_menu', '角色菜单关联表', '十一', 1, 'com.solo.system', 'system', 'role.menu', '角色菜单关联', 'SysRoleMenu', '人生若只如初见，何事秋风悲画扇', b'0', '', '1', '2023-12-25 16:56:13', '1', '2023-12-25 16:56:56', b'0', NULL);

SET FOREIGN_KEY_CHECKS = 1;
