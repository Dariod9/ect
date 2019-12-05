#include"pqueue.h"
#include"stdio.h"

int main(void){
    int a[9]={2,6,3,4,8,1,7,9,5};
    PtPQueue q= PQueueCreate(9);

    for(int i=0;i<9;i++){
        PQueueInsert(q,a[i]);
    }

    for(int i=8;i>=0;i--){
        int tmp;
        PQueueDeleteMax(q,&tmp);
        a[i]=tmp;
    }

     for(int i=0;i<9;i++){
        printf("%d : %d\n", i+1, a[i]);
    }

}