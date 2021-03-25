import java.util.Scanner;
import java.io.*;

public class Mt2_89288{

// DÁRIO MATOS 89288 TURMA 8
	
		static Scanner sc= new Scanner (System.in);
		static int nota;
	public static void main (String[] args) throws IOException {
		
		int num,valor,max,min,moda;
		double media;
		
		do{			//Validar numero de alunos da turma
			
			System.out.println("Numero de alunos:");
			num=sc.nextInt();
			
			if(num<0 || num>20){
				
				System.out.println("Numero invalido de alunos!");
				}
			
		}while(num<0 || num>20);
		
			int a_notas[] = new int[num]; //Array correspondente ao conjunto de notas
		
		for(int i=0; i<=a_notas.length-1;i++){
				
			valor=validarNota();
			a_notas[i]=valor;
				
			}
		
				
		//Atribuição de valores de media, valor maximo, minimo e moda a variáveis		
		media=calculaMedia(a_notas);
		max=calculaMax(a_notas);
		min=calculaMin(a_notas);
		moda=calculaModa(a_notas);
				
		imprimeTabela(a_notas,min,max,media,moda); //Impressao da tabela com os dados pedidos
		
		escreveFicheiro(a_notas,num,min,max,media,moda);
	}
	
	public static int validarNota (){ //Função apra validar o valor da nota introduzida
		
		do{
			
			System.out.println("Nota:");
			nota=sc.nextInt();
			
			if(nota<0 || nota>20){
				
				System.out.println("Nota invalida!");
				
				}
			
		}while(nota<0 || nota>20);
			
		return nota;	
		
	}
		
		
	public static double calculaMedia(int [] a){ //Função para calcular media
	
	int soma=0;
	double media=0;	
		
		for(int i=0;i<=a.length-1;i++){
			
			soma += a[i];
			
			}
			
			media=(double)soma/(a.length);

		return media;
		
	}
		
	public static int calculaMax (int [] a){ //Função para calcular maximo
		
	int max=0;	
		
		for(int i=0;i<=a.length-1;i++){
			
			if(a[i]>max){
				
				max=a[i];
				
				}
			
			}
			
		return max;	
	
		}
		
		
	public static int calculaMin (int [] a){ //Função para calcular minimo
		
		int min=20;	
		
		for(int i=0;i<=a.length-1;i++){
			
			if(a[i]<min){
				
				min=a[i];
				
				}
			
			}
			
		return min;	
	
		}
		
		
	public static int calculaModa (int [] a){ //Função para calcular moda
		
		int cont=1,cont2,valor=0;
		int moda=a[0];
		
		for(int i=0;i<a.length-1;i++){
			
			valor=a[i];
			cont2=0;
			
			for(int i2=1;i2<a.length;i2++){
				
				if(valor==a[i2]){
					
					cont2++;
					
					}
					
				if(cont2>cont){
					
					moda=valor;
					cont=cont2;
										
					}
				
				}
			}
	
		return moda;
	
		}	
		
		public static void imprimeTabela(int[]a,int x, int y, double w, int z){ //Função para imprimir tabela
			
			System.out.println("Tabela com as notas de uma turma");
		
			for(int i=0;i<=a.length-1;i++){
				
				System.out.printf("%2d\n",a[i]);
				
				}
			
			System.out.printf("nota minima= %2d\n",x);
			System.out.printf("nota maxima= %2d\n",y);
			System.out.printf("nota media= %4.2f\n",w);
			System.out.printf("nota mais frequente= %2d\n",z);
			
			
			}
			
			//Função para escrever Ficheiro
		public static void escreveFicheiro (int[] a,int x, int b, int c, double d, int m) throws IOException {
			
			File fich = new File("notasT.txt"); //Criação do ficheiro de nome notasT
			
			PrintWriter pw = new PrintWriter(fich);
			
			pw.println(x); //Impressao do numero de alunos
			
			//Impressao dos dados pedidos
			
				for(int i=0;i<=a.length-1;i++){
					
					pw.println(a[i]);
					
					}
			pw.println(b);
			pw.println(c);
			pw.println(d);
			pw.println(m);
			
			pw.close();
			}
}



