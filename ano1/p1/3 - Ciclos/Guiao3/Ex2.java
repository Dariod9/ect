import java.util.Scanner;

public class Ex2
{
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

double prod=1,x=0;

	do {
		
	System.out.print("Introduza um numero:");
	x= sc.nextDouble();
	
			if(x==0){
		
			break;
		
			}
	
	prod*= x;

	} while(x!=0); 
	
	if(x==0); {
		
	System.out.printf("Acabou, o produto dos numeros e %3f", prod);
	
}
	
	}


	
}

