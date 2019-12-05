// Generated from Suff.g4 by ANTLR 4.7.2
 import java.util.*; 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SuffParser}.
 */
public interface SuffListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SuffParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(SuffParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SuffParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(SuffParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SuffParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(SuffParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link SuffParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(SuffParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link SuffParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(SuffParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SuffParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(SuffParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SuffParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SuffParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SuffParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SuffParser.ExprContext ctx);
}