package aula9.Ex3;

import java.util.Iterator;

public class VectorPessoas {
	private Pessoa[] lista;
	private int n;
	private final int sizeInitial = 50;
	private int dimen = sizeInitial;
	
	public VectorPessoas() {
		lista = new Pessoa[sizeInitial];
		n = 0;
		}
	
	public boolean addPessoa(Pessoa est) {
		if (est == null) return false;
		
		if (n>=dimen) {
			dimen += sizeInitial;
			Pessoa[] newArray = new Pessoa[dimen];
			System.arraycopy(lista, 0, newArray, 0, n ); lista = newArray;
			}
		
		lista[n++] = est;
		return true; 
	}
	
	public boolean removePessoa(Pessoa p) {
		for (int i = 0; i < n; i++) {
			if (lista[i] == p) {
				n--;
				for (int j = i; j < n; j++) lista[j] = lista[j + 1];
				return true;
				}
			}
		return false;
		}
	
	
	public int totalPessoas() {
		return n;
		}
	
	public Pessoa getPessoa(int i) {
		return lista[i];
		}
	
	Iterator iterator() {
		return (this).new VectorIterator();}

	
	
private class VectorIterator implements Iterator, BFIterator{

	private int index;
	
	VectorIterator() {
		index = 0; }
	
	public boolean hasNext() {
		return (index < n);
		}
	
	public Object next() {
		if (hasNext()) {
			Object r = lista[index];
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
			Object p= lista[index-1];
			index--;
			return p;
		}
		else return null;
	}
	}

}