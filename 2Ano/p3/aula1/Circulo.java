package aula1;

public class Circulo{
	private Ponto centro;
	private double raio;
	
	public Circulo(Ponto centro, double raio) {
		
		this.centro=centro;
		this.raio=raio;
	}
	
	public Circulo(double x, double y, double raio) {
		
		Ponto c= new Ponto(x,y);
		this.centro=c;
		this.raio=raio;
	}
	
	public Ponto centro() { return centro;}
	
	public double raio()  { return raio;}	
	
	public String toString() {
		String x1=""+centro.x();
		String y1=""+centro.y();
		double area=3.14*raio*raio;
		String s="\nCirculo de centro em ("+x1+","+y1+") e raio "+raio+" e área "+area;
		
		return s;
	}
	
	public boolean checkEqual(Circulo cir) {
		boolean equal=false;
		
		if(cir.centro().x()==centro.x() && cir.centro().y()==centro.y() && cir.raio()==raio) equal=true;
				
		return equal;
		
	}
}