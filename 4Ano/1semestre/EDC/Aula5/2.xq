declare function local:curso-by-name($cname) as element()*
{
for $a in distinct-values(doc("cursos")//nome) where $a = $cname
return 
  <elem>
  {$a}
  </elem>
};

<curso>
{local:curso-by-name("Contabilidade")}
</curso>