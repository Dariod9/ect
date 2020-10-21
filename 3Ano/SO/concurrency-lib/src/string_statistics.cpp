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

#include  "thread.h"
#include  "utils.h"

/** \brief internal storage size of <em>FIFO memory</em> */
#define  FIFOSZ         15

typedef struct ServiceRequest {
    unsigned int client_id;
    char *string;
} ServiceRequest;

typedef struct ServiceResponse {
    unsigned int server_id;
    unsigned int char_num;
    unsigned int digit_num;
    unsigned int letter_num;
} ServiceResponse;

typedef struct SLOT {
    ServiceRequest request;
    ServiceResponse response;
    bool responseIsAvailable = false;
    pthread_cond_t responseAvailable = PTHREAD_COND_INITIALIZER;
    pthread_mutex_t accessCR = PTHREAD_MUTEX_INITIALIZER;
} SLOT;

typedef struct FIFO {
    unsigned int ii;   ///< point of insertion
    unsigned int ri;   ///< point of retrieval
    unsigned int cnt;  ///< number of items stored
    uint32_t slot[FIFOSZ];  ///< storage memory
    pthread_cond_t fifoNotFull = PTHREAD_COND_INITIALIZER;
    pthread_cond_t fifoNotEmpty = PTHREAD_COND_INITIALIZER;
    pthread_mutex_t accessCR = PTHREAD_MUTEX_INITIALIZER; // access critical section
} FIFO;

SLOT slots[FIFOSZ];
static FIFO free_slots;
static FIFO pending_slots;

uint32_t callService(ServiceRequest &req, ServiceResponse &res);
void processService(unsigned int server_id);
void insert(FIFO *fifo, uint32_t id);
uint32_t retrieve(FIFO *fifo);
void signalResponseIsAvailable(uint32_t id);
void waitForResponse(uint32_t id);

void freeInit();
static bool fifoFull(FIFO *fifo);
static bool fifoEmpty(FIFO *fifo);

void printRequest(uint32_t slot_id);
void printResponse(uint32_t slot_id);
char *getString();
void printFIFOS();

/* Initialization of the FIFO */
void freeInit() {
    mutex_lock(&free_slots.accessCR);

    unsigned int i;
    for (i = 0; i < FIFOSZ; i++) {
        free_slots.slot[i] = i;
    }
    free_slots.ii = 0;
    free_slots.ri = 0;
    free_slots.cnt = FIFOSZ;

    cond_signal(&free_slots.fifoNotEmpty);

    mutex_unlock(&free_slots.accessCR);
}

/* Initialization of the FIFO */
void pendingInit() {
    mutex_lock(&pending_slots.accessCR);

    pending_slots.ii = 0;
    pending_slots.ri = 0;
    pending_slots.cnt = 0;

    cond_signal(&pending_slots.fifoNotFull);

    mutex_unlock(&pending_slots.accessCR);
}

/* Check if FIFO is full */
static bool fifoFull(FIFO *fifo) {
    return fifo->cnt == FIFOSZ;
}

/* Check if FIFO is empty */
static bool fifoEmpty(FIFO *fifo) {
    return fifo->cnt == 0;
}

void insert(FIFO *fifo, uint32_t id) {
    mutex_lock(&fifo->accessCR);

    /* wait while fifo is full */
    while (fifoFull(fifo)) {
        cond_wait(&fifo->fifoNotFull, &fifo->accessCR); // aguardar sinalização de que o fifo não cheio
    }

    /* Insert */
    fifo->slot[fifo->ii] = id;			// inserir id no point of insertion
    fifo->ii = (fifo->ii + 1) % FIFOSZ; // atualizar point of insertion
    fifo->cnt++;						// incrementar counter

    cond_signal(&fifo->fifoNotEmpty);	// sinalizar que fifo não está vazio

    mutex_unlock(&fifo->accessCR);
}

uint32_t retrieve(FIFO *fifo) {
    mutex_lock(&fifo->accessCR);

    /* wait while fifo is empty */
    while (fifoEmpty(fifo)) {
        cond_wait(&fifo->fifoNotEmpty, &fifo->accessCR); // aguardar sinalização de que o fifo não está vazio
    }

    /* Retrieve */
    uint32_t res;
    res = fifo->slot[fifo->ri];			// buscar id no point of retrieval
    fifo->ri = (fifo->ri + 1) % FIFOSZ; // incrementar point of retrieval
    fifo->cnt--;						// decrementar point of retrieval

    cond_signal(&fifo->fifoNotFull);	// sinalizar que fifo não está cheio

    mutex_unlock(&fifo->accessCR);

    return res;							// retornar id
}

// sinalizar que resposta está available
void signalResponseIsAvailable(uint32_t id) {
    cond_signal(&slots[id].responseAvailable);
    slots[id].responseIsAvailable = true;
}

// esperar reposta do server
void waitForResponse(uint32_t id) {
    while(!slots[id].responseIsAvailable) {
        cond_wait(&slots[id].responseAvailable, &slots[id].accessCR);
    }
}

