.data
 .text
 .globl main
main: li $t0,10 # instru��o virtual (decomposta
 # em duas instru��es nativas)
 
 srl $t1,$t0,1 #
 
 xor $t1,$t1,$t0
 
 li $v0,10
 syscall
 #jr $ra # fim do programa