import java.util.Scanner;

public class G4E6 {
	
	public static void main (String[] args) {
	
	Scanner sc= new Scanner (System.in);
	int l,c; 
	
	System.out.println("Introduza o comprimento");
	c=sc.nextInt();
	System.out.println("Introduza a largura");
	l=sc.nextInt();
	
	for(int i=1;i<=c;i++){

		System.out.print("\n*");
		
		for(int i2=1;i2<=l;i2++){
			System.out.print(" *");
			}
		}
	}
}

