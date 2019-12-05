import java.util.*;
import java.io.*;


public class Problema4 {
		static Scanner sc=new Scanner(System.in);
	public static void main (String[] args) throws IOException{
	
	int e=0,n=0;
	Aluno[] x=new Aluno[n];
	do{
		System.out.printf("\n\nServicos Academicos - Gestao de uma pauta:");
		System.out.println("1 - Ler ficheiro com números mec. e pedir informação de notas");
		System.out.println("2 - Imprimir no terminal a informação da disciplina");
		System.out.println("3 - Calcular estatísticas das notas finai");
		System.out.println("4 - Alterar as notas de um aluno ");
		System.out.println("5 - Imprimir um histograma de notas");
		System.out.println("6 - Gravar num ficheiro a informação da disciplina (ordenada)");
		System.out.println("7- Terminar o programa");
		System.out.print("Opcao->"); e=sc.nextInt();
	
	switch(e){
		
		case 1:	x=input();
				break;
				
		case 2: show(x);
				break;
		
		case 3: stats(x);
				break;
			
		case 4: change(x);
				break;
			
		case 6: print(x);
				break;
			}	
		}while(e!=7);
	
	}
	
public static Aluno[] input () throws IOException {
	
	int n=0,i=0,n1=0,nR=0,nF;
	String nome;
	
	sc.nextLine();
	System.out.println("Nome do ficheiro:");
	nome=sc.nextLine();
	
	File fich= new File(nome);
	
	Scanner scf= new Scanner(fich);
	
	while(scf.hasNextLine()){
		System.out.println(scf.nextLine());
		n++;	
		}
	scf.close();
	
	Aluno[] a=new Aluno[n];
	
	
	Scanner scf2=new Scanner(fich);
	
		while(scf2.hasNextLine() && i<n){
			a[i]=new Aluno();
			a[i].mec=scf2.nextInt();
			i++;			
			
			}
			
	scf2.close();
	
		for(int i2=0;i2<n;i2++){
			System.out.println("Introduza as notas de Exame e Recurso");
			a[i2].n1=validate(a[i2].n1);
			a[i2].nR=validate(a[i2].nR);
			a[i2].nF=(a[i2].n1+a[i2].nR)/2;
			}
			
	PrintWriter pw=new PrintWriter(fich);
			pw.println("-------------------------------------------------");
		for(int i2=0;i2<n;i2++){
			
			pw.println(a[i2].mec+"	||	"+a[i2].n1+"	||	"+a[i2].nR+"	||	"+a[i2].nF);
			
			}
	pw.close();
	
	return a;
	
	}
	
	
public static void show (Aluno [] x) {
	
	System.out.println("-------------------------------------------------");
	for(int i=0;i<=x.length-1;i++){
		
		System.out.println(x[i].mec+"	||	"+x[i].n1+"	||	"+x[i].nR+"	||	"+x[i].nF);
		
		}
	
	}
	
public static void stats (Aluno[] x){
	
	int soma=0,nMax=0,nNeg=0,nPos=0;
	double media=0;
	
	for(int i=0;i<=x.length-1;i++){
		
		soma+=x[i].nF;
		if(x[i].nF>nMax) nMax=x[i].nF;
		if(x[i].nF>9) nPos++;
		if(x[i].nF<10) nNeg++;
		
		}
	
	media=soma/x.length;
	
	System.out.printf("\nNota media Final: %4.2f",media);
	for(int i=0;i<=x.length-1;i++){
		if(x[i].nF==nMax) System.out.println("\nMelhor aluno: Mec "+x[i].mec+"   Nota Final "+x[i].nF);
		}
	System.out.printf("\nO numero de negativas foi %2d e de positivas foi de %2d",nNeg,nPos);
	
	}	
	
public static Aluno[] change(Aluno[] x){
	
	int t;
	System.out.println("Aluno a alterar:");
	t=sc.nextInt();
	
	for(int i=0;i<=x.length-1;i++){
		
		if(t==x[i].mec){
			System.out.println("Nova nota normal:");
			x[i].n1=sc.nextInt();
			System.out.println("Nova nota de recurso:");
			x[i].nR=sc.nextInt();
			
			x[i].nF=(x[i].n1+x[i].nR)/2;
					
			}
		}	
	return x;
	}
	
	
public static void print (Aluno[] x) throws IOException{
	
	int temp=0;
	
	for(int i=0;i<=x.length-1;i++){
	
		if(i==x.length-1) break;
	
		if(x[i].nF<x[i+1].nF){
			
			temp=x[i].nF;
			x[i].nF=x[i+1].nF;
			x[i+1].nF=temp;
						
		}
	}
	
	sc.nextLine();
	System.out.println("Novo ficheiro:");
	String nome=sc.nextLine();
	
	File fich=new File(nome);
	PrintWriter pw= new PrintWriter(fich);
		pw.println("-------------------------------------------------");
		for(int i2=0;i2<x.length-1;i2++){
			if(x[i2].nF>=10){
			pw.println(x[i2].mec+"	||	"+x[i2].n1+"	||	"+x[i2].nR+"	||	"+x[i2].nF);
			}
			}
	pw.close();
}
	
	

public static int validate (int x){
	
	do{

	x=sc.nextInt();
	if(x>=0 && x<=20) break;
	System.out.println("Nota invalida");
		}while(x<0||x>20);
		
		return x;
	}
	
}

class Aluno{
	
	int mec;
	int n1,nR,nF;
	}

