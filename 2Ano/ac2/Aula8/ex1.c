#include<detpic32.h>

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
 // Configure UART1:
 // 1 - Configure BaudRate Generator
 U1MODEbits.BRGH=0;
 U1BRG= ((PBCLK+8*115200)/(16*115200))-1;
 // 2 – Configure number of data bits, parity and number of stop bits
 U1MODEbits.PDSEL=00;
 U1MODEbits.STSEL=0;
 // (see U1MODE register)
 // 3 – Enable the trasmitter and receiver modules (see register U1STA)
 U1STAbits.UTXEN=1;
 U1STAbits.URXEN=1;
 // 4 – Enable UART1 (see register U1MODE)
 //U1MODE= U1MODE | 0x8000;
 U1MODEbits.ON=1;


while(1){
    putc('A');
    delay(1000);
}
return 0;

 } 
