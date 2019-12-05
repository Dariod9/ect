#include<detpic32.h>
#include"send2displays.h"
#include"delay.h"

int main(void){

    TRISB = TRISB & 0x00FF;

    TRISDbits.TRISD5=0;
    TRISDbits.TRISD6=0;

    TRISB = TRISB | 0x000F;

    LATB = LATB & 0x00FF;
    PORTB = PORTB & 0xFFF0;

    LATDbits.LATD5=0;
    LATDbits.LATD6=1;    

    TRISBbits.TRISB4 = 1; // RBx digital output disconnected
    AD1PCFGbits.PCFG4= 0; // RBx configured as analog input (AN4)
    AD1CON1bits.SSRC = 7; // Conversion trigger selection bits: in this
    // mode an internal counter ends sampling and
    // starts conversion
    AD1CON1bits.CLRASAM = 1; // Stop conversions when the 1st A/D converter
    // interrupt is generated. At the same time,
    // hardware clears the ASAM bit
    AD1CON3bits.SAMC = 16; // Sample time is 16 TAD (TAD = 100 ns)
    AD1CON2bits.SMPI = 4-1; // Interrupt is generated after XX samples
    // (replace XX by the desired number of
    // consecutive samples)
    AD1CHSbits.CH0SA = 4; // replace x by the desired input
    // analog channel (0 to 15)
    AD1CON1bits.ON = 1;


    while((1)){
        AD1CON1bits.ASAM=1;
        while(IFS1bits.AD1IF==0);
        
        int *p = (int *)(&ADC1BUF0);
        int i=0;
        double sum=0;
        for( i = 0; i < 16; i++ )
        {
        sum+=p[i*4];
        } 
        int v_avg=sum/4;
        int v=(v_avg*33+511)/1023;

        v=v+ (PORTB & 0x000F);

        delay(10);
        send2displays(v);
        

    IFS1bits.AD1IF==0;
    }

}
