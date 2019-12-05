package aula9.Ex2;

public class Topping extends GeladoDecorator{

	private String top;
	
	public Topping(Gelado i,String top) {
		super(i);
		this.top=top;
		}

	@Override
	public void base(int n) {
		i.base(n);
		System.out.print(" com "+top);
		
	}
	
	

}
