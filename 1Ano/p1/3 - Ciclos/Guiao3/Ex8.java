import java.util.Scanner;

public class Ex8
{
  public static void main(String[] args) {

	Scanner sc= new Scanner (System.in);
	
int n, cont=0;
double soma=0, media=0;
 
 System.out.printf("Introduzir notas: %n");
 
do{	
		n= sc.nextInt();
		cont++;
		
	if(n<0){
		
		System.out.printf("A soma das notas e %4.2f e a media e %4.2f e %4d", soma, media, cont-1);
		
			}
	
	soma += n;
	media = soma/(cont);
	
	}while(n>=0);

}

}
