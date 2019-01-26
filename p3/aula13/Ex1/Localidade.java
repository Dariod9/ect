package aula13.Ex1;

public class Localidade extends Regiao{

	private TipoLocalidade tipo;
	
	public Localidade(String nome, int pop, TipoLocalidade tipo) {
		super(nome,pop);
		this.tipo=tipo;
	}
	
	public String getNome() {return super.getNome();}
	public int getPop() { return super.pop();}
	public TipoLocalidade getTipo() { return this.tipo;}

	@Override
	public String toString() {
		String s=getNome()+" de população "+getPop();
		return s;
	}
}
