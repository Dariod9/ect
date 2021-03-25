import static java.lang.System.*;
import java.util.Calendar;

public class Data {
  public int dia, mes, ano;

  /** Inicia esta data com o dia de hoje. */
  public Data() {
    Calendar today = Calendar.getInstance();

    dia = today.get(Calendar.DAY_OF_MONTH);
    mes = today.get(Calendar.MONTH) + 1;
    ano = today.get(Calendar.YEAR);
  }

  /** Inicia a data a partir do dia, mes e ano dados. */
  public Data(int dia, int mes, int ano) {
	  this.dia=dia;
	  this.mes=mes;
	  this.ano=ano;
  }

  /** Devolve esta data segundo a norma ISO 8601. */
  public String toString() {
    return String.format("%04d-%02d-%02d", ano, mes, dia);
  }

  public int ano(){
	 return ano;	 
  }
	 
  public int mes(){
     return mes;
  }
 
  public int dia(){
	 return dia;
  }
  /** Indica se ano é bissexto. */
  public static boolean bissexto(int ano) {
    return ano%4 == 0 && ano%100 != 0 || ano%400 == 0;
  }

  // Crie métodos para obter o dia, mes e ano da data.
  //...

  /** Dimensões dos meses num ano comum. */
  private static final
  int[] diasMesComum = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  /** Devolve o número de dias do mês dado. */
  public static int diasDoMes(int mes, int ano) {
   
   int dias;
   
	if(mes==1 || mes==3||mes==5||mes==7||mes==8||mes==10||mes==12){
		dias= diasMesComum[mes-1];
		}
	
	else{
		dias=30;
			if(mes==2){
				if(bissexto(ano)) dias=29;
				else dias=28;				
				}
		
		}
		
    return dias;
  }


 private static final
  String[] nomesMesComum = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};

  /** Devolve o mes da data por extenso. */
  public String mesExtenso() {
    return nomesMesComum[mes-1];
  }


  /** Devolve esta data por extenso. */
  public String extenso() {
    String s=dia+" de "+nomesMesComum[mes-1]+" de "+ano;
    return s;
  }

  /** Indica se um terno (dia, mes, ano) forma uma data válida. */
  public static boolean dataValida(int dia, int mes, int ano) {
	  boolean data=true;
	  
	  if(dia<1 || dia>31) data=false;
	  if(mes<1 || mes>12) data=false;
	  if(dia!=diasDoMes(mes,ano)) data=false;
	  	  
    return data;
  }


   public void seguinte() {
         
    if(dataValida(dia+1,mes,ano)){
		dia=dia+1;
		}
	else if(dataValida(1,mes+1,ano)){
		dia=1;
		mes=mes+1;
		}
	else if(dataValida(1,1,ano+1)){
		dia=1;
		mes=1;
		ano=ano+1;		
		}

		assert dataValida(dia,mes,ano);


	}
}

