package aula6.Ex1;

public enum DiaSemana {
	Segunda(1), Terça(2), Quarta(3), Quinta(4), Sexta(5), Sabado(6), Domingo(7);
	
	private int num;
	
	DiaSemana(int num){
		this.num = num;
	}
	
	public int getnum() {
		return num;
	}

	public static DiaSemana rand() {
		
		double d = Math.random()*6;
		int numero = (int) d;
		
		switch(numero) {
		
		case 0: return DiaSemana.Segunda;
		case 1: return DiaSemana.Terça;
		case 2: return DiaSemana.Quarta;
		case 3: return DiaSemana.Quinta;
		case 4: return DiaSemana.Sexta;
		case 5: return DiaSemana.Sabado;

		default: return Domingo;
		}
	}
	
}
