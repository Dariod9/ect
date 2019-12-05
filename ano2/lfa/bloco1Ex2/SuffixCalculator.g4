grammar SuffixCalculator;

program :
    stat* EOF {int sum=0;}
;
stat :
    expr NEWLINE
    | NEWLINE
    ;
expr :
    expr expr op=( ' * ' | ' / ' | '+' | '-' )
    | Number {System.out.println($Number.text);}
    ;
Number : [0-9]+( ' . ' [0-9] + )? ;
NEWLINE : '\r' ? '\n' ;
WS: [ \t]+ -> skip ;