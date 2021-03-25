#Alinea 3)
n = 1000;
fator = 0.8;
letras = ['a':'z' 'A':'Z'];

m= round(n/fator);
contador_djb2 = zeros(1, m);


for i = 1: n
    key = stringMaker (3,20, letras)      % Ex. 1
    value_djb2 = rem(hash(key), m) + 1;  % Ex. 2 
    value_sdbm = rem(hash(key, 'sdbm'), m) + 1;
    contador_djb2(value_djb2)  = contador_djb2(value_djb2) + 1;
end


% djb2
        figure
        subplot(221)
        bar(contador_djb2, 'r')
        grid on
        title('Strings mapped pela função hash: djb2')
        drawnow
        
        
#Alinea 4)
x = [0:9]; 

% Para o algoritmo djb2
figure
subplot(1,2,1)
successes_djb2 = histc(contador_djb2, 0:9);
pmfX_djb2 = successes_djb2 / m;
stem(0:9, pmfX_djb2);
grid on;
title('Variável X pmf (djb2 case)');
axis([-0.5, 9.5, 0, 0.5]);
drawnow

fprintf('Algoritmo djb2: ');
e_x = sum(x.*pmfX_djb2);
fprintf('\n\tE[X] = %f', e_x);
e_x2 = sum((x.^2).*pmfX_djb2);
fprintf('\n\tVar(X) = %f', e_x2 - e_x^2);
fprintf('\n')