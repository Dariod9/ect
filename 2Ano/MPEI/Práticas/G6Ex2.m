bloom=zeros(1,100,'uint8');

paisesI={"Espanha", "Portugal", "Inglaterra"}
paisesF={"Espanha", "Alemanha", "Dinam","Angola"}


%Com 3 hashes
for i=1:length(paisesI)
  bloom=add(bloom,3,paisesI{i});
endfor
 
for j=1:length(paisesF)
 
  boole=checkExists(bloom,3,paisesF{j});
  
  if boole==true
    display(paisesF{j})
    display(" pertence")
  else
    display(paisesF{j})
    display(" não pertence")
  endif

end