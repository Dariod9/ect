%%
%a

N=10;
results= zeros(1,N); %vector with N simulation results
results2= zeros(1,N); %vector with N simulation results
for it= 1:N
    [results(it) results2(it)] = simulator1(20,100,4,500,'movies.txt');
end
alfa= 0.1; %90% confidence interval%
media = mean(results);
media2 = mean(results2);
term = norminv(1-alfa/2)*sqrt(var(results)/N);
term2 = norminv(1-alfa/2)*sqrt(var(results2)/N);
fprintf('resultado = %.2e +- %.2e\n',media,term)
fprintf('resultado = %.2e +- %.2e\n',media2,term2)

%%
%b

N=10;
gamas=[10 15 20 25 30 35 40];
data=zeros(1,7);
data2=zeros(1,7);
erros=zeros(1,7);
erros2=zeros(1,7);
results= zeros(1,N); %vector with N simulation results
results2= zeros(1,N); %vector with N simulation results
for ga= 1:7
    for it= 1:N
        [results(it) results2(it)] = simulator1(gamas(ga),100,4,500,'movies.txt');
    end

    alfa= 0.1; %90% confidence interval%
    media = mean(results);
    media2 = mean(results2);
    term = norminv(1-alfa/2)*sqrt(var(results)/N);
    term2 = norminv(1-alfa/2)*sqrt(var(results2)/N);
    %%fprintf('resultado = %.2e +- %.2e\n',media,term)
    %%fprintf('resultado = %.2e +- %.2e\n',media2,term2)
    data(ga)=media;
    data2(ga)=media2;
    erro(ga)=term;
    erro2(ga)=term2;
end

figure(1)

bar(gamas, data)                

hold on

er = errorbar(gamas,data,erro,erro);    
er.Color = [0 0 0];                            
er.LineStyle = 'none';  
grid on
hold off

figure(2)
bar(gamas, data2)                

hold on

er2 = errorbar(gamas,data2,erro2,erro2);    
er2.Color = [0 0 0];                            
er2.LineStyle = 'none';  
grid on
hold off

%%
%c


N=10;
gamas=[10 15 20 25 30 35 40];
data=zeros(1,7);
data2=zeros(1,7);
erros=zeros(1,7);
erros2=zeros(1,7);
results= zeros(1,N); %vector with N simulation results
results2= zeros(1,N); %vector with N simulation results
for ga= 1:7
    for it= 1:N
        [results(it) results2(it)] = simulator1(gamas(ga),100,4,5000,'movies.txt');
    end

    alfa= 0.1; %90% confidence interval%
    media = mean(results);
    media2 = mean(results2);
    term = norminv(1-alfa/2)*sqrt(var(results)/N);
    term2 = norminv(1-alfa/2)*sqrt(var(results2)/N);
    %%fprintf('resultado = %.2e +- %.2e\n',media,term)
    %%fprintf('resultado = %.2e +- %.2e\n',media2,term2)
    dataFinal(ga)=media;
    dataFinal2(ga)=media2;
    erroFinal(ga)=term;
    erroFinal2(ga)=term2;
end

figure(1)

bar(gamas, dataFinal)                

hold on

er = errorbar(gamas,dataFinal,erroFinal,erroFinal);    
er.Color = [0 0 0];                            
er.LineStyle = 'none';  
grid on
hold off

figure(2)
bar(gamas, dataFinal2)                

hold on

er2 = errorbar(gamas,dataFinal2,erroFinal2,erroFinal2);    
er2.Color = [0 0 0];                            
er2.LineStyle = 'none';  
grid on
hold off


%%
%d


N=10;
gamas=[100 150 200 250 300 350 400];
dataF=zeros(1,7);
dataF2=zeros(1,7);
errosF=zeros(1,7);
errosF2=zeros(1,7);
results= zeros(1,N); %vector with N simulation results
results2= zeros(1,N); %vector with N simulation results

