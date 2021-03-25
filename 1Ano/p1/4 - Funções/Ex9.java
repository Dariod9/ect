import java.util.Scanner;

public class Ex9 {
	
	public static void main (String[] args) {
	
	Scanner sc= new Scanner (System.in);
		int n;
	
		System.out.println("Introduza o numero final");
		n=sc.nextInt();
	 
	 lista(n);
		
		}	
	
		
	public static boolean isprime (int x) {
	
		boolean prim = true;
				
				if(x==1 || x==2 || x==3 || x==5 || x==7 || x==11){
				
				return true;
				
				}
			
				if(x==4 || x==6 || x==8 || x==9 || x==10 || x==12){
					
				return false;
				
				} 
		
			return false;
		}
		
		public static void lista (int x) {
	
		
			for(int i=1;i<=x;i++){
			
				if (isprime(i) == true){
				
					System.out.printf("%3d \n",i);
					}
				
				}
		
			}
			
}
	





