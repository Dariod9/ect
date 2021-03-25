package teste2015Clinica;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;

import aula10.BFIterator;

public class ListaGeneric<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<T> lista;
	private int n;
	public ListaGeneric() {
		lista = new LinkedList<T>();
		this.n=0;
		}
	
	
	public LinkedList<T> list(){ return lista;}
	
	public boolean addElem(T elem) {
		if (elem == null) return false;
		
		if (lista.isEmpty()) lista.addFirst(elem);
		
		else lista.addLast(elem);
		
		n++;
		
		return true; 
	}
	
	public boolean removeElem(T p) {
		assert p!=null;
	
		boolean ret=false;
		
		if(lista.remove(p)==true); ret=true;
		
		return ret;
	}
	
	
	public int totalElem() {
		return n;
		}
	
	public T getElem(int i) {
		return lista.get(i);
		}
	
	Iterator iterator() {
		return (this).new ListIterator();
	}

	
	
private class ListIterator implements Iterator<T>, BFIterator{

	private int index;
	
	ListIterator() {
		index = 0; }
	
	public boolean hasNext() {
		return (index < n);
		}
	
	public T next() {
		if (hasNext()) {
			T r = lista.get(index);
			index++;
			return r;
		}
		throw new IndexOutOfBoundsException("only " + n + " elements");
		}
	
	public void remove() {
		throw new UnsupportedOperationException( "Operação não suportada!"); }

	public boolean hasPrevious() {
		return index>0;
	}

	public T previous() {
		if(hasPrevious()) {
			T p= lista.get(index-1);
			index--;
			return p;
		}
		
		else return null;

	
	}
	}

}