package aula1;

import java.util.*;

public class Pessoa{
	
	private String nome;
	private	int cc;
	private Data dataNasc;
	
	public Pessoa(String nome, int cc, Data dataNasc) {
		
		this.nome=nome;
		this.cc=cc;
		this.dataNasc=dataNasc;
	}
	
	public String nome(){
		  return nome; }
	
	public int cc(){
		  return cc; }
	
	public Data dataNasc(){
		  return dataNasc; }	
}


class ordenaCC implements Comparator<Pessoa>{
		
		public int compare(Pessoa a, Pessoa b) {
			return a.cc()-b.cc();
		}
	}