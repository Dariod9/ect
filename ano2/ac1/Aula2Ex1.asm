.data
 .text
 .globl main
main: ori $t0,$0,0x1234 # substituir val_1 e val_2 pelos
 
sra $t0,$t0, 1 # Shift left logical

 
 #li $v0,10
 #syscall
 jr $ra # fim do programa
