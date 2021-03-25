import java.util.Scanner;

public class Ex3 
{
	
	public static void main (String args[]) {

	Scanner sc= new Scanner (System.in);
	
		System.out.println("Introduzir ano");
		int a = sc.nextInt();
		
		System.out.println("Introduza o mes: ");
		int x= sc.nextInt();
		
		System.out.printf("O ano %2d tem %2d dias \n", a,bis(a));
		System.out.printf("O mes %2d tem %2d dias \n", x,mes(x));
	}
	
	public static int bis (int a) { //Identifica o numero de dias do ano
		
	Scanner sc= new Scanner (System.in);
	int d,c1=0,c2,c3,z;
	
		
		d=1;
		c1=(a%4);
		c2=(a%100);
		c3=(a%400);
		z=0;
		
		if(c1==0) {
			
			d=366;  
			
				}
				
		else if(c1!=0){
			
			d=365;
			
			}
		
		
				
		else if( (c2==0) && (c3 != 0)){
			
			d=365;
			
				}
				
		else if((c1==0) && (c3==0)) {
			
			d=366;
			
		}
		
		return d;
		
	}
	
		
		
		
		
	public static int mes (int x) {  //Dias do Mês
		
	Scanner sc= new Scanner (System.in);

		int m=0;
		int d2=0;
			
			
		switch (m) {
				
			case 1:case 3:case 5: case 7: case 8:case 10:case 12:
				
			d2=31;
			
			break;
				
			case 2: case 4: case 6: case 9: case 11:
				
			d2=30;
			
			break;
			
				}
					
		return d2;
									


}

}
