-- 用户表
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id BIGINT NOT NULL COMMENT '主键ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
    age INT NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    create_time DATETIME NULL DEFAULT NULL COMMENT '创建时间',
    update_time DATETIME NULL DEFAULT NULL COMMENT '更新时间',
    create_user BIGINT NULL DEFAULT NULL COMMENT '创建人',
    update_user BIGINT NULL DEFAULT NULL COMMENT '更新人',
    is_deleted INT NULL DEFAULT 0 COMMENT '是否删除',
    PRIMARY KEY (id)
);
-- 插入用户数据
    INSERT INTO sys_user (id, name, age, email,create_time, update_time, create_user,update_user, is_deleted)
    VALUES
        (1, '张三', 20, 'zhangsan@example.com',now(), now(), 1, 1, 0),
        (2, '李四', 25, 'lisi@example.com',now(), now(), 1, 1, 0),
        (3, '王五', 30, 'wangwu@example.com',now(), now(), 1, 1, 0),
        (4, '赵六', 35, 'zhaoliu@example.com',now(), now(), 1, 1, 0),
        (5, '孙七', 40, 'sunqi@example.com',now(), now(), 1, 1, 0),
        (6, '周八', 45, 'zhouba@example.com',now(), now(), 1, 1, 0),
        (7, '吴九', 50, 'wujiu@example.com',now(), now(), 1, 1, 0),
        (8, '郑十', 55, 'zhengshi@example.com',now(), now(), 1, 1, 0),
        (9, '王二', 28, 'wanger@example.com',now(), now(), 1, 1, 0),
        (10, '宋江', 32, 'songjiang@example.com', now(), now(), 1, 1, 0),
        (11, '吴用', 36, 'wuyong@example.com',now(), now(), 1, 1, 0),
        (12, '卢俊义', 40, 'lujunyi@example.com',now(), now(), 1, 1, 0),
        (13, '林冲', 44, 'linchong@example.com',now(), now(), 1, 1, 0),
        (14, '关胜', 48, 'guansheng@example.com',now(), now(), 1, 1, 0),
        (15, '秦明', 52, 'qinming@example.com',now(), now(), 1, 1, 0),
        (16, '呼延灼', 56, 'huyanzhuo@example.com',now(), now(), 1, 1, 0),
        (17, '花荣', 60, 'huarong@example.com',now(), now(), 1, 1, 0),
        (18, '柴进', 64, 'chaijin@example.com',now(), now(), 1, 1, 0),
        (19, '李应', 68, 'liying@example.com',now(), now(), 1, 1, 0),
        (20, '朱仝', 72, 'zhushong@example.com',now(), now(), 1, 1, 0),
        (21, '鲁智深', 76, 'luzhishi@example.com',now(), now(), 1, 1, 0),
        (22, '武松', 80, 'wusong@example.com',now(), now(), 1, 1, 0),
        (23, '董平', 84, 'dongping@example.com',now(), now(), 1, 1, 0),
        (24, '张清', 88, 'zhangqing@example.com',now(), now(), 1, 1, 0),
        (25, '杨志', 92, 'yangzhi@example.com',now(), now(), 1, 1, 0),
        (26, '徐宁', 96, 'xuning@example.com',now(), now(), 1, 1, 0),
        (27, '索超', 100, 'suoche@example.com', now(), now(), 1, 1, 0),
        (28, '戴宗', 104, 'daizong@example.com', now(), now(), 1, 1, 0),
        (29, '刘唐', 108, 'liutang@example.com',now(), now(), 1, 1, 0),
        (30, '李逵', 112, 'likui@example.com',now(), now(), 1, 1, 0),
        (31, '史进', 116, 'shijing@example.com',now(), now(), 1, 1, 0);

-- 用户部门关联表
DROP TABLE IF EXISTS sys_user_dept;
CREATE TABLE sys_user_dept
(
    id BIGINT NOT NULL COMMENT '主键ID',
    user_id BIGINT NULL DEFAULT NULL COMMENT '用户ID',
    dept_id BIGINT NULL DEFAULT NULL COMMENT '部门ID',
    create_time DATETIME NULL DEFAULT NULL COMMENT '创建时间',
    update_time DATETIME NULL DEFAULT NULL COMMENT '更新时间',
    create_by VARCHAR(50) NULL DEFAULT NULL COMMENT '创建人',
    update_by VARCHAR(50) NULL DEFAULT NULL COMMENT '更新人',
    is_deleted INT NULL DEFAULT 0 COMMENT '是否删除',
    PRIMARY KEY (id)
);

