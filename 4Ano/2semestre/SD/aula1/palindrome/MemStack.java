package aula1.palindrome;

public class MemStack<T> extends MemObject<T> {

	private int in=0;
	private int out=0;
	private boolean empty;
	
	public MemStack(T[] elems) {
		super(elems);
		out=0;
		empty=true;
	}

	@Override
	protected void push(T val) {
		if((in != out) || empty ){
			mem[in]=val;
			out=in;
			in = (in+1) % mem.length;
			empty=false;
		}
		
	}

	@Override
	protected T pop() {
		T ret=null;
		
		if(!empty){
			ret= mem[out];
			in=out;
			out = (out-1) % mem.length;
			if(in==out) empty=true;
		}
		
		return ret;
	}

}