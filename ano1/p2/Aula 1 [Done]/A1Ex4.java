import java.util.*;


public class A1Ex4 {
	static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) {
		String f;
		
		System.out.println("Frase ->");
		f=sc.nextLine();
		
		f=f.replace('L','U');
		f=f.replace('l','u');
		f=f.replace("R","");
		f=f.replace("r","");
	
	System.out.println(f);
	
	}
}

