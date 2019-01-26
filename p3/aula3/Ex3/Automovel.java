package aula3.Ex3;

public class Automovel extends Veiculo{
		
	public Automovel(int cilind, int potencia, int lotacao, String tpCarta, int pesoBruto, Condutor cond){
		super(cilind, potencia, lotacao, tpCarta, pesoBruto,cond);
		
	}
	
	//@Override
	public boolean isValid() {
		if(lotacao()!=4 || !tpCarta().equalsIgnoreCase(cond().carta())) return false;
		else return true;}
	}