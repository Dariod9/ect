package aula11.Ex3;

public class Cereal extends Alimento implements Vegetariano{

	private String nome;
	
	public Cereal(String nome, double proteinas, double calorias, double peso) {
		
		super(proteinas, calorias, peso);
		this.nome=nome;
		
	}
	
}
