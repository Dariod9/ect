package aula5.Ex3;

public class Contacto extends Pessoa{
	
	private int phone;
	
	public Contacto(String nome, Data dataNasc, int phone) {
		super(nome,dataNasc);
		this.phone=phone;
	}
	
	public int phone() {return phone;}
}