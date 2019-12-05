import sqlite3 as sql
import sys

def songIn(nome):
	
	# Ligaçao à Database
	db = sql.connect("data.db")
	
	#Cursor e inserir valores
	c=db.cursor()
	c.execute("UPDATE data SET nome2=\"ya\" WHERE nome=\"ze\";")
	
	
	db.commit()
	c.close()
	
	db.close()
	
