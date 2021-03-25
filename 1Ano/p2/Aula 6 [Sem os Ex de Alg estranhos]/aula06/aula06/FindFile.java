import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class FindFile {
	
	public static void main (String[] args) {
		
	File f=new File(args[0]);
		
	findFile(f,args[1]);
	
	}
	
	public static void findFile(File c, String a){
			
		//File f=new File(System.getProperty("user.dir"));
		
		File[] b= c.listFiles();
		
		for(int i=0;i<b.length;i++){
			
			if(b[i].getName().contains(a)) out.println(b[i].getName());
			
			if(b[i].isDirectory()) findFile(b[i],a);
			
			}
		
	}
}
