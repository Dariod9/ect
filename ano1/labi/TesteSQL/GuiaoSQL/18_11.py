import sqlite3 as sql
import sys

def main(argv):
	db = sql.connect(argv[1])
	# estabelecer ligação à BD
	# realizar operações sobre a BD
	
	a=0
	
	result = db.execute("SELECT nome FROM data2")
	for row in result:
		print (row)
		a=a+1

	print(a)
	print("contactos")

	db.close()
	# terminar ligação
	
main(sys.argv)
