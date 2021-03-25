#include<detpic32.h>
//#include"isr_adc.c" 

 volatile unsigned char voltage = 0; // Global variable


void delay(int ms)
{
 for(; ms > 0; ms--)
 {
 resetCoreTimer();
 while(readCoreTimer() < 20000);
 }
}



 int main(void)
 {

     static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71}; 
     static char displayFlag=0;

 unsigned int cnt = 0;
 // Configure all (digital I/O, analog input, A/D module, interrupts)

 // Configure all (digital I/O, analog input, A/D module)
 
 TRISB = TRISB & 0x00FF;
 TRISD = TRISDbits.TRISD5=0;
 TRISD = TRISDbits.TRISD6=0;

 TRISBbits.TRISB4 = 1; // RB4 digital output disconnected
 AD1PCFGbits.PCFG4 = 0; // RB4 configured as analog input (AN4) 

 AD1CHSbits.CH0SA = 4; // Selects AN4 as input for the A/D converter

 AD1CON2bits.SMPI = 3;

 AD1CON1bits.SSRC = 7; // Start conversion 

 AD1CON1bits.CLRASAM=1;

 AD1CON3bits.SAMC=16;

 AD1CON1bits.ON =1;


 LATDbits.LATD6 = 1; // display high active
 LATDbits.LATD5 = 0; // display low inactive

 // Configure interrupt system

 IPC6bits.AD1IP = 2;

 IFS1bits.AD1IF = 0; 

 IEC1bits.AD1IE = 1;
 
 EnableInterrupts(); // Global Interrupt Enable
 while(1)
 {
 if(cnt % 25 == 0) // 250 ms (4 samples/second)
 {
 // Start A/D conversion
   AD1CON1bits.ASAM=1;
 }


 // Send "voltage" variable to displays

 // if "displayFlag" is 0 then send digit_low to display_low
 // else send digit_high to didplay_high
int v1= voltage/10;
int v2=voltage % 10;

 if(displayFlag){
     LATB = LATB & 0x80FF;
     LATB = LATB | (display7Scodes[v1] << 8);
 }else{
   LATB = LATB & 0x00FF;
   LATB = LATB | (display7Scodes[v2] << 8);
 
 }
 
 LATDbits.LATD6 = !LATDbits.LATD6;
 LATDbits.LATD5 = !LATDbits.LATD5;
 displayFlag=!displayFlag;
 


 cnt++;

 // Wait 10 ms
 delay(10);
  }
 }



 void _int_(27) isr_adc(void)
 {
 // Calculate buffer average (8 samples)
 int *p = (int *)(&ADC1BUF0);
 int i=0;
 double sum=0;

 for( i = 0; i < 8; i++ )
 {
    sum+=p[i*4];
 } 
   printf("\n");
   int v= sum/4;
   int v_avg=(v*33+511)/1023;

   voltage=v_avg;

   //v1=v_avg/10;
   //v2=v_avg % 10;

 // Calculate voltage amplitude (???)

 // Convert voltage amplitude to decimal. Assign it to "voltage"

 IFS1bits.AD1IF = 0; // Reset AD1IF flag
}
