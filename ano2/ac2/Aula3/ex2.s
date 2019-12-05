 .equ SFR_BASE_HI, 0xBF88 # 16 MSbits of SFR area
 .equ TRISE, 0x6100 
 .equ LATE , 0x6120
 .equ TRISB, 0x6040
 .equ PORTB , 0x6050
 .data
 .text
.globl main

main:
 lui $t1, SFR_BASE_HI #
 lw $t2, TRISE($t1) # READ (Mem_addr = 0xBF880000 + 0x6100)
 andi $t2, $t2, 0xFFFE # MODIFY (
 sw $t2, TRISE($t1) # WRITE (Write TRISE register)

 lui $t1, SFR_BASE_HI #
 lw $t2, TRISB($t1) # READ (Mem_addr = 0xBF880000 + 0x6100)
 ori $t2, $t2, 1 # MODIFY 
 sw $t2, TRISB($t1) # WRITE (Write TRISE register)

 while:
        lw $t2, PORTB($t1)
        andi $t2,$t2,1 

        lw $t3,LATE($t1)
        andi $t3,$t3,0xFFFE

        or $t3,$t3,$t2
        
        sw $t3, LATE($t1) # WRITE (Write TRISE register)

        j while

jr $ra