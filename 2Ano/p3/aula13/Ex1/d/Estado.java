package aula13.Ex1.d;

public class Estado extends Regiao{

	private Cidade capital;
	
	public Estado(String nome, int pop, Cidade capital) {
		super(nome, pop);
		this.capital=capital;	
	}
	
	public Localidade getCapital() { return this.capital;}
}
