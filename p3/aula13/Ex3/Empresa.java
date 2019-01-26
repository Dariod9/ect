package aula13.Ex3;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Iterator;


public class Empresa {

	private List<Pessoa> funcionarios;
	private List<Brinquedo> brinquedos;
	private Hashtable<Pessoa,Brinquedo> mapaBrinquedos;
	private String nome;
	private NameCounter nameCounter;
	
	public Empresa(String nome) {
		funcionarios=new ArrayList<>();
		mapaBrinquedos=new Hashtable<>();
		brinquedos=new ArrayList<>();
		nameCounter=new NameCounter();
		this.nome=nome;
	}
	
	
	public boolean addEmpregado(Pessoa emp) {

		nameCounter.addEmp(emp);
		
		if(funcionarios.contains(emp))
			return false;
		else {
			funcionarios.add(emp);
			return true;
		}
		

	}
	
	public boolean addBrinquedo(Brinquedo b) {
		
		if(brinquedos.contains(b))
			return false;
		else {
			brinquedos.add(b);
			return true;
		}
	}
	
	public boolean removeEmpregado(Pessoa emp) {
		
		nameCounter.remEmp(emp);
		
		if(funcionarios.contains(emp)) {
			
			funcionarios.remove(emp);
			return true;}
		
		else {
			System.out.println("Empregado não existente!");
			return false;
		}
	}
	
	public boolean removeBrinquedo(Brinquedo b) {
		
		if(brinquedos.contains(b)) {
			
			brinquedos.remove(b);
			return true;}
		
		else {
			System.out.println("Brinquedo não existente!");
			return false;
		}
	}
	
	
	public void listFunc() {
		
		Comparator<Pessoa> byName= Comparator.comparing(Pessoa::nome); 
		
		
		Pessoa[] a=new Pessoa[funcionarios.size()];
		a=funcionarios.toArray(a);
		
		Arrays.sort(a, byName);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i].nome());
		}
		
	}
	
	
	public void listOffers() {
		
		List chaves= new ArrayList(mapaBrinquedos.keySet());
		
		for (int i=0;i<chaves.size();i++){
			System.out.println(chaves.get(i)+"  ->  "+mapaBrinquedos.get(chaves.get(i)));
		}
		
	}
	
	public void setFunc(ArrayList<Pessoa> a) {
		funcionarios=a;
	}
	
	public void setBrinq(ArrayList<Brinquedo> b) {
		brinquedos=b;
	}
	
	
	public void giveRandom() {
		
		Random rand = new Random();
		Pessoa randomP = funcionarios.get(rand.nextInt(funcionarios.size()));

		Random rand2 = new Random();
		Brinquedo randomB = brinquedos.get(rand2.nextInt(brinquedos.size()));
		
		mapaBrinquedos.put(randomP, randomB);
		

	}
	
	/*public void nameToToy() {
		
		ArrayList<String> nomesEscolhidos=new ArrayList<>();
		
		List<Integer> valores= nameCounter.getValues().stream().filter(i -> i>3).collect(Collectors.toList());
		
		
		
		for (int j = 0; j < nameCounter.keySet().size(); j++) {
			
			
			if(valores.get(j)) 
		}
	}*/
	
}
