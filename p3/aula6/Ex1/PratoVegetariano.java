package aula6.Ex1;

public class PratoVegetariano extends Prato implements Vegetariano, Comparable<Prato> {

	private LinkedList<Vegetariano> ings;
	
	public PratoVegetariano(String nome) {
		super(nome);
	}
	
	public PratoVegetariano(String nome, LinkedList<Vegetariano> ings) {
		super(nome);
		this.ings=ings;
	}
	
	@Override
	public boolean addIngrediente(Alimento a) {
		if(a instanceof Vegetariano) {
			addListaIng((Alimento) a);
			return true;
		}
		else return false;
	}

}
