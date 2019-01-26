package teste2009Garrafeira;

public class Agua extends Bebida {

	private Tipo tipo;
	
	public Agua(String nome, int quantidade, double preco, Tipo tipo) {
		super(nome, quantidade, preco);
		this.tipo=tipo;
	}
	
	public Agua(Tipo tipo) {
		this.tipo=tipo;;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	
}
