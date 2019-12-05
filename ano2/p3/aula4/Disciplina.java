package aula4;

import java.util.ArrayList;

public class Disciplina{
	
	private String nome;
	private String area;
	private int ects;
	private Professor resp;
	private ArrayList<Estudante> Alunos = new ArrayList<Estudante>();
	
	
	public Disciplina(String nome, String area, int ects, Professor resp) {
		this.nome=nome;
		this.area=area;
		this.ects=ects;
		this.resp=resp;
	}
	
	public boolean addAluno(Estudante est) {
		
		boolean r=false;
		
		if(!Alunos.contains(est)) {
			r=true;
			Alunos.add(est);
		}
		else System.out.println(est.nome()+" já está inscrito nesta disciplina!");
		
		return r;
	}
	
	
	public boolean delAluno(int nMec) {
		boolean r= false;
		
		for(int i=0;i<Alunos.size();i++) {
			if(Alunos.get(i).nMec()==nMec) {
				r= true;
				Alunos.remove(Alunos.get(i)); }
			}
		return r;
		
	}
	
	
	public boolean alunoInscrito(int nMec) {
		
		boolean contains=false;
		
		for(int i=0;i<Alunos.size();i++) {
			if(Alunos.get(i).nMec()==nMec) contains= true;	
		}
		
		return contains;
	}


	public int numAlunos() { return Alunos.size();	}
	
	public String toString() {
		String s=nome+ " ( "+ects+" ECTS ) da area de "+area;
		return s;
		}
	
	public Estudante[] getAlunos() {
		
		Estudante[] a=new Estudante[Alunos.size()];
		
		return Alunos.toArray(a);
	} //DOUBLE CHECK THIS ONE
	
	
	public Estudante[] getAlunos(String tipo) {
		
		ArrayList<Estudante> a= new ArrayList<Estudante>();
				
		for(int i=0;i<Alunos.size();i++) {
			if(Alunos.get(i).getClass().getSimpleName().equalsIgnoreCase(tipo)) a.add(Alunos.get(i));
		}
		
		Estudante[] a2= new Estudante[a.size()];
		a2=a.toArray(a2);
		return a2;
	}
	
}