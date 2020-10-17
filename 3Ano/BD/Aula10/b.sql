CREATE PROC b AS
SELECT fname, Minit, Lname, Ssn from (department join employee on department.Mgr_ssn=employee.Ssn);

Select Mgr_ssn as Gerente, DATEDIFF(year, Mgr_start_date, GETDATE()) as Anos from department where Mgr_start_date=(
		Select Min(Mgr_start_date) as data_velho from department );


