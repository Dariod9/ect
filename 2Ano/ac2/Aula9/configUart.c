#include<detpic32.h>

void configUart(unsigned int baud, char parity, unsigned int numStopBits)
 {
 // Configure UART1:
 // 1 - Configure BaudRate Generator
 U1MODEbits.BRGH=0;
 U1BRG= ((PBCLK+8*baud)/(16*baud))-1;
 // 2 – Configure number of data bits, parity and number of stop bits

switch (parity) {
    case 'N':
        U1MODEbits.PDSEL = 00; //no parity
        break;
    case 'O':
        U1MODEbits.PDSEL = 10; //odd parity
        break;
    case 'E':
        U1MODEbits.PDSEL = 01; //even parity
        break;
    }

 if (numStopBits > 2) 
        numStopBits = 1;
    else {
        U1MODEbits.STSEL = numStopBits - 1; // 1 stop bit (=1 for 2 stop bits)
    }

 // (see U1MODE register)
 // 3 – Enable the trasmitter and receiver modules (see register U1STA)
 U1STAbits.UTXEN=1;
 U1STAbits.URXEN=1;
 // 4 – Enable UART1 (see register U1MODE)

 // Enable Interrupts
    //U1STAbits.UTXSEL = 00;
    U1STAbits.URXISEL = 00;
    //U1STAbits.UTXEN = 1; // Transmission Module
    U1STAbits.URXEN = 1; // Reception Module

    // the folowing bits are on the table in page 74 of the PIC32 manual
    IEC0bits.U1RXIE = 1;
    //IEC0bits.U1TXIE = 1;
    IEC0bits.U1EIE = 1;

    // clear interrupt flags
    IFS0bits.U1RXIF = 0; 
    //IFS0bits.U1TXIF = 0; 
    IFS0bits.U1EIF = 0; 

    IPC6bits.U1IP = 2;

 //U1MODE= U1MODE | 0x8000;
 U1MODEbits.ON=1;

} 

