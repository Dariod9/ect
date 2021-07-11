%%
%a
p=0.6;
m=4;

y=p+(1-p)/m;

%%
%b
p=0.7;
m=5;

y2=p*m/(1+(m-1)*p);

display(x)


%%
%c
p=linspace(0,1);
n=3;
f3=p+(1-p)/n;
n=4;
f4=p+(1-p)/n;
n=5;
f5=p+(1-p)/n;

plot(p*100,f3*100,'b-',p*100,f4*100,'g:',p*100,f5*100,'r--' )

%%
%d
p=linspace(0,1);
m=3;
f3=p*m./(1+(m-1).*p);
display(f3)
m=4;
f4=p*m./(1+(m-1)*p);
m=5;
f5=p*m./(1+(m-1)*p);

plot(p*100,f3*100,'b-',p*100,f4*100,'g:',p*100,f5*100,'r--' )


