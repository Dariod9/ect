package aula13.Ex3;

import java.util.HashMap;
import java.util.Set;

public class NameCounter {

	private HashMap<String, Integer> map;
	
	public NameCounter() {
		
		this.map=new HashMap<String, Integer>();
		
	}

	
	public void addEmp(Pessoa p) {
		
		if(map.containsKey(p.nome())) {
			
			int tmp=map.get(p.nome());
			map.put(p.nome(), tmp++);
		}
		
		else 
			map.put(p.nome(), 1);
	}
	
	public void remEmp(Pessoa p) {
		
		
		if(map.containsKey(p.nome())) {
			int tmp=map.get(p.nome());
			map.put(p.nome(), tmp--);
		}
		
		else 
			System.out.println("O empregado não existe");
		
	}
	
	public Set<String> keySet() {
		
		return map.keySet();
	}
	
	public Set<Integer> getValues() {
		
		return (Set<Integer>) map.values();
	}
	
}
