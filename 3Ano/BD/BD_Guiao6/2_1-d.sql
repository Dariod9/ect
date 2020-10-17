Select Fname, Lname, Hours from(
Select * from ((employee join works_on on Ssn=Essn) join (Select * from project where Pname='Aveiro Digital') as tmp on Pno=tmp.Pnumber) where Dno=3
)as tmp2 where tmp2.Hours>20