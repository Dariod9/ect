import static java.lang.System.*;

public class P2
{
  public static void main(String[] args)
  {
	  out.printf("\n '%s' contains %d pairs of consecutive equal characters", args[0],countPairs(args[0],1,0));
  }


	public static int countPairs (String s, int n, int cont){
		
		assert n>=0;
		
		//char a=s.charAt(n);
		
		if(n>0 && n<s.length() && s.charAt(n)==s.charAt(n-1)){
			cont+=1;
			out.println("yA");
				}
		
		if(n<s.length()) 
		return countPairs(s,n+1,cont);

		return cont;
		
		}

}

