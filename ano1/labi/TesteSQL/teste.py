import sqlite3 as sql
import sys

def main(argv):
	db = sql.connect(argv[1])
	# estabelecer ligação à BD
	# realizar operações sobre a BD

	result = db.execute("SELECT * FROM data2")
	while True:
		row = result.fetchone()
		if not row:
				break
		print (row)

	db.close()
	# terminar ligação
	
main(sys.argv)
