// Generated from Calc.g4 by ANTLR 4.7.2

    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CalcParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CalcParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declarationStat}
	 * labeled alternative in {@link CalcParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStat(CalcParser.DeclarationStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declarationStat}
	 * labeled alternative in {@link CalcParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStat(CalcParser.DeclarationStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showStat}
	 * labeled alternative in {@link CalcParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterShowStat(CalcParser.ShowStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showStat}
	 * labeled alternative in {@link CalcParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitShowStat(CalcParser.ShowStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CalcParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CalcParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#show}.
	 * @param ctx the parse tree
	 */
	void enterShow(CalcParser.ShowContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#show}.
	 * @param ctx the parse tree
	 */
	void exitShow(CalcParser.ShowContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleExpr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDoubleExpr(CalcParser.DoubleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleExpr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDoubleExpr(CalcParser.DoubleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(CalcParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(CalcParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(CalcParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(CalcParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(CalcParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(CalcParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(CalcParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(CalcParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(CalcParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link CalcParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(CalcParser.IdExprContext ctx);
}