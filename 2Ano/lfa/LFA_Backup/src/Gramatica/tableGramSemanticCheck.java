package Gramatica;

import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.time.temporal.ValueRange;
import java.util.HashMap;


        /*
        @author  Diogo Daniel Nunes Fernandes

        */

public class tableGramSemanticCheck extends tableGramBaseVisitor<Boolean> {
    private static HashMap<String, TYPE> mapa_tipo_id = new HashMap<>(); //server para guardar de que tipo é um certo Id (ex double x (x é um double))
    private static String ID_atual;

    public enum TYPE {INT, STRING, DOUBLE, TABLE, TABLE2}

    ;
    protected Variable a = null;
    protected Variable b = null;
    protected Variable c = null;
    protected Variable get = null;

    @Override
    public Boolean visitMain(tableGramParser.MainContext ctx) {
        return super.visitMain(ctx);
    }

    @Override
    public Boolean visitDeclareStat(tableGramParser.DeclareStatContext ctx) {
        return super.visitDeclareStat(ctx);
    }

    @Override
    public Boolean visitAtrStat(tableGramParser.AtrStatContext ctx) {
        return super.visitAtrStat(ctx);
    }

    @Override
    public Boolean visitMethodStat(tableGramParser.MethodStatContext ctx) {
        return super.visitMethodStat(ctx);
    }

    @Override
    public Boolean visitNumExpression(tableGramParser.NumExpressionContext ctx) {
        return super.visitNumExpression(ctx);
    }

    @Override
    public Boolean visitParenMath(tableGramParser.ParenMathContext ctx) {
        return super.visitParenMath(ctx);
    }

    @Override
    public Boolean visitMultDivMath(tableGramParser.MultDivMathContext ctx) {
        return super.visitMultDivMath(ctx);
    }

    @Override
    public Boolean visitAddSubMath(tableGramParser.AddSubMathContext ctx) {
        return super.visitAddSubMath(ctx);
    }

    @Override
    public Boolean visitStringExpr(tableGramParser.StringExprContext ctx) {

        a = new Variable("String", ctx.STRING().getText());

        return visitChildren(ctx);
    }

    @Override
    public Boolean visitNewTableMethod(tableGramParser.NewTableMethodContext ctx) {
        return super.visitNewTableMethod(ctx);
    }

    @Override
    public Boolean visitCopyTableMethod(tableGramParser.CopyTableMethodContext ctx) {
        return super.visitCopyTableMethod(ctx);
    }

    @Override
    public Boolean visitReadTableMethod(tableGramParser.ReadTableMethodContext ctx) {
        return super.visitReadTableMethod(ctx);
    }

    @Override
    public Boolean visitGetElemMethod(tableGramParser.GetElemMethodContext ctx) {
        return super.visitGetElemMethod(ctx);
    }

    @Override
    public Boolean visitRemoveTableMethod(tableGramParser.RemoveTableMethodContext ctx) {
        return super.visitRemoveTableMethod(ctx);
    }

    @Override
    public Boolean visitAddRowMethod(tableGramParser.AddRowMethodContext ctx) {
        return super.visitAddRowMethod(ctx);
    }

    @Override
    public Boolean visitCopyRowMethod(tableGramParser.CopyRowMethodContext ctx) {
        return super.visitCopyRowMethod(ctx);
    }


    @Override
    public Boolean visitNewRowMethod(tableGramParser.NewRowMethodContext ctx) {
        return super.visitNewRowMethod(ctx);
    }

    @Override
    public Boolean visitClearRowMethod(tableGramParser.ClearRowMethodContext ctx) {
        return super.visitClearRowMethod(ctx);
    }

    @Override
    public Boolean visitInsertElemMethod(tableGramParser.InsertElemMethodContext ctx) {
        return super.visitInsertElemMethod(ctx);
    }

    @Override
    public Boolean visitRemoveElemMethod(tableGramParser.RemoveElemMethodContext ctx) {
        return super.visitRemoveElemMethod(ctx);
    }

    @Override
    public Boolean visitAddColumnMethod(tableGramParser.AddColumnMethodContext ctx) {
        return super.visitAddColumnMethod(ctx);
    }

    @Override
    public Boolean visitNewColumnMethod(tableGramParser.NewColumnMethodContext ctx) {
        return super.visitNewColumnMethod(ctx);
    }

