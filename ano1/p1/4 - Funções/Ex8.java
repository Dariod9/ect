import java.util.Scanner;

public class Ex8 {
	
	public static void main (String[] args) {
	
	mult();
	
		}
	
	
	public static void mult () { 
		
		Scanner sc= new Scanner (System.in);
		int x1, x2, y1, y2;
		
		System.out.println("Introduza valor inicial:");
		x1= sc.nextInt();
		
		do{
			
		System.out.println("Introduza valor final:");
		x2= sc.nextInt();
		
		if(x2<x1) { System.out.println("Numero invalido"); }	
			
		}while(x2<x1);
		
		System.out.print("- - - - - - - - - - - - - - - - - - - -\n");
	
		System.out.printf("|   x   |  5x2+10x+3  |  7x3+3x2+5x+x  |\n"); 

		System.out.print("- - - - - - - - - - - - - - - - - - - -\n");
		
				
		for(int i=x1;i<=x2;i++) {
				
		System.out.printf("|    %2d    |     %4d     |     %3d    |\n", i, poly2(i) , poly3(i) );
		
		}
		
		System.out.println("- - - - - - - - - - - - - - - - - - - ");
		
	}


		public static int poly3 (int x){
		
		int y1;
		
		y1=7*(x*x*x)+3*(x*x)+(5*x) +2;
	
		return y1;
			}

		public static int poly2 (int x){
		
		int y2;
		
		y2=5*x*x + 10*x + 3;
		
		return y2;

			}
	
}

