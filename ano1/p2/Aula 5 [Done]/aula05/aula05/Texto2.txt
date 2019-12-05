import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class CopyFile {
	
	public static void main (String[] args)  {
		int n=0,i=0;
		
		try{
		File f1=new File(args[0]);
		File f2=new File(args[1]);
		copiar(f1,f2);		
		
		}catch(FileNotFoundException a){
			out.println("Invalid or non-existing file");
			a.printStackTrace();
				}
			
		}
		
	public static void copiar(File a, File b) throws FileNotFoundException{
		int n=0,i=0;		
		
		Scanner scf=new Scanner(a);
			
		while(scf.hasNextLine()){
			out.println(scf.nextLine());
			n++;			
			
			}
		scf.close();
		
		Scanner scf2=new Scanner(a);
		
		String[] s= new String[n];
		
		while(scf2.hasNextLine() && i<n){		//A funcionar bem
			s[i]=scf2.nextLine();
			i++;
			}			
		
		PrintWriter p=new PrintWriter(b);
		
		for(int i2=0;i2<s.length;i2++){
			p.println(s[i2]);
			}
			
		p.close();
		
	}	
}
