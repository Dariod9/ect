import static java.lang.System.*;
import java.util.Scanner;
import p2utils.Stack;

public class HanoiTowers
{
  // ...
  
  private Stack<Integer> left= new Stack<Integer>();
  private Stack<Integer> center= new Stack<Integer>();
  private Stack<Integer> right= new Stack<Integer>();


	HanoiTowers(int n){
		
		for(int i=n;i>=1;i--){
			left.push(i);
			}
	
		}



	public static void moverDiscos(int n, Stack<Integer> left, Stack<Integer> right,  Stack<Integer> center) { 
			assert n >= 0;
			if (n > 0) { 
				moverDiscos(n-1, left, center, right); 
				
				//out.println("Move disco "+n+" da torre "+origem+" para a torre "+destino); 
				moveDisk(left,right); //?
				
				
				moverDiscos(n-1, center, right, left); 
				
				}
			}

	
	public static void moveDisk(Stack<Integer> a,Stack<Integer> b){
		
		b.push(a.top());
		a.pop();
		
		}
		
}

