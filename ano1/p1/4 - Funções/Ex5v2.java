import java.util.Scanner;

public class Ex5v2
{

	public static void main (String[] args) {
		
	Scanner sc= new Scanner (System.in);

	int n,x,b;
	
	System.out.println("Introduza a altura:");
	n=sc.nextInt();	
	System.out.println("Introduza o comprimento:");
	b= sc.nextInt();

	
	for(int i=1;i<=n;i++){
	
			if(i==1){
			
			printNtimes(b);

				}
				
			
			else {
				
				System.out.print("\n*");
				alt(2*b-3);
				System.out.print("*\n");
			
				}
		
				
			if(i==n-1){
					
					
			printNtimes(b);
			
			
			}
		

		}
}

	public static int printNtimes (int b){
		
		Scanner sc = new Scanner (System.in);
			
		int l=0;
		
		//System.out.println("Introduza a largura:");
		//l= sc.nextInt();
		
		for(int i=1;i<=b;i++) {
			
			System.out.print("* ");
			
		}
		
		return l;
		
	}


	public static int alt (int x) { 
		
		int a=0;
		
		for(int i=1;i<=x;i++) {
		
			System.out.print(" ");
		
					}
		
		return a;
		
	
		}
1
}




