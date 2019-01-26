import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Feira {

	private String nome;
	private String local;
	private Set<Stand> stands;
	private Set<Visitante> visitantes;
	
	public Feira(String nome, String local) {
		this.nome=nome;
		this.local=local;
		this.stands=new HashSet<>();
		this.visitantes=new HashSet<>();
	}

	public String getNome() {
		return nome;
	}

	public String getLocal() {
		return local;
	}
	
	public void add(Stand s) {
		stands.add(s);
	}
	
	public void add(Visitante v) {
		visitantes.add(v);
	}

	public String emailsDosResponsaveis() {
		List<String> emails= stands.stream().map(x -> x.responsavel().getEmail()).collect(Collectors.toList());
				
		return emails.stream().collect(Collectors.joining(","));
	}
	
	public List<StandServicos> getServico(Servico restaurante) {
		List<StandServicos> servicos= stands.stream().filter(x-> x instanceof StandServicos).map(x -> (StandServicos) x).collect(Collectors.toList());
		return servicos.stream().filter( x-> x.getServico().equals(restaurante)).collect(Collectors.toList());
		}
	
	public String toString() {
		return "Feira "+getNome()+" - Total de Expositores: "+stands.size()+"; Total de Visitantes: "+visitantes.size();
	}

	public Set<Expositor> getStandsOrderedByCodigo() {
		
		List<Stand> std=stands.stream().collect(Collectors.toList());
		Collections.sort(std, new StandComparator());
		return std.stream().collect(Collectors.toSet());
	}

	/*public String visitantesEntreDatas(String string, String string2) {
		List<String> datas=visitantes.stream().map(x -> x.getData()).collect(Collectors.toList());

		}
		datas.stream().map(mapper)

		
		return null;
	}*/
}
