 .equ SFR_BASE_HI, 0xBF88 # 16 MSbits of SFR area
 .equ TRISE, 0x6100 # TRISE address is 0xBF886100
 .equ LATE, 0x6120 # LATE address is 0xBF886120
 .data
 .text
 .globl main


delay:

move $s4,$a0
li $s5, 20000

while: ble $s4, $0, end
       
       li $v0,12
       syscall

       while2: li $v0,11
                syscall
               move $s3,$v0
               bgt		$s3, $s5, end2	# if $s2 > $s1 then target
               j while2

        end2:
        subu $s4,$s4,1
        j while

end: jr $ra


main: 
    subu $sp,$sp,16
    sw $ra,($sp)
    sw $s0,4($sp)
    sw $s1,8($sp)
    sw $s2,12($sp)


    lui $s0,SFR_BASE_HI
      lw $s1, TRISE($s0) # READ (Mem_addr = 0xBF880000 + 0x6100)
      and $s1,$s1,0xFFF0 
      sw $s1, TRISE($s0)

     li $s2,0
    

 while3:      
    
      li $a0,200
      jal delay

    move $a0,$s2
    li $v0,6
    syscall
      
      lw $s1, LATE($s0)
      andi $s1,$s1,0xFFF0
      or $s1,$s1,$s2      
      sw $s1,LATE($s0)

      addi $s2,$s2,1

    j while3


    lw $ra,($sp)
    lw $s0,4($sp)
    lw $s1,8($sp)
    lw $s2,12($sp)
    addiu $sp,$sp,16

jr $ra
