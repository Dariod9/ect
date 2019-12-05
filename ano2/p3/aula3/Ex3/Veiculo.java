package aula3.Ex3;

public class Veiculo{
	
	private int cilind;
	private int potencia;
	private int lotacao;
	private String tpCarta;
	private int pesoBruto;
	private Condutor cond;
	
	public Veiculo(int cilind, int potencia, int lotacao, String tpCarta, int pesoBruto, Condutor cond){
		this.cilind=cilind;
		this.potencia=potencia;
		this.lotacao=lotacao;
		this.tpCarta=tpCarta;
		this.pesoBruto=pesoBruto;
		this.cond=cond;
	}


	public int cilind() {return cilind;}
	public int potencia() {return potencia;}
	public int lotacao() { return lotacao;}  //<<<-----------
	public String tpCarta() { return tpCarta;}
	public int pesoBruto() { return pesoBruto;}
	public Condutor cond() {return cond;}
	
	public boolean isValid() { return tpCarta().equalsIgnoreCase(cond().carta());}
	
}