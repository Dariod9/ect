package teste2015Clinica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Clinica implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private ListaGeneric<Mobiliario> lista;
	
	public Clinica(String nome) {
		this.setNome(nome);
		this.lista=new ListaGeneric<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ListaGeneric<Mobiliario> getLista() {
		return lista;
	}
	
	public void setLista(ListaGeneric<Mobiliario> ls) {
		this.lista=ls;
	}

	public boolean addMobiliario(Mobiliario m1) {
		lista.addElem(m1);
		return true;
		}
	
	public boolean removeMobiliario(Mobiliario m1) {
		lista.removeElem(m1);
		return true;
	}
	
	
	public MyRangeIterator<Mobiliario> iterator(int a,int b){
		return new MyRangeIterator(lista, a,b);
	}
	
	public MyRangeIterator<Mobiliario> iterator(){
		return new MyRangeIterator(lista);
	}
	
	public List<Transporte> listTransportes(){
		
		return lista.list().stream().filter(x -> x instanceof Transporte).map(x-> (Transporte) x).collect(Collectors.toList());
		
	}
	
	
	public void saveClinica(String nome) throws IOException {
		
		ObjectOutputStream objectOut =
				new ObjectOutputStream(
				new FileOutputStream(nome));
				objectOut.writeObject(this);
				objectOut.close();
	}
	
	public void rescueClinica(String nome) throws IOException, ClassNotFoundException{
		
		Clinica c1;
		
		ObjectInputStream objectIn =
				new ObjectInputStream(
				new FileInputStream(nome));
				 c1=(Clinica)objectIn.readObject();
				 
				 this.setNome(c1.getNome());
				 this.setLista(c1.getLista());
	}
	
}
	
	
	class MyRangeIterator<Clinica> implements Iterator<Mobiliario>{

		int index;
		int end;
		ListaGeneric<Mobiliario> lista;
		
		
		public MyRangeIterator(ListaGeneric<Mobiliario> ls) {
			index=0;
			end=ls.totalElem();
			lista=ls;
		}
		
		public MyRangeIterator(ListaGeneric<Mobiliario> ls, int a, int b) {
			index=a;
			end=b+1;
			lista=ls;
			
		}
		
		@Override
		public boolean hasNext() {
			if(index<end) return true;
			else return false;
		}

		@Override
		public Mobiliario next() {
			Mobiliario tmp=lista.getElem(index);
			index++;
			return tmp;
		}
		
	}
	
