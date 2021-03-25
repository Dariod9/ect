import java.util.Scanner;


public class QuaseTeste {

	public static void main (String [] args){
	
	Scanner sc= new Scanner (System.in);
	int path, n, nota, min=20,max=0, minP=0, maxP=0,soma=0,media=0,neg=0,pos=0;

	do{
		
	System.out.println("Deseja: (1)Inserir os dados  (2) Gerar os dados");
	path= sc.nextInt();
		
		if(path!=1 && path!=2){
			
			System.out.println("Resposta Invalida");
			
			}
		
		}while(path!=1 && path!=2);
		
		

	do{
		
	System.out.println("Introduza o numero de alunos:");
	n=sc.nextInt();
	num_al(n);
	
		if(n<1 || n>40){
			
			System.out.println("Numero Invalido");
				
			}
				
		}while(n<1 || n>40);
		
	if(path==1){	
	
		for(int i=1; i<=num_al(n); i++) {
		
		System.out.println("\nAluno" + i);
		
		nota=notAl();
		min = notaMinima(nota,min);
		max = notaMaxima(nota,max);
		minP= proximidadeMin(max);
		maxP= proximidadeMax(min);
		soma += nota;
		neg= notaN(nota, neg);
		pos= notaP(nota, pos);
	}
	
		media=soma/num_al(n);
		
		System.out.println("----------------");
		System.out.printf("Nota Minima: %2d \n", min);
		System.out.printf("Nota Maxima: %2d \n", max);
		System.out.printf("Proximidade minima: %2d \n", minP);
		System.out.printf("Proximidade maxima: %2d \n", maxP);
		System.out.printf("Soma de todas as notas: %2d \n", soma);
		System.out.printf("Media das notas: %2d \n", media);
		System.out.printf("Existem %2d notas negativas \n", neg);
		System.out.printf("Existem %2d notas postiivas", pos);
	
	}
	
	
	if(path==2){
		
			for(int i=1;i<=n;i++){
				
			nota= notAL_G();
			min = notaMinima(nota,min);
			max = notaMaxima(nota,max);
			minP= proximidadeMin(max);
			maxP= proximidadeMax(min);
			soma += nota;
			neg= notaN(nota, neg);
			pos= notaP(nota, pos);
				
				}
				
		System.out.println("\n----------------");
		System.out.printf("Nota Minima: %2d \n", min);
		System.out.printf("Nota Maxima: %2d \n", max);
		System.out.printf("Proximidade minima: %2d \n", minP);
		System.out.printf("Proximidade maxima: %2d \n", maxP);
		System.out.printf("Soma de todas as notas: %2d \n", soma);
		System.out.printf("Media das notas: %2d \n", media);
		System.out.printf("Existem %2d notas negativas \n", neg);
		System.out.printf("Existem %2d notas postiivas", pos);
	
			
		}
	
	
	}
	

	
	public static int num_al (int x){
	
	int num_al;
	
		
		num_al=x;
		
		return num_al;
	
	}
	
	public static int notAl (){
	Scanner sc= new Scanner (System.in);
		
		int nota;
			
		do{
			System.out.println("Nota:");
			nota= sc.nextInt();
			
			if(nota<0 || nota>20){
				
				System.out.println("Nota Invalida");
				
				}
			
		}while(nota<0 || nota>20);
			
			return nota;
			
				}
	
	public static int notaMinima (int x, int notam){
		
		
			if(x<notam){
				
				notam=x;
				
				return notam;
				
			}
			
			else{
				
				return notam;
				
				}
				
			}	
			
			
		public static int notaMaxima (int x, int notaM) {
			
			if(x>notaM){
				
				notaM=x;
				
				return notaM;
				
					}
					
			else{ return notaM;
				}
				
			}
			
			
		public static int proximidadeMin (int notaM){
			
			int minp= 20 - notaM;
			
			return minp;
			
				}
				
	
		public static int proximidadeMax ( int notam){
			
			int maxp= 20 - notam;
			
			return maxp;
			
			}
	
		
		public static int notaN (int x,int nega){
		
						
			if(x<10){
				
				nega++;
				
				return nega;
					}
					
			else{ return nega; }
			
			}
			
			
		public static int notaP (int x, int pos){
			
			
			if(x>=10){
				
				pos++;
				
				return pos;
				
					}
					
			else{ return pos; }
			
			}
			
	
	
		public static int notAL_G (){
			
			int nota= (int) (21* Math.random());
	
				System.out.printf("\nNota => %2d", nota);
				
			
			return nota;
			
			}
	
	
}
