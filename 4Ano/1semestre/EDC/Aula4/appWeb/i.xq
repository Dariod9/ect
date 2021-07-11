<root>{
for $a in collection("cursos")//curso where $a//departamento="Departamento de Eletrónica, Telecomunicações e Informática"
return 
  <elem>
  {$a/nome}
  </elem>
}
</root>