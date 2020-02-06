--create stu table
create table stu
(
stuId varchar(30) primary key,
stuName nvarchar(50) not null,
stuSex nchar(1) check(stuSex in('男','女')) default '男',
stuAge int check (stuAge>1),
stuJg nvarchar(30),
stuDept nvarchar(40)
)
--insert
insert into stu values('sp001','孙悟空','男',20,'花果山','少林派');
insert into stu values('sp002','猪八戒','男',15,'高老庄','天上的');
insert into stu values('sp003','沙悟净','男',26,'流沙河','水里的');

insert into stu values('sp004','唐三藏','男',21,'长安','庙里的');

select * from stu