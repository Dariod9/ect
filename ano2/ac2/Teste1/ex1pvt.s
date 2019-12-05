.equ SFR_BASE_HI, 0xBF88 # 16 MSbits of SFR area
.equ TRISE, 0x6100 # TRISE address is 0xBF886100
.equ TRISB, 0x6040
.equ PORTB, 0x6050
.equ LATE, 0x6120 # LATE address is 0xBF886120
.data
.text
.globl main

main:

    lui $t1, SFR_BASE_HI

    lw $t0,TRISB($t1)
    or $t0,$t0,0x0F
    sw $t0,TRISB($t1)

    lw $t0,TRISE($t1)
    and $t0,$t0,0xFF00
    sw $t0,TRISE($t1)



    while:

        lw $t2, PORTB($t1)

        and $t3,$t2,0x0008

        if: bne		$t3, 0x0008, else	# if $t2 !0xelse then target
            xor     $t2,$t2,0xF

            lw $t4, LATE($t1)
            andi $t4,$t4,0xFFF0
            or $t4,$t4,$t2
            sw $t4, LATE($t1)

        else:

        lw $t4, LATE($t1)
            andi $t4,$t4,0xFFF0
            or $t4,$t4,$t2
            sw $t4, LATE($t1)

    j while

jr $ra


        
