import java.util.*;

public class A1Ex2 {
	static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) {
		double PG1,PG2,TP1,EF;
		double notaF;
		
		System.out.print("PG1:");
		PG1=sc.nextDouble();
		System.out.print("\nPG2:");
		PG2=sc.nextDouble();
		System.out.print("\nTP1:");
		TP1=sc.nextDouble();
		System.out.print("\nEF:");
		EF=sc.nextDouble();
		
		System.out.printf("\nPG1->%4.2f  PG2->%4.2f  TP1->%4.2f  EF->%4.2f\n",PG1,PG2,TP1,EF);
		
		notaF=0.15*PG1+0.15*PG2+0.2*TP1+0.5*EF;
		
		System.out.println("Nota Final -> "+notaF);
		
		
	}
}

