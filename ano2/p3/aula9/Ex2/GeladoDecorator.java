package aula9.Ex2;

public abstract class GeladoDecorator implements Gelado{
	
	protected Gelado i;
	
	public GeladoDecorator(Gelado i) {
		this.i=i;
	}
	
	public void base(int n) { i.base(n);}

}
