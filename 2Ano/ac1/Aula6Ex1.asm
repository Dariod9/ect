# O argumento da função é passado em $a0
# O resultado é devolvido em $v0
# Sub-rotina terminal: não devem ser usados registos $sx
.data
.eqv print_str,4
.eqv print_int,1
s_hdr: .asciiz "O comprimento é: "
str: .asciiz "Arquitetura de Computadores I"
.text
.globl main

strlen: li $t1,0 # len = 0;
while: lb $t0,($a0)# while(*s++ != '\0')
 addiu $a0,$a0,1 #
 beq  $t0,'\0',endw # {
 addi  $t1,$t1,1 # len++;
 j while # }
endw: move $v0,$t1 # return len;
 jr $ra # 
 
 main: addiu $sp,$sp, -4
 	sw $ra,($sp)
 	
 	la $a0,str
 	jal strlen
 	move $a0,$v0
 	
 	li $v0,1
 	syscall
 	
 	lw $ra, ($sp)
 	addiu $sp, $sp,4
 	
# 	li $v0,10
 	jr $ra
