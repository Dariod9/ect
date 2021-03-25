import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class ListRec {

  public static void main(String[] args) {
    
    ListRec(args[0]);
    
      }


  /** Imprime as N primeiras strings do array, uma por linha. */
  public static void ListRec(String string) {
    // Implemente de forma recursiva...
	
	int n;
	
	File f= new File("string");
	
	assert f.isFile();
	
	File[] a=f.listFiles();
	
	//IMprimir os subdirect do primeiro sub direct, recursivamente
	//USar n para imprimir o diretório da 1 pasta, ate que o n<a.length()
	
		  }

}
