import static java.lang.System.*;

public class DatasPassadas {

  public static void main(String[] args) {
    Data atual = new Data();
    int dia= atual.dia();
    int mes= atual.mes();
    int ano= atual.ano();
    
    atual.dia=dia;
    atual.mes=mes;
    atual.ano=ano;
    
    Data inicio= new Data(25,12,2017);
        
    while(inicio!=null){ 			//O comando inicio!=atual não estava a funcionar. Não encontrava a igualdade entre datas, só entre os seus componentes
    inicio.seguinte();
    System.out.println(inicio.extenso());
	if(inicio.dia==atual.dia && inicio.mes==atual.mes && inicio.ano==atual.ano){break;}
		}
    //...
  }

}

