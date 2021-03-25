grammar ex42;

main : (i {System.out.println($i.v);} '\n') * EOF;
i returns [double v]:
     e {$v=$e.v;};

e returns [double v]:
| left=e op=('*' | '/') right=e { if($op.text.equals("*"))
                                        $v=$left.v * $right.v;
                                  else
                                        $v=$left.v / $right.v;}
| left=e op=('+' | '-') right=e { if($op.text.equals("+"))
                                        $v=$left.v + $right.v;
                                  else
                                        $v=$left.v - $right.v;}
| r  {$v= Double.parseDouble($r.text);}
;
r : N;
N: [0-1]+;
WS: [ \t\n\r]+ -> skip ;