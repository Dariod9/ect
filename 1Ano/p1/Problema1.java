import java.util.*;
import java.io.*;


public class Problema1 {
	static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) throws IOException {
		
	int e=0;

	do{	
		System.out.println("\n\nEstacao meteorologica:");
		System.out.println("1-Ler ficheiro de dados");
		System.out.println("2-Acrescentar medida");
		System.out.println("3-Listar valores de temperatura e humidade");
		System.out.println("4-Listar medidas ordenadas por valor de temperatura");
		System.out.println("5-Listar medidas ordenadas por valor de humidade");
		System.out.println("6-Calcular valores medio de temperatura e humidade");
		System.out.println("7-Calcular max e min de temperatura e humidade");
		System.out.println("8-Calcular histograma das temperaturas e humidade");
		System.out.println("9-Terminar o programa");
		System.out.print("\n Opcao->"); e=sc.nextInt();

		switch(e){
			
			case 1:	lerFile();
					break;
			
			case 2:addMed("teste.txt");
					break;
					
			case 3: list(lerFile());
					break;

			case 4: listTemp(lerFile());
					break;
			
			case 5: listHumid(lerFile());
					break;
			
			case 6: calcMed(lerFile());
					break;
			
			case 7: calcExt(lerFile());

			case 8:

			}	

		}while(e!=9);		
	}


public static Dia[] lerFile()throws IOException{
	
	int i=0,n=0;
	
	sc.nextLine();
	
	System.out.println("Introduza o nome do ficheiro a ler:");
	
	String nome = sc.nextLine();
	
	File fich = new File(nome);
	
	Scanner scf = new Scanner(fich);
		
		while(scf.hasNextLine()){
			
			
		System.out.println(scf.nextLine());	
		i++;
			
		}
		scf.close();

			Scanner scf2= new Scanner (fich);
			
			Dia[] a=new Dia[i];
						
			while(scf2.hasNextLine() && n<i){
				
			a[n]=new Dia();
			a[n].tmp=scf2.nextInt();
			a[n].hum=scf2.nextInt();
			n++;
															
				}
		
			scf2.close();

			//	O ARRAY FUNCIONA BEM
	
	return a;
	
	}

public static Dia[] addMed(String y) throws IOException{ //INACABADO MAS I GOT THE IDEA

		int i=0,n=0;
		int n1,n2;
		File x= new File(y);
		 
		Scanner scf= new Scanner(x);
		
		while(scf.hasNextLine()){
		
			System.out.println("\n" + scf.nextLine());
			i++;
			}
		PrintWriter pw= new PrintWriter(x);
		
		System.out.println("Introduza 2 valores:");
		n1=sc.nextInt();
		n2=sc.nextInt();	
	
		pw.println(n1+"	"+n2);
	
		pw.close();
		scf.close();
	
	
			Scanner scf2=new Scanner(x);
			
			Dia[]b=new Dia[i+1];
			
			while(scf2.hasNextLine() && n<i+1){
				
			b[n]=new Dia();
			if(scf2.hasNextInt()) b[n].tmp=scf2.nextInt();
			if(scf2.hasNextInt()) b[n].hum=scf2.nextInt();
			n++;
															
				}
		
			scf2.close();
	
	
		/*	for(int i2=0;i2<=i;i2++){
				
				System.out.println(b[i2].tmp+" "+b[i2].hum);
				
				}*/
	
		return b;
	
		}
		
		
	public static void list (Dia[] x){
		
		System.out.println();
		System.out.println("	Temperaturas ||  Humidades");
		for(int i=0;i<=x.length-1;i++){
			
			System.out.println("Dia "+(i+1)+"      "+x[i].tmp+"      ||     "+x[i].hum+"      ");
			
			}		
		}
		
	public static void listTemp (Dia[]x){
		
		int[] h=new int[x.length];
		int help=0;
		
		for(int i=0;i<=h.length-1;i++){
			
			h[i]=x[i].tmp;
			
			}
		System.out.println();
		System.out.println("Lista ordenada de temperatura");
		for(int i=0;i<=h.length-1;i++){
			
			if(i==h.length-1) break;
			
			if(h[i]>h[i+1]){
				
				help=h[i];
				h[i]=h[i+1];
				h[i+1]=help;
				}
				
			
			}
		
		for(int i=0;i<=h.length-1;i++){
			
			System.out.println(h[i]);
			
			}
		
		}
	
	
	public static void listHumid (Dia[] x){
		
		int[] h=new int[x.length];
		int help=0;
		
		for(int i=0;i<=h.length-1;i++){
			
			h[i]=x[i].hum;
			
			}
		System.out.println();
		System.out.println("Lista ordenada de humidades");
		for(int i=0;i<=h.length-1;i++){
			
			if(i==h.length-1) break;
			
			if(h[i]>h[i+1]){
				
				help=h[i];
				h[i]=h[i+1];
				h[i+1]=help;
				}
				
			}
		
		for(int i=0;i<=h.length-1;i++){
			
			System.out.println(h[i]);
			
			}
		
		}
		
		
	public static void calcMed (Dia[] x){
		
		int somaT=0, somaH=0;
		double medT,medH;
		
		for(int i=0;i<=x.length-1;i++){
			
			somaT+= x[i].tmp;
			somaH+= x[i].hum;
			
			}
		
		medT=somaT/x.length;
		medH=somaH/x.length;
		
		System.out.printf("As medias (T e H) sao, respetivamente, %4.2f e %4.2f",medT,medH);
		
		}
		
	public static void calcExt (Dia[] x){
		
		int tMax=0,tMin=50,hMax=0,hMin=101;
		
		for(int i=0;i<=x.length-1;i++){
			
			if(x[i].tmp>tMax) tMax=x[i].tmp;
			if(x[i].tmp<tMin) tMin=x[i].tmp;
			if(x[i].hum>hMax) hMax=x[i].hum;
			if(x[i].hum<hMin) hMin=x[i].hum;
			
			}
		
		System.out.printf("Temp e Hum maximos e minimos: %2d<->%2d e %2d<->%2d",tMax,tMin,hMax,hMin);
		
		}
			
	}

class Dia{
	
	int tmp,hum;
	
		/*Dia(int temp, int hmd){
			temp=tmp;
			hmd=hum;
				}*/
		}
