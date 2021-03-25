import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import p2utils.KeyValueList;
//import p2utils.KeyValueNode;

public class CheckPassword {
	static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) throws IOException {
		
		File f=new File(args[0]);
		
		Scanner scf= new Scanner(f);
		
		KeyValueList<String> E= new KeyValueList<>();
		
		boolean trig=true;
		
		
		
		while(scf.hasNext()){
			
				String user= scf.next();
				String pass= scf.next();
					
			input(E,user,pass);
			
		}

		try{
		while(trig=true){
			
			out.print("Username ->");
			String a=sc.nextLine();
			if(E.contains(a)) out.printf("Password -->"+E.get(a)+"\n");
			
			
			
			}
	
	}
	catch(Throwable e){
		out.println("\n Programa terminado com sucesso!");
		}
	
	
}
	
	public static void input(KeyValueList<String> E,String user, String pass){
		int a=E.size();
		E.set(user,pass);
		
		/*if(E.size()>a){
			out.printf("\n Utilizador --> %s \n Password --> %s",user,pass);
			}*/
	
		}
	
	/*public static void print(KeyValueList<String> E){
		
		print(E,first);
		
		}
		
		public static void print(KeyValueList<String> E, Node<String> n){
			
			}
	*/
}

