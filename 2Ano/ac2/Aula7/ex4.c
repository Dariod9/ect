#include<detpic32.h>

void _int_(12) isr_T3(void)
 {
     IFS0bits.T3IF = 0;
 } 

int main(void){

 T1CONbits.TCKPS = 7; // 1:256 prescaler (i.e. fout_presc =  KHz)
 PR1 = 39063; // Fout = 20MHz / (256 * (39061+1)) = 2 Hz
 TMR1 = 0; // Reset timer T3 count register
 T1CONbits.TON = 1; // Enable timer T3 (must be the last command of the
 // timer configuration sequence) 

 T3CONbits.TCKPS = 5; // 1:32 prescaler (i.e. fout_presc = 625 KHz)
 PR3 = 62499; // Fout = 20MHz / (32 * (62499 + 1)) = 10 Hz
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

 while(1){};
}
