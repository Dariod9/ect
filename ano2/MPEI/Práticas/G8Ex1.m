
T = [0.7 0.8; 0.3 0.2];

% a)

I = [1; 0];
prob = T^2 * I;

display('Probabilidade de presença: \n')
display(prob(1))

% b)
I = [0; 1];
prob = T^2 * I;

display('Probabilidade de presença: \n')
display(prob(1))

% c)
I = [1; 0];
ultProb = T^29 * I;

display('Probabilidade de presença: \n')
display(ultProb(1))


% d)

I = [0.85; 0.15];
prob_present = zeros(30,1);
prob_not_present = zeros(30,1);

for i=1:30
    week_prob = T^(i-1) * I;
    prob_present(i) = week_prob(1);
    prob_not_present(i) = week_prob(2);
end

figure; 
hold on;
p1 = plot(prob_present);
p2 = plot(prob_not_present);
legend({"Probability of being present", "Probability of not being present"})
grid on
axis([0 30 0 1])
xlabel('Number of classes')
ylabel('Probability of not going to class')
title('Evolution of going or not to class')