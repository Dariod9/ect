<root>{
for $a in collection("cursos")//curso where $a/nome="Contabilidade"
return 
  <elem>
  {$a/areascientificas}
  </elem>
}
</root>