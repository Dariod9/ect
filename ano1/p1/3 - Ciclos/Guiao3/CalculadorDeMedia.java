import java.util.Scanner;

public class CalculadorDeMedia
{
  public static void main(String[] args) {

	Scanner sc= new Scanner (System.in);

int i, x, n=0, soma=0;
double media=0;

System.out.println("Introduzir numero de notas");
x =sc.nextInt();

for (i=1; i<=x ;i++) {
		
	System.out.println("Introduzir nota");
	n= sc.nextInt();	
		
	soma += n;
	media= soma/x;
	
	}
	

System.out.printf("A soma e %2d e a media e %4.2f", soma, media);

}

}
