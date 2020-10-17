Select Ssn,Fname,Lname,Pno from (project join 
(employee join works_on on employee.Ssn=works_on.Essn)
on project.Pnumber=works_on.Pno)
