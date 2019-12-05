import java.util.*;

public class G8Ex2 {
   static final Scanner sc= new Scanner (System.in);
	
   public static void main (String[] args) {
	 

	Ponto2D ponto = new Ponto2D();
	double distP,somaDist=0,distMax=0,xMax=0,yMax=0;		
	int Num=0;	
		do{
			
			ponto = IntPonto();
			
			distP=Math.sqrt(ponto.x*ponto.x + ponto.y*ponto.y);
			
			Num++;
			
			somaDist+= distP;
			
			if(distP>distMax){
				
				distMax=distP;
				xMax=ponto.x;
				yMax=ponto.y;
				
				}
			
			}while(ponto.x!=0 && ponto.y!=0);

	System.out.printf("A soma das distancias dos %2d pontos a origem e %4.2f",Num-1,somaDist);
	System.out.printf("\nO ponto mais afastado da origem foi: (%4.2f,%4.2f)",xMax,yMax);
	
	}
	
	public static Ponto2D IntPonto(){
		
		Ponto2D ponto= new Ponto2D();
		double x,y;
		
		System.out.println();
		System.out.printf("Coordenada X:");
		x= sc.nextDouble(); ponto.x=x;
		System.out.printf("\nCoordenada Y:");
		y=sc.nextDouble(); ponto.y=y;
		
		return ponto;
		
		}
}

class Ponto2D{
	
	double x,y;
	
	}

