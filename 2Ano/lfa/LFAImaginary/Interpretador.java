public class Interpretador extends ImagBaseVisitor<Object> {



    @Override public Object visitProgram(ImagParser.ProgramContext ctx) { return visitChildren(ctx); }

    @Override public Object visitDeclarationStat(ImagParser.DeclarationStatContext ctx) { return visitChildren(ctx); }

    @Override public Object visitPrintStat(ImagParser.PrintStatContext ctx) { return visitChildren(ctx); }


    @Override public Object visitDeclaration(ImagParser.DeclarationContext ctx) { 
        if(ImagParser.mapa.containsKey(ctx.ID().getText())) ImagParser.mapa.replace(ctx.ID().getText(), visit(ctx.expr()));
        else ImagParser.mapa.put(ctx.ID().getText(), visit(ctx.expr()));

        return visitChildren(ctx); 
    }

    @Override public Object visitPrint(ImagParser.PrintContext ctx) {
        if(!ImagParser.mapa.containsKey(ctx.ID().getText())) System.out.println("Variável não registada!");
        else{
                if(ImagParser.mapa.get(ctx.ID().getText()) instanceof Point){
                    Point p= (Point) ImagParser.mapa.get(ctx.ID().getText());
                    p.print();
                }
                 else System.out.println(ImagParser.mapa.get(ctx.ID().getText()));
        }

            return visitChildren(ctx); }

    @Override public Object visitDoubleExpr(ImagParser.DoubleExprContext ctx) { return Double.parseDouble(ctx.DOUBLE().getText()); }

    @Override public Object visitIntExpr(ImagParser.IntExprContext ctx) { return Integer.parseInt(ctx.INT().getText()); }


    @Override public Object visitMultExpr(ImagParser.MultExprContext ctx) { 
        if(visit(ctx.e1) instanceof Point && visit(ctx.e2) instanceof Point) {
            Point p1= (Point) visit(ctx.e1);
            Point p2= (Point) visit(ctx.e2);

            System.out.println("Operação inválida");
            return visitChildren(ctx);
        }

        else if(visit(ctx.e1) instanceof Point){
            Point p1= (Point) visit(ctx.e1);

            if(ctx.op.getText().equals("*")) return p1.mult(visit(ctx.e2)+"");
            else return p1.div(visit(ctx.e2)+"");

        }

        else if(visit(ctx.e2) instanceof Point){
            Point p2= (Point) visit(ctx.e1);

            if(ctx.op.getText().equals("*")) return p2.mult(visit(ctx.e1)+"");
            else return p2.div(visit(ctx.e1)+"");

        }

        else {
            String s1=visit(ctx.e1)+"";
            String s2=visit(ctx.e2)+"";
            if(s2.contains(".") || s1.contains(".")){
                if(ctx.op.getText().equals("*")) return Double.parseDouble(s1)*Double.parseDouble(s2);
                else return Double.parseDouble(s1)/Double.parseDouble(s2);
            }

            else{
                if(ctx.op.getText().equals("*")) return Integer.parseInt(s1)*Integer.parseInt(s2);
                else return Integer.parseInt(s1)/Integer.parseInt(s2);
            }
        }
        

    }

    @Override public Object visitAddExpr(ImagParser.AddExprContext ctx) { 
        if(visit(ctx.e1) instanceof Point && visit(ctx.e2) instanceof Point) {
            Point p1= (Point) visit(ctx.e1);
            Point p2= (Point) visit(ctx.e2);

            if(ctx.op.getText().equals("+")) return p1.sum(p2);
            else return p1.sub(p2);
        }

        else if(visit(ctx.e1) instanceof Point){
            Point p1= (Point) visit(ctx.e1);

            if(ctx.op.getText().equals("+")) return p1.sum(visit(ctx.e2)+"");
            else return p1.sub(visit(ctx.e2)+"");

        }

        else if(visit(ctx.e2) instanceof Point){
            Point p2= (Point) visit(ctx.e1);

            if(ctx.op.getText().equals("+")) return p2.sum(visit(ctx.e1)+"");
            else return p2.sub(visit(ctx.e1)+"");

        }

        else {
            String s1=visit(ctx.e1)+"";
            String s2=visit(ctx.e2)+"";
            if(s2.contains(".") || s1.contains(".")){
                if(ctx.op.getText().equals("+")) return Double.parseDouble(s1)+Double.parseDouble(s2);
                else return Double.parseDouble(s1)-Double.parseDouble(s2);
            }

            else{
                if(ctx.op.getText().equals("+")) return Integer.parseInt(s1)+Integer.parseInt(s2);
                else return Integer.parseInt(s1)-Integer.parseInt(s2);
            }
        }
        
    }


    @Override public Object visitParenExpr(ImagParser.ParenExprContext ctx) { return visit(ctx.expr()); }

    @Override public Object visitIdExpr(ImagParser.IdExprContext ctx) {
        if(ImagParser.mapa.containsKey(ctx.ID().getText())) return ImagParser.mapa.get(ctx.ID().getText());
        
        else System.out.println("Variável não existente");

        return visitChildren(ctx); }

    @Override public Object visitPointExpr(ImagParser.PointExprContext ctx) { return visitChildren(ctx); }

    @Override public Object visitOpp(ImagParser.OppContext ctx) {
        try{
            if(ctx.op.getText().equals("-")) return "-";
            else return null;
        }
        catch(Exception e ){
            return null;
        }
    }

    @Override public Object visitPoint(ImagParser.PointContext ctx) { 
        if(visit(ctx.expr(0)) instanceof Point || visit(ctx.expr(1)) instanceof Point ){
            System.out.println("Coordenadas Inválidas");
            return null;
        }
        else{
        
            Double d=0.0;
            Imaginary i=null;
            String s=visit(ctx.opp(0))+"";
            String s1=visit(ctx.opp(1))+"";

            if(s.equals("-")) d=(-1)*Double.parseDouble(visit(ctx.expr(0))+"");
            else d=Double.parseDouble(visit(ctx.expr(0))+"");

            if(s1.equals("-")) i=new Imaginary((-1)*Double.parseDouble(visit(ctx.expr(1))+""));
            else i=new Imaginary(Double.parseDouble(visit(ctx.expr(1))+"")); 
        

            return new Point(d, i);

        }
    }

}