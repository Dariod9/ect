package teste2009Garrafeira;

public class Espumante extends Vinho implements Gaseificada {

	public Espumante(String nome, int quantidade, double preco, double teor, Regiao regiao) {
		super(nome, quantidade, preco,teor,regiao);
	}

}
