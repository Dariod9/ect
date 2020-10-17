CREATE PROC a (@numero int) AS 
Delete from dependent where Essn=@numero;
Delete from works_on where Essn=@numero;
Delete from employee where Ssn=@numero;


