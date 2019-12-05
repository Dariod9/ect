import static java.lang.System.*;

public class Fibonacci {

  public static void main(String[] args) {
    if (args.length < 1) {
      out.println("USO: java -ea Fibonacci N [N ...]");
      exit(1);
    }
	/*int max=0;
	for(int i=0;i<args.length;i++){
		if(Integer.parseInt(args[i])>max) max=Integer.parseInt(args[i]);
		}
		*/
	int[] valores= new int[Integer.parseInt(args[0])+1];

    // Alguns testes:
    assert fibonacci(0,valores) == 0;
    assert fibonacci(1,valores) == 1;
    assert fibonacci(2,valores) == 1;
    assert fibonacci(5,valores) == 5;

    for(int i = 0; i < args.length; i++) {
      int n = Integer.parseInt(args[i]);
      long time = nanoTime();  // System.nanoTime() gives the time in ns.
      int f = fibonacci(n,valores);
      time = nanoTime() - time;
      out.printf("fibonacci(%d) = %d (%d ns)\n", n, f, time);
	  valores[i]=f;
    
    }
  
   
  
  }

  public static int fibonacci(int n, int[] array) {
    assert n >= 0;
    int result=0;
    
    if(n==0) return 0;
    if(n==1) return 1;
    if(array[n]!=0) return array[n];
    else{
		result=fibonacci(n-2,array)+fibonacci(n-1,array);
	
    return result;
	}
	
  }

}
