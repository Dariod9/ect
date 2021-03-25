 .equ SFR_BASE_HI, 0xBF88 # 16 MSbits of SFR area
 .equ TRISE, 0x6100 
 .equ LATE , 0x6120
 .equ TRISB, 0x6040
 .equ PORTB , 0x6050
  .data
 .text
.globl main

    main:
    subu $sp,$sp,28
    sw $ra,($sp)
    sw $s0,4($sp)
    sw $s1,8($sp)
    sw $s2,12($sp)
    sw $s3,16($sp)
    sw $s4,20($sp)
    sw $s5,24($sp)

    lui $s0, SFR_BASE_HI

    lw $s1, TRISE($s0)
    andi $s1,$s1,0xFFF0
    sw $s1,TRISE($s0)

    lw $s4, TRISB($s0)
    and $s4,$s4,0xFFF7
    ori $s4,$s4,0x0008
    sw $s4, TRISB($s0)


    li $s2,1



    while:

        li $a0,250
        jal delay

        lw $s5, PORTB($s0) 
        andi $s5,$s5,0x0008
        #sw $s5, PORTB($s0)

        move $t0,$s5

        beq $s5,0,if1
        bne $s5,0,if2

        if1: addi $s2,$s2,1
            lw $s3, LATE($s0)
            andi $s3,0xFFF0
            add $s3,$s3,$s2
            sw $s3, LATE($s0)

             j while

        if2: sub  $s2,$s2,1
            lw $s3, LATE($s0)
            andi $s3,0xFFF0
            add $s3,$s3,$s2
            sw $s3, LATE($s0)

             j while

    j while


    lw $ra,($sp)
    lw $s0,4($sp)
    lw $s1,8($sp)
    lw $s2,12($sp)
    lw $s3,16($sp)
    lw $s4,20($sp)
    lw $s5,24($sp)

    addiu $sp,$sp,20


    jr $ra


#----------

delay:
    move 	$s4, $a0		#$s0=int ms

 for:

    ble		$s4, $0, end

    li $v0,12
    syscall

 while2:

    li $v0,11
    syscall
    
    ble     $v0, 20000, while2

    subu	$s4, $s4,1

 j for

 end: jr $ra 
