package aula5.Ex2;

public class CarroPolicia extends Veiculo implements Policia, Motorizado{
	
	private Tipo tipo;
	private static int id;
	private String combustivel;
	
	public CarroPolicia(int ano, String matr, int cilind, int velM, Tipo tipo, String combustivel) {
		super(ano,matr,"Azul/Branco", 4, cilind,velM);
		this.tipo=tipo;
		this.id++;
		this.combustivel=combustivel;
	}

	@Override
	public Tipo tipo() {
		return tipo;
	}

	@Override
	public int id() {
		return id;
	}

	@Override
	public int getPotencia() {
		return this.cilind()/9;
	}

	@Override
	public double getConsumo() {
		return Math.sqrt(this.cilind() - this.velM()) /2;
	}

	@Override
	public String getCombustivel() {
		return combustivel;
	}
}