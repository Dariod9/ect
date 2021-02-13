<root>{
for $a in collection("cursos")//curso where $a//areacientifica="Contabilidade"
return 
  <elem>
  {$a/nome}
  </elem>
}
</root>