package aula3.Ex3;

public class Condutor extends Pessoa{
	
	private String carta;
	
	public Condutor(String nome, int CC, Data dataNasc, String carta){
		super(nome,CC,dataNasc);
		this.carta=carta;
	}
	
	public String carta(){ return carta;}
}