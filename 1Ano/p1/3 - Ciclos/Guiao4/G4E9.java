import java.util.Scanner;


public class G4E9 {
	
	public static void main (String[] args) {
		
		Scanner sc= new Scanner (System.in);
		int N,soma=0;
		
		do{
			
			System.out.println("Introduzir numero de pares:");
			N = sc.nextInt();
		
		}while(N<0 || N>1000);
			
			for(int i=1; i<=N*2;i++){ 
				
				
				if(i%2==0){
					
					soma+= i;
					
					System.out.printf("%3d", i);
					
					}
				}
				
			System.out.printf("\nA soma de todos os numeros e %5d",soma);
}

}
