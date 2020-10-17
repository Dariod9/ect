Select * from (dept_locations right outer join
				(Select * from (department join
					(Select * from ((employee join works_on on Ssn=Essn) join project on Pno=PNumber) where Plocation='Aveiro') as tmp1
					on DNumber=Dno)) as tmp2
				on dept_locations.DNumber=tmp2.DNumber) WHERE DLocation<>'Aveiro'