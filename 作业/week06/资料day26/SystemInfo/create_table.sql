-- 建立学生信息表
create table stuInfo(
   stuName varchar(10) not null,
   stuNo varchar(10) primary key,
   stuSex varchar(10) default 'male',
   stuAge int ,   -- check(stuAge >= 15 and stuAge <= 50)
   stuSeat int not null auto_increment,key(stuSeat) ,  -- auto_increment
   stuAddress varchar(50) default 'unclear'
   )

-- 建立学生考试成绩表
create table stuMarks(
   examNo varchar(20) not null unique,
   stuNo varchar(10) not null,
   writtenExam int default '0', -- check(stuAge >= 0 and stuAge <= 100) 
   labExam int default '0' -- check(stuAge >= 0 and stuAge <= 100) 
   )

-- check数值范围
ALTER TABLE stuInfo ADD CONSTRAINT stuNo CHECK(stuNo like'S253[0-9][0-9]');
ALTER TABLE stuInfo ADD CONSTRAINT stuAge CHECK(stuAge >= 15 and stuAge <= 50);
ALTER TABLE stuMarks ADD CONSTRAINT writtenExam CHECK(writtenExam >= 0 and writtenExam <= 100);
ALTER TABLE stuMarks ADD CONSTRAINT labExam CHECK(labExam >= 0 and labExam <= 100);

-- 插入数据
insert into stuInfo(stuName,stuNo,stuSex,stuAge,stuAddress) values ('ZhangSan','S25302','male',18,'BeiJing')
