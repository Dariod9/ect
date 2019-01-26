package aula13.Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pais implements Comparable<Pais>{

	private String nome;
	private Localidade capital;
	private List<Regiao> regioes=new ArrayList<>();
	
	public Pais(String nome, Localidade capital) {
		this.nome=nome;
		if(capital.getTipo() != TipoLocalidade.CIDADE)
			throw new IllegalArgumentException("Capital Inválida");
		else	
			this.capital = capital;
	}
	
	public Pais(String nome) {
		this.nome=nome;
	}
	
	public String getNome() {return nome;}
	public Localidade getCapital() { return capital;}
	public List<Regiao> getRegioes() { return regioes;}
	public void addRegiao(Regiao a) {
		regioes.add(a);
	}

	public int popTotal() {
		
		return regioes.stream().collect(Collectors.summingInt(Regiao::pop));}
	
	@Override
	public String toString() {
		String s= "Pais: \n "+nome+ "(Populacao : "+popTotal()+") de capital ";
		if(capital!=null) s+=capital.toString();
		else s+="Desconhecida";
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		if (capital == null) {
			if (other.capital != null)
				return false;
		} else if (!capital.equals(other.capital))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (regioes == null) {
			if (other.regioes != null)
				return false;
		} else if (!regioes.equals(other.regioes))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Pais arg0) {
		return nome.compareTo(arg0.nome);
	}
}
