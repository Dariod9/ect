package aula3.Ex4;
import java.util.ArrayList;

public class Video{
	
	private static int ID=0;	
	private String nome;
	private String categoria;
	private String idade;
	private int stock;
	public ArrayList<Integer> utilizadores;

	public Video(String nome, String categoria, String idade, int stock) {
		this.utilizadores= new ArrayList<Integer>();
		ID++;
		this.nome=nome;
		this.categoria=categoria;
		this.idade=idade;
		this.stock=stock;
	}
	
	
public int ID () {return ID;}	

public String nome() {return nome;}

public String categoria() {return categoria;}

public String idade () {return idade;}

public int stock() { return stock;}

public void stackUp() { stock++;}

public void stackDown() { stock--;}

public void add(int n) { utilizadores.add(n); } 


}