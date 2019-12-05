import java.util.*;

public class G9Ex2 {
	
	public static void main (String[] args) {
	
		Scanner sc= new Scanner(System.in);

		String frase= new String();
		
		System.out.println("Introduza um nome:");
		frase=sc.nextLine();

		Acro(frase);
		
	}
	
	
	public static void Acro (String s){
		
		int numM=0;
		char letra;
		
		for(int i=0;i<s.length();i++){
			
			letra=s.charAt(i);
			
			if(Character.isUpperCase(letra)){
				
				numM++;
				
				}
			
			}
			
	char[] a= new char[numM];


		for(int i2=0;i2<=0;i2++){
			
			for(int i=0;i<s.length();i++){	

				letra=s.charAt(i);
						
				if(Character.isUpperCase(letra)){
			
				a[i2]=letra;
				System.out.printf("%c",a[i2]);
				}
			}
		}

 }
}
