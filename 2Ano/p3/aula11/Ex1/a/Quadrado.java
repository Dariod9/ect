package aula11.Ex1.a;

public class Quadrado extends Figura{
	private Ponto bottomLeft;
	private double lado;
	private Ponto centro;//=new Ponto(bottomLeft.x()+lado/2, bottomLeft.y()+lado/2);
	
	public Quadrado() {};
	
	public Quadrado(Quadrado q1) {
		this.bottomLeft=q1.bottomLeft;
		this.lado=q1.lado;
		this.centro=q1.centro();
	}
	
	public Quadrado(double lado) {
		this.bottomLeft=new Ponto(-lado/2,-lado/2);
		this.lado=lado;
		this.centro=new Ponto(0,0);
	}
	
	public Quadrado(double blx, double bly, double lado) {
		this.bottomLeft=new Ponto(blx-lado/2,bly-lado/2);
		this.lado=lado;
		this.centro=new Ponto(blx,bly);
	}
	public Quadrado(Ponto centro, double lado) {
		
		this.centro=centro;
		this.bottomLeft=new Ponto(centro.x()-lado/2, centro.y()-lado/2);
		this.lado=lado;
	}
	
	public Ponto bottomLeft() { return bottomLeft;}
	public Ponto centro() { return centro;}
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