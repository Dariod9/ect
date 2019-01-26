package aula13.Ex3;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		Empresa BB=new Empresa("Brinca&Beira");
		
		ArrayList<Pessoa> f=new ArrayList<>();
		f.add(new Pessoa("Zé", 18));
		f.add(new Pessoa("Miguel",24));
		f.add(new Pessoa("Xico",35));
		f.add(new Pessoa("Helena", 22));
		
		BB.setFunc(f);
		Pessoa t=new Pessoa("Tone",30);
		BB.addEmpregado(t);
		BB.removeEmpregado(t);
		
		BB.listFunc();
		
		ArrayList<Brinquedo> b= new ArrayList<>();
		b.add(new Brinquedo("Urso"));
		b.add(new Brinquedo("Pistola"));
		b.add(new Brinquedo("Carro"));
		
		BB.setBrinq(b);
		Brinquedo cam=new Brinquedo("Camiao");
		BB.addBrinquedo(cam);
		BB.removeBrinquedo(cam);
		
		
		BB.giveRandom();
		BB.giveRandom();
		BB.giveRandom();
		BB.giveRandom();
		BB.giveRandom();
		
		
		BB.listOffers();
		
	
		

	}

}
