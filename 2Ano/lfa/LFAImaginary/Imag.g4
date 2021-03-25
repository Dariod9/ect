grammar Imag;

@parser::header{
    import java.util.*;
}

@parser::members{
    public static HashMap<String,Object> mapa = new HashMap<>();
}

program: (stat)* EOF;

stat: declaration       #declarationStat
    | print             #printStat
    ;


declaration : ID '=' expr ;

print : 'print' ID;

expr:
        e1=expr op=('*'|'/') e2=expr        #multExpr
    |   e1=expr op=('+'|'-') e2=expr        #addExpr
    |   '(' expr ')'                        #parenExpr
    |   DOUBLE                              #doubleExpr
    |   INT                                 #intExpr
    |   ID                                  #idExpr
    |   point                               #pointExpr
    ;

point: '(' opp expr ',' opp expr'i' ')' ;

opp : op=.? ;

ID : [a-zA-Z][a-zA-Z_0-9]*;
INT : [0-9]+;
DOUBLE : INT+'.'INT+;
WS: [ \t\n\r]+ -> skip;
COMMENT : '//' .*? '\n' -> skip;