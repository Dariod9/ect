package aula3.Ex3;

public class Test{
	
	public static void main(String[] args) {
		
		Condutor c1=new Condutor("Alex", 15606975, new Data(29,9,1999),"A");
		Condutor c2=new Condutor("Tone", 16469378, new Data(5,4,1999),"B");
		Condutor c3=new Condutor("Joao", 26532567, new Data(1,31,1998),"C");
		
		Automovel seat= new Automovel(300,900,4,"A",1500,c1);
		System.out.print("\n O condutor c1 pode conduzir o seat?"+seat.isValid()); //True;
		
		Automovel opel= new Automovel(300,800,4,"A",1300,c2);
		System.out.print("\n O condutor c2 pode conduzir o opel?"+opel.isValid()); //False;
		
		Motociclo honda= new Motociclo(100,400,2,"B",400,c3);
		System.out.print("\n O condutor c3 pode conduzir o honda?"+honda.isValid()); //False;	
		
		PesadoDeMercadorias scania= new PesadoDeMercadorias(500,1000,4,"C",5000,c3);
		System.out.print("\n O condutor c3 pode conduzir o scania?"+scania.isValid()); //Falso because lotacao;
		
		PesadoDePassageiros berrelhas= new PesadoDePassageiros(550,900,2,"C",5000,c1);
		System.out.print("\n O condutor c3 pode conduzir o berrelhas?"+berrelhas.isValid()); //Falso;
	}
}