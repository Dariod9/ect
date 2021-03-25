package aula10;

import java.util.Iterator;

public class VectorGeneric<T> {
	private T[] vector;
	private int n;
	private final int sizeInitial = 50;
	private int dimen = sizeInitial;
	
	public VectorGeneric() {
		vector = (T[])new Object[sizeInitial];
		n = 0;
		}
	
	public boolean addElem(T elem) {
		if (elem == null) return false;
		
		if (n>=dimen) {
			dimen += sizeInitial;
			T[] newArray = (T[]) new Object[dimen];
			System.arraycopy(vector, 0, newArray, 0, n ); vector = newArray;
			}
		
		vector[n++] = elem;
		return true; 
	}
	
	public boolean removeElem(T elem) {
		for (int i = 0; i < n; i++) {
			if (vector[i] == elem) {
				n--;
				for (int j = i; j < n; j++) vector[j] = vector[j + 1];
				return true;
				}
			}
		return false;
		}
	
	
	public int totalElem() {
		return n;
		}
	
	public T get(int i) {
		return vector[i];
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
			Object r = vector[index];
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
			Object p= vector[index-1];
			index--;
			return p;
		}
		else return null;
	}
	}

}