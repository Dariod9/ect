package aula7.Ex1;

import java.io.IOException;
import java.nio.file.*;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class Aeroporto {
		
		private Path path;
		private Path v;
		private Hashtable<String,String> tabela= new Hashtable<String,String>();
		private ArrayList<Voo> voos= new ArrayList<Voo>();
		private static ArrayList<Companhia> companhias= new ArrayList<Companhia>();
		
		public Aeroporto(Path path, Path v,Hashtable<String,String> tabela) throws IOException {
			this.path=path;
			this.tabela=tabela;
			this.v=v;
			this.voos=toArray(path,v,tabela);
		}
	
	public Path getPath() {
		return path;
	}

	public Path getV() {
		return v;
	}

	public Hashtable<String, String> getTabela() {
		return tabela;
	}

	public ArrayList<Voo> getVoos() {
		return voos;
	}
	
	public ArrayList<Companhia> getCompanhias(){ return companhias;}

	public ArrayList<Voo> toArray(Path compa, Path v, Hashtable<String,String> tabela) throws IOException{
		
		tabela= toTable(compa);
		
		List listaV=Files.readAllLines(v);
		
		ArrayList<Voo> voos= new ArrayList<Voo>();
		
		for(int i=1;i<listaV.size();i++) {
			
			String[] temp=((String) listaV.get(i)).split("\t");
			
			String[] tempH=temp[0].split(":");
			Hora hora=new Hora(Integer.parseInt(tempH[0]),Integer.parseInt(tempH[1]));
			
			
			Companhia c= new Companhia(tabela.get(createString(temp[1])));
			String nome= createInt(temp[1]);
			String origem=temp[2];
			
			Hora atraso= new Hora(00,00);
			
			if(temp.length>3) {
				
			tempH= temp[3].split(":");
			
			atraso=new Hora(Integer.parseInt(tempH[0]),Integer.parseInt(tempH[1]));
			}
			
			voos.add(new Voo(hora,c,nome, origem,atraso));
			
		}
		
		return voos;
	}
	
	public static Hashtable<String,String> toTable(Path p) throws IOException{
		
		List lista=Files.readAllLines(p);
		
		String[] linhas=new String[lista.size()];
		linhas= (String[]) lista.toArray(linhas);
		
		Hashtable<String,String> tabela= new Hashtable<String,String>(lista.size()-1);
		
		for(int i=1; i<lista.size();i++) {
			String[] temp=linhas[i].split("\t");
			tabela.put(temp[0], temp[1]);
			
			Companhia c=new Companhia(temp[1]);
			companhias.add(c);
		}
		
		return tabela;
	}
	
	
	public String createString(String s) {
		
		
		String sigla="";
		
		for(int i=0;i<2;i++) {
			sigla=sigla+s.charAt(i) ;
		}
		
		return sigla;
	}
	
	
	public String createInt(String s) {
			
		String sigla=""+s.charAt(2);
		
		for(int i=0;i<s.length();i++) {
			if(Character.isDigit(s.charAt(i))) sigla=sigla+s.charAt(i) ;
		}
		
		return sigla;
		
	}
	
	public String toString() {
		
		String s="";
		
		for(int i=0;i<voos.size();i++) {
			Voo temp= voos.get(i);
			s+="\n"+temp.hora().toString()+"\t"+"3"+temp.nome()+"\t"+temp.getCompanhia().nomeC()+"\t"+temp.origem()+"\t"+temp.atraso().toString()+"\t"+"Previsto: "+temp.hora().soma(temp.atraso())+"\n";
		}
		
		return s;
	}
	
	public double mediaA(Companhia c) {
		int soma=0;
		for(int i=0;i<voos.size();i++) {
			if(voos.get(i).getCompanhia().equals(c)) soma+=voos.get(i).atraso().segundos();
		}
		
		double media=soma/voos.size();
		
		return media;
	}

}
