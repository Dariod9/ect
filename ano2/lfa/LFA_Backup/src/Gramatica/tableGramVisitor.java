// Generated from tableGram.g4 by ANTLR 4.7.2
package Gramatica;
    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link tableGramParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface tableGramVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link tableGramParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(tableGramParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declareStat}
	 * labeled alternative in {@link tableGramParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareStat(tableGramParser.DeclareStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atrStat}
	 * labeled alternative in {@link tableGramParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtrStat(tableGramParser.AtrStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodStat}
	 * labeled alternative in {@link tableGramParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodStat(tableGramParser.MethodStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link tableGramParser#declaracao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao(tableGramParser.DeclaracaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringDeclaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringDeclaring(tableGramParser.StringDeclaringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intDeclaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntDeclaring(tableGramParser.IntDeclaringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleDeclaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleDeclaring(tableGramParser.DoubleDeclaringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tableDeclaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableDeclaring(tableGramParser.TableDeclaringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code table2Declaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable2Declaring(tableGramParser.Table2DeclaringContext ctx);
	/**
	 * Visit a parse tree produced by {@link tableGramParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao(tableGramParser.AtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code method}
	 * labeled alternative in {@link tableGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(tableGramParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numExpression}
	 * labeled alternative in {@link tableGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExpression(tableGramParser.NumExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringGet}
	 * labeled alternative in {@link tableGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringGet(tableGramParser.StringGetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdMath(tableGramParser.IdMathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenMath(tableGramParser.ParenMathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDivMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivMath(tableGramParser.MultDivMathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntMath(tableGramParser.IntMathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubMath(tableGramParser.AddSubMathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleMath(tableGramParser.DoubleMathContext ctx);
	/**
	 * Visit a parse tree produced by {@link tableGramParser#stringExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(tableGramParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newTableMethod}
	 * labeled alternative in {@link tableGramParser#nonVoidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewTableMethod(tableGramParser.NewTableMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code copyTableMethod}
	 * labeled alternative in {@link tableGramParser#nonVoidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCopyTableMethod(tableGramParser.CopyTableMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code getElemMethod}
	 * labeled alternative in {@link tableGramParser#nonVoidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetElemMethod(tableGramParser.GetElemMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code removeTableMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveTableMethod(tableGramParser.RemoveTableMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readTableMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadTableMethod(tableGramParser.ReadTableMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddRowMethod(tableGramParser.AddRowMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code copyRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCopyRowMethod(tableGramParser.CopyRowMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewRowMethod(tableGramParser.NewRowMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code clearRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClearRowMethod(tableGramParser.ClearRowMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insertElemMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertElemMethod(tableGramParser.InsertElemMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code removeElemMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveElemMethod(tableGramParser.RemoveElemMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddColumnMethod(tableGramParser.AddColumnMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewColumnMethod(tableGramParser.NewColumnMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code copyColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCopyColumnMethod(tableGramParser.CopyColumnMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code clearColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClearColumnMethod(tableGramParser.ClearColumnMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printTableMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintTableMethod(tableGramParser.PrintTableMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintRowMethod(tableGramParser.PrintRowMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintColumnMethod(tableGramParser.PrintColumnMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exportMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportMethod(tableGramParser.ExportMethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createDefaultTable}
	 * labeled alternative in {@link tableGramParser#newTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateDefaultTable(tableGramParser.CreateDefaultTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createCustomTable}
	 * labeled alternative in {@link tableGramParser#newTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateCustomTable(tableGramParser.CreateCustomTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createType2Table}
	 * labeled alternative in {@link tableGramParser#newTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateType2Table(tableGramParser.CreateType2TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link tableGramParser#copyTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCopyTable(tableGramParser.CopyTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insertElem1}
	 * labeled alternative in {@link tableGramParser#insertElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertElem1(tableGramParser.InsertElem1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code insertElem2}
	 * labeled alternative in {@link tableGramParser#insertElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertElem2(tableGramParser.InsertElem2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code removeElem1}
	 * labeled alternative in {@link tableGramParser#removeElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveElem1(tableGramParser.RemoveElem1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code removeElem2}
	 * labeled alternative in {@link tableGramParser#removeElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveElem2(tableGramParser.RemoveElem2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code getElem1}
	 * labeled alternative in {@link tableGramParser#getElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetElem1(tableGramParser.GetElem1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code getElem2}
	 * labeled alternative in {@link tableGramParser#getElem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetElem2(tableGramParser.GetElem2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code read1}
	 * labeled alternative in {@link tableGramParser#readTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead1(tableGramParser.Read1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code read2}
	 * labeled alternative in {@link tableGramParser#readTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead2(tableGramParser.Read2Context ctx);
	/**
	 * Visit a parse tree produced by {@link tableGramParser#removeTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemoveTable(tableGramParser.RemoveTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addRow1}
	 * labeled alternative in {@link tableGramParser#addRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddRow1(tableGramParser.AddRow1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code addRow2}
	 * labeled alternative in {@link tableGramParser#addRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddRow2(tableGramParser.AddRow2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code copyRow1}
	 * labeled alternative in {@link tableGramParser#copyRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCopyRow1(tableGramParser.CopyRow1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code copyRow2}
	 * labeled alternative in {@link tableGramParser#copyRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCopyRow2(tableGramParser.CopyRow2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code newRowSpecific}
	 * labeled alternative in {@link tableGramParser#newRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewRowSpecific(tableGramParser.NewRowSpecificContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newRowSimple}
	 * labeled alternative in {@link tableGramParser#newRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewRowSimple(tableGramParser.NewRowSimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newRowTable2}
	 * labeled alternative in {@link tableGramParser#newRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewRowTable2(tableGramParser.NewRowTable2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code clearRow1}
	 * labeled alternative in {@link tableGramParser#clearRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClearRow1(tableGramParser.ClearRow1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code clearRow2}
	 * labeled alternative in {@link tableGramParser#clearRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClearRow2(tableGramParser.ClearRow2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code addColumn1}
	 * labeled alternative in {@link tableGramParser#addColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddColumn1(tableGramParser.AddColumn1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code addColumn2}
	 * labeled alternative in {@link tableGramParser#addColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddColumn2(tableGramParser.AddColumn2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code copyColumn1}
	 * labeled alternative in {@link tableGramParser#copyColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCopyColumn1(tableGramParser.CopyColumn1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code copyColumn2}
	 * labeled alternative in {@link tableGramParser#copyColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCopyColumn2(tableGramParser.CopyColumn2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code newColumnSpecific}
	 * labeled alternative in {@link tableGramParser#newColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewColumnSpecific(tableGramParser.NewColumnSpecificContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newColumnTable2}
	 * labeled alternative in {@link tableGramParser#newColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewColumnTable2(tableGramParser.NewColumnTable2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code newColumnSimple}
	 * labeled alternative in {@link tableGramParser#newColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewColumnSimple(tableGramParser.NewColumnSimpleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code clearColumn1}
	 * labeled alternative in {@link tableGramParser#clearColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClearColumn1(tableGramParser.ClearColumn1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code clearColumn2}
	 * labeled alternative in {@link tableGramParser#clearColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClearColumn2(tableGramParser.ClearColumn2Context ctx);
	/**
	 * Visit a parse tree produced by {@link tableGramParser#export}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExport(tableGramParser.ExportContext ctx);
	/**
	 * Visit a parse tree produced by {@link tableGramParser#printTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintTable(tableGramParser.PrintTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printRow1}
	 * labeled alternative in {@link tableGramParser#printRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintRow1(tableGramParser.PrintRow1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code printRow2}
	 * labeled alternative in {@link tableGramParser#printRow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintRow2(tableGramParser.PrintRow2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code printColumn1}
	 * labeled alternative in {@link tableGramParser#printColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintColumn1(tableGramParser.PrintColumn1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code printColumn2}
	 * labeled alternative in {@link tableGramParser#printColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintColumn2(tableGramParser.PrintColumn2Context ctx);
}