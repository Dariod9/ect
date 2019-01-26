package aula5.Ex2;

public class BicicletaPolicia extends Bicicleta implements Policia{
	
	private Tipo tipo;
	private static int id;
	
	public BicicletaPolicia(int ano, String cor, Tipo tipo) {
		super(ano,cor);
		this.tipo=tipo;
		this.id++;
	}

	@Override
	public Tipo tipo() {
		return tipo;
	}

	@Override
	public int id() {
		return id;
	}
}