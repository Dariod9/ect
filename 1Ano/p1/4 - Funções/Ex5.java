import java.util.Scanner;

public class Ex5
{
	
	public static void main (String[] args) {
		
	printNtimes();

}


	public static void printNtimes () {
	int a;
	int l;	
	Scanner sc= new Scanner (System.in);

	System.out.println("Introduzir altura");
	a = sc.nextInt();
	
	System.out.println("Introduzir largura");
	l = sc.nextInt();
	
	int f= l;
	
		for(int i=1; i<=l;i++){
	
		System.out.print(" *" + "  ");
	
			}
		

 	
	for(int i=1; i<=a-2; i++) {
			
			System.out.println("\n *"+" ");	
		
		
	}
		
		for(int i=1; i<=l;i++){
	
		System.out.print(" *" + "  ");
	
		}
	
	
		public static void printMeio () {
			
			
			
			
			
		}
	
	
}

}
