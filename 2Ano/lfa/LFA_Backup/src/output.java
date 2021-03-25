import Gramatica.Tabela;
import Gramatica.tabela2;

public class output {
   public static void main(String[] args) {
       Integer x1;  
       x1 = 3 ;
       Integer x2;  
       x2 = 5 ;
       x1 = 2 + x2 ;
       System.out.print(x1+"\n"); 
       Tabela t1;  
       t1 = new Tabela("Tabela ",4,4) ;
       t1.add(2,3,x1); 
       t1.add(1,1,x2); 
       t1.print(); 
       t1.addRow(2);
       t1.addRow();
       t1.addColumn(3);
       Tabela t3;  
       t3 = t1 ;
       t3.print(); 
       t1.printRow(1); 
       t1.printColumn(2); 
       Double d;  
       d = 4.5 ;
       t1.add(1,2,d); 
       String s;  
       s = "Testes!" ;
       t1.add(4,4,s); 
       Tabela t2;  
       t2 = new Tabela("Tabela ",3,3) ;
       t2.print(); 
       t1.print(); 
       t1.deleteRow(2); 
       t1.deleteColumn(4); 
       t1.print(); 
   }
}
