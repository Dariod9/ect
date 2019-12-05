N = 1e5; 
p = 0.5;
n = 4;

%i)
k=2
result = nchoosek(4, k)*((1/2)^k)*(1/2)^(n-k)

%ii)
k=0
result1 = nchoosek(4, k)*((1/2)^k)*(1/2)^(n-k);

k=1
result2 = nchoosek(4, k)*((1/2)^k)*(1/2)^(n-k);

result=result1+result2

%iii)

k=1
result1 = nchoosek(4, k)*((1/2)^k)*(1/2)^(n-k);

k=2
result2 = nchoosek(4, k)*((1/2)^k)*(1/2)^(n-k);

k=3
result3 = nchoosek(4, k)*((1/2)^k)*(1/2)^(n-k);

result=result1+result2+result3