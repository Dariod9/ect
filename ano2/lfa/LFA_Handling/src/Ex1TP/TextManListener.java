package Ex1TP;

// Generated from TextMan.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TextManParser}.
 */
public interface TextManListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TextManParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TextManParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TextManParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TextManParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decLine}
	 * labeled alternative in {@link TextManParser#line}.
	 * @param ctx the parse tree
	 */
	void enterDecLine(TextManParser.DecLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decLine}
	 * labeled alternative in {@link TextManParser#line}.
	 * @param ctx the parse tree
	 */
	void exitDecLine(TextManParser.DecLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printLine}
	 * labeled alternative in {@link TextManParser#line}.
	 * @param ctx the parse tree
	 */
	void enterPrintLine(TextManParser.PrintLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printLine}
	 * labeled alternative in {@link TextManParser#line}.
	 * @param ctx the parse tree
	 */
	void exitPrintLine(TextManParser.PrintLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inputLine}
	 * labeled alternative in {@link TextManParser#line}.
	 * @param ctx the parse tree
	 */
	void enterInputLine(TextManParser.InputLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inputLine}
	 * labeled alternative in {@link TextManParser#line}.
	 * @param ctx the parse tree
	 */
	void exitInputLine(TextManParser.InputLineContext ctx);
	/**
	 * Enter a parse tree produced by {@link TextManParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterDec(TextManParser.DecContext ctx);
	/**
	 * Exit a parse tree produced by {@link TextManParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitDec(TextManParser.DecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printID}
	 * labeled alternative in {@link TextManParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrintID(TextManParser.PrintIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printID}
	 * labeled alternative in {@link TextManParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrintID(TextManParser.PrintIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printString}
	 * labeled alternative in {@link TextManParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrintString(TextManParser.PrintStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printString}
	 * labeled alternative in {@link TextManParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrintString(TextManParser.PrintStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printInput}
	 * labeled alternative in {@link TextManParser#input}.
	 * @param ctx the parse tree
	 */
	void enterPrintInput(TextManParser.PrintInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printInput}
	 * labeled alternative in {@link TextManParser#input}.
	 * @param ctx the parse tree
	 */
	void exitPrintInput(TextManParser.PrintInputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IDInput}
	 * labeled alternative in {@link TextManParser#input}.
	 * @param ctx the parse tree
	 */
	void enterIDInput(TextManParser.IDInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IDInput}
	 * labeled alternative in {@link TextManParser#input}.
	 * @param ctx the parse tree
	 */
	void exitIDInput(TextManParser.IDInputContext ctx);
}