#include <detpic32.h>
#include"send2displays.c"

volatile int oc=6249/(2);
volatile int flag=0;

unsigned char toBCD(unsigned char value){
   return ((value/10)<<4)+(value%10);
}


void delay(int ms){
     for(; ms>0;ms--){
     resetCoreTimer();
     while(readCoreTimer()<20000);}
}

void putc(char byte2send)
{
 // wait while UTXBF == 1
 while(U1STAbits.UTXBF==1);
 // Copy byte2send to the UxTXREG register
 U1TXREG=byte2send;
} 

void puts(char *str)
 {
  // use putc() function to send each charater ('\0' should not
 while(*str){
    putc(*str);
    str++;}
 // be sent)
 } 


void _int_(8) isr_timer2(void){

 int tmp= (double) ((double) OC1RS/6249.0)*100;
 send2displays(toBCD((unsigned char) tmp),0);

 IFS0bits.T2IF = 0; // Reset AD1IF flag


}


void _int_(12) isr_timer3(void){

if(flag==0){
 int tmp= (double) ((double) OC1RS/6249.0)*100;
 putc('0'+(tmp/10));
 putc('0'+(tmp%10)); 
 }

 flag=!flag;
 
IFS0bits.T3IF = 0; // Reset AD1IF flag

}

// Interrupt Handler
 void _int_(24) isr_uart1(void) // Replace VECTOR by the A/D vector
 // number - see "PIC32 family data
 // sheet" (pages 74-76)
 {
 // ISR actions
 
    unsigned char ord= U1RXREG;
    putc(ord);
    if(ord=='+'){
        if(oc+312>=5935){
           puts("OLimite máximo atingido\n");
            oc=5934;}
        else oc=oc+313;
        }

    else if(ord=='-'){
     if(oc-313<313){
         puts("OLimite minimo atingido\n");
            oc=320;}
        else oc=oc-313;
    }

     OC1RS=oc;
    

 IFS0bits.U1RXIF = 0; // Reset AD1IF flag

 } 


int main(void){

    U1MODEbits.BRGH=0;
    U1BRG= ((PBCLK+8*19200)/(16*19200))-1;
    U1MODEbits.PDSEL=01;
    U1MODEbits.STSEL=1;


    T3CONbits.TCKPS = 7; // 1:32 prescaler (i.e Fout_presc = 625 KHz)
    PR3 = 39063; // Fout = 20MHz / (32 * (6249 + 1)) = 100 Hz
    TMR3 = 0; // Reset timer T2 count register
    T3CONbits.TON = 1; // Enable timer T2 (must be the last command of the


    T2CONbits.TCKPS = 5; // 1:32 prescaler (i.e Fout_presc = 625 KHz)
    PR2 = 6249; // Fout = 20MHz / (32 * (6249 + 1)) = 100 Hz
    TMR2 = 0; // Reset timer T2 count register
    T2CONbits.TON = 1; // Enable timer T2 (must be the last command of the
    // timer configuration sequence)
    OC1CONbits.OCM = 6; // PWM mode on OCx; fault pin disabled
    OC1CONbits.OCTSEL =0;// Use timer T2 as the time base for PWM generation
    OC1RS = oc; // Ton constant
    OC1CONbits.ON = 1; // Enable OC1 module 

    IPC6bits.U1IP = 2; // Interrupt priority (must be in range [1..6])
    IEC0bits.U1RXIE = 1; // Enable timer T2 interrupts
    IFS0bits.U1RXIF = 0;

    IPC2bits.T2IP = 2; // Interrupt priority (must be in range [1..6])
    IEC0bits.T2IE = 1; // Enable timer T2 interrupts
    IFS0bits.T2IF = 0;

    IPC3bits.T3IP = 2; // Interrupt priority (must be in range [1..6])
    IEC0bits.T3IE = 1; // Enable timer T2 interrupts
    IFS0bits.T3IF = 0;

    EnableInterrupts();

    while(1);

    return 0;
}
