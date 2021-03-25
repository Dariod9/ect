#include<detpic32.h>

volatile int adc_value; 

void _int_(27) isr_adc(void) // Replace VECTOR by the A/D vector
 // number - see "PIC32 family data
 // sheet" (pages 74-76)
 {
LATEbits.LATE0=0;
 // Print ADC1BUF0 value // Hexadecimal (3 digits format)
 adc_value=(ADC1BUF0, 16 | 3 << 16);


 LATEbits.LATE0=1;
 // Start A/D conversion
  AD1CON1bits.ASAM=1;


 IFS1bits.AD1IF = 0; // Reset AD1IF flag
}


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

 TRISEbits.TRISE0=0;

 EnableInterrupts(); // Global Interrupt Enable

 // Start A/D conversion
  AD1CON1bits.ASAM=1;

 while(1) { } // all activity is done by the ISR
 return 0;
}

