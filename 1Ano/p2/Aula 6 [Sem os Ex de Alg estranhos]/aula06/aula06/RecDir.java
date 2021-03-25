import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class RecDir {
	
	public static void main (String[] args) {
	
	File a=new File(args[0]);
	
	listDir(a);
	
	}
	
	public static void listDir(File a){
		
		out.println(a.getPath());
		if(a.isDirectory() && a.canRead()){
		File[] b=a.listFiles();
			
		for(int i=0;i<b.length;i++){
			
			
			listDir(b[i]);
			
			}
		}
	}
		
}
