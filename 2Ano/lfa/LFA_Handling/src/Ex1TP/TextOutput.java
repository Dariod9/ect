package Ex1TP;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class TextOutput extends TextManBaseVisitor<String>{

    public HashMap<String,String> map;

    public TextOutput() {
        this.map=new HashMap<>();
    }


    @Override
    public String visitProgram(TextManParser.ProgramContext ctx)
    {
        String res = "";
        Iterator<TextManParser.LineContext> iter = ctx.line().iterator();
        while(iter.hasNext())
            res += visit(iter.next()) + "\n";
        return res;
    }


    @Override
    public String visitDecLine(TextManParser.DecLineContext ctx) {
        return visit(ctx.dec());
    }

    @Override
    public String visitPrintLine(TextManParser.PrintLineContext ctx) {
        return visit(ctx.print());
    }

    @Override
    public String visitPrintInput(TextManParser.PrintInputContext ctx) {
        Scanner sc= new Scanner(System.in);
        String word= sc.nextLine();
        return word;
    }

    @Override
    public String visitIDInput(TextManParser.IDInputContext ctx) {
        Scanner sc= new Scanner(System.in);
        String word= sc.nextLine();
        map.put(ctx.ID().getText(),word);
        return "Done";
    }

    @Override
    public String visitInputLine(TextManParser.InputLineContext ctx) {
        return super.visitInputLine(ctx);
    }

    @Override
    public String visitDec(TextManParser.DecContext ctx) {
        map.put(ctx.ID().getText(),ctx.STRING().getText());
        return "Inserted";
    }

    @Override
    public String visitPrintID(TextManParser.PrintIDContext ctx) {
        if(map.containsKey(ctx.ID().getText())) return map.get(ctx.ID().getText());
        else return ctx.ID().getText();
    }

    @Override
    public String visitPrintString(TextManParser.PrintStringContext ctx) {
        return ctx.STRING().getText();
    }


}
