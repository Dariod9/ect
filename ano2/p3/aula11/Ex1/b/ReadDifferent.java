package aula11.Ex1.b;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReadDifferent {

	
	private String nome;
	private int totNum;
	private HashSet<String> set=new HashSet<String>();
	
	public ReadDifferent(String nome) throws IOException {
		
		String s=nome+".txt";
		
		Path p=Paths.get("C:\\Users\\DarioMatos\\Desktop\\ECT\\2 Ano\\P3\\aula1\\src\\aula11\\Ex1\\b", s);
		
		Charset charset=Charset.forName("US-ASCII");
		List<String> listaS=Files.readAllLines(p, StandardCharsets.ISO_8859_1);
		
		List<String[]> linhas=new ArrayList<>();
		
		for (int i = 0; i < listaS.size(); i++) {
			String tmp=(String) listaS.get(i);
			linhas.add(i, tmp.split("[\\W]+"));
		}
		
		
		for (int i = 0; i < linhas.size(); i++) {
			for (int j = 0; j < linhas.get(i).length; j++) {
				totNum++;
				addH(linhas.get(i)[j]);
			}
		}
		
		
		System.out.println("Numero de palavras: "+totNum +"\n Numero de palavras diferentes: "+set().size());
		
	}
	
	
	public boolean addH(String word) {
		if(!set().contains(word)) {
			set().add(word);
			return true;
		}
		else return false;
	}
	
	public HashSet<String> set() { return this.set;}
	
	
}
