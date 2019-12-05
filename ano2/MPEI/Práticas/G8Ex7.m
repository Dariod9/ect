
% a)

countInitial = [100; 200; 30];

T = [ 0.8   0.1   0.05; ...
      0.2   0.6   0.20; ...
      0.0   0.3   0.75];
  
count3Next = T^3 * countInitial;


fprintf(' Dinheiro da Ana: $%4.2f\n', count3Next(1));
fprintf(' DInheiro do Bernardo: $%4.2f\n', count3Next(2));
fprintf(' DInheiro da Catarina: $%4.2f\n\n', count3Next(3));


% b)
countYearNext = T^365 * countInitial;

fprintf(' Dinheiro da Ana: $%4.2f\n', countYearNext(1));
fprintf(' Dinheiro do Bernardo: $%4.2f\n', countYearNext(2));
fprintf(' Dinheiro da Catarina: $%4.2f\n\n', countYearNext(3));

% c)

n = 1;
countNNext = T * countInitial;
while(1) 
    n = n + 1;
    countNNext = T * countNNext;
    if(countNNext(3) > 130)
        break;
    end
end
fprintf(' Catarina tera mais de 130 apos %d transicoes\n', n);