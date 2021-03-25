import java.util.Scanner;

public class Mt1_89288v2 {		//Dário Matos  89288 Turma P08
	
	public static void main (String[] args) {
		
		Scanner sc= new Scanner (System.in);
		
		int x1,xf;		//Variaveis de inicio e fim do intervalo, respetivamente
		
		do{ 			//Ciclo para validaçao do intervalo introduzido
			
			System.out.println("Tabela com os valores do polinomio x2 + 2x + 3");
			System.out.print("Introduza o valor de x minimo:");
			x1=sc.nextInt();
			System.out.print("Introduza o valor de x maximo:");
			xf=sc.nextInt();
			
			if(xf<x1){
				
				System.out.println("Intervalo invalido\n");
				
				}
			
		}while(xf<x1);
		
		System.out.print("xmin=2		xmax=6 \n");
		
		System.out.println("\n|  x  |  x2 + 2x + 3  |"); //Linha inicial da tabela
		
		System.out.println("|---------------------|");
		
			for(int i=x1;i<=xf;i++){
				
				if(calculaPoli(i)<100){  //Calculo e apresentaçao formatada dos valores até 100
					
					System.out.printf("|%3d  |      %2d       |\n", i, calculaPoli(i));
		
						}
						
				if(calculaPoli(i)>100 && calculaPoli(i)<1000){	//Calculo e apresentaçao formatada dos valores entre 100 e 1000
					
					System.out.printf("|%3d  |      %3d      |\n", i, calculaPoli(i));
		
						}
					
				if(calculaPoli(i)>1000){	//Calculo e apresentaçao formatada dos valores superiores a 1000
					
					System.out.printf("|%3d  |     %5d     |\n", i ,calculaPoli(i));
			
						}
			}		
			
			
			//Repeticao do processo:
			
				System.out.println("\nDeseja repetir o processo?\n (1) Sim   (2) Nao");
			
			int repeat ; //Variavel de escolha 1--> Repetir  2--> Cancelar
			
			repeat = sc.nextInt(); 
				
				do{
					
					
		
				int xi,xf2;		//Variaveis de inicio e fim do intervalo, respetivamente
		
		do{ 			//Ciclo para validaçao do intervalo introduzido
			
			System.out.println("Tabela com os valores do polinomio x2 + 2x + 3");
			System.out.print("Introduza o valor de x minimo:");
			xi=sc.nextInt();
			System.out.print("Introduza o valor de x maximo:");
			xf2=sc.nextInt();
			
			if(xf2<xi){
				
				System.out.println("Intervalo invalido\n");
				
				}
			
		}while(xf2<xi);
		
		System.out.print("xmin=2		xmax=6 \n");
		
		System.out.println("\n|  x  |  x2 + 2x + 3  |"); //Linha inicial da tabela
		
		System.out.println("|---------------------|");
		
			for(int i=xi;i<=xf2;i++){
				
				if(calculaPoli(i)<100){  //Calculo e apresentaçao formatada dos valores até 100
					
					System.out.printf("|%3d  |      %2d       |\n", i, calculaPoli(i));
		
						}
						
				if(calculaPoli(i)>100 && calculaPoli(i)<1000){	//Calculo e apresentaçao formatada dos valores entre 100 e 1000
					
					System.out.printf("|%3d  |      %3d      |\n", i, calculaPoli(i));
		
						}
					
				if(calculaPoli(i)>1000){	//Calculo e apresentaçao formatada dos valores superiores a 1000
					
					System.out.printf("|%3d  |     %5d     |\n", i ,calculaPoli(i));
			
						}
			}		
			
			
			
			System.out.println("\nDeseja repetir o processo? (1) Sim ; (2) Nao"); //Repetição da escolha
			repeat=sc.nextInt();	
					
					
					}while(repeat==1);		//Caso a opção seja (2) --> Não, o programa terminará
					
			
			
			
			
	}
	
	
	
	public static int calculaPoli (int x){ //Funcao que calcula os valores do polinómio
		
		int y;
		
		y= x*x + 2*(x) + 3;
	
		return y;
	}

}
