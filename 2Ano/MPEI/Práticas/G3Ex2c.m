
f="{(x,y) pertencentes a  N, X pertencente a {5,50,100} ^ x pertencente a N: f(5)=9/10, f(50)=9/100, f(100)=1/100}"

x=[5,50,100];
px=[9/10,9/100,1/100];
subplot(1,2,1)
stem(x,px)
axis([0,105,0,0.9]);
xlabel('x');
ylabel('p_x(x)')