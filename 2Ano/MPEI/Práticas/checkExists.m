function [boolean] = checkExists(tabela, num, elem)

  boolean=true;

    for i=1:num     
        u_el = [elem num2str(1:i)];
        
        el_index = rem(hash(u_el), length(tabela)) + 1;
        
        if(tabela(el_index)==0)
          boolean=false;
          break;
        endif
    end
end