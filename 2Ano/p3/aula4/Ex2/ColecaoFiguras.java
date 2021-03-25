package aula4.Ex2;

import java.util.ArrayList;

public class ColecaoFiguras{
	
	private ArrayList<Figura> lista=new ArrayList<Figura>();
	private double areaTotal;
	private double maxArea;
	
	public ColecaoFiguras(double maxArea) {
		this.maxArea=maxArea;
	}
	
	public boolean addFigura(Figura f) {
		if(areaTotal+f.area()>maxArea) return false;
		
		else {
			if(!lista.contains(f)) {
				lista.add(f);
				areaTotal=areaTotal+f.area();
				return true;
				}
			else return false;
		}
	}
	
	public boolean delFigura(Figura f) {
		if(lista.contains(f)) {
			lista.remove(f);
			areaTotal=areaTotal-f.area();
			return true;
		}
		else return false;
	}
	
	
	public double areaTotal() { return areaTotal;}
	
	public boolean exists(Figura f) { return lista.contains(f);	}
	
	public String toString() {
		String s="Lista de Figuras com "+lista.size()+" elementos e de área total "+ areaTotal+"m2";	
		return s;	}
	
	public Figura[] getFiguras() {
		Figura[] a=new Figura[lista.size()];
		
		return a=lista.toArray(a);
	}
	
	public Ponto[] getCentros() {
		
		Ponto[] centros=new Ponto[lista.size()];
		
		for(int i=0;i<lista.size();i++) {
			centros[i]=lista.get(i).centro();
			}
		
		return centros;
		
		}
		
}