package aula3.Ex3;

public class Motociclo extends Veiculo{
	
	public Motociclo(int cilind, int potencia, int lotacao, String tpCarta, int pesoBruto, Condutor cond){
		super(cilind, potencia, lotacao, tpCarta, pesoBruto,cond);
		
	}
	
	//@Override
	public boolean isValid() { return lotacao()==2 && tpCarta().equalsIgnoreCase(cond().carta());}
	}