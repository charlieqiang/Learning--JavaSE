--create db
create database spdb1
--dept table
create table dept
(deptno int primary key,
dname nvarchar(30),
loc nvarchar(30)
)
--emp table
create table emp
(empno int primary key,
ename nvarchar(30),
job nvarchar(30),
mgr int,
hiredate datetime,
sal numeric(10,2),
comm numeric(10,2),
deptno int foreign key references dept(deptno)
)

--msg