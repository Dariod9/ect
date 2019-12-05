#include<detpic32.h>

int main(void)
{

 TRISBbits.TRISB4 = 1; // RB4 digital output disconnected
 AD1PCFGbits.PCFG4 = 0; // RB4 configured as analog input (AN4) 

 AD1CHSbits.CH0SA = 4; // Selects AN4 as input for the A/D converter

 AD1CON2bits.SMPI = 0;

 AD1CON1bits.SSRC = 7; // Start conversion 

 AD1CON1bits.CLRASAM=1;

 AD1CON3bits.SAMC=16;

 AD1CON1bits.ON =1;


while(1){

 AD1CON1bits.ASAM=1;

 while( IFS1bits.AD1IF == 0);
 
 printInt(ADC1BUF0, 16 | 3 << 16);
 printf("\n");

 IFS1bits.AD1IF = 0;

}




}