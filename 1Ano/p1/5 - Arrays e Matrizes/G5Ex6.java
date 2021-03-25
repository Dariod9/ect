import java.util.*;

public class G5Ex4 {
	
	public static void main (String[] args) {

	Scanner sc= new Scanner (System.in);
	System.out.println("Introduza o numero a valorizar:");
	int a= sc.nextInt();
	int cont0=0,cont1=0,cont2=0,cont3=0,cont4=0,cont5=0,cont6=0,cont7=0,cont8=0,cont9=0,cont10=0;
	int cont11=0,cont12=0,cont13=0,cont14=0,cont15=0,cont16=0,cont17=0,cont18=0,cont19=0,cont20=0;
	
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
