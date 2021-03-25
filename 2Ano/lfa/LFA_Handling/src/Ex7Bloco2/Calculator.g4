grammar Calculator;
program : ( stat NEWLINE ) * EOF
;
stat : expr   # ExprStat
| assignment  # AssignmentStat
;
assignment : ID '=' expr
;
expr : e1=expr op=('*'|'/') e2=expr # MultDiv
| e1=expr op=('+'|'-') e2=expr # AddSub
| INT # Number
| '(' expr ')' # Parentesis
| ID # Variable
;
ID: [a-zA-Z_]+;
INT: [0-9]+;
NEWLINE: '\r'? '\n';
WS: [ /t]+ -> skip;