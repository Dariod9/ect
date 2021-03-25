% a)

ar = rand(20, 20);

for i=1:20
    ar(:, i) = ar(:, i) / sum(ar(:, i));
end

I = zeros(20,1);
I(1) = 1;

t20next = ar^20 * I;
fprintf('Prob de transicao: %f\n', t20next(20))

t40next = ar^40 * I;
fprintf('Prob de transicao: %f\n', t40next(20))
t100next = ar^100 * I;
fprintf('Prob de transicao: %f\n', t100next(20))