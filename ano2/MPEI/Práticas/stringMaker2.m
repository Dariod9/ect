
function [ str ] = stringMaker2 (valorM, var, letters, alfaPt)
str = '';   

length = valorM + (sqrt(var)* randn());


for i=1:  length
    letterIndex = find(alfaPt > rand());
   
   str(i) = letters(letterIndex(1));
end
end