import java.util.*;

public class G5Ex1 {
	
	public static void main (String[] args) {
		
		Scanner sc= new Scanner (System.in);
		
		System.out.println("Introduza a quantidade de valores");
		int x= sc.nextInt();
		
		int [] ar= new int[x];
		
			
		for(int i=0; i<=x-1;i++) {
			
			System.out.println("Introduzir valor:");
			int a= sc.nextInt();
			
			ar[i]=a;
			
			}			
			
			
			
		for(int i=ar.length-1;i>=0;i--){
			
			System.out.printf("%2d", ar[i]);
			
			}
		
		
	}
}

