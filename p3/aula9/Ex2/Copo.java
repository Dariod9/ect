package aula9.Ex2;

public class Copo extends GeladoDecorator{

	public Copo(Gelado i) {
		super(i);
		}

	@Override
	public void base(int n) {
		i.base(n);
		System.out.print(" em copo");	
	}
}
