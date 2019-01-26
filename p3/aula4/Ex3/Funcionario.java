package aula4.Ex3;

public class Funcionario extends Pessoa {
	private int nFunc;
	private int fiscal;
	
	public Funcionario(String nome, int cc, String dataNasc, int nFunc, int fiscal) {
		super(nome,cc,dataNasc);
		this.nFunc=nFunc;
		this.fiscal=fiscal;
	}

public int nFunc() {return nFunc;}

public int fiscal() {return fiscal;}
	
}