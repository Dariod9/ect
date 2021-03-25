package teste2015Clinica;

import java.io.Serializable;

public class Maca extends Marquesa implements Transporte, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numGrades;
	private TipoUtilizacao tipo;
	
	public Maca(String designacao, int id, Material material, double comp, double larg, boolean colchao, int numGrades) {
		super(designacao, id, material, comp, larg, colchao, false);
		this.setNumGrades(numGrades);
		this.setTipo(TipoUtilizacao.URGENTE);
	}

	public TipoUtilizacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoUtilizacao tipo) {
		this.tipo = tipo;
	}

	public int getNumGrades() {
		return numGrades;
	}

	public void setNumGrades(int numGrades) {
		this.numGrades = numGrades;
	}

	
	
	
}
