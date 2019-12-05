import java.util.Scanner;

public class Ex6
{

	public static void main (String[] args) {
			
	mult(); 
	
	}
	
	
	public static void mult () { 
		
		Scanner sc= new Scanner (System.in);
		int N;
		
		do{
		
		System.out.println("Introduza numero a multiplicar:");
		N= sc.nextInt();
		
		}while(N<0 || N>=100);
		
		
		System.out.print("- - - - - - - - - - - - - - - - - - - \n");
	
		System.out.printf("|          Tabuada dos %3d          |\n", N); 

		System.out.print("- - - - - - - - - - - - - - - - - - - \n");
		
		int a=0;
		
		for(int i=1;i<=10;i++) {
		
		a= N * i;
			
		System.out.printf("|         %2d x %2d         |     %3d |\n", N, i, a);
		
		}
		
		System.out.println("- - - - - - - - - - - - - - - - - - - ");
		
		}

}





