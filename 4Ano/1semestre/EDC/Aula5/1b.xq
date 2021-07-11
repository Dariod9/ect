let $bs := doc('cursos')//cursos
for  $e in $bs where $e = "CURSO TESTE"
return delete node $e