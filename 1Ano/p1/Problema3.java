import java.util.*;
import java.io.*;

public class Problema3{
	static Scanner sc= new Scanner(System.in);
	public static void main (String[] args) throws IOException{
		
		int e=0,n=0;
	
	Robot[] a=new Robot[n];
	
	do{	
		System.out.println();
		System.out.println("Micro-Rato 2013 - Gestao da prova:");
		System.out.println("1 - Adicionar informacao relativa a um robo");
		System.out.println("2 - Imprimir informacao dos robos em prova");
		System.out.println("3 - Vencedor da prova e tempos medios de prova");
		System.out.println("4 - Media do numero de elementos por equipa");
		System.out.println("5 - Mostrar o nome dos robos em maiusculas");
		System.out.println("6 - Alterar informacao de um robo");
		System.out.println("7 - Remover robos da competicao");
		System.out.println("8 - Gravar informacao da prova num ficheiro");
		System.out.println("9 - Terminar o programa");
		System.out.print("Opcao ->"); e=sc.nextInt();
		
		switch (e){
		
		case 1: a=addInfo(a);
				break;
				
		case 2: showInf(a);
				break;
		
		case 3: robWin(a);
				break;
				
		case 6: changeRob(a);
				break;
				
		case 7: rmRob(a);
				break;
		
		case 8: makeFile(a);
				break;
				
		}
		
		
		}while(e!=9);
	
}
	
	public static Robot[] addInfo (Robot[] x){
		
		String name;
		int time,n;
		
		sc.nextLine();
		
		Robot[] y=new Robot[x.length+1];
		
		if(x.length==0){
			
			
			System.out.println("Introduza o nome do robo:");
			name=sc.nextLine();
			System.out.println("Introduza o tempo:");
			time=sc.nextInt();
			System.out.println("Numero de elementos:");
			n=sc.nextInt();
			
			y[0]=new Robot();
			y[0].name=name;
			y[0].time=time;
			y[0].n=n;
				
				}		
		
		else{
					
			for(int i=0;i<=x.length-1;i++){
				
				y[i]=x[i];
				
				}
			
			System.out.println("Nome:");
			name=sc.nextLine();
			System.out.println("Tempo:");
			time=sc.nextInt();
			System.out.println("Numero de elementos:");
			n=sc.nextInt();
			
			y[x.length]=new Robot();
			y[x.length].name=name;
			y[x.length].time=time;
			y[x.length].n=n;
			
		}
			
	/*	for(int i=0;i<=y.length-1;i++){
			
			System.out.print("\n"+y[i].name+y[i].time+" "+y[i].n+"\n");
			
			}*/ //FUNCIONA BEM
		
		
		
		return y;
		}
		
	public static void showInf (Robot[] x){
		
		int h=0,m=0,s=0;
		
		for(int i=0;i<=x.length-1;i++){
		
			if(x[i].time<=59){
				h=0;
				m=0;
				s=x[i].time;				
				
				}
				
			else if(x[i].time>59 && x[i].time<=3599){
				h=0;
				m=(int)x[i].time / 60;
				s=(int)((x[i].time % 60));
				}
			
			else if(x[i].time>3599){
				h=(int) x[i].time/3600;
				m=(int)((x[i].time % 3660)/60);                                           
				s=(int)((x[i].time % 3660));
				}
				
			System.out.print("\n"+x[i].name+"	"+h+":"+m+":"+s+"	"+x[i].n+"\n");
			
			}
		}
		
	
	public static void robWin (Robot[] x){
		
		int min=9999;
		int soma=0;
		double med=0;
		for(int i=0;i<=x.length-1;i++){
			
			if(x[i].time<min) min=x[i].time;
			soma+=x[i].time;
			}
		
		med= soma/x.length;
			
		for(int i=0;i<=x.length-1;i++){
			if(x[i].time==min) 
			System.out.printf("O robot vencedor foi o %s , com um tempo de %5d segundos e de %2d elementos na equipa tecnica. A media dos tempos foi de %4.2f %n%n",x[i].name,x[i].time,x[i].n,med);
			}
		
		}
		
		
	public static Robot[] changeRob (Robot[] x){
		sc.nextLine();
		System.out.println("Qual o robot a mudar?");
		String nome=sc.nextLine();
		
		for(int i=0;i<=x.length-1;i++){
			
			if(x[i].name.equals(nome)){
				x[i]=new Robot();
				System.out.println("Novo nome:");
				x[i].name=sc.nextLine();
				System.out.println("Novo tempo:");
				x[i].time=sc.nextInt();
				System.out.println("Nova equipa");
				x[i].n=sc.nextInt();
				
				}
			
			}
		
		return x;
		}
	
	public static Robot[] rmRob (Robot[] x){
		
		int k=0;
		
		System.out.println("Introduza o valor de tempo a nao ultrapassar:");
		k=sc.nextInt();
		
		for(int i=0;i<=x.length-1;i++){
			
			if(x[i].time>k){
				
				for(int i2=i;i2<=x.length-2;i2++){
					
					x[i]=x[i+1];
					
					}				
				
				x[x.length-1].name= "";
				x[x.length-1].time=0;
				x[x.length-1].n=0;
				
				}
			
			}
		
		return x;
		
		}
		
	
	public static void makeFile (Robot[] x) throws IOException {
			
		System.out.println("Nome do ficheiro a criar:");
		sc.nextLine();
		String nome=sc.nextLine();
		
		File fich= new File(nome);
		
		PrintWriter pw= new PrintWriter(fich);
		
		pw.println("	Nome do Robot	||	Tempo	||	N. E. da equipa	");	
		
		for(int i=0;i<=x.length-1;i++){
			
			pw.println("	"+x[i].name+"		||	"+x[i].time+"	||	  "+x[i].n+"	");
			
			}
			
		pw.close();
		
		}
		
}

class Robot{
	
	String name;
	int time,n;
	
	}

