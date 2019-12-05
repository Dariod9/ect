package aula4;

public class Bolseiro extends Estudante{
	
	private int bolsa;
	
	public Bolseiro(String nome, int CC, Data dataNasc){
		super(nome,CC,dataNasc);
	}
	
	public int bolsa(){ return bolsa;}
	public int setBolsa(int a){ return bolsa=a;}
	
	@Override
	public String toString(){
		String s="\n "+nome()+", CC:"+CC()+", "+dataNasc().toString()+", nMec:"+nMec()+", dataInsc"+dataInsc().toString()+", Bolsa:"+bolsa;
		return s;
	}
}