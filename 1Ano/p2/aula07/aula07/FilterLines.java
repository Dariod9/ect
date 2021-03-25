import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;
// import java.util.*;   // => "error: reference to LinkedList is ambiguous"
// java.util.LinkedList colide com p2utils.LinkedList!
import p2utils.*;

public class FilterLines
{
  public static void main(String[] args) throws IOException
  {
    if (args.length != 1) {
      err.printf("Usage: java -ea FilterLines text-file\n");
      exit(1);
    }
    File fil = new File(args[0]);
    
    LinkedList<String> small = new LinkedList<>();
    LinkedList<String> med = new LinkedList<>();
    LinkedList<String> big = new LinkedList<>();
    

    Scanner sf = new Scanner(fil);
    // exceções poderiam ser intercetadas e mostrar mensagem de erro.
    while (sf.hasNextLine()) {
      String line = sf.nextLine();
      // Guardar linha na lista apropriada, consoante o tamanho.
      //...
		if(line.length()<20){
			small.addLast(line);
			}
		if(line.length()>=20 && line.length()<40){
			med.addLast(line);
			}
		if(line.length()>40){
			big.addLast(line);
			}	

    }
    sf.close();

    // Escrever conteúdo das listas...
    out.println("Curtas---|---------|---------|---------|---------");
	small.print();


    out.println("Médias---|---------|---------|---------|---------");
    med.print();

    out.println("Longas---|---------|---------|---------|---------");
    big.print();
  }

}
