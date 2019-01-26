package aula5.Ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Nokia {
	private File file;
	private ArrayList<Contacto> listaN = new ArrayList<Contacto>();
	
	public Nokia(File file) {
		this.file = file;
	}
	
	public ArrayList<Contacto> read(){
		Scanner sc= new Scanner((Readable) this.file);
		String tipo=sc.nextLine();
		
			while(sc.hasNextLine()) {
				
				String nome=sc.nextLine();
				
				int phone= Integer.parseInt(sc.nextLine());
				
				String[] a= sc.nextLine().split("/");
				Data dataNasc= new Data(Integer.parseInt(a[0]), Integer.parseInt(a[1]), Integer.parseInt(a[2]));
				
				String espaco=sc.nextLine();
				
				Contacto c= new Contacto(nome,dataNasc,phone);
				listaN.add(c);		
			}
			
		return listaN;
	}
	
	public void print(ArrayList<Contacto> a) throws IOException {
		
		File f= new File("NokiaCont.txt");
		
		PrintWriter pf= new PrintWriter(f);
		pf.println("Nokia");
		
		for(int i=0; i<a.size();i++) {
			
			pf.println(a.get(i).nome());
			pf.println(a.get(i).phone());
			pf.println(a.get(i).dataNasc().toString());;
			
		}
		
		pf.close();
	}
	
}			