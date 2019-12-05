package teste2015Clinica;

import java.io.Serializable;

public class Marquesa extends Cama implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean inclinacao;

	public Marquesa(String designacao, int id, Material material, double comp, double larg, boolean colchao, boolean inclinacao) {
		super(designacao, id, material, comp, larg, colchao);
		this.setInclinacao(inclinacao);
	}

	public boolean isInclinacao() {
		return inclinacao;
	}

	public void setInclinacao(boolean inclinacao) {
		this.inclinacao = inclinacao;
	}
	
}
