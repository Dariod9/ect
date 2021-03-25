% a)

p = 0.4;
q = 0.6;
ar = [   p.^2, 0, 0, q.^2;       (1-p).^2, 0, 0, q.*(1-q);   
        p.*(1-p), 0, 0, q.*(1-q);   p.*(1-p), 1, 1, (1-q).^2];

% b)

I = [1; 0; 0; 0];

after10 = ar^10 * I;

fprintf('Prob de estar no estado A (após 10): %f\n', after10(1))
fprintf('Prob de estar no estado B (após 10): %f\n', after10(2))
fprintf('Prob de estar no estado C (após 10): %f\n', after10(3))
fprintf('Prob de estar no estado D (após 10): %f\n', after10(4))