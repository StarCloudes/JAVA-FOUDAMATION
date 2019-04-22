-- 域完整性
-- 列完整性(单元格)
-- 数据类型 非空约束（not null） 默认值约束(default)  
CREATE TABLE user7(
	id  INT PRIMARY KEY,
	NAME VARCHAR(10) NOT NULL,
	sex  VARCHAR(10) DEFAULT '男'
)

INSERT INTO user7(id,NAME) VALUES(1,'bing');
INSERT INTO user7(id,NAME) VALUES(1,NULL);  -- Column 'NAME' cannot be null

-- 引用完整性
-- 外键约束
CREATE TABLE user8(
       uid INT PRIMARY KEY,
       NAME VARCHAR(10)
)

CREATE TABLE order1(
	oid INT PRIMARY KEY,
	uid INT ,
	des VARCHAR(10),
	FOREIGN KEY(uid) REFERENCES user8(uid)
)

-- 取消主外键关系
ALTER TABLE order1 DROP FOREIGN KEY order1_ibfk_1

-- 手动添加主外键
ALTER TABLE order1 ADD CONSTRAINT order1_user8_1 FOREIGN KEY(uid) REFERENCES user8(uid)