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
    *str++; }

  }
/*char getc(void)
{

 if(OERR == 1) OERR =0;
 // Wait while URXDA == 0
 while(U1ATAbits.UR1DA==0);
 // Return U1RXREG
 return U1RXREG;
} */

int main(void)
 {
 
 configUart(115200,'N',2);


while(1){
    puts("yellow\n");
    delay(1000);
}
return 0;
}
