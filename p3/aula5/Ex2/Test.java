package aula5.Ex2;

public class Test{
	public static void main(String[] args) {
		
		Veiculo[] veics=new Veiculo[4];
		
		Bicicleta bike= new Bicicleta(2012,"cinzento");
		veics[0]=bike;
		
		BicicletaPolicia bikePol= new BicicletaPolicia(2008,"azul",Tipo.INEM);
		veics[1]=bikePol;
		
		CarroPolicia taxiPol= new CarroPolicia(2017,"PJ-99-AR",800,200,Tipo.PJ,"Diesel");
		veics[2]=taxiPol;
		
		MotaPolicia hondaCBR= new MotaPolicia(2016,"LP-99-24",400,170,Tipo.Bombeiros,"Diesel");
		veics[3]=hondaCBR;
		
		System.out.println(hondaCBR.id()); //2 ou 3
		
		for(int i=0; i<4;i++) {
			System.out.println(veics[i].toString());
		}
		
		UtilCompare.sortArray(veics); // AQUI
		System.out.println("Ordenados:");
		for(int i=0; i<veics.length;i++) {
			System.out.println(veics[i].toString());
		}
		
	}
}