// fazer request
uint32_t callService(ServiceRequest &req, ServiceResponse &res) {
    uint32_t slot_id = retrieve(&free_slots); // buscar id para fazer request

    mutex_lock(&slots[slot_id].accessCR);
    slots[slot_id].request = req;
    slots[slot_id].response = res;
    printRequest(slot_id);
    insert(&pending_slots, slot_id); // insere request no fifo dos pending slots
    //printf("waiting for slot #%d\n", slot_id);
    waitForResponse(slot_id);
    mutex_unlock(&slots[slot_id].accessCR);

    return slot_id;
}

// processar request
void processService(unsigned int server_id) {
    uint32_t slot_id = retrieve(&pending_slots); // buscar id dos pending
    mutex_lock(&slots[slot_id].accessCR);
    slots[slot_id].response.server_id = server_id;

    for(unsigned int i = 0; slots[slot_id].request.string[i] != '\0'; i++) {
        slots[slot_id].response.char_num++;
        if (slots[slot_id].request.string[i] >= 0x30 && slots[slot_id].request.string[i] <= 0x39) {
            slots[slot_id].response.digit_num++;
        }
        else if ((slots[slot_id].request.string[i] >= 0x41 && slots[slot_id].request.string[i] <= 0x5A) ||
        (slots[slot_id].request.string[i] >= 0x61 && slots[slot_id].request.string[i] <= 0x7A)) {
            slots[slot_id].response.letter_num++;
        }
    }

    signalResponseIsAvailable(slot_id); 		// sinalizar que o request foi processado e já tem response available
    mutex_unlock(&slots[slot_id].accessCR);
    //printf("server finished slot #%d\n", slot_id);
}

void printRequest(uint32_t slot_id) {
    printf("Request made by client #%d in slot #%d: %s\n", slots[slot_id].request.client_id, slot_id,
            slots[slot_id].request.string);
}

void printResponse(uint32_t slot_id) {
    mutex_lock(&slots[slot_id].accessCR);
    printf("Response processed by server #%d in slot #%d:\nChar number: %d\nDigit number: %d\nLetter number: %d\n",
          slots[slot_id].response.server_id, slot_id, slots[slot_id].response.char_num,
          slots[slot_id].response.digit_num, slots[slot_id].response.letter_num);
    mutex_unlock(&slots[slot_id].accessCR);
}

char *getString() {
    return (char*) "Test String 1";
}

/* The client thread */
void *client(void *argp) {
    int runtime = 600;
    int id = *((int *) argp);
    printf("Client #%d is online\n", id);

    while (1) {
        ServiceRequest * req = new ServiceRequest();
        req->client_id = id;
        req->string = getString();
        ServiceResponse * res = new ServiceResponse();
        uint32_t slot_id = callService(*req, *res);
        printResponse(slot_id);
        slots[slot_id].responseIsAvailable = false;
        free(req);
        free(res);
        insert(&free_slots, slot_id);
        runtime--;
        if (runtime == 0){
            return 0;
        }
    }
}

/* The server thread */
void *server(void *argp) {
    int id = *((int *) argp);
    printf("Server #%d is online\n", id);

    while (1) {
        processService(id);
    }
}

void printFIFOS() {
    printf("\nfree_slots: ");
    for(unsigned int i = 0; i < FIFOSZ - 1; i++){
        printf("%d, ", free_slots.slot[(free_slots.ri + i) % FIFOSZ]);
    }
    printf("%d\n", free_slots.slot[(free_slots.ri + FIFOSZ - 1) % FIFOSZ]);
    printf("pending_slots: ");
    for(unsigned int i = 0; i < FIFOSZ - 1; i++){
        printf("%d, ", pending_slots.slot[(pending_slots.ri + i) % FIFOSZ]);
    }
    printf("%d\n\n", pending_slots.slot[(pending_slots.ri + FIFOSZ - 1) % FIFOSZ]);
}

int main() {
    freeInit(); // inicializar FIFO dos free slots
    pendingInit();	// inicializar FIFO dos pending slots

    printFIFOS();

    pthread_t cthr[8];   /* clients' ids */
    pthread_t sthr[3];   /* servers' ids */

    printf("Launching 2client threads\n");
    unsigned int i;
    for (i = 0; i < 2; i++){
        thread_create(&cthr[i], NULL, client, (void *) &i);
    }

    printf("Launching 1 server threads\n");
    unsigned int j;
    for (j = 0; j < 1;j++) {
        thread_create(&sthr[j], NULL, server, (void *) &j);
    }

    /* wait for threads to conclude */
    for (i = 0; i < 2;i++) {
        thread_join(cthr[i], NULL);
        printf("Client thread %d has terminated\n", i);
    }

    for (i = 0; i < 1; i++) {
        thread_cancel(sthr[i]);
        printf("Server thread %d has been cancelled\n", i);
    }

    return 0;
}