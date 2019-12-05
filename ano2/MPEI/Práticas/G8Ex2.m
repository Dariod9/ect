
T = [ 1/3    .25    0;  
      1/3    .55    .5; 
      1/3    .20    .5];
  
% Confirmar se é estocástica
stoch = sum(sum(T)) - size(T,1);

display("É matriz estocástica: ")
if stoch=0
  display("false")
else display("true")
endif


%% (b)

I = [.5; .25; .25];

% c)

dist = T^30 * I;

fprintf('Numero de estudantes A: %d\n', round(90*dist(1)))
fprintf('Numero de estudantes B: %d\n', round(90*dist(2)))
fprintf('Numero de estudantes C: %d\n\n', round(90*dist(3)))

% d)

I = [1/3; 1/3; 1/3];

dist = T^30 * I;

fprintf('Numero de estudantes A: %d\n', round(90*dist(1)))
fprintf('Numero de estudantes B: %d\n', round(90*dist(2)))
fprintf('Numero de estudantes C: %d\n\n', round(90*dist(3)))