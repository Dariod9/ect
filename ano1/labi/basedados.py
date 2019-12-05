import sqlite3 as sql
import sys

def songIn(base, nome, som, gosto):

	#base de dados
	database = sql.connect("tabela.db")
	cursor=db.cursor()	

	ver=cursor.execute("SELECT name FROM sqlite_master WHERE type='table' AND name='tabela';")
	row = result.fetchone()

	if row is None:
		cursor.execute(
		"CREATE TABLE users( nome TEXT, som TEXT, gosto INTEGER);")	
		database.commit()

	cursor.execute("UPDATE tabela SET som=\""+musica+"\" WHERE nome=\""+nome+"\";")
	cursor.execute("UPDATE tabela SET gosto=\""+gosto+"\" WHERE nome=\""+nome+"\";")
	
	database.commit()
	cursor.close()
	database.close()
	
