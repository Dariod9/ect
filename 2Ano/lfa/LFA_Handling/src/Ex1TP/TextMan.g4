grammar TextMan;

program: ( line NL) * EOF;

line : dec #decLine
| print    #printLine
| input    #inputLine
;

dec: ID ':' STRING ;

print : 'print' ID #printID
| 'print' STRING  #printString
;

input: 'print input'   #printInput
      | ID ': input'   #IDInput
 ;


STRING: ('"' (~'"')* '"');

ID: INT*[a-zA-Z_]+INT*;
INT: [0-9]+;

NL: '\r'? '\n';
WS: [ \t]+ -> skip ;
