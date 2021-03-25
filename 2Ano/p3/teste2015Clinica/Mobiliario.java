package teste2015Clinica;

import java.io.Serializable;

public abstract class Mobiliario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String designacao;
	private int id;
	private Material material;
	
	public enum Material {
		MADEIRA, PLASTICO, METAL, SINTETICO
}	


	public Mobiliario(String designacao, int id, Material material) {
		this.setDesignacao(designacao);
		this.setId(id);
		this.setMaterial(material);
	}


	public String getDesignacao() {
		return designacao;
	}


	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
	}

}
