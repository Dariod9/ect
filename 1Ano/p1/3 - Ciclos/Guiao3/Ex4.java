import java.util.Scanner;

public class Ex4
{
  public static void main(String[] args) {

	Scanner sc= new Scanner (System.in);
	
	{
	 int num = lerInteiroNoIntervalo(1, 10);
	  imprimeTabela(num);
	   } 
	   
	   public static int lerInteiroNoIntervalo(int linf, int lsup){
		    Scanner kb = new Scanner(System.in);
		    
		     int n; 
		     
		     do{ 
				 
				 System.out.print("Valor inteiro: ");
				 
				  n = kb.nextInt();
				   
			}while(n < linf || n > lsup); 
				   
		   return n; 
				   }
				   
		    public static void imprimeTabela(int n){ 
				
			for(int i = 0 ; i <= 10 ; i++) 
			
			printf("%2d X %2d = %3d\n", n, i, n*i);
}
}

}
