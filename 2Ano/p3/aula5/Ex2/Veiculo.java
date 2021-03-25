package aula5.Ex2;

public abstract class Veiculo implements Comparable<Veiculo>{
	
	private int ano;
	private String matr;
	private String cor;
	private int rodas;
	private int cilind;
	private int velM;
	
	public Veiculo(int ano, String matr, String cor, int rodas, int cilind, int velM){
		this.ano=ano;
		this.matr=matr;
		this.cor=cor;
		this.rodas=rodas;
		this.cilind=cilind;
		this.velM=velM;
	}
	
	public int ano() {return ano;}
	public String matr() {return matr;}
	public String cor() {return cor;}
	public int rodas() {return rodas;}
	public int cilind() {return cilind;}
	public int velM() {return velM;}
			
	@Override
	public int compareTo(Veiculo a) {
		if(a.ano<this.ano) return 1;
		else if(a.ano==this.ano) return 0;
		else return -1;
	}
	
}
