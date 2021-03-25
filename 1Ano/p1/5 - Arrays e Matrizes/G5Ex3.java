import java.util.*;

public class G5Ex3 {

	public static void main (String[] args) {
		
		int escolha;
		
		do{
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("\nAnalise de uma sequencia de numeros inteiros\n");
		System.out.print("\n1 - Ler a sequencia\n");
		System.out.println("2 - Escrever a sequencia");
		System.out.println("3 - Calcular o maximo da sequencia");
		System.out.println("4 - Calcular o minimo da sequencia");
		System.out.println("5 - Calcular a media da sequencia");
		System.out.println("6 - Detetar se e uma sequencia so constituida por numeros pares");
		System.out.println("0 - Terminar o programa");
		
		System.out.print(" Opcao --> ");
		escolha =sc.nextInt();
		
		if(escolha<0 || escolha >6){ System.out.println("Opcao Invalida!"); }
		
		
		if(escolha==1){
			
			ler();
			
			}
			
		if(escolha==2){
			
			escrever();
			
			}
		
		
		if(escolha==3){
			
			System.out.printf("O valor maximo foi %3d",maximo());
			
			}
		
		
		if(escolha==4){
			
			System.out.printf("O valor minimo foi %3d",minimo());
			
			}
		
		if(escolha==5){
			
			System.out.printf("O valor da media foi de %4.2f", media() );
			
			}
		
		if(escolha==6){
			
		detect();
		
		}
	
		
		}while(escolha<0 || escolha >6);
			
	
		}
		
		public static void ler(){
		
				Scanner sc= new Scanner (System.in);
				
				int [] ar = new int [50];
				int x;
				

				for(int i=0;i<= (ar.length-1) ;i++){
					
					System.out.println("Introduzir numero");
					x = sc.nextInt();
					
					ar[i]=x;
					
					if(x==0){
						
						break;
						
						
				}
		
			}
			
		
		}
		
		
		
		public static void escrever(){
		
				Scanner sc= new Scanner (System.in);
				
				int [] ar = new int [50];
				int x;
				
				for(int i=0;i<= (ar.length-1) ;i++){
					
					System.out.println("Introduzir numero");
					x = sc.nextInt();
					
					if(x==0){
						
						break;
						
						}
					
					ar[i]=x;
					
				}
					
					
				for(int i=0; i<=ar.length-1;i++){
					
					if(ar[i]==0){break;}
					
					System.out.printf("%2d",ar[i]);
				
					}
		
		
		}
		
		
		
		public static int maximo () {

		
				Scanner sc= new Scanner (System.in);
				
				int [] ar = new int [50];
				int x, max=0;
				
				for(int i=0;i<= (ar.length-1) ;i++){
					
					System.out.println("Introduzir numero");
					x = sc.nextInt();
					
					ar[i]=x;
					
					if(x==0){
						
						break;
						
						}
				
					}

				
				for(int i=0;i<=ar.length-1;i++){
					
					if(ar[i]>max){
						
						max=ar[i];
						
						}
						
					}
					
				return max;

	}

	
		public static int minimo () {

		
				Scanner sc= new Scanner (System.in);
				
				int [] ar = new int [50];
				int x, min;
				
				for(int i=0;i<= (ar.length-1) ;i++){
					
					System.out.println("Introduzir numero");
					x = sc.nextInt();
					
					ar[i]=x;
					
					if(x==0){
						
						break;
						
						}
				
					}


				min=ar[1];
				
				for(int i=0;i<=ar.length-1;i++){
					
					if(ar[i]==0){break;}
					
					if(ar[i]<min){
						
						min=ar[i];
						
						}
						
					}
					
				return min;
		
	}


		public static double media (){
		
				Scanner sc= new Scanner (System.in);
				
				int [] ar = new int [50];
				int x, soma=0, cont=0;
				double media;
				
				for(int i=0;i<= (ar.length-1) ;i++){
					
					System.out.println("Introduzir numero");
					x = sc.nextInt();
					
					if(x==0){
						
						break;
						
						}
					
					ar[i]=x;
					
					soma += ar[i];
					cont++;
					
					}

					media= (soma/cont);
					
					return media;
				

		}
		
		
		public static void detect (){
		
				Scanner sc= new Scanner (System.in);
				
				int [] ar = new int [50];
				int x,p;
				
				for(int i=0;i<= (ar.length-1) ;i++){
					
					System.out.println("Introduzir numero");
					x = sc.nextInt();
					
					if(x==0){
						
						break;
						
						}
					
					ar[i]=x;						

				if((ar[i] % 2)!= 0){
					
					System.out.println("A sequencia possui numeros impares");
					
					break;
					
					}
					
					System.out.println("A sequencia so e constituida por numeros pares");				
					
					}

				} 				
				
				
	}


