#include<stdio.h>
#include<assert.h>

typedef unsigned long long u64;

u64 numAdd;
u64 a;
u64 b;
u64 sum;


u64 addF(int n)
{

assert (n>=0);

if(n<2){
    return 1;
}

    a=0;
    b=1;
    sum=0;

    for(;n>1;n--){

        numAdd++;
        sum=a+b;

        a=b;
        b=sum;
        }




return sum;

}


int main(void)
{
    
    for(int i=0;i<10;i++){
        numAdd=0;
        sum=addF(i);
        printf("%d  |  %llu  |  %llu \n", i, sum,numAdd);
    }


}