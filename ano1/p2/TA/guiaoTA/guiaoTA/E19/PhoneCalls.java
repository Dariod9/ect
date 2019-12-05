import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import p2utils.*;

public class PhoneCalls
{
		

	public static void main(String[] args) throws IOException{
		
		String nomeNMS= args[0];
		String nomeCLS= args[1];
		String num= args[2];
		
		
		assert nomeNMS.contains(".nms") && nomeCLS.contains(".cls")  :("Argumentos Inválido!");
			
			File nms= new File(nomeNMS);
			
			Scanner scf= new Scanner(nms);
			
			while(scf.hasNextLine()){
				String as= scf.nextLine();
		
				String[] s=as.split(" ");
				String nome= s[1]+" "+s[2];
				contacts.set(s[0],nome);
				
				}
			scf.close();
			
		
		//REGISTO DE CHAMADAS
		
			File cls = new File(nomeCLS);
			
			Scanner scf2 = new Scanner(cls);
		
			while(scf2.hasNextLine()){
				
				String a= scf2.nextLine();
				
				String[] s2= a.split(" ");
				
				Calls call= new Calls(s2[0],s2[1],s2[2]);
				 
				chamadas.in(call);
					
				}	

			scf2.close();

		//String n1="";
		//	String n2="";
			
			String appears="";
		
			if(appears==num){
				if(contacts.contains(appears)) out.print("\nCalls made by"+contacts.get(appears));
				
				else out.print("\nCalls made by"+appears);
			
				Queue<Calls> temp=chamadas;
			
				for(int i=0; i<temp.size();i++){
					
						if(temp.peek().caller().equals(num)){
							if(contacts.contains(temp.peek().receiver())) out.print("\n- to"+contacts.get(chamadas.peek().receiver())+" "+temp.peek().length());
							else out.print("\n- to phone "+num+" "+temp.peek().length());
							}
						else if(temp.peek().receiver().equals(num)){
							if(contacts.contains(temp.peek().caller())) out.print("\n- to"+contacts.get(temp.peek().caller())+" "+temp.peek().length());
							else out.print("\n- to phone "+num+" "+temp.peek().length());
						}
						
						temp.out();
							
					}
					
				}
				
		}	
	
	static HashTable<String> contacts = new HashTable<String>(200);
	static Queue<Calls> chamadas = new Queue<Calls>();
}

