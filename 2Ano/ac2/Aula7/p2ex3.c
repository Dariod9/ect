#include<detpic32.h>
#include"setPWM.c"

int main(void){

    TRISEbits.TRISE3=0;

    T3CONbits.TCKPS = 5; // 1:32 prescaler (i.e Fout_presc = 625 KHz)
    PR3 = 6249; // Fout = 20MHz / (32 * (6249 + 1)) = 100 Hz
    TMR3 = 0; // Reset timer T2 count register
    T3CONbits.TON = 1; // Enable timer T3 (must be the last command of the
    // timer configuration sequence)
    OC1CONbits.OCM = 6; // PWM mode on OCx; fault pin disabled
    OC1CONbits.OCTSEL =1;// Use timer T3 as the time base for PWM generation
    setPWM(10);
    OC1CONbits.ON = 1; // Enable OC1 module

    LATE = LATE & 0xFFF0;

     while(1){
        while(IFS0bits.T3IF==0);
        IFS0bits.T3IF = 0;
             }
}
