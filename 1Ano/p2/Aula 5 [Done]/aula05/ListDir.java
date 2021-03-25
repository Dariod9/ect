import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class ListDir {
	static Scanner sc=new Scanner(System.in);
	public static void main (String[] args){
		
		
		try{
				File f=new File(args[0]); //args[0]
				if(args[0]==""){
				
					File g=new File("aula05");
					list(g);
					
					}
					
				else{
					
					
					list(f);
						}
					}
			catch(IOException a){
				//Não se poe nada porque não vai fazer nada, é só para cobrir o IOE
				}	
			catch(NullPointerException b){
				out.println("Nome invalido!");
				
				}				
		}
			
	
	public static void list (File a) throws IOException{
		
		File[] b;
		
		b=a.listFiles();
		
		for(int i=0;i<b.length;i++){
			verify(b[i]);
			
			out.printf(" "+b[i].getPath()+"\n"); 
			
			}
		
		
		}
		
		
	public static void verify (File a) throws IOException{
		
		boolean file=false,r=false,w=false;
		
		if(a.isFile()){
			 out.print("F");
			 }
		else if(!a.isFile()) out.print("D");
		if(a.canRead()) r=true; out.print("R");
		if(a.canWrite()) w=true; out.print("W");
		
		
		
		
		}
	
}

