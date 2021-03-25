package aula11.Ex2;

import java.util.Comparator;
import java.util.List;

public class maiorFigura8{		
	
	public static Figura maiorFiguraA(List<Figura> figuras) {
	
		return figuras.stream()
	.max(Comparator.comparing(Figura::area))
	.get(); 
	}

	
	public static Figura maiorFiguraP(List<Figura> figuras) {
		
		return figuras.stream().max(Comparator.comparing(Figura::perimetro)).get();
	}
}