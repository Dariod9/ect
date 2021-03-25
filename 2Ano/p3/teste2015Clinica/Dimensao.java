package teste2015Clinica;

import java.io.Serializable;

public class Dimensao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double comprimento;
	private double largura;
	
	public Dimensao(double comprimento, double largura) {
		this.setComprimento(comprimento);
		this.setLargura(largura);
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	public double getLargura() {
		return largura;
	}

	public void setLargura(double largura) {
		this.largura = largura;
	}
}
