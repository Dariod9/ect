import java.util.*;

public class G9Ex1 {
		static Scanner sc= new Scanner (System.in);
		
	public static void main (String[] args) {
	
	int contM=0,contm=0,cont1=0,contV=0,numC=0;
	char letra;
	
	String frase = new String();
	
	System.out.println("Introduza a sua frase");
	frase=sc.nextLine();
	
			 for (int i=0;i<frase.length();i++){
				
				letra=frase.charAt(i);
				
				if(Character.isUpperCase(letra)){
					
					contM++;
					
					}
				
				else if(Character.isLowerCase(letra)){
					
					contm++;		
					
					}
					
				else if(Character.isDigit(letra)){
					
					cont1++;
					
					}
					
				if(isVowel(letra)==true){
					
					contV++;
					
					}
					
					
				}

		numC=frase.length() - (contV+cont1);

	System.out.println("Analise de uma frase");
	System.out.print("Frase de entrada -> "); System.out.print(frase);
	System.out.printf("\nNumero de caracteres minusculos -> %2d\n", contm);
	System.out.printf("Numero de caracteres maiusculos -> %2d\n", contM);
	System.out.printf("Numero de caracteres numericos -> %2d\n", cont1);
	System.out.printf("Numero de vogais ->%2d\n",contV);
	System.out.printf("Numero de consoantes -> %2d\n",numC);
	}
	
	public static boolean isVowel(char c){
			
			if(c == 'a' || c=='e' || c=='i' || c=='o'|| c=='u'){
				
				return true;
				
				}
		
				return false;
		
			}
			
	}

