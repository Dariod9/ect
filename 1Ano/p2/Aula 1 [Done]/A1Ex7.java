import java.util.*;
import java.io.*;

public class A1Ex7 {
	static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) throws IOException{
		
		System.out.println("Primeiro nome:");
		String nome1=sc.nextLine();
		System.out.println("Segundo nome:");
		String nome2=sc.nextLine();
		
		copy(nome1,nome2);
		
	}
	
	public static void copy(String a,String b)throws IOException{
		
		int i=0,n=0;
		
		File fich=new File(a);
		
		Scanner scf=new Scanner(fich);
		
		while(scf.hasNextLine()){
			System.out.println(scf.nextLine());
			i++;
			}
		
		scf.close();
		
	
		Scanner scf2=new Scanner(fich);
		
		String[] x=new String[i];
		
		while(scf2.hasNextLine() && n<i) {
		
		x[n]=scf2.nextLine();
		
		n++;
			}
		scf2.close();
		
		for(int i2=0;i2<=x.length-1;i++) System.out.println(x[i]);
		
		
		/*File fich2=new File(b);
		
		PrintWriter pw=new PrintWriter(fich2);
		 
		for(int i2=0;i2<=x.length-1;i2++){
			
			pw.println(x[i2]);
			
			}*/
		
		
		}
}

