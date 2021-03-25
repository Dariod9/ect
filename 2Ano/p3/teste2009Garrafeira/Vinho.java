package teste2009Garrafeira;

public class Vinho extends Alcoolica {

	private Regiao regiao;
	
	public Vinho(String nome, int quantidade, double preco, double teor, Regiao regiao) {
		super(nome, quantidade, preco,teor);
		this.regiao=regiao;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
}
