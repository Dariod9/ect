// Generated from Str.g4 by ANTLR 4.7.2

    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StrParser}.
 */
public interface StrListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StrParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(StrParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(StrParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declarationStat}
	 * labeled alternative in {@link StrParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStat(StrParser.DeclarationStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declarationStat}
	 * labeled alternative in {@link StrParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStat(StrParser.DeclarationStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link StrParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(StrParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link StrParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(StrParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link StrParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(StrParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(StrParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link StrParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(StrParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(StrParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(StrParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(StrParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mathExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMathExpr(StrParser.MathExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mathExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMathExpr(StrParser.MathExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inputExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInputExpr(StrParser.InputExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inputExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInputExpr(StrParser.InputExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code concatExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConcatExpr(StrParser.ConcatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code concatExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConcatExpr(StrParser.ConcatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(StrParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(StrParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link StrParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(StrParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(StrParser.InputContext ctx);
}