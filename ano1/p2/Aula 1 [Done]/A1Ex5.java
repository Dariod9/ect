import java.util.*;

public class A1Ex5 {
	static Scanner sc=new Scanner (System.in);
	public static void main (String[] args) {
		int cont=0;
		double x;
		
		double[] a=new double[99];
		for(int i=0;i<=99;i++){
			x=sc.nextDouble();
			if(x==0) break;

			a[i]=x;
			
			cont++;
			
			}
			
		double[] b= new double[cont];
		
		for(int i=0;i<=b.length-1;i++){
			b[i]=a[i];			
			}
		
		
		double soma=0,media=0;
		
		for(int i=0;i<=b.length-1;i++){
			soma+=b[i];
			}
		
		media=soma/b.length;
		
		System.out.println("Soma -> "+soma+"  Media -> "+media);
		
	}
}

