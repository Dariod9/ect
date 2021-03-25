#include<stdio.h>


int c1,c2,c3=0;

int f1(int n)
{
int i, j,r= 0;

    for(i = 1; i <= n; i++)
        for(j = 1; j <=n;j++){
            r += 1;
            c1++;}
            return r;
}

int f2(int n)
{
    int i, j,r= 0;
    for(i = 1; i <= n; i++)
        for(j = 1; j <= i; j++){
            r += 1;
            c2++;}
            return r;
}

int f3 (int n)
{
    int i, j,r= 0;
        for(i = 1; i <= n; i++)
            for(j = i; j <=n; j++){
                r += j;
                c3++;}
    return r;
}

int f3count (int n)
{
    int count=0;
    int i, j=0;
        for(i = 1; i <= n; i++)
            for(j = i; j <=n; j++)
                count++;
    return count;
}


int main(void){

    char string[]="f1 \t Adicoes \t f2 \t Adicoes \t f3 \t Adicoes\n";
    printf(string);

    for(int i=0; i<11;i++){

        c1=0;
        int r1=f1(i);
        c2=0;
        int r2=f2(i);
        c3=0;
       int  r3=f3(i);

        printf(" %2d \t %2d \t \t %2d \t %2d \t \t %2d \t %2d \t\n",r1,c1,r2,c2,r3,c3);}
        printf(" \t  O(n²) \t \t O2(n²) \t \t");
}