package aula1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex1_2{
	static Scanner sc= new Scanner(System.in);
	public static void main (String[] args) {

	ArrayList<Pessoa> lista=new ArrayList<Pessoa>();
		
	int e=-1;
	
	do {
	
		System.out.print("Insira a sua opcao:\n"
				+ "1 - Introduzir pessoa\n"
				+ "2 - Apagar pessoas\n"
				+ "3 - Imprimir lista\n"
				+ "4 - Imprimir Lista ordenada por CC\n"
				+ "0 - Sair");
		
	e=sc.nextInt();
	
	if(e==1) {
		
		System.out.println("Introduza os dados da pessoa");
		sc.nextLine();
		
		System.out.println("Nome:");
		String nome=sc.nextLine();
		
		System.out.println("CC:");
		int cc= sc.nextInt();
		
			
		System.out.println("Data (Dia):");
		int dia=sc.nextInt();
		
		while(dia<1 || dia>31) {
			System.out.println("Dia Invalido");
			dia=sc.nextInt();
			}
		System.out.println("Mês");
		int mes=sc.nextInt();
		
		while(mes<1 || mes>31) {
			System.out.println("Mes Invalido");
			mes=sc.nextInt();
		}
			
		System.out.println("Ano");
		int ano=sc.nextInt();
		
		Data data= new Data(dia,mes,ano);
				
		Pessoa p= new Pessoa(nome,cc,data);
		lista.add(p);
		
		}
		
	else if(e==2) {
		
		
		System.out.println("Introduza o nome da pessoa a apagar:");
		sc.nextLine();
		String nomeOut= sc.nextLine();
		
		for(int i=0;i<lista.size();i++) {
			
			Pessoa temp=lista.get(i);
			
			if(temp.nome().equalsIgnoreCase(nomeOut)) lista.remove(i);
			
			
		}
	}
	
	
	else if(e==3) {
		
		System.out.println("   Nome   ||    CC    ||    Data de Nasc.    ");
		
		for(int i=0;i<lista.size();i++) {
			
			System.out.print(lista.get(i).nome()+"       "+lista.get(i).cc()+"        "+lista.get(i).dataNasc().dia()+" do "+lista.get(i).dataNasc().mes()+" de "+lista.get(i).dataNasc().ano()+"\n");
			System.out.println();
		}
		
	}
	
	else if(e==4) {
		
		Pessoa[] arr= new Pessoa[lista.size()];
		for(int i=0; i<lista.size();i++) {
			arr[i]=lista.get(i);
		}
		
		Arrays.sort(arr, new ordenaCC());
		
		 System.out.println("Lista ordenada por CC"); 
		 System.out.println("");
		 System.out.println("   Nome   ||    CC    ||    Data de Nasc.    ");
			
		 for(int i=0;i<arr.length;i++) {
				
				System.out.print(arr[i].nome()+"       "+arr[i].cc()+"        "+arr[i].dataNasc().dia()+" do "+arr[i].dataNasc().mes()+" de "+arr[i].dataNasc().ano()+"\n");
				System.out.println();
		
		 }
	
	}
	
	}while(e!=0);
	
}

	
public static ArrayList<Pessoa> bubbleSortCC(ArrayList<Pessoa> lista) {
	boolean trocas;
	for (int i=lista.size()-2;i>0;i--) {
		trocas=false;
		for(int j=0;j<i;j++) {
			if(lista.get(j).cc()>lista.get(j+1).cc()){
				Pessoa aux = lista.get(j);
				lista.set(j, lista.get(j+1));
				lista.set(j+1, aux);
				trocas=true;
				
			}
		}
	if(!trocas) break;
	}
	
	return lista;
}
	
}