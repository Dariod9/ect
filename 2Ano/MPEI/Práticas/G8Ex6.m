% a)

H = [ 0.8    0.0    0.3    0.0; ...
      0.2    0.9    0.2    0.0; ...
      0.0    0.1    0.4    0.0; ...
      0.0    0.0    0.1    1.0];

% b)

prob100 = H^1000 * [1; 0; 0; 0]

display(prob100(2))

%Estado absorvente!

% c)

prob1 = zeros(4, 4);
prob2 = zeros(4, 4);
prob100 = zeros(4, 4);

for i=1:4
    
    I = [1;2;3;4] == i;
    
    tmp = H^1 * I;
    prob1(:,i) = tmp(:);
    tmp2 = H^2 * I;
    prob2(:,i) = tmp2(:);
    tmp3 = H^100 * I;
    prob100(:,i) = tmp3(:);
end

for i=1:4
    fprintf('Para%d\n', i)
    for j=1:4
      
       fprintf('\tProbabilidade de %d apos 1 transicao:  %f\n', j, prob1(j,i))
       fprintf('\tProbabilidade de %d apos 2 transicoes : %f\n', j, prob2(j,i))
       fprintf('\tProbabilidade de %d apos 100 transicoes: %f\n\n', j, prob100(j,i))
    
    end
end

%% d)
Q = H(1:3,1:3);

% e)
n = size(Q, 1);
F = inv(eye(n) - Q);

% f)
meanOfIterations = sum(F);

fprintf('Media de transicoes (estado 1): %f\n', meanOfIterations(1));
fprintf('Media de transicoes (estado 2): %f\n', meanOfIterations(2));
fprintf('Media de transicoes (estado 3): %f\n', meanOfIterations(3));

% g)

fprintf('Media de transicoes (estado 1): %f\n', meanOfIterations(1));
fprintf('Media de transicoes (estado 2): %f\n', meanOfIterations(2));
fprintf('Media de transicoes (estado 3): %f\n', meanOfIterations(3));


% h)
%Aumentando:

nH = [ 0.8    0.1    0.5    0.0; ...
         0.2    0.8    0.25   0.0; ...
         0.0    0.1    0.2    0.0; ...
         0.0    0.0    0.05   1.0];
     
nQ = nH(1:3,1:3);
nF = inv(eye(3) - nQ);
meanOfIterations = sum(nF);

fprintf('Nova media de transicoes (estado 1): %f\n', meanOfIterations(1));
fprintf('Nova media de transicoes (estado 2): %f\n', meanOfIterations(2));
fprintf('Nova media de transicoes (estado 3): %f\n', meanOfIterations(3));