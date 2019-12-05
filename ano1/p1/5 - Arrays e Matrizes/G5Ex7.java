import java.util.*;


public class G5Ex7 {
	
	static Scanner sc= new Scanner (System.in);
	public static void main (String[] args) {
			System.out.println("Quantos queres?");
		int quant=sc.nextInt();		
				
		int n;
		int Notas[] = new int[quant];
		
		
		for(int i=0;i<=Notas.length-1;i++){

				System.out.println("Nota:");
				n = sc.nextInt();
					
			Notas[i]=n;
			
			}
		

		int Cont[] = new int[21];
		
		for(int i=1;i<=Cont.length-1;i++){
			
			Cont[i]=0;
			
			}
		
				
		for(int i=0;i<=20;i++){
				
			for(int i2=0;i2<Notas.length-1;i2++){
							
				if(Notas[i]==i){ Cont[i]++; }
	
					}
		
			System.out.printf("O numero %2d ocorre %2d vezes\n", i, Cont[i]);
		
		}
			



		


	}
}

