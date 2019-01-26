package aula3.Ex2;

public class Circulo extends Figura{
	private Ponto centro;
	private double raio;
	
	public Circulo(Circulo c1) {
		this.centro=c1.centro;
		this.raio=c1.raio;
	}
	
	public Circulo(double raio) {
		this.centro=new Ponto(0,0); //super(new Ponto(0,0))M
		this.raio=raio;
	}
	
	public Circulo(Ponto centro, double raio) {
		
		super(centro);
		this.raio=raio;
	}
	
	public Circulo(double x, double y, double raio) {
		super();
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
	
	public boolean equals(Circulo cir) {
		boolean equal=false;
		
		if(cir.centro().x()==centro.x() && cir.centro().y()==centro.y() && cir.raio()==raio) equal=true;
				
		return equal;
		}
		
	@Override
	public double area() {
		return 3.141592*raio*raio;
	}
	
	public double perimetro() {
		return 2*3.141592*raio;
	}
}