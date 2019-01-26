package aula5.Ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class vCard {
	private File file;
	private ArrayList<Contacto> listaV = new ArrayList<Contacto>();
	
	public vCard(File file) {
		this.file = file;
	}
	
	public ArrayList<Contacto> read(){
		Scanner sc= new Scanner((Readable) this.file);
		String tipo=sc.nextLine();
		
			while(sc.hasNextLine()) {
			String[] a=sc.nextLine().split("#");
			
			String nome= a[1];
			
			int phone= Integer.parseInt(a[2]);
			
			String[] b=a[3].split("/");
			Data dataNasc= new Data(Integer.parseInt(b[0]), Integer.parseInt(b[1]), Integer.parseInt(b[2]));
			
			Contacto c=new Contacto(nome,dataNasc,phone);
			listaV.add(c);
			}
			
		return listaV;
	}
	
	
	public void print(ArrayList<Contacto> a) throws IOException{
		
		File f= new File("vCardCont.txt");
		
		PrintWriter pf= new PrintWriter(f);
		pf.println("vCard");
		
		for(int i=0; i<a.size();i++) {
			pf.println("#"+a.get(i).nome()+"#"+a.get(i).phone()+"#"+a.get(i).dataNasc().toString());
			
		}
		
		pf.close();
	}
	
}			