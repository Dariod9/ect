N = 1e5; 
p = 1/3;
n = 5;
lancamentos = rand(n, N);
sucessos = sum(lancamentos < 1/3);

func = histc(sucessos, 0:n) / N;
stem(func, 'r')
ylabel('P(X=xi)')
xlabel('xi')
title('Função Massa Probabilidade P(x)\n');