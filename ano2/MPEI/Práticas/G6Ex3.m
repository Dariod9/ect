bloom=zeros(1,8000,'uint8');

letras=['a':'z' 'A':'Z' '0':'9'];

hashes=3;
arrayH=zeros(1,hashes,'uint8');

fich={'pg21209.txt','pg26017.txt'};
pmPT=pmfLetrasPT(fich,letras);
dist=cumsum(pmPT);


%Alinea a)
for i=1:hashes
  arrayH(i)=ceil(rand()*1000);
endfor

for i=1:1000
  s=stringMaker(0,40,letras);
  bloom=add(bloom,hashes,s);
endfor

%Alinea b)

cont=0;

for j=1:10000
  s=stringMaker(0,40,letras);
  if(checkExists(bloom,3,s))==true;
  cont=cont+1;
  endif;
endfor

display(cont)