    @Override
    public Boolean visitCopyColumnMethod(tableGramParser.CopyColumnMethodContext ctx) {
        return super.visitCopyColumnMethod(ctx);
    }

    @Override
    public Boolean visitClearColumnMethod(tableGramParser.ClearColumnMethodContext ctx) {
        return super.visitClearColumnMethod(ctx);
    }

    @Override
    public Boolean visitPrintTableMethod(tableGramParser.PrintTableMethodContext ctx) {
        return super.visitPrintTableMethod(ctx);
    }

    @Override
    public Boolean visitPrintRowMethod(tableGramParser.PrintRowMethodContext ctx) {
        return super.visitPrintRowMethod(ctx);
    }

    @Override
    public Boolean visitPrintColumnMethod(tableGramParser.PrintColumnMethodContext ctx) {
        return super.visitPrintColumnMethod(ctx);
    }

    @Override
    public Boolean visitExportMethod(tableGramParser.ExportMethodContext ctx) {
        return super.visitExportMethod(ctx);
    }

    @Override
    public Boolean visitTable2Declaring(tableGramParser.Table2DeclaringContext ctx) {
        mapa_tipo_id.put(ID_atual, TYPE.TABLE2);
        ErrorHandling.printInfo("Table declared");

        return true;

    }

    @Override
    public Boolean visitCreateDefaultTable(tableGramParser.CreateDefaultTableContext ctx) {
        a = new Variable("table", new Tabela("Tabela"));
        return super.visitCreateDefaultTable(ctx);
    }

    @Override
    public Boolean visitCreateCustomTable(tableGramParser.CreateCustomTableContext ctx) {
        a = new Variable("table", new Tabela("Tabela", Integer.parseInt(ctx.INT(0).getText()), Integer.parseInt(ctx.INT(1).getText())));
        return super.visitCreateCustomTable(ctx);
    }

    @Override
    public Boolean visitCreateType2Table(tableGramParser.CreateType2TableContext ctx) {
        a = new Variable("table2", new tabela2(ctx.ID().getText()));
        return super.visitCreateType2Table(ctx);
    }

