#include<detpic32.h>
#include"configUart.c"


#define DisableUart1RxInterrupt() IEC0bits.U1RXIE = 0
#define EnableUart1RxInterrupt()  IEC0bits.U1RXIE = 1
#define DisableUart1TxInterrupt() IEC0bits.U1TXIE = 0
#define EnableUart1TxInterrupt()  IEC0bits.U1TXIE = 1
#define BUF_SIZE                  8
#define INDEX_MASK                BUF_SIZE-1

typedef struct
 {
 unsigned char data[BUF_SIZE];
 unsigned int head;
 unsigned int tail;
 unsigned int count;
 } circularBuffer;


 volatile circularBuffer txb; // Transmission buffer
 volatile circularBuffer rxb; // Reception buffer 

 void comDrv_flushRx(void)
 {
 // Initialize variables of the reception buffer
 rxb.count=0;
 rxb.head=0;
 rxb.tail=0;
 } 

 void comDrv_flushTx(void)
 {
 // Initialize variables of the transmission buffer
 txb.count=0;
 txb.head=0;
 txb.tail=0;
 }

 void comDrv_putc(char ch)
 {
 while(txb.count == BUF_SIZE){} // Wait while buffer is full

 txb.data[txb.tail] = ch; // Copy character to the transmission
 // buffer at position "tail"
 txb.tail = (txb.tail + 1) & (INDEX_MASK); // Increment "tail" index
 // (mod. BUF_SIZE)

 DisableUart1TxInterrupt(); // Begin of critical section
 // Increment "count" variable
 txb.count++;
 EnableUart1TxInterrupt(); // End of critical section
 } 


/*char comDrv_getc(char *pchar)
 {
 // Test "count" variable (reception buffer) and return FALSE
 // if it is zero
 if(rxb.count==0) return FALSE;

 DisableUart1RxInterrupt(); // Begin of critical section
 // Copy character pointed by "head" to *pchar
 // Decrement "count" variable
 // Increment "head" variable (mod BUF_SIZE)
 EnableUart1RxInterrupt(); // End of critical section
 return TRUE;
 } */



 void comDrv_puts(char *s)
 {
     while(*s!='\0'){
         comDrv_putc(*s);
         s++;
     }
 }

 void _int_(24) isr_uart1(void) {
     // if U1TXIF is set
    if(IFS0bits.U1TXIF==1){

    // if "count" variable (transmission buffer, txb) is greater than 0
        if(txb.count>0){

        // Copy character pointed by "head" to U1TXREG register
                U1TXREG=txb.data[txb.head];

                // Increment "head" variable (mod BUF_SIZE)
                txb.head++;
                // Decrement "count" variable
                txb.count--;
         }


        if(txb.count==0){// if "count" variable is 0 then
                DisableUart1TxInterrupt();
            } 

        // Reset UART1 TX interrupt flag
        IFS0bits.U1TXIF=0;
    }

 }


 int main(void)
{
    configUart(115200,'N',1); // default "pterm" parameters
    // with TX and RX interrupts disabled
    //configInterrupts
    IPC6bits.U1IP=2;
    IFS0bits.U1RXIF=0;
    IFS0bits.U1TXIF=0;
    IEC0bits.U1RXIE=1;
    IEC0bits.U1RXIE=1;
    comDrv_flushRx();
    comDrv_flushTx();
    EnableInterrupts();

    while(1)
        comDrv_puts("Teste do bloco de transmissao do device driver!...");
    return 0;
 } 
