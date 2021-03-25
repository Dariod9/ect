import java.util.Scanner;

public class Ex4 
{
	
	public static void main (String[] args) {
		
		display();
		
	}


				public static int fact (int M) { //Função que calcula o Fatorial
		
						Scanner sc= new Scanner (System.in);
	
						int f=1;
				
						for(int i=1;i<=M;i++){
			
						f *= i;
		
					}
	
	
						return f;
	
					}
		
		
		
	public static void display () {
		
		Scanner sc= new Scanner (System.in);
			
		int M;
		
		System.out.println("Introduzir numero:");
		M=sc.nextInt();
		
		for(int i2=1;i2<=M;i2++){
			
			System.out.printf("%2d! = %3d \n",i2,fact(i2));
			
						
		}
			
		
	}	
		
}
