package aula5.Ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ficheiro implements ContactManage{
	
	private File file;
	

	@Override
	public ArrayList<Contacto> read() throws FileNotFoundException {
		Scanner sc= new Scanner((Readable) this.file);
		String tipo=sc.nextLine();
		sc.close();
		
		int select=0;
		
		if(tipo.contains("Nokia")) {
			select=1;		
		}
		
		else if(tipo.contains("vCard")) {
				select=2;				
			}
		
		else if(tipo.contains("CSV")) {
				select=3;
			}
		
		return read(select);
	}

	@Override
	public void SaveFile(ArrayList<Contacto> p, String type) throws IOException {
		Scanner sc= new Scanner((Readable) this.file);
		String tipo=sc.nextLine();
		sc.close();
		
		if(tipo.contains("Nokia")) {
			Nokia nokia=new Nokia(this.file);
			nokia.print(p);
		}
		
		else if(tipo.contains("vCard")) {
			vCard vcard=new vCard(this.file);
			vcard.print(p);
			}
		
		else if(tipo.contains("CSV")) {
			CSV csv= new CSV(this.file);
			csv.print(p);
			}
	}
	
	
	
	public ArrayList<Contacto> read(int a){
		
		if(a==0) {
			Nokia nokia= new Nokia(this.file);
			return nokia.read();}
		
		else if(a==1) {
			vCard vcard= new vCard(this.file);
			return vcard.read();}
		
		else if(a==2) {
			CSV csv= new CSV(this.file);
			return csv.read();}
	
		else return null;
		
	}

	
}