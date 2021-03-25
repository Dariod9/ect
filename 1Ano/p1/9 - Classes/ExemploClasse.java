import java.util.*;

public class ExemploClasse {
	static Scanner sc = new Scanner (System.in);
	public static void main (String[] args) {
	
	String x= new String();
		
	Experiment prim, seg;
	prim= new Experiment();
	seg= new Experiment();

	prim.nota1=12.3;
	prim.nota2=8.4;
	seg.nota1=6.1;
	seg.nota2=16.3;
	
	
	System.out.println("Primeiro ou segundo aluno?");
	x=sc.nextLine();
	
	if(x=="prim"){
	System.out.printf("A media do aluno e %4.2f",media(prim.nota1,prim.nota2));
	}
	
	if(x=="seg"){
	System.out.printf("A media do aluno e %4.2f",media(seg.nota1,seg.nota2));
	}
		
	}
	
	
	public static double media (double x , double y){
		
		double a;
		
		a=(x+y)/2;
		
		return a;
		
		}
}

	class Experiment{
		
		double nota1,nota2;
		
		}

