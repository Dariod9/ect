// Generated from ex42.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ex42Parser}.
 */
public interface ex42Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ex42Parser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(ex42Parser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex42Parser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(ex42Parser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ex42Parser#i}.
	 * @param ctx the parse tree
	 */
	void enterI(ex42Parser.IContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex42Parser#i}.
	 * @param ctx the parse tree
	 */
	void exitI(ex42Parser.IContext ctx);
	/**
	 * Enter a parse tree produced by {@link ex42Parser#e}.
	 * @param ctx the parse tree
	 */
	void enterE(ex42Parser.EContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex42Parser#e}.
	 * @param ctx the parse tree
	 */
	void exitE(ex42Parser.EContext ctx);
	/**
	 * Enter a parse tree produced by {@link ex42Parser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(ex42Parser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex42Parser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(ex42Parser.RContext ctx);
}