
public class CalcInter extends CalcBaseVisitor<Object> {



    @Override public Object visitProgram(CalcParser.ProgramContext ctx) {
        
        return visitChildren(ctx); 
        }

    @Override public Object visitDeclarationStat(CalcParser.DeclarationStatContext ctx) {
        
        return visitChildren(ctx); 
        }

    @Override public Object visitShowStat(CalcParser.ShowStatContext ctx) {

        return visitChildren(ctx); 
    }

    @Override public Object visitDeclaration(CalcParser.DeclarationContext ctx) { 
        if(CalcParser.mapa.containsKey(ctx.ID().getText())) CalcParser.mapa.replace(ctx.ID().getText(), visit(ctx.expr()));

        else CalcParser.mapa.put(ctx.ID().getText(), visit(ctx.expr()));

        return visitChildren(ctx); 
    }

    @Override public Object visitShow(CalcParser.ShowContext ctx) {
        System.out.println(visit(ctx.expr()));
        return visitChildren(ctx); 
    }
    
    @Override public Object visitDoubleExpr(CalcParser.DoubleExprContext ctx) {
         return Double.parseDouble(ctx.DOUBLE().getText()); }

    @Override public Object visitIntExpr(CalcParser.IntExprContext ctx) {
         return Integer.parseInt(ctx.INT().getText()); }

    @Override public Object visitAddExpr(CalcParser.AddExprContext ctx) {
        String s1=visit(ctx.e1)+"";
        String s2=visit(ctx.e2)+"";
        
        if(ctx.op.getText().equals("+")){

             if(s1.contains(".") || s2.contains(".")) {
                
                    return Double.parseDouble(s1)+Double.parseDouble(s2);
                }
            
            else return Integer.parseInt(s1)+Integer.parseInt(s2);
    
        }

        else{

             if(s1.contains(".") || s2.contains(".")) {

                return Double.parseDouble(s1)-Double.parseDouble(s2);
            }
        
        else return Integer.parseInt(s1)-Integer.parseInt(s2);


        }

    }

    @Override public Object visitParenExpr(CalcParser.ParenExprContext ctx) { return visit(ctx.expr()); }
	

    @Override public Object visitMultExpr(CalcParser.MultExprContext ctx) { 
        String s1=visit(ctx.e1)+"";
        String s2=visit(ctx.e2)+"";

        if(ctx.op.getText().equals("*")){


             if(s1.contains(".") || s2.contains(".")) {

                    return Double.parseDouble(s1)*Double.parseDouble(s2);
                }
            
            else return Integer.parseInt(s1)*Integer.parseInt(s2);
    
        }

        else{

             if(s1.contains(".") || s2.contains(".")) {

                return Double.parseDouble(s1)/Double.parseDouble(s2);
            }
        
        else return Integer.parseInt(s1)/Integer.parseInt(s2);


        }
    }
    @Override public Object visitIdExpr(CalcParser.IdExprContext ctx) {
        if(CalcParser.mapa.containsKey(ctx.ID().getText())){
            return CalcParser.mapa.get(ctx.ID().getText());
        }

        else return null;
        }

}