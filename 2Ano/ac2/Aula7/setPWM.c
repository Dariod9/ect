#include <detpic32.h>

void setPWM(unsigned int dutyCycle){

    
    //OC1CONbits.OCM = 6; // PWM mode on OCx; fault pin disabled
    //OC1CONbits.OCTSEL =0;// Use timer T3 as the time base for PWM generation

    OC1RS = (6249*dutyCycle)/100;
    //OC1CONbits.ON = 1; // Enable OC1 module
}