    @Override
    public Boolean visitCopyTable(tableGramParser.CopyTableContext ctx) {
        if (tableGramParser.mapa.containsKey(ctx.ID().getText())) {
            a = new Variable(tableGramParser.mapa.get(ctx.ID().getText()).getType(), tableGramParser.mapa.get(ctx.ID().getText()).getValue());
            return true;
        } else {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID().getText() + " Not existing variable !");

            return false;
        }
    }

    @Override
    public Boolean visitRemoveElem1(tableGramParser.RemoveElem1Context ctx) {

        if (!tableGramParser.mapa.containsKey(ctx.ID().getText()) ||
                tableGramParser.mapa.get(ctx.ID().getText()).getValue() == null) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID().getText() + " Not existing table !");

            return false;

        } else return true;
    }

    @Override
    public Boolean visitRemoveElem2(tableGramParser.RemoveElem2Context ctx) {

        if (!tableGramParser.mapa.containsKey(ctx.ID(2).getText()) ||
                tableGramParser.mapa.get(ctx.ID(2).getText()).getValue() == null) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID(2).getText() + " Not existing table !");

            return false;

        } else return true;
    }


    @Override
    public Boolean visitGetElem2(tableGramParser.GetElem2Context ctx) {

        if (!tableGramParser.mapa.containsKey(ctx.ID(2).getText()) ||
                tableGramParser.mapa.get(ctx.ID(2).getText()).getValue() == null ||
                !tableGramParser.mapa.get(ctx.ID(2).getText()).getType().equalsIgnoreCase("table2")) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID(2).getText() + " Not existing table !");

            return false;

        } else return true;

    }

    @Override
    public Boolean visitRead1(tableGramParser.Read1Context ctx) {

        try {
            File f = new File(ctx.ID(1).getText() + ".csv");

        } catch (Exception e) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID(1).getText() + " Not existing file !");

            return false;
        }
        return true;

    }

    //}
    @Override
    public Boolean visitRead2(tableGramParser.Read2Context ctx) {
        return super.visitRead2(ctx);
    }

    @Override
    public Boolean visitAddRow1(tableGramParser.AddRow1Context ctx) {
        return super.visitAddRow1(ctx);
    }

    @Override
    public Boolean visitAddRow2(tableGramParser.AddRow2Context ctx) {
        return super.visitAddRow2(ctx);
    }

    @Override
    public Boolean visitCopyRow1(tableGramParser.CopyRow1Context ctx) {
        return super.visitCopyRow1(ctx);
    }

    @Override
    public Boolean visitCopyRow2(tableGramParser.CopyRow2Context ctx) {
        return super.visitCopyRow2(ctx);
    }

    @Override
    public Boolean visitNewRowTable2(tableGramParser.NewRowTable2Context ctx) {
        if (!tableGramParser.mapa.containsKey(ctx.ID(1).getText()) ||
                tableGramParser.mapa.get(ctx.ID(1).getText()).getValue() == null ||
                !tableGramParser.mapa.get(ctx.ID(1).getText()).getType().equalsIgnoreCase("table2")) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID(1).getText() + " Invalid Table");

            return false;

        } else return true;


    }

    @Override
    public Boolean visitClearRow2(tableGramParser.ClearRow2Context ctx) {
        return super.visitClearRow2(ctx);
    }

    @Override
    public Boolean visitAddColumn1(tableGramParser.AddColumn1Context ctx) {
        return super.visitAddColumn1(ctx);
    }

    @Override
    public Boolean visitAddColumn2(tableGramParser.AddColumn2Context ctx) {
        return super.visitAddColumn2(ctx);
    }

    @Override
    public Boolean visitCopyColumn1(tableGramParser.CopyColumn1Context ctx) {
        return super.visitCopyColumn1(ctx);
    }

    @Override
    public Boolean visitNewColumnTable2(tableGramParser.NewColumnTable2Context ctx) {

        if (!tableGramParser.mapa.containsKey(ctx.ID(2).getText()) ||
                tableGramParser.mapa.get(ctx.ID(2).getText()).getValue() == null ||
                !tableGramParser.mapa.get(ctx.ID(2).getText()).getType().equalsIgnoreCase("table2")) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID(1).getText() + " Invalid Table");

            return false;
        } else if (!ctx.ID(0).getText().equals("int") &&
                !ctx.ID(0).getText().equals("double") &&
                !ctx.ID(0).getText().equals("string")) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID(1).getText() + " Invalid!\nType must be Integer,Double or String");

            return false;

        }

        return super.visitNewColumnTable2(ctx);
    }

    @Override
    public Boolean visitClearColumn2(tableGramParser.ClearColumn2Context ctx) {
        return super.visitClearColumn2(ctx);
    }

    @Override
    public Boolean visitExport(tableGramParser.ExportContext ctx) {
        return super.visitExport(ctx);
    }

    @Override
    public Boolean visitPrintTable(tableGramParser.PrintTableContext ctx) {

        if (tableGramParser.mapa.get(ctx.ID().getText()) == null) {
            ErrorHandling.printError(ctx, "condition '" + ctx.ID().getText() + " 'is not defined!");

            return false;
        } else if (!tableGramParser.mapa.containsKey(ctx.ID().getText())) {
            ErrorHandling.printError(ctx, "condition '" + ctx.ID().getText() + " has no value!");

            return false;

        } else

            return true;


    }


//---------------------------------------------------------------------------

    @Override
    public Boolean visitDeclaracao(tableGramParser.DeclaracaoContext ctx) {


        ID_atual = ctx.ID().getText();
        boolean check = visit(ctx.tipo());

        String tipo = ctx.tipo().getText();
        String varName = ctx.ID().getText();

        if (tipo.equals("String")) {
            Variable<String> var = new Variable<>("String", null);
            tableGramParser.mapa.put(varName, var);
        } else if (tipo.equals("Integer")) {
            Variable<Integer> var = new Variable<>("Integer", null);
            tableGramParser.mapa.put(varName, var);
        } else if (tipo.equals("Double")) {
            Variable<Double> var = new Variable<>("Double", null);
            tableGramParser.mapa.put(varName, var);
        } else if (tipo.equals("table")) {
            Variable<Tabela> var = new Variable<>("Tabela", null);
            tableGramParser.mapa.put(varName, var);

        } else if (tipo.equals("table2")) {
            Variable<Tabela> var = new Variable<>("Tabela2", null);
            tableGramParser.mapa.put(varName, var);
        }

        return check;

    }


    @Override
    public Boolean visitStringDeclaring(tableGramParser.StringDeclaringContext ctx) {

        ErrorHandling.printInfo("String declared");
        mapa_tipo_id.put(ID_atual, TYPE.STRING);


        return true;
    }

    @Override
    public Boolean visitIntDeclaring(tableGramParser.IntDeclaringContext ctx) {
        mapa_tipo_id.put(ID_atual, TYPE.INT);
        ErrorHandling.printInfo("Int declared");

        return true;
    }

    @Override
    public Boolean visitDoubleDeclaring(tableGramParser.DoubleDeclaringContext ctx) {
        mapa_tipo_id.put(ID_atual, TYPE.DOUBLE);
        ErrorHandling.printInfo("Double declared");

        return true;

    }

    @Override
    public Boolean visitTableDeclaring(tableGramParser.TableDeclaringContext ctx) {


        mapa_tipo_id.put(ID_atual, TYPE.TABLE);
        ErrorHandling.printInfo("Table declared");

        return true;


    }
