#include<detpic32.h>
#include"send2displays.c"

volatile int oc=6249/2;
volatile int valF;
volatile int valorA;

void putc(char byte2send)
{
 // wait while UTXBF == 1
 while(U1STAbits.UTXBF==1);
 // Copy byte2send to the UxTXREG register
    U1TXREG=byte2send;
 } 

void puts(char *str){
    while(*str!='\0'){
        putc(*str);
        str++;
    }
}

unsigned char toBCD(unsigned char val){
    return ((val/10)<<4) + (val % 10);
}


 // Interrupt Handler
 void _int_(12) isr_timer3(void) // Replace VECTOR by the A/D vector
 // number - see "PIC32 family data
 // sheet" (pages 74-76)
 {
 // ISR actions
 


 IFS0bits.T3IF = 0; // Reset AD1IF flag
 }


 void _int_(16) isr_timer4(void) // Replace VECTOR by the A/D vector
 // number - see "PIC32 family data
 // sheet" (pages 74-76)
 {
 // ISR actions
 
    send2displays(toBCD((char)valorA),0);

 IFS0bits.T4IF = 0; // Reset AD1IF flag
 }

 void _int_(24) isr_uart1(void) // Replace VECTOR by the A/D vector
 // number - see "PIC32 family data
 // sheet" (pages 74-76)
 {
 // ISR actions

    unsigned char e=U1RXREG;

    if(e=='A'){

        AD1CON1bits.ASAM=1;

        while( IFS1bits.AD1IF == 0 );
        int soma=ADC1BUF0+ADC1BUF1+ADC1BUF2+ADC1BUF3;

        int v=soma/4;
        int v_avg=(v*99)/1023;
        valF=v_avg;

        IFS1bits.AD1IF=0;

    }

    else if(e=='D'){

        valorA=valF;

    }

    else if(e=='E'){
        putc('0'+(valF/10));
        putc('0'+(valF%10));
        putc('\n');
    }

    else if(e=='P'){
        oc=6249+(valF/100);
    }

 IFS0bits.U1RXIF = 0; // Reset AD1IF flag
 }

int main(void){

    U1MODEbits.BRGH=0;
    U1BRG = ((PBCLK+8*38400)/(16*38400))-1;

    U1MODEbits.PDSEL=10;
    U1MODEbits.STSEL=0;


    IPC6bits.U1IP = 2; // Interrupt priority (must be in range [1..6])
    IEC0bits.U1RXIE = 1; // Enable timer T2 interrupts
    IFS0bits.U1RXIF = 0; // Reset timer T2 interrupt flag



    T4CONbits.TCKPS = 5; // 1:32 prescaler (i.e Fout_presc = 625 KHz)
    PR4 = 4310; // Fout = 20MHz / (32 * (62499 + 1)) = 10 Hz
    TMR4 = 0; // Reset timer T2 count register
    T4CONbits.TON = 1; // Enable timer T2 (must be the last command of the
    // timer configuration sequence)
    //OC1CONbits.OCM = 6; // PWM mode on OCx; fault pin disabled
    //OC1CONbits.OCTSEL =0;// Use timer T2 as the time base for PWM generation
    //OC1RS = 12500; // Ton constant
    //OC1CONbits.ON = 1; // Enable OC1 module

    IPC4bits.T4IP = 2; // Interrupt priority (must be in range [1..6])
    IEC0bits.T4IE = 1; // Enable timer T2 interrupts
    IFS0bits.T4IF = 0; // Reset timer T2 interrupt flag



     T3CONbits.TCKPS = 5; // 1:32 prescaler (i.e Fout_presc = 625 KHz)
    PR3 = 6249; // Fout = 20MHz / (32 * (62499 + 1)) = 10 Hz
    TMR3 = 0; // Reset timer T2 count register
    T3CONbits.TON = 1; // Enable timer T2 (must be the last command of the
    // timer configuration sequence)
    OC1CONbits.OCM = 6; // PWM mode on OCx; fault pin disabled
    OC1CONbits.OCTSEL =1;// Use timer T2 as the time base for PWM generation
    OC1RS = oc; // Ton constant
    OC1CONbits.ON = 1; // Enable OC1 module





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
    AD1CON1bits.ON = 1; // Enable A/D converter
    // This must the last command of the A/D
    // configuration sequence 

    AD1CON1bits.ASAM = 1; // Start conversion 


    EnableInterrupts();


    while(1);

      /*  while(IFS1bits.AD1IF==0);

        int soma=ADC1BUF0+ADC1BUF1+ADC1BUF2+ADC1BUF3;

        int v=soma/4;
        int v_avg=(v*99)/1023;

        unsigned char value= toBCD((char) v_avg);

      
        putc('0'+ADC1BUF0);
 
        IFS1bits.AD1IF==0;*/
    


    return 0;
}
