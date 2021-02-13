<root>{
for $a in distinct-values(doc("cursos")//departamentos//departamento)
return 
  <elem>
  {$a}
  </elem>
}
</root>