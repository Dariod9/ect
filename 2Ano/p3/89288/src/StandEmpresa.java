import java.util.ArrayList;
import java.util.List;

public class StandEmpresa extends Stand {

	private List<Participante> participantes;
	
	public StandEmpresa(String codigo, String nome, Participante responsavel) {
		super(codigo, nome, responsavel);
		this.participantes=new ArrayList<>();
		participantes.add(responsavel);
	}
	
	public StandEmpresa(String codigo, String nome, Participante responsavel, List<Participante> participantes) {
		super(codigo, nome, responsavel);
		this.participantes=participantes;
	}
	
	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void add(Participante participante) {
		participantes.add(participante);
		
	}

	public List<Participante> membros() {
		return participantes;
	}
	
	public String toString() {
		return "Stand Empresa[codigo="+codigo()+", nome="+getNome()+", resp="+responsavel();
	}

}
