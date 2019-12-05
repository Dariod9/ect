package aula3.Ex1;

public class Estudante extends Pessoa{
	
	private static int nMec=100;
	private Data dataInsc;
	
	public Estudante(String nome, int CC, Data dataNasc, Data dataInsc){
		super(nome, CC, dataNasc);
		nMec++;
		this.dataInsc=dataInsc;
	}
	
	public Estudante(String nome, int CC, Data dataNasc){
		super(nome, CC, dataNasc);
		nMec++;
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