package teste2015Clinica;

import java.io.Serializable;

public class CadeiraDeRodas extends Cadeira implements Transporte, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numRodas;
	private boolean eletrica;
	private TipoUtilizacao tipoU;
	
	public CadeiraDeRodas(String designacao, int id, Material material, TipoCadeira tipo, int numApoios, double altura, int numRodas, boolean eletrica) {
		super(designacao, id, material, tipo, numApoios, altura);
		this.setNumRodas(numRodas);
		this.setEletrica(eletrica);
		this.tipoU= TipoUtilizacao.MOB_REDUZIDA;
	}

	public int getNumRodas() {
		return numRodas;
	}

	public void setNumRodas(int numRodas) {
		this.numRodas = numRodas;
	}

	public boolean isEletrica() {
		return eletrica;
	}

	public void setEletrica(boolean eletrica) {
		this.eletrica = eletrica;
	}

	public TipoUtilizacao getTipo() {
		return tipoU;
	}

	public void setTipo(TipoUtilizacao tipoU) {
		this.tipoU = tipoU;
	}

}
