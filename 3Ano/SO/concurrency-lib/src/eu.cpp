//
// Created by rrosmaninho on 25/11/19.
//

#include  <stdio.h>
#include  <stdlib.h>
#include  <stdint.h>
#include  <libgen.h>
#include  <unistd.h>
#include  <sys/wait.h>
#include  <sys/types.h>
#include  <pthread.h>
#include  <math.h>
#include  <string>

#include  "thread.h"
#include  "utils.h"

using namespace std;

/** \brief internal storage size of <em>FIFO memory</em> */
#define  FIFOSZ         15

typedef struct FIFO {
    unsigned int ii;   ///< point of insertion
    unsigned int ri;   ///< point of retrieval
    unsigned int cnt;  ///< number of items stored
    uint32_t slot[FIFOSZ];  ///< storage memory
    pthread_cond_t isNotEmpty = PTHREAD_COND_INITIALIZER;
    pthread_cond_t isNotFull = PTHREAD_COND_INITIALIZER;
    pthread_mutex_t access = PTHREAD_MUTEX_INITIALIZER;
} FIFO;

typedef struct ServiceRequest {
    uint32_t client_id;
    string req_string;
} ServiceRequest;

typedef struct ServiceResponse {
    uint32_t server_id;
    uint32_t char_num;
    uint32_t letter_num;
    uint32_t digit_num;
} ServiceResponse;

typedef struct SLOT {
    ServiceRequest req;
    ServiceResponse res;
    bool responseIsAvailable = false;
    pthread_cond_t isAvailable = PTHREAD_COND_INITIALIZER;
    pthread_mutex_t access = PTHREAD_MUTEX_INITIALIZER;
} SLOT;

static SLOT slots[FIFOSZ];
static FIFO pending_slots;
static FIFO free_slots;

void insert(FIFO * fifo, uint32_t id){
    mutex_lock(&free_slots.access);

    while(fifo->cnt==FIFOSZ){
        cond_wait(&fifo->isNotFull, &fifo->access);
    }

    fifo->slot[fifo->ii]=id;
    fifo->ii=(fifo->ii+1)%FIFOSZ;
    fifo->cnt++;

    cond_signal(&fifo->isNotEmpty);

    mutex_unlock(&free_slots.access);
}

uint32_t retrieve(FIFO * fifo){
    mutex_lock(&fifo->access);

    while(fifo->cnt==0){
        cond_wait(&fifo->isNotEmpty, &fifo->access);
    }

    uint32_t ret=fifo->slot[fifo->ri];
    fifo->ri=(fifo->ri+1) % FIFOSZ;
    fifo->cnt--;

    cond_signal(&fifo->isNotFull);

    mutex_unlock(&fifo->access);
    return ret;
}

void signalResponseIsAvailable(uint32_t id){
    mutex_lock(&slots[id].access);
    cond_signal(&slots[id].isAvailable);
    slots[id].responseIsAvailable=true;
    mutex_unlock(&slots[id].access);
}

void waitForResponse(uint32_t id){
    mutex_lock(&slots[id].access);
    while(!&slots[id].responseIsAvailable){
        cond_wait(&slots[id].isAvailable, &slots[id].access);   
    }
    slots[id].responseIsAvailable=false;
    mutex_unlock(&slots[id].access);
}

void callService(ServiceRequest & req, ServiceResponse & res){
    uint32_t ret=retrieve(&free_slots);
    mutex_lock(&slots[ret].access);
    slots[ret].req=req;
    slots[ret].res=res;
    mutex_unlock(&slots[ret].access);
    insert(&pending_slots, ret);
    waitForResponse(ret);
    insert(&free_slots,ret);
}


void processService(){
    uint32_t ret=retrieve(&pending_slots);
    mutex_lock(&slots[ret].access);
    slots[ret].res.char_num=4;
    mutex_unlock(&slots[ret].access);
    signalResponseIsAvailable(ret);
}