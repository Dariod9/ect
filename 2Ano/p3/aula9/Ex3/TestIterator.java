package aula9.Ex3;

import java.util.Iterator;

public abstract class TestIterator { 
  public static void main(String[] args) {
	  VectorPessoas vp = new VectorPessoas();
	  for (int i=0; i<10; i++)
		  vp.addPessoa(new Pessoa("Beb� no Vector "+i,                        1000+i, Data.getToday()));
	 
	  Iterator vec = vp.iterator();
	  
	  while ( vec.hasNext() )
		  System.out.println( vec.next() );
	  
	  ListaPessoas lp = new ListaPessoas();
	  for (int i=0; i<10; i++)
		  lp.addPessoa(new Pessoa("Beb� na Lista "+i,                        2000+i, Data.getToday()));
	  
	  Iterator lista = lp.iterator();
	  while ( lista.hasNext() )
		  System.out.println( lista.next() ); 
  } }