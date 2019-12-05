#include<stdio.h>


int fatorial(int n)
{

    int r=0;
    for(int i=1; i<=n;i++){
        r=r*1;
    }

    return r;
}


int* checkFac(int n)
{

    int* fatores = malloc(10*sizeof(int));

    for(int i=0;i<10;i++){
    
    double tmp = n/10.0 - (int) n/10;
    fatores[i]=(int) (tmp*10);

    }

    return fatores;
    
}

int main(void)
{
 
int sum=0;

    int* f= malloc(10*sizeof(int));

    for(int i=0; i<1000000;i++)
    {
    
       sum=0;
       f=checkFac(i);
    
       for(int j=0; j<sizeof(f);j++){
           sum=sum+fatorial(f[j]);
       }
    
       if(sum==i) printf("%2d",i);
    }
}