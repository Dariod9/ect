N = 1e5; 
p = 1/3;
n = 5;

k=0
result1 = nchoosek(n, k)*(p^k)*(1/2)^(n-k);

k=1
result2 = nchoosek(n, k)*(p^k)*(1/2)^(n-k);

k=2
result3 = nchoosek(n, k)*(p^k)*(1/2)^(n-k);

result=result1+result2+result3