import java.util.Scanner;
import java.io.*;

public class Ficheiros {
	
	public static void main(String[] args) 	throws IOException{

	Scanner sc= new Scanner (System.in);
		
	System.out.print("Nome do Ficheiro: ");

		String nome = sc.nextLine();

		File newf = new File(nome);
	
	
	PrintWriter pw = new PrintWriter(newf);

		System.out.println("Introduzir o texto do ficheiro");
		String texto = sc.nextLine();

	pw.println(texto);

	pw.close();
		
	System.out.println("Ficheiro criado com sucesso!");
	
	/*	Scanner sc = new Scanner (System.in);
		
			System.out.print("Ficheiro de entrada: ");

			String nameIn = kb.nextLine();
			
	
		File newf = new File(Fitcheiro);
		
		Scanner scf = new Scanner(newf);
		
		while(scf.hasNextLine())
			
			
		scf.close(); */
		
	}
}



