/*
 * Pessoal, tentativa de interpretação daquele suposto teste de P1:
 * 
 * Como não temos enunciado, primeiro temos que determinar o objetivo do programa:
 * 
 * O objetivo do exercício é tendo x alunos numa turma registar as notas que os x alunos obtiveram num teste (0 a 20) e depois mostrar várias estatísticas sobre as notas da turma.
 * As notas podem ser registadas através de Scanner (perguntar ao utilizador cada nota), ou gerando-as de forma aleatória
 * Em ambos os casos, o número de alunos, x, tem de ser obtido através do Scanner
 * Eu disse registar as notas mas nós não as vamos registar verdadeiramente pq arrays não calham no teste. O que vai acontecer é que a cada nota que introduzimos (seja por Scanner ou random) alteramos as variáveis que usamos para as estatísticas. No final é fazer print dessas variáveis 
 * Quais as estatísticas?
 * 
 * Corri o programa e estas são as estatísticas que ele imprime:
 * 
 * ------------------------------
 * Proximidade minima:  1
 * Proximidade maxima: 18
 * Total de negativas:  3
 * Total de positivas:  2
 * Soma das notas:     48
 * Media:               9.60
 * Nota minima:         2
 * Nota maxima:        19
 * ------------------------------
 * 
 * 
 * Próximidade minima = 20 - nota mais alta
 * Proximidade maxima = 20 - nota mais baixa
 * O resto é fácil
 * Ou seja, só precisamos de ter variáveis para todas estas estatisticas e ir alterando à medida que recebemos as notas. a média faz-se no final
 * Mas eles pedem para fazer estas operações de alterar as variáveis cada uma na sua função individual, menos a nota mínima e máxima, isso eles fizeram na main.
 * 
 * Sigam desde o início, isto depois de tentar perceber não é assim tão difícil.
 * 
 * Se tiverem alguma dúvida avisem,
 * Ass: Rosmaninho
 * 
 */

import java.util.*;
import java.util.Scanner;

public class TesteP2 {
	static Scanner read = new Scanner(System.in);
	static final int nota_max = 20;
	
	public static void main (String[] args) {
		int escolher; // opção (se quer inserir as notas manualmente ou gerar random)
		int nota; // este int é a o que usamos para colocar o resultado do Scanner ou random. vai mudando a cada sacnner ou random
		int minp = 0; // proximidade minima
		int maxp = 0; // proximidade maxima
		int soma = 0; // soma de todas as notas
		int neg_notas = 0; // número de notas negativas
		int pos_notas = 0; // número de notas positivas
		int num_al = 1; // este int guarda o numero do aluno em que vamos. Ou seja, o número do aluno (de 1 a total_al) que teve a nota que foi registada no int nota. Cada vez que registamos uma nova nota este numero aumenta 1
		int total_al; // total de alunos na turma
		int min = 0; // nota minima
		int max = 0; // nota maxima
		
		// Escolher entre usar Scanner (introduzir manualmente) ou random)
		do{
			System.out.println("Escolha uma das opçoes:  (1) - Inserir      (2) - Gerar");
			escolher = read.nextInt(); // guardar a opção no int escolher
		}while(escolher !=1 && escolher != 2);
		
		// Perguntar e guardar o número total de alunos. VER FUNÇÂO inserir() mais abaixo
		System.out.println("Numero de alunos? ");
		total_al = inserir(1, 40); // minimo 1, maximo 40
		
		// Loop que vai repetir até passarmos por todos os alunos. ou seja, repetir total_al vezes
		do{
			if(escolher == 1){
				System.out.println("Nota? ");
				nota = inserir(0, 20); // Perguntar e guardar a nota do aluno. VER FUNÇÂO inserir() mais abaixo
			}
			// Se a opção for 2:
			else {
				nota = gerar(); // gerar nota random. VER FUNÇÃO gerar() mais abaixo 
			}
			
			System.out.println();
			neg_notas = total_neg(nota, neg_notas); // Chamar funções para atualizar neg_notas e pos_notas para incluir o valor da nota que foi inserida
			pos_notas = total_pos(nota, pos_notas);
			
			// Para o primeiro aluno:
			if(num_al == 1){
				// PS: nota_max é igual a 20, podiam escrever só 20
				// Como estamos na primeira nota, essa nota é a nota mínima e a máxima
				// Para além disso, (20 - nota) é a proximidade minima e a maxima 
				
				maxp= minp = nota_max - nota;
				min = max = nota;
				soma  = nota;  // a soma das notas é a propria nota
				
			}
			else{
				minp = min_prox(nota, minp); // Chamar a função min_prox() com a nota do aluno para atualizar variável minp
				maxp = max_prox(nota, maxp); // Chamar a função max_prox() com a nota do aluno para atualizar variável maxp
				soma = tsoma(nota, soma); // Chamar a função tsoma() com a nota do aluno para atualizar variável soma
			}
			
			System.out.printf("Aluno "+num_al+": Nota = "+nota); // print da nota de cada aluno
			
			if (nota <= min){ // Se nota for menor do que a atual nota mínima, nota torna-se a nova nota mínima
				min = nota; // Apontar a nova nota mínima
				System.out.printf("\nAluno com nota minima: aluno numero %d", num_al); // Se tivermos uma nova nota mínima fazemos print disso (pq o enunciado o pede, aparentemente)
				System.out.println();
			}
			else if(nota >= max){ // Se nota for maior do que a atual nota máxima, nota torna-se a nova nota máxima
				max = nota; // Apontar a nova nota máxima
			}
			num_al++; //incremento de alunos
			
		} while (num_al >0 && num_al <=total_al); // repetir para cada aluno da turma
		
		// IMPRIMIR AS ESTATiSTICAS
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
	
	// Esta função valida o numero obtido. Apenas devolve o numero quando este estiver entre min e max (ints que são fornecidos à função quando a chamamos).
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
		int nota = (int) (20*Math.random()); // Math.random() gera um double de 0 a 1. 20 * Math.random() gera, portanto, um double de 0 a 20. Como antes temos "(int)", o double obtido do random é arredondado ao inteiro mais próximo.  
		return nota;
	}
	
	public static int min_prox(int nota, int prox_min){ // Calcula a proximidade da nota maxima com o 20 ( proximidade minima)
		// Se (20 - nota) for menor do que a atual proximidade minima, (20 - nota) torna-se a nova proximidade minima
		if((nota_max - nota) < prox_min){
			return (nota_max - nota);
		}
		return prox_min;
	}
	
	public static int max_prox(int nota, int prox_max){  // Calcula a proximidade da nota minima com o 20 ( proximidade maxima)
		// Se (20 - nota) for maior do que a atual proximidade máxima, (20 - nota) torna-se a nova proximidade máxima
		if((nota_max - nota) > prox_max){
			return(nota_max - nota);
		}
		return prox_max;
	}
	
	// AS FUNÇÕES ABAIXO são simples de perceber, mas se tiverem dúvida avisem.
	
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

