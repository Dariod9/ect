package aula10;

import java.util.Iterator;
import java.util.LinkedList;

public class TestGeneric {
	public static void main(String[] args){
	
	Figura a1=new Retangulo(2,3);
	Figura a2=new Quadrado(2);
	
	ListaGeneric<Figura> figuras=new ListaGeneric<Figura>();
	
	figuras.addElem(a1);
	
	figuras.addElem(a2);
	
	System.out.println(sumArea(figuras));
	
	Iterator iterador=figuras.iterator();
	
	printSet(iterador);
	
	
	//Alinea c)
	VectorGeneric<Pessoa> vp = new VectorGeneric<Pessoa>();
	for (int i=0; i<10; i++)
	vp.addElem(new Pessoa("Bebé no Vector "+i,
	1000+i, Data.getToday()));
	Iterator<Pessoa> vec = vp.iterator();
	printSet(vp.iterator());
	ListaGeneric<Pessoa> lp = new ListaGeneric<Pessoa>();
	while ( vec.hasNext() )
	lp.addElem( vec.next() );
	Iterator<Pessoa> lista = lp.iterator();
	while ( lista.hasNext() )
	System.out.println( lista.next() );
	ListaGeneric<Figura> figList = new ListaGeneric<Figura>();
	figList.addElem(new Circulo (1,3, 1));
	figList.addElem(new Quadrado(3,4, 2));
	
	
	
	}
	
	
	public static double sumArea(ListaGeneric<Figura> lista){
	
	Iterator<Figura> iterador=lista.iterator();
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
