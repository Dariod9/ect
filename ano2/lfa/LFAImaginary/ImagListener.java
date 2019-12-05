// Generated from Imag.g4 by ANTLR 4.7.2

    import java.util.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ImagParser}.
 */
public interface ImagListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ImagParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ImagParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ImagParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declarationStat}
	 * labeled alternative in {@link ImagParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStat(ImagParser.DeclarationStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declarationStat}
	 * labeled alternative in {@link ImagParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStat(ImagParser.DeclarationStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link ImagParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(ImagParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStat}
	 * labeled alternative in {@link ImagParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(ImagParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImagParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(ImagParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(ImagParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImagParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ImagParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ImagParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDoubleExpr(ImagParser.DoubleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDoubleExpr(ImagParser.DoubleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(ImagParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(ImagParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(ImagParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(ImagParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(ImagParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(ImagParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(ImagParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(ImagParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(ImagParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(ImagParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pointExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPointExpr(ImagParser.PointExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pointExpr}
	 * labeled alternative in {@link ImagParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPointExpr(ImagParser.PointExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImagParser#point}.
	 * @param ctx the parse tree
	 */
	void enterPoint(ImagParser.PointContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagParser#point}.
	 * @param ctx the parse tree
	 */
	void exitPoint(ImagParser.PointContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImagParser#opp}.
	 * @param ctx the parse tree
	 */
	void enterOpp(ImagParser.OppContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImagParser#opp}.
	 * @param ctx the parse tree
	 */
	void exitOpp(ImagParser.OppContext ctx);
}