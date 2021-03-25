
function retval = prob (input1)
cont=0;
for I=1:200
  N=1e5;
  p=0.5;
  k=input1;
  n=4;
  lancamentos=rand(n,N) > p;
  sucessos = sum(lancamentos) ==k;
  probSimulacao = sum(sucessos)/N;
  cont=cont+probSimulacao;
end
cont/200
endfunction
