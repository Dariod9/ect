p = linspace(0,1); #p entre 0 e 1

#Avi�o cair --> Mais de metade dos motores avariarem --> Obrigatoriamente 2
prob2 = nchoosek(2,2) * (p.^2) *1;#todo o "p" elevado a 2

#Avi�o cair ----------------> 3 ou 4 motores
prob4 = 0;
for i=3:4 
    prob4 = prob4 + nchoosek(4,i) * p.^i .* (1-p).^(4-i);
end

final=prob2/prob4

if final>1
  v="\n� preferivel utilizar um avi�o de 4 motores"
else
  s="\n� prefer�vel utilizar um avi�o de 2 motores"
endif