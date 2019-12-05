import java.util.*;
import java.io.*;


public class Teste2 {
	static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) throws IOException {
		
		 Pais[] paises;
		
		 paises = lerFichHum("teste.txt");
		
		procurarListar(paises," ");  // espaço lista tudo        
		
		procurarListar(paises,"56"); // lista paises onde apareca "56"
		
		 int [] mins = humMin(paises);
		 
		for(int i=0; i<mins.length; i++) 
					System.out.printf("Minimo = %5d %3d %s%n", paises[mins[i]].dia,
					paises[mins[i]].humidade, paises[mins[i]].nome);
		
		
		int[] freq = freqHum(paises);
		
		printFreq(freq);
		System.out.println("");
		System.out.println(diaPaisExiste(paises,paises.length,24,"Marrocos"));
		
		//paises=removerRepetidos(paises);
		
		//bubbleSort(paises);*/
		
		gravarPais(paises, "PaisesHumidOrd.txt"); 
		
	}
	
	
public static Pais[] lerFichHum(String x) throws IOException{
	
	File fich=new File(x);
	
	Scanner scf=new Scanner(fich);
	
	int n=scf.nextInt();
	int i=0;
	Pais[] a=new Pais[n];
	
	while(scf.hasNextInt() && i<n){
		a[i]=new Pais();
		a[i].dia=scf.nextInt();
		a[i].humidade=scf.nextInt();
		a[i].nome=scf.nextLine();
		i++;
		
		
		}
	
	return a;
	}
	

public static void procurarListar (Pais[] x, String k){
	
		System.out.println("\nDia     Humidade     Pais");

	for(int i=0;i<=x.length-1;i++){
		String s=x[i].dia+" "+x[i].humidade+" "+x[i].nome;
		if(s.contains(k)) 
			System.out.println(s);
		}
	}
public static int[] humMin(Pais[] x){
	int minH=101,cont=0;
	
		for(int i=0;i<=x.length-1;i++){
			if(x[i].humidade<minH) minH=x[i].humidade;
			}
			
		for(int i=0;i<=x.length-1;i++){
			if(x[i].humidade==minH) cont++;
			}
	
	int[] b= new int[cont];
	
		for(int i=0;i<=b.length-1;i++){
			if(x[i].humidade==minH) b[i]=i;				
			}
	return b;
	}


public static void gravarPais(Pais[] x,String nome) throws IOException{
	
	File fich=new File(nome);
	PrintWriter pw=new PrintWriter(fich);
	
	pw.println(x.length);
	for(int i=0;i<x.length-1;i++){
		pw.println("");
		pw.printf("%5d  %2d  %2s",x[i].dia,x[i].humidade,x[i].nome);
		}
		
	pw.close();
	
	}	

public static int[] freqHum(Pais[] x){
	
	int[] f=new int[101];
		for(int i=0;i<=x.length-1;i++){
			if(x[i].humidade>=10 && x[i].humidade<=100){
				f[x[i].humidade]++;
				}
			}
			
		return f;
	}
		
public static void printFreq (int[] x){
	System.out.println("");
	System.out.println("Hum.  Freq.");
	for(int i=0;i<=x.length-1;i++){
		
		if(x[i]!=0){
			
			System.out.printf("\n%3d  %2d",i,x[i]);
			}
		
		}
	
	}
	
public static boolean diaPaisExiste(Pais[] x, int comp, int dia, String nome) {
	
	boolean exist=false;

	for(int i=0;i<=comp-1;i++){
		
		String s=x[i].dia+" "+x[i].humidade+" "+x[i].nome;
		String a=" "+dia;
		
		if(s.contains(a) || s.contains(nome)){
			 exist=true;
			break;
			}		
		}

		return exist;
	}
	

		
}

class Pais{
	int dia,humidade;
	String nome;
	}

