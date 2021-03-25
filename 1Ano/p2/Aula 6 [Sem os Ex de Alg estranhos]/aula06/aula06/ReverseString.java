import static java.lang.System.*;

public class ReverseString {

  public static void main(String[] args) {
    out.printf(" %s -> %s ",args[0],reverseString(args[0],args[0].length()));
  }


  /** Imprime as N primeiras strings do array, uma por linha. */
  public static String reverseString(String string,int N){
    // Implemente de forma recursiva...
	String s="";
	
	if(N>0) s=string.charAt(N-1)+reverseString(string,N-1);		
		
	return s;	
	}

}
