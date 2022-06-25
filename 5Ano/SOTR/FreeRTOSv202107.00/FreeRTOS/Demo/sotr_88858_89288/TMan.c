/* Kernel includes. */
#include "FreeRTOS.h"
#include "task.h"
#include <math.h>

#include <xc.h>

/* Hardware specific includes. */
#include "ConfigPerformance.h"

#include "TMan.h"

/* Standard includes. */
#include <stdio.h>
#include <string.h>

#include <semphr.h>

/* App includes */
#include "../UART/uart.h"

/* Priorities of the demo application tasks (high numb. -> high prio.) */
#define tsk_PRIORITY	( tskIDLE_PRIORITY + 2 )
#define tics_PRIORITY	( tskIDLE_PRIORITY + 1 )

#define TMan_PERIOD 1000


struct TMan_task tasks[6];
int maxTasks;
int taskIndex;
TickType_t TMan_tick;
QueueHandle_t xQueue_msg;


void TMAN_Init (int numOfTasks) {
    
     // Init UART and redirect stdin/stdot/stderr to UART
    if(UartInit(configPERIPHERAL_CLOCK_HZ, 115200) != UART_SUCCESS) {
        PORTAbits.RA3 = 1; // If Led active error initializing UART
        while(1);
    }

     __XC_UART = 1; /* Redirect stdin/stdout/stderr to UART1*/
    
    // Disable JTAG interface as it uses a few ADC ports
    DDPCONbits.JTAGEN = 0;
    
    // Initialize ADC module
    // Polling mode, AN0 as input
    // Generic part
    AD1CON1bits.SSRC = 7; // Internal counter ends sampling and starts conversion
    AD1CON1bits.CLRASAM = 1; //Stop conversion when 1st A/D converter interrupt is generated and clears ASAM bit automatically
    AD1CON1bits.FORM = 0; // Integer 16 bit output format
    AD1CON2bits.VCFG = 0; // VR+=AVdd; VR-=AVss
    AD1CON2bits.SMPI = 0; // Number (+1) of consecutive conversions, stored in ADC1BUF0...ADCBUF{SMPI}
    AD1CON3bits.ADRC = 1; // ADC uses internal RC clock
    AD1CON3bits.SAMC = 16; // Sample time is 16TAD ( TAD = 100ns)
    // Set AN0 as input
    AD1CHSbits.CH0SA = 0; // Select AN0 as input for A/D converter
    TRISBbits.TRISB0 = 1; // Set AN0 to input mode
    AD1PCFGbits.PCFG0 = 0; // Set AN0 to analog mode
    // Enable module
    AD1CON1bits.ON = 1; // Enable A/D module (This must be the ***last instruction of configuration phase***)
    
    /* Welcome message*/
    printf("\n\n*********************************************\n\r");
    printf("Initializing the TMAN Framework \n\r");
    printf("*********************************************\n\r");
    
    maxTasks = numOfTasks;
    taskIndex = 0;
    
    printf("Creating getTicks Task\n\r");
    xTaskCreate ( TMAN_getTicks , ( const signed char * const ) "Get Tics", configMINIMAL_STACK_SIZE, NULL, tics_PRIORITY, NULL);
    xQueue_msg = xQueueCreate(maxTasks*5,sizeof(char)*80 );

    
}

void TMAN_TaskAdd(const char* name, int prior){
     
    if(taskIndex < maxTasks){
        tasks[taskIndex].name = name;
        xTaskCreate( BusyWait, ( const signed char * const ) name, configMINIMAL_STACK_SIZE,(void *) &tasks[taskIndex], tsk_PRIORITY + prior, NULL );
        printf("Task %s created!\n\r", tasks[taskIndex].name);
        taskIndex++;
        
    }else{
        printf("Task can not be created, max number %d of tasks created\n\r", maxTasks);
    }
}

void TMAN_TaskRegisterAttributes (const char* name, int period, int phase, int deadline, int next_activ, int wcet, int priority) {
    for (int i=0; i < maxTasks; i++){
        if(tasks[i].name == name){
            tasks[i].period = period;
            tasks[i].phase = phase;
            tasks[i].current_a=phase;
            tasks[i].deadline = deadline+phase;
            tasks[i].deadline_count=0;
            tasks[i].next_a= phase;
            tasks[i].wcet=wcet;
            tasks[i].priority=priority;
            
            printf("Attributes period:%d , phase:%d , deadline:%d attributed to Task %c\n\r", tasks[i].period, tasks[i].phase, tasks[i].deadline, tasks[i].name);
        }
    
    }
    
}

void TMAN_TaskWaitPeriod(void){
    const char* name = pcTaskGetName(xTaskGetCurrentTaskHandle());
    for(int i=0;i<maxTasks;i++){
        if(tasks[i].name == name ){
            if(TMan_tick>tasks[i].current_a+tasks[i].deadline){
                tasks[i].deadline_count++;
//                tasks[i].deadline_A = tasks[i].deadline_A+tasks[i].period;
            }
        }
    }
    vTaskSuspend(NULL);

}

