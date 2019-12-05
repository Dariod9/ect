
public class Visitante {

	private static int numTotal;
	private int num;
	private String data;
	
	public Visitante(String data) {
		numTotal++;
		this.num=numTotal;
		this.data=data;
	}

	public int getNum() {
		return num;
	}


	public String getData() {
		return data;
	}

	
}
