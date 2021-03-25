import java.util.*;

public class G6E3 {
	static Scanner sc=new Scanner (System.in);
	public static void main (String[] args) {
		
		int e,max=0,min=20;
		int a[]= new int[50];
		
	System.out.println("Analise de uma sequencia de numeros inteiros");
	System.out.println("1 - Ler a Sequencia");
	System.out.println("2 - Escrever a Sequecia");
	System.out.println("3 - Calcular o maximo da sequencia");
	System.out.println("4 - Calcular o minimo da sequencia");
	System.out.println("5 - Calcular a media da sequencia");
	System.out.println("6 - Detetar se e uma sequencia de pares");
	System.out.println("10 - Terminar Programa");
	
		
	do{
		
		System.out.print("Opcao -> ");
		e=sc.nextInt();
		
		switch(e){
		
		case 1: a=ler();
				break;
				
		case 2: imprimir(a);
				break;
		
		case 3: System.out.println("O maximo e " + calcMax(a));
				break;
				
		case 4: System.out.println("O minimo e " + calcMin(a));
				break;
		
		case 5: System.out.println("A media e " + calcMed(a));
				break;
		
		case 6: parDetect(a);
				break;
		
		}
			}while(e!=10);
	
	}


	public static int[] ler(){
		
		int n;
		int[] a= new int[50];
		
		for(int i=0;i<=a.length-1;i++){
			
			System.out.println("Introduza um valor");
			n=sc.nextInt();
		
			if(n==0){break;}
			
			a[i]=n;
			
			}
		System.out.print("\n");
		
		return a;
		
		}

	
	public static void imprimir (int[] x){
		
		for(int i=0;i<=x.length-1;i++){
			
			System.out.print(x[i] + " ");
			
			}
		}
		
	public static int calcMax (int[] x){
		
		int max=0;
		
		for(int i=0;i<=x.length-1;i++){
			
			if(x[i]>max){
				
				max=x[i];
				
				}
			
			}
		return max;
		}

	public static int calcMin (int[] x){
		
		int min=20;
		
		for(int i=0;i<=x.length-1;i++){
			
			if(x[i]<min){
				
				min=x[i];
				
				}
			
			}
		return min;
		}

	public static double calcMed (int[] x){
		
		int soma=0;
		double media=0;
		
		for(int i=0;i<=x.length;i++){
			
			if(x[i]==0){break;}
			
			soma+= x[i];
			
			media= (double) soma/(i+1) ;
			}
		return media;
		}

	public static void parDetect (int[] x){
		
		int help=0;
		
			for(int i=0;i<=x.length-1;i++){
				
				if(x[i]%2!=0){
					
					help=1;
					System.out.println("A sequencia possui numeros impares");
					break;
						}
				}
				
			if(help==0){
				 System.out.println("A sequencia e constituida por numeros pares");
			}
			
		}
		

}

