create schema empresa;
go

create table employee (
		fname	char(10)			NOT NULL,
		Minit	char(1)				NOT NULL,
		Lname	char(10)			NOT	NULL,
		Ssn		int ,
		Bdate	Date				NOT NULL,
		Address	varchar(70)			NOT NULL,
		Sex		char(1)				NOT NULL,
		Salary	int	check(Salary>=0)NOT null,
		Super_Ssn	int ,
		Dno		int,
		primary key (Ssn),
		foreign key (Super_ssn) references employee(Ssn));

Create table department(
		Dname	varchar(30)				NOT null,
		DNumber	int check(DNumber>=0)	NOT NULL,
		Mgr_ssn	int ,
		Mgr_start_date Date				,
		primary key(DNumber));

Alter table employee ADD foreign key(Dno) references department(DNumber);

create table dept_locations(
		DNumber		int	check(DNumber>=0)	NOT NULL,
		DLocation	varchar(25)				NOT Null,
		Primary key(DNumber, DLocation),
		Foreign key(DNumber) references department(DNumber));

create table project(
		PName		varchar(30)				NOT NULL,
		PNumber		int	check(PNumber>0)	NOT NULL,
		PLocation	varchar(30)				NOT NULL,
		DNum		int check(DNum>=0)		NOT NULL,
		primary key(PNumber),
		foreign key(Dnum) references department(DNumber));

create table works_on(
		Essn		int ,
		Pno			int check(Pno>0)	NOT NULL,
		Hours		int,
		primary key(Essn, Pno),
		foreign key(Essn) references employee(Ssn),
		foreign key(Pno)  references project(PNumber));

create table dependent(
		Essn		int,
		Dependent_name	varchar(20)		NOT NULL,
		Sex			char(1)				NOT NULL,
		Bdate		Date				NOT NULL,
		Relationship varchar(15)		NOT NULL,
		primary key(Essn, Dependent_name),
		foreign key(Essn) references employee(Ssn));
