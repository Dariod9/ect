import java.util.Scanner;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class ImagMain {
   public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(new File(args[0]));
      String lineText = null;
      int lineNum = 1;
      if (sc.hasNextLine())
         lineText = sc.nextLine();
      ImagParser parser = new ImagParser(null);
      // replace error listener:
      //parser.removeErrorListeners(); // remove ConsoleErrorListener
      //parser.addErrorListener(new ErrorHandlingListener());
      Interpretador visitor0 = new Interpretador();
      while(lineText != null) {
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromString(lineText + "\n");
         // create a lexer that feeds off of input CharStream:
         ImagLexer lexer = new ImagLexer(input);
         lexer.setLine(lineNum);
         lexer.setCharPositionInLine(0);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         parser.setInputStream(tokens);
         // begin parsing at program rule:
         ParseTree tree = parser.program();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            visitor0.visit(tree);
         }
         if (sc.hasNextLine())
            lineText = sc.nextLine();
         else
            lineText = null;
         lineNum++;
      }
   }
}