void TMAN_getTicks(void *pvParams){
    TickType_t xLastWakeTime;
    xLastWakeTime = xTaskGetTickCount();
    for(;;){//        printf("%d", TMan_tick);
        
        
        for(int i=0;i<maxTasks;i++){
            
            if((int) TMan_tick>=tasks[i].next_a){ //pode executar
//          printf("%s", tasks[i].name);
                if((int) TMan_tick <= (tasks[i].next_a+tasks[i].deadline)){
                            
                    TaskHandle_t handle = xTaskGetHandle(tasks[i].name);

                    tasks[i].current_a=tasks[i].next_a;

                    tasks[i].next_a=tasks[i].next_a+tasks[i].period;


                    vTaskResume(handle);
                }
                else{
                    tasks[i].next_a=tasks[i].next_a+tasks[i].period;
                    tasks[i].current_a=tasks[i].next_a;

                    tasks[i].deadline_count++;
                    printf("name:%s, deadlines:%d , tic:%d, \n\r", tasks[i].name , tasks[i].deadline_count, TMan_tick);
                }
            }
            
                
        }
        vTaskDelayUntil( &xLastWakeTime, 1);
        TMan_tick++;
    }
        

        

}

void TMAN_Close(void){
    vTaskEndScheduler();
}



void printTask(void *pvParam){
    char mesg[80];
    
    TickType_t xLastWakeTime;
    for(;;){
        if( xQueue_msg != NULL ){
            for(;;) {            
               if( xQueueReceive( xQueue_msg,mesg,portMAX_DELAY ) == pdPASS ){
                   PrintStr(mesg);
               }
            }        
        }
    }
}

int TMAN_Feasibility() {
    
    int f = 1;
    
    for (int i = 0; i<maxTasks; i++) {
        if(TMAN_Wcet(tasks[i])==0){
            f=0;
            break;
        }
    }
    return f;
}

int TMAN_Wcet(TMan_task task) {         //FIXE PRIORITY SLIDES : SLIDE 21
    
    int iteration = 0;
    double RWC = 0;
    double previousRWC = 0;
    
    uint8_t mesg[80];
    char mensagem[80];
    
    
    do {
        RWC=0;
        sprintf(mensagem,"RWC: %f, PRWC: %f , Início da Iteration: %d, \n\r", RWC, previousRWC, iteration);
        if( xQueueSend(xQueue_msg, mensagem, 10) != pdPASS ) { }
        printf("RWC , PRWC : %f %f \n\n", RWC, previousRWC);
        for(int i=0;i<maxTasks;i++){
            if(tasks[i].priority>task.priority){
                if (iteration == 0) {
                    RWC = RWC+ (double) tasks[i].wcet;
                }
                else{
                    RWC = RWC + ceil ( previousRWC/(double) tasks[i].period)* (double) tasks[i].wcet;
                    
                }
            }
        }
        
        
        
        RWC = RWC + (double) task.wcet;
        sprintf(mensagem,"RWC: %f, Iteration: %d, \n\r", RWC, iteration);
        if( xQueueSend(xQueue_msg, mensagem, 10) != pdPASS ) { }
        
        
        if (RWC > (double) task.deadline) {
            printf("%s task, iteração %d",task.name,iteration);
            return 0; //wrongg
        }
        if (previousRWC==RWC && iteration >0) {
            return 1; // converge
        }
        
        iteration++;
        
        previousRWC = (double) RWC;
        sprintf(mensagem,"RWC: %f, PRWC: %f , Fim da Iteration: %d, \n\r", RWC, previousRWC, iteration);
        if( xQueueSend(xQueue_msg, mensagem, 10) != pdPASS ) { }


    }while(RWC <=(double)  task.deadline);
}



void BusyWait(void *pvParams){
    uint8_t mesg[80];
    char mensagem[80];
    TMan_task * task = (TMan_task *) pvParams;
    for(;;){
        TMAN_TaskWaitPeriod();
        TickType_t tic = xTaskGetTickCount();
        sprintf(mensagem,"name:%s, deadlines:%d , tic:%d, \n\r", task->name, task->deadline_count, tic);
        if( xQueueSend(xQueue_msg, mensagem, 10) != pdPASS ) { }
        //printf("%s, %d\n\r",(const char*) pvParams, tic);
        
    }
    
//    for(;;){
//        for(int i=0; i<IMAXCOUNT; i++){
//            for(int j=0; j<JMAXCOUNT; j++){
//                TickType_t tic = xTaskGetTickCount();
//                printf("%s, %d\n\r",(const char*) pvParams, tic);
//            }
//        }
//    }
}
    

