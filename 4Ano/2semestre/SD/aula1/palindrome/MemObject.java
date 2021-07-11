package aula1.palindrome;

public abstract class MemObject<T> {

	protected int nElems;
	protected T [] mem =null; 
	
	public MemObject(T[] m) {
		nElems=m.length;
		mem=m;
	}
	
	protected abstract void push(T val);
	protected abstract T pop();

}
