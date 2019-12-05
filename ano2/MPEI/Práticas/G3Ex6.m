 p=1/1000;
 n=8000;
 k=7;
 
 #Distribuição
prob = prod(n-k+1:n)/factorial(k) * p^k * (1-p)^(n-k)


#Poisson
lambda=n*p;

probP= (lambda^k)*(exp(-lambda))/factorial(k)