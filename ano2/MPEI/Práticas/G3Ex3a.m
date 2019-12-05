N = 1e5; 
p = 0.5;
n = 4;
lancamentos = rand(n, N);
sucessos = sum(lancamentos < 0.5);

func = histc(sucessos, 0:n) / N;
stem(func, 'r')
ylabel('P(X=xi)')
xlabel('xi')
title('Função Massa Probabilidade P(x)\n');