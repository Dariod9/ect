%%
%a
n=100*8;
i=0;
p=0.01;
comb=nchoosek(n,i)

f0=comb*(p^i)*(1-p)^(n-i)

%%
%b
n=1000*8;
i=1;
p=0.001;
comb=nchoosek(n,i);


f1=comb*(p^i)*(1-p)^(n-i)

%%
%c

n=200*8;
i=0;
i2=1;
p=0.0001;
comb=nchoosek(n,i);
comb2=nchoosek(n,i2);

f1=comb*(p^i)*(1-p)^(n-i)
f2=comb2*(p^i2)*(1-p)^(n-i2)
f_2=1-(f0+f1)

%%
%d
p=logspace(-8,-2);
m=100*8;
i=0

comb3=nchoosek(m,i);

f3=comb3*(p.^i).*(1-p).^(m-i);

m2=200*8;
comb4=nchoosek(m2,i);
f4=comb4*(p.^i).*(1-p).^(m2-i);

m3=1000*8;
comb5=nchoosek(m3,i);
f5=comb5*(p.^i).*(1-p).^(m3-i);

semilogx(p, f3*100, 'b-', p, f4*100, 'r--', p, f5*100, 'g:')

%%
%e
m=linspace(64*8,1518*8);
i=0;

p=0.0001;

f3= p^i * (1-p).^(m-i);


p2=0.001;

f4=p2^i * (1-p2).^(m-i);


p3=0.01;

f5=p3^i * (1-p3).^(m-i);

semilogy(m,f3*100,'b-',m,f4*100,'g:',m,f5*100,'r--' )
