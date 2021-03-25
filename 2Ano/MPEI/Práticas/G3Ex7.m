lambda=15;

#a)
k=0;
p=(lambda^k)*(exp(-lambda))/factorial(k);
disp("Probabildiade de receber 0 mensagens em 1 segundo:")
disp(p)

#b)

#1-P(<10)
  pb=0;
for i=0:10
  pb=pb+(lambda^i)*(exp(-lamda))/factorial(i);
endfor

disp("Probabilidade de mais de 15 mensagens: ")
disp(1-pb)


