#include<detpic32.h>
#include"configUart.c"


void delay(int ms)
{
 for(; ms > 0; ms--)
 {
 resetCoreTimer();
 while(readCoreTimer() < 20000);
 }
}


void putc(char byte2send)
{
 // wait while UTXBF == 1
 while(U1STAbits.UTXBF==1);
 // Copy byte2send to the UxTXREG register
    U1TXREG=byte2send;
} 

void puts(char* str)
{
  while(*str!='\0'){
    putc(*str);
    str++; }

  }

  int main(void)
 {
 configUart(115200,'N',1); //default "pterm" parameters (8 data bits)
 
 TRISBbits.TRISB6=0;
 while(1)
 {
   // while(U1STAbits.TRMT!=1) // Wait until TRMT == 1
    LATBbits.LATB6=1;
     puts("1234567\n");
    LATBbits.LATB6=0;
 }
 return 0;
 } 