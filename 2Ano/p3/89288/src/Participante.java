
public class Participante {

	private String email;
	private String nome;
	
	public Participante(String email, String nome) {
		this.email=email;
		this.nome=nome;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}
	
	
	public String toString() {
		return "Participante [email="+getEmail()+" , nome="+getNome()+"]";
	}

}
