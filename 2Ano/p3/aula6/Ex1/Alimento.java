package aula6.Ex1;

public class Alimento implements Comparable<Alimento>{
	
	private double proteinas;
	private double calorias;
	private double peso;

	public Alimento(double proteinas, double calorias, double peso) {
		this.proteinas=proteinas;
		this.calorias=calorias;
		this.peso=peso;
	}
	
	public double getproteinas() {return proteinas;}
	public double getcalorias() {return calorias;}
	public double getpeso() {return peso;}

	@Override
	public int compareTo(Alimento o) {
		if(calorias>o.getcalorias()) return 1;
		else if(calorias==o.getcalorias()) return 0;
		else return -1;
	}
	

	
}