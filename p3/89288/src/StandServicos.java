
public class StandServicos extends Stand {

	private Servico servico;
	
	public StandServicos(String codigo, String nome, Participante responsavel, Servico servico) {
		super(codigo, nome, responsavel);
		this.servico=servico;
	}

	public Servico getServico() {
		return servico;
	}
	
	public String toString() {
		return "Stand Servicos[codigo="+codigo()+", nome="+getNome()+", resp="+responsavel();
	}

}
