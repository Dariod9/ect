package aula5.Ex1;

public class Retangulo extends Quadrado{
	
	private Ponto topRight;
	private Ponto centro;
	private double comp; //topRight.x()-bottomLeft().x();
	private double larg; //topRight.y()-bottomLeft().y();
	
	public Retangulo(Retangulo r1) {
		super();// Queria aceder ao bottomLeft(parametro da classe Quadrado) porque o Retangulo também passa a ter, certo?
		this.topRight=r1.topRight;
		this.comp=r1.comp;
		this.larg=r1.larg;
		this.centro=r1.centro();
	}
	
	public Retangulo(double larg, double comp) {
		super(larg);
		this.topRight=new Ponto(larg,comp);
		this.comp=comp;
		this.larg=larg;
		this.centro=new Ponto(0,0);
		
	}
	
	public Retangulo(double bl1, double bl2, double tr1, double tr2) {
		this.topRight=new Ponto(bl1+tr1/2,bl2+tr2/2);
		this.comp=tr1;
		this.larg=tr2;
		this.centro=new Ponto(bl1,bl2);
		
	}
	
	public Retangulo(Ponto bottomLeft, Ponto topRight, double lado) {
		
		super(bottomLeft,lado);
		this.topRight=topRight;
		this.comp=topRight.x()-bottomLeft.x();
		this.larg=lado;
		this.centro=new Ponto(topRight.x()-bottomLeft.x(),topRight.y()-bottomLeft.y());
	}
	
	public Ponto topRight() { return topRight;}
	public Ponto centro() { return centro;}
	public double comp()  { return comp;}
	
	public double larg()  { return larg;}
	
	public String toString() {
		double x1=topRight.x()-comp;
		double y1=topRight.y()-larg;
		
		String x2=""+topRight.x();
		double y2=topRight.y()-larg;
		
		double x3=topRight.x()-comp;
		String y3=""+topRight.y();
		
		String x4=""+topRight.x();
		String y4=""+topRight.y();
		
		String s="\nRetangulo de coordenadas ("+x1+","+y1+"), ("+x2+","+y2+"), ("+x3+","+y3+"), ("+x4+","+y4+") e area "+area();
		return s;
	}
	
	@Override
	public double area() {
		return comp*larg;
	}
	
	@Override
	public double perimetro() {
		return 2*larg+2*comp;
	}
	
}