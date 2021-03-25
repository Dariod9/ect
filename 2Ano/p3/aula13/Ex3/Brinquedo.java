package aula13.Ex3;

public class Brinquedo {

	private String nome;
	
	public Brinquedo(String nome) {
		this.nome=nome;
	}
	
	public String nome() { return nome;}
	
	@Override
	public String toString() {
		return nome;
	}
}
