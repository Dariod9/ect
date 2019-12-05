grammar Calc;

@parser::header{
    import java.util.*;
}

@parser::members{
    public static HashMap<String,Object> mapa = new HashMap<>();
}

program: (stat';')* EOF;

stat : declaration      #declarationStat
      |show             #showStat
      ;


declaration: ID '=' expr ;

show : 'print' expr;

expr: e1=expr op=('*'|'/') e2=expr          #multExpr
    | e1=expr op=('+'|'-') e2=expr          #addExpr
    | '(' expr ')'                          #parenExpr
    | DOUBLE                                #doubleExpr
    | INT                                   #intExpr
    | ID                                    #idExpr
    ;


ID : [a-zA-Z][a-zA-Z_0-9]*;
DOUBLE: INT*'.'INT* ;
INT: [0-9]+;
WS: [ \t\n\r]+ -> skip;
COMMENT: '//' .*? '\n' -> skip;