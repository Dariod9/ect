package Gramatica;

import java.io.*;
import java.util.*;

import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;

public class tableCompiler extends tableGramBaseVisitor<ST> {

    protected STGroup stg = null;

    @Override
    public ST visitMain(tableGramParser.MainContext ctx) {
        stg = new STGroupFile("Gramatica/StringTemplate.stg");
        ST res = stg.getInstanceOf("main");

        for (tableGramParser.StatContext s : ctx.stat())
            res.add("stat", visit(s));
        return res;
    }

    @Override
    public ST visitDeclareStat(tableGramParser.DeclareStatContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.declaracao()));
        return res;
    }

    @Override
    public ST visitAtrStat(tableGramParser.AtrStatContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.atribuicao()));
        return res;
    }

    @Override
    public ST visitMethodStat(tableGramParser.MethodStatContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.voidMethods()));
        return res;
    }

    @Override
    public ST visitDeclaracao(tableGramParser.DeclaracaoContext ctx) {
        String tipo = ctx.tipo().getText();
        String varName = ctx.ID().getText();
        ST res = stg.getInstanceOf("declaracao");

        if (tipo.equals("String")) {
            res.add("dataType", "String");
        } else if (tipo.equals("Integer")) {
            res.add("dataType", "Integer");
        } else if (tipo.equals("Double")) {
            res.add("dataType", "Double");
        } else if (tipo.equals("table")) {

            res.add("dataType", "Tabela");
        } else if (tipo.equals("table2")) {
            res.add("dataType", "tabela2");
        }


        res.add("name", varName);
        return res;
    }

    @Override
    public ST visitStringDeclaring(tableGramParser.StringDeclaringContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ST visitIntDeclaring(tableGramParser.IntDeclaringContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ST visitDoubleDeclaring(tableGramParser.DoubleDeclaringContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ST visitTableDeclaring(tableGramParser.TableDeclaringContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public ST visitAtribuicao(tableGramParser.AtribuicaoContext ctx) {
        ST res = stg.getInstanceOf("atribuicao");
        res.add("name", ctx.ID().getText());
        res.add("expr", visit(ctx.expr()));

        return res;
    }

    @Override
    public ST visitMethod(tableGramParser.MethodContext ctx) {
        ST res = stg.getInstanceOf("stats");

        res.add("stat", visit(ctx.nonVoidMethods()));
        return res;
    }

    @Override
    public ST visitNumExpression(tableGramParser.NumExpressionContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.numExpr()));
        return res;
    }

    @Override
    public ST visitStringGet(tableGramParser.StringGetContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.stringExpr()));
        return res;
    }


    @Override
    public ST visitTable2Declaring(tableGramParser.Table2DeclaringContext ctx) {
        return super.visitTable2Declaring(ctx);
    }

    @Override
    public ST visitMultDivMath(tableGramParser.MultDivMathContext ctx) {
        ST res = stg.getInstanceOf("math");
        res.add("e1", ctx.e1.getText());
        res.add("op", ctx.op.getText());
        res.add("e2", ctx.e2.getText());
        return res;
    }

    @Override
    public ST visitAddSubMath(tableGramParser.AddSubMathContext ctx) {
        ST res = stg.getInstanceOf("math");
        res.add("e1", ctx.e1.getText());
        res.add("op", ctx.op.getText());
        res.add("e2", ctx.e2.getText());
        return res;
    }

    @Override
    public ST visitParenMath(tableGramParser.ParenMathContext ctx) {
        ST res = stg.getInstanceOf("parent");
        res.add("x", ctx.numExpr().getText());
        return res;
    }

    @Override
    public ST visitIdMath(tableGramParser.IdMathContext ctx) {
        ST res = stg.getInstanceOf("test");
        res.add("value", ctx.ID().getText());
        return res;
    }

    @Override
    public ST visitIntMath(tableGramParser.IntMathContext ctx) {
        ST res = stg.getInstanceOf("test");
        res.add("value", ctx.INT().getText());
        return res;
    }

    @Override
    public ST visitDoubleMath(tableGramParser.DoubleMathContext ctx) {
        ST res = stg.getInstanceOf("test");
        res.add("value", ctx.DOUBLE().getText());
        return res;
    }

    @Override
    public ST visitStringExpr(tableGramParser.StringExprContext ctx) {
        ST res = stg.getInstanceOf("test");
        res.add("value", ctx.STRING().getText());
        return res;
    }

    @Override
    public ST visitNewTableMethod(tableGramParser.NewTableMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.newTable()));
        return res;
    }

    @Override
    public ST visitCopyTableMethod(tableGramParser.CopyTableMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.copyTable()));
        return res;
    }

    @Override
    public ST visitReadTableMethod(tableGramParser.ReadTableMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.readTable()));
        return res;
    }

    @Override
    public ST visitGetElemMethod(tableGramParser.GetElemMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.getElem()));
        return res;
    }

    @Override
    public ST visitRemoveTableMethod(tableGramParser.RemoveTableMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.removeTable()));
        return res;
    }

    @Override
    public ST visitAddRowMethod(tableGramParser.AddRowMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.addRow()));
        return res;
    }

    @Override
    public ST visitNewRowMethod(tableGramParser.NewRowMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.newRow()));
        return res;
    }

    @Override
    public ST visitClearRowMethod(tableGramParser.ClearRowMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.clearRow()));
        return res;
    }

    @Override
    public ST visitInsertElemMethod(tableGramParser.InsertElemMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.insertElem()));
        return res;
    }

    @Override
    public ST visitRemoveElemMethod(tableGramParser.RemoveElemMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.removeElem()));
        return res;
    }

    @Override
    public ST visitAddColumnMethod(tableGramParser.AddColumnMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.addColumn()));
        return res;
    }

    @Override
    public ST visitNewColumnMethod(tableGramParser.NewColumnMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.newColumn()));
        return res;
    }

    @Override
    public ST visitCopyColumnMethod(tableGramParser.CopyColumnMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.copyColumn()));
        return res;
    }

    @Override
    public ST visitCopyRowMethod(tableGramParser.CopyRowMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.copyRow()));
        return res;
    }

    @Override
    public ST visitClearColumnMethod(tableGramParser.ClearColumnMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.clearColumn()));
        return res;
    }

    @Override
    public ST visitPrintTableMethod(tableGramParser.PrintTableMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.printTable()));
        return res;
    }

    @Override
    public ST visitPrintRowMethod(tableGramParser.PrintRowMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.printRow()));
        return res;
    }

    @Override
    public ST visitPrintColumnMethod(tableGramParser.PrintColumnMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.printColumn()));
        return res;
    }

    @Override
    public ST visitExportMethod(tableGramParser.ExportMethodContext ctx) {
        ST res = stg.getInstanceOf("stats");
        res.add("stat", visit(ctx.export()));
        return res;
    }

    @Override
    public ST visitCreateDefaultTable(tableGramParser.CreateDefaultTableContext ctx) {
        ST res = stg.getInstanceOf("newTable1");
        res.add("name", "Tabela");
        return res;
    }

    @Override
    public ST visitCreateCustomTable(tableGramParser.CreateCustomTableContext ctx) {
        ST res = stg.getInstanceOf("newTable2");
        res.add("name", "Tabela");
        res.add("x", ctx.INT(0).getText());
        res.add("y", ctx.INT(1).getText());
        return res;
    }

    @Override
    public ST visitCreateType2Table(tableGramParser.CreateType2TableContext ctx) {
        ST res = stg.getInstanceOf("newTable3");
        res.add("name", ctx.ID().getText());
        return res;
    }

    @Override
    public ST visitCopyTable(tableGramParser.CopyTableContext ctx) {
        ST res = stg.getInstanceOf("copyTable");
        res.add("table", ctx.ID().getText());
        return res;
    }

    @Override
    public ST visitInsertElem1(tableGramParser.InsertElem1Context ctx) {
        ST res = stg.getInstanceOf("insertElem1");
        res.add("elem", ctx.ID(0).getText());
        res.add("x", ctx.INT(0).getText());
        res.add("y", ctx.INT(1).getText());
        res.add("table", ctx.ID(1).getText());
        return res;
    }

    @Override
    public ST visitInsertElem2(tableGramParser.InsertElem2Context ctx) {
        ST res = stg.getInstanceOf("insertElem2");
        res.add("elem", ctx.ID(0).getText());
        res.add("var1", ctx.ID(1).getText());
        res.add("var2", ctx.ID(2).getText());
        res.add("table", ctx.ID(3).getText());
        return res;
    }

    @Override
    public ST visitRemoveElem1(tableGramParser.RemoveElem1Context ctx) {
        ST res = stg.getInstanceOf("removeElem");
        res.add("x", ctx.INT(0).getText());
        res.add("y", ctx.INT(1).getText());
        res.add("table", ctx.ID().getText());
        return res;
    }

    @Override
    public ST visitRemoveElem2(tableGramParser.RemoveElem2Context ctx) {
        ST res = stg.getInstanceOf("insertElem2");
        res.add("elem", null);
        res.add("x", ctx.ID(0).getText());
        res.add("y", ctx.ID(1).getText());
        res.add("table", ctx.ID(2).getText());
        return res;
    }


    @Override
    public ST visitGetElem1(tableGramParser.GetElem1Context ctx) {

        Tabela t = (Tabela) tableGramParser.mapa.get(ctx.ID().getText()).getValue();
        ST res = null;
        Double d;

        Variable var = (Variable) t.get(Integer.parseInt(ctx.INT(0).getText()), Integer.parseInt(ctx.INT(1).getText()));


        if (var.getType().equals("Integer")) {

            res = stg.getInstanceOf("getElem1Int");
            res.add("x", ctx.INT(0).getText());
            res.add("y", ctx.INT(1).getText());
            res.add("table", ctx.ID().getText());
        } else if (var.getType().equalsIgnoreCase("Double")) {
            res = stg.getInstanceOf("getElem1Double");
            res.add("x", ctx.INT(0).getText());
            res.add("y", ctx.INT(1).getText());
            res.add("table", ctx.ID().getText());
        } else {
            res = stg.getInstanceOf("getElem1String");
            res.add("x", ctx.INT(0).getText());
            res.add("y", ctx.INT(1).getText());
            res.add("table", ctx.ID().getText());
        }
        return res;
    }

    @Override
    public ST visitGetElem2(tableGramParser.GetElem2Context ctx) {
        tabela2 t = (tabela2) tableGramParser.mapa.get(ctx.ID(2).getText()).getValue();
        ST res = null;
        Double d;
        Variable var = (Variable) t.getElem(ctx.ID(0).getText(), ctx.ID(1).getText());


        if (var.getType().equalsIgnoreCase("Integer")) {

            res = stg.getInstanceOf("getElem2Int");
            res.add("var1", ctx.ID(0).getText());
            res.add("var2", ctx.ID(1).getText());
            res.add("table", ctx.ID(2).getText());
        } else if (var.getType().equalsIgnoreCase("Double")) {
            res = stg.getInstanceOf("getElem2Double");
            res.add("var1", ctx.ID(0).getText());
            res.add("var2", ctx.ID(1).getText());
            res.add("table", ctx.ID(2).getText());
        } else {
            res = stg.getInstanceOf("getElem2String");
            res.add("var1", ctx.ID(0).getText());
            res.add("var2", ctx.ID(1).getText());
            res.add("table", ctx.ID(2).getText());
        }


        return res;

    }

    @Override
    public ST visitRead1(tableGramParser.Read1Context ctx) {


        ST res = stg.getInstanceOf("readTable");
        res.add("table", ctx.ID(0).getText());
        res.add("file", ctx.ID(1).getText());

        return res;
    }

    @Override
    public ST visitRead2(tableGramParser.Read2Context ctx) {
        ST res = stg.getInstanceOf("readTable");
        res.add("table", ctx.ID(0).getText());
        res.add("file", ctx.ID(1).getText());
        return res;
    }

    @Override
    public ST visitRemoveTable(tableGramParser.RemoveTableContext ctx) {
        ST res = stg.getInstanceOf("removeTable");
        res.add("table", ctx.ID().getText());
        return res;
    }

    @Override
    public ST visitAddRow1(tableGramParser.AddRow1Context ctx) {
        ST res = stg.getInstanceOf("addRow1");
        res.add("x", ctx.INT(0).getText());
        res.add("table1", tableGramParser.mapa.get(ctx.ID(0).getText()));
        res.add("y", ctx.INT(1).getText());
        res.add("table2", tableGramParser.mapa.get(ctx.ID(1).getText()));
        return res;
    }

    @Override
    public ST visitAddRow2(tableGramParser.AddRow2Context ctx) {
        ST res = stg.getInstanceOf("addRow2");
        res.add("var1", ctx.ID(0).getText());
        res.add("table1", tableGramParser.mapa.get(ctx.ID(1).getText()));
        res.add("var2", ctx.ID(2).getText());
        res.add("table2", tableGramParser.mapa.get(ctx.ID(3).getText()));
        return res;
    }

    @Override
    public ST visitCopyRow1(tableGramParser.CopyRow1Context ctx) {
        ST res = stg.getInstanceOf("copyRow1");
        res.add("x", ctx.INT(0).getText());
        res.add("table1", tableGramParser.mapa.get(ctx.ID(0).getText()));
        res.add("y", ctx.INT(1).getText());
        res.add("table2", tableGramParser.mapa.get(ctx.ID(1).getText()));
        return res;
    }

    @Override
    public ST visitCopyRow2(tableGramParser.CopyRow2Context ctx) {
        ST res = stg.getInstanceOf("copyRow2");
        res.add("var1", ctx.ID(0).getText());
        res.add("table1", tableGramParser.mapa.get(ctx.ID(1).getText()));
        res.add("var2", ctx.ID(2).getText());
        res.add("table2", tableGramParser.mapa.get(ctx.ID(3).getText()));
        return res;
    }

    @Override
    public ST visitNewRowSpecific(tableGramParser.NewRowSpecificContext ctx) {
        ST res = stg.getInstanceOf("newRow1");
        res.add("x", ctx.INT().getText());
        res.add("table", ctx.ID().getText());
        return res;
    }

    @Override
    public ST visitNewRowSimple(tableGramParser.NewRowSimpleContext ctx) {
        ST res = stg.getInstanceOf("newRow2");
        res.add("table", ctx.ID().getText());
        return res;
    }

    @Override
    public ST visitNewRowTable2(tableGramParser.NewRowTable2Context ctx) {
        ST res = stg.getInstanceOf("newRow3");
        res.add("var", ctx.ID(0).getText());
        res.add("table", ctx.ID(1).getText());
        return res;
    }

    @Override
    public ST visitClearRow1(tableGramParser.ClearRow1Context ctx) {
        ST res = stg.getInstanceOf("clearRow1");
        res.add("x", ctx.INT().getText());
        res.add("table", ctx.ID().getText());
        return res;
    }

    @Override
    public ST visitClearRow2(tableGramParser.ClearRow2Context ctx) {
        ST res = stg.getInstanceOf("clearRow2");
        res.add("var", ctx.ID(0).getText());
        res.add("table", tableGramParser.mapa.get(ctx.ID(1).getText()));
        return res;
    }

    @Override
    public ST visitAddColumn1(tableGramParser.AddColumn1Context ctx) {
        ST res = stg.getInstanceOf("addColumn1");
        res.add("x", ctx.INT(0).getText());
        res.add("table1", tableGramParser.mapa.get(ctx.ID(0).getText()));
        res.add("y", ctx.INT(1).getText());
        res.add("table2", tableGramParser.mapa.get(ctx.ID(1).getText()));
        return res;
    }

    @Override
    public ST visitAddColumn2(tableGramParser.AddColumn2Context ctx) {
        ST res = stg.getInstanceOf("addColumn2");
        res.add("var1", ctx.ID(0).getText());
        res.add("table1", tableGramParser.mapa.get(ctx.ID(1).getText()));
        res.add("var2", ctx.ID(2).getText());
        res.add("table2", tableGramParser.mapa.get(ctx.ID(3).getText()));
        return res;
    }

    @Override
    public ST visitCopyColumn1(tableGramParser.CopyColumn1Context ctx) {
        ST res = stg.getInstanceOf("copyColumn1");
        res.add("x", ctx.INT(0).getText());
        res.add("table1", ctx.ID(0).getText());
        res.add("y", ctx.INT(1).getText());
        res.add("table2", ctx.ID(1).getText());
        return res;
    }

    @Override
    public ST visitCopyColumn2(tableGramParser.CopyColumn2Context ctx) {
        ST res = stg.getInstanceOf("copyColumn2");
        res.add("var1", ctx.ID(0).getText());
        res.add("table1", ctx.ID(1).getText());
        res.add("table2", ctx.ID(2).getText());
        return res;
    }

    @Override
    public ST visitNewColumnSpecific(tableGramParser.NewColumnSpecificContext ctx) {
        ST res = stg.getInstanceOf("newColumn1");
        res.add("x", ctx.INT().getText());
        res.add("table", ctx.ID().getText());
        return res;
    }

    @Override
    public ST visitNewColumnSimple(tableGramParser.NewColumnSimpleContext ctx) {
        ST res = stg.getInstanceOf("newColumn2");
        res.add("table", ctx.ID().getText());
        return res;
    }

    @Override
    public ST visitNewColumnTable2(tableGramParser.NewColumnTable2Context ctx) {
        ST res = stg.getInstanceOf("newColumn3");
        res.add("var", ctx.ID(1).getText());
        res.add("type", ctx.ID(0).getText());
        res.add("table", ctx.ID(2).getText());
        return res;
    }

    @Override
    public ST visitClearColumn1(tableGramParser.ClearColumn1Context ctx) {
        ST res = stg.getInstanceOf("clearColumn1");
        res.add("x", Integer.parseInt(ctx.INT().getText()));
        res.add("table", ctx.ID().getText());
        return res;
    }

    @Override
    public ST visitClearColumn2(tableGramParser.ClearColumn2Context ctx) {
        ST res = stg.getInstanceOf("clearColumn2");
        res.add("var", ctx.ID(0).getText());
        res.add("table", tableGramParser.mapa.get(ctx.ID(1).getText()));
        return res;
    }

    @Override
    public ST visitExport(tableGramParser.ExportContext ctx) {
        ST res = stg.getInstanceOf("export");
        res.add("table", ctx.ID(0).getText());
        res.add("file", ctx.ID(1).getText());
        return res;
    }

    @Override
    public ST visitPrintTable(tableGramParser.PrintTableContext ctx) {
        ST res = null;


        if (tableGramParser.mapa.get(ctx.ID().getText()).getType().equals("table")) {
            res = stg.getInstanceOf("printTable");
            res.add("table", ctx.ID().getText());
        } else if (tableGramParser.mapa.get(ctx.ID().getText()).getType().equals("table2")) {
            res = stg.getInstanceOf("printTable");
            res.add("table", ctx.ID().getText());
        } else if (tableGramParser.mapa.get(ctx.ID().getText()).getType().equals("Integer") ||
                tableGramParser.mapa.get(ctx.ID().getText()).getType().equals("Double") ||
                tableGramParser.mapa.get(ctx.ID().getText()).getType().equals("String")) {
            res = stg.getInstanceOf("printVar");
            res.add("var", ctx.ID().getText());
        }

        return res;
    }

    @Override
    public ST visitPrintRow1(tableGramParser.PrintRow1Context ctx) {
        ST res = stg.getInstanceOf("printRow1");
        res.add("x", ctx.INT().getText());
        res.add("table", ctx.ID().getText());
        return res;
    }

    @Override
    public ST visitPrintRow2(tableGramParser.PrintRow2Context ctx) {
        ST res = stg.getInstanceOf("printRow2");
        res.add("var", ctx.ID(0).getText());
        res.add("table", ctx.ID(1).getText());
        return res;
    }

    @Override
    public ST visitPrintColumn1(tableGramParser.PrintColumn1Context ctx) {
        ST res = stg.getInstanceOf("printColumn1");
        res.add("x", ctx.INT().getText());
        res.add("table", ctx.ID().getText());
        return res;
    }

    @Override
    public ST visitPrintColumn2(tableGramParser.PrintColumn2Context ctx) {
        ST res = stg.getInstanceOf("printColumn2");
        res.add("var", ctx.ID(0).getText());
        res.add("table", ctx.ID(1).getText());
        return res;
    }

}
