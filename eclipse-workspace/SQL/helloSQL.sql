--create
--create database LiangShanHeros02
--table
use LiangShanHeros02
go;
create table heros
(
heroId int,
heroName varchar(50),
heroNickName varchar(50),
sex char(2),
sal int
)

insert into heros values(1,'ËÎ½­','¼°Ê±Óê','ÄÐ',2000)

--delete table
--drop table heros

--query
select * from heros

--change
--update heros set ×Ö¶Î=? where condition
update heros set sal=sal*1.1 where sal<3000

--delete
delete from heros where sex='ÄÐ'