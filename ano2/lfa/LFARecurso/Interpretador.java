
public class Interpretador extends VectorBaseVisitor<Object> {


    @Override public Object visitProgram(VectorParser.ProgramContext ctx) { return visitChildren(ctx); }

    @Override public Object visitDeclarationStat(VectorParser.DeclarationStatContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitShowStat(VectorParser.ShowStatContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitDeclaration(VectorParser.DeclarationContext ctx) {
        
        if(VectorParser.mapa.containsKey(ctx.ID().getText())) VectorParser.mapa.replace(ctx.ID().getText(),visit(ctx.expr()));

        else VectorParser.mapa.put(ctx.ID().getText(),visit(ctx.expr()));

        return visitChildren(ctx); }
    
    @Override public Object visitShowID(VectorParser.ShowIDContext ctx) { 
    
        if(!VectorParser.mapa.containsKey(ctx.ID().getText())) System.out.println("Variável não registada!");

        else if(VectorParser.mapa.get(ctx.ID().getText()) instanceof Vec ){
            Vec v= (Vec) VectorParser.mapa.get(ctx.ID().getText()); 
            v.print();
        }
        else System.out.println(VectorParser.mapa.get(ctx.ID().getText()));

        return visitChildren(ctx); 
    
    }
    
    @Override public Object visitShowExpr (VectorParser.ShowExprContext ctx) { 

        if(visit(ctx.expr()) instanceof Vec){
            Vec v= (Vec) visit(ctx.expr());
            v.print();;
        }

        else System.out.println(visit(ctx.expr()));

        return visitChildren(ctx); 
    
    }

    @Override public Object visitExprParen(VectorParser.ExprParenContext ctx) {

        return visit(ctx.expr());
        }

    @Override public Object visitExprMult(VectorParser.ExprMultContext ctx) { 
        
        if(ctx.op.getText().equals("*")){
            if(visit(ctx.e1) instanceof Vec && visit(ctx.e2) instanceof Vec){
                Vec v1=(Vec) visit(ctx.e1);
                Vec v2=(Vec) visit(ctx.e2);
                return v1.mult(v2);
            }

            else if(visit(ctx.e1) instanceof Vec){
                Vec v=(Vec) visit(ctx.e1);

                return v.mult(Double.parseDouble(visit(ctx.e2)+""));
            }

            else if(visit(ctx.e2) instanceof Vec){
                Vec v= (Vec) visit(ctx.e2); 
                return v.mult(Double.parseDouble(visit(ctx.e1)+""));
            }

            else{
                 return Double.parseDouble(visit(ctx.e1)+"") * Double.parseDouble(visit(ctx.e2)+"");}
        }

        else {
            if(visit(ctx.e1) instanceof Vec && visit(ctx.e2) instanceof Vec){
                Vec v1=(Vec) visit(ctx.e1);
                Vec v2=(Vec) visit(ctx.e2);
                return v1.div(v2);
            }

            else if(visit(ctx.e1) instanceof Vec){
                Vec v=(Vec) visit(ctx.e1);

                return v.mult(Double.parseDouble(visit(ctx.e2)+""));
            }

            else if(visit(ctx.e2) instanceof Vec){
                Vec v= (Vec) visit(ctx.e2); 
                return v.mult(Double.parseDouble(visit(ctx.e1)+""));
            }

            else{
                 return Double.parseDouble(visit(ctx.e1)+"") * Double.parseDouble(visit(ctx.e2)+"");}
        }
        
    
    }

    @Override public Object visitExprSum(VectorParser.ExprSumContext ctx) { 
        
        if(ctx.op.getText().equals("+")){
            if(visit(ctx.e1) instanceof Vec && visit(ctx.e2) instanceof Vec){
                Vec v1=(Vec) visit(ctx.e1);
                Vec v2=(Vec) visit(ctx.e2);
                return v1.sum(v2);
            }

            else if(visit(ctx.e1) instanceof Vec || visit(ctx.e2) instanceof Vec){
                System.out.println("Parametros inválidos");
                return null;
            }

            else{
                 return Double.parseDouble(visit(ctx.e1)+"") + Double.parseDouble(visit(ctx.e2)+"");}
        }

        else {
            if(visit(ctx.e1) instanceof Vec && visit(ctx.e2) instanceof Vec){
                Vec v1=(Vec) visit(ctx.e1);
                Vec v2=(Vec) visit(ctx.e2);
                return v1.sub(v2);
            }

            else if(visit(ctx.e1) instanceof Vec || visit(ctx.e2) instanceof Vec){
                System.out.println("Parametros inválidos");
                return null;
            }

            else{
                 return Double.parseDouble(visit(ctx.e1)+"") - Double.parseDouble(visit(ctx.e2)+"");}
        }
        
    }

    @Override public Object visitExprID(VectorParser.ExprIDContext ctx) {
        return VectorParser.mapa.get(ctx.ID().getText()); 
        }
	

    @Override public Object visitExprVec(VectorParser.ExprVecContext ctx) { return visitChildren(ctx); }
    
    @Override public Object visitExprDouble(VectorParser.ExprDoubleContext ctx) {
         return Double.parseDouble(ctx.DOUBLE().getText()); }
    
    @Override public Object visitExprInt(VectorParser.ExprIntContext ctx) {
         return Double.parseDouble(ctx.INT().getText()); }
    
    @Override public Object visitVec(VectorParser.VecContext ctx) {
        Vec v=new Vec();

        if(ctx.num().getText().contains(",")){
            String[] arr= ctx.num().getText().split(",");
            for(int i=0;i<arr.length;i++){
                v.add(arr[i]);
            }
        }

        else v.add(ctx.num().getText());

        return v; }
    
    @Override public Object visitProgressiveNum(VectorParser.ProgressiveNumContext ctx) {
         return ctx.num(0).getText()+","+ctx.num(1).getText() ; }
    
    @Override public Object visitDoubleNum(VectorParser.DoubleNumContext ctx) {
         return Double.parseDouble(ctx.DOUBLE().getText()); }
    
    @Override public Object visitIntNum(VectorParser.IntNumContext ctx) { 
        return Double.parseDouble(ctx.INT().getText()); }
    
}