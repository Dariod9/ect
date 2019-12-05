package aula8.Ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		int[] ganho = {25, 50, 125, 250, 500, 750, 1500, 2500, 5000, 10000, 16000, 3200, 64000, 125000, 250000};
		
		Quizz quizz = new Quizz();
		
		ArrayList<Question> perguntas = quizz.getTeste();
		
		for (int i=0; i<perguntas.size() ; i++) {
			Framework programa=new Framework(perguntas.get(i),ganho[i]);
			//qqsm.wait();
		}
	}
}