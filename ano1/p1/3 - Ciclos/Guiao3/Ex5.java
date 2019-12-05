import java.util.Scanner;

public class Ex5
{
  public static void main(String[] args) {

	Scanner sc= new Scanner (System.in);

int num;
num=sc.nextInt();

do {
	
	System.out.println("Introduza um numero inteiro:");
	num = sc.nextInt();
	
	
	if(num<=0){
		
		System.out.println("Introduz numero positivo C%RALHO");
	}
	
		
		switch (num){
			
			case 2:
			
			System.out.println("O numero e primo");
			
			break;
			
			case 3:
			
			System.out.println("O numero e primo");
			
			break;
			
			case 5:
			
			System.out.println("O numero e primo");
	
			break;
			
			
			case 7:
			
			System.out.println("O numero e primo");

			break;
			
			
			case 9:
			
			System.out.println("O numero e primo");

			break;
			
			
			case 11:
			
			System.out.println("O numero e primo");

			break;
			
			
			case 13:
			
			System.out.println("O numero e primo");

			break;
	}
		
} while(num>=0);


		
}

}


