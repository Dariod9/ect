package treino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Treino {
	public static void main(String[] args) {
		
		List<Pessoa> pessoas= new ArrayList<>();
				
		
		for(int i=0;i<10;i++) {
			
			int idade= (int) (Math.random()*100);
			
			Pessoa p=new Pessoa("Pepe",idade);
			pessoas.add(p);
			
		}
		
		
		
		pessoas.forEach( p -> System.out.println(p.idade()));
		
		Comparator<Pessoa> byAge= Comparator.comparing(Pessoa::idade);
		
		
		Pessoa[] a= new Pessoa[10];
		pessoas.toArray(a);
		
		Arrays.sort(a, byAge);
		
		System.out.println("----------------------");
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i].idade());
		}
		
	}
}
