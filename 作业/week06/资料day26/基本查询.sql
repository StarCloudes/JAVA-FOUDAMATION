-- 创建基本表
CREATE TABLE stu (
	sid	CHAR(6),
	sname		VARCHAR(50),
	age		INT,
	gender	VARCHAR(50)
);
INSERT INTO stu VALUES('S_1001', 'liuYi', 35, 'male');
INSERT INTO stu VALUES('S_1002', 'chenEr', 15, 'female');
INSERT INTO stu VALUES('S_1003', 'zhangSan', 95, 'male');
INSERT INTO stu VALUES('S_1004', 'liSi', 65, 'female');
INSERT INTO stu VALUES('S_1005', 'wangWu', 55, 'male');
INSERT INTO stu VALUES('S_1006', 'zhaoLiu', 75, 'female');
INSERT INTO stu VALUES('S_1007', 'sunQi', 25, 'male');
INSERT INTO stu VALUES('S_1008', 'zhouBa', 45, 'female');
INSERT INTO stu VALUES('S_1009', 'wuJiu', 85, 'male');
INSERT INTO stu VALUES('S_1010', 'zhengShi', 5, 'female');
INSERT INTO stu VALUES('S_1011', 'xxx', NULL, NULL);

CREATE TABLE emp(
	empno		INT,
	ename		VARCHAR(50),
	job		VARCHAR(50),
	mgr		INT,
	hiredate	DATE,
	sal		DECIMAL(7,2),
	comm		DECIMAL(7,2),
	deptno		INT
) ;

