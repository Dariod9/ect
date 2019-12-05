.data
 .text
 .globl main
main: li $t0,10 # instrução virtual (decomposta
 # em duas instruções nativas)
 
 srl $t1,$t0,1 #
 
 xor $t1,$t1,$t0
 
 li $v0,10
 syscall
 #jr $ra # fim do programa