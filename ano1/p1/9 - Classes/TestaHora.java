import java.util.Scanner;

public class TestaHora {
  static final Scanner sc = new Scanner(System.in);
  
  public static void main(String[] args) {
    Hora inicio;  // tem de definir o novo tipo Hora!
    Hora fim;
    
    inicio = new Hora();
    inicio.h = 9;
    inicio.m = 23;
    inicio.s = 5;
    
    System.out.print("Começou às ");
    printHora(inicio);  // crie esta função!
    System.out.println(".");
    System.out.println("Quando termina?");
    //fim = lerHora();  // crie esta função!
    System.out.print("Início: ");
    printHora(inicio);
    System.out.print(" Fim: ");
   // printHora(fim);
  }
  
	public static void printHora (Hora horageral){
	
	
	System.out.print(horageral.h + ":" + horageral.m + ":" + horageral.s);
		
	}
  
	
	public static void lerHora (){
	
	Hora fim;
	fim = new Hora();
	fim.h=11;
    fim.m=07;
    fim.s=02;
    
		
	System.out.printf("hora? %2d \n", fim.h);
	System.out.printf("minuto? %2d \n", fim.m);
	System.out.printf("segundo? %2d \n", fim.s);	
	
	} 
  
  
  }
  
  
  
  class Hora{
	  
	  int h,m,s;
	  
  }
  
  
/**
EXEMPLO do pretendido:
$ java TestaHora
Começou às 09:23:05.
Quando termina?
horas? 11
minutos? 7
segundos? 2
Início: 09:23:05 Fim: 11:07:02.
**/

