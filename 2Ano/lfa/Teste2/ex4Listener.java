// Generated from ex4.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ex4Parser}.
 */
public interface ex4Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ex4Parser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(ex4Parser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex4Parser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(ex4Parser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link ex4Parser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(ex4Parser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex4Parser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(ex4Parser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ex4Parser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(ex4Parser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex4Parser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(ex4Parser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ex4Parser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(ex4Parser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link ex4Parser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(ex4Parser.StringContext ctx);
}