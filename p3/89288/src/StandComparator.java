import java.util.Comparator;

public class StandComparator implements Comparator<Stand>{

	@Override
	public int compare(Stand arg0, Stand arg1) {
		if(Integer.parseInt(arg0.codigo())>Integer.parseInt(arg1.codigo())) return 1;
		else if(Integer.parseInt(arg0.codigo())==Integer.parseInt(arg1.codigo())) return 0;
		else return -1;
	}

}
