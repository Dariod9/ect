package teste2015Clinica;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Teste {
	public static void main (String[] args) throws IOException, ClassNotFoundException {
		
		Cadeira cd1= new Cadeira("Elite-2", 2034, Mobiliario.Material.SINTETICO, TipoCadeira.ESCRITORIO, 1,0.9);
		
		CadeiraDeRodas cd2= new CadeiraDeRodas("Mobilete", 3233, Mobiliario.Material.METAL, TipoCadeira.ESCRITORIO, 4, 0.0, 4, false);
	
		cd2.setTipo(TipoUtilizacao.MOB_REDUZIDA);
		Cama c1=new Cama("FOfinha", 4233, Mobiliario.Material.MADEIRA, 1.90, 1.10,true);
		CamaArticulada ca1 = new CamaArticulada("MaxFlex2000", 4174, Mobiliario.Material.METAL, 1.9,1.2,true,false);
		
		Marquesa m1= new Marquesa("Ex20", 1234, Mobiliario.Material.METAL, 1.8, 0.9, true, false);
		Maca ma1= new Maca("SpeedX2", 9232, Mobiliario.Material.METAL.MADEIRA, 2.0, 0.8, false, 2);
		ma1.setTipo(TipoUtilizacao.URGENTE);
		
		Clinica cl1= new Clinica("Boa Saúde");
		
		System.out.println("\n-------Insercao Mobiliario-------");
		System.out.print(cl1.addMobiliario(cd1)+", ");
		System.out.print(cl1.addMobiliario(cd2)+", ");
		System.out.print(cl1.addMobiliario(c1)+", ");
		System.out.print(cl1.addMobiliario(ca1)+", ");
		System.out.print(cl1.addMobiliario(m1)+", ");
		System.out.print(cl1.addMobiliario(ma1)+", ");
		
		System.out.println("\n-----Listagem de todo o Mobiliario------");
		for (MyRangeIterator<Mobiliario> r1 = cl1.iterator(); r1.hasNext();)
			System.out.println(r1.next() + "\n");

		cl1.removeMobiliario(cd1);

		System.out.println(
			"\n------------------------ Listagem de Mobiliario de Transporte -----------------------------");
		List<Transporte> lo = cl1.listTransportes();
		
		for (Iterator<Transporte> ri = lo.iterator(); ri.hasNext();) {
			Transporte tp = ri.next();
			System.out.println("  Elemento: " + tp.getClass().getSimpleName() + " para transporte " + tp.getTipo());
		}
		cl1.saveClinica("clinica.bin");
		cl1.rescueClinica("clinica.bin");
		cd1.saveCadeira("Cadeira.bin");
		cd1.rescueCadeira("Cadeira.bin");
	}
}
