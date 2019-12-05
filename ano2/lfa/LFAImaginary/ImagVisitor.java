// Generated from Imag.g4 by ANTLR 4.7.2

    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ImagParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ImagVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ImagParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ImagParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declarationStat}
	 * labeled alternative in {@link ImagParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationStat(ImagParser.DeclarationStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link ImagParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStat(ImagParser.PrintStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImagParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(ImagParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImagParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(ImagParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleExpr(ImagParser.DoubleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(ImagParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(ImagParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(ImagParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(ImagParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(ImagParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pointExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointExpr(ImagParser.PointExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImagParser#point}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPoint(ImagParser.PointContext ctx);
	/**
	 * Visit a parse tree produced by {@link ImagParser#opp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpp(ImagParser.OppContext ctx);
}