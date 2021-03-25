import java.util.Scanner;

public class Ex9
{
  public static void main(String[] args) {

	Scanner sc= new Scanner (System.in);
	
double n, contP=0, contN=0, contI=0, contI2=0;
 
System.out.printf("Introduzir notas: %n");
 
do{	
		n= sc.nextDouble();
		;
		
		if(n>0){
		
		contP++;		
		
			}
			
	
		if(n<0){
		
		contN++;		
		
			}
	
		if(n>100 && n<1000){
		
		contI++;		
		
			}
	
		if(n>-1000 && n<-100){
		
		contI2++;		
		
			}
	
	
	}while(n!=0);
	
	System.out.printf("Quantidade de  numeros positivos: %4.2f %n", contP);
	System.out.printf("Quantidade de  numeros negativos: %4.2f %n", contN);
	System.out.printf("Quantidade de  numeros no intervalo [100,1000]: %4.2f %n", contI);
	System.out.printf("Quantidade de  numeros no intervalo [-1000,-100]: %4.2f %n", contI2);

}

}
