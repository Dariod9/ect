#include<detpic32.h>
#include "isr_adc.c"

int main(void)
 {
 // Configure all (digital I/O, analog input, A/D module)
 
 TRISBbits.TRISB4 = 1; // RB4 digital output disconnected
 AD1PCFGbits.PCFG4 = 0; // RB4 configured as analog input (AN4) 

 AD1CHSbits.CH0SA = 4; // Selects AN4 as input for the A/D converter

 AD1CON2bits.SMPI = 0;

 AD1CON1bits.SSRC = 7; // Start conversion 

 AD1CON1bits.CLRASAM=1;

 AD1CON3bits.SAMC=16;

 AD1CON1bits.ON =1;


 // Configure interrupt system

 IPC6bits.AD1IP = 2;

 IFS1bits.AD1IF = 0; 

 IEC1bits.AD1IE = 1;

 EnableInterrupts(); // Global Interrupt Enable

 // Start A/D conversion
  AD1CON1bits.ASAM=1;

 while(1) { } // all activity is done by the ISR
 return 0;
}


