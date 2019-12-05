grammar ex4;

main : (header '\n' ( content '\n')*)? EOF;
header: WORD+;
content : string+;

string: NUMBER+
        | WORD+;

WORD: [a-z]+;
NUMBER: [0-9]+;
WS: [ \t\r]+ -> skip ;