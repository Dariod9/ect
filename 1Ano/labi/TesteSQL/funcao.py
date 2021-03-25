import sqlite3 as sql
import sys


def getName(music):
	
	# Ligaçao à Database
	db = sql.connect("data.db")
	# Criação do cursor
	c=db.cursor()	
	
	result=c.execute("SELECT name FROM users WHERE music=\""+music+"\";")
	rows=result.fetchone()

	if rows is None:
		print("Nenhum nome associado registado!") 
	else:	
		print(rows)
		
	return rows	


def getSong(base, name):
	
	# Ligaçao à Database
	db = sql.connect("data.db")
	# Criação do cursor
	c=db.cursor()	
	
	result=c.execute("SELECT music FROM users WHERE name=\""+name+"\";")
	
	rows=result.fetchone()

	if rows is None:
		print("Nenhum nome associado registado!") 
	else:	
		print(rows)
		
	return rows	
	


def checkExists(db,c):
	
	# Procurar tabela com utilizadores(if exists)
	result=c.execute("SELECT name FROM sqlite_master WHERE type='table' AND name='users';")
	row = result.fetchone()
	##db.commit()

	#Caso não exista -> criar tabela com utilizadores e musicas respetivas
	if row is None:
		c.execute("CREATE TABLE users( name TEXT, music TEXT, like INTEGER);")	
		db.commit()


def evIn(base, name, music, like):		## funcao de teste de executes

	# Ligaçao à Database
	db = sql.connect("data.db")
	# Criação do cursor
	c=db.cursor()	

	checkExists(db, c)
	
	#Inserir valores
	c.execute("INSERT INTO users VALUES ( \""+name+"\",\""+music+"\",\""+like+"\");")
	db.commit()
	
	c.close()
	
	db.close()
	
	
def updt(base):  						## testar exacute update

	# Ligaçao à Database
	db = sql.connect("data.db")
	# Criação do cursor
	c=db.cursor()	
	
	checkExists(db,c)
	
	#Inserir valores
	c.execute("UPDATE users SET name=\"tomane\" WHERE like=\"2\";")	
	db.commit()
	c.close()
	
	db.close()


def songIn(base, nome, musica):

	# Ligaçao à Database
	db = sql.connect("data.db")
	# Criação do cursor
	c=db.cursor()	

	checkExists(base, db, c)
	
	#Inserir valores
	c.execute("UPDATE users SET music=\""+musica+"\" WHERE name=\""+nome+"\";")
	
	db.commit()
	c.close()
	
	result=db.execute("SELECT name FROM users;")
	row=result.fetchone()
	print(row)
	
	db.close()
	
	
def likeIn(base, nome):				##FUNCIONA MAL --> Integer like e devolvido em tupo (3,) e por isso like+1 nao funfa :c

	# Ligaçao à Database
	db = sql.connect("data.db")
	# Criação do cursor
	c=db.cursor()	

	checkExists(base, db, c)
	
	result=c.execute("SELECT like FROM users WHERE name=\""+nome+"\";")
	row=result.fetchone()
	number=int(row)+1
	
	#Inserir valores
	c.execute("UPDATE users SET like=\""+number+"\" WHERE name=\""+nome+"\";")
	
	db.commit()
	c.close()
	
	db.close()
