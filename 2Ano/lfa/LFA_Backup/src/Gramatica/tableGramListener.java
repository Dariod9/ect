// Generated from tableGram.g4 by ANTLR 4.7.2
package Gramatica;
    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link tableGramParser}.
 */
public interface tableGramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link tableGramParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(tableGramParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableGramParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(tableGramParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declareStat}
	 * labeled alternative in {@link tableGramParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDeclareStat(tableGramParser.DeclareStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declareStat}
	 * labeled alternative in {@link tableGramParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDeclareStat(tableGramParser.DeclareStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atrStat}
	 * labeled alternative in {@link tableGramParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAtrStat(tableGramParser.AtrStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atrStat}
	 * labeled alternative in {@link tableGramParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAtrStat(tableGramParser.AtrStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodStat}
	 * labeled alternative in {@link tableGramParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterMethodStat(tableGramParser.MethodStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodStat}
	 * labeled alternative in {@link tableGramParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitMethodStat(tableGramParser.MethodStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link tableGramParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(tableGramParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableGramParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(tableGramParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringDeclaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterStringDeclaring(tableGramParser.StringDeclaringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringDeclaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitStringDeclaring(tableGramParser.StringDeclaringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intDeclaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterIntDeclaring(tableGramParser.IntDeclaringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intDeclaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitIntDeclaring(tableGramParser.IntDeclaringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleDeclaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterDoubleDeclaring(tableGramParser.DoubleDeclaringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleDeclaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitDoubleDeclaring(tableGramParser.DoubleDeclaringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableDeclaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTableDeclaring(tableGramParser.TableDeclaringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableDeclaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTableDeclaring(tableGramParser.TableDeclaringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code table2Declaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTable2Declaring(tableGramParser.Table2DeclaringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code table2Declaring}
	 * labeled alternative in {@link tableGramParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTable2Declaring(tableGramParser.Table2DeclaringContext ctx);
	/**
	 * Enter a parse tree produced by {@link tableGramParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void enterAtribuicao(tableGramParser.AtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableGramParser#atribuicao}.
	 * @param ctx the parse tree
	 */
	void exitAtribuicao(tableGramParser.AtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code method}
	 * labeled alternative in {@link tableGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMethod(tableGramParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code method}
	 * labeled alternative in {@link tableGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMethod(tableGramParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numExpression}
	 * labeled alternative in {@link tableGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumExpression(tableGramParser.NumExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numExpression}
	 * labeled alternative in {@link tableGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumExpression(tableGramParser.NumExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringGet}
	 * labeled alternative in {@link tableGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringGet(tableGramParser.StringGetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringGet}
	 * labeled alternative in {@link tableGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringGet(tableGramParser.StringGetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void enterIdMath(tableGramParser.IdMathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void exitIdMath(tableGramParser.IdMathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void enterParenMath(tableGramParser.ParenMathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void exitParenMath(tableGramParser.ParenMathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multDivMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultDivMath(tableGramParser.MultDivMathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multDivMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultDivMath(tableGramParser.MultDivMathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void enterIntMath(tableGramParser.IntMathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void exitIntMath(tableGramParser.IntMathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubMath(tableGramParser.AddSubMathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubMath(tableGramParser.AddSubMathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void enterDoubleMath(tableGramParser.DoubleMathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleMath}
	 * labeled alternative in {@link tableGramParser#numExpr}.
	 * @param ctx the parse tree
	 */
	void exitDoubleMath(tableGramParser.DoubleMathContext ctx);
	/**
	 * Enter a parse tree produced by {@link tableGramParser#stringExpr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(tableGramParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableGramParser#stringExpr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(tableGramParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newTableMethod}
	 * labeled alternative in {@link tableGramParser#nonVoidMethods}.
	 * @param ctx the parse tree
	 */
	void enterNewTableMethod(tableGramParser.NewTableMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newTableMethod}
	 * labeled alternative in {@link tableGramParser#nonVoidMethods}.
	 * @param ctx the parse tree
	 */
	void exitNewTableMethod(tableGramParser.NewTableMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code copyTableMethod}
	 * labeled alternative in {@link tableGramParser#nonVoidMethods}.
	 * @param ctx the parse tree
	 */
	void enterCopyTableMethod(tableGramParser.CopyTableMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code copyTableMethod}
	 * labeled alternative in {@link tableGramParser#nonVoidMethods}.
	 * @param ctx the parse tree
	 */
	void exitCopyTableMethod(tableGramParser.CopyTableMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code getElemMethod}
	 * labeled alternative in {@link tableGramParser#nonVoidMethods}.
	 * @param ctx the parse tree
	 */
	void enterGetElemMethod(tableGramParser.GetElemMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code getElemMethod}
	 * labeled alternative in {@link tableGramParser#nonVoidMethods}.
	 * @param ctx the parse tree
	 */
	void exitGetElemMethod(tableGramParser.GetElemMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code removeTableMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterRemoveTableMethod(tableGramParser.RemoveTableMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code removeTableMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitRemoveTableMethod(tableGramParser.RemoveTableMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code readTableMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterReadTableMethod(tableGramParser.ReadTableMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code readTableMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitReadTableMethod(tableGramParser.ReadTableMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterAddRowMethod(tableGramParser.AddRowMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitAddRowMethod(tableGramParser.AddRowMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code copyRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterCopyRowMethod(tableGramParser.CopyRowMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code copyRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitCopyRowMethod(tableGramParser.CopyRowMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterNewRowMethod(tableGramParser.NewRowMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitNewRowMethod(tableGramParser.NewRowMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code clearRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterClearRowMethod(tableGramParser.ClearRowMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code clearRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitClearRowMethod(tableGramParser.ClearRowMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertElemMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterInsertElemMethod(tableGramParser.InsertElemMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insertElemMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitInsertElemMethod(tableGramParser.InsertElemMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code removeElemMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterRemoveElemMethod(tableGramParser.RemoveElemMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code removeElemMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitRemoveElemMethod(tableGramParser.RemoveElemMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterAddColumnMethod(tableGramParser.AddColumnMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitAddColumnMethod(tableGramParser.AddColumnMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterNewColumnMethod(tableGramParser.NewColumnMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitNewColumnMethod(tableGramParser.NewColumnMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code copyColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterCopyColumnMethod(tableGramParser.CopyColumnMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code copyColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitCopyColumnMethod(tableGramParser.CopyColumnMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code clearColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterClearColumnMethod(tableGramParser.ClearColumnMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code clearColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitClearColumnMethod(tableGramParser.ClearColumnMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printTableMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterPrintTableMethod(tableGramParser.PrintTableMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printTableMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitPrintTableMethod(tableGramParser.PrintTableMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterPrintRowMethod(tableGramParser.PrintRowMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printRowMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitPrintRowMethod(tableGramParser.PrintRowMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterPrintColumnMethod(tableGramParser.PrintColumnMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printColumnMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitPrintColumnMethod(tableGramParser.PrintColumnMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exportMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void enterExportMethod(tableGramParser.ExportMethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exportMethod}
	 * labeled alternative in {@link tableGramParser#voidMethods}.
	 * @param ctx the parse tree
	 */
	void exitExportMethod(tableGramParser.ExportMethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createDefaultTable}
	 * labeled alternative in {@link tableGramParser#newTable}.
	 * @param ctx the parse tree
	 */
	void enterCreateDefaultTable(tableGramParser.CreateDefaultTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createDefaultTable}
	 * labeled alternative in {@link tableGramParser#newTable}.
	 * @param ctx the parse tree
	 */
	void exitCreateDefaultTable(tableGramParser.CreateDefaultTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createCustomTable}
	 * labeled alternative in {@link tableGramParser#newTable}.
	 * @param ctx the parse tree
	 */
	void enterCreateCustomTable(tableGramParser.CreateCustomTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createCustomTable}
	 * labeled alternative in {@link tableGramParser#newTable}.
	 * @param ctx the parse tree
	 */
	void exitCreateCustomTable(tableGramParser.CreateCustomTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createType2Table}
	 * labeled alternative in {@link tableGramParser#newTable}.
	 * @param ctx the parse tree
	 */
	void enterCreateType2Table(tableGramParser.CreateType2TableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createType2Table}
	 * labeled alternative in {@link tableGramParser#newTable}.
	 * @param ctx the parse tree
	 */
	void exitCreateType2Table(tableGramParser.CreateType2TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link tableGramParser#copyTable}.
	 * @param ctx the parse tree
	 */
	void enterCopyTable(tableGramParser.CopyTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableGramParser#copyTable}.
	 * @param ctx the parse tree
	 */
	void exitCopyTable(tableGramParser.CopyTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertElem1}
	 * labeled alternative in {@link tableGramParser#insertElem}.
	 * @param ctx the parse tree
	 */
	void enterInsertElem1(tableGramParser.InsertElem1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code insertElem1}
	 * labeled alternative in {@link tableGramParser#insertElem}.
	 * @param ctx the parse tree
	 */
	void exitInsertElem1(tableGramParser.InsertElem1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code insertElem2}
	 * labeled alternative in {@link tableGramParser#insertElem}.
	 * @param ctx the parse tree
	 */
	void enterInsertElem2(tableGramParser.InsertElem2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code insertElem2}
	 * labeled alternative in {@link tableGramParser#insertElem}.
	 * @param ctx the parse tree
	 */
	void exitInsertElem2(tableGramParser.InsertElem2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code removeElem1}
	 * labeled alternative in {@link tableGramParser#removeElem}.
	 * @param ctx the parse tree
	 */
	void enterRemoveElem1(tableGramParser.RemoveElem1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code removeElem1}
	 * labeled alternative in {@link tableGramParser#removeElem}.
	 * @param ctx the parse tree
	 */
	void exitRemoveElem1(tableGramParser.RemoveElem1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code removeElem2}
	 * labeled alternative in {@link tableGramParser#removeElem}.
	 * @param ctx the parse tree
	 */
	void enterRemoveElem2(tableGramParser.RemoveElem2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code removeElem2}
	 * labeled alternative in {@link tableGramParser#removeElem}.
	 * @param ctx the parse tree
	 */
	void exitRemoveElem2(tableGramParser.RemoveElem2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code getElem1}
	 * labeled alternative in {@link tableGramParser#getElem}.
	 * @param ctx the parse tree
	 */
	void enterGetElem1(tableGramParser.GetElem1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code getElem1}
	 * labeled alternative in {@link tableGramParser#getElem}.
	 * @param ctx the parse tree
	 */
	void exitGetElem1(tableGramParser.GetElem1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code getElem2}
	 * labeled alternative in {@link tableGramParser#getElem}.
	 * @param ctx the parse tree
	 */
	void enterGetElem2(tableGramParser.GetElem2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code getElem2}
	 * labeled alternative in {@link tableGramParser#getElem}.
	 * @param ctx the parse tree
	 */
	void exitGetElem2(tableGramParser.GetElem2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code read1}
	 * labeled alternative in {@link tableGramParser#readTable}.
	 * @param ctx the parse tree
	 */
	void enterRead1(tableGramParser.Read1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code read1}
	 * labeled alternative in {@link tableGramParser#readTable}.
	 * @param ctx the parse tree
	 */
	void exitRead1(tableGramParser.Read1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code read2}
	 * labeled alternative in {@link tableGramParser#readTable}.
	 * @param ctx the parse tree
	 */
	void enterRead2(tableGramParser.Read2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code read2}
	 * labeled alternative in {@link tableGramParser#readTable}.
	 * @param ctx the parse tree
	 */
	void exitRead2(tableGramParser.Read2Context ctx);
	/**
	 * Enter a parse tree produced by {@link tableGramParser#removeTable}.
	 * @param ctx the parse tree
	 */
	void enterRemoveTable(tableGramParser.RemoveTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableGramParser#removeTable}.
	 * @param ctx the parse tree
	 */
	void exitRemoveTable(tableGramParser.RemoveTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addRow1}
	 * labeled alternative in {@link tableGramParser#addRow}.
	 * @param ctx the parse tree
	 */
	void enterAddRow1(tableGramParser.AddRow1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code addRow1}
	 * labeled alternative in {@link tableGramParser#addRow}.
	 * @param ctx the parse tree
	 */
	void exitAddRow1(tableGramParser.AddRow1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code addRow2}
	 * labeled alternative in {@link tableGramParser#addRow}.
	 * @param ctx the parse tree
	 */
	void enterAddRow2(tableGramParser.AddRow2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code addRow2}
	 * labeled alternative in {@link tableGramParser#addRow}.
	 * @param ctx the parse tree
	 */
	void exitAddRow2(tableGramParser.AddRow2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code copyRow1}
	 * labeled alternative in {@link tableGramParser#copyRow}.
	 * @param ctx the parse tree
	 */
	void enterCopyRow1(tableGramParser.CopyRow1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code copyRow1}
	 * labeled alternative in {@link tableGramParser#copyRow}.
	 * @param ctx the parse tree
	 */
	void exitCopyRow1(tableGramParser.CopyRow1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code copyRow2}
	 * labeled alternative in {@link tableGramParser#copyRow}.
	 * @param ctx the parse tree
	 */
	void enterCopyRow2(tableGramParser.CopyRow2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code copyRow2}
	 * labeled alternative in {@link tableGramParser#copyRow}.
	 * @param ctx the parse tree
	 */
	void exitCopyRow2(tableGramParser.CopyRow2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code newRowSpecific}
	 * labeled alternative in {@link tableGramParser#newRow}.
	 * @param ctx the parse tree
	 */
	void enterNewRowSpecific(tableGramParser.NewRowSpecificContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newRowSpecific}
	 * labeled alternative in {@link tableGramParser#newRow}.
	 * @param ctx the parse tree
	 */
	void exitNewRowSpecific(tableGramParser.NewRowSpecificContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newRowSimple}
	 * labeled alternative in {@link tableGramParser#newRow}.
	 * @param ctx the parse tree
	 */
	void enterNewRowSimple(tableGramParser.NewRowSimpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newRowSimple}
	 * labeled alternative in {@link tableGramParser#newRow}.
	 * @param ctx the parse tree
	 */
	void exitNewRowSimple(tableGramParser.NewRowSimpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newRowTable2}
	 * labeled alternative in {@link tableGramParser#newRow}.
	 * @param ctx the parse tree
	 */
	void enterNewRowTable2(tableGramParser.NewRowTable2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code newRowTable2}
	 * labeled alternative in {@link tableGramParser#newRow}.
	 * @param ctx the parse tree
	 */
	void exitNewRowTable2(tableGramParser.NewRowTable2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code clearRow1}
	 * labeled alternative in {@link tableGramParser#clearRow}.
	 * @param ctx the parse tree
	 */
	void enterClearRow1(tableGramParser.ClearRow1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code clearRow1}
	 * labeled alternative in {@link tableGramParser#clearRow}.
	 * @param ctx the parse tree
	 */
	void exitClearRow1(tableGramParser.ClearRow1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code clearRow2}
	 * labeled alternative in {@link tableGramParser#clearRow}.
	 * @param ctx the parse tree
	 */
	void enterClearRow2(tableGramParser.ClearRow2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code clearRow2}
	 * labeled alternative in {@link tableGramParser#clearRow}.
	 * @param ctx the parse tree
	 */
	void exitClearRow2(tableGramParser.ClearRow2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code addColumn1}
	 * labeled alternative in {@link tableGramParser#addColumn}.
	 * @param ctx the parse tree
	 */
	void enterAddColumn1(tableGramParser.AddColumn1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code addColumn1}
	 * labeled alternative in {@link tableGramParser#addColumn}.
	 * @param ctx the parse tree
	 */
	void exitAddColumn1(tableGramParser.AddColumn1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code addColumn2}
	 * labeled alternative in {@link tableGramParser#addColumn}.
	 * @param ctx the parse tree
	 */
	void enterAddColumn2(tableGramParser.AddColumn2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code addColumn2}
	 * labeled alternative in {@link tableGramParser#addColumn}.
	 * @param ctx the parse tree
	 */
	void exitAddColumn2(tableGramParser.AddColumn2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code copyColumn1}
	 * labeled alternative in {@link tableGramParser#copyColumn}.
	 * @param ctx the parse tree
	 */
	void enterCopyColumn1(tableGramParser.CopyColumn1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code copyColumn1}
	 * labeled alternative in {@link tableGramParser#copyColumn}.
	 * @param ctx the parse tree
	 */
	void exitCopyColumn1(tableGramParser.CopyColumn1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code copyColumn2}
	 * labeled alternative in {@link tableGramParser#copyColumn}.
	 * @param ctx the parse tree
	 */
	void enterCopyColumn2(tableGramParser.CopyColumn2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code copyColumn2}
	 * labeled alternative in {@link tableGramParser#copyColumn}.
	 * @param ctx the parse tree
	 */
	void exitCopyColumn2(tableGramParser.CopyColumn2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code newColumnSpecific}
	 * labeled alternative in {@link tableGramParser#newColumn}.
	 * @param ctx the parse tree
	 */
	void enterNewColumnSpecific(tableGramParser.NewColumnSpecificContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newColumnSpecific}
	 * labeled alternative in {@link tableGramParser#newColumn}.
	 * @param ctx the parse tree
	 */
	void exitNewColumnSpecific(tableGramParser.NewColumnSpecificContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newColumnTable2}
	 * labeled alternative in {@link tableGramParser#newColumn}.
	 * @param ctx the parse tree
	 */
	void enterNewColumnTable2(tableGramParser.NewColumnTable2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code newColumnTable2}
	 * labeled alternative in {@link tableGramParser#newColumn}.
	 * @param ctx the parse tree
	 */
	void exitNewColumnTable2(tableGramParser.NewColumnTable2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code newColumnSimple}
	 * labeled alternative in {@link tableGramParser#newColumn}.
	 * @param ctx the parse tree
	 */
	void enterNewColumnSimple(tableGramParser.NewColumnSimpleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newColumnSimple}
	 * labeled alternative in {@link tableGramParser#newColumn}.
	 * @param ctx the parse tree
	 */
	void exitNewColumnSimple(tableGramParser.NewColumnSimpleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code clearColumn1}
	 * labeled alternative in {@link tableGramParser#clearColumn}.
	 * @param ctx the parse tree
	 */
	void enterClearColumn1(tableGramParser.ClearColumn1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code clearColumn1}
	 * labeled alternative in {@link tableGramParser#clearColumn}.
	 * @param ctx the parse tree
	 */
	void exitClearColumn1(tableGramParser.ClearColumn1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code clearColumn2}
	 * labeled alternative in {@link tableGramParser#clearColumn}.
	 * @param ctx the parse tree
	 */
	void enterClearColumn2(tableGramParser.ClearColumn2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code clearColumn2}
	 * labeled alternative in {@link tableGramParser#clearColumn}.
	 * @param ctx the parse tree
	 */
	void exitClearColumn2(tableGramParser.ClearColumn2Context ctx);
	/**
	 * Enter a parse tree produced by {@link tableGramParser#export}.
	 * @param ctx the parse tree
	 */
	void enterExport(tableGramParser.ExportContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableGramParser#export}.
	 * @param ctx the parse tree
	 */
	void exitExport(tableGramParser.ExportContext ctx);
	/**
	 * Enter a parse tree produced by {@link tableGramParser#printTable}.
	 * @param ctx the parse tree
	 */
	void enterPrintTable(tableGramParser.PrintTableContext ctx);
	/**
	 * Exit a parse tree produced by {@link tableGramParser#printTable}.
	 * @param ctx the parse tree
	 */
	void exitPrintTable(tableGramParser.PrintTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printRow1}
	 * labeled alternative in {@link tableGramParser#printRow}.
	 * @param ctx the parse tree
	 */
	void enterPrintRow1(tableGramParser.PrintRow1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code printRow1}
	 * labeled alternative in {@link tableGramParser#printRow}.
	 * @param ctx the parse tree
	 */
	void exitPrintRow1(tableGramParser.PrintRow1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code printRow2}
	 * labeled alternative in {@link tableGramParser#printRow}.
	 * @param ctx the parse tree
	 */
	void enterPrintRow2(tableGramParser.PrintRow2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code printRow2}
	 * labeled alternative in {@link tableGramParser#printRow}.
	 * @param ctx the parse tree
	 */
	void exitPrintRow2(tableGramParser.PrintRow2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code printColumn1}
	 * labeled alternative in {@link tableGramParser#printColumn}.
	 * @param ctx the parse tree
	 */
	void enterPrintColumn1(tableGramParser.PrintColumn1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code printColumn1}
	 * labeled alternative in {@link tableGramParser#printColumn}.
	 * @param ctx the parse tree
	 */
	void exitPrintColumn1(tableGramParser.PrintColumn1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code printColumn2}
	 * labeled alternative in {@link tableGramParser#printColumn}.
	 * @param ctx the parse tree
	 */
	void enterPrintColumn2(tableGramParser.PrintColumn2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code printColumn2}
	 * labeled alternative in {@link tableGramParser#printColumn}.
	 * @param ctx the parse tree
	 */
	void exitPrintColumn2(tableGramParser.PrintColumn2Context ctx);
}