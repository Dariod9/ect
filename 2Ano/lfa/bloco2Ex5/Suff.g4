grammar Suff;
@header { import java.util.*; }
@members { protected Map<String,Double> symbolTable = new HashMap<String,Double>(); }

program : (stat {System.out.println($stat.v);} NEWLINE) * EOF;
stat returns [double v]:
    expr {$v=$expr.v;}
    | assignment {$v = $assignment.v;}
    ;

assignment returns [double v]:ID '=' expr  { $v=$expr.v; symbolTable.put($ID.text, $v);};

expr returns [double v]:
     left=expr op=( '*' | '/' ) right=expr {if($op.text.equals("*"))
                                                $v =$left.v * $right.v;
                                            else $v = $left.v / $right.v; }
    |left=expr op=( '+' | '-' ) right=expr {if($op.text.equals("-"))
                                                $v =$left.v - $right.v;
                                            else $v = $left.v + $right.v; }
    /*|left=expr op=('=' | '=/=') right=expr {if($op.text.equals("="))
                                                $left.v = $right.v;}*/
    | INT           { $v= Double.parseDouble($INT.text);}

    | ID            { if(!symbolTable.containsKey($ID.text))
                    { System.err.println("ERROR: variable \""+$ID.text+
                    "\" not found!"); System.exit(1); }
                    $v = symbolTable.get($ID.text); }
    ;
INT : [0-9]+;
ID : [a-zA-Z]+ ;
NEWLINE : '\r'? '\n' ;
WS: [ \t]+ -> skip ;