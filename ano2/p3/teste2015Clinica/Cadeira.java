package teste2015Clinica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cadeira extends Mobiliario implements Serializable {

	private static final long serialVersionUID = 1L;
	private TipoCadeira tipo;
	private int numApoios;
	private double altura;
	
	public Cadeira(String designacao, int id, Material material, TipoCadeira tipo, int numApoios, double altura) {
		super(designacao,id,material);
		this.setTipo(tipo);
		this.setNumApoios(numApoios);
		this.setAltura(altura);
	}

	public TipoCadeira getType() {
		return tipo;
	}

	public void setTipo(TipoCadeira tipo) {
		this.tipo = tipo;
	}

	public int getNumApoios() {
		return numApoios;
	}

	public void setNumApoios(int numApoios) {
		this.numApoios = numApoios;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public void saveCadeira(String nome) throws FileNotFoundException, IOException {
		
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(nome));
		out.writeObject(this);
		out.close();
	}
	
	public void rescueCadeira(String nome) throws FileNotFoundException, IOException, ClassNotFoundException{
		
		ObjectInputStream in=new ObjectInputStream( new FileInputStream(nome));
		Cadeira c1=(Cadeira) in.readObject();
		this.setAltura(c1.getAltura());
		this.setDesignacao(c1.getDesignacao());
		this.setId(c1.getId());
		this.setMaterial(c1.getMaterial());
		this.setNumApoios(c1.getNumApoios());
		this.setTipo(c1.getType());
		
	}
	
	
}
