import java.util.Scanner;

public class ResolTeste {
		static final int nota_max=0;
		
	public static void main (String[] args) {
		
	Scanner sc= new Scanner (System.in);
	int n,notaAl,nota_min=0,nota_max=0,soma,media,nPos,nNeg;
	
		
		
	System.out.println("Insira uma opcao: (1) Inserir ou (2) Gerar");
	
	int e=sc.nextInt();
	
	if(e==1){		
			
		n= num();
			
		notasAlunos(n);
		
		//soma= notasAlunos(n);
		//nota_max= notasAlunos(n);
		
		
		//System.out.printf("A soma e %3d e nota max %3d", soma, nota_max);
		
		}
		
	if(e==2){
		
		}
	
		
	}
	
	
	public static void notasAlunos (int x) {
	
		Scanner sc= new Scanner (System.in);
	
		int nota=0, nota_min=20,soma=0,media,proxm,proxM;

		for(int i=1;i<=x;i++) {
		
		System.out.println("Introduzir nota do aluno:");
		nota= sc.nextInt();
		soma+=nota;
		
	if(nota<nota_min){
			
			nota_min=nota;
			
				}
		
		if(nota>nota_max){
			
			nota_max=nota; 
	
			}
			
		}
		
		media=soma/x;
		
		proxm=20-nota_max;
		
		proxM=20-nota_min;
		
		System.out.printf("A soma das notas e de %3d, a nota minima %3d, a nota maxima %3d, media %2d, proximidades %3d e %3d",soma,nota_min, nota_max,media,proxm, proxM);
		
	}
			
			//System.out.printf("A nota minima foi de %2d valores\n", nota_min);
			//System.out.printf("A nota máxima foi de %2d valores\n", nota_max);
			//System.out.printf("A soma de todas as notas e de %3d \n", soma);	
					
	public static int p1 (int x){
		
		int proxim;
		
		proxim = 20-x;
		
		return proxim;
		
		}
		
		
	public static int p2 (int x){
		
		int proxiM;
		
		proxiM = 20 - x;
		
		return proxiM;
		
		}  
			
		
	public static int num () {
	
	Scanner sc = new Scanner (System.in);
	
	System.out.println("Introduzir numero de notas");
	int n= sc.nextInt();
	
	return n;
	
	}
	
	
	public static int Nminima (int a, int b){
		
		if(a<b){
			
			b=a;
			
			return a;
		
		 }
		
		else{
			return b;
		}
	}	
					
		
	
}
