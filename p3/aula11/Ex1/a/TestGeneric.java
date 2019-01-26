package aula11.Ex1.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class TestGeneric {
	public static void main(String[] args){
	
	Figura a1=new Retangulo(2,3);
	Figura a2=new Quadrado(2);
	
	Collection<Figura> figuras=new LinkedList<Figura>();
	
	figuras.add(a1);
	
	figuras.add(a2);
	
	System.out.println(sumArea(figuras));
	
	Iterator iterador=figuras.iterator();
	
	printSet(iterador);
	
	
	//Alinea c)
	Collection<Pessoa> vp = new ArrayList<Pessoa>();
	for (int i=0; i<10; i++)
	vp.add(new Pessoa("Bebé no Vector "+i,
	1000+i, Data.getToday()));
	Iterator<Pessoa> vec = vp.iterator();
	printSet(vp.iterator());
	Collection<Pessoa> lp = new ArrayList<Pessoa>();
	while ( vec.hasNext() )
	lp.add( vec.next() );
	Iterator<Pessoa> lista = lp.iterator();
	while ( lista.hasNext() )
	System.out.println( lista.next() );
	Collection<Figura> figList = new LinkedList<Figura>();
	figList.add(new Circulo (1,3, 1));
	figList.add(new Quadrado(3,4, 2));
	
	
	
	}
	
	
	public static double sumArea(Collection<Figura> figuras){
	
	Iterator<Figura> iterador=figuras.iterator();
	double sumarea=0;
	
	while(iterador.hasNext()){
		
		Figura a= iterador.next();
		sumarea+=a.area();
	}
	
	return sumarea;
		
	}
	
	public static void printSet(Iterator myIterator){
		
		while(myIterator.hasNext()){
			
			System.out.println(myIterator.next());
		}
	}
	
}