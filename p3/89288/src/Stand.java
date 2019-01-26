
public abstract class Stand implements Expositor{

	private String codigo;
	private String nome;
	private Participante responsavel;
	
	public Stand(String codigo, String nome, Participante responsavel) {
		this.codigo=codigo;
		this.nome=nome;
		this.responsavel=responsavel;
	}
	
	public String codigo() { return codigo;}

	public Participante responsavel() {
		return responsavel;
	}

	public String getNome() {
		return nome;
	}

	public String toString() {
		return " [codigo="+codigo()+ ", nome="+getNome()+", resp="+responsavel;
	}
}
