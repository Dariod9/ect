package aula6.Ex2;

import java.util.*;
import java.util.function.Predicate;

public class ListsProcess {
	
	public static <T> List<T> filter(List<T> lista, Predicate<T> cond) {	
		
		List<T> listaFiltd = new ArrayList<T>();
		
		for( T o: lista) {
			if(cond.test(o)) {
				listaFiltd.add(o);
			}
		}
	
		return listaFiltd;

	}	
}
