<root>{
for $a in distinct-values(collection("cursos")//departamento)
return 
  <elem>
  <dep>{$a}</dep> 
  {
  for $b in collection("cursos")//curso[departamentos/departamento/text()=$a]
  return
      <curso>{$b/nome/text()}</curso>
  }
  </elem>
}
</root>