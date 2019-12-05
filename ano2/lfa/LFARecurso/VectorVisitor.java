// Generated from Vector.g4 by ANTLR 4.7.2

    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link VectorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface VectorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link VectorParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(VectorParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declarationStat}
	 * labeled alternative in {@link VectorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationStat(VectorParser.DeclarationStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showStat}
	 * labeled alternative in {@link VectorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowStat(VectorParser.ShowStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link VectorParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(VectorParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showID}
	 * labeled alternative in {@link VectorParser#show}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowID(VectorParser.ShowIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code showExpr}
	 * labeled alternative in {@link VectorParser#show}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowExpr(VectorParser.ShowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprInt}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInt(VectorParser.ExprIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprParen}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParen(VectorParser.ExprParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprDouble}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDouble(VectorParser.ExprDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprVec}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVec(VectorParser.ExprVecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprID}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprID(VectorParser.ExprIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMult}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMult(VectorParser.ExprMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSum}
	 * labeled alternative in {@link VectorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSum(VectorParser.ExprSumContext ctx);
	/**
	 * Visit a parse tree produced by {@link VectorParser#vec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVec(VectorParser.VecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code progressiveNum}
	 * labeled alternative in {@link VectorParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgressiveNum(VectorParser.ProgressiveNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleNum}
	 * labeled alternative in {@link VectorParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleNum(VectorParser.DoubleNumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intNum}
	 * labeled alternative in {@link VectorParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntNum(VectorParser.IntNumContext ctx);
}