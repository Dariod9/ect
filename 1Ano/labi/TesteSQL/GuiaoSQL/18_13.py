import sqlite3 as sql
import sys

def main(argv):
	db = sql.connect(argv[1])
	inp=argv[2]
	# estabelecer ligação à BD
	# realizar operações sobre a BD
		
	
	result = db.execute("SELECT empresa FROM pessoas WHERE nome LIKE ? OR apelido LIKE ?", (inp,inp) )
	for row in result:
		print (row)

	db.close()
	# terminar ligação
	
main(sys.argv)
