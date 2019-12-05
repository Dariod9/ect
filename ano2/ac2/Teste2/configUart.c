#include<detpic32.h>

void configUart(unsigned int baud, char parity, unsigned int stopbits){

    U1MODEbits.BRGH=0;
    U1BRG= ((PBCLK+ 8 * baud)/( 16 *baud))-1;
    
    if(parity=='N')    U1MODEbits.PDSEL=00;
    else if(parity=='E') U1MODEbits.PDSEL=01;
    else if(parity=='0') U1MODEbits.PDSEL=10;
    else U1MODEbits.PDSEL=00;

    if(stopbits==1) U1MODEbits.STSEL=0;
    if(stopbits==2) U1MODEbits.STSEL=1;
    else U1MODEbits.STSEL=0;

    U1STAbits.UTXEN=1;
    U1STAbits.URXEN=1;

    U1MODEbits.ON=1;
}
