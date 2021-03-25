package aula10;

public class Figura{
	
	private Ponto centro;
	private double area;
	private double perimetro;
	
	public Ponto centro(){ return centro;}
	public double area(){ return area;}
	public double perimetro() { return perimetro;}
	
	public Figura() {};
	
	public Figura(Ponto centro) {
		this.centro=centro;
	}
	
}