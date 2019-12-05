package teste2009Garrafeira;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Bar {

	private String nome;
	private HashMap<Bebida, Integer> bebidas;
	
	public Bar(String nome) {
		this.nome=nome;
		bebidas=new HashMap<>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public HashMap<Bebida, Integer> getBebidas() {
		return bebidas;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean addBebida(Bebida b) {
		if(bebidas.containsKey(b.getNome())) {
			
			int tmp=bebidas.get(b.getNome());
			bebidas.put(b, tmp+1);
			return true;
		}
		
		else {
			bebidas.put(b, 1);
			return true;
		}
	}
	
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean remBebida(Bebida b) {
		
		if((bebidas.get(b)) > 1){
			int tmp= bebidas.get(b.getNome());
			bebidas.put(b, tmp-1);
			return true;
		}
		else if((bebidas.get(b)) == 1) {
			bebidas.remove(b.getNome());
			return true;
		}
		else {
			System.out.println("A bebida a retirar não existe");
			return false;
		}
	}


	public int size() {
		
		return bebidas.keySet().size();
	}
	
	public void remove(int i) {
		
		List<Bebida> tmp= bebidas.keySet().stream().collect(Collectors.toList());
		
		Bebida[] bs=new Bebida[bebidas.keySet().size()];
		tmp.toArray(bs);
		
		bebidas.remove(bs[i]);
	}
	
	
	@Override
	public String toString() {
		
		return bebidas.keySet().stream().map(b -> b.getNome().concat(":")
											.concat(bebidas.get(b).toString())).collect(Collectors.joining("\n"));
	}
	
	
	public List<Bebida> list(){
		
		return (List<Bebida>) bebidas.keySet().stream().collect(Collectors.toList());
	}
	
	public MyRangeIterator<Bebida> iterator(){
		
		Bebida [] b=new Bebida[bebidas.keySet().size()];
		bebidas.keySet().toArray(b);
		
		return new MyRangeIterator<Bebida>(b);
	}
}

	 @SuppressWarnings("hiding")
	class MyRangeIterator<Bebida> implements Iterator<Bebida>{

		int index;
		int end;
		Bebida[] bebidas;
		
		public MyRangeIterator(Bebida[] b) {
			this.bebidas=b;
			index=0;
			end=b.length;
		}
		
		@Override
		public boolean hasNext() {
			if(index<end) return true;
			else
			return false;
		}

		@Override
		public Bebida next() {
			Bebida tmp=bebidas[index];
			index++;
			return tmp;
		}
		
		
		
		
	}