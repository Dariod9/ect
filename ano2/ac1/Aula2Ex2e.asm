.data
 .text
 .globl main
main: li $t0,15 # instrução virtual (decomposta
 # em duas instruções nativas)
 
 srl $t1,$t0,4
 xor $t1,$t1,$t0
 
  srl $t0,$t1,2
 xor $t1,$t1,$t0
 
  srl $t0,$t1,1
 xor $t1,$t1,$t0
 
  or $t2, $t1, 0
 
 li $v0,10
 syscall
 #jr $ra # fim do programa