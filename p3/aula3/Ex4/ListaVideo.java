package aula3.Ex4;
import java.util.ArrayList;

public class ListaVideo{
	
	private ArrayList<Video> lista = new ArrayList<Video>();
	
	
	public int size() {return lista.size();}
	
	public void add(Video v) {
		if(lista.contains(v)) v.stackUp();
		else lista.add(v);
	}
	
	public void remove(Video v) {
		if(v.stock()==1) lista.remove(v);
		else if(v.stock()>1) v.stackDown();
		else if(!lista.contains(v)) System.out.println("O video requerido não está disponível");
	
	}
		
	public Video get(int i) {return lista.get(i); }
	
}	