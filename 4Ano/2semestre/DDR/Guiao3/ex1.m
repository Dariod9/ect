%%
%a

N=10;
P=10000;
confidence=90;

lambda=1800;
C=10;
%f=1000000; %a
f=10000;%b

pl=zeros(1,N);
apd=zeros(1,N);
mpd=zeros(1,N);
t=zeros(1,N);

for i=1:N
    [pl(i) apd(i) mpd(i) t(i)]=simulator1(lambda, C, f, P);
end




alfa= 0.1; %90% confidence interval%
mediaPL = mean(pl);
mediaAPD = mean(apd);
mediaMPD = mean(mpd);
mediaT = mean(t);

term = norminv(1-alfa/2)*sqrt(var(pl)/N);
term2 = norminv(1-alfa/2)*sqrt(var(apd)/N);
term3 = norminv(1-alfa/2)*sqrt(var(mpd)/N);
term4 = norminv(1-alfa/2)*sqrt(var(t)/N);

fprintf('resultado = %.2e +- %.2e\n',mediaPL,term)
fprintf('resultado = %.2e +- %.2e\n',mediaAPD,term2)
fprintf('resultado = %.2e +- %.2e\n',mediaMPD,term3)
fprintf('resultado = %.2e +- %.2e\n',mediaT,term4)

%%
% c) M/M/1 queueing model
lambda = 1800;
C = 10;     %(Mbps)

% B - tamanho medio de pacotes
tam= [65:109 111:1517];
perc=(100-(16+25+20))/length(tam)/100;

totalSize=64*0.16+110*0.25+1518*0.2;
%64 *16 110 * 25 1518 *20 

for i=1:length(tam)
    totalSize=totalSize+(tam(i)*perc);
end
%%mediaSize=totalSize/length(tam)
B = totalSize;
miu = (C*1e6) / (B*8);
APD = 1000 / (miu - lambda);

fprintf('\nPacket Loss: %.3e\n', 0);
fprintf('\nAverage Packet Delay: %.4e\n', APD);
%%fprintf('\nAverage Packet Delay: %.f\n', MPD);

%%
%d

N=10;
P=10000;
confidence=90;

lambda=1800;
C=10*1e6;
%f=1000000; %a
f=10000;%b

% B - tamanho medio de pacotes
tam= [65:109 111:1517];
perc=(100-(16+25+20))/length(tam)/100;

totalSize=64*0.16+110*0.25+1518*0.2;
%64 *16 110 * 25 1518 *20 

ES=(0.16*64*8/C)+(0.25*110*8/C)+(0.2*1518*8/C);
ES2=(0.16*(64*8/C)^2)+(0.25*(110*8/C)^2)+(0.2*(1518*8/C)^2);

T64=0.16*(1^(8*64))*lambda*8*64;
T110=0.25*(1^(8*110))*lambda*8*110;
T1518=0.2*(1^(8*1518))*lambda*8*1518;
TT=T64+T110+T1518;

for i=1:length(tam)
    TT=TT+(perc*(1^(8*tam(i)))*lambda*8*tam(i));
    
    ES=ES+(perc*tam(i)*8/C);
    ES2=ES2+(perc*(tam(i)*8/C)^2);
end

fprintf('\nES= %.4e \n',ES)
fprintf('ES2 = %.4e \n',ES2)
Wq=(lambda*ES2)/(2*(1-lambda*ES));
fprintf('Delay = %.4e \n',Wq*1000+ES*1000)
fprintf('TT (Mbps) = %.4e \n',TT/1e6)


%%
%e

m=round(f/B)+1