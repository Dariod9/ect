import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;


public class Agenda {
	private Tarefa t[]=new Tarefa[1000];
		
	public void novaTarefa(Tarefa a){
							
		for(int i=0;i<this.t.length;i++){
			
			if(this.t[i]==null){
				this.t[i]=a;
				break;
				}
			;
			}
		}
			
	/*  public void sort(Tarefa[] a, int n) {
   
   Data[] datas= new Data[a.length];
   
   for(int u=0;u<datas.length;u++){
	   datas[u]=a[u].inicio;
	   }
   
			for (int i = 0; i < n-1; i++) {
			  for (int j = i+1; j < datas.length; j++) {
				if(datas[j]!=null && datas[i]!=null){
					if (datas[j].compareTo(datas[i])<0) {
						  Data tmp = datas[j];
						  datas[j] = datas[i];
						  datas[i] = tmp;
					}
				}
			  }
			}
		  */
  
		
	  public void escreve (){
		  
		  for(int i=0;i<t.length;i++){
			  if(t[i]!=null){
			  out.printf(t[i].inicio+" "+ t[i].texto+" " + t[i].fim+"\n");
					}
			  }
		  
		  }
		  
		  
	  public boolean intersecta(Tarefa a, Tarefa b){
		
		boolean inter=true;
		int i,i2,i3,i4;
		
		i= a.inicio.compareTo(b.inicio);
		i2=a.inicio.compareTo(b.fim);
		i3=a.fim.compareTo(b.inicio);
		i4=a.fim.compareTo(b.fim);
		
		//if(i<=0 && i3>=0)
		if(i<0 && i3<0) inter=false;
		if(i2>0 && i4>0) inter=false;
	
		return inter;
		} 
		
		
		
	public Agenda filtra(Data a, Data b){
		
		Tarefa[] m=new Tarefa[1000];

		for(int i=0;i<this.t.length;i++){
			if(t[i]!=null && this.t[i].fim.compareTo(a)<0){
				out.println("oi");
				}
			if(t[i]!=null && this.t[i].inicio.compareTo(b)>0){
				out.println("yo");
				}
			else{
				m[i]=t[i];
				}
				
			}
		
		
		Agenda diario = new Agenda();
		
		/*	Tarefa x= new Tarefa(a,b,"oi");
		int n=0;
		
		
		
		while(t[n]!=null && n<=t.length){
			if(intersecta(t[n],x)){
				m[n]=new Tarefa(t[n].inicio,t[n].fim,t[n].texto);
				}
			n++;
		}*/
		
		diario.t=m;
		
		return diario;
	}
			
		 
}

