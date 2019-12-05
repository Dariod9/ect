

#----------

delay:
    move 	$s4, $a0		#$s0=int ms

 for:

    ble		$s4, $0, end

    li $v0,12
    syscall

 while2:

    li $v0,11
    syscall
    
    ble     $v0, 20000, while2

    subu	$s4, $s4,1

 j for

 end: jr $ra 
