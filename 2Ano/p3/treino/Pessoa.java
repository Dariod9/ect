package treino;

public class Pessoa {

	private String nome;
	private int idade;
	
	public Pessoa(String nome, int idade) {
		this.nome=nome;
		this.idade=idade;
	}
	
	public String nome() { return this.nome;}
	public int idade() { return idade;}
	
}
