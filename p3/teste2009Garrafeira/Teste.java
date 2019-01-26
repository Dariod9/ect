package teste2009Garrafeira;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Teste {
 public static void main (String[] args) {
	 
	 Agua a1= new Agua("PuraNascente", 33, 0.49, Tipo.NASCENTE);
	 Agua a2= new AguaGaseificada("AguaMineral", 25, 0.45, Tipo.MINERAL);
	 
	 Vinho v1=new Vinho("Penalva", 75, 2.79, 13, Regiao.DAO);
	 Espumante v2=new Espumante("LeitaodeVinho", 75, 3.5, 12.5, Regiao.BAIRRADA);
	 
	 Bar bar1= new Bar("Meu Bar");
	 
	 System.out.println("---------Qql cena--------");
	 System.out.print(bar1.addBebida(a1)+" \n");
	 System.out.print(bar1.addBebida(a2)+"\n");
	 System.out.print(bar1.addBebida(a2)+"\n");
	 System.out.print(bar1.addBebida(v1)+"\n");
	 System.out.print(bar1.addBebida(v2)+"\n");

	 
	 List<Bebida> b=bar1.list();

	 Collections.sort(b, new PerPriceComparator());
	 System.out.println("-----Ordenar por preço----");
	 for (Iterator<Bebida> b1= b.iterator() ; b1.hasNext();)
		 	System.out.println(b1.next());
 
 	
 	while(bar1.size()!=0) 
 		bar1.remove(bar1.size()-1);
  	
 	System.out.println("Apos remover");
 	for(MyRangeIterator<Bebida> bi=bar1.iterator(); bi.hasNext();)
 		System.out.println(bi.next());
 }
}
