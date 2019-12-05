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

char getc(void)
 {
 // If OERR == 1 then reset OERR
    if(U1STAbits.OERR==1) U1STAbits.OERR=0;

 // Wait while URXDA == 0
    while(U1STAbits.URXDA==0);
 // If FERR or PERR then
 // read UxRXREG (to discard the character) and return 0
    if(U1STAbits.FERR==1 || U1STAbits.PERR==1){
    char tmp=U1RXREG;
    return 0;}
 // else
 // Return U1RXREG
    else return U1RXREG;
 } 


void putc(char byte2send)
 {
    // wait while UTXBF == 1
    while(U1STAbits.UTXBF==1);
    // Copy byte2send to the UxTXREG register
    U1TXREG=byte2send;
 } 

 void puts(char *str){
  // use putc() function to send each charater ('\0' should not
  while(*str!='\0'){
      putc(*str);
      str++;
  }
 // be sent)
 }

int main(void)
{
    configUart(115200,'N',1); // default "pterm" parameters

    while(1){
        putc( getc() );
        delay(1000);
        }
    
   return 0;    
}
