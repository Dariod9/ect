import java.util.Scanner;
import java.io.*;


public class G7Ex4 {

		public static void main (String[] args) throws IOException {
		
			Scanner sc= new Scanner (System.in);
		int i=0;
		int array[]= new int[30];  //Array para 30 notas, 1 a cada aluno
			
			System.out.println("Ficheiro a abrir (.extensao)");
			String nome = sc.nextLine(); //"Chamar" o ficheiro
			
			File fich = new File(nome);
		
		Scanner scf1 = new Scanner(fich);
		
		while(scf1.hasNextInt())
		
			System.out.println(scf1.nextInt()); //Imprimir cada nota
		
			scf1.close();
		
			Scanner scf2 = new Scanner(fich);			
				//Atribuir a cada espaço do array uma nota
				
				array[i++]=scf2.nextInt();
					
		//for(int i2=0;i2<=array.length-1;i2++){
			
			//System.out.printf("\n%2d ", array[i2]);
			
			//}
		
		scf2.close();
			
		System.out.println("Histograma de Notas");
		System.out.println("----------------------------------------------------");				
				
			for(int i2=0;i2<=20;i2++){
				
				System.out.printf(" %2d  | ",i2);
				
				for(int i3=0;i3<=array.length-1;i3++){
					
					if((int) array[i3]==i2){ System.out.print("*"); }
					
						}
					System.out.println(" ");
					
			} 
		
			
	
	}		
	
	
}
