import java.util.Scanner;


public class G4E8 {
	
	public static void main (String[] args) {
		
		Scanner sc= new Scanner (System.in);
		int A,B;
		
		do{
			
			System.out.println("Introduza valores do intervalo positivo de A a B:");
			A= sc.nextInt();
			B= sc.nextInt();
		
			}while(A<0 || A>=B);
			
			for(int i=A;i<=B;i++){
				
				if(i%2!=0){
					
					System.out.printf("%4d", i);
					
					}
					
				else{
					}
					
					}
				
				}
				
}

