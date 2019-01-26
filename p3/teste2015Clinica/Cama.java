package teste2015Clinica;

import java.io.Serializable;

public class Cama extends Mobiliario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimensao dimensao;
	private boolean colchao;
	
	public Cama(String designacao, int id, Material material, double comp, double larg, boolean colchao) {
		super(designacao,id,material);
		this.setDimensao(new Dimensao(comp,larg));
		this.setColchao(colchao);
	}

	public Dimensao getDimensao() {
		return dimensao;
	}

	public void setDimensao(Dimensao dimensao) {
		this.dimensao = dimensao;
	}

	public boolean isColchao() {
		return colchao;
	}

	public void setColchao(boolean colchao) {
		this.colchao = colchao;
	}
	
	
}
