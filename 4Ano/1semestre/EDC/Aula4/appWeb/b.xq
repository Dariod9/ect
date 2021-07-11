<root>{
for $a in distinct-values(doc("cursos")//local)
return 
  <elem>
  {$a}
  </elem>
}
</root>