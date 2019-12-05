package aula5.Ex2;

public abstract class Motociclo extends Veiculo{
	
	private String combustivel;
	
	public Motociclo(int ano, String matr, String cor, int rodas, int cilind, int velM, String combustivel) {
		super(ano, matr, cor, rodas,cilind,velM);
		this.combustivel=combustivel;
	}
		
	public String combustivel() { return combustivel;}
	
}