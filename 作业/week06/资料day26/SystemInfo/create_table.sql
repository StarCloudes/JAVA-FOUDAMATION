-- 建立学生信息表
create table stuInfo(
   stuName varchar(10) not null,
   stuNo varchar(10) not null unique,
   stuSex varchar(10) default 'male',
   stuAge int ,   -- check(stuAge >= 15 and stuAge <= 50)
   stuSeat int not null auto_increment,key(stuSeat) ,  -- auto_increment
   stuAddress varchar(50) default 'unclear',
   primary key(stuNo)
   )

-- 建立学生考试成绩表
create table stuMarks(
   examNo varchar(10) not null unique,
   stuNo varchar(10) not null unique,
   writtenExam int default '0', -- check(stuAge >= 0 and stuAge <= 100) 
   labExam int default '0' ,-- check(stuAge >= 0 and stuAge <= 100) 
   primary key(examNo),
   foreign key(stuNo) references stuInfo(stuNo)
   )


-- check数值范围
ALTER TABLE stuInfo ADD CONSTRAINT stuNo CHECK(stuNo like'S253[0-9][0-9]');
ALTER TABLE stuInfo ADD CONSTRAINT stuAge CHECK(stuAge >= 15 and stuAge <= 50);
ALTER TABLE stuMarks ADD CONSTRAINT writtenExam CHECK(writtenExam >= 0 and writtenExam <= 100);
ALTER TABLE stuMarks ADD CONSTRAINT labExam CHECK(labExam >= 0 and labExam <= 100);

-- 插入数据
insert into stuInfo(stuName,stuNo,stuSex,stuAge,stuAddress) values 
    ('lisi','S25303','male',19,'Shanghai'),
    ('KaiGe','S25304','male',18,'BeiJing'),
    ('Zhishu','S25306','male',20,'Taiwan'),
    ('Xiangqin','S25308','female',18,'Taiwai'),
    ('Quanyecha','S25310','male',18,'Japen')

insert into stuInfo(stuName,stuNo,stuSex,stuAge,stuAddress) values 
    ('zhangsan','S25301','male',17,'Shenzhen')
    
insert into stuMarksvalues ('02','S25304',80,80),('04','S25306',100,80)
insert into stuMarks(examNo,stuNo) values ('03','S25310'),('08','S25308')




