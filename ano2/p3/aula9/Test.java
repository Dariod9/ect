package aula9;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws IOException {
		
		File f= new File("Testa.txt");
		
		ScannerAbeirense scanner= new ScannerAbeirense(f);
		
		for(int i=0;i<3;i++){
			System.out.println(scanner.nextLine());
	}
		
		System.out.println("Introduzir frase:");
		
		ScannerAbeirense sc= new ScannerAbeirense(System.in);
		String s=sc.nextLine();
		System.out.println(s);
		
		
}
}
