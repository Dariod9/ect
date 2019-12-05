import java.util.*;

public class G5Ex4 {

		public static void main (String[] args) {
		
			int num, nota, array[];
			Scanner sc= new Scanner (System.in);
	
		do{
			
			System.out.println("Introduza o numero de notas:");
			num=sc.nextInt();

		}while(num<0 || num>50);
			
		array= new int[num];
	
		for(int i=0;i<=array.length-1;i++){
			
			System.out.println("Introduzir nota:");
			nota= sc.nextInt();
			
			array[i]=nota;
			
				}
				
		System.out.println("Histograma de Notas");
		System.out.println("----------------------------------------------------");				
				
			for(int i=0;i<=20;i++){
				
				System.out.printf(" %2d  | ",i);
				
				for(int i3=0;i3<=array.length-1;i3++){
					
					if(array[i3]==i){ System.out.print("*"); }
					
						}
					System.out.println(" ");
			}
		
	}		
}
