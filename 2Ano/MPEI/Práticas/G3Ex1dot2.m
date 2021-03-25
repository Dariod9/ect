x=1:6;
px=ones(1,6)/6;
subplot(1,2,1)
stem(x,px)
axis([0,6,0,0.2]);
xlabel('x');
ylabel('p_x(x)')

FX=cumsum([0,px,0]);
subplot(1,2,2)
stairs(0:7,FX);
axis([0,8,0,1.2])
xlabel('x');
ylabel('F_X(x)');
