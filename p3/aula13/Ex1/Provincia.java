package aula13.Ex1;

public class Provincia extends Regiao{

	private String governador;
	
	public Provincia(String nome, int pop, String governador) {
		super(nome, pop);
		this.governador=governador;
	}

	public String getGov() { return governador;}
	
	
}
