package aula13.Ex1.d;

public abstract class Regiao {
	
	private String nome;
	private int pop;
	
	public Regiao(String nome, int pop) {
		this.nome=nome;
		this.pop=pop;
	}
	
	public String getNome() { return this.nome;}
	public int pop() { return this.pop;}
}
