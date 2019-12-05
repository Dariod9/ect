package aula12.Ex1;

import java.util.*;

public class Figura implements Comparable<Figura>{
	
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
	@Override
	public int compareTo(Figura o) {
		if(o.area()>this.area()) return -1;
		else if(o.area()==this.area()) return 0;
		else return 1;
	}
	
}