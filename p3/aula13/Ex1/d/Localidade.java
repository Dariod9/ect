package aula13.Ex1.d;

public class Localidade extends Regiao{
	
	public Localidade(String nome, int pop) {
		super(nome,pop);
	}
	
	public String getNome() {return super.getNome();}
	public int getPop() { return super.pop();}

	@Override
	public String toString() {
		String s=getNome()+" de população "+getPop();
		return s;
	}
}
