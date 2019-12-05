package aula1;

public class Ex1_1{
	
	public static void main (String[] args) {
		
	// Ponto A	

	int cont=0;
			
	
	for(int j=0;j<args.length;j++) {

		String s=args[j];
		
			for(int i=0;i<s.length();i++) {
				
				if(Character.isDigit(s.charAt(i))) cont++;

			}
		}

	System.out.printf("As palavras possuem "+cont+" caracteres numericos\n");
	
	//Ponto B e C
	
	boolean big=false;
	boolean small=false;
	
	for(int j=0;j<args.length;j++) {
	
	String s=args[j];
		
		for(int i=0;i<s.length();i++) {
		
			if(Character.isUpperCase(s.charAt((i)))) big=true;
			if(Character.isLowerCase(s.charAt((i)))) small=true;
		}
	
	}
	if(!big && small) System.out.println("As palavra apenas possuem letras minusculas");
	else if(big && !small) System.out.println("As palavras apenas possuem letras maiusculas");
	
	
	//Ponto D
	
	System.out.printf("Foram introduzidas "+args.length+" palavras");
	
		
	//Ponto E
	
	for(int j=0;j<args.length;j++) {
		
		System.out.printf("\n"+args[j]+" --> ");
		
		for(int i=0;i<args[j].length();i++) {
			
			if(i%2==0) System.out.print(args[j].charAt(i+1));
			else System.out.print(args[j].charAt(i-1));
		
		}
		
	
	}
	
	}
	
}