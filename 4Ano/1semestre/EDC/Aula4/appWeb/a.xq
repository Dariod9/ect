<root>{
for $a in collection("Corridas")//Race
return
  <elem>
  {$a/RaceName}
  </elem>
}
</root>