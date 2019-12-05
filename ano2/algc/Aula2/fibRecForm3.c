#include<stdio.h>
#include<assert.h>
#include<math.h>

typedef unsigned long long u64;

u64 numAdd;



u64 addF(int n)
{

u64 c=0.44721357549995793928;
u64 c2=0.48121182505960344750;

double teta=(1+sqrt(5))/2;

u64 r=round(c*exp((double) n*c2));
return r;

}


int main(void)
{
    
    for(int i=0;i<100;i++){
        
        u64 r=addF(i);
        printf("%d  |  %llu  \n", i, r);
    }


}
