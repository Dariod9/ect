import java.util.Scanner;

public class Aula1
{
  public static void main(String[] args)
  {
    // Scanner para leitura de dados do teclado
    Scanner sc = new Scanner(System.in);
    
    double Val, Disc, IVA;       // Variaveis de Entrada
    double Total;// Variaveis de Saida
    
    // 1) Ler os dados (sem validar, por enquanto)
    System.out.print("Valor do Produto: ");
    Val = sc.nextDouble();
    System.out.print("Desconto %: ");
    Disc = sc.nextDouble();
    System.out.print("Taxa de IVA %: ");
    IVA = sc.nextDouble();
    
    // 2) Calcular
    
    Total = Val - (Disc/100) * Val + (IVA/100) * Val ;
	
    // 3) Escrever os resultados
    System.out.printf("Fatura = %8.2f", Total);
  }
}
