%%
%a

N=10;
lambda=[100 120 140 160 180 200];
data=zeros(1,6);
data2=zeros(1,6);
erros=zeros(1,6);
erros2=zeros(1,6);
results= zeros(1,N); %vector with N simulation results
results2= zeros(1,N); %vector with N simulation results
for ga= 1:length(lambda)
    for it= 1:N
        [results(it) results2(it)] = simulator2(lambda(ga),20,10,100,0,10000,'movies.txt');
    end

    alfa= 0.1; %90% confidence interval%
    media = mean(results);
    media2 = mean(results2);
    data(ga)=media;
    data2(ga)=media2;
    term = norminv(1-alfa/2)*sqrt(var(results)/N);
    term2 = norminv(1-alfa/2)*sqrt(var(results2)/N);
    %%fprintf('resultado = %.2e +- %.2e\n',media,term)
    %%fprintf('resultado = %.2e +- %.2e\n',media2,term2)
    errosF(ga)=term;
    errosF2(ga)=term2;
end

figure(1)

bar(lambda, data)                

hold on

er = errorbar(lambda,data,errosF,errosF);    
er.Color = [0 0 0];                            
er.LineStyle = 'none';  
grid on
hold off

figure(2)
bar(lambda, data2)                

hold on

er2 = errorbar(lambda,data2,errosF2,errosF2);    
er2.Color = [0 0 0];                            
er2.LineStyle = 'none';  
grid on
hold off

%%
%b


N=10;
lambda=[100 120 140 160 180 200];
data=zeros(1,6);
data2=zeros(1,6);
erros=zeros(1,6);
erros2=zeros(1,6);
results= zeros(1,N); %vector with N simulation results
results2= zeros(1,N); %vector with N simulation results
resultsb2= zeros(1,N); %vector with N simulation results
resultsb22= zeros(1,N); %vector with N simulation results
resultsb3= zeros(1,N); %vector with N simulation results
resultsb32= zeros(1,N); %vector with N simulation results


for ga= 1:length(lambda)
    for it= 1:N
        [results(it) results2(it)] = simulator2(lambda(ga),20,10,100,0,10000,'movies.txt');
        [resultsb2(it) resultsb22(it)] = simulator2(lambda(ga),20,4,250,0,10000,'movies.txt');
        [resultsb3(it) resultsb32(it)] = simulator2(lambda(ga),20,1,1000,0,10000,'movies.txt');
    end

    alfa= 0.1; %90% confidence interval%
    media = mean(results);
    media2 = mean(results2);
    mediab2 = mean(resultsb2);
    mediab22 = mean(resultsb22);
    mediab3 = mean(resultsb3);
    mediab32 = mean(resultsb32);
    data(ga)=media;
    data2(ga)=media2;
    datab2(ga)=mediab2;
    datab22(ga)=mediab22;
    datab3(ga)=mediab3;
    datab32(ga)=mediab32;
end

figure(1)

bar(lambda, [data; datab2;datab3])                

hold on

er = errorbar(lambda,data,erro,erro);    
er.Color = [0 0 0];                            
er.LineStyle = 'none';  
grid on
hold off

figure(2)
bar(lambda, [data2; datab22;datab32])                

hold on

er2 = errorbar(lambda,data2,erro2,erro2);    
er2.Color = [0 0 0];                            
er2.LineStyle = 'none';  
grid on
hold off


%% 2 c) d)

lambda = [100 120 140 160 180 200]; 
p = 20;
n = 10;
S = 100;
% W = 0;    % b
% W = 400;  % c
 W = 600;  % d
R = 10000;
fname = 'movies.txt';

% number of simulations
N = 10; 

% vectors with N simulation results
block_hd = zeros(1,N); 
block_4k = zeros(1,N);
block_hd2 = zeros(1,N); 
block_4k2 = zeros(1,N);
block_hd3 = zeros(1,N); 
block_4k3 = zeros(1,N);

mediaBlock_hd = zeros(1,size(lambda, 2));
mediaBlock_hd2 = zeros(1,size(lambda, 2));
mediaBlock_hd3 = zeros(1,size(lambda, 2));

mediaBlock_4k = zeros(1,size(lambda, 2));
mediaBlock_4k2 = zeros(1,size(lambda, 2));
mediaBlock_4k3 = zeros(1,size(lambda, 2));

for i = 1:size(lambda, 2)
    for it= 1:N
        [block_hd(it), block_4k(it)] = simulator2(lambda(i), p, n, S, W, R, fname);
        [block_hd2(it), block_4k2(it)] = simulator2(lambda(i), p, 4, 250, W, R, fname);
        [block_hd3(it), block_4k3(it)] = simulator2(lambda(i), p, 1, 1000, W, R, fname);
    end
    
    %90% confidence interval%
    alfa= 0.1; 
    mediaBlock_hd(i) = mean(block_hd);
    mediaBlock_4k(i) = mean(block_4k);
    
    mediaBlock_hd2(i) = mean(block_hd2);
    mediaBlock_4k2(i) = mean(block_4k2);
    
    mediaBlock_hd3(i) = mean(block_hd3);
    mediaBlock_4k3(i) = mean(block_4k3);
    
end


figure(3)
bar(lambda,[mediaBlock_hd; mediaBlock_hd2; mediaBlock_hd3])
legend('HD1', 'HD2', 'HD3', 'Location', 'northwest')
ylim([0 100])
grid on

figure(4)
bar(lambda,[mediaBlock_4k; mediaBlock_4k2; mediaBlock_4k3])
legend('4k1', '4k2', '4k3', 'Location', 'northwest')
ylim([0 100])
grid on

%%
%e


results= 0; %zeros(1,N); %vector with N simulation results
results2= 0; %zeros(1,N); %vector with N simulation results

lambda = 100000/24;

results=zeros(1,4);
results2=zeros(1,4);
n=[4 5 6 7 ];
W=110;
R=100000;
for i=1:4
    [results(i) results2(i)] = simulator2(lambda,24,n(i),10000,W,R,'movies.txt');
end

figure(1)

bar(n, [results; results2])
title('Blocking probabilities for n servers - W = 110')
xlabel('Number of servers')

ylim([0 2])


grid on

media = mean(results);
media2 = mean(results2);
fprintf(" Media 1 : %.7f \n",media)
fprintf(" Media 2 : %.7f \n \n",media2)