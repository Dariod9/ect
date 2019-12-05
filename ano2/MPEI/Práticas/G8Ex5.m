% a)

T = [ 0.7   0.2   0.3;
      0.2   0.3   0.3;
      0.1   0.5   0.4];

%% b)

I = [1; 0; 0];

nextDay = T^2 * I;

fprintf('Probabilidade de chover no dia a seguir: %f\n', nextDay(3));

% c)

n = 20;
potT = T;

evolution = zeros(9, n);
evolution(:,1) = potT(:);

for i=2:n
    potT = potT * T;
    evolution(:,i) = potT(:);
end

figure;
plot(evolution')

% d)

potT = T;
prev_T = zeros(3,3);

evolution = zeros(9, 1);
evolution(:,1) = potT(:);

threshold = 10^(-4);
evolution(:,1) = potT(:);

for i=2:n
    
    if (sum(sum(abs(potT - prev_T))) <= threshold) 
        break;
    end
    
    prev_T = potT;
    potT = potT * T;
    evolution(:,i) = potT(:);
end

plot(evolution')

display("Numero de interacoes até alcançar treshhold: ")
display(size(evolution,2))