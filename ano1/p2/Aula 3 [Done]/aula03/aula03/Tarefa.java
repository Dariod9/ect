import java.lang.System.*;

public class Tarefa {
	
	public Data inicio,fim;
	public String texto;

	public Tarefa (Data d1, Data d2, String t){
		
		this.inicio=d1;
		this.fim=d2;
		this.texto=t;
		
		}
		
	public Data inicio(){ return inicio; }
	public Data fim() { return fim; }
	public String texto() { return texto; }
	
}