-- 插入20条用户部门数据
    INSERT INTO sys_user_dept (id, user_id, dept_id, create_time, update_time, create_by, update_by, is_deleted)
    VALUES
        (1, 1, 1, now(), now(), 'admin', 'admin', 0),
        (2, 2, 2, now(), now(), 'admin', 'admin', 0),
        (3, 3, 3, now(), now(), 'admin', 'admin', 0),
        (4, 4, 4, now(), now(), 'admin', 'admin', 0),
        (5, 5, 5, now(), now(), 'admin', 'admin', 0),
        (6, 6, 6, now(), now(), 'admin', 'admin', 0),
        (7, 7, 7, now(), now(), 'admin', 'admin', 0),
        (8, 8, 8, now(), now(), 'admin', 'admin', 0),
        (9, 9, 9, now(), now(), 'admin', 'admin', 0),
        (10, 10, 10, now(), now(), 'admin', 'admin', 0),
        (11, 11, 11, now(), now(), 'admin', 'admin', 0),
        (12, 12, 12, now(), now(), 'admin', 'admin', 0),
        (13, 13, 13, now(), now(), 'admin', 'admin', 0),
        (14, 14, 14, now(), now(), 'admin', 'admin', 0),
        (15, 15, 15, now(), now(), 'admin', 'admin', 0),
        (16, 16, 16, now(), now(), 'admin', 'admin', 0),
        (17, 17, 17, now(), now(), 'admin', 'admin', 0),
        (18, 18, 18, now(), now(), 'admin', 'admin', 0),
        (19, 19, 19, now(), now(), 'admin', 'admin', 0),
        (20, 20, 20, now(), now(), 'admin', 'admin', 0);


--  部门表
DROP TABLE IF EXISTS sys_dept;
CREATE TABLE sys_dept
(
    id BIGINT NOT NULL COMMENT '主键ID',
    code VARCHAR(30) NULL DEFAULT NULL COMMENT '部门编码',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '部门名称',
    parent_id BIGINT NULL DEFAULT NULL COMMENT '父级部门ID',
    level INT NULL DEFAULT NULL COMMENT '部门层级',
    sort INT NULL DEFAULT NULL COMMENT '排序',
    create_time DATETIME NULL DEFAULT NULL COMMENT '创建时间',
    update_time DATETIME NULL DEFAULT NULL COMMENT '更新时间',
    create_user BIGINT NULL DEFAULT NULL COMMENT '创建人',
    update_user BIGINT NULL DEFAULT NULL COMMENT '更新人',
    is_deleted INT NULL DEFAULT NULL COMMENT '是否删除',
    PRIMARY KEY (id)
);
-- 插入部门数据
INSERT INTO sys_dept (id, code, name, parent_id, level, sort, create_time, update_time, create_user, update_user, is_deleted)
VALUES
    (1, '001', '总公司', NULL, 1, 1, now(), now(), 1, 1, 0),
    (2, '002', '测试部', 1, 2, 1, now(), now(), 1, 1, 0),
    (3, '003', '开发部', 1, 2, 2, now(), now(), 1, 1, 0),
    (4, '004', '财务部', 1, 2, 3, now(), now(), 1, 1, 0),
    (5, '005', '市场部', 1, 2, 4, now(), now(), 1, 1, 0),
    (6, '006', '人力资源部', 1, 2, 5, now(), now(), 1, 1, 0),
    (7, '007', '行政部', 1, 2, 6, now(), now(), 1, 1, 0),
    (8, '008', '财务部-财务一部', 4, 3, 1, now(), now(), 1, 1, 0),
    (9, '009', '财务部-财务二部', 4, 3, 2, now(), now(), 1, 1, 0),
    (10, '010', '开发部-前端开发', 3, 3, 1, now(), now(), 1, 1, 0),
    (11, '011', '开发部-后端开发', 3, 3, 2, now(), now(), 1, 1, 0),
    (12, '012', '测试部-功能测试', 2, 3, 1, now(), now(), 1, 1, 0),
    (13, '013', '测试部-性能测试', 2, 3, 2, now(), now(), 1, 1, 0),
    (14, '014', '市场部-市场调研', 5, 3, 1, now(), now(), 1, 1, 0),
    (15, '015', '市场部-市场推广', 5, 3, 2, now(), now(), 1, 1, 0);


