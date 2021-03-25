import java.util.Scanner;

public class Ex2 {
	
	public static void main (String args[]) {

	Scanner sc= new Scanner (System.in);
				
	System.out.printf("Entre %4.2f e %4.2f, o maior numero e %4.2f \n", 3.2, 5.6, max(3.2,5.6));
	System.out.printf("Entre %4d e %4d, o maior numero e %4d \n ", 143, 256, max(143,256));

	System.out.printf("O valor do polinomio 4*x*x*x + 2x'2 -4x +6 quando x = %4.2f e igual a %4.2f \n", 4.1, poly3(4.1)); 

	System.out.printf("O valor do logaritmo de %2d e' igual a %2d \n", 5, fact(5));
	
	//System.out.printf("O numero positivo introduzido foi %3d", getIntPos());
	
	System.out.printf("O numero positivo introduzido foi %3d \n", getIntRange());

	printNtimes();
	
}



	//Funções para identificiar número maior
	
	public static double max (double x, double y) {
	double z=0;
	
	if(x>y){
		
		z=x;
		
		}
	
	else if (x<y){
		
		z=y;
		
		}
	
	return z;
	
	}

	public static int max (int x, int y) {
	int z=0;
	
	if(x>y){
		
		z=x;
		
		}
	
	else if (x<y){
		
		z=y;
		
		}
	
	return z;
	
	}
	

	//Função para calcular o valor de um polinómio do 3 grau	
	

	public static double poly3 (double x){
	double y;
	y=4*(x*x*x)+2*(x*x)-(4*x) +6;
	return y;
}
	
	//Função de calcular o Fatorial
	
	public static int fact (int x) {
	int y=0;
	int i=1;
	for(i=1;i<x;i++) {
		
		y= i*x;
		
					}
		
	return y;
}	
	//Função de ler do teclado

	//public static int getIntPos () {
	//int y;
	//Scanner sc= new Scanner (System.in);
	//do{
		//System.out.println("Introduzir numero:");
		//y = sc.nextInt();
			
		//}while(y<0);
	
	
	//return  y;
	
	//}


	//Função de ler do teclado dentro do intervalo

	public static int getIntRange () {
	int y;
	int a;
	int b;
	Scanner sc= new Scanner (System.in);
	
	System.out.println("Introduzir intervalo:");
	a = sc.nextInt();
	b = sc.nextInt();	
	
	do{
	System.out.println("Introduzir numero:");
	y = sc.nextInt();
			
			if(y<a || y>b){
				
				System.out.println("O numero nao esta introduzido no intervalo!");
				
			}
			
	}while(y<a || y>b);

	return  y;	

	}


	public static void printNtimes () {
	int n;
		
	Scanner sc= new Scanner (System.in);

	System.out.println("Introduzir numero de vezes");
	n = sc.nextInt();

	for(int i=1; i<=n; i++) {
		
		System.out.println("Hello World");
		
	}
	
}



	
}
	
	
	


	
		


	
	
	
	
	
