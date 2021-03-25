import java.util.Scanner;

public class Ex7 {
	
	public static void main (String[] args) {
	
	Scanner sc= new Scanner (System.in);
	
	int x,y;
	
	System.out.println("Introduzir numeros:");	
	x = sc.nextInt();
	y = sc.nextInt();
	
	mdc(x, y);
	
	
	}
		
	public static int mdc (int a, int b) {
		
	int d=0;
	
		
		if(a>b){
			
			
				d = a-b;
			
						
				if(d>b){
				
							do{
			
									d = d-b;
					
							}while(d>b);
				
				
						if(d==b){
				
						return d;
				
								}
				
						}
				
				if(b>d){
				
							do{
									b -= d;
				
							}while(b>d);
			
			
						if(d==b){
				
						return d;
				
								}
			
			
						}
			
				}	
			
				
		if(a<b){
				
				d = b-a;
						
						if(d>a){
				
								do{
			
									d -= a;
					
									}while(d>a);
				
								}
				
						
						if(a>d){
				
								do{
									
									a -= d;
				
									}while(a>d);
				
							if(d==a){
				
							return d;
				
									}
			
			
								}
			
			
				}
				
						
			if(a==b){
				
			return a;
			 
				}
			
		System.out.printf("%2d",d);

		return d;
		
				
		
}

}
