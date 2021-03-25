function mat = createNewSimilarityMatrix(u, ut)

    num = length(ut); % Num
    
    Set = cell(num,1);
    for n = 1:num   
       
        ind = find(u(:,1) == ut(n));
 
        Set{n} = [Set{n} u(ind,2)];
    end
    %% Distancia de JAccard
    mat = zeros(num); 
    w = waitbar(0,'Calculating');
    for n1= 1:num
     
     waitbar(n1/num,w);
  
    
      for n2= n1+1:num
            a = length(intersect(Set{n1}, Set{n2}));
            mat(n1,n2) = 1 - a/(length(Set{n1}) + length(Set{n2}) - a);
        end
    end
    
    
    delete (w)