package aula6.Ex1;

public class Peixe extends Alimento {
	
	private TipoPeixe tipo;

	public Peixe(TipoPeixe tipo, double proteinas,double calorias, double peso) {
		super(proteinas,calorias,peso);
		this.tipo=tipo;
	}
	
}