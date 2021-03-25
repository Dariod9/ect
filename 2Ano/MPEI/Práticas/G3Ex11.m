
N=1e5;
x=14+2*randn(1,N);

% Definir todos os x>20 como x=20
length(find(x>20));
x(find(x>20))=20;

#a)
pA=sum(x>12 & x<16)/N

#b)
pB=sum(x>10 & x<18)/N

#c)
pC=sum(x>10)/N