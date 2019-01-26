package aula7.Ex1;

public class Voo {

	private Hora hora;
	private String nome;
	private String origem;
	private Hora atraso;
	private Companhia companhia;
	
	public Voo(Hora hora,Companhia companhia, String nome, String origem, Hora atraso) {
		this.hora=hora;
		this.nome=nome;
		this.companhia=companhia;
		this.origem=origem;
		this.atraso=atraso;
	}
	
	public Hora hora() {return hora;}	
	public String nome() {return nome;}
	public String origem() {return origem;}
	public Hora atraso() {return atraso;}

	public Companhia getCompanhia() { return companhia;}
	
	public boolean pontual() {
		if(atraso.minutos()==0 && atraso.segundos()==0) return true;
		else return false;
	}
}
