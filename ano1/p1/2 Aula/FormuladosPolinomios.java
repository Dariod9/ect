import java.util.Scanner;

public class FormuladosPolinomios 
{
  public static void main (String[] args)
  {
		
		Scanner sc = new Scanner (System.in);


		double A, B, C;
		double bd,x1,x2,x3,x4;
		
		System.out.println("Introduzir os coeficientes do polinomio:");
		A = sc.nextDouble();
		B = sc.nextDouble();
		C = sc.nextDouble();
		
		bd = ((B*B) - 4*A*C);
		
		x1 = (-B+Math.sqrt(bd))/2*A;
		x2 = (-B-Math.sqrt(bd))/2*A;
		
		if (bd>0) {
		
		System.out.printf("Raizes: %2f, %2f", x1,x2);
		
		}	
		
		else if (bd<0) {
			
			System.out.println("Nao existem raizes reais!");
			
		x3= (-B/2*A)+ Math.sqrt(-bd);
		x4= (-B/2*A)- Math.sqrt(-bd);
		
		System.out.printf("Raizes: %2f i, %2f i",x3,x4);
		
	}
  }
  
}
