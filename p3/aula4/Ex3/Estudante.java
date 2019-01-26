package aula4.Ex3;

public class Estudante extends Pessoa{
	
	private int mec;
	private String curso;
	
	public Estudante(String nome, int cc, String dataNasc, int mec, String curso) {
		
		super(nome, cc, dataNasc);
		this.mec=mec;
		this.curso=curso;
		
	}
	
public int mec() {return mec;}

public String curso() {return curso;}
	
}