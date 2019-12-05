package aula7.Ex1;

public class Hora {

	private int minutos;
	private int segundos;
	
	public Hora(int minutos, int segundos) {
		this.minutos=minutos;
		this.segundos=segundos;
	}
	
	public int minutos() {return minutos;}
	public int segundos() { return segundos;}

	@Override
	public String toString() { 
		String s=""+minutos+":"+segundos;
		return s;
	}
	
	public String soma(Hora h) {
		String s="";
		int mins= h.minutos+minutos;
		int segs= h.segundos+segundos;
		if (segs==60){
			mins++;
			segs=00;
		}
		
		s=mins+":"+segs;
		return s;
	}
}
