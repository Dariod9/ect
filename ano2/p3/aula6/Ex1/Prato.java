package aula6.Ex1;

public class Prato implements Comparable<Prato>{
	
	private String nome;
	private LinkedList<Alimento> ings=new LinkedList<Alimento>();
	private double protTotal=0;
	private double calTotal=0;
	private double pesoTotal=0;
	
	
	public Prato(String nome) {
		this.nome=nome;
	}

	
	public String nome() { return nome;}
	public double protTotal() {return protTotal;}
	public double calTotal() { return calTotal;}
	public double pesoTotal() {return pesoTotal;}
	
	public LinkedList<Alimento> ings() { return ings;}
	
	public boolean addIngrediente(Alimento a) {
		addListaIng(a);
		return true;
	}
	
	public void addListaIng(Alimento a) {
		if(ings.isEmpty()) ings.addFirst(a);
		else ings.addLast(a);
		
		protTotal=protTotal+a.getproteinas();
		pesoTotal=pesoTotal+a.getpeso();
		calTotal=calTotal+a.getcalorias();
	}
	
	
	
	
	@Override
	public int compareTo(Prato o) {
		if(calTotal>o.calTotal()) return 1;
		else if(calTotal==o.calTotal()) return 0;
		else return -1;
	}
	
	@Override
	public String toString() {
		return "O prato "+nome + "\te composto por "+ ings.size() + " \tIngredientes, " ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prato other = (Prato) obj;
		
		if (Double.doubleToLongBits(calTotal) != Double.doubleToLongBits(other.calTotal()))
			return false;
		if (ings == null) {
			if (other.ings() != null)
				return false;
		} else if (!ings.equals(other.ings()))
			return false;
		if (nome() == null) {
			if (other.nome() != null)
				return false;
		} else if (!nome().equals(other.nome()))
			return false;
		if (Double.doubleToLongBits(pesoTotal) != Double.doubleToLongBits(other.pesoTotal()))
			return false;
		if (Double.doubleToLongBits(protTotal) != Double.doubleToLongBits(other.protTotal()))
			return false;
		return true;
	}
	
	
	
}