for ga= 1:7
    for it= 1:N
        [results(it) results2(it)] = simulator1(gamas(ga),1000,4,5000,'movies.txt');
    end

    alfa= 0.1; %90% confidence interval%
    media = mean(results);
    media2 = mean(results2);
    term = norminv(1-alfa/2)*sqrt(var(results)/N);
    term2 = norminv(1-alfa/2)*sqrt(var(results2)/N);
    %%fprintf('resultado = %.2e +- %.2e\n',media,term)
    %%fprintf('resultado = %.2e +- %.2e\n',media2,term2)
    dataF(ga)=media;
    dataF2(ga)=media2;
    errosF(ga)=term;
    errosF2(ga)=term2;
end

figure(1)

bar(gamas, dataF)                

hold on

er = errorbar(gamas,dataF,errosF,errosF);    
er.Color = [0 0 0];                            
er.LineStyle = 'none';  
grid on
hold off

figure(2)
bar(gamas, data2)                

hold on

er2 = errorbar(gamas,dataF2,errosF2,errosF2);    
er2.Color = [0 0 0];                            
er2.LineStyle = 'none';  
grid on
hold off

%%
%e

N=100/4;

gamas=[10 15 20 25 30 35 40];
figure(1)

ro=86.3/60;

a= 1;
p= 1;

block = zeros(1,N);
ocup = zeros(1,N);
blockPercentagem = zeros(1,length(gamas));
blockError = zeros(1,length(gamas));

%ro=lambda/u
% 1/u = 86.3 minutes
u=86.3;

for i = 1:length(gamas)
    a=1;
    block(i)=1;
    ro=(gamas(i)/60)*u;
    for n=N:-1:1
        a=a*n/ro;
        block(i)=block(i)+a;
    end
    block(i)=1/block(i);
    blockPercentagem(i) = (block(i))*100;
end

%Average coiso

numerator=zeros(1,length(gamas))
denominator=zeros(1,length(gamas))
o=zeros(1,length(gamas))
u=86.3/60;

for j = 1:length(gamas)

    a= N;
    numerator(j)= a;
    ro=gamas(j)*u;
    for i= N-1:-1:1
     a= a*i/ro;
     numerator(j)= numerator(j) + a;
    end
    a= 1;
    denominator(j)= a;
    for i= N:-1:1
     a= a*i/ro;
     denominator(j)= denominator(j) + a;
    end
    o(j)= numerator(j)/denominator(j)
    
end

figure(1)
bar(gamas, [dataFinal; blockPercentagem])                

hold on
grid on
hold off

figure(2)
bar(gamas, [dataFinal2; o*4])                

hold on
grid on
hold off


%%
%f

N=1000/4;

gamas=[100 150 200 250 300 350 400];
figure(1)

ro=86.3/60;

a= 1;
p= 1;

block = zeros(1,N);
ocup = zeros(1,N);
blockPercentagem2 = zeros(1,length(gamas));
blockError = zeros(1,length(gamas));

%ro=lambda/u
% 1/u = 86.3 minutes
u=86.3;

for i = 1:length(gamas)
    a=1;
    block(i)=1;
    ro=(gamas(i)/60)*u;
    for n=N:-1:1
        a=a*n/ro;
        block(i)=block(i)+a;
    end
    block(i)=1/block(i);
    blockPercentagem2(i) = (block(i))*100;
end

%Average coiso

numerator=zeros(1,length(gamas))
denominator=zeros(1,length(gamas))
o2=zeros(1,length(gamas))
u=86.3/60;

for j = 1:length(gamas)

    a= N;
    numerator(j)= a;
    ro=gamas(j)*u;
    for i= N-1:-1:1
     a= a*i/ro;
     numerator(j)= numerator(j) + a;
    end
    a= 1;
    denominator(j)= a;
    for i= N:-1:1
     a= a*i/ro;
     denominator(j)= denominator(j) + a;
    end
    o2(j)= numerator(j)/denominator(j)
    
end

figure(1)
bar(gamas, [dataF; blockPercentagem])                

hold on
grid on
hold off

figure(2)
bar(gamas, [dataF; o*4])                

hold on
grid on
hold off


