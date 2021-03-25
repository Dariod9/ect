package aula7.Ex1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Path compa= Paths.get("C:\\Users\\DarioMatos\\Desktop\\aula7_material\\aula7_material", "companhias.txt");
		Path v= Paths.get("C:\\Users\\DarioMatos\\Desktop\\aula7_material\\aula7_material", "voos.txt");
		Hashtable<String,String> tabela= Aeroporto.toTable(compa);

		Aeroporto aeroporto=new Aeroporto(compa,v,tabela);
		
		File f=new File("Infopublico.txt");
		PrintWriter pf= new PrintWriter(f);
		
		pf.println("Hora\t"+"Voo\t"+"Companhia\t"+"Origem\t"+"Atraso\t"+"Obs");

		pf.print(aeroporto.toString());
		
		pf.close();
		
		for(int i=0;i<aeroporto.getCompanhias().size();i++) {
			
			System.out.println("Companhia"+"\t"+"Atrasos"
					+ "\n"+aeroporto.getCompanhias().get(i).nomeC()+"\t"+aeroporto.mediaA(aeroporto.getCompanhias().get(i)));

		}
		
	}
}