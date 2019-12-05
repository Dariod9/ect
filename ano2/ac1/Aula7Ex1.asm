# Mapa de registos
# n: $a0 -> $s0
# b: $a1 -> $s1
# s: $a2 -> $s2
# p: $s3
# digit: $t0
# Sub-rotina intermédia
	
	.eqv sc_print_string,4
	.eqv INT_DEMO, 2413 
	.data
string: .space 33
	.text
	.globl main

main: addiu $sp,$sp,-4 
	sw $ra,($sp) #Guardar o valor do $ra
	
	la $a0,INT_DEMO
	li $a1,10
	la $a2,string
	jal itoa
	move $a0,$v0
	
	li $v0,sc_print_string
	syscall
	
	lw $ra,($sp)
	addiu $sp,$sp,4
	
	li $v0,0
	jr $ra



itoa: subu $sp,$sp,-12# reserva espaço na stack
		 sw $s0,0($sp)
		 sw $s1,4($sp)
		 sw $s2,8($sp) # guarda registos $sx e $ra
		 sw $ra,12($sp)
		 
		 
		 move $s0,$a0
		 move $s1,$a1
		 move $s2,$s2 # copia n, b e s para registos
		 # "callee-saved"
		 move $s3,$a2 # p = s;
		
		do: # do {
		 rem $t0,$s0,$s1
		 div $s0,$s0,$s1
		 
		 move $a0,$s3
		 jal toascii
		 
		 sb $v0,0($s0)
		 addiu $s0,$s0,1
		 
		 while:
		 ble  $s0,'0',do # } while(n > 0);
		 sb $0,0($s3) # *p = 0;
	
		 move $v0,$s2
		 jal strrev # strrev( s );

		 move $v0,$s2 # return s;
		 lw $ra,0
		 lw $s0,16($sp)
		 lw $s1,12($sp)
		 lw $s2,8($sp)
		 lw $s3,4($ra) # repõe registos $sx e $ra

		 addu $sp,$sp,16 # liberta espaço na stack
		 jr $ra #
	
		 	 
toascii: addi $a0,,$a0,'0'
	if:  	ble $a0,'9',end
		addi $a0,$a0,7
	end: move $v0,$a0
		jr $ra
	
exchange:			# void exchange(char* c1, char* c2) {
	lb $t0, 0($a0)		# 	char aux = *c1;
	lb $t1, 0($a1)
	
	sb $t1, 0($a0)		#     *c1 = *c2;
	sb $t0, 0($a1)		#     *c2 = aux;
	
	jr $ra			# }

# -------------------------------------------------------------------------		
strrev: 			# char* strrev(char* str) {
	subiu $sp, $sp, 16	# saves $s, $ra registers ("callee-saved")
	sw $ra, 0($sp)
	sw $s0, 4($sp)
	sw $s1, 8($sp)
	sw $s2, 12($sp)
	
	move $s0, $a0		# IMPORTANT: I need to return str
	move $s1, $a0		# 	char* p1 = str;
	move $s2, $a0		# 	char* p2 = str;
	
	lb $t0, 0($s2)

whileA: 
	beq $t0, '\0', endWA	# 	while(*p2 != '\0')		: ok
	addiu $s2, $s2, 1	# 		p2++;
	lb  $t0, 0($s2)		# 		$t2 = *(p2++)
	j whileA	
endWA:	
	
	subiu $s2, $s2, 1	# 	p2--;

whileB:	bge $s1, $s2, endWB	# 	while( p1 < p2 ) {
	
	move $a0, $s1
	move $a1, $s2
	jal exchange		# 		exchange(p1, p2);
	
	addiu $s1, $s1, 1	#		p1++;
	subiu $s2, $s2, 1	# 		p2--;
	
	j whileB		# 	}
endWB:   			
	move $v0, $s0		# return str;
	
	lw $ra, 0($sp)		# restores registers
	lw $s0, 4($sp)
	lw $s1, 8($sp)
	lw $s2, 12($sp)
	addiu $sp, $sp, 16
	
	jr $ra			# }