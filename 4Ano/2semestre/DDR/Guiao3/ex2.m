% INPUT PARAMETERS:
lambda = 1800;  % lambda - packet rate (packets/sec)
C = 10;         % link bandwidth (Mbps)
f = 1000000;    % 
P = 10000;      % number of packets (stopping criterium)
% b = 1e-6;   % a)
b = 1e-5;    % b)

% OUTPUT PARAMETERS:
%  PL   - packet loss (%)
%  APD  - average packet delay (milliseconds)
%  MPD  - maximum packet delay (milliseconds)
%  TT   - transmitted throughput (Mbps)

N = 20;  % number of simulations

PL = zeros(1,N); 
APD = zeros(1,N);
MPD = zeros(1,N);
TT = zeros(1,N);

for it= 1:N
    [PL(it), APD(it), MPD(it), TT(it)] = simulator2(lambda, C, f, P, b);
end

% 90confidence interval %
alfa= 0.1; 

mediaPL = mean(PL);
termPL = norminv(1-alfa/2)*sqrt(var(PL)/N);

mediaAPD = mean(APD);
termAPD = norminv(1-alfa/2)*sqrt(var(APD)/N);

mediaMPD = mean(MPD);
termMPD = norminv(1-alfa/2)*sqrt(var(MPD)/N);

mediaTT = mean(TT);
termTT = norminv(1-alfa/2)*sqrt(var(TT)/N);
    
fprintf('\nPacket Loss: %.4f + %.4f\n', mediaPL, termPL);
fprintf('Avg packet delay (ms): %.4f + %.4f\n', mediaAPD, termAPD);
fprintf('Max packet delay (ms): %.4f + %.4f\n', mediaMPD, termMPD);
fprintf('Throughtput (Mbps): %.4f +- %.4f\n', mediaTT, termTT);

%%
% c M/G/1 queueing model

lambda = 1800;
C = 10 * 1e6;     %(Mbps)

% B - tamanho medio de pacotes
tam= [65:109 111:1517];
pres = ((100 - (16+25+20)) / length(tam)) / 100;
p64 = 0.16;
p110 = 0.25;
p1518 = 0.20;

% packet loss
pl64 = p64 * (1 - ((1 - b)^(8*64)));
pl110 = p110 * (1 - ((1 - b)^(8*110)));
pl1518 = p1518 * (1 - ((1 - b)^(8*1518)));

pli = pl64 + pl110 + pl1518;

for i=1:length(tam)
    pli = pli + (pres * (1 - ((1 - b)^(8*i))));
end


es64 = p64 * ((8 * 64) / C);
es110 = p110 * ((8 * 110) / C);
es1518 = p1518 * ((8 * 1518) / C);
ess64 = p64 * ((8 * 64) / C)^2;
ess110 = p110 * ((8 * 110) / C)^2;
ess1518 = p1518 * ((8 * 1518) / C)^2;

es = es64 + es110 + es1518;
ess = ess64 + ess110 + ess1518;

T64= p64 * (1^(8*64)) * lambda*8*64;
T110= p110 * (1^(8*110)) * lambda*8*110;
T1518= p1518 * (1^(8*1518)) * lambda*8*1518;
TT= T64 + T110 + T1518;

for i=1:length(tam)
    es = es + (pres * ((8 * tam(i)) / C));
    ess = ess + (pres * ((8 * tam(i)) / C)^2);
    TT=TT+(pres*(1^(8*tam(i)))*lambda*8*tam(i));
end

wq = (lambda * ess) / (2 * (1 - lambda * es));
w = wq*1000 + es*1000;

fprintf('\nPacket Loss: %.4e\n', pli);
fprintf('Avg packet delay (ms): %.4e\n', w);
fprintf('Throughtput (Mbps): %.4e\n', TT);