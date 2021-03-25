#include <detpic32.h>

void send2displays(unsigned char value)
 {
 static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71}; 

 static char displayFlag = 0; // static variable: doesn't loose its
                              // value between calls to function

 unsigned char digit_low = value & 0x0F;
 unsigned char digit_high = value >> 4;

 LATB = LATB & 0x00FF;
 // if "displayFlag" is 0 then send digit_low to display_low
 if(displayFlag==0){
     LATB = LATB | (display7Scodes[digit_low] << 8);
 }
 // else send digit_high to didplay_high
 if(displayFlag==1){
     LATB = LATB | (display7Scodes[digit_high] << 8);
 }
 
 displayFlag=!displayFlag;
 } 