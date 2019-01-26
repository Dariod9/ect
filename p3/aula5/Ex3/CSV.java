package aula5.Ex3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CSV{
	private File file;
	private ArrayList<Contacto> listaC = new ArrayList<Contacto>();
	
	public CSV(File file) {
		this.file = file;
	}
	
	public ArrayList<Contacto> read(){
		Scanner sc= new Scanner((Readable) this.file);
		String tipo=sc.nextLine();
		
		while(sc.hasNextLine()) {
			String[] a=sc.nextLine().split("	");
			
			String nome= a[0];
			
			int phone= Integer.parseInt(a[1]);
			
			String[] b=a[2].split("/");
			Data dataNasc= new Data(Integer.parseInt(b[0]), Integer.parseInt(b[1]), Integer.parseInt(b[2]));
			
			Contacto c=new Contacto(nome,dataNasc,phone);
			listaC.add(c);
			}
		return listaC;
	}
	
	public void print(ArrayList<Contacto> a) throws IOException{
		
		File f= new File("CSVCont.txt");
		
		PrintWriter pf= new PrintWriter(f);
		pf.println("CSV");
		
		for(int i=0; i<a.size();i++) {
			
			pf.println(a.get(i).nome()+"	"+a.get(i).phone()+"	"+a.get(i).dataNasc().toString());
		}
		
	}

}