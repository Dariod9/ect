package aula5.Ex3;

import java.util.*;

public class Pessoa{
	
	private String nome;
	private Data dataNasc;
	
	public Pessoa(String nome, Data dataNasc) {
		
		this.nome=nome;
		this.dataNasc=dataNasc;
	}
	
	public String nome(){
		  return nome; }
	
	public Data dataNasc(){
		  return dataNasc; }	
}


//class ordenaCC implements Comparator<Pessoa>{
		
	//	public int compare(Pessoa a, Pessoa b) {
		//	return a.cc()-b.cc();
		//}
//	}