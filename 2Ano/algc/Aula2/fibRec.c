#include<stdio.h>
#include<assert.h>
#include"elapsed-time.h"

typedef unsigned long long u64;

u64 numAdd;
u64 fib;



u64 addF(int n)
{

assert (n>=0);

if(n<2){
    return n;
}

numAdd++;

return (addF(n-1)+addF(n-2));

}


int main(void)
{
    
printf("  n v               Fn      time\n");
        printf("\n");

    for(int i=0;i<50;i++){
        numAdd=0;
       /* u64 r=addF(i);
        printf("%d  |  %llu  |  %llu \n", i, r,numAdd);*/

        

        double dt1=0;

            if(i<40 || dt1<50.0)
                {

                (void) elapsed_time();
                
                fib=addF(i);
                dt1=elapsed_time();

                printf("%3d  %20llu %12.9f\n", i, fib, dt1);
              }            
                
    
    }


}