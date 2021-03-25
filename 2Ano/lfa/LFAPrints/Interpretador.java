import java.util.Scanner;

public class Interpretador extends StrBaseVisitor<String> {

    @Override public String visitProgram(StrParser.ProgramContext ctx) { return visitChildren(ctx); }

    @Override public String visitDeclarationStat(StrParser.DeclarationStatContext ctx) { return visitChildren(ctx); }

    @Override public String visitPrintStat(StrParser.PrintStatContext ctx) { return visitChildren(ctx); }


    @Override public String visitDeclaration(StrParser.DeclarationContext ctx) { 
        if(StrParser.mapa.containsKey(ctx.ID().getText())) StrParser.mapa.replace(ctx.ID().getText(), visit(ctx.expr()));
        else StrParser.mapa.put(ctx.ID().getText(), visit(ctx.expr()));
        
        return visitChildren(ctx); }

    @Override public String visitPrint(StrParser.PrintContext ctx) {  System.out.println(visit(ctx.expr())); 
        return visitChildren(ctx);
    }


    @Override public String visitStringExpr(StrParser.StringExprContext ctx) { return ctx.STRING().getText(); }
    

    @Override public String visitMathExpr(StrParser.MathExprContext ctx) { 
        String s1=visit(ctx.e1);
        String s2=visit(ctx.e2);
        if(!s1.contains("\"")){
            if(StrParser.mapa.containsKey(s1)) s1=StrParser.mapa.get(s1);
        }
        
        if(!s2.contains("\"")){
            if(StrParser.mapa.containsKey(s2)) s2=StrParser.mapa.get(s2);
        }

        String s3=s1.replaceAll("\"", "") + s2.replaceAll("\"", "");        
        return s3; }

    @Override public String visitInputExpr(StrParser.InputExprContext ctx) { return visitChildren(ctx); }
        

    @Override public String visitConcatExpr(StrParser.ConcatExprContext ctx) { 
        String s1=visit(ctx.expr());
        String s2=ctx.STRING(0).getText();
        String s3=ctx.STRING(1).getText();
        
        s1=s1.replaceAll("\"","");
        s2=s2.replaceAll("\"","");
        s3=s3.replaceAll("\"","");

        if(s1.contains(s2)){
            s1=s1.replaceAll(s2, s3);
            return s1;
        }

        else System.out.println("String alvo não inclui fator a subsituir!");

        return visitChildren(ctx); }

    @Override public String visitIdExpr(StrParser.IdExprContext ctx) {
        if(StrParser.mapa.containsKey(ctx.ID().getText())) return StrParser.mapa.get(ctx.ID().getText());
        else System.out.println("Variável não registada!");
        return visitChildren(ctx); }

    @Override public String visitInput(StrParser.InputContext ctx) { 
        String s= "\"";
        Scanner sc=new Scanner(System.in);
        s=s+sc.nextLine()+"\"";
        return s; 
    }
}