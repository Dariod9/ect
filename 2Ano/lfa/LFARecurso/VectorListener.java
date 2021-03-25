// Generated from Vector.g4 by ANTLR 4.7.2

    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link VectorParser}.
 */
public interface VectorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link VectorParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(VectorParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link VectorParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(VectorParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declarationStat}
	 * labeled alternative in {@link VectorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStat(VectorParser.DeclarationStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declarationStat}
	 * labeled alternative in {@link VectorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStat(VectorParser.DeclarationStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showStat}
	 * labeled alternative in {@link VectorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterShowStat(VectorParser.ShowStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showStat}
	 * labeled alternative in {@link VectorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitShowStat(VectorParser.ShowStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link VectorParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(VectorParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link VectorParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(VectorParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showID}
	 * labeled alternative in {@link VectorParser#show}.
	 * @param ctx the parse tree
	 */
	void enterShowID(VectorParser.ShowIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showID}
	 * labeled alternative in {@link VectorParser#show}.
	 * @param ctx the parse tree
	 */
	void exitShowID(VectorParser.ShowIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code showExpr}
	 * labeled alternative in {@link VectorParser#show}.
	 * @param ctx the parse tree
	 */
	void enterShowExpr(VectorParser.ShowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code showExpr}
	 * labeled alternative in {@link VectorParser#show}.
	 * @param ctx the parse tree
	 */
	void exitShowExpr(VectorParser.ShowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInt}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInt(VectorParser.ExprIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInt}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInt(VectorParser.ExprIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprParen}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParen(VectorParser.ExprParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprParen}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParen(VectorParser.ExprParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprDouble}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprDouble(VectorParser.ExprDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprDouble}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprDouble(VectorParser.ExprDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprVec}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprVec(VectorParser.ExprVecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprVec}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprVec(VectorParser.ExprVecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprID}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(VectorParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprID}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(VectorParser.ExprIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMult}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMult(VectorParser.ExprMultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMult}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMult(VectorParser.ExprMultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSum}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSum(VectorParser.ExprSumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSum}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSum(VectorParser.ExprSumContext ctx);
	/**
	 * Enter a parse tree produced by {@link VectorParser#vec}.
	 * @param ctx the parse tree
	 */
	void enterVec(VectorParser.VecContext ctx);
	/**
	 * Exit a parse tree produced by {@link VectorParser#vec}.
	 * @param ctx the parse tree
	 */
	void exitVec(VectorParser.VecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code progressiveNum}
	 * labeled alternative in {@link VectorParser#num}.
	 * @param ctx the parse tree
	 */
	void enterProgressiveNum(VectorParser.ProgressiveNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code progressiveNum}
	 * labeled alternative in {@link VectorParser#num}.
	 * @param ctx the parse tree
	 */
	void exitProgressiveNum(VectorParser.ProgressiveNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleNum}
	 * labeled alternative in {@link VectorParser#num}.
	 * @param ctx the parse tree
	 */
	void enterDoubleNum(VectorParser.DoubleNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleNum}
	 * labeled alternative in {@link VectorParser#num}.
	 * @param ctx the parse tree
	 */
	void exitDoubleNum(VectorParser.DoubleNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intNum}
	 * labeled alternative in {@link VectorParser#num}.
	 * @param ctx the parse tree
	 */
	void enterIntNum(VectorParser.IntNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intNum}
	 * labeled alternative in {@link VectorParser#num}.
	 * @param ctx the parse tree
	 */
	void exitIntNum(VectorParser.IntNumContext ctx);
}