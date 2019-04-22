# Day25  数据库MYSQL
#### 卸载（win版）
1. 停止MySQL服务
2. 卸载MySQL
3. 删除残留软件文件和数据库文件

#### SQL语法———DML
```sql
CREATE TABLE user(
    NAME VARCHAR(10),
    AGE INT,
    SEX VARCHAR(1)   
)
-- 
CREATE TABLE emp(
    ID INT,
    NAME VARCHAR(10),
    gender VARCHAR(10),
    birthday DATE,
    salary FLOAT(10,2),  
    RESUME TEXT
)
-- 插入
INSERT INTO emp(ID,NAME,gender,birthday,salary,RESUME) VALUES (1,'zhangsan','男','1994-10-20',2000,'好男人');
INSERT INTO emp(ID,NAME,gender,birthday,salary,RESUME) VALUES (2,'lisi','男','1997-10-20',200,'小学生');
INSERT INTO emp VALUES (3,'xue','女','1992-10-20',500,'美女');

-- 修改
UPDATE emp SET NAME='chenchen' where id = 2;

-- 删除
DELETE FROM emp where id=3;

-- Truncate 删除整个表，数据不可找回
```


#code/Java