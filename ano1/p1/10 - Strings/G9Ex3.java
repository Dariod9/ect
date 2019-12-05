import java.util.*;


public class G9Ex3 {
		static Scanner sc= new Scanner (System.in);
	public static void main (String[] args) {
		
	String s= new String();
	s=sc.nextLine();
	
	CountWord(s);
	}
		
	public static void CountWord (String x){
		
		char letra;
		int contP=0;
		
		for(int i=0;i<=x.length()-1;i++){
			
			letra=x.charAt(i);
			
			if(letra == ' ' || letra == '\n'){
				
				contP++;
				
				}
			
			}
		
		System.out.printf("O numero de palavras e: %2d",contP+1);
		
		}
}

