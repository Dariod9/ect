% alfabeto simples 
% completar com outros caracteres 
alpha = ['A':'Z' 'a':'z' ];  

%  ficheiros a serem processados (do projecto Gutemberg
ficheiros={'pg21209.txt','pg26017.txt'};

% obter função massa de probabilidade (pmf em Inglês)
pmfPT=pmfLetrasPT(ficheiros,alpha);

%  visualizar função massa de probabilidade
stem(pmfPT)

n = 1000;
loadFactor = 0.8;
m= round(n/loadFactor);

contador_sdbm = zeros(1, m);

for i = 1: n
    key = stringMaker2(10,5,alphabet, distPT);
    value_sdbm = rem(hash(key, 'sdbm'), m) + 1;
    contador_sdbm(value_sdbm) = contador_sdbm(value_sdbm) + 1;
    
    if rem (i, 25) == 0        
        % sdbm
        subplot(223)
        bar(contador_sdbm, 'r')
        grid on
        title('Num of strings mapped by the hash function for each position: sdbm')
        drawnow
        
        subplot(224)
        hist(contador_sdbm, 0:9, 'r')
        grid on
        title('Histogram of string in each position: sdbm')
        drawnow
    end
 
end

#Exercicio 4 -> V2)
x = [0:9]; 

%sdbm
subplot(1, 2, 2)
successes_sdbm = histc(contador_sdbm, 0:9);
pmfX_sdbm = successes_sdbm / m;
stem(x, pmfX_sdbm, 'r');
grid on;
title('Random variable X pmf (sdbm case)');
axis([-0.5, 9.5, 0, 0.5]);
drawnow

fprintf('Algorithm sdbm: ');
e_x = sum(x.*pmfX_sdbm);
fprintf('\n\tE[X] = %f', e_x);
e_x2 = sum((x.^2).*pmfX_sdbm);
fprintf('\n\tVar(X) = %f\n', e_x2 - e_x^2);
fprintf('\n')