import sqlite3 as sql
import sys

def main(argv):
	db = sql.connect(argv[1])
	# estabelecer ligação à BD
	# realizar operações sobre a BD
		
	frase=input("Nome ? ")
	result = db.execute("SELECT * FROM data2 WHERE nome LIKE ?", (frase,) )
	for row in result:
		print (row)

	db.close()
	# terminar ligação
	
main(sys.argv)
