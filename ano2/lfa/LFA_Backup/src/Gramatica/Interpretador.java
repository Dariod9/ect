package Gramatica;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Interpretador extends tableGramBaseVisitor<Variable>  {

        @Override
        public Variable visitMain(tableGramParser.MainContext ctx) {
            return visitChildren(ctx);
        }

        @Override
        public Variable visitDeclareStat(tableGramParser.DeclareStatContext ctx) {
            return super.visitDeclareStat(ctx);
        }

        @Override
        public Variable visitAtrStat(tableGramParser.AtrStatContext ctx) {
            return super.visitAtrStat(ctx);
        }

        @Override
        public Variable visitMethodStat(tableGramParser.MethodStatContext ctx) {
            return super.visitMethodStat(ctx);
        }





        @Override
        public Variable visitDeclaracao(tableGramParser.DeclaracaoContext ctx) {
                if(ctx.tipo().getText().equals("String")){

                    Variable<String> var=new Variable<>("String",null);

                    tableGramParser.mapa.put(ctx.ID().getText(),var);
                    return visitChildren(ctx);
                }

            else if(ctx.tipo().getText().equals("int")){

                    Variable<Integer> var=new Variable<>("Integer",null);

                    tableGramParser.mapa.put(ctx.ID().getText(),var);

                    return visitChildren(ctx);
                }

            else if(ctx.tipo().getText().equals("double")){
                    Variable<Double> var=new Variable<>("Double",null);
                    tableGramParser.mapa.put(ctx.ID().getText(),var);

                    return visitChildren(ctx);
                }

            else if(ctx.tipo().getText().equals("table")){
                    Variable<Tabela> var=new Variable<>("Tabela",null);
                    tableGramParser.mapa.put(ctx.ID().getText(),var);
                  //  tableGramParser.tables.add(var);
                    return visitChildren(ctx);
                }

            else
            System.out.println("Impossivel");
            return super.visitDeclaracao(ctx);
        }




        @Override
        public Variable visitStringDeclaring(tableGramParser.StringDeclaringContext ctx) {
            return super.visitStringDeclaring(ctx);
        }

        @Override
        public Variable visitIntDeclaring(tableGramParser.IntDeclaringContext ctx) {
            return super.visitIntDeclaring(ctx);
        }

        @Override
        public Variable visitDoubleDeclaring(tableGramParser.DoubleDeclaringContext ctx) {
            return super.visitDoubleDeclaring(ctx);
        }

        @Override
        public Variable visitTableDeclaring(tableGramParser.TableDeclaringContext ctx) {
            return super.visitTableDeclaring(ctx);
        }




        @Override
        public Variable visitAtribuicao(tableGramParser.AtribuicaoContext ctx) {

            if(!tableGramParser.mapa.containsKey(ctx.ID().getText())){

                tableGramParser.mapa.put(ctx.ID().getText(),visit(ctx.expr()));
            }

            else{
                if(tableGramParser.mapa.get(ctx.ID().getText()).getType().equals("String") &&
                        visit(ctx.expr()).getType().equals("String"))

                    tableGramParser.mapa.replace(ctx.ID().getText(),visit(ctx.expr()));
                else if(tableGramParser.mapa.get(ctx.ID().getText()).getType().equals("Integer") &&
                        visit(ctx.expr()).getType().equals("Integer"))

                    tableGramParser.mapa.replace(ctx.ID().getText(),visit(ctx.expr()));

                else if(tableGramParser.mapa.get(ctx.ID().getText()).getType().equals("Double") &&
                        visit(ctx.expr()).getType().equals("Double"))

                    tableGramParser.mapa.replace(ctx.ID().getText(),visit(ctx.expr()));

                else if(tableGramParser.mapa.get(ctx.ID().getText()).getType().equals("Tabela") &&
                        visit(ctx.expr())!=null &&
                        visit(ctx.expr()).getType().equals("Tabela")) {


                        tableGramParser.tables.add(new Variable(ctx.ID().getText(),visit(ctx.expr()).getValue()));
                        tableGramParser.mapa.replace(ctx.ID().getText(), visit(ctx.expr()));

                    }

                else if(tableGramParser.mapa.get(ctx.ID().getText()).getType().equals("Tabela2") &&
                        visit(ctx.expr())!=null &&
                        visit(ctx.expr()).getType().equals("Tabela2")) {
                    tableGramParser.tables.add(new Variable(ctx.ID().getText(),visit(ctx.expr()).getValue()));
                }
                else System.out.println("Tipos não correspondentes");
            }


           return visitChildren(ctx);
        }



        @Override
        public Variable visitMethod(tableGramParser.MethodContext ctx) {
            return super.visitMethod(ctx);
        }

        @Override
        public Variable visitNumExpression(tableGramParser.NumExpressionContext ctx) {
            return super.visitNumExpression(ctx);
        }

        @Override
        public Variable visitStringGet(tableGramParser.StringGetContext ctx) {
            return super.visitStringGet(ctx);
        }



		/*
        @Override
        public Variable visitMath(tableGramParser.MathContext ctx) {
            Variable var;

            if(ctx.op.getText().equals("+")){
                double d1=Double.parseDouble(ctx.e1.getText());
                double d2=Double.parseDouble(ctx.e2.getText());
                var=new Variable("Double",d1+d2);
                return var;
            }

            else if(ctx.op.getText().equals("-")){
                double d1=Double.parseDouble(ctx.e1.getText());
                double d2=Double.parseDouble(ctx.e2.getText());
                var = new Variable("Double",d1-d2);
                return var;
            }

            else if(ctx.op.getText().equals("*")){
                double d1=Double.parseDouble(ctx.e1.getText());
                double d2=Double.parseDouble(ctx.e2.getText());
                var = new Variable("Double",d1*d2);
                return var;
            }

            else if(ctx.op.getText().equals("/")){
                double d1=Double.parseDouble(ctx.e1.getText());
                double d2=Double.parseDouble(ctx.e2.getText());
                var = new Variable("Double",d1/d2);
                return var;
            }

            else return new Variable("Double",0);
        }
		*/

		@Override public Variable visitMultDivMath(tableGramParser.MultDivMathContext ctx) { return visitChildren(ctx); }
	
		@Override public Variable visitAddSubMath(tableGramParser.AddSubMathContext ctx) { return visitChildren(ctx); }
	
		@Override public Variable visitParenMath(tableGramParser.ParenMathContext ctx) { return visitChildren(ctx); }
	
        @Override
        public Variable visitIntMath(tableGramParser.IntMathContext ctx) {
            return new Variable("Integer",Integer.parseInt(ctx.INT().getText()));
        }

        @Override
        public Variable visitDoubleMath(tableGramParser.DoubleMathContext ctx) {
            return new Variable("Double",Double.parseDouble(ctx.DOUBLE().getText()));
        }

        @Override
        public Variable visitStringExpr(tableGramParser.StringExprContext ctx) {
            return new Variable("String", ctx.STRING().getText());
        }



        @Override
        public Variable visitNewTableMethod(tableGramParser.NewTableMethodContext ctx) {
            return super.visitNewTableMethod(ctx);
        }

        @Override
        public Variable visitCopyTableMethod(tableGramParser.CopyTableMethodContext ctx) {
            return super.visitCopyTableMethod(ctx);
        }

        @Override
        public Variable visitReadTableMethod(tableGramParser.ReadTableMethodContext ctx) {
            return super.visitReadTableMethod(ctx);
        }

        @Override
        public Variable visitGetElemMethod(tableGramParser.GetElemMethodContext ctx) {
            return super.visitGetElemMethod(ctx);
        }

        @Override
        public Variable visitRemoveTableMethod(tableGramParser.RemoveTableMethodContext ctx) {
            return super.visitRemoveTableMethod(ctx);
        }

        @Override
        public Variable visitAddRowMethod(tableGramParser.AddRowMethodContext ctx) {
            return super.visitAddRowMethod(ctx);
        }

        @Override
        public Variable visitCopyRowMethod(tableGramParser.CopyRowMethodContext ctx) {
            return super.visitCopyRowMethod(ctx);
        }

        @Override
        public Variable visitNewRowMethod(tableGramParser.NewRowMethodContext ctx) {
            return super.visitNewRowMethod(ctx);
        }

        @Override
        public Variable visitClearRowMethod(tableGramParser.ClearRowMethodContext ctx) {
            return super.visitClearRowMethod(ctx);
        }

        @Override
        public Variable visitAddColumnMethod(tableGramParser.AddColumnMethodContext ctx) {
            return super.visitAddColumnMethod(ctx);
        }

        @Override
        public Variable visitNewColumnMethod(tableGramParser.NewColumnMethodContext ctx) {
            return super.visitNewColumnMethod(ctx);
        }

        @Override
        public Variable visitClearColumnMethod(tableGramParser.ClearColumnMethodContext ctx) {
            return super.visitClearColumnMethod(ctx);
        }

        @Override
        public Variable visitPrintTableMethod(tableGramParser.PrintTableMethodContext ctx) {
            return super.visitPrintTableMethod(ctx);
        }

        @Override
        public Variable visitPrintRowMethod(tableGramParser.PrintRowMethodContext ctx) {
            return super.visitPrintRowMethod(ctx);
        }

        @Override
        public Variable visitPrintColumnMethod(tableGramParser.PrintColumnMethodContext ctx) {
            return super.visitPrintColumnMethod(ctx);
        }

        @Override
        public Variable visitExportMethod(tableGramParser.ExportMethodContext ctx) {
            return super.visitExportMethod(ctx);
        }



        @Override
        public Variable visitCreateDefaultTable(tableGramParser.CreateDefaultTableContext ctx) {
            Tabela t= new Tabela("Tabela");

            return new Variable("Tabela",t);
        }

        @Override
        public Variable visitCreateCustomTable(tableGramParser.CreateCustomTableContext ctx) {
            int a= Integer.parseInt(ctx.INT(0).getText());
            int b= Integer.parseInt(ctx.INT(1).getText());

            Tabela t= new Tabela("Tabela",a,b);

            return new Variable("Tabela",t);
        }

        @Override
        public Variable visitCopyTable(tableGramParser.CopyTableContext ctx) {
            Variable ret;
            if(tableGramParser.mapa.containsKey(ctx.ID().getText())) {
                ret = tableGramParser.mapa.get(ctx.ID().getText());
                return ret;
            }

            else{
                return null;
            }

        }



        @Override
        public Variable visitInsertElemMethod(tableGramParser.InsertElemMethodContext ctx) {
            return super.visitInsertElemMethod(ctx);
        }

        @Override
        public Variable visitInsertElem1(tableGramParser.InsertElem1Context ctx) {
            Tabela t=null;

            if(tableGramParser.mapa.containsKey(ctx.ID(0).getText()) &&
                    tableGramParser.mapa.get(ctx.ID(0).getText()).getValue()!=null &&
                    tableGramParser.mapa.containsKey(ctx.ID(1).getText()) &&
                    tableGramParser.mapa.get(ctx.ID(1).getText()).getValue()!= null){

                t= (Tabela) tableGramParser.mapa.get(ctx.ID(1).getText()).getValue();

                t.add(Integer.parseInt(ctx.INT(0).getText()),Integer.parseInt(ctx.INT(1).getText()),tableGramParser.mapa.get(ctx.ID(0).getText()).getValue());
            }

            else System.out.println("Variáveis não válidas");

            return super.visitInsertElem1(ctx);
        }

        @Override
    public Variable visitInsertElem2(tableGramParser.InsertElem2Context ctx) {
		tabela2 t= null;
		if(tableGramParser.mapa.containsKey(ctx.ID(0).getText()) &&
                tableGramParser.mapa.get(ctx.ID(0).getText()).getValue()!=null &&
                tableGramParser.mapa.containsKey(ctx.ID(3).getText()) &&
                tableGramParser.mapa.get(ctx.ID(3).getText()).getValue()!= null){

            t= (tabela2) tableGramParser.mapa.get(ctx.ID(1).getText()).getValue();

            t.setData(ctx.ID(1).getText(),ctx.ID(2).getText(),tableGramParser.mapa.get(ctx.ID(1).getText()).getValue());
        }

        else System.out.println("Variáveis não válidas");
        
        return super.visitInsertElem2(ctx);
    }


        @Override
        public Variable visitRemoveElemMethod(tableGramParser.RemoveElemMethodContext ctx) {
            return super.visitRemoveElemMethod(ctx);
        }

        @Override
        public Variable visitRemoveElem1(tableGramParser.RemoveElem1Context ctx) {
            Tabela t=null;

            if(tableGramParser.mapa.containsKey(ctx.ID().getText()) &&
                    tableGramParser.mapa.get(ctx.ID().getText()).getValue()!=null){

                t= (Tabela) tableGramParser.mapa.get(ctx.ID().getText()).getValue();
                t.delete(Integer.parseInt(ctx.INT(0).getText()), Integer.parseInt(ctx.INT(1).getText()));

            }



            return super.visitRemoveElem1(ctx);
        }

//FALTA o 2

        @Override
        public Variable visitGetElem1(tableGramParser.GetElem1Context ctx) {
            Tabela t;
            Variable v = null;
            if(tableGramParser.mapa.containsKey(ctx.ID().getText())){

                if(tableGramParser.mapa.get(ctx.ID().getText()).getType().equals("Tabela")) {
                    t = (Tabela) tableGramParser.mapa.get(ctx.ID().getText()).getValue();
                    v= new Variable("Elemento",t.get(Integer.parseInt(ctx.INT(0).getText()), Integer.parseInt(ctx.INT(1).getText())));
                }

                else System.out.println("O elemento referido não é uma tabela");
                }

            else System.out.println("Tabela não existente");

            return v;
        }

        @Override
    public Variable visitGetElem2(tableGramParser.GetElem2Context ctx) {
        tabela2 t=null;
        Variable v = null;
        if(tableGramParser.mapa.containsKey(ctx.ID(2).getText())){

            if(tableGramParser.mapa.get(ctx.ID(2).getText()).getType().equals("Tabela2")) {
                t = (tabela2) tableGramParser.mapa.get(ctx.ID(2).getText()).getValue();
                v= new Variable("Elemento",t.getElem(ctx.ID(0).getText(), ctx.ID(1).getText()));
            }

            else System.out.println("O elemento referido não é uma tabela");
            }

        else System.out.println("Tabela não existente");

        return v;
    }



   /* @Override public Variable visitRead1(tableGramParser.Read1Context ctx) {
        String s=ctx.ID().getText()+".csv";
        Tabela t=null;
        //throw IOException;
        int maxL=0;
        int maxC=0;


        try {
            File inputFile = new File(s);

            Scanner sc= new Scanner(inputFile);

            while(sc.hasNextLine()){
                String[] array= sc.nextLine().split(",");
                if(array.length>maxC) maxC=array.length;
                maxL++;
            }

            sc.close();


            t= new Tabela(s+"", maxC,maxL);

            Scanner sc2 = new Scanner(inputFile);

            int linha=1;

            while (sc2.hasNextLine()){
                String[] array= sc2.nextLine().split(",");
                for(int i=1;i<=array.length;i++) t.add(i,linha,array[i-1]);

                linha++;

            }

            sc2.close();

        }
        catch (IOException e) {
            System.out.print("Ficheiro não existente");
        }



        return new Variable("Tabela",t);
    }
*/
    @Override public Variable visitRead2(tableGramParser.Read2Context ctx) { return visitChildren(ctx); }


        @Override
        public Variable visitRemoveTable(tableGramParser.RemoveTableContext ctx) {
            Tabela t1=null;
			tabela2 t2=null;
            if(tableGramParser.mapa.containsKey(ctx.ID().getText())){
				try{
					t1 = (Tabela) tableGramParser.mapa.get(ctx.ID().getText()).getValue();
					if(tableGramParser.tables.contains(t1))
                    tableGramParser.tables.remove(t1);
					
				}catch(Exception e){}
				try{
					t2 = (tabela2) tableGramParser.mapa.get(ctx.ID().getText()).getValue();
					if(tableGramParser.tables.contains(t2))
                    tableGramParser.tables.remove(t2);
					
				}catch(Exception e){}
				tableGramParser.mapa.remove(ctx.ID().getText());
                
            }

            else System.out.println("Tabela não existente");


            return super.visitRemoveTable(ctx);
        }


        @Override
        public Variable visitCopyColumnMethod(tableGramParser.CopyColumnMethodContext ctx) {
            return super.visitCopyColumnMethod(ctx);
        }

        @Override
        public Variable visitAddRow1(tableGramParser.AddRow1Context ctx) {
            /*Tabela t1,t2 = null;

            if(tableGramParser.mapa.containsKey(ctx.ID(0).getText()) && tableGramParser.mapa.containsKey(ctx.ID(1).getText())) {
                if (tableGramParser.mapa.get(ctx.ID(0).getText()).getValue() != null
                        && tableGramParser.mapa.get(ctx.ID(1).getText()).getValue() != null)

                t1=(Tabela) tableGramParser.mapa.get(ctx.ID(0).getText()).getValue();
                t2=(Tabela) tableGramParser.mapa.get(ctx.ID(1).getText()).getValue();


            }*/
            return super.visitAddRow1(ctx);
        }


    @Override
    public Variable visitCreateType2Table(tableGramParser.CreateType2TableContext ctx) {
		tabela2 t2= new tabela2(ctx.ID().getText());
		
        return new Variable("Tabela2",t2);
    }

    @Override
    public Variable visitRemoveElem2(tableGramParser.RemoveElem2Context ctx) {
		
		tabela2 t=null;

            if(tableGramParser.mapa.containsKey(ctx.ID(2).getText()) &&
                    tableGramParser.mapa.get(ctx.ID(2).getText()).getValue()!=null){

                t= (tabela2) tableGramParser.mapa.get(ctx.ID(2).getText()).getValue();
                t.setData(ctx.ID(0).getText(), ctx.ID(1).getText(),null);

            }
        return super.visitRemoveElem2(ctx);
    }

    @Override
    public Variable visitNewRowTable2(tableGramParser.NewRowTable2Context ctx) {
		tabela2 t1=null;

            if(tableGramParser.mapa.containsKey(ctx.ID(1).getText()) &&
                tableGramParser.mapa.get(ctx.ID(1).getText()).getValue()!= null){

                t1= (tabela2) tableGramParser.mapa.get(ctx.ID(1).getText()).getValue();

                t1.addRow(ctx.ID(0).getText());
            }

            else System.out.println("Tabela invalida");
        return super.visitNewRowTable2(ctx);
    }

    @Override
    public Variable visitNewColumnTable2(tableGramParser.NewColumnTable2Context ctx) {
		tabela2 t1=null;

            if(tableGramParser.mapa.containsKey(ctx.ID(2).getText()) &&
                tableGramParser.mapa.get(ctx.ID(2).getText()).getValue()!= null){

                t1= (tabela2) tableGramParser.mapa.get(ctx.ID(2).getText()).getValue();

                t1.addColumn(ctx.ID(0).getText(),ctx.ID(1).getText());
            }

            else System.out.println("Tabela invalida");
        return super.visitNewColumnTable2(ctx);
    }

    @Override
    public Variable visitClearColumn2(tableGramParser.ClearColumn2Context ctx) {
		tabela2 t1=null;

            if(tableGramParser.mapa.containsKey(ctx.ID(1).getText()) &&
                tableGramParser.mapa.get(ctx.ID(1).getText()).getValue()!= null){

                t1= (tabela2) tableGramParser.mapa.get(ctx.ID(1).getText()).getValue();

                t1.clearColumn(ctx.ID(0).getText());
            }

            else System.out.println("Tabela invalida");
        
        return super.visitClearColumn2(ctx);
    }

    @Override
    public Variable visitAddRow2(tableGramParser.AddRow2Context ctx) {
		tabela2 t1=null;
		tabela2 t2 = null;

        if(tableGramParser.mapa.containsKey(ctx.ID(1).getText()) && tableGramParser.mapa.containsKey(ctx.ID(3).getText())) {
            if (tableGramParser.mapa.get(ctx.ID(1).getText()).getValue() != null
                    && tableGramParser.mapa.get(ctx.ID(3).getText()).getValue() != null)

            t1=(tabela2) tableGramParser.mapa.get(ctx.ID(1).getText()).getValue();
            t2=(tabela2) tableGramParser.mapa.get(ctx.ID(3).getText()).getValue();

			t1.sumRows(ctx.ID(0).getText(),t2,ctx.ID(2).getText());
        }
        return super.visitAddRow2(ctx);
    }

        @Override
        public Variable visitCopyRow1(tableGramParser.CopyRow1Context ctx) {      //    NAO ESTA A FUNFAR
           /* Tabela t1=null;
            Tabela t2=null;

            if(tableGramParser.mapa.containsKey(ctx.ID(0).getText()) && tableGramParser.mapa.containsKey(ctx.ID(1).getText())) {
                if (tableGramParser.mapa.get(ctx.ID(0).getText()).getValue() != null
                        && tableGramParser.mapa.get(ctx.ID(1).getText()).getValue() != null) {

                    t1 = (Tabela) tableGramParser.mapa.get(ctx.ID(0).getText()).getValue();
                    t2 = (Tabela) tableGramParser.mapa.get(ctx.ID(1).getText()).getValue();

                    t2.addRow(Integer.parseInt(ctx.INT(1).getText()));
                    System.out.println("y");
                    t2.fillRow(t1.getRow(Integer.parseInt(ctx.INT(0).getText())), Integer.parseInt(ctx.INT(1).getText()));
                }
                else System.out.println("Tabelas Vazias");
            }

            else System.out.println("Tabelas não existentes");
*/
            return super.visitCopyRow1(ctx);
        }
	//NAO USAR

         @Override
    public Variable visitCopyRow2(tableGramParser.CopyRow2Context ctx) {
		tabela2 t1=null;
        tabela2 t2=null;

        if(tableGramParser.mapa.containsKey(ctx.ID(1).getText()) && tableGramParser.mapa.containsKey(ctx.ID(2).getText())) {
            if (tableGramParser.mapa.get(ctx.ID(1).getText()).getValue() != null
                    && tableGramParser.mapa.get(ctx.ID(2).getText()).getValue() != null) {

                t1 = (tabela2) tableGramParser.mapa.get(ctx.ID(1).getText()).getValue();
                t2 = (tabela2) tableGramParser.mapa.get(ctx.ID(2).getText()).getValue();

                t2.addRowFrom(ctx.ID(0).getText(), t1);
            }
            else System.out.println("Tabelas Vazias");
        }

        else System.out.println("Tabelas não existentes");
        
        return super.visitCopyRow2(ctx);
    }

        @Override
        public Variable visitNewRowSpecific(tableGramParser.NewRowSpecificContext ctx) {
            Tabela t1=null;

            if(tableGramParser.mapa.containsKey(ctx.ID().getText()) &&
                    tableGramParser.mapa.get(ctx.ID().getText()).getValue()!= null){

                t1= (Tabela) tableGramParser.mapa.get(ctx.ID().getText()).getValue();

                t1.addRow(Integer.parseInt(ctx.INT().getText()));
            }

            else System.out.println("Tabela Invalida");

            return super.visitNewRowSpecific(ctx);
        }

        @Override
        public Variable visitNewRowSimple(tableGramParser.NewRowSimpleContext ctx) {
            Tabela t1=null;

            if(tableGramParser.mapa.containsKey(ctx.ID().getText()) &&
                tableGramParser.mapa.get(ctx.ID().getText()).getValue()!= null){

                t1= (Tabela) tableGramParser.mapa.get(ctx.ID().getText()).getValue();

                t1.addRow();
            }

            else System.out.println("Tabela invalida");


            return super.visitNewRowSimple(ctx);
        }

        @Override
        public Variable visitClearRow1(tableGramParser.ClearRow1Context ctx) {
            Tabela t1=null;

            if(tableGramParser.mapa.containsKey(ctx.ID().getText()) &&
                    tableGramParser.mapa.get(ctx.ID().getText()).getValue()!= null) {

                t1 = (Tabela) tableGramParser.mapa.get(ctx.ID().getText()).getValue();

                t1.deleteRow(Integer.parseInt(ctx.INT().getText()));
            }

            else System.out.println("Tabelas Invalidas");

                return super.visitClearRow1(ctx);
        }

    @Override
	public Variable visitClearRow2(tableGramParser.ClearRow2Context ctx) {
		tabela2 t1=null;

		if(tableGramParser.mapa.containsKey(ctx.ID(1).getText()) &&
			tableGramParser.mapa.get(ctx.ID(1).getText()).getValue()!= null) {

			t1 = (tabela2) tableGramParser.mapa.get(ctx.ID(1).getText()).getValue();

			t1.clearRow(ctx.ID(0).getText());
		}

		else System.out.println("Tabelas Invalidas");

		
        return super.visitClearRow2(ctx);
    }

    @Override
    public Variable visitAddColumn1(tableGramParser.AddColumn1Context ctx) {
		return super.visitAddColumn1(ctx);
	}

	@Override
	public Variable visitAddColumn2(tableGramParser.AddColumn2Context ctx) {
		tabela2 t1=null;
		tabela2 t2=null;

		if(tableGramParser.mapa.containsKey(ctx.ID(1).getText()) && tableGramParser.mapa.containsKey(ctx.ID(3).getText())) {
                if (tableGramParser.mapa.get(ctx.ID(1).getText()).getValue() != null
                        && tableGramParser.mapa.get(ctx.ID(3).getText()).getValue() != null) {

                    t1 = (tabela2) tableGramParser.mapa.get(ctx.ID(1).getText()).getValue();
                    t2 = (tabela2) tableGramParser.mapa.get(ctx.ID(3).getText()).getValue();
                    
                    t1.sumColumns(ctx.ID(0).getText(),t2,ctx.ID(2).getText());
				}
				else System.out.println("Tabelas vazias");
			
		}

		else System.out.println("Tabelas Invalidas");
        return super.visitAddColumn2(ctx);
    }

        @Override
        public Variable visitCopyColumn1(tableGramParser.CopyColumn1Context ctx) {

          /*  Tabela t1=null;
            Tabela t2=null;

            if(tableGramParser.mapa.containsKey(ctx.ID(0).getText()) && tableGramParser.mapa.containsKey(ctx.ID(1).getText())) {
                if (tableGramParser.mapa.get(ctx.ID(0).getText()).getValue() != null
                        && tableGramParser.mapa.get(ctx.ID(1).getText()).getValue() != null) {

                    t1 = (Tabela) tableGramParser.mapa.get(ctx.ID(0).getText()).getValue();
                    t2 = (Tabela) tableGramParser.mapa.get(ctx.ID(1).getText()).getValue();


                    t1.CopyCol(Integer.parseInt(ctx.INT(0).getText()),Integer.parseInt(ctx.INT(1).getText())-1,t2);
                   // t2.addColumn(Integer.parseInt(ctx.INT(1).getText()));
                 //   t2.fillColumn(t1.getColumn(Integer.parseInt(ctx.INT(0).getText())), Integer.parseInt(ctx.INT(1).getText()));
                }


                else System.out.println("Tabelas Vazias");
            }

            else System.out.println("Tabelas Invalidas");
		*/
//NAO USAR
            return super.visitCopyColumn1(ctx);
        }

       @Override
    public Variable visitCopyColumn2(tableGramParser.CopyColumn2Context ctx) {
		tabela2 t1=null;
        tabela2 t2=null;
        
        if(tableGramParser.mapa.containsKey(ctx.ID(1).getText()) && tableGramParser.mapa.containsKey(ctx.ID(2).getText())) {
            if (tableGramParser.mapa.get(ctx.ID(1).getText()).getValue() != null
                    && tableGramParser.mapa.get(ctx.ID(2).getText()).getValue() != null) {

                t1 = (tabela2) tableGramParser.mapa.get(ctx.ID(1).getText()).getValue();
                t2 = (tabela2) tableGramParser.mapa.get(ctx.ID(2).getText()).getValue();

                t2.addColumnFrom(ctx.ID(0).getText(), t1);
            }


            else System.out.println("Tabelas Vazias");
        }

        else System.out.println("Tabelas Invalidas");
        
        return super.visitCopyColumn2(ctx);
    }

        @Override
        public Variable visitNewColumnSpecific(tableGramParser.NewColumnSpecificContext ctx) {
            Tabela t1=null;

            if(tableGramParser.mapa.containsKey(ctx.ID().getText()) &&
                    tableGramParser.mapa.get(ctx.ID().getText()).getValue()!= null){

                t1= (Tabela) tableGramParser.mapa.get(ctx.ID().getText()).getValue();

                t1.addColumn(Integer.parseInt(ctx.INT().getText()));
            }

            else System.out.println("Tabela invalida");



            return super.visitNewColumnSpecific(ctx);
        }

        @Override
        public Variable visitNewColumnSimple(tableGramParser.NewColumnSimpleContext ctx) {
            Tabela t1=null;

            if(tableGramParser.mapa.containsKey(ctx.ID().getText()) &&
                    tableGramParser.mapa.get(ctx.ID().getText()).getValue()!= null){

                t1= (Tabela) tableGramParser.mapa.get(ctx.ID().getText()).getValue();

                t1.addColumn();
            }

            else System.out.println("Tabela invalida");


            return super.visitNewColumnSimple(ctx);
        }

        @Override
        public Variable visitClearColumn1(tableGramParser.ClearColumn1Context ctx) {
            Tabela t1=null;

            if(tableGramParser.mapa.containsKey(ctx.ID().getText()) &&
                    tableGramParser.mapa.get(ctx.ID().getText()).getValue()!= null){

                t1= (Tabela) tableGramParser.mapa.get(ctx.ID().getText()).getValue();

                t1.deleteColumn(Integer.parseInt(ctx.INT().getText()));
            }

            else System.out.println("Tabela invalida");


            return super.visitClearColumn1(ctx);
        }

        @Override
        public Variable visitExport(tableGramParser.ExportContext ctx)
        {
            /*String s=ctx.ID(1).getText()+".csv";
            Tabela t=null;
            //throw IOException;
            if(tableGramParser.mapa.containsKey(ctx.ID(0).getText()) &&
                    tableGramParser.mapa.get(ctx.ID(0).getText()).getValue()!= null) {

                t = (Tabela) tableGramParser.mapa.get(ctx.ID(0).getText()).getValue();

                File f = new File(s);

                try {
                    File outputFile = new File(s);

                    FileWriter out = new FileWriter(outputFile);

                    for (int i = 1; i <= t.getMaxLinhas(); i++) {
                        for (int j = 1; j <= t.getMaxColunas(); j++) {
                            out.write(t.get(j, i) + ",");
                        }
                        out.write("\n");

                    }
                    out.close();
                    System.out.println("Concluido");
                } catch (IOException e) {
                    System.out.print("Ficheiro não existente");
                }

            } else System.out.print("Tabela não existente");*/
        Tabela t1=null;
        tabela2 t2=null;
        
        if(tableGramParser.mapa.containsKey(ctx.ID(0).getText()) ) {
            if (tableGramParser.mapa.get(ctx.ID(0).getText()).getValue() != null) {

				try{
					t1 = (Tabela) tableGramParser.mapa.get(ctx.ID(0).getText()).getValue();
					//t1.extractToCSV(ctx.ID(1).getText());  Adicionar na classe Tabela
				}catch(Exception e){}
				try{
					t2 = (tabela2) tableGramParser.mapa.get(ctx.ID(0).getText()).getValue();
					t2.extractToCSV(ctx.ID(1).getText());
				}catch(Exception e){}
                
            }


            else System.out.println("Tabelas Vazias");
        }

        else System.out.println("Tabelas Invalidas");
            

            return super.visitExport(ctx);}


        @Override
        public Variable visitPrintTable(tableGramParser.PrintTableContext ctx) {

            Tabela t1 = null;
            tabela2 t2=null;

            if(tableGramParser.mapa.containsKey(ctx.ID().getText())){
                Variable var=tableGramParser.mapa.get(ctx.ID().getText());
                if(var.getType().equals("Tabela") || var.getType().equals("Tabela2")){
//try catch
                    if(tableGramParser.mapa.get(ctx.ID().getText()).getValue()!= null){
						try{
							t1 = (Tabela) var.getValue();
							t1.print();
						}catch(Exception e){}
						try{
							t2 = (tabela2) var.getValue();
							t2.print();
						}catch(Exception e){}
                        
                    }

                }

                else System.out.println(tableGramParser.mapa.get(ctx.ID().getText()).getValue());

             }

            else System.out.println("Variável não registada");

            return super.visitPrintTable(ctx);
        }

        @Override
        public Variable visitPrintRow1(tableGramParser.PrintRow1Context ctx)
        {

            Tabela t = null;

            if(tableGramParser.mapa.containsKey(ctx.ID().getText())){
                Variable var=tableGramParser.mapa.get(ctx.ID().getText());
                if(var.getType().equals("Tabela")){

                    if(tableGramParser.mapa.get(ctx.ID().getText()).getValue()!= null){
                        t = (Tabela) var.getValue();
                        t.printRow(Integer.parseInt(ctx.INT().getText()));
                    }

                }

                else System.out.println(tableGramParser.mapa.get(ctx.ID().getText()).getValue());

            }

            else System.out.println("Variável não registada");


            return super.visitPrintRow1(ctx);
        }

        @Override
    public Variable visitPrintRow2(tableGramParser.PrintRow2Context ctx) {
		
		
		tabela2 t = null;

        if(tableGramParser.mapa.containsKey(ctx.ID(1).getText())){
            Variable var=tableGramParser.mapa.get(ctx.ID(1).getText());
            if(var.getType().equals("Tabela2")){

                if(tableGramParser.mapa.get(ctx.ID(1).getText()).getValue()!= null){
                    t = (tabela2) var.getValue();
                    t.printRow(ctx.ID(0).getText());
                }

            }

            else System.out.println(tableGramParser.mapa.get(ctx.ID(1).getText()).getValue());

        }

        else System.out.println("Variável não registada");
        
        return super.visitPrintRow2(ctx);
    }

        @Override
        public Variable visitPrintColumn1(tableGramParser.PrintColumn1Context ctx) {
            Tabela t = null;

            if(tableGramParser.mapa.containsKey(ctx.ID().getText())){
                Variable var=tableGramParser.mapa.get(ctx.ID().getText());
                if(var.getType().equals("Tabela")){

                    if(tableGramParser.mapa.get(ctx.ID().getText()).getValue()!= null){
                        t = (Tabela) var.getValue();
                        t.printColumn(Integer.parseInt(ctx.INT().getText()));
                    }

                }

                else System.out.println(tableGramParser.mapa.get(ctx.ID().getText()).getValue());

            }

            else System.out.println("Variável não registada");

            return super.visitPrintColumn1(ctx);
        }

       
    @Override
    public Variable visitPrintColumn2(tableGramParser.PrintColumn2Context ctx)
    {
		tabela2 t = null;

        if(tableGramParser.mapa.containsKey(ctx.ID(1).getText())){
            Variable var=tableGramParser.mapa.get(ctx.ID(1).getText());
            if(var.getType().equals("Tabela2")){

                if(tableGramParser.mapa.get(ctx.ID(1).getText()).getValue()!= null){
                    t = (tabela2) var.getValue();
                    t.printColumn(ctx.ID(0).getText());
                }

            }

            else System.out.println(tableGramParser.mapa.get(ctx.ID(1).getText()).getValue());

        }
        return super.visitPrintColumn2(ctx);
    }

}
