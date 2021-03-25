%b)
N = 1e5; 
p = 0.5;
n = 4;
lancamentos = rand(n, N);
sucessos = sum(lancamentos < 0.5);

func = histc(sucessos, 0:n) / N;

valor = sum([0:n].*func);
variancia = sum(([0:n]).^2.*func) - valor ^ 2;
desvPad  = sqrt(variancia);

printf ('\nValor esperado= %.4f', valor)
printf ('\nVariancia= %.4f', variancia)
printf ('\nDesvio Padrao= %.4f', desvPad)

%c) Variável Discreta Binomial
%   Px(k)=nchoosek*(p^k)*(1-p^(n-k))
