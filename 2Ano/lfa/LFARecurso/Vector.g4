grammar Vector;

@parser::header{
    import java.util.*;
}

@parser::members{
    public static HashMap<String,Object> mapa = new HashMap<>();
}

program: (stat ';')*EOF;

stat:  declaration      #declarationStat
    |  show             #showStat
    ;

declaration: ID '=' expr ;


show: 'show' ID  #showID
     |'show' expr #showExpr
     ;

expr:
     e1=expr op=('*'|'/') e2=expr        #exprMult
    |e1=expr op=('+'|'-') e2=expr        #exprSum
    |'(' expr ')'                       #exprParen
    |  DOUBLE        #exprDouble
    | INT           #exprInt
    | ID            #exprID
    | vec           #exprVec
    ;

vec: '[' num ']' ;

num:  num ',' num         #progressiveNum
    | DOUBLE        #doubleNum
    | INT           #intNum
    ;

ID: [a-zA-Z][a-zA-Z_0-9]* ;
DOUBLE: [0-9]+'.'[0-9]+ ;
INT : [0-9]+  ;
WS : [ \t\n\r]+-> skip ;
COMMENT: '#' .*? '\n'-> skip  ;