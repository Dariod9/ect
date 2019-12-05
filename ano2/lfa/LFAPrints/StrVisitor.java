// Generated from Str.g4 by ANTLR 4.7.2

    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link StrParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface StrVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link StrParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(StrParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declarationStat}
	 * labeled alternative in {@link StrParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationStat(StrParser.DeclarationStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link StrParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(StrParser.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link StrParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(StrParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link StrParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(StrParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(StrParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mathExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathExpr(StrParser.MathExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inputExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputExpr(StrParser.InputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code concatExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatExpr(StrParser.ConcatExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link StrParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(StrParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link StrParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(StrParser.InputContext ctx);
}