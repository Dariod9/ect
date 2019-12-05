package aula6.Ex2;

public class Estudante extends Pessoa{
	
	private static int num=100;
	private int nMec;
	private Data dataInsc;
	
	public Estudante(String nome, int CC, Data dataNasc, Data dataInsc){
		super(nome, CC, dataNasc);
		nMec=num++;
		this.dataInsc=dataInsc;
	}
	
	public Estudante(String nome, int CC, Data dataNasc){
		super(nome, CC, dataNasc);
		nMec=num++;
		this.dataInsc=Data.getToday();
	}
	
	public int nMec(){return nMec;}
	public Data dataInsc(){ return dataInsc;}
	
	@Override
	public String toString(){
		String s="\n "+nome()+", CC:"+CC()+", "+dataNasc().toString()+", nMec:"+nMec+", dataInsc"+dataInsc.toString();
		return s;
	}
	
}