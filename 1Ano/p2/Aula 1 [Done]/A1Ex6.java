import java.util.*;

public class A1Ex6 {
	static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) {
		int x,a,cont=0;
		
		x= (int) (Math.random()*(101));
		
		do{
		
		System.out.println("Numero?");
		a=sc.nextInt();
		
			if(a>x){
				System.out.println("O numero e menor");
				cont++;
				}
			
			if(a<x){
				
				System.out.println("O numero e maior");
				cont++;
				}
			
		
		
		}while(a!=x);
	
		if(a==x){
			System.out.println("Parabens! Pontuacao: "+(cont+1));
			
		}
	
	}
}

