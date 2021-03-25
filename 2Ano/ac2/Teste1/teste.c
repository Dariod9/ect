#include <detpic32.h>
#include "send2displays.c"

void delay(int ms){
    
    for( ; ms>0 ; ms--){
        
    resetCoreTimer();
    while(readCoreTimer()<20000);

    }
}

int main(void)
{

//static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71}; 

TRISE = TRISE & 0xFFF0; //LEDS OUTPUT

TRISDbits.TRISD5=0;
TRISDbits.TRISD6=0; //DISPLAYS OUTPUT

TRISB= TRISB | 0x000F;
TRISB= TRISB & 0x00FF;

LATDbits.LATD5=0;  //ATIVADO O DISPLAY DE NR 5
LATDbits.LATD6=1;
LATE = (LATE & 0xFFF0);

//int add=0;
int value=13;

while(1){
    delay(10);
    send2displays(value);
}


}
