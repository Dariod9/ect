.equ READ_CORE_TIMER,11
.equ RESET_CORE_TIMER,12
.equ PUT_CHAR,3
.equ PRINT_INT,6
.data
k:  .word 20000
 .text
 .globl delay

delay:

    subu $sp,$sp,4
    sw   $ra,0($sp)

    move 	$s0, $a0		#$s0=int ms

 for:

    ble		$s0, $0, end

    li $v0,12
    syscall

    while:

    li $v0,11
    syscall
    ble		$v0, k, while

    subi	$s0, $s0,1

 end:

    lw $ra,0($sp)
    addiu $sp,$sp,4

    jr $ra