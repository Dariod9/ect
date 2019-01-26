package aula5.Ex2;

public class MotaPolicia extends Motociclo implements Policia, Motorizado{
	
	private Tipo tipo;
	private static int id;
	
	public MotaPolicia(int ano, String matr, int cilind, int velM, Tipo tipo, String combustivel) {
		super(ano,matr,"Azul/Branco", 2, cilind,velM,combustivel);
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
		return this.combustivel();
	}
}