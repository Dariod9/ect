package aula8.Ex3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Quizz {

	private ArrayList<Question> teste= new ArrayList<Question>();
	
	public Quizz() throws IOException {
		
		Path fich=Paths.get("C:\\Users\\DarioMatos\\Desktop\\aula8_material\\aula8_material\\QQSM\\QQSM", "questions.txt");
		List listaQ= Files.readAllLines(fich);
		
		for(int i=0;i<listaQ.size();i++) {
			String linha=(String) listaQ.get(i);
			String[] linhas=linha.split("&&");
			
			//Imagem
			String nomeImg = linhas[0].substring(5, linhas[0].length());
			ImageIcon imagem= new ImageIcon(nomeImg);
			
			String q=linhas[1];
			String[] ans= {linhas[2],linhas[3],linhas[4],linhas[5]};
			String correct= linhas[2];
			
			Question a=new Question(imagem,q,ans,correct);
			
			teste.add(a);
		}
		
		
	}
	
	public ArrayList<Question> getTeste(){ return teste;}
}
