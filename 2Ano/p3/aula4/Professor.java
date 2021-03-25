package aula4;

public class Professor extends Pessoa{
	
	private int nFunc;
	private Data admissao;

	public Professor(String nome, int CC, Data dataNasc) {
		super(nome, CC, dataNasc);
	}
	
	
	public Professor(String nome, int CC, Data dataNasc, int nFunc, Data admissao) {
		super(nome,CC,dataNasc);
		this.nFunc=nFunc;
		this.admissao=admissao;
	}
	
}