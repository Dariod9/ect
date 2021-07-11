% a)
denominador = (1 + (5) + ((5)*(50/2)) + ((5)*(50/2)*(200/5)) + ((5)*(50/2)*(200/5)*(600/8)));
 
 s2 = 1 / denominador;
 s3 = (5) / denominador;
 s4 = ((5)*(50/2)) / denominador; 
 s5 = ((5)*(50/2)*(200/5)) / denominador;
 s6 = ((5)*(50/2)*(200/5)*(600/8)) / denominador;
 
 % prob interference
 int = s2 + s3
 % prob normal state
 normal = s4 + s5 + s6
 
 %%
 % b)
 % avg ber interference state
 interBer = [10^-3 10^-2];
 interStates = [s3  s2]; 
 avgBerInter = sum(interStates .* interBer) / int
 
 % avg ber normal state
 normalBer = [10^-6 10^-5 10^-4];
 normalStates = [s6 s5 s4];
 avgBerNormal = sum(normalStates .* normalBer) / normal
 
 %%
 % c)
 % calc prob de o pacote ter erros em cada estado
    
 % 1 ou mais erros = 1 - f(0)
 
 % n -> numero de bytes
 % p -> error rate
 % f -> probabilidade em cada estado
 
 n = linspace(64, 200);
 n = n*8;
 
 p = 10^-6;
 f6 = (1 - (1 * p^0 * (1-p).^(n-0))) * 100;
 
 p = 10^-5;
 f5 = (1 - (1 * p^0 * (1-p).^(n-0))) * 100;
 
 p = 10^-4;
 f4 = (1 - (1 * p^0 * (1-p).^(n-0))) * 100;
 
 p = 10^-3;
 f3 = (1 - (1 * p^0 * (1-p).^(n-0))) * 100;
 
 p = 10^-2;
 f2 = (1 - (1 * p^0 * (1-p).^(n-0))) * 100; 
 
 prob_normal_w_errors = (s4*f4 + s5*f5 + s6*f6) ./ (s2*f2 + s3*f3 + s4*f4 + s5*f5 + s6*f6);
 
 figure(1)
 plot(n/8, prob_normal_w_errors, 'b-')
 title('Probability of link in the normal state and packet received contains errors')
 xlabel('Packet Size (Bytes)')
 grid on
 
 %%
 % d)
 
 p = 10^-6;
 f6 = (1 * p^0 * (1-p).^(n-0)) * 100;
 
 p = 10^-5;
 f5 = (1 * p^0 * (1-p).^(n-0)) * 100;
 
 p = 10^-4;
 f4 = (1 * p^0 * (1-p).^(n-0)) * 100;
 
 p = 10^-3;
 f3 = (1 * p^0 * (1-p).^(n-0)) * 100;
 
 p = 10^-2;
 f2 = (1 * p^0 * (1-p).^(n-0)) * 100;
 
 prob_int_no_errors = (s2*f2 + s3*f3) ./ (s2*f2 + s3*f3 + s4*f4 + s5*f5 + s6*f6);
 
 figure(2)
 yy = [0 9];
 plot(n/8, prob_int_no_errors, 'b-')
 title('Probability of link in the interference state and receive a packet without errors')
 xlabel('Packet Size (Bytes)')
 grid on
 
 
 %%
 % 5
 
 % a)
 b = 64*8;
 
 n = linspace(2,5,4);
 
 errorRate = [10^-6 10^-5 10^-4 10^-3 10^-2];
 
 f6 = (1 - (1 * errorRate(1)^0 * (1-errorRate(1))^(b-0))).^n;
 
 f5 = (1 - (1 * errorRate(2)^0 * (1-errorRate(2))^(b-0))).^n;
 
 f4 = (1 - (1 * errorRate(3)^0 * (1-errorRate(3))^(b-0))).^n;
 
 f3 = (1 - (1 * errorRate(4)^0 * (1-errorRate(4))^(b-0))).^n; 
 
 f2 = (1 - (1 * errorRate(5)^0 * (1-errorRate(5))^(b-0))).^n;
 
 prob_false_positives = (s4*f4 + s5*f5 + s6*f6) ./ (s2*f2 + s3*f3 + s4*f4 + s5*f5 + s6*f6) * 100;
 
 figure(3)
 semilogy(n, prob_false_positives, 'b-')
 title('Probability of false positives')
 xlabel('N frames')
 grid on
 
 %%
 % b)
 % prob de pelos menos 1 pacote sem erros = 1 - prob de todos terem erros
 n = linspace(2,5,4);
 b = 64*8;
 errorRate = [10^-6 10^-5 10^-4 10^-3 10^-2];
 
 f6 = (1 - (1 - (1 * 1 * (1-errorRate(1))^(b-0))).^n);
 f5 = (1 - (1 - (1 * 1 * (1-errorRate(2))^(b-0))).^n);
 f4 = (1 - (1 - (1 * 1 * (1-errorRate(3))^(b-0))).^n);
 f3 = (1 - (1 - (1 * 1 * (1-errorRate(4))^(b-0))).^n);
 f2 = (1 - (1 - (1 * 1 * (1-errorRate(5))^(b-0))).^n);
 
 prob_false_negatives = (s2*f2 + s3*f3) ./ (s2*f2 + s3*f3 + s4*f4 + s5*f5 + s6*f6);
 
 figure(4)
 semilogy(n, prob_false_negatives * 100, 'b-')
 title('Probability of false negatives')
 xlabel('N frames')
 grid on
 
 
