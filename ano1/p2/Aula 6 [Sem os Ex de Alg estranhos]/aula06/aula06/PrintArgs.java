import static java.lang.System.*;

public class PrintArgs {

  public static void main(String[] args) {
    printArray(args, args.length);
  }


  /** Imprime as N primeiras strings do array, uma por linha. */
  public static void printArray(String[] array, int N) {
    // Implemente de forma recursiva...
	
	assert N>=0;
	
		//while(N<array.length){
		if(N!=0) printArray(array,N-1);
			
		if(N<array.length) out.println(array[N]);
		//	}
  }

}
