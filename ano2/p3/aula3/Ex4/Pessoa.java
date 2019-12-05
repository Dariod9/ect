package aula3.Ex4;

import java.util.ArrayList;

public class Pessoa{
	
	private static int nSocio=0;
	private Data signup;
	private String nome;
	private int cc;
	private String dataNasc;
	private ArrayList<Video> listaV;
	
	public Pessoa(String nome, int cc, String dataNasc) {
		
		this.nome=nome;
		this.cc=cc;
		this.dataNasc=dataNasc;
		nSocio++;	}


public int nSocio() { return nSocio; }
public Data signup() { return signup;}
public String nome() {return nome;}

public int CC () {return cc;}

public String dataNasc() {return dataNasc;}


public void checkOut(Video v) {
	v.stackUp();
	v.add(nSocio);
	listaV.add(v);}

public void checkIn(Video v) {
	v.stackDown();
	listaV.remove(v);
	
	}

}