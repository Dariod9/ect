package aula1;

import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;

public class Ex1_3{
		static Scanner sc=new Scanner(System.in);
	public static void main (String[] args){
	
		int e=-1;
		
		ArrayList<Circulo> listaC= new ArrayList<Circulo>();
		ArrayList<Retangulo> listaR= new ArrayList<Retangulo>();
		ArrayList<Quadrado> listaQ= new ArrayList<Quadrado>();
		
		do {
			
			System.out.print("Insira a sua opcao:\n"
					+ "1 - Introduzir Circulo\n"
					+ "2 - Introduzir Retangulo\n"
					+ "3 - Introduzir Quadrado\n"
					+ "4 - Verificar interseção de círculos\n"
					+ "0 - Sair e apresentar dados");
			
		e=sc.nextInt();
		
		if(e==1) {
			
			System.out.println("Coordenada X:");
			double x1=sc.nextDouble();
			
			
			System.out.println("Coordenada Y:");
			double y1= sc.nextDouble();
			
				
			System.out.println("Raio:");
			double r=sc.nextDouble();
			
			while(r<1 || r>31) {
				System.out.println("Raio inválido");
				r=sc.nextDouble();
				}
				
			
			Circulo c= new Circulo(x1,y1,r);
		
			listaC.add(c);
			
			}
			
		else if(e==2) {
			
			
			System.out.println("BottomLeft X:");
			double x1=sc.nextDouble();
			
			
			System.out.println("BottomLeft Y:");
			double y1= sc.nextDouble();
			
			
			System.out.println("TopRight X:");
			double x2=sc.nextDouble();
			
			
			System.out.println("TopRight Y:");
			double y2= sc.nextDouble();
	
			double comp=x2-x1;
			
			double larg=y2-y1;
			
			while(larg<1) {
				System.out.println("Largura invalido");
				larg=sc.nextDouble();
			}
				
			
			Ponto bL=new Ponto(x1,y1);
			Ponto tR=new Ponto(x2,y2);
			
			Retangulo r= new Retangulo(bL,tR,comp,larg);
		
			listaR.add(r);
			}
		
		
		
		else if(e==3) {
			
			
			System.out.println("BottomLeft X:");
			double x1=sc.nextDouble();
			
			
			System.out.println("BottomLeft Y:");
			double y1= sc.nextDouble();
			
			
			System.out.println("Lado:");
			double lado= sc.nextDouble();
			
			while(lado<1) {
				System.out.println("Comprimento inválido");
				lado=sc.nextDouble();
				}				
			
			Ponto p=new Ponto(x1,y1);
			
			Quadrado q= new Quadrado(p,lado);
		
			listaQ.add(q);
			}
		
		
		else if(e==4) {
			assert !listaC.isEmpty();
			
			
			System.out.println("Introduzir Index de Circulos a verificar);"
					+ "Circulo 1:");
			int c1=sc.nextInt();
			System.out.println("Circulo 2:");
			int c2=sc.nextInt();
			
			boolean intcp=false;
			
			double subDisty=((listaC.get(c2).centro().y())-listaC.get(c1).centro().y())*((listaC.get(c2).centro().y())-listaC.get(c1).centro().y());
			double subDistx=((listaC.get(c2).centro().x())-listaC.get(c1).centro().x())*((listaC.get(c2).centro().x())-listaC.get(c1).centro().x());
			
			double dist=Math.sqrt(subDisty+subDistx);
			
			if(dist<listaC.get(c1).raio() || dist<listaC.get(c2).raio()) intcp=true;
			
		if(intcp) System.out.println("Os circulos intersetam-se");
		else System.out.println("Os circulos não se intersetam");
			
		}
		
		
		}while(e!=0);
	
		
		for(int i=0;i<listaC.size();i++) {
			
		System.out.printf("\n"+listaC.get(i).toString());
			
		}
	
		
		for(int i=0;i<listaR.size();i++) {
			
			System.out.printf("\n"+listaR.get(i).toString());
				
			}
		
		for(int i=0;i<listaQ.size();i++) {
			
			System.out.printf("\n"+listaQ.get(i).toString());
				
			}
	}







}