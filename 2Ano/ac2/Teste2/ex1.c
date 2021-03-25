#include<detpic32.h>
#include"send2displays.c"

void delay(int ms)
{
 for(; ms > 0; ms--)
 {
 resetCoreTimer();
 while(readCoreTimer() < 20000);
 }
}

// Interrupt Handler
 void _int_(12) isr_T3(void) // Replace VECTOR by the A/D vector
 // number - see "PIC32 family data
 // sheet" (pages 74-76)
 {
 // ISR actions
 putChar('3'); 
 IFS0bits.T3IF = 0;
 } 

 void _int_(4) isr_T1(void)
 {
 // print character '1'
 putChar('1');
 // Reset T1IF flag
 IFS0bits.T1IF = 0;

 }


int main(void){
    // Configure Timer T3 (2 Hz with interrupts disabled)

    T1CONbits.TCKPS = 7; // 1:256 prescaler (i.e. fout_presc = 625 KHz)
    PR2 = 39063; // Fout = 20MHz / (32 * ( + 1)) = 2 Hz
    TMR1 = 0; // Reset timer T2 count register
    T1CONbits.TON = 1; // Enable timer T2 (must be the last command of the
    // timer configuration sequence) 


    T3CONbits.TCKPS = 5; // 1:256 prescaler (i.e. fout_presc = 625 KHz)
    PR2 = 62499; // Fout = 20MHz / (32 * (62499 + 1)) = 10 Hz
    TMR3 = 0; // Reset timer T2 count register
    T3CONbits.TON = 1; // Enable timer T2 (must be the last command of the
    // timer configuration sequence) 

    IPC1bits.T1IP = 2; // Interrupt priority (must be in range [1..6])
    IEC0bits.T1IE = 1; // Enable timer T2 interrupts
    IFS0bits.T1IF = 0; // Reset timer T2 interrupt flag 

    IPC3bits.T3IP = 2; // Interrupt priority (must be in range [1..6])
    IEC0bits.T3IE = 1; // Enable timer T2 interrupts
    IFS0bits.T3IF = 0; // Reset timer T2 interrupt flag 




    EnableInterrupts();

    while(1);
    return 0;
 } 
