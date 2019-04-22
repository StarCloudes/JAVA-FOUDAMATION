-- 多表查询
-- 合并结果集
CREATE TABLE A(
	NAME VARCHAR(10),
	score INT
)

CREATE TABLE B(
	NAME VARCHAR(10),
	score INT
)

CREATE TABLE C(
	NAME VARCHAR(10),
	score INT,
	age  INT
)
INSERT INTO A VALUES('a',20),('aa',40),('aaa',60)
INSERT INTO B VALUES('b',20),('bb',40),('bbb',60)
INSERT INTO C VALUES('c',20,10),('cc',40,20),('ccc',60,30)

INSERT INTO A VALUE('f',100)
INSERT INTO B VALUE('f',100)

-- 注意点:进行联合查询的表的列数和单元格的数据类型必须一致
-- 自动去重
SELECT * FROM A  UNION  SELECT * FROM B

-- 不去重
SELECT * FROM A  UNION ALL  SELECT * FROM B

SELECT * FROM A  UNION ALL  SELECT * FROM C

-- 连接查询
CREATE TABLE student(
	id INT PRIMARY KEY,
	NAME VARCHAR(10)
)

CREATE TABLE scores(
	id INT ,
	score INT,
	courseId INT  PRIMARY KEY,
	FOREIGN KEY(id) REFERENCES student(id)
)

INSERT INTO student VALUES(1,'bing'),(2,'chen')
INSERT INTO scores VALUES(1,20,1),(2,50,2),(1,60,3)

-- 查询学生的信息和成绩
-- 采用的2*3的乘法,得到的积我们称为笛卡尔积

SELECT * FROM student,scores
	
-- 使用主外键关系做为条件来去除无用信息
-- 注意:多表查询,如果一个字段的名字是唯一的,不需要使用.语法,可以直接使用.
-- 但是如果多表中同一个字段出现了多次,要使用.语法
SELECT * FROM student,scores WHERE student.id=scores.id

-- 去除主外键
-- 没有主外键关系也可以采用99乘法表的形式查询,只需让两个表的主键,外键字段保持一致
ALTER TABLE scores DROP FOREIGN KEY scores_ibfk_1

-- 这里本质上就是内连接
SELECT * FROM student,scores WHERE student.id=scores.id

-- 重新添加主外键
ALTER TABLE scores ADD CONSTRAINT scores_student_1 FOREIGN KEY(id) REFERENCES student(id)

-- 给表设置别名
SELECT * FROM student a,scores b WHERE a.id=b.id

-- 内连接 
SELECT * FROM student a INNER JOIN scores b ON a.id=b.id
-- 添加一个学生
INSERT INTO student VALUES(3,'pu')
-- 注意:内连接的特点:只能查出两个表都有的id记录,如果一个记录只有主表有,副表没有,
-- 使用内连接,无法查出这条记录
SELECT * FROM student a INNER JOIN scores b ON a.id=b.id

-- 外连接
-- 左外连接
-- 左连接:写法   select  from 表一 left outer(可省略) join 表二  on 表一.id=表二.id
-- 工作原理:以左表为主,左表的信息会全部查出来,右表中只能查出与左表中id相同的记录,其他的查不出

SELECT * FROM student a LEFT OUTER JOIN scores b ON a.id=b.id

-- 丢掉主外键
ALTER TABLE scores DROP FOREIGN KEY scores_student_1
INSERT INTO scores  VALUES(4,50,6)

SELECT * FROM student a LEFT OUTER JOIN scores b ON a.id=b.id

-- 右外连接
-- 左连接:写法   select  from 表一 right outer(可省略) join 表二  on 表一.id=表二.id
-- 工作原理:以右表为主,右表的信息会全部查出来,左表中只能查出与右表中id相同的记录,其他的查不出
SELECT * FROM student a RIGHT OUTER JOIN scores b ON a.id=b.id

-- 全外连接--mysql 不支持

-- 自然连接  可以省略后面的判断条件但是要保证有主外键关系
-- 如果没有主外键关系也可以查询,只需让两个表的某一个字段保持一致
SELECT * FROM student a NATURAL  JOIN scores b 

-- 明天内容
-- 子查询
-- 自连接
-- MySQL中的函数
-- 备份与恢复
-- jdbc
