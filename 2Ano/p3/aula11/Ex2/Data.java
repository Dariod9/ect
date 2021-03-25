package aula11.Ex2;

import java.util.GregorianCalendar;

public class Data{
	
	private int dia;
	private int mes;
	private int ano;
	
	public Data(int dia, int mes, int ano){
		this.dia=dia;
		this.mes=mes;
		this.ano=ano;
	}
	
	public boolean validate(){
		if(dia<1 || mes<1 || ano<1) return false;
		else return true;
	}
	
	public static Data getToday(){
		GregorianCalendar cal= new GregorianCalendar();
		
		return new Data(cal.get(cal.DAY_OF_MONTH),cal.get(cal.MONTH),cal.get(cal.YEAR));
	}
	
	public int dia(){ return dia;}
	public int mes(){ return mes;}
	public int ano(){ return ano;}
	
	@Override
	public String toString(){
		String  s="Data:"+dia+"/"+mes+"/"+ano;
		return s;
	}
}