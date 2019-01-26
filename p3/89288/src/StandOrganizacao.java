
public class StandOrganizacao extends Stand {

	private String contacto;

	public StandOrganizacao(String codigo, String nome, Participante responsavel, String contacto) {
		super(codigo, nome, responsavel);
		this.contacto=contacto;
	}

	public String getContacto() {
		return contacto;
	}
	
	public static StandOrganizacao instance(String codigo, String nome, Participante responsavel, String contacto) {
		return new StandOrganizacao(codigo, nome, responsavel, contacto);
		
	}
	
	public String toString() {
		return "Stand Organizacao[codigo="+codigo()+", nome="+getNome()+", resp="+responsavel();
	}
	
	
}
