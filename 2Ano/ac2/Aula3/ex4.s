 .equ SFR_BASE_HI, 0xBF88 # 16 MSbits of SFR area
 .equ TRISE, 0x6100 
 .equ LATE , 0x6120
  .data
  k:  .word 20000
 .text
.globl main

main:

    subu $sp,$sp,20
    sw $ra,($sp)
    sw $s0,4($sp)
    sw $s1,8($sp)
    sw $s2,12($sp)
    sw $s3,16($sp)

    li $s0,0    #int v=0



    lui $s1, SFR_BASE_HI

    lw $s2,TRISE($s1)
    andi $s2,$s2,0xFFFE
    sw $s2,TRISE($s1)



    while:

    lw $s3,LATE($s1)
    xor $s3,$s3,1
 #   andi $s3,$s3,0xFFFE
  #  or $s3,$s3,$s0
    sw $s3,LATE($s1)

    li $a0,20
    jal delay

#    xori $s0,$s0,1

    j while
    
    lw $ra,($sp)
    lw $s0,4($sp)
    lw $s1,8($sp)
    lw $s2,12($sp)
    lw $s3,16($sp)

    addiu $sp,$sp,20

    jr $ra

#-------------------------

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
