package aula6.Ex1;

public class PratoDieta extends Prato{

	private LinkedList<Alimento> ings;
	private double maxCal;
	private double cals=0;
	
	public PratoDieta(String nome, double maxCal) {
		super(nome);
		this.maxCal=maxCal;
	}
	
	public PratoDieta(String nome, LinkedList<Alimento> ings) {
		super(nome);
		this.ings=ings;
	}
	
	@Override
	public boolean addIngrediente(Alimento a) {
		if(maxCal>=cals+a.getcalorias()) {
			addListaIng(a);
			return true;
		}
		else System.out.println("Limite de Calorias ultrapassado!");
		return false;
	}

}
