package aula6.Ex1;

public class Carne extends Alimento{

	private TipoCarne tipo;
	
	public Carne(TipoCarne tipo, double proteinas, double calorias, double peso) {
		super(proteinas,calorias,peso);
		this.tipo=tipo;			
	
	}
}