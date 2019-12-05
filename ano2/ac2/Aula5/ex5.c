#include<detpic32.h>



int main(void)
{

  static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71}; 

 static char displayFlag = 0; // static variable: doesn't loose its
                              // value between calls to function


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

 int v1=0;
 int v2=0;
 int i = 0;
 while(1)
    {
    if(i++ % 25 == 0) // 0, 250ms, 500ms, 750ms, ...
    {
    
 AD1CON1bits.ASAM=1;

 while( IFS1bits.AD1IF == 0);
 
 int *p = (int *)(&ADC1BUF0);
 int i=0;
 double sum=0;
 for( i = 0; i < 16; i++ )
 {
    sum+=p[i*4];
 } 
   int v= sum/4;
   int v_avg=(v*33+511)/1023;

   v1=v_avg/10;
   v2=v_avg % 10;

    }

 IFS1bits.AD1IF = 0;

    
 unsigned char digit_low = v2;
 unsigned char digit_high =v1;


 // if "displayFlag" is 0 then send digit_low to display_low
 // else send digit_high to didplay_high
 if(displayFlag){
     LATB = LATB & 0x80FF;
     LATB = LATB | (display7Scodes[digit_high] << 8);
 }else{
   LATB = LATB & 0x00FF;
   LATB = LATB | (display7Scodes[digit_low] << 8);
 
 }
 
 LATDbits.LATD6 = !LATDbits.LATD6;
 LATDbits.LATD5 = !LATDbits.LATD5;
 displayFlag=!displayFlag;
 
    
   delay(10);

    }

    return 0;
 }
