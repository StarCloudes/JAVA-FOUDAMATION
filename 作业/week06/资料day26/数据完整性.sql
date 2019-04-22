-- 数据的完整性
-- 实体完整性--行完整性 行--一个实体
-- 实体：即表中的一行(一条记录)代表一个实体（entity）
-- 实体完整性的作用：标识每一行数据不重复。
-- 约束类型： 主键约束（primary key）  唯一约束(unique)  自动增长列(auto_increment)
-- 主键约束
-- 第一种
CREATE TABLE user1(
	id  INT PRIMARY KEY,
	NAME VARCHAR(10)
)

-- 第二种
CREATE TABLE user2(
	id  INT,
	NAME VARCHAR(10),
	PRIMARY KEY(id)
)

-- 第三种
CREATE TABLE user3(
	id  INT,
	NAME VARCHAR(10)
)

-- 单独设置主键
ALTER TABLE user3 ADD PRIMARY KEY(id)

-- 设置联合主键
CREATE TABLE user4(
	id  INT,
	tempId INT,
	NAME VARCHAR(10),
	PRIMARY KEY(id,tempId)
)

-- 添加一个数据
INSERT INTO user3 VALUES(1,'bingbing')
INSERT INTO user3(id ,NAME) VALUES(NULL,'bingbing')

-- 唯一约束
-- 数据不能重复
-- 注意点:他对null不起作用
CREATE TABLE user5(
	id  INT PRIMARY KEY,
	NAME VARCHAR(10) UNIQUE
)
INSERT INTO user5 VALUES(3,NULL)

-- 自动增长列
-- 1.自动增长列只适用于数值型
-- 2.当某一行被删除,新增一行,不会自动补齐
CREATE TABLE user6(
	id  INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(10) 
)
INSERT INTO user6(NAME) VALUES('bingbing')






