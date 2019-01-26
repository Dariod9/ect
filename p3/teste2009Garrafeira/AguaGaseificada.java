package teste2009Garrafeira;

public class AguaGaseificada extends Agua implements Gaseificada {

	
	public AguaGaseificada(String nome, int quantidade, double preco, Tipo tipo) {
		super(nome, quantidade, preco,tipo);
	}
	
	public AguaGaseificada(Tipo tipo) {
		super(tipo);
	}

}
