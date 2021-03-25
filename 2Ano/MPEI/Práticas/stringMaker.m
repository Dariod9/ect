#Alinea 1)

function [ str ] = stringMaker ( min, max, letras )
length = randi([min max]);          % generates a random length
str = '';                                           
for i=1:  length
    str(i) = letras(ceil(rand()*52));
end

end