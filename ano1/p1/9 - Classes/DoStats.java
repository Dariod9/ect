import java.util.Scanner;

// Complete o programa
public class DoStats {
  
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  double x,sum=0,sum2=0,min=99,max=0;
	  int n;
	  
    // Cria um registo de estatisticas:
    Statistics xstat = new Statistics();
    
    
    System.out.println("Introduza o numero de dados:");
    n=sc.nextInt();
    
    xstat.num=n;
    
    
		for(int i=0;i<=n-1;i++){
			
			System.out.println("Introduza um valor:");
			x=sc.nextDouble();
			xstat.a[i]=x;
			
			}
		
    
  /*  // Enquanto houver um valor para ler:
    while (sc.hasNextDouble()) {
      // Lê um valor:
      x = sc.nextDouble();
      // Atualiza o registo de estatisticas:
      updateStats(xstat, x);
    }
    */
    
		for(int i=0;i<=n-1;i++){
			
			sum+= xstat.a[i];
			sum2+=(xstat.a[i]*xstat.a[i]);
			
			if(xstat.a[i]<min){
				
				min=xstat.a[i];
				
				}
				
			if(xstat.a[i]>max){
				
				max=xstat.a[i];
				
				}
			
			}
    
    xstat.sum=sum;
   
    xstat.sum2=sum2;
    
    xstat.min=min;
    
    xstat.max=max;
    
    // Escreve resultados:
    System.out.printf("numero de valores = %f\n", xstat.num);
    System.out.printf("soma dos valores = %f\n", xstat.sum);
    System.out.printf("soma dos quadrados = %f\n", xstat.sum2);
    if (xstat.num > 0) {
      System.out.printf("min = %f\n", xstat.min);
      System.out.printf("max = %f\n", xstat.max);
      System.out.printf("média = %f\n", mean(xstat));
      
    } else {
      System.out.printf("Lista vazia!");
    }
  }

  // Definir funções updateStats, mean!
  
 /* public static void updateStats(Statistics geral, double x){
	  	  
	  geral.num=(geral.num )+ 1;
	  geral.a[num]=x;
	  
	  }*/
  
	public static double mean (Statistics geral){
		
		double m;
		
		m=geral.sum/geral.num;
		
		return m;
		
		}
}

// Definir classe Statistics -----------------------
class Statistics{
	
	int num;
	double[] a= new double[num];
	double x,sum,sum2,min,max;
}
