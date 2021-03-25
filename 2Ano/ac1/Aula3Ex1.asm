# Mapa de registos:
# $t0 � soma
# $t1 � value
# $t2 - i
 .data
str1: .asciiz "Introduza um numero: "
str2: .asciiz "Valor ignorado"
str3: .asciiz "A soma dos positivos e: "
 .eqv print_string,4
 .eqv read_int, 5

  .text
 .globl main
main: li $t0,0 # soma = 0;
 	li $t2,0 # i = 0;
 	
for: bge $t2,5,endfor # while(i < 5) {
	
	li $v0,4 #Print
	la $a0, str1 #Atribuicao da string
	syscall

	li $v0,5 #Get value
	syscall
	
	move $t1,$v0 #Por o valor num registo
	
	ble $t1,$0,else # if(value > 0)
 	add $t0,$t1,$t0 # soma += value;
 	j endif  #

else: li $v0,4
      la $a0, str2
      syscall
 # print_string("...");
 
endif: addi $t2,$t2,1 # i++;
 j for # }
endfor:
	li $v0,4
	la $a0,str3
	syscall	 # print_string("...");

	li $v0,1
	la $a0,($t0) # print_i
	syscall 
	
	li $v0,10
	syscall
