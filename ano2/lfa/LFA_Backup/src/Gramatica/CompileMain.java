package Gramatica;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.stringtemplate.v4.ST;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.err;
import static java.lang.System.exit;

public class CompileMain {
    public static void main(String[] args) throws Exception {

        // create a CharStream that reads from standard input:
        CharStream input = CharStreams.fromStream(new FileInputStream(args[0]));
        // create a lexer that feeds off of input CharStream:
        tableGramLexer lexer = new tableGramLexer(input);
        // create a buffer of tokens pulled from the lexer:
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer:
        tableGramParser parser = new tableGramParser(tokens);
        // replace error listener:
        //parser.removeErrorListeners(); // remove ConsoleErrorListener
        //parser.addErrorListener(new ErrorHandlingListener());
        // begin parsing at main rule:
        ParseTree tree = parser.main();
            System.out.println(args[0] + " is correct");
            if (parser.getNumberOfSyntaxErrors() == 0) {
                // print LISP-style tree:
                // System.out.println(tree.toStringTree(parser));
                tableGramSemanticCheck visitor0 = new tableGramSemanticCheck();
                tableCompiler visitor1 = new tableCompiler();
                visitor0.visit(tree);
                if(!ErrorHandling.error()){
                    ST code = (ST) visitor1.visit(tree);
                    code.add("name","output");
                    PrintWriter pw = new PrintWriter(new File("output.java"));
                    pw.print(code.render());
                    pw.close();

                }
            }
    }
}
