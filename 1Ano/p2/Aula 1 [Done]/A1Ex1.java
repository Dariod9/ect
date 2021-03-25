import java.util.*;


public class A1Ex1 {
	static Scanner sc= new Scanner(System.in);
	public static void main (String[] args) {
	double a,b;
	String operador;
	
	a=sc.nextDouble();
	operador=sc.next();
	b=sc.nextDouble();
	
	if(operador.equals("+")) System.out.println(a+b);
	if(operador.equals("-"))System.out.println(a-b);
	if(operador.equals("x"))System.out.println(a*b);
	if(operador.equals("/"))System.out.println(a/b);
	
	}
}

