package treino;

class Singleton{
	
	private String nome;
	private static final Singleton instance= new Singleton("CoisoIgual");
	
	private Singleton(String nome) {
		this.nome=nome;
	}
	
	public Singleton getInstance() {
		return instance;
	}
	
}
	