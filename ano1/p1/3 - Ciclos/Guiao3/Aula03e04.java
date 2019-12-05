import java.util.Scanner;

public class Aula03e04
{
  public static void main(String[] args) {
	
	
	Scanner sc = new Scanner(System.in);

int n, cont=0;

do{
	
	System.out.println("Introduzir numero:");
	n= sc.nextInt();
	cont++;
} while(n>0);

	System.out.printf("Quantidade de numeros introduzidos: %2d", cont);

}

}
