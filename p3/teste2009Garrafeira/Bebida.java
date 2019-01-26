package teste2009Garrafeira;

public class Bebida{

	private String nome;
	private int quantidade;
	private double preco;
	
	public Bebida() {
		
	}
	
	public Bebida(String nome, int quantidade, double preco) {
		this.setNome(nome);
		this.setQuantidade(quantidade);
		this.setPreco(preco);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}	
	
}
