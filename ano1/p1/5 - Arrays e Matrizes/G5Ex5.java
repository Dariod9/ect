import java.util.*;

public class G5Ex5 {
	
	static int num;
	static Scanner sc= new Scanner (System.in);
	public static void main (String[] args) {
	
		int x,soma=0;
		double media=0,dP=0,desPad=0;
	
		Validar();
		
		int[] Turma = new int[num];
		double[] Desvio= new double[num];
		
		for(int i=0;i<=Turma.length-1;i++){
			
			System.out.println("Nota:");
			x = sc.nextInt();
			
			Turma[i]=x;
			
			soma+= x;
			
			}
	
			media=soma/num;
			
		for(int i=0;i<=Desvio.length-1;i++){
			
			if(Turma[i]<media){
				
				Desvio[i]= media-Turma[i];
				
				}
			
			if(Turma[i]>media){
				
				Desvio[i]=Turma[i]-media;
				
				}
			
			}
	
	
		for(int i=0;i<=Desvio.length-1;i++){
			
			dP += Desvio[i]/num;
			
			}
		
		
		System.out.printf("A media das notas e de %4.2f valores", media);
		System.out.printf("O Desvio Padrao do conjunto e de %4.2f valores", dP);
		
	}
	
	
	
	
	public static int Validar (){
		
		do{
		
		System.out.println("Introduzir numero de notas");
		num = sc.nextInt();
		
		if(num<0 || num>30){System.out.println("Numero de notas invalido\n");}
		
		}while(num<0||num>30);
	
		return num;
		
	}
}
