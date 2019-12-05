function [tabela] = add(tabela, num, elem)

    for i=1:num
        
        u_el = [elem num2str(1:i)];
        
        el_index = rem(hash(u_el), length(tabela)) + 1;
        tabela(el_index) = 1;
    end
end