let $bs := doc('cursos')
for $y in $bs//curso/guid
where $y='54444'
return replace node $y/text() with "54"