<root>{
for $a in collection("cursos")//curso where $a/guid=17
return
  <elem>
  {$a/codigo}
  {$a/nome}
  {$a/grau}
  {$a/local}
  </elem>
}
</root>