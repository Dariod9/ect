<root>{
for $a in distinct-values(collection("cursos")//local)
return 
  <elem>
  <local>{$a}</local> 
  {
  for $b in collection("cursos")//curso[local/text()=$a]
  return
      <curso>{$b/nome/text()}</curso>
  }
  </elem>
}
</root>