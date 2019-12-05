import sqlite3 as sql
import sys
import time


def putSong(name, id, length, date, user):

	db=sql.connect("data.db")
	c=db.cursor()
	
	checkExists(db,c)
	
	date = time.time()
	
	c.execute(
		"INSERT INTO (name, id, length, date, uses, votes, author) VALUES(?, ?, ?, ?, ?, ?, ?)",
		(name, id, length, date, 0, 0, user))
	db.commit()
   
	c.close()
	db.close()
    
    
def checkExists(db,c):
	
	# Procurar tabela com utilizadores(if exists)
	result=c.execute("SELECT name FROM sqlite_master WHERE type='table' AND name='songs';")
	row = result.fetchone()

	#Caso não exista -> criar tabela com utilizadores e musicas respetivas
	if row is None:
		c.execute("CREATE TABLE users( name TEXT, music TEXT, like INTEGER);")	
		db.commit()