//---------------------------------------------------------------------------


    @Override
    public Boolean visitAtribuicao(tableGramParser.AtribuicaoContext ctx) {

        ID_atual = ctx.ID().getText();
        Boolean check = visit(ctx.expr());


        tableGramParser.mapa.put(ctx.ID().getText(), a);
        a = null;


        return check;
    }


    @Override
    public Boolean visitMethod(tableGramParser.MethodContext ctx) {


        if (mapa_tipo_id.get(ID_atual) != TYPE.TABLE && mapa_tipo_id.get(ID_atual) != TYPE.TABLE2
                && mapa_tipo_id.get(ID_atual) != TYPE.DOUBLE && mapa_tipo_id.get(ID_atual) != TYPE.INT && mapa_tipo_id.get(ID_atual) != TYPE.STRING
        ) {

            ErrorHandling.printError(ctx, "condition '" + ID_atual + "' type is not a Table!");

            return false;
        } else {
            ErrorHandling.printInfo("done");
            visitChildren(ctx);
            return true;
        }
    }


    @Override
    public Boolean visitIntMath(tableGramParser.IntMathContext ctx) {


        if (mapa_tipo_id.get(ID_atual) != TYPE.INT && mapa_tipo_id.get(ID_atual) != TYPE.DOUBLE) {
            ErrorHandling.printError(ctx, "condition '" + ID_atual + "' type is not an Int!");

            return false;
        } else {
            a = new Variable("Integer", (Integer) Integer.parseInt(ctx.INT().getText()));
            ErrorHandling.printInfo("done");
            return true;
        }


    }

    @Override
    public Boolean visitIdMath(tableGramParser.IdMathContext ctx) {
        return super.visitIdMath(ctx);
    }

    @Override
    public Boolean visitGetElem1(tableGramParser.GetElem1Context ctx) {

        if (!tableGramParser.mapa.containsKey(ctx.ID().getText())) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID().getText() + " Not existing table !");

            return false;

        } else {
            if (!tableGramParser.mapa.get(ctx.ID().getText()).getType().equals("table") ||
                    tableGramParser.mapa.get(ctx.ID().getText()).getType() == null) {

                ErrorHandling.printError(ctx, "condition '" + ctx.ID().getText() + " Not a table !");
                return false;
            } else {

                Tabela t = (Tabela) tableGramParser.mapa.get(ctx.ID().getText()).getValue();
                Variable v = (Variable) t.get(Integer.parseInt(ctx.INT(0).getText()), Integer.parseInt(ctx.INT(1).getText()));
                a = v;
               /* if(v.getType().equalsIgnoreCase("Integer")) c=new Variable(("testeON"),"1");
                else if(v.getType().equalsIgnoreCase("String")) c= new Variable("testeON","3");
                else if(v.getType().equalsIgnoreCase("Double")) c= new Variable("testeON","2");
                else c=new Variable("testeON","4");
*/


                return true;
            }
        }
    }

    @Override
    public Boolean visitDoubleMath(tableGramParser.DoubleMathContext ctx) {

        a = new Variable("Double", Double.parseDouble(ctx.DOUBLE().getText()));

        if (mapa_tipo_id.get(ID_atual) != TYPE.DOUBLE) {
            ErrorHandling.printError(ctx, "condition ' " + ID_atual + " 'type is not a Double!");

            return false;
        } else {
            ErrorHandling.printInfo("done");
            return true;
        }

    }

    @Override
    public Boolean visitNewRowSpecific(tableGramParser.NewRowSpecificContext ctx) {
        if (!tableGramParser.mapa.containsKey(ctx.ID().getText()) ||
                tableGramParser.mapa.get(ctx.ID().getText()).getValue() == null) {

            ErrorHandling.printError(ctx, "condition ' " + ctx.ID().getText() + " Invalid Table!");

            return false;


        } else return true;
    }


    @Override
    public Boolean visitNewRowSimple(tableGramParser.NewRowSimpleContext ctx) {

        if (!tableGramParser.mapa.containsKey(ctx.ID().getText()) &&
                tableGramParser.mapa.get(ctx.ID().getText()).getValue() == null) {

            ErrorHandling.printError(ctx, "condition ' " + ctx.ID().getText() + " Invalid Table!");

            return false;

        } else return true;
    }


    @Override
    public Boolean visitClearRow1(tableGramParser.ClearRow1Context ctx) {
        if (!tableGramParser.mapa.containsKey(ctx.ID().getText()) &&
                tableGramParser.mapa.get(ctx.ID().getText()).getValue() == null) {

            ErrorHandling.printError(ctx, "condition ' " + ctx.ID().getText() + " Invalid Table!");

            return false;
        } else if (!tableGramParser.mapa.get(ctx.ID().getText()).getType().equalsIgnoreCase("table")) {
            ErrorHandling.printError(ctx, "condition ' " + ctx.ID() + " Not a Table!");

            return false;

        } else {

            Tabela t = (Tabela) tableGramParser.mapa.get(ctx.ID().getText()).getValue();
            if (Integer.parseInt(ctx.INT().getText()) > t.getMaxLinhas() ||
                    Integer.parseInt(ctx.INT().getText()) < 1) {
                ErrorHandling.printError(ctx, "condition ' " + ctx.ID() + " Dimensões inválidas!");

                return false;
            } else return true;
        }
    }


    @Override
    public Boolean visitCopyColumn2(tableGramParser.CopyColumn2Context ctx) {

        if (!tableGramParser.mapa.containsKey(ctx.ID(1).getText()) &&
                !tableGramParser.mapa.containsKey(ctx.ID(2).getText())) {

            ErrorHandling.printError(ctx, "condition ' " + ctx.ID(0) + " Invalid Table!");

            return false;

        } else {
            if (tableGramParser.mapa.get(ctx.ID(1).getText()).getValue() == null
                    && tableGramParser.mapa.get(ctx.ID(2).getText()).getValue() == null) {

                ErrorHandling.printError(ctx, "condition ' " + ctx.ID(0) + " Empty Tables!");

                return false;

            } else return true;
        }

    }


    @Override
    public Boolean visitNewColumnSpecific(tableGramParser.NewColumnSpecificContext ctx) {
        if (!tableGramParser.mapa.containsKey(ctx.ID().getText()) &&
                tableGramParser.mapa.get(ctx.ID().getText()).getValue() == null) {

            ErrorHandling.printError(ctx, "condition ' " + ctx.ID() + " Invalid Tables!");

            return false;

        } else return true;
    }

    @Override
    public Boolean visitNewColumnSimple(tableGramParser.NewColumnSimpleContext ctx) {


        if (!tableGramParser.mapa.containsKey(ctx.ID().getText()) &&
                tableGramParser.mapa.get(ctx.ID().getText()).getValue() == null) {

            ErrorHandling.printError(ctx, "condition ' " + ctx.ID() + " Invalid Tables!");

            return false;

        } else return true;
    }

    @Override
    public Boolean visitClearColumn1(tableGramParser.ClearColumn1Context ctx) {
        if (!tableGramParser.mapa.containsKey(ctx.ID().getText()) &&
                tableGramParser.mapa.get(ctx.ID().getText()).getValue() == null) {

            ErrorHandling.printError(ctx, "condition ' " + ctx.ID() + " Invalid Tables!");

            return false;

        } else if (!tableGramParser.mapa.get(ctx.ID().getText()).getType().equalsIgnoreCase("table")) {
            ErrorHandling.printError(ctx, "condition ' " + ctx.ID() + " Not a Table!");

            return false;
        } else {

            Tabela t = (Tabela) tableGramParser.mapa.get(ctx.ID().getText()).getValue();
            if (Integer.parseInt(ctx.INT().getText()) > t.getMaxColunas() ||
                    Integer.parseInt(ctx.INT().getText()) < 1) {
                ErrorHandling.printError(ctx, "condition ' " + ctx.ID() + " Dimensões inválidas!");

                return false;
            } else return true;
        }
    }

    @Override
    public Boolean visitRemoveTable(tableGramParser.RemoveTableContext ctx) {

        if (!tableGramParser.mapa.containsKey(ctx.ID().getText())) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID().getText() + " Not existing variable !");

            return false;
        } else {
            tableGramParser.mapa.remove(ctx.ID().getText());
            return true;
        }
    }


    @Override
    public Boolean visitPrintRow1(tableGramParser.PrintRow1Context ctx) {
        if (!tableGramParser.mapa.containsKey(ctx.ID().getText())) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID().getText() + " Not existing variable !");

            return false;
        } else return true;
    }


    @Override
    public Boolean visitPrintRow2(tableGramParser.PrintRow2Context ctx) {
        if (!tableGramParser.mapa.containsKey(ctx.ID(1).getText())) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID(1).getText() + " Not existing table !");

            return false;

        } else return true;
    }

    @Override
    public Boolean visitPrintColumn1(tableGramParser.PrintColumn1Context ctx) {
        if (!tableGramParser.mapa.containsKey(ctx.ID().getText())) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID().getText() + " Not existing table !");

            return false;
        } else return true;
    }


    @Override
    public Boolean visitPrintColumn2(tableGramParser.PrintColumn2Context ctx) {
        if (!tableGramParser.mapa.containsKey(ctx.ID(1).getText())) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID(1).getText() + " Not existing variable !");

            return false;
        } else return true;
    }


    @Override
    public Boolean visitInsertElem1(tableGramParser.InsertElem1Context ctx) {


        if (!tableGramParser.mapa.containsKey(ctx.ID(0).getText()) ||
                tableGramParser.mapa.get(ctx.ID(0).getText()).getValue() == null ||
                !tableGramParser.mapa.containsKey(ctx.ID(1).getText()) ||
                tableGramParser.mapa.get(ctx.ID(1).getText()).getValue() == null) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID(0).getText() + " , " + ctx.ID(1).getText() + " Not existing variable !");

            return false;

        } else if (tableGramParser.mapa.get(ctx.ID(1).getText()).getType().equals("table2")) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID(0).getText() + " , " + ctx.ID(1).getText() + " Tabela do tipo incorreto !");

            return false;
        } else {
            Tabela t = (Tabela) tableGramParser.mapa.get(ctx.ID(1).getText()).getValue();
            t.add(Integer.parseInt(ctx.INT(0).getText()), Integer.parseInt(ctx.INT(1).getText()), tableGramParser.mapa.get(ctx.ID(0).getText()));
            return true;
        }

    }

    @Override
    public Boolean visitInsertElem2(tableGramParser.InsertElem2Context ctx) {
        if (!tableGramParser.mapa.containsKey(ctx.ID(0).getText()) ||
                tableGramParser.mapa.get(ctx.ID(0).getText()).getValue() == null ||
                !tableGramParser.mapa.containsKey(ctx.ID(3).getText()) ||
                tableGramParser.mapa.get(ctx.ID(3).getText()).getValue() == null) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID(0).getText() + " , " + ctx.ID(3).getText() + " Not available pair !");

            return false;

        } else if (!tableGramParser.mapa.get(ctx.ID(3).getText()).getType().equals("table2")) {

            ErrorHandling.printError(ctx, "condition '" + ctx.ID(0).getText() + " , " + ctx.ID(3).getText() + " Tabela do tipo incorreto !");

            return false;
        } else {
        /*    tabela2 t= (tabela2) tableGramParser.mapa.get(ctx.ID(3).getText()).getValue();
            t.setData(ctx.ID(1).getText(),ctx.ID(2).getText(),tableGramParser.mapa.get(ctx.ID(0).getText()));
          */
            return true;
        }

    }

    @Override
    public Boolean visitStringGet(tableGramParser.StringGetContext ctx) {


        if (mapa_tipo_id.get(ID_atual) != TYPE.STRING) {
            ErrorHandling.printError(ctx, "condition '" + ID_atual + "' type is not a String!");

            return false;
        } else {
            ErrorHandling.printInfo("done");
            super.visitStringGet(ctx);
            return true;

        }


    }


}