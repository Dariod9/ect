import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class gramMain {
   public static void main(String[] args) throws Exception {
      InputStream in_stream = null;
      try
      { in_stream = new FileInputStream(new File("numbers.txt")); }
      catch(FileNotFoundException e)
      { err.println("ERROR: reading number file!"); System.exit(1); }
      // create a CharStream that reads from in_stream:
      ANTLRInputStream input = new ANTLRInputStream(in_stream);
      // create a lexer that feeds off of input CharStream:
      gramLexer lexer = new gramLexer(input);
      // create a buffer of tokens pulled from the lexer:
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      // create a parser that feeds off the tokens buffer:
      gramParser parser = new gramParser(tokens);
      // replace error listener:
      //parser.removeErrorListeners(); // remove ConsoleErrorListener
      //parser.addErrorListener(new ErrorHandlingListener());
      // begin parsing at pro rule:
      ParseTree tree = parser.pro();
      if (parser.getNumberOfSyntaxErrors() == 0) {
         // print LISP-style tree:
         // System.out.println(tree.toStringTree(parser));
         // System.out.println(tree.toStringTree(parser));
         ParseTreeWalker walker = new ParseTreeWalker();
         ConstructGramMap mappings = new ConstructGramMap();
         walker.walk(mappings,tree);

         Scanner in = new Scanner(System.in);
         while(in.hasNextLine())
         {
         String line = in.nextLine();
         String[] words = line.replace('-',' ').toLowerCase().split(" ");
         for(int i = 0;i < words.length;i++)
         {
         if(i != 0) out.print(" ");
         if(mappings.exists(words[i]))
         out.print(mappings.value(words[i]).toString());
         else
         out.print(words[i]);
         }
         out.println();
         }
      }
   }
}
