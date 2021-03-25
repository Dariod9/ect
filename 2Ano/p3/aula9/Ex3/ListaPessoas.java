package aula9.Ex3;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaPessoas {
	private LinkedList<Pessoa> lista;
	private int n;
	public ListaPessoas() {
		lista = new LinkedList<Pessoa>();
		this.n=0;
		}
	
	public boolean addPessoa(Pessoa est) {
		if (est == null) return false;
		
		if (lista.isEmpty()) lista.addFirst(est);
		
		else lista.addLast(est);
		
		n++;
		
		return true; 
	}
	
	public boolean removePessoa(Pessoa p) {
		assert p!=null;
	
		boolean ret=false;
		
		if(lista.remove(p)==true); ret=true;
		
		return ret;
	}
	
	
	public int totalPessoas() {
		return n;
		}
	
	public Pessoa getPessoa(int i) {
		return lista.get(i);
		}
	
	Iterator iterator() {
		return (this).new ListIterator();}

	
	
private class ListIterator implements Iterator, BFIterator{

	private int index;
	
	ListIterator() {
		index = 0; }
	
	public boolean hasNext() {
		return (index < n);
		}
	
	public Object next() {
		if (hasNext()) {
			Object r = lista.get(index);
			index++;
			return r;
		}
		throw new IndexOutOfBoundsException("only " + n + " elements");
		}
	
	public void remove() {
		throw new UnsupportedOperationException( "Operação não suportada!"); }

	@Override
	public boolean hasPrevious() {
		return index>0;
	}

	@Override
	public Object previous() {
		if(hasPrevious()) {
			Object p= lista.get(index-1);
			index--;
			return p;
		}
		
		else return null;

	
	}
	}

}