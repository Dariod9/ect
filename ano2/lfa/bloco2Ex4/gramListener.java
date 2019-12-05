// Generated from gram.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link gramParser}.
 */
public interface gramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link gramParser#pro}.
	 * @param ctx the parse tree
	 */
	void enterPro(gramParser.ProContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#pro}.
	 * @param ctx the parse tree
	 */
	void exitPro(gramParser.ProContext ctx);
	/**
	 * Enter a parse tree produced by {@link gramParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(gramParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link gramParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(gramParser.LineContext ctx);
}