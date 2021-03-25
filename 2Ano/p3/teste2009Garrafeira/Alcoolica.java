package teste2009Garrafeira;

public abstract class Alcoolica extends Bebida {

	private double teor;
	
	public Alcoolica(String nome, int quantidade, double preco, double teor) {
		super(nome, quantidade, preco);
		this.teor=teor;
	}
	
	public double getTeor() { return teor;}
}
