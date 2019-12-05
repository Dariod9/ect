#include<detpic32.h>
#include"configUart.c"


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

void _int_(24) isr_uart1(void)
 {
 putc(U1RXREG);
 // Clear UART1 rx interrupt flag
 IFS0bits.U1RXIF=0;
 } 

int main(void)
 {
 configUart(115200,'N',1); // default "pterm" parameters

 // with RX interrupt enabled
 U1STAbits.URXISEL=00;
 U1MODEbits.U1RXIE=1;

    IPC3bits.T3IP = 2; // Interrupt priority (must be in range [1..6])
    IEC0bits.T3IE = 1; // Enable timer T2 interrupts
    IFS0bits.T3IF = 0; // Reset timer T2 interrupt flag


 EnableInterrupts();
 while(1);
 return 0;
 } 