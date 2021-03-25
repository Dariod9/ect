void send2displays(int value){

    static const char display7Scodes[] = {0x3F, 0x06, 0x5B,0x4F,0x66,0x6D,0x7D,0x07,0x7F,0x6F,0x77,0x7C,0x39,0x5E,0x79,0x71}; 
    int displayFlag=0;

    int v1= value % 10;
    int v2= value / 10;

    LATDbits.LATD5=!LATDbits.LATD5;
    LATDbits.LATD6=!LATDbits.LATD6;

    if(LATDbits.LATD5==1){
        LATB = (LATB & 0x00FF) | (display7Scodes[v1] << 8);
    }

    if(LATDbits.LATD5==0){
        LATB = (LATB & 0x00FF) | (display7Scodes[v2] << 8);
    }

    displayFlag=!displayFlag;
 
}
