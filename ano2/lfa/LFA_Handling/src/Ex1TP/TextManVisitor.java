package Ex1TP;

// Generated from TextMan.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TextManParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TextManVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TextManParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TextManParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decLine}
	 * labeled alternative in {@link TextManParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecLine(TextManParser.DecLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printLine}
	 * labeled alternative in {@link TextManParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintLine(TextManParser.PrintLineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inputLine}
	 * labeled alternative in {@link TextManParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputLine(TextManParser.InputLineContext ctx);
	/**
	 * Visit a parse tree produced by {@link TextManParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDec(TextManParser.DecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printID}
	 * labeled alternative in {@link TextManParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintID(TextManParser.PrintIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printString}
	 * labeled alternative in {@link TextManParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintString(TextManParser.PrintStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printInput}
	 * labeled alternative in {@link TextManParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintInput(TextManParser.PrintInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IDInput}
	 * labeled alternative in {@link TextManParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIDInput(TextManParser.IDInputContext ctx);
}