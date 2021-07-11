<root>{
for $a in distinct-values(collection("cursos")//areacientifica)
return 
  <elem>
  <local>{$a}</local> 
  {
  for $b in collection("cursos")//curso[areascientificas/areacientifica/text()=$a]
  return
      <curso>{$b/nome/text()}</curso>
  }
  </elem>
}
</root>