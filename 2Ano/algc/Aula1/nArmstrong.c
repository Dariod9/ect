#include<stdio.h>

int verArm(int n)
{
int h1=(int) (n/100);
int h2=(int) (n/10 - h1*10);
int h3tmp= n/10- (int) (n/10);
int h3=h3tmp*10;

int pot1=h1^3;
int pot2=h2^3;
int pot3=h3^3;
int trig=pot1+pot2+pot3;

return trig;
}

int main(void)
{

    for(int i=100;i<=999;i++){

        if(verArm(i)==i)
            printf("%3d \n", i);

    }

}
