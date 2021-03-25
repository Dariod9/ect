words=ScannerFile('file.txt')

bloomF=zeros(1,1000,'utf8');

count=0;
for i=1:length(words)
  
    if~(checkExists(bloomF,hashes,words(i)==1)
      count=count+1; 
      bloomF=add(bloomF,hashes,words(i));
    endif
    
endfor

fprintf('No ficheiro são escritas %d palavras diferentes', count)