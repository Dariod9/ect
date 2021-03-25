import static java.lang.System.*;
import p2utils.Stack;

public class Palindrome {
	
	public static void main (String[] args) {
		
		Stack<Character> a= new Stack<Character>();
		Stack<Character> b= new Stack<Character>();
		
		String s=args[0];
		char c;
		
		for(int i=0;i<args[0].length();i++){
			
		 	c=s.charAt(i);
			
			a.push(c);
			
			}
			
		for(int i=args[0].length()-1;i>=0;i--){
			
			c=s.charAt(i);
			
			b.push(c);
			
			}
						
		out.println(compare(a,b));
	
	}
	
	public static boolean compare(Stack<Character> a,Stack<Character> b){
		
		return pushFalse(a,b,true);
		}
	
	public static boolean pushFalse(Stack<Character> a,Stack<Character> b,boolean same){
		
	if(a.isEmpty()==false && b.isEmpty()==false){
		if(a.top()==b.top()){
			same=true;
			a.pop();
			b.pop();
			return pushFalse(a,b,true);
			}
		
		else{
			return same=false;
			 }
		
		}
			
	else return same;
		
		}
}

