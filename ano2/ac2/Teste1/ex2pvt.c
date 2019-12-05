#include<detpic32.h>

void delay(int ms){
    for(; ms>0; ms--){
        resetCoreTimer();
        while(readCoreTimer()<20000);
    }

}

int main(void)
{

    static const char letras[] = { 0x5E, 0x00, 0x00 , 0x39, 0x5C, 0x54}; 
    int displayFlag=0;

    TRISB = TRISB & 0x00FF;
    TRISDbits.TRISD5=0;
    TRISDbits.TRISD6=0;

    LATDbits.LATD5=0;
    LATDbits.LATD6=1;
    

    int cont=5;
    int freq=0;

    while(1){

            while(1){
            
            //freq++;

            delay(200);
            //LATB = 0xFFFF;
            printf("Não está\n");
            if (LATDbits.LATD5==0) {
                            printf(" está1\n");
                LATB = (LATB & 0x00FF) | (letras[cont-2] << 8);
            }
            if(LATDbits.LATD5==1){
                            printf(" está2\n");
                LATB = (LATB & 0x00FF) | (letras[cont-1] << 8);
            }
            
            //displayFlag=!displayFlag;
            LATDbits.LATD5=!LATDbits.LATD5;
            LATDbits.LATD6=!LATDbits.LATD6;

           // if(cont==6) cont=2;
            //cont++;
            }
        
        /*if(cont==5){
            cont=1;
        }
        else cont++;

        freq++;*/
        
    }
}
