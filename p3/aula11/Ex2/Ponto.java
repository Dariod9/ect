package aula11.Ex2;

public class Ponto{
	private double x;
	private double y;
	
	public Ponto(double x, double y) {
		this.x=x;
		this.y=y;
		
	}

public double x() { return x;}

public double y() { return y;}

public String toString() {
	String x1=""+x;
	String y1=""+y;
	String s="\nPonto de coordenadas ("+x1+","+y1+")";
	
	return s;
}
	
}