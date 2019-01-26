package aula1;

import java.util.*;

public class Quadrado{
	private Ponto bottomLeft;
	private double lado;
	
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
		double area= lado*lado;
		
		String s="\nQuadrado de centro em ("+x1+","+y1+"), lado "+lado+" e area "+area;
		
		return s;
	}
}