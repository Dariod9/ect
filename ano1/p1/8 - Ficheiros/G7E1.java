import java.util.Scanner;
import java.io.*;

public class G7E1 {
	
	public static void main(String[] args) 	throws IOException{
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Introduza o nome do ficheiro a ler:");
		String nome = sc.nextLine();
	
		File fich = new File(nome);
	
		Scanner scf = new Scanner(fich);
		
		while(scf.hasNextLine())
		 
		System.out.println(scf.nextLine());	
		
		scf.close();
			
}
}
