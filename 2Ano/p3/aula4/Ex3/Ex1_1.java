package aula4.Ex3;

import java.util.Scanner;

public class Ex1_1{
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {

		ListaCliente Clientes= new ListaCliente();
		ListaVideo	Videos= new ListaVideo();
		
		int e=-1;
		
		do {
			
			System.out.printf("Introduza a opção:"
					+ "\n1 - Introduzir utilizador"
					+ "\n2 - Remover utilizador"
					+ "\n3 - Listar videos disponiveis"
					+ "\n4 - Introduzir filme"
					+ "\n5 - Verificar disponibilidade"
					+ "\n6 - Check-In / Check-Out"
					+ "\n7 - Lista de socios por vídeo"
					+ "\n8 - Sair\n");

			e=sc.nextInt();
	
		if(e==1) {
			System.out.print("\nEstudante(1) ou Funcionário(2)?");
			int x=sc.nextInt();
			
				System.out.print("\nNome:");
				String e1=sc.next();
				
				System.out.print("\nCC:");
				int cc=sc.nextInt();
				
				sc.nextLine();
				System.out.print("\nData de Nascimento:");
				String e2=sc.nextLine();
			
			if(x==1) {
				
				System.out.print("\nMec:");
				int mec=sc.nextInt();
				
				System.out.print("\nCurso:");
				String e3=sc.next();
				
				Estudante p1= new Estudante(e1,cc,e2,mec,e3);
				
				Clientes.add(p1);
				
			}
			
			else if(x==2) {
				
				System.out.println("Numero de Funcionario:");
				int nFunc=sc.nextInt();
				
				System.out.println("Numero Fiscal:");
				int fisc=sc.nextInt();
				
				Funcionario p2= new Funcionario(e1,cc,e2,nFunc,fisc);
				Clientes.add(p2);
			}
		}
		
		else if(e==2) {
			System.out.println("Introduza o nome do utilziador a retirar:");
			String uti=sc.next();

			for(int i=0;i<Clientes.size();i++) {
				
				Pessoa temp= Clientes.get(i);
				
				if(temp.nome().equalsIgnoreCase(uti)) Clientes.remove(temp);
				
			}
		}
			
		
		else if(e==3) {
				
				for(int i=0; i<Videos.size(); i++) {
					
					System.out.println(Videos.get(i).nome());
					
				}
			}
			
		
		else if(e==4) {
				
			System.out.println("Nome:");
			String v1=sc.next();
			
			System.out.println("Categoria:");
			String v2=sc.next();
			
			System.out.println("Idade:");
			String v3=sc.next();
			
			System.out.println("Stock Inicial:");
			int s=sc.nextInt();
					
			Videos.add(new Video(v1,v2,v3,s));
				
			}
		
		else if(e==5) {
			
			System.out.println("Introduza nome do filme:");
			String filmeCheck=sc.next();
			
			boolean exists=true;
			
			for(int i=0;i<Videos.size();i++) {
				if(Videos.get(i).nome().equalsIgnoreCase(filmeCheck)) {
					if(Videos.get(i).stock()<1) exists=false;
				}
			}
			
			if(exists) System.out.println("O filme está disponível");
			else System.out.println("O filme não está disponível");
			
		}
		
		else if(e==6) {
			
			System.out.println("Nome da pessoa:");
			String checker= sc.next();
			
			System.out.println("Nome do filme:");
			String filmeC=sc.next();
			
			System.out.println("Check-In(1) ou Check-Out(2)?");
			int check=sc.nextInt();
			
			if(check==1) {
				
				int indexC=0,indexV=0;
				
				for(int i=0;i<Clientes.size();i++) {
					if(Clientes.get(i).nome().equalsIgnoreCase(checker))  indexC=i; 
					}
				
				for(int i=0;i<Videos.size();i++) {
					if(Videos.get(i).nome().equalsIgnoreCase(filmeC)) indexV=i;
				}
				
				
				Clientes.get(indexC).checkIn(Videos.get(indexV));
				Videos.add(Videos.get(indexV));
			}
			
			
			else if(check==2) {
				
				
				int indexC2=0,indexV2=0;
				
				for(int i=0;i<Clientes.size();i++) {
					if(Clientes.get(i).nome().equalsIgnoreCase(checker))  indexC2=i; 
					}
				
				for(int i=0;i<Videos.size();i++) {
					if(Videos.get(i).nome().equalsIgnoreCase(filmeC)) indexV2=i;
				}
				
				
				Clientes.get(indexC2).checkOut(Videos.get(indexV2));
				Videos.add(Videos.get(indexV2));
				
				
				}
			
		else if(e==7) {
			
			System.out.println("Introduzir nome do vídeo");
			String s0=sc.next();
			int temp=0;
			
			for(int i=0;i<Videos.size();i++) {
				if(Videos.get(i).nome().equalsIgnoreCase(s0)) temp=i; 
			}
				
			for(int i=0;i<Videos.get(temp).utilizadores.size();i++) {
				System.out.print("\nSócio "+Videos.get(temp).utilizadores.get(i));
			}
			
		}
			
		}
			
		}while(e!=8);
		
		}
}