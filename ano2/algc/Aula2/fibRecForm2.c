#include<stdio.h>
#include<assert.h>
#include<math.h>

typedef unsigned long long u64;

u64 numAdd;



u64 addF(int n)
{

double teta=(1+sqrt(5))/2;

u64 r=round(pow(teta,n)/sqrt(5));
return r;

}


int main(void)
{
    
    for(int i=0;i<100;i++){
        
        u64 r=addF(i);
        printf("%d  |  %llu  \n", i, r);
    }


}
