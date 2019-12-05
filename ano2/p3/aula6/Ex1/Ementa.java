package aula6.Ex1;

import java.util.ArrayList;

public class Ementa {

	private String nome;
	private String local;
	private LinkedList<Prato> pratos = new LinkedList<Prato>();
	private ArrayList<Prato[]> listaP=new ArrayList<Prato[]>();
	
	public Ementa(String nome, String local) {
		this.nome = nome;
		this.local = local;
	}

	public String nome() { return nome;	}
	public int size() {	return pratos.size();} 
	public String getLocal() {	return local; }
	
	public void addPrato(Prato p, DiaSemana d) {
		if(!pratos.isEmpty()) pratos.addLast(p);
		else pratos.addFirst(p);
	}
	
	@Override
	public String toString() {
		LinkedList<Prato> tmp=pratos;
		String s="";
		
		while(!tmp.isEmpty()) {
			s=s+"\n"+tmp.first().nome() + " com " +tmp.first().calTotal() + " calorias(100g) e "+tmp.first().protTotal()+ " proteinas(100g), de peso "+tmp.first().pesoTotal();
			tmp.removeFirst();
		}
		
		return s;
	}
}
