package aula5.Ex3;

public class Data {
	private int dia;
	private int mes;
	private int ano;

  /** Inicia a data a partir do dia, mes e ano dados. */
  public Data(int dia, int mes, int ano) {
	  this.dia=dia;
	  this.mes=mes;
	  this.ano=ano;
  }
  
  public int dia(){
	  return dia; }
  
  public int mes(){
	  return mes; }
  
  public int ano(){
	  return ano; }
}