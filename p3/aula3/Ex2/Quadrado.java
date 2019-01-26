package aula3.Ex2;

public class Quadrado extends Figura{
	private Ponto bottomLeft;
	private double lado;
	
	public Quadrado() {};
	
	public Quadrado(Quadrado q1) {
		this.bottomLeft=q1.bottomLeft;
		this.lado=q1.lado;
	}
	
	public Quadrado(double lado) {
		this.bottomLeft=new Ponto(0,0);
		this.lado=lado;
	}
	
	public Quadrado(double blx, double bly, double lado) {
		this.bottomLeft=new Ponto(blx,bly);
		this.lado=lado;
	}
	public Quadrado(Ponto bottomLeft, double lado) {
		
		this.bottomLeft=bottomLeft;
		this.lado=lado;
	}
	
	public Ponto bottomLeft() { return bottomLeft;}
	
	public double lado()  { return lado;}	
	
	public String toString() {
		double centro1=bottomLeft.x()+(lado*1/2);
		String x1=""+centro1;
		double centro2=bottomLeft.y()+(lado*1/2);
		String y1=""+centro2;
		
		String s="\nQuadrado de centro em ("+x1+","+y1+"), lado "+lado+" e area "+area();
		
		return s;
	}
	
	@Override
	public double area() {
		return lado*lado;
	}
	
	public double perimetro() {
		return lado*4;
	}
}