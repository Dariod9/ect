udata=load('u.data');  % Ficheiro

u = udata(1:end,1:2);

% Lista de uts
ut = unique(u(:,1)); 
num = length(ut); 

if exist('matriz.mat', 'file')
    % Existe a matriz
    load Jmatrix
else
    %display(
    fprintf('A gerar matriz:');
  
    J = simMatriz(u, ut);
    save Jmatrix J
end

fprintf('Searching for similar pairs...\n');

threshold = 0.4;

simUsers= zeros(1,3);
k= 1;

for n1= 1:num
      
      
      for n2= n1+1:num
        if areSimilar(n1, n2, J, threshold)
            simUsers(k,:) = [ut(n1) ut(n2) J(n1,n2)];
            k = k+1; 
        end
    end
end

simUsers
fprintf('--- %d similar users\n', k-1);