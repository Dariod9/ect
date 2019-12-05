import java.util.Scanner;

public class Ex3
{
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

double x1,x,max=0,min=0,soma=0,media=0,cont=0;

	System.out.print("Inserir primeiro numero:");
	x1= sc.nextDouble();
	
	soma=x1;
	cont=1;
	max=x1;
	min=x1;

do{
	
	System.out.print("Inserir numero seguinte:");
	x= sc.nextDouble();
	cont++;
	
	if(x>x1) {
		
		max=x;
		
		}
		
	else if(x>max){
		
		max=x;
		
		}	
	
	else if (x<x1){
		
		min=x;
		
	}
	
	else if (x<min){
		
		min=x;
		
	}
	
		soma+=x;
		
		media=soma/cont;
		
			
}while(x!=x1);



System.out.printf("Maximo: %3.2f  Minimo: %3.2f   Media: %3.2f  Cont= %3.2f", max, min, media, cont);





	}

}
