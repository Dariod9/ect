 .equ SFR_BASE_HI, 0xBF88 # 16 MSbits of SFR area
 .equ TRISE, 0x6100 # TRISE address is 0xBF886100
 .equ TRISB, 0x6040
 .equ LATE, 0x6120 # LATE address is 0xBF886120
 .equ PORTB, 0x6050
 .data
 .text
 .globl main

    delay:

        move $s0,$a0



        for: ble	$s0, $0, end	# if $a0 <0 then end
            subu	$s0, $s0, 1			# $a0 = $t1 - 0


            li $v0,12
            syscall

            whiled: li $v0,11
                    syscall

                    blt		$v0, 20000, whiled	# if $t0 < $t1 then target
            
        j for


    end:

    jr $ra
    
main:
        subu $sp,$sp,16
        sw $ra,($sp)
        sw $s0,4($sp)
        sw $s1,8($sp)
        sw $s2,12($sp)


        

        lui $s1,SFR_BASE_HI

        lw $s2,TRISE($s1)
        andi $s2,$s2,0xFFF0
        sw $s2,TRISE($s1)

        lw $s2,TRISB($s1)
        ori $s2,$s2,0x000F
        sw $s2,TRISB($s1)

        lw $s2,LATE($s1)
        andi $s2,$s2,0xFFF0
        sw $s2,LATE($s1)

        li $s0,0

    while:

        li $a0,1000
        jal delay
        
        lw $s0,PORTB($s1)
        andi $s0,$s0,0x000F

        lw $s2,LATE($s1)
        add	$s2, $s2, $s0
        sw $s2,LATE($s1)

        

        j while

    lw $ra,($sp)
    lw $s0,4($sp)
    lw $s1,8($sp)
    lw $s2,12($sp)
    addiu $sp,$sp,16

jr $ra


        

        