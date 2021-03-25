# O argumento da função é passado em $a0
# O resultado é devolvido em $v0
# Sub-rotina terminal: não devem ser usados registos $sx
.data
.align 2
.eqv print_int,1
.eqv print_str,4
str: .asciiz "ola"
.text
.globl main

# Mapa de registos:
# str: $a0 -> $s0 (argumento é passado em $a0)
# p1: $s1 (registo callee-saved)
# p2: $s2 (registo callee-saved)
#

exchange:			# void exchange(char* c1, char* c2) {
	lb $t0, 0($a0)		# 	char aux = *c1;
	lb $t1, 0($a1)
	
	sb $t1, 0($a0)		#     *c1 = *c2;
	sb $t0, 0($a1)		#     *c2 = aux;
	
	jr $ra			# }
	
	
strrev: subu $sp,$sp,16 # reserva espaço na stack
 sw $ra,0($sp) # guarda endereço de retorno
 sw $s0,4($sp) # guarda valor dos registos
 sw $s1,8($sp) # $s0, $s1 e $s2
 sw $s2,12($sp) #
 move $s0,$a0 # registo "callee-saved"
 move $s1,$a0 # p1 = str
 move $s2,$a0 # p2 = str
 
lb $t0, 0($s2)


while1: # while( *p2 != '\0' ) {
 beq $t0,'\0',endw
 addi $s2,$s2,1 # p2++;
 lb $t0,0($s2) #ponteiro -> novo 1 caracter da palavra
 j while1 # }
 
 endw: subiu $s2, $s2, 1 #p2--;
 
while2: # while(p1 < p2) {
 bge $s1,$s2,endw2
 move $a0,$s1 #
 move $a1,$s2 #
 jal exchange # exchange(p1,p2)
 
 addiu $s1, $s1, 1	#		p1++;
 subiu $s2, $s2, 1	# 		p2--;
	
 j while2 # }
 
 endw2:
 move $v0,$s0 # return str
 
 lw $ra,0($sp) # repõe endereço de retorno
 lw $s0,4($sp) # repõe o valor dos registos
 lw $s1,8($sp) # $s0, $s1 e $s2
 lw $s2,12($sp) #
 addu $sp,$sp,16 # liberta espaço da stack
 jr $ra # termina a sub-rotina
 
 main:
  	addiu $sp,$sp, 16
 	sw $ra,0($sp)
 	sw $s0,4($sp)
 	sw $s1,8($sp)
 	sw $s2,12($sp)
 	
 	la $a0,str
 	jal strrev
 	
 	move $a0,$v0
 	li $v0,4	# 	print_string( strrev(str) );
	syscall	
	
	
	lw $ra, 0($sp)
	lw $s1, 4($sp)
	lw $s2, 8($sp)
	lw $s3,12($sp)		# resets $ra
	addiu $sp, $sp,16
	
	jr $ra			# }
