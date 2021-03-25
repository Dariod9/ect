import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;

public class SortInts
{
  public static void main(String[] args) throws IOException {
	  
	SortedListInt lst= new SortedListInt();
	
	for(int i=0;i<args.length;i++){
	  
	  File f=new File(args[i]);
	  
	  Scanner scf=new Scanner(f);
	  	  
	  while(scf.hasNextInt()){
		  lst.insert(scf.nextInt());
		  }
	
	  scf.close();
		}
		
		print(lst);
			
	}
	
  public static void print(SortedListInt a){
	  print(a.first,a);
	  }
	public static void print(NodeInt n, SortedListInt a){
		out.println(n.elem);
		if(n.next!=null) print(n.next,a);
		}
}


