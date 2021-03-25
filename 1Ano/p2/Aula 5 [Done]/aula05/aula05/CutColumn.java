import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class CutColumn {
	
	public static void main (String[] args) throws IOException {
		
		int n=0,i=0;
		
		File f= new File(args[0]);
		
		Scanner scf=new Scanner(f);
		
		while(scf.hasNextLine()){
			
			out.println(scf.nextLine());
			n++;
			}
		
		scf.close();
		
		Scanner scf2=new Scanner(f);
		
		String[] a=new String[n];
		
		while(scf2.hasNextLine() && i<n){
			a[i]=scf2.nextLine();
			i++;
			}
			
		scf2.close();
		
		
		
		for(int i2=0;i2<a.length;i2++){
		
			String[] b=a[i2].split(" ");
			int o= Integer.parseInt(args[1]);
			if(b.length>=o){
				if(b[o-1]!=null){
				
				out.print(b[o-1]+"\n");
				
				} 
			}
		}
		
		
	}
}

