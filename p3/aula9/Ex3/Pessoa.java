package aula9.Ex3;

public class Pessoa{
	
	private String nome;
	private int CC;
	private Data dataNasc;

	public Pessoa(String nome, int CC, Data dataNasc){
		this.nome=nome;
		this.CC=CC;
		this.dataNasc=dataNasc;
	}
	
	public String nome(){ return nome;}
	public int CC() { return CC;};
	public Data dataNasc(){ return dataNasc;}
	
	@Override 
	public String toString(){
		String s="\n "+nome+", CC:"+CC+", "+dataNasc.toString();
		return s;
	}
	
	
}