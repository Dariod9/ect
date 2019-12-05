package aula9.Ex2;

public class Cone extends GeladoDecorator{
	
	public Cone (Gelado i) {
		super(i);
		}

	@Override
	public void base(int n) {
		i.base(n);
		System.out.print(" em cone");
		
	}
	
	

}
