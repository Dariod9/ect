#include<detpic32.h>

int main(void)
{

 TRISBbits.TRISB4 = 1; // RB4 digital output disconnected
 AD1PCFGbits.PCFG4 = 0; // RB4 configured as analog input (AN4) 

 AD1CHSbits.CH0SA = 4; // Selects AN4 as input for the A/D converter

 AD1CON2bits.SMPI = 3;

 AD1CON1bits.SSRC = 7; // Start conversion 

 AD1CON1bits.CLRASAM=1;

 AD1CON3bits.SAMC=16;

 AD1CON1bits.ON =1;

while(1){

 AD1CON1bits.ASAM=1;

 while( IFS1bits.AD1IF == 0);
 
 int *p = (int *)(&ADC1BUF0);
 int i=0;
 double sum=0;
 for( i = 0; i < 16; i++ )
 {
    sum+=p[i*4];
 } 
   printf("\n");
   int v= sum/4;
   int v_avg=(v*33+511)/1023;
   printf("%d\n", v_avg);

   int v1=v_avg/10;
   int v2=v_avg % 10;

   //printInt(v1,10);
   //putChar('.');
   //printInt(v2,10);
   //printf("\n");
   
 

 IFS1bits.AD1IF = 0;

}
}

