#include <detpic32.h>

void delay(int ms)
{
 for(; ms > 0; ms--)
 {
 resetCoreTimer();
 while(readCoreTimer() < 20000);
 }
}

int charToBin(char a){






    switch (a)
    {
        case 'a':
            return 0x7700;
            break;

        case 'b':
            return 0x7C00;
            break;

        case 'c':
            return 0x3900;
            break;

        case 'd':
            return 0x5E00;
            break;

        case 'e':
            return 0x7900;
            break;

        case 'f':
            return 0x7100;
            break;

        case 'g':
            return 0x7D00;
            break;


        default: return 0x0000;
            break;
    }

}



 int main(void)
 {
 
 LATB =  (LATB & 0x00FF);

 TRISB = (TRISB & 0x00FF);

 TRISDbits.TRISD5=0;
 TRISDbits.TRISD6=0;

 LATDbits.LATD5=0;
 LATDbits.LATD6=1;


 while(1)
 {
 delay(500); // half period = 0.5s

 char in=getChar();
 
 LATB = (LATB & 0x00FF) | charToBin(in);

    }
return 1;
 }
