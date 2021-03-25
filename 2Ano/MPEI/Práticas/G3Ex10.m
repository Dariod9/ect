p=linspace(0,10);

#a)
soma=0;
for j=1:100
    if p(1,j)<3
      soma=soma+1;
    endif
endfor

disp("Probabilidade de X<3: ")
disp(soma/100)  

#b)
soma2=0;
for j=1:100
    if p(1,j)>7
      soma=soma+1;
    endif
endfor

disp("Probabilidade de X>7: ")
disp(soma/100)  

#c)
soma=0;
for j=1:100
    if (p(1,j)>1 && p(1,j)<6)
      soma=soma+1;
    endif
endfor

disp("Probabilidade de 1<X<6: ")
disp(soma/100)  
