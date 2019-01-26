package aula6.Ex1;

public class Legume extends Alimento implements Vegetariano {

	private String nome;
	
	public Legume(String nome, double proteinas, double calorias, double peso) {
		super(proteinas,calorias,peso);
		this.nome=nome;
	}
	
}
