import java.util.*;
import java.util.Scanner;

public class TesteP1 {
	static Scanner read = new Scanner(System.in);
	static final int nota_max = 20;
	
	public static void main (String[] args) {
		int escolher, nota, minp = 0, maxp = 0, soma = 0, neg_notas = 0, pos_notas = 0, num_al/*numero de alunos na turma*/ = 1;
		int min = 0, max = 0; 
		
		do{
			System.out.println("Escolha uma das opçoes:  (1) - Inserir      (2) - Gerar");
			escolher = read.nextInt ();			
		}while(escolher !=1 && escolher != 2);
		System.out.println("Numero de alunos");
		int total_al = inserir(1/*min*/, 40/*max*/);
		
		do{
			if(escolher == 1){
				System.out.println("Nota");
				nota = inserir(0, 20);
			}
			else/*escolher =2*/{
				nota = gerar();
			}
			
			System.out.println();
			neg_notas = total_neg(nota, neg_notas);
			pos_notas = total_pos(nota, pos_notas);
			
			if(num_al == 1){
				maxp= minp = nota_max - nota;  //proximidade minima=  proximidade maxima, do primeiro aluno da turma(aplica se também caso só haja um aluno na turma)
				min = max = nota; //nota maxima = nota minima, para o primeiro aluno da turma(aplica se também caso só haja um aluno na turma)
				soma  = nota;  // a soma das notas é a propria nota
				
			}
			else{
				minp = min_prox(nota, minp);
				maxp = max_prox(nota, maxp);
				soma = tsoma(nota, soma);
			}
			
			System.out.printf("Aluno "+num_al+": Nota = "+nota); // print da nota de cada alun
			
			
			if (nota <= min){
				min = nota;
				System.out.printf("\nAluno com nota minima: aluno numero %d", num_al);
				System.out.println();
			}
			else if(nota >= max){
				max = nota;
			}
			num_al++; //incremento de alunos
			
		} while (num_al >0 && num_al <=total_al); // para cada aluno da turma
		
		System.out.println();
		System.out.println("------------------------------");
		System.out.printf("Proximidade minima: %2d\n", minp);
		System.out.printf("Proximidade maxima: %2d\n", maxp);
		System.out.printf("Total de negativas: %2d\n", neg_notas);
		System.out.printf("Total de positivas: %2d\n", pos_notas);
		System.out.printf("Soma das notas: %6d\n", soma);
		System.out.printf("Media: %18.2f\n", media(soma, total_al));
		System.out.printf("Nota minima: %9d\n", min);
		System.out.printf("Nota maxima: %9d", max);
	}
	
	public static int inserir(int min, int max){  // Inserir as notas de todos os alunos
		int nota;
		do{

			nota = read.nextInt();
			
			if(nota < min || nota > max){
				System.out.println("Nota Inválida!");
			}
		}while(nota < min || nota > max);
		return nota;	
	}
	
	public static int gerar(){ // Gera as notas para todos os alunos da turma
		int nota = (int) (20*Math.random());
		return nota;
	}
	
	public static int min_prox(int nota, int prox_min){ // Calcula a proximidade da nota maxima com o 20 ( proximidade minima)
		if((nota_max - nota) < prox_min){
			return (nota_max - nota);
		}
		return prox_min;
	}
	
	public static int max_prox(int nota, int prox_max){  // Calcula a proximidade da nota minima com o 20 ( proximidade maxima)
		if((nota_max - nota) > prox_max){
			return(nota_max - nota);
		}
		return prox_max;
	}
	
	public static int tsoma(int nota, int soma){ // Soma das notas
		soma = soma + nota;
		return soma;
	}
	
	public static double media(int soma, int turma){ // Media das notas
		double m = (double)soma/(double)turma;
		return m;
	}
	
	public static int total_neg (int nota, int neg_notas){ // Total de negativas
		if(nota < 10 && nota >= 0){
			neg_notas++;
		}
		return neg_notas;
	}
	
	public static int total_pos (int nota, int pos_notas){  // Total de positivas
		if(nota >= 10 && nota <= 20){
			pos_notas++;
		}
		return pos_notas;
	}
}

