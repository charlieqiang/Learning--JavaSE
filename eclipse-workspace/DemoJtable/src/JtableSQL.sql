--create stu table
create table stu
(
stuId varchar(30) primary key,
stuName nvarchar(50) not null,
stuSex nchar(1) check(stuSex in('��','Ů')) default '��',
stuAge int check (stuAge>1),
stuJg nvarchar(30),
stuDept nvarchar(40)
)
--insert
insert into stu values('sp001','�����','��',20,'����ɽ','������');
insert into stu values('sp002','��˽�','��',15,'����ׯ','���ϵ�');
insert into stu values('sp003','ɳ��','��',26,'��ɳ��','ˮ���');

insert into stu values('sp004','������','��',21,'����','�����');

select * from stu