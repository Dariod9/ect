#include"pqueue.h"
#include"stdio.h"

int main(void){
 
    int a[23]={5,6,3,4,8,1,7,9,5,11,4,9,12,15,13,8,17,20,21,24,15,13,11};
    PtPQueue q= PQueueCreate(10);

    for(int i=0;i<9;i++){
        PQueueInsert(q,a[i]);
    }

    for(int i=10;i<23;i++){
        
        int tmp;
        
        PQueueDeleteMax(q,&tmp);

        if(tmp<a[i]){
            a[i]=tmp;
            PQueueInsert(q,tmp);
        }
        else PQueueInsert(q,a[i]);
        }



     for(int i=0;i<9;i++){
         int t2;
         PQueueDeleteMax(q,&t2);
         printf("%d\n",t2);
    }

}