import java.util.Scanner;
import java.io.*;

public class Dario {
	
	public static void main (String[] args) throws IOException {
	Scanner sc = new Scanner (System.in);

		int array[]= new int[30];  //Array para 30 notas, 1 a cada aluno

//		System.out.println("Ficheiro a abrir (.extensao)");
//		String nome = sc.nextLine(); //"Chamar" o ficheiro

		File fich = new File("turma.txt");

		Scanner scf1 = new Scanner(fich);
		int i = 0;
		while(scf1.hasNextInt()) {
			int nota = scf1.nextInt();
			System.out.println(nota); //Imprimir cada nota

		}
		scf1.close();
		
		
		Scanner scf2 = new Scanner(fich);
		while(scf2.hasNextInt()) {
			array[i++] = scf2.nextInt();
		}
		scf2.close();	
		
		System.out.println("\nArray:");
		for(int j = 0; j < array.length; j++)
			System.out.println(array[j]);
		
		}		
		
		
	}
