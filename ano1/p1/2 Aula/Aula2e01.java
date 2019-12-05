import java.util.Scanner;

public class Aula2e01 {
	
	public static void main (String[] args) {	
	Scanner sc = new Scanner (System.in);
	
	int n1, n2, n3;
	
	System.out.println("Apresentar numeros inteiros:" );
	n1 = sc.nextInt();
	n2 = sc.nextInt();
	n3 = sc.nextInt();
	
	if (n1 > n2 && n2 > n3) {
		
		System.out.printf(" Ordem crescente dos numeros: %4d, %4d, %4d", n1, n2, n3);
		
	}
	
	else if (n1>n2 && n3>n2) {
		
		System.out.printf(" Ordem crescente dos numeros: %4d, %4d, %4d", n1, n3, n2);
		
	}
	
	else if (n2>n1 && n1>n3) {
		
		System.out.printf(" Ordem crescente dos numeros: %4d, %4d, %4d", n2, n1, n3);
		
	}
	
	else if (n2>n1 && n3>n1) {
		
		System.out.printf( "  Ordem crescente dos numeros: %4d, %4d, %4d", n2, n3, n1);
		
	}
	
	else if (n3>n1 && n1>n2) {
		
		System.out.printf(" Ordem crescente dos numeros: %4d, %4d, %4d", n3,n1,n2);
		
	}
	
	else if (n3>n2 && n2>n1) {
		
		System.out.printf(" Ordem crescente dos numeros: %4d, %4d, %4d", n3,n2,n1);
		
	}
	

}

}
