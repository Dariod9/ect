package aula1.palindrome;

import genclass.GenericIO;

public class Palindrome {	
	
	public static void main(System[] args) {
		System.out.println("ola");
		
		String word;
		int i = 0;
		
		GenericIO.writelnString("Quall é a palavra? ");
		word = GenericIO.readlnString();
		if(word == null) word="";
		
		/* seu armazenamento (carater a carater) em paralelo nas memórias de tipo stack e fifo */
		MemStack<Character> stack = new MemStack<Character>(word.length());
		MemFIFO<Character> fifo = new MemFIFO<Character>(word.length());
		
		try {
			for(i=0; i<word.length(); i++) {
				stack.write(new Character (word.charAt(i)));
				fifo.write(new Character (word.charAt(i)));
				
			}
		} catch (MemException e) {
			GenericIO.writelnString("Error: ", e.getMessage(), " na interação " + (i+1));
			GenericIO.writelnString("Error: ", e.toString());
			e.printStackTrace();
			System.exit(1);
		}
		
		/*leitura sucessiva (carater a carater) em paralelo dos valores armazenados nas duas memórias com sua comparação */
		
		try {
			for(i=0; i<word.length(); i++) {
				if((stack.read()).charValue() != (fifo.read()).charValue()) {
					GenericIO.writelnString("Não é um palindroma!");
					return;
				}
			}
		} catch (MemException e) {
			GenericIO.writelnString("Error: ", e.getMessage(), " na interação " + (i+1));
			GenericIO.writelnString("Error: ", e.toString());
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
}
