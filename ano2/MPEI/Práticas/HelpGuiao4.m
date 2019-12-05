% função massa probabildiade

x=1:10;
px=ones(1,10)/10;
subplot(1,2,1)
stem(x,px)
axis([0,11,0,0.12])
xlabel('x');
ylabel('p_x(x)')

%Funcão distribuição acumulada

FX=cumsum([0,px,0]);
subplot(1,2,2)
stairs(0:11,FX);
axis([o,11,0,1.1)];
xlabel('F_x(x)0');

%Valor esperado

EX= sum(x.*px)