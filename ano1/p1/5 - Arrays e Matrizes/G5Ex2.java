import java.util.*;

public class G5Ex2 {
	
	public static void main (String[] args) {

	Scanner sc= new Scanner (System.in);
	System.out.println("Introduza o numero a valorizar:");
	int a= sc.nextInt();
	int cont=0;
	
	int [] coiso = new int [100];
	
		
	for(int i=0;i<=coiso.length-1;i++){
			
			System.out.println("Introduza um valor:");
			int b= sc.nextInt();
			
			coiso[i]=b;
			
			if(coiso[i]==a){
			
				cont++;
				
				}
			if(b<0){
				
				break;
				
				}
			}

	System.out.printf("O numero de vezes que o algarismo %2d foi introduzido foi %2d", a, cont);
		
	}

}
