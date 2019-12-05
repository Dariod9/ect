#include <detpic32.h>

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

 TRISB = TRISB | 0x000F;                        // configure RB0-RB3 as inputs

 TRISB = TRISB & 0x80FF;                        // configure RB8-RB14 as outputs

 TRISDbits.TRISD5=0;                                      // configure RD5-RD6 as outputs
 TRISDbits.TRISD6=0;

 LATDbits.LATD5=0;
 LATDbits.LATD6=1;
 
 
 while(1)
 {
   char trig=PORTB & 0x000F;

   LATB= (LATB && 0x00FF) | (display7Scodes[trig] <<8 );
   
   }


return 0;

}
