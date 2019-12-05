package aula6.Ex1;

import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;
public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static Ementa ementa = new Ementa("Especial Caloiro", "Snack da UA");
	private static LinkedList<Prato> pratos = new LinkedList<Prato>();
	
	public static void main(String[] args) throws IOException {
		int escolha;
		do{ 
			System.out.println("\n1- Criar Prato");
			System.out.println("2- Apagar Prato");
			System.out.println("3- Adicionar Ingrediente");
			System.out.println("4- Adicionar Prato");
			System.out.println("5- Imprimir Ementa");
			System.out.println("6- Guardar em Ficheiro");
			System.out.println("0- Sair");
			System.out.println("Introduza o numero do que quer fazer->");
			escolha = sc.nextInt();
			sc.nextLine();
			switch(escolha){ 
				case 1:										
					criarPrato();					
				break;											
				case 2:										
					apagarPrato();
				break;
				case 3:										
					adicionarIngrediente();
				break;
				case 4:										
					adicionarPrato();
				break;
				case 5:										
					System.out.println("\n" + ementa);
				break;
				case 6:
					saveInFile();
					break;
				case 0:
					System.out.println("Adeus");
				default:									
				System.out.printf("Operação errada!\n\n");
			}
		}while(escolha != 0);
	}

	private static void adicionarPrato() {
		int numero;
		int escolha = 0;
		boolean sair = false;
		Prato p;
		do{ 
			numero = listarPrato(); 
			if(numero == 0) {
				System.out.println("Ainda não criou nenhum prato");
				sair = true;
				break;
			}
			System.out.println("Introduza o numero do prato que quer adicionar a ementa->");
			escolha = sc.nextInt();
			System.out.println(escolha);
		}while(escolha>= numero && escolha <1);
		if(!sair){
			Object[] a = pratos.toArray();
			Prato[] b = new Prato[a.length];
			for(int i = 0; i<a.length;i++) {
				 b[i] = (Prato) a[i];
			}
			sc.nextLine();
			DiaSemana dia = dia();
			ementa.addPrato(b[escolha-1], dia);
		}
		
	}

	private static void adicionarIngrediente() {
		int numero;
		int escolha = 0;
		boolean sair = false;
		Prato p;
		do{ 
			numero = listarPrato(); 
			if(numero == 0) {
				System.out.println("Ainda não criou nenhum prato");
				sair = true;
				break;
			}
			System.out.println("Introduza o numero do prato que quer adicionar ingredientes->");
			escolha = sc.nextInt();
			System.out.println(escolha);
		}while(escolha>= numero && escolha <1);
		if(!sair){
			p = pratos.remove(escolha-1);
			System.out.println("Introduza o numero de alimentos que pretende adicionar ->");
			int numAlimentos = sc.nextInt();
			Alimento a = null;
			if(p.getClass().getName().equals(Prato.class.getName())) { 
				for(int i = 0; i<numAlimentos;i++) {
					boolean escolha1 = false;
					do {
						System.out.println("Introduza o Tipo de alimento que pretende criar (Carne / Peixe / Cereal / Legume) ->");	
						sc.nextLine();
						String resposta = sc.nextLine();
						if(resposta.equalsIgnoreCase("carne")) {
							a = carne();
							escolha1 = true;
						}
						else if(resposta.equalsIgnoreCase("peixe")) {
							a = peixe();
							escolha1 = true;
						}
						else if(resposta.equalsIgnoreCase("cereal")) {
							a = cereal();
							escolha1 = true;
						}
						else if(resposta.equalsIgnoreCase("legume")) {
							a = legume();
							escolha1 = true;
						}else
							System.out.println("Opcao invalida");
					}while(!escolha1);
					p.addIngrediente(a);
				}
				
			}
			else if(p.getClass().equals(PratoDieta.class)) {
				for(int i = 0; i<numAlimentos;i++) {
					boolean escolha1 = false;
					do {
						System.out.println("Introduza o Tipo de alimento que pretende criar (Carne / Peixe / Cereal / Legume) ->");	
						sc.nextLine();
						String resposta = sc.nextLine();
						if(resposta.equalsIgnoreCase("carne")) {
							a = carne();
							
							escolha1 = true;
						}
						else if(resposta.equalsIgnoreCase("peixe")) {
							a = peixe();
							escolha1 = true;
						}
						else if(resposta.equalsIgnoreCase("cereal")) {
							a = cereal();
							escolha1 = true;
						}
						else if(resposta.equalsIgnoreCase("legume")) {
							a = legume();
							escolha1 = true;
						}else
							System.out.println("Opcao invalida");
					}while(!escolha1);
					if(!p.addIngrediente(a)) 
						i--;
				}
			}
			else if(p.getClass().equals(PratoVegetariano.class)) {
				for(int i = 0; i<numAlimentos;i++) {
					boolean escolha1 = false;
					do {
						System.out.println("Introduza o Tipo de alimento que pretende criar (Cereal / Legume) ->");	
						sc.nextLine();
						String resposta = sc.nextLine();
						if(resposta.equalsIgnoreCase("cereal")) {
							a = cereal();
							escolha1 = true;
						}
						else if(resposta.equalsIgnoreCase("legume")) {
							a = legume();
							escolha1 = true;
						}else
							System.out.println("Opcao invalida");
					}while(!escolha1);
					p.addIngrediente(a);
				}
			}
			pratos.add(p);
		}
	}

	private static void apagarPrato() {
		int numero;
		int escolha;
		Prato a;
		do{ 
			numero = listarPrato(); 
			System.out.println("Introduza o numero do prato que quer eliminar->");
			escolha = sc.nextInt();
		}while(escolha> numero && escolha <1);
		a = pratos.remove(escolha-1);
		System.out.println("Prato "+ a.toString()+" removido");
	}

	private static int listarPrato() {
		Object[] todos =  pratos.toArray();
		for(int i  = 0; i<todos.length;i++) {
			if(todos[i].getClass().getName().equals(Prato.class.getName())) { 
				Prato a = (Prato) todos[i];
				System.out.println(i+1+" " + a.toString());
			}
			else if(todos[i].getClass().equals(PratoDieta.class)) {
				PratoDieta a = (PratoDieta) todos[i];
				System.out.println(i+1+" "  + a.toString());
				}
			else if(todos[i].getClass().equals(PratoVegetariano.class)) {
				PratoVegetariano a = (PratoVegetariano) todos[i];
				System.out.println(i+1+" "  + a.toString());
			}
		}
		return todos.length;
	}

	private static void criarPrato() {
		int escolha;
		do{ 
			System.out.println("\n1- Criar Prato normal");
			System.out.println("2- Criar Prato vegetariano");
			System.out.println("3- Criar Prato dieta");
			System.out.println("0- Voltar ao inicio");
			System.out.println("Introduza o numero do que quer fazer->");
			escolha = sc.nextInt();
			sc.nextLine();
			switch(escolha){ 
				case 1:	
					criarPratoNormal();	
					System.out.println("Prato normal Criado com sucesso");
					escolha = 0;					
				break;											
				case 2:										
					criarPratoVegetariano();
					escolha = 0;
				break;
				case 3:										
					criarPratoDieta();
					escolha = 0;
				break;
				default:									
				System.out.printf("Operação errada!\n\n");
			}
		}while(escolha != 0);		
	}

	private static void criarPratoNormal() {
		int numAlimentos;
		String nome = nome();
		Prato aux = new Prato(nome);
		Alimento a = null;
		System.out.println("Introduza o numero de alimentos que o prato tem ->");
		numAlimentos = sc.nextInt();
		for(int i = 0; i<numAlimentos;i++) {
			boolean escolha = false;
			do {
				System.out.println("Introduza o Tipo de alimento que pretende criar (Carne / Peixe / Cereal / Legume) ->");	
				sc.nextLine();
				String resposta = sc.nextLine();
				if(resposta.equalsIgnoreCase("carne")) {
					a = carne();
					escolha = true;
				}
				else if(resposta.equalsIgnoreCase("peixe")) {
					a = peixe();
					escolha = true;
				}
				else if(resposta.equalsIgnoreCase("cereal")) {
					a = cereal();
					escolha = true;
				}
				else if(resposta.equalsIgnoreCase("legume")) {
					a = legume();
					escolha = true;
				}else
					System.out.println("Opcao invalida");
			}while(!escolha);
			aux.addIngrediente(a);
		}
		pratos.add(aux);
	}
	
	private static void criarPratoDieta() {
		int numAlimentos;
		String nome = nome();
		double maxcal = maximoCalorias();
		PratoDieta aux = new PratoDieta(nome,maxcal);
		Alimento a = null;
		System.out.println("Introduza o numero de alimentos que o prato tem ->");
		numAlimentos = sc.nextInt();
		for(int i = 0; i<numAlimentos;i++) {
			boolean escolha = false;
			do {
				System.out.println("Introduza o Tipo de alimento que pretende criar (Carne / Peixe / Cereal / Legume) ->");	
				sc.nextLine();
				String resposta = sc.nextLine();
				if(resposta.equalsIgnoreCase("carne")) {
					a = carne();
					
					escolha = true;
				}
				else if(resposta.equalsIgnoreCase("peixe")) {
					a = peixe();
					escolha = true;
				}
				else if(resposta.equalsIgnoreCase("cereal")) {
					a = cereal();
					escolha = true;
				}
				else if(resposta.equalsIgnoreCase("legume")) {
					a = legume();
					escolha = true;
				}else
					System.out.println("Opcao invalida");
			}while(!escolha);
			if(!aux.addIngrediente(a)) 
				i--;
		}
		pratos.add(aux);
	}
	
	private static void criarPratoVegetariano() {
		int numAlimentos;
		String nome = nome();
		PratoVegetariano aux = new PratoVegetariano(nome);
		Alimento a = null;
		System.out.println("Introduza o numero de alimentos que o prato tem ->");
		numAlimentos = sc.nextInt();
		for(int i = 0; i<numAlimentos;i++) {
			boolean escolha = false;
			do {
				System.out.println("Introduza o Tipo de alimento que pretende criar (Cereal / Legume) ->");	
				sc.nextLine();
				String resposta = sc.nextLine();
				if(resposta.equalsIgnoreCase("cereal")) {
					a = cereal();
					escolha = true;
				}
				else if(resposta.equalsIgnoreCase("legume")) {
					a = legume();
					escolha = true;
				}else
					System.out.println("Opcao invalida");
			}while(!escolha);
			aux.addIngrediente(a);
		}
		pratos.add(aux);
	}
	
	public static Carne carne() {
		TipoCarne tipo = tipoCarne();
		double proteinas = proteinas();
		double calorias = calorias();
		double peso = peso();
		return new  Carne(tipo, proteinas,calorias,peso);
		
	}
	public static Peixe peixe() {
		TipoPeixe tipo = tipoPeixe();
		double proteinas = proteinas();
		double calorias = calorias();
		double peso = peso();
		return new  Peixe(tipo, proteinas,calorias,peso);
		
	}
	public static Cereal cereal() {
		String nome = nome();
		double proteinas = proteinas();
		double calorias = calorias();
		double peso = peso();
		return new  Cereal(nome, proteinas,calorias,peso);
		
	}
	public static Legume legume() {
		String nome = nome();
		double proteinas = proteinas();
		double calorias = calorias();
		double peso = peso();
		return new  Legume(nome, proteinas,calorias,peso);
		
	}

	public static String nome() {
		System.out.println("Introduza o nome ->");
		return sc.nextLine();
	}
	
	public static double proteinas() {
		System.out.println("Introduza o numero de proteinas ->");
		return sc.nextDouble();
	}
	
	public static double calorias() {
		System.out.println("Introduza o numero de calorias ->");
		return sc.nextDouble();
	}
	
	public static double peso() {
		System.out.println("Introduza o peso ->");
		return sc.nextDouble();
	}
	
	public static double maximoCalorias() {
		System.out.println("Introduza o maximo de calorias->");
		return sc.nextDouble();
	}
	
	public static TipoCarne tipoCarne() {
		boolean escolha = false;
		TipoCarne a = TipoCarne.VACA;
		do {
			System.out.print("Introduza o tipo de carne que pretende " + java.util.Arrays.asList(TipoCarne.values()) );
			
			String resposta = sc.nextLine();
			if(resposta.equalsIgnoreCase("porco")) {
				a = TipoCarne.PORCO;
				escolha = true;
			}
			else if(resposta.equalsIgnoreCase("vaca")) {
				escolha = true;
			}
			else if(resposta.equalsIgnoreCase("peru")) {
				a = TipoCarne.PERU;
				escolha = true;
			}
			else if(resposta.equalsIgnoreCase("frango")) {
				a = TipoCarne.FRANGO;
				escolha = true;
			}
			else if(resposta.equalsIgnoreCase("outra")) {
				a = TipoCarne.OUTRA;
				escolha = true;
			}else
				System.out.println("Opcao invalida");
		}while(!escolha);
		return a;
	}
	
	public static TipoPeixe tipoPeixe() {
		boolean escolha = false;
		TipoPeixe a = TipoPeixe.Fresco;
		do {
			System.out.print("Introduza o tipo de peixe que pretende " + java.util.Arrays.asList(TipoPeixe.values()) );
			
			String resposta = sc.nextLine();
			if(resposta.equalsIgnoreCase("congelado")) {
				a = TipoPeixe.Congelado;
				escolha = true;
			}
			else if(resposta.equalsIgnoreCase("fresco")) {
				escolha = true;
			}else
				System.out.println("Opcao invalida");
		}while(!escolha);
		return a;
	}
	
	public static DiaSemana dia() {
		boolean escolha = false;
		DiaSemana a = DiaSemana.Segunda;
		do {
			System.out.print("Introduza o Dia da Semana que pretende " + java.util.Arrays.asList(DiaSemana.values()) );
			
			String resposta = sc.nextLine();
			if(resposta.equalsIgnoreCase("terça")) {
				a = DiaSemana.Terça;
				escolha = true;
			}
			else if(resposta.equalsIgnoreCase("segunda")) {
				escolha = true;
			}
			else if(resposta.equalsIgnoreCase("quarta")) {
				a = DiaSemana.Quarta;
				escolha = true;
			}
			else if(resposta.equalsIgnoreCase("quinta")) {
				a = DiaSemana.Quinta;
				escolha = true;
			}
			else if(resposta.equalsIgnoreCase("sexta")) {
				a = DiaSemana.Sexta;
				escolha = true;
			}
			else if(resposta.equalsIgnoreCase("sabado")) {
				a = DiaSemana.Sabado;
				escolha = true;
			}
			else if(resposta.equalsIgnoreCase("domingo")) {
				a = DiaSemana.Domingo;
				escolha = true;
			}
			else
				System.out.println("Opcao invalida");
		}while(!escolha);
		return a;
	}
	
	
	public static void saveInFile() throws IOException {
		
		System.out.println("O ficheiro será gravado com o nome Ementa");
		
		File f= new File("Ementa.txt");
		
		PrintWriter pw= new PrintWriter(f);
		pw.println("Ementa - Snack UA:");
		pw.print(ementa);
		pw.close();
		
		
	}
	

}
