<root>{
for $a in distinct-values(doc("cursos")//areascientificas//areacientifica)
return 
  <elem>
  {$a}
  </elem>
}
</root>