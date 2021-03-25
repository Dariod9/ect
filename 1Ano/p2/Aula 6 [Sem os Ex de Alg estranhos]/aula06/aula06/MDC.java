import static java.lang.System.*;

public class MDC {

  public static void main(String[] args) {
    
    mdc(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    
  }


  public static void mdc(int a, int b){	
	  
	  if(b==0) out.println(a);
	  
	  else mdc(b, a%b);
	  
	}

}
