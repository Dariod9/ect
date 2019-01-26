package aula13.Ex1;

public class Estado extends Regiao{

	private Localidade capital;
	
	public Estado(String nome, int pop, Localidade capital) {
		super(nome, pop);
		
		if(capital.getTipo() != TipoLocalidade.CIDADE)
			throw new IllegalArgumentException("Capital Inválida");
		else	
			this.capital = capital;
		
		
		
	}
	
	public Localidade getCapital() { return this.capital;}
}
