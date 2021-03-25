# Mapa de registos:
# $t0 – value
# $t1 – bit
# $t2 - i
 .data
str1: .asciiz "Introduza um numero: "
str2: .asciiz "O valor em binario e: "
 .eqv print_string,4
 .eqv print_char,11
 .eqv read_int, 5

  .text
 .globl main
main: 
	li $v0,4 #Print
	la $a0, str1 #Atribuicao da string
	syscall

	li $v0,5 #Get value
	syscall
	move $t0,$v0 #Por o valor num registo
	
	li $v0,4
	la $a0,str2
	syscall
 	
for: bge $t2,32,endfor # while(i < 32) {
	rem $t3,$t2,4
	
	
	printspace: bne $t3,0,notprintspace
		    li $v0,11
		    la $a0,' '
		    syscall
	
	notprintspace: 
			andi $t1,$t0,0x80000000
			bne $t1,$0, else
		
			li $v0,11
			la $a0,'0'
			syscall
			j	next
			
	else:	li $v0,11
		la $a0,'1'
		syscall
	
	next:  sll $t0,$t0,1
		addi $t2,$t2,1
		j for
endfor:
	
	li $v0,10
	syscall
		
	
	
