import static java.lang.System.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import p2utils.KeyValueList;

public class TranslateNumbers
{
  public static void main(String[] args) throws IOException {
	
    KeyValueList<String> counts = new KeyValueList<>();
    
    Scanner sc= new Scanner(System.in);
    
    File f= new File("numbers.txt");
    
    Scanner scf= new Scanner(f);
    
    while(scf.hasNextLine()){
		String s  = scf.next();		//QUASE COMPLETO, FALTA RETIRAR O " -" DE TODOS OS ELEMENTOS TRADUZIDOS
		String s2 = scf.nextLine();
		counts.set(s,s2);
		
		}
		
	scf.close();
	
	out.println("Introduza a frase:");
	String frase=sc.nextLine();
	
	String[] a= frase.split(" ");
	
	for(int w=0;w<a.length;w++){
		if(counts.contains(a[w])) out.printf(" "+counts.get(a[w]));
		else out.printf(" "+a[w]);
					
		}	
	}
}
