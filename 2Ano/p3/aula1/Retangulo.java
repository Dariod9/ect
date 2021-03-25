package aula1;

public class Retangulo{
	private Ponto bottomLeft;
	private Ponto topRight;
	private double comp;
	private double larg;
	
	public Retangulo(Ponto bottomLeft, Ponto topRight, double comp, double larg) {
		
		this.bottomLeft=bottomLeft;
		this.topRight=topRight;
		this.comp=comp;
		this.larg=larg;
	}
	
	public Ponto bottomLeft() { return bottomLeft;}
	
	public Ponto topRight() { return topRight;}
	
	public double comp()  { return comp;}
	
	public double larg()  { return larg;}
	
	public String toString() {
		String x1=""+bottomLeft.x();
		String y1=""+bottomLeft.y();
		
		String x2=""+topRight.x();
		String y2=""+bottomLeft.y();
		
		String x3=""+bottomLeft.x();
		String y3=""+topRight.y();
		
		String x4=""+topRight.x();
		String y4=""+topRight.y();
		
		double area=comp*larg;
		
		String s="\nRetangulo de coordenadas ("+x1+","+y1+"), ("+x2+","+y2+"), ("+x3+","+y3+"), ("+x4+","+y4+") e area "+area;
		return s;
	}
	
}