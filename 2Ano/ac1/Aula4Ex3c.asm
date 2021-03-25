# Mapa de registos
# $t0 -> i
# $t1 -> str
# $t2 -> str+1
# $t3 -> str[i]
# $t4 -> soma

 .data

 .eqv print_int10,1
 .eqv SIZE,40
 .align 2
 array:.word 1,2,3,5
 .text
 .globl main
main:

 li $t0,0 #
# la $t1,array # p = array;
 li $t4,0 #soma=0;
 
while: # while(i < SIZE) # {
 la $t1,array # p = array;
 addu $t2,$t1,$t0 #str+1
 lb  $t3,($t2) # str[i];
 
 beq $t0,4,endw
 
 if: blt $t3,'0',endif # if(str[i] >= '0' &&
 bgt $t3,'9',endif # str[i] <= '9');
 add $t4,$t4,$t3# soma = soma + str[i];
 
 endif:
 add $t0,$t0,1 #i++

 j while # }
 
 endw: li $v0,1 
 	la $a0,($t4)  
 	syscall	# print_int10(soma);
 	jr $ra # termina o program