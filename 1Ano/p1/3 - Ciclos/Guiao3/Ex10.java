import java.util.Scanner;

public class Ex10
{
  public static void main(String[] args) {

	Scanner sc= new Scanner (System.in);

int num=0,x1=0,x3=0, menor,maior;

System.out.println("Introduzir numero:");
x1=sc.nextInt();

menor=x1;
maior=x1;

do{
		
	System.out.println("Introduzir numero:");
	num=sc.nextInt();
		
	if(num==(2*x3)){
		
		break;
		
		}
	
	
	else if(num!=x3){

	x3=num;
	
	}
	
		
	else if(num>x3){
		
		maior=num;
		
		}
		
	else if(num>maior){
		
		maior=num;
		
		}
	
	else if(num<x3){
		
		menor=num;
		
		}
		
	else if(num<menor){
		
		menor=num;
		
		}		
	
	}while(num!=(2*x3));

	System.out.printf("O maior numero e %4d e o menor e %4d. Acabou com %4d", maior, menor, num);

}

}
