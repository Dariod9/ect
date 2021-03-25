grammar Str;

@parser::header{
    import java.util.*;
}

@parser::members{
    public static HashMap<String,String> mapa = new HashMap<>();
}

program: (stat)* EOF;

stat : declaration      #declarationStat
      |print            #printStat
      ;


declaration: ID '=' expr;

print : 'print' expr;

expr : 
        e1=expr op=('+'|'-') e2=expr       #mathExpr
      | '(' expr '/' STRING '/' STRING ')' #concatExpr
      | input                              #inputExpr
      | ID                                 #idExpr
      | STRING                             #stringExpr
      ;

input: 'input:'     ;

ID : [a-zA-Z][a-zA-Z_0-9]*;
STRING : '"' .*? '"' ;
WS : [ \t\n\r]+ -> skip;
COMMENT : '//' .*? '\n' -> skip;