INSERT INTO emp VALUES(7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20);
INSERT INTO emp VALUES(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO emp VALUES(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,500,30);
INSERT INTO emp VALUES(7566,'JONES','MANAGER',7839,'1981-04-02',2975,NULL,20);
INSERT INTO emp VALUES(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,1400,30);
INSERT INTO emp VALUES(7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,NULL,30);
INSERT INTO emp VALUES(7782,'CLARK','MANAGER',7839,'1981-06-09',2450,NULL,10);
INSERT INTO emp VALUES(7788,'SCOTT','ANALYST',7566,'1987-04-19',3000,NULL,20);
INSERT INTO emp VALUES(7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10);
INSERT INTO emp VALUES(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO emp VALUES(7876,'ADAMS','CLERK',7788,'1987-05-23',1100,NULL,20);
INSERT INTO emp VALUES(7900,'JAMES','CLERK',7698,'1981-12-03',950,NULL,30);
INSERT INTO emp VALUES(7902,'FORD','ANALYST',7566,'1981-12-03',3000,NULL,20);
INSERT INTO emp VALUES(7934,'MILLER','CLERK',7782,'1982-01-23',1300,NULL,10);


CREATE TABLE dept(
	deptno		INT,
	dname		VARCHAR(14),
	loc		VARCHAR(13)
);
INSERT INTO dept VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO dept VALUES(20, 'RESEARCH', 'DALLAS');
INSERT INTO dept VALUES(30, 'SALES', 'CHICAGO');
INSERT INTO dept VALUES(40, 'OPERATIONS', 'BOSTON');
--  DQL
-- 语法： SELECT 列名 FROM 表名  【WHERE --> GOUP BY -->HAVING--> ORDER BY   LIMIT】
-- 1　基础查询
-- 查询所有列
SELECT * FROM stu;
-- 查询姓名,年龄
SELECT  sname,age   FROM stu;

-- 2. 条件查询
-- 条件查询介绍
-- 2.2　查询性别为女，并且年龄小于50的记录
SELECT  *  FROM   stu  WHERE gender='female'  AND  age<50;
-- 2.3　查询学号为S_1001，或者姓名为liSi的记录
SELECT * FROM stu  WHERE sid='S_1001'  OR  sname='liSi';
-- 2.5　查询学号不是S_1001，S_1002，S_1003的记录
SELECT * FROM stu WHERE sid NOT IN ('S_1001','S_1002','S_1003')
-- 2.6　查询年龄为null的记录
SELECT * FROM stu WHERE age IS NULL;
-- 2.7　查询年龄在20到40之间的学生记录
SELECT * FROM stu WHERE age>=20 AND age<=40
SELECT * FROM stu WHERE age BETWEEN 20 AND 40  -- 包含开头和结尾
-- 2.8　查询性别非男的学生记录
-- 注意这里不包含null
SELECT * FROM stu WHERE gender!='male'
SELECT * FROM stu WHERE gender<>'male'
SELECT * FROM stu WHERE NOT gender='male'
-- 2.9　查询姓名不为null的学生记录
SELECT * FROM stu WHERE NOT sname IS NULL
-- 3.模糊查询
-- 3.1　查询姓名由5个字母构成的学生记录
SELECT * FROM stu WHERE sname LIKE '_____'
-- 3.2　查询姓名由5个字母构成，并且第5个字母为“i”的学生记录
SELECT * FROM stu WHERE  sname LIKE '____i'
-- 3.3　查询姓名以“z”开头的学生记录
SELECT * FROM stu WHERE sname LIKE 'z%'
-- 3.4　查询姓名中第2个字母为“i”的学生记录
SELECT * FROM stu WHERE sname LIKE '_i%'
-- 3.5　查询姓名中包含“a”字母的学生记录
SELECT * FROM stu WHERE sname LIKE '%a%'

-- 4.字段控制查询
-- 4.1 去重
SELECT * FROM emp WHERE sal=3000
SELECT DISTINCT sal FROM emp;
-- 4.2　查看雇员的月薪与佣金之和
-- 默认与null进行计算的结果都是null
SELECT *,sal+IFNULL(comm,0) FROM emp 
-- 4.3　给列名添加别名  AS关键字可以省略
SELECT *,sal+IFNULL(comm,0) AS SUM FROM emp 

-- 5.排序
-- 5.1　查询所有学生记录，按年龄升序排序
-- 默认认为null是最小的(比0都小), 如果是升序  ASC可以省略
SELECT * FROM stu ORDER BY age ASC
-- 降序,desc不可以省略
SELECT * FROM stu ORDER BY age DESC 
SELECT * FROM stu ORDER BY sname DESC 

-- 聚合函数  sum  avg  max  min   count
-- 聚合函数是用来做纵向运算的函数：
-- COUNT()：统计指定列不为NULL的记录行数；
-- 查询emp表中记录数：如果查询的记录的行数不一致,会以行数少的为基准显示所有数据,虚拟表一定一个矩形.所以这是错误
SELECT COUNT(*) num FROM emp;
-- MAX()：计算指定列的最大值，如果指定列是字符串类型，那么使用字符串排序运算；
SELECT MAX(ename) FROM emp;
-- MIN()：计算指定列的最小值，如果指定列是字符串类型，那么使用字符串排序运算；
-- SUM()：计算指定列的数值和，如果指定列类型不是数值类型，那么计算结果为0；
SELECT SUM(sal) FROM emp;
-- AVG()：计算指定列的平均值，如果指定列类型不是数值类型，那么计算结果为0；

-- 分组查询
-- 凡和聚合函数同时出现的列名，则一定会写在group by 之后
-- 查询每个部门的部门编号和每个部门的工资和：
SELECT deptno,SUM(sal),mgr FROM emp  GROUP BY deptno;
-- 查询工资总和大于9000的部门编号以及工资和
SELECT deptno,SUM(sal),mgr FROM emp  GROUP BY deptno HAVING SUM(sal)>9000

-- 8.limit
-- LIMIT用来限定查询结果的起始行，以及总行数。
-- 8.1　查询5行记录，起始行从0开始
SELECT * FROM emp LIMIT 0,5
SELECT * FROM emp LIMIT 5,5
SELECT * FROM emp LIMIT 10,5

-- 设定 页数 currentPage(默认从1开始)  每页的行数 (size)
-- 第一页  (currentPage-1)*size  , size

-- 查询语句书写顺序：select – from- where- group by- having- order by-limit
-- 查询语句执行顺序：from - where -group by - having - select - order by-limit







