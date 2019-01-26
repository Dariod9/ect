package teste2015Clinica;

import java.io.Serializable;

public class CamaArticulada extends Cama implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean eletrica;
	
	public CamaArticulada(String designacao, int id, Material material, double comp, double larg, boolean colchao, boolean eletrica) {
		super(designacao, id, material, comp, larg, colchao);
		this.eletrica=eletrica;
	}

	public boolean isEletrica() {
		return eletrica;
	}

	public void setEletrica(boolean eletrica) {
		this.eletrica = eletrica;
	}

}
