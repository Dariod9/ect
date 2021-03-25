import static java.lang.System.*;

public class AllDivisors
{
public static void main(String[] args){
	
	divisors(Integer.parseInt(args[0])," ");
	
	}
	
public static void divisors(int n,String s){
		
	out.println();	

	for(int i=n-1;i>1;i--){
		
		if(n%i==0){
			out.println(s+i);
			divisors(i,s+"  ");
			}
	
		}
	
	}
}
