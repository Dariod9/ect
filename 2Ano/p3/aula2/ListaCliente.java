package aula2;
import java.util.ArrayList;

public class ListaCliente{
	
	private ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
	
	
	public int size() {return lista.size();}
	public void add(Pessoa e) {lista.add(e); }
	public void remove(Pessoa e) {lista.remove(e);}
	public Pessoa get(int i) {return lista.get(i); }
	
}