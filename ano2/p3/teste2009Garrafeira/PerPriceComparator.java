package teste2009Garrafeira;

import java.util.Comparator;

public class PerPriceComparator implements Comparator<Bebida>{

	@Override
	public int compare(Bebida arg0, Bebida arg1) {
		
		if(arg0.getPreco()>arg1.getPreco()) return 1;
		else if(arg0.getPreco()==arg1.getPreco()) return 0;
		else return -1;
	}


}
