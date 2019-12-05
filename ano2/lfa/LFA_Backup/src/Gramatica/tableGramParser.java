// Generated from tableGram.g4 by ANTLR 4.7.2
package Gramatica;
    import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class tableGramParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, ID=40, INT=41, DOUBLE=42, STRING=43, COMMENT_Line=44, COMMENT_Section=45, 
		WS=46, ERROR=47;
	public static final int
		RULE_main = 0, RULE_stat = 1, RULE_declaracao = 2, RULE_tipo = 3, RULE_atribuicao = 4, 
		RULE_expr = 5, RULE_numExpr = 6, RULE_stringExpr = 7, RULE_nonVoidMethods = 8, 
		RULE_voidMethods = 9, RULE_newTable = 10, RULE_copyTable = 11, RULE_insertElem = 12, 
		RULE_removeElem = 13, RULE_getElem = 14, RULE_readTable = 15, RULE_removeTable = 16, 
		RULE_addRow = 17, RULE_copyRow = 18, RULE_newRow = 19, RULE_clearRow = 20, 
		RULE_addColumn = 21, RULE_copyColumn = 22, RULE_newColumn = 23, RULE_clearColumn = 24, 
		RULE_export = 25, RULE_printTable = 26, RULE_printRow = 27, RULE_printColumn = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "stat", "declaracao", "tipo", "atribuicao", "expr", "numExpr", 
			"stringExpr", "nonVoidMethods", "voidMethods", "newTable", "copyTable", 
			"insertElem", "removeElem", "getElem", "readTable", "removeTable", "addRow", 
			"copyRow", "newRow", "clearRow", "addColumn", "copyColumn", "newColumn", 
			"clearColumn", "export", "printTable", "printRow", "printColumn"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'String'", "'Integer'", "'Double'", "'table'", "'table2'", "'='", 
			"'*'", "'/'", "'+'", "'-'", "'('", "')'", "'createTable'", "'createStringTable'", 
			"'copy'", "'insert'", "','", "'remove'", "'removeType2'", "'get'", "'->'", 
			"'readType1'", "'.csv'", "'readType2'", "'deleteTable'", "'addRow'", 
			"'copyRow'", "'newRow'", "'clearRow'", "'addColumn'", "'copyColumn'", 
			"'newColumn'", "'newColumn2 '", "'clearColumn'", "'save'", "'to'", "'print'", 
			"'printRow'", "'printColumn'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "ID", "INT", "DOUBLE", "STRING", "COMMENT_Line", 
			"COMMENT_Section", "WS", "ERROR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "tableGram.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    public static Map<String,Variable> mapa = new HashMap<>();
	    public static ArrayList<Variable> tables =  new ArrayList<>();

	public tableGramParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class MainContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(tableGramParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << ID))) != 0)) {
				{
				{
				setState(58);
				stat();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MethodStatContext extends StatContext {
		public VoidMethodsContext voidMethods() {
			return getRuleContext(VoidMethodsContext.class,0);
		}
		public MethodStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterMethodStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitMethodStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitMethodStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclareStatContext extends StatContext {
		public DeclaracaoContext declaracao() {
			return getRuleContext(DeclaracaoContext.class,0);
		}
		public DeclareStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterDeclareStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitDeclareStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitDeclareStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtrStatContext extends StatContext {
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public AtrStatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterAtrStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitAtrStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitAtrStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new DeclareStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				declaracao();
				}
				break;
			case 2:
				_localctx = new AtrStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				atribuicao();
				}
				break;
			case 3:
				_localctx = new MethodStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				voidMethods();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracaoContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public DeclaracaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterDeclaracao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitDeclaracao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitDeclaracao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracaoContext declaracao() throws RecognitionException {
		DeclaracaoContext _localctx = new DeclaracaoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			tipo();
			setState(72);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	 
		public TipoContext() { }
		public void copyFrom(TipoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Table2DeclaringContext extends TipoContext {
		public Table2DeclaringContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterTable2Declaring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitTable2Declaring(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitTable2Declaring(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntDeclaringContext extends TipoContext {
		public IntDeclaringContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterIntDeclaring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitIntDeclaring(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitIntDeclaring(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TableDeclaringContext extends TipoContext {
		public TableDeclaringContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterTableDeclaring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitTableDeclaring(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitTableDeclaring(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleDeclaringContext extends TipoContext {
		public DoubleDeclaringContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterDoubleDeclaring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitDoubleDeclaring(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitDoubleDeclaring(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringDeclaringContext extends TipoContext {
		public StringDeclaringContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterStringDeclaring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitStringDeclaring(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitStringDeclaring(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tipo);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new StringDeclaringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(T__0);
				}
				break;
			case T__1:
				_localctx = new IntDeclaringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(T__1);
				}
				break;
			case T__2:
				_localctx = new DoubleDeclaringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(T__2);
				}
				break;
			case T__3:
				_localctx = new TableDeclaringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				match(T__3);
				}
				break;
			case T__4:
				_localctx = new Table2DeclaringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtribuicaoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitAtribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(ID);
			setState(82);
			match(T__5);
			setState(83);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringGetContext extends ExprContext {
		public StringExprContext stringExpr() {
			return getRuleContext(StringExprContext.class,0);
		}
		public StringGetContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterStringGet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitStringGet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitStringGet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MethodContext extends ExprContext {
		public NonVoidMethodsContext nonVoidMethods() {
			return getRuleContext(NonVoidMethodsContext.class,0);
		}
		public MethodContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumExpressionContext extends ExprContext {
		public NumExprContext numExpr() {
			return getRuleContext(NumExprContext.class,0);
		}
		public NumExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterNumExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitNumExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitNumExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__13:
			case T__14:
			case T__19:
				_localctx = new MethodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				nonVoidMethods();
				}
				break;
			case T__10:
			case ID:
			case INT:
			case DOUBLE:
				_localctx = new NumExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				numExpr(0);
				}
				break;
			case STRING:
				_localctx = new StringGetContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				stringExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumExprContext extends ParserRuleContext {
		public String value;
		public NumExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numExpr; }
	 
		public NumExprContext() { }
		public void copyFrom(NumExprContext ctx) {
			super.copyFrom(ctx);
			this.value = ctx.value;
		}
	}
	public static class IdMathContext extends NumExprContext {
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public IdMathContext(NumExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterIdMath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitIdMath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitIdMath(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenMathContext extends NumExprContext {
		public NumExprContext numExpr() {
			return getRuleContext(NumExprContext.class,0);
		}
		public ParenMathContext(NumExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterParenMath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitParenMath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitParenMath(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultDivMathContext extends NumExprContext {
		public NumExprContext e1;
		public Token op;
		public NumExprContext e2;
		public List<NumExprContext> numExpr() {
			return getRuleContexts(NumExprContext.class);
		}
		public NumExprContext numExpr(int i) {
			return getRuleContext(NumExprContext.class,i);
		}
		public MultDivMathContext(NumExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterMultDivMath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitMultDivMath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitMultDivMath(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntMathContext extends NumExprContext {
		public TerminalNode INT() { return getToken(tableGramParser.INT, 0); }
		public IntMathContext(NumExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterIntMath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitIntMath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitIntMath(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubMathContext extends NumExprContext {
		public NumExprContext e1;
		public Token op;
		public NumExprContext e2;
		public List<NumExprContext> numExpr() {
			return getRuleContexts(NumExprContext.class);
		}
		public NumExprContext numExpr(int i) {
			return getRuleContext(NumExprContext.class,i);
		}
		public AddSubMathContext(NumExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterAddSubMath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitAddSubMath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitAddSubMath(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DoubleMathContext extends NumExprContext {
		public TerminalNode DOUBLE() { return getToken(tableGramParser.DOUBLE, 0); }
		public DoubleMathContext(NumExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterDoubleMath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitDoubleMath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitDoubleMath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumExprContext numExpr() throws RecognitionException {
		return numExpr(0);
	}

	private NumExprContext numExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NumExprContext _localctx = new NumExprContext(_ctx, _parentState);
		NumExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_numExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				{
				_localctx = new ParenMathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(91);
				match(T__10);
				setState(92);
				numExpr(0);
				setState(93);
				match(T__11);
				}
				break;
			case INT:
				{
				_localctx = new IntMathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				match(INT);
				}
				break;
			case DOUBLE:
				{
				_localctx = new DoubleMathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				match(DOUBLE);
				}
				break;
			case ID:
				{
				_localctx = new IdMathContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(106);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new MultDivMathContext(new NumExprContext(_parentctx, _parentState));
						((MultDivMathContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_numExpr);
						setState(100);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(101);
						((MultDivMathContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
							((MultDivMathContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(102);
						((MultDivMathContext)_localctx).e2 = numExpr(7);
						}
						break;
					case 2:
						{
						_localctx = new AddSubMathContext(new NumExprContext(_parentctx, _parentState));
						((AddSubMathContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_numExpr);
						setState(103);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(104);
						((AddSubMathContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__8 || _la==T__9) ) {
							((AddSubMathContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(105);
						((AddSubMathContext)_localctx).e2 = numExpr(6);
						}
						break;
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StringExprContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(tableGramParser.STRING, 0); }
		public StringExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterStringExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitStringExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitStringExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringExprContext stringExpr() throws RecognitionException {
		StringExprContext _localctx = new StringExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stringExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonVoidMethodsContext extends ParserRuleContext {
		public NonVoidMethodsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonVoidMethods; }
	 
		public NonVoidMethodsContext() { }
		public void copyFrom(NonVoidMethodsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CopyTableMethodContext extends NonVoidMethodsContext {
		public CopyTableContext copyTable() {
			return getRuleContext(CopyTableContext.class,0);
		}
		public CopyTableMethodContext(NonVoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterCopyTableMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitCopyTableMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitCopyTableMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetElemMethodContext extends NonVoidMethodsContext {
		public GetElemContext getElem() {
			return getRuleContext(GetElemContext.class,0);
		}
		public GetElemMethodContext(NonVoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterGetElemMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitGetElemMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitGetElemMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewTableMethodContext extends NonVoidMethodsContext {
		public NewTableContext newTable() {
			return getRuleContext(NewTableContext.class,0);
		}
		public NewTableMethodContext(NonVoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterNewTableMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitNewTableMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitNewTableMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonVoidMethodsContext nonVoidMethods() throws RecognitionException {
		NonVoidMethodsContext _localctx = new NonVoidMethodsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_nonVoidMethods);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case T__13:
				_localctx = new NewTableMethodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				newTable();
				}
				break;
			case T__14:
				_localctx = new CopyTableMethodContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				copyTable();
				}
				break;
			case T__19:
				_localctx = new GetElemMethodContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				getElem();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VoidMethodsContext extends ParserRuleContext {
		public VoidMethodsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidMethods; }
	 
		public VoidMethodsContext() { }
		public void copyFrom(VoidMethodsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RemoveElemMethodContext extends VoidMethodsContext {
		public RemoveElemContext removeElem() {
			return getRuleContext(RemoveElemContext.class,0);
		}
		public RemoveElemMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterRemoveElemMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitRemoveElemMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitRemoveElemMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewColumnMethodContext extends VoidMethodsContext {
		public NewColumnContext newColumn() {
			return getRuleContext(NewColumnContext.class,0);
		}
		public NewColumnMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterNewColumnMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitNewColumnMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitNewColumnMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintRowMethodContext extends VoidMethodsContext {
		public PrintRowContext printRow() {
			return getRuleContext(PrintRowContext.class,0);
		}
		public PrintRowMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterPrintRowMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitPrintRowMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitPrintRowMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CopyColumnMethodContext extends VoidMethodsContext {
		public CopyColumnContext copyColumn() {
			return getRuleContext(CopyColumnContext.class,0);
		}
		public CopyColumnMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterCopyColumnMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitCopyColumnMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitCopyColumnMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddRowMethodContext extends VoidMethodsContext {
		public AddRowContext addRow() {
			return getRuleContext(AddRowContext.class,0);
		}
		public AddRowMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterAddRowMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitAddRowMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitAddRowMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewRowMethodContext extends VoidMethodsContext {
		public NewRowContext newRow() {
			return getRuleContext(NewRowContext.class,0);
		}
		public NewRowMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterNewRowMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitNewRowMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitNewRowMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExportMethodContext extends VoidMethodsContext {
		public ExportContext export() {
			return getRuleContext(ExportContext.class,0);
		}
		public ExportMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterExportMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitExportMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitExportMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddColumnMethodContext extends VoidMethodsContext {
		public AddColumnContext addColumn() {
			return getRuleContext(AddColumnContext.class,0);
		}
		public AddColumnMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterAddColumnMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitAddColumnMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitAddColumnMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClearRowMethodContext extends VoidMethodsContext {
		public ClearRowContext clearRow() {
			return getRuleContext(ClearRowContext.class,0);
		}
		public ClearRowMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterClearRowMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitClearRowMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitClearRowMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CopyRowMethodContext extends VoidMethodsContext {
		public CopyRowContext copyRow() {
			return getRuleContext(CopyRowContext.class,0);
		}
		public CopyRowMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterCopyRowMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitCopyRowMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitCopyRowMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClearColumnMethodContext extends VoidMethodsContext {
		public ClearColumnContext clearColumn() {
			return getRuleContext(ClearColumnContext.class,0);
		}
		public ClearColumnMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterClearColumnMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitClearColumnMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitClearColumnMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReadTableMethodContext extends VoidMethodsContext {
		public ReadTableContext readTable() {
			return getRuleContext(ReadTableContext.class,0);
		}
		public ReadTableMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterReadTableMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitReadTableMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitReadTableMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintColumnMethodContext extends VoidMethodsContext {
		public PrintColumnContext printColumn() {
			return getRuleContext(PrintColumnContext.class,0);
		}
		public PrintColumnMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterPrintColumnMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitPrintColumnMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitPrintColumnMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InsertElemMethodContext extends VoidMethodsContext {
		public InsertElemContext insertElem() {
			return getRuleContext(InsertElemContext.class,0);
		}
		public InsertElemMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterInsertElemMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitInsertElemMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitInsertElemMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RemoveTableMethodContext extends VoidMethodsContext {
		public RemoveTableContext removeTable() {
			return getRuleContext(RemoveTableContext.class,0);
		}
		public RemoveTableMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterRemoveTableMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitRemoveTableMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitRemoveTableMethod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintTableMethodContext extends VoidMethodsContext {
		public PrintTableContext printTable() {
			return getRuleContext(PrintTableContext.class,0);
		}
		public PrintTableMethodContext(VoidMethodsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterPrintTableMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitPrintTableMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitPrintTableMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoidMethodsContext voidMethods() throws RecognitionException {
		VoidMethodsContext _localctx = new VoidMethodsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_voidMethods);
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new RemoveTableMethodContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				removeTable();
				}
				break;
			case 2:
				_localctx = new ReadTableMethodContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				readTable();
				}
				break;
			case 3:
				_localctx = new AddRowMethodContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(120);
				addRow();
				}
				break;
			case 4:
				_localctx = new CopyRowMethodContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(121);
				copyRow();
				}
				break;
			case 5:
				_localctx = new NewRowMethodContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(122);
				newRow();
				}
				break;
			case 6:
				_localctx = new ClearRowMethodContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(123);
				clearRow();
				}
				break;
			case 7:
				_localctx = new InsertElemMethodContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(124);
				insertElem();
				}
				break;
			case 8:
				_localctx = new RemoveElemMethodContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(125);
				removeElem();
				}
				break;
			case 9:
				_localctx = new AddColumnMethodContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(126);
				addColumn();
				}
				break;
			case 10:
				_localctx = new NewColumnMethodContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(127);
				newColumn();
				}
				break;
			case 11:
				_localctx = new CopyColumnMethodContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(128);
				copyColumn();
				}
				break;
			case 12:
				_localctx = new CopyRowMethodContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(129);
				copyRow();
				}
				break;
			case 13:
				_localctx = new ClearColumnMethodContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(130);
				clearColumn();
				}
				break;
			case 14:
				_localctx = new PrintTableMethodContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(131);
				printTable();
				}
				break;
			case 15:
				_localctx = new PrintRowMethodContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(132);
				printRow();
				}
				break;
			case 16:
				_localctx = new PrintColumnMethodContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(133);
				printColumn();
				}
				break;
			case 17:
				_localctx = new ExportMethodContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(134);
				export();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewTableContext extends ParserRuleContext {
		public NewTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newTable; }
	 
		public NewTableContext() { }
		public void copyFrom(NewTableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CreateType2TableContext extends NewTableContext {
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public CreateType2TableContext(NewTableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterCreateType2Table(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitCreateType2Table(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitCreateType2Table(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateCustomTableContext extends NewTableContext {
		public List<TerminalNode> INT() { return getTokens(tableGramParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(tableGramParser.INT, i);
		}
		public CreateCustomTableContext(NewTableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterCreateCustomTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitCreateCustomTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitCreateCustomTable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreateDefaultTableContext extends NewTableContext {
		public CreateDefaultTableContext(NewTableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterCreateDefaultTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitCreateDefaultTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitCreateDefaultTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewTableContext newTable() throws RecognitionException {
		NewTableContext _localctx = new NewTableContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_newTable);
		try {
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new CreateDefaultTableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(T__12);
				}
				break;
			case 2:
				_localctx = new CreateCustomTableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(T__12);
				setState(139);
				match(INT);
				setState(140);
				match(INT);
				}
				break;
			case 3:
				_localctx = new CreateType2TableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				match(T__13);
				setState(142);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CopyTableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public CopyTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_copyTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterCopyTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitCopyTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitCopyTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CopyTableContext copyTable() throws RecognitionException {
		CopyTableContext _localctx = new CopyTableContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_copyTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(T__14);
			setState(146);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertElemContext extends ParserRuleContext {
		public InsertElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertElem; }
	 
		public InsertElemContext() { }
		public void copyFrom(InsertElemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InsertElem2Context extends InsertElemContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public InsertElem2Context(InsertElemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterInsertElem2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitInsertElem2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitInsertElem2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InsertElem1Context extends InsertElemContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public List<TerminalNode> INT() { return getTokens(tableGramParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(tableGramParser.INT, i);
		}
		public InsertElem1Context(InsertElemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterInsertElem1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitInsertElem1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitInsertElem1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertElemContext insertElem() throws RecognitionException {
		InsertElemContext _localctx = new InsertElemContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_insertElem);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new InsertElem1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(T__15);
				setState(149);
				match(ID);
				setState(150);
				match(T__10);
				setState(151);
				match(INT);
				setState(152);
				match(T__16);
				setState(153);
				match(INT);
				setState(154);
				match(T__11);
				setState(155);
				match(ID);
				}
				break;
			case 2:
				_localctx = new InsertElem2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				match(T__15);
				setState(157);
				match(ID);
				setState(158);
				match(T__10);
				setState(159);
				match(ID);
				setState(160);
				match(T__16);
				setState(161);
				match(ID);
				setState(162);
				match(T__11);
				setState(163);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RemoveElemContext extends ParserRuleContext {
		public RemoveElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_removeElem; }
	 
		public RemoveElemContext() { }
		public void copyFrom(RemoveElemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RemoveElem1Context extends RemoveElemContext {
		public List<TerminalNode> INT() { return getTokens(tableGramParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(tableGramParser.INT, i);
		}
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public RemoveElem1Context(RemoveElemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterRemoveElem1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitRemoveElem1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitRemoveElem1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RemoveElem2Context extends RemoveElemContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public RemoveElem2Context(RemoveElemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterRemoveElem2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitRemoveElem2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitRemoveElem2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RemoveElemContext removeElem() throws RecognitionException {
		RemoveElemContext _localctx = new RemoveElemContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_removeElem);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__17:
				_localctx = new RemoveElem1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(T__17);
				setState(167);
				match(T__10);
				setState(168);
				match(INT);
				setState(169);
				match(T__16);
				setState(170);
				match(INT);
				setState(171);
				match(T__11);
				setState(172);
				match(ID);
				}
				break;
			case T__18:
				_localctx = new RemoveElem2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(T__18);
				setState(174);
				match(T__10);
				setState(175);
				match(ID);
				setState(176);
				match(T__16);
				setState(177);
				match(ID);
				setState(178);
				match(T__11);
				setState(179);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GetElemContext extends ParserRuleContext {
		public GetElemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getElem; }
	 
		public GetElemContext() { }
		public void copyFrom(GetElemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class GetElem2Context extends GetElemContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public GetElem2Context(GetElemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterGetElem2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitGetElem2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitGetElem2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GetElem1Context extends GetElemContext {
		public List<TerminalNode> INT() { return getTokens(tableGramParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(tableGramParser.INT, i);
		}
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public GetElem1Context(GetElemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterGetElem1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitGetElem1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitGetElem1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetElemContext getElem() throws RecognitionException {
		GetElemContext _localctx = new GetElemContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_getElem);
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new GetElem1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(T__19);
				setState(183);
				match(T__10);
				setState(184);
				match(INT);
				setState(185);
				match(T__16);
				setState(186);
				match(INT);
				setState(187);
				match(T__11);
				setState(188);
				match(ID);
				}
				break;
			case 2:
				_localctx = new GetElem2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(T__19);
				setState(190);
				match(T__10);
				setState(191);
				match(ID);
				setState(192);
				match(T__16);
				setState(193);
				match(ID);
				setState(194);
				match(T__11);
				setState(195);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadTableContext extends ParserRuleContext {
		public ReadTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readTable; }
	 
		public ReadTableContext() { }
		public void copyFrom(ReadTableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Read2Context extends ReadTableContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public Read2Context(ReadTableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterRead2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitRead2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitRead2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Read1Context extends ReadTableContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public Read1Context(ReadTableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterRead1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitRead1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitRead1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadTableContext readTable() throws RecognitionException {
		ReadTableContext _localctx = new ReadTableContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_readTable);
		try {
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new Read1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(ID);
				setState(199);
				match(T__20);
				setState(200);
				match(T__21);
				setState(201);
				match(ID);
				setState(202);
				match(T__22);
				}
				break;
			case 2:
				_localctx = new Read2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				match(ID);
				setState(204);
				match(T__20);
				setState(205);
				match(T__23);
				setState(206);
				match(ID);
				setState(207);
				match(T__22);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RemoveTableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public RemoveTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_removeTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterRemoveTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitRemoveTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitRemoveTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RemoveTableContext removeTable() throws RecognitionException {
		RemoveTableContext _localctx = new RemoveTableContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_removeTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__24);
			setState(211);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddRowContext extends ParserRuleContext {
		public AddRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addRow; }
	 
		public AddRowContext() { }
		public void copyFrom(AddRowContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddRow2Context extends AddRowContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public AddRow2Context(AddRowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterAddRow2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitAddRow2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitAddRow2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddRow1Context extends AddRowContext {
		public List<TerminalNode> INT() { return getTokens(tableGramParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(tableGramParser.INT, i);
		}
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public AddRow1Context(AddRowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterAddRow1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitAddRow1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitAddRow1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddRowContext addRow() throws RecognitionException {
		AddRowContext _localctx = new AddRowContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_addRow);
		try {
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new AddRow1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				match(T__25);
				setState(214);
				match(INT);
				setState(215);
				match(ID);
				setState(216);
				match(T__20);
				setState(217);
				match(INT);
				setState(218);
				match(ID);
				}
				break;
			case 2:
				_localctx = new AddRow2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				match(T__25);
				setState(220);
				match(ID);
				setState(221);
				match(ID);
				setState(222);
				match(T__20);
				setState(223);
				match(ID);
				setState(224);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CopyRowContext extends ParserRuleContext {
		public CopyRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_copyRow; }
	 
		public CopyRowContext() { }
		public void copyFrom(CopyRowContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CopyRow1Context extends CopyRowContext {
		public List<TerminalNode> INT() { return getTokens(tableGramParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(tableGramParser.INT, i);
		}
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public CopyRow1Context(CopyRowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterCopyRow1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitCopyRow1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitCopyRow1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CopyRow2Context extends CopyRowContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public CopyRow2Context(CopyRowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterCopyRow2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitCopyRow2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitCopyRow2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CopyRowContext copyRow() throws RecognitionException {
		CopyRowContext _localctx = new CopyRowContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_copyRow);
		try {
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new CopyRow1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				match(T__26);
				setState(228);
				match(INT);
				setState(229);
				match(ID);
				setState(230);
				match(T__20);
				setState(231);
				match(INT);
				setState(232);
				match(ID);
				}
				break;
			case 2:
				_localctx = new CopyRow2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				match(T__26);
				setState(234);
				match(ID);
				setState(235);
				match(ID);
				setState(236);
				match(T__20);
				setState(237);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewRowContext extends ParserRuleContext {
		public NewRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newRow; }
	 
		public NewRowContext() { }
		public void copyFrom(NewRowContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewRowSpecificContext extends NewRowContext {
		public TerminalNode INT() { return getToken(tableGramParser.INT, 0); }
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public NewRowSpecificContext(NewRowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterNewRowSpecific(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitNewRowSpecific(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitNewRowSpecific(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewRowTable2Context extends NewRowContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public NewRowTable2Context(NewRowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterNewRowTable2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitNewRowTable2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitNewRowTable2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewRowSimpleContext extends NewRowContext {
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public NewRowSimpleContext(NewRowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterNewRowSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitNewRowSimple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitNewRowSimple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewRowContext newRow() throws RecognitionException {
		NewRowContext _localctx = new NewRowContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_newRow);
		try {
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new NewRowSpecificContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				match(T__27);
				setState(241);
				match(T__20);
				setState(242);
				match(INT);
				setState(243);
				match(ID);
				}
				break;
			case 2:
				_localctx = new NewRowSimpleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				match(T__27);
				setState(245);
				match(T__20);
				setState(246);
				match(ID);
				}
				break;
			case 3:
				_localctx = new NewRowTable2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				match(T__27);
				setState(248);
				match(T__20);
				setState(249);
				match(ID);
				setState(250);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClearRowContext extends ParserRuleContext {
		public ClearRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clearRow; }
	 
		public ClearRowContext() { }
		public void copyFrom(ClearRowContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClearRow1Context extends ClearRowContext {
		public TerminalNode INT() { return getToken(tableGramParser.INT, 0); }
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public ClearRow1Context(ClearRowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterClearRow1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitClearRow1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitClearRow1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClearRow2Context extends ClearRowContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public ClearRow2Context(ClearRowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterClearRow2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitClearRow2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitClearRow2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClearRowContext clearRow() throws RecognitionException {
		ClearRowContext _localctx = new ClearRowContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_clearRow);
		try {
			setState(259);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new ClearRow1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				match(T__28);
				setState(254);
				match(INT);
				setState(255);
				match(ID);
				}
				break;
			case 2:
				_localctx = new ClearRow2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				match(T__28);
				setState(257);
				match(ID);
				setState(258);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddColumnContext extends ParserRuleContext {
		public AddColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addColumn; }
	 
		public AddColumnContext() { }
		public void copyFrom(AddColumnContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddColumn1Context extends AddColumnContext {
		public List<TerminalNode> INT() { return getTokens(tableGramParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(tableGramParser.INT, i);
		}
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public AddColumn1Context(AddColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterAddColumn1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitAddColumn1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitAddColumn1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddColumn2Context extends AddColumnContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public AddColumn2Context(AddColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterAddColumn2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitAddColumn2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitAddColumn2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddColumnContext addColumn() throws RecognitionException {
		AddColumnContext _localctx = new AddColumnContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_addColumn);
		try {
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new AddColumn1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				match(T__29);
				setState(262);
				match(INT);
				setState(263);
				match(ID);
				setState(264);
				match(T__20);
				setState(265);
				match(INT);
				setState(266);
				match(ID);
				}
				break;
			case 2:
				_localctx = new AddColumn2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				match(T__29);
				setState(268);
				match(ID);
				setState(269);
				match(ID);
				setState(270);
				match(T__20);
				setState(271);
				match(ID);
				setState(272);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CopyColumnContext extends ParserRuleContext {
		public CopyColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_copyColumn; }
	 
		public CopyColumnContext() { }
		public void copyFrom(CopyColumnContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CopyColumn1Context extends CopyColumnContext {
		public List<TerminalNode> INT() { return getTokens(tableGramParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(tableGramParser.INT, i);
		}
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public CopyColumn1Context(CopyColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterCopyColumn1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitCopyColumn1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitCopyColumn1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CopyColumn2Context extends CopyColumnContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public CopyColumn2Context(CopyColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterCopyColumn2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitCopyColumn2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitCopyColumn2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CopyColumnContext copyColumn() throws RecognitionException {
		CopyColumnContext _localctx = new CopyColumnContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_copyColumn);
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new CopyColumn1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(275);
				match(T__30);
				setState(276);
				match(INT);
				setState(277);
				match(ID);
				setState(278);
				match(T__20);
				setState(279);
				match(INT);
				setState(280);
				match(ID);
				}
				break;
			case 2:
				_localctx = new CopyColumn2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				match(T__30);
				setState(282);
				match(ID);
				setState(283);
				match(ID);
				setState(284);
				match(T__20);
				setState(285);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewColumnContext extends ParserRuleContext {
		public NewColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newColumn; }
	 
		public NewColumnContext() { }
		public void copyFrom(NewColumnContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewColumnSpecificContext extends NewColumnContext {
		public TerminalNode INT() { return getToken(tableGramParser.INT, 0); }
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public NewColumnSpecificContext(NewColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterNewColumnSpecific(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitNewColumnSpecific(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitNewColumnSpecific(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewColumnSimpleContext extends NewColumnContext {
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public NewColumnSimpleContext(NewColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterNewColumnSimple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitNewColumnSimple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitNewColumnSimple(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewColumnTable2Context extends NewColumnContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public NewColumnTable2Context(NewColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterNewColumnTable2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitNewColumnTable2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitNewColumnTable2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewColumnContext newColumn() throws RecognitionException {
		NewColumnContext _localctx = new NewColumnContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_newColumn);
		try {
			setState(302);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new NewColumnSpecificContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(T__31);
				setState(289);
				match(T__20);
				setState(290);
				match(INT);
				setState(291);
				match(ID);
				}
				break;
			case 2:
				_localctx = new NewColumnTable2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				match(T__32);
				setState(293);
				match(ID);
				setState(294);
				match(T__20);
				setState(295);
				match(ID);
				setState(296);
				match(T__10);
				setState(297);
				match(ID);
				setState(298);
				match(T__11);
				}
				break;
			case 3:
				_localctx = new NewColumnSimpleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				match(T__31);
				setState(300);
				match(T__20);
				setState(301);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClearColumnContext extends ParserRuleContext {
		public ClearColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clearColumn; }
	 
		public ClearColumnContext() { }
		public void copyFrom(ClearColumnContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClearColumn1Context extends ClearColumnContext {
		public TerminalNode INT() { return getToken(tableGramParser.INT, 0); }
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public ClearColumn1Context(ClearColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterClearColumn1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitClearColumn1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitClearColumn1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ClearColumn2Context extends ClearColumnContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public ClearColumn2Context(ClearColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterClearColumn2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitClearColumn2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitClearColumn2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClearColumnContext clearColumn() throws RecognitionException {
		ClearColumnContext _localctx = new ClearColumnContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_clearColumn);
		try {
			setState(310);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new ClearColumn1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				match(T__33);
				setState(305);
				match(INT);
				setState(306);
				match(ID);
				}
				break;
			case 2:
				_localctx = new ClearColumn2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(307);
				match(T__33);
				setState(308);
				match(ID);
				setState(309);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExportContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public ExportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_export; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterExport(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitExport(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitExport(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExportContext export() throws RecognitionException {
		ExportContext _localctx = new ExportContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_export);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(T__34);
			setState(313);
			match(ID);
			setState(314);
			match(T__35);
			setState(315);
			match(ID);
			setState(316);
			match(T__22);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintTableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public PrintTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterPrintTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitPrintTable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitPrintTable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintTableContext printTable() throws RecognitionException {
		PrintTableContext _localctx = new PrintTableContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_printTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(T__36);
			setState(319);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintRowContext extends ParserRuleContext {
		public PrintRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printRow; }
	 
		public PrintRowContext() { }
		public void copyFrom(PrintRowContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintRow2Context extends PrintRowContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public PrintRow2Context(PrintRowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterPrintRow2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitPrintRow2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitPrintRow2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintRow1Context extends PrintRowContext {
		public TerminalNode INT() { return getToken(tableGramParser.INT, 0); }
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public PrintRow1Context(PrintRowContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterPrintRow1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitPrintRow1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitPrintRow1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintRowContext printRow() throws RecognitionException {
		PrintRowContext _localctx = new PrintRowContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_printRow);
		try {
			setState(327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new PrintRow1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(321);
				match(T__37);
				setState(322);
				match(INT);
				setState(323);
				match(ID);
				}
				break;
			case 2:
				_localctx = new PrintRow2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				match(T__37);
				setState(325);
				match(ID);
				setState(326);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintColumnContext extends ParserRuleContext {
		public PrintColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printColumn; }
	 
		public PrintColumnContext() { }
		public void copyFrom(PrintColumnContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintColumn2Context extends PrintColumnContext {
		public List<TerminalNode> ID() { return getTokens(tableGramParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(tableGramParser.ID, i);
		}
		public PrintColumn2Context(PrintColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterPrintColumn2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitPrintColumn2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitPrintColumn2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintColumn1Context extends PrintColumnContext {
		public TerminalNode INT() { return getToken(tableGramParser.INT, 0); }
		public TerminalNode ID() { return getToken(tableGramParser.ID, 0); }
		public PrintColumn1Context(PrintColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).enterPrintColumn1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof tableGramListener ) ((tableGramListener)listener).exitPrintColumn1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof tableGramVisitor ) return ((tableGramVisitor<? extends T>)visitor).visitPrintColumn1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintColumnContext printColumn() throws RecognitionException {
		PrintColumnContext _localctx = new PrintColumnContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_printColumn);
		try {
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new PrintColumn1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(329);
				match(T__38);
				setState(330);
				match(INT);
				setState(331);
				match(ID);
				}
				break;
			case 2:
				_localctx = new PrintColumn2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				match(T__38);
				setState(333);
				match(ID);
				setState(334);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return numExpr_sempred((NumExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean numExpr_sempred(NumExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u0154\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\7\2>\n\2\f\2\16"+
		"\2A\13\2\3\2\3\2\3\3\3\3\3\3\5\3H\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\5\5R\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\5\7[\n\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\5\be\n\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bm\n\b\f\b\16\bp\13\b\3\t"+
		"\3\t\3\n\3\n\3\n\5\nw\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u008a\n\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\5\f\u0092\n\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00a7\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00b7"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00c7\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00d3\n\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\5\23\u00e4\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\5\24\u00f1\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\5\25\u00fe\n\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u0106\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u0114\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u0121\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u0131\n\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0139"+
		"\n\32\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\5\35\u014a\n\35\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0152\n"+
		"\36\3\36\2\3\16\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:\2\4\3\2\t\n\3\2\13\f\2\u0168\2?\3\2\2\2\4G\3\2\2\2\6I\3\2"+
		"\2\2\bQ\3\2\2\2\nS\3\2\2\2\fZ\3\2\2\2\16d\3\2\2\2\20q\3\2\2\2\22v\3\2"+
		"\2\2\24\u0089\3\2\2\2\26\u0091\3\2\2\2\30\u0093\3\2\2\2\32\u00a6\3\2\2"+
		"\2\34\u00b6\3\2\2\2\36\u00c6\3\2\2\2 \u00d2\3\2\2\2\"\u00d4\3\2\2\2$\u00e3"+
		"\3\2\2\2&\u00f0\3\2\2\2(\u00fd\3\2\2\2*\u0105\3\2\2\2,\u0113\3\2\2\2."+
		"\u0120\3\2\2\2\60\u0130\3\2\2\2\62\u0138\3\2\2\2\64\u013a\3\2\2\2\66\u0140"+
		"\3\2\2\28\u0149\3\2\2\2:\u0151\3\2\2\2<>\5\4\3\2=<\3\2\2\2>A\3\2\2\2?"+
		"=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2BC\7\2\2\3C\3\3\2\2\2DH\5\6\4\2"+
		"EH\5\n\6\2FH\5\24\13\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2H\5\3\2\2\2IJ\5\b"+
		"\5\2JK\7*\2\2K\7\3\2\2\2LR\7\3\2\2MR\7\4\2\2NR\7\5\2\2OR\7\6\2\2PR\7\7"+
		"\2\2QL\3\2\2\2QM\3\2\2\2QN\3\2\2\2QO\3\2\2\2QP\3\2\2\2R\t\3\2\2\2ST\7"+
		"*\2\2TU\7\b\2\2UV\5\f\7\2V\13\3\2\2\2W[\5\22\n\2X[\5\16\b\2Y[\5\20\t\2"+
		"ZW\3\2\2\2ZX\3\2\2\2ZY\3\2\2\2[\r\3\2\2\2\\]\b\b\1\2]^\7\r\2\2^_\5\16"+
		"\b\2_`\7\16\2\2`e\3\2\2\2ae\7+\2\2be\7,\2\2ce\7*\2\2d\\\3\2\2\2da\3\2"+
		"\2\2db\3\2\2\2dc\3\2\2\2en\3\2\2\2fg\f\b\2\2gh\t\2\2\2hm\5\16\b\tij\f"+
		"\7\2\2jk\t\3\2\2km\5\16\b\blf\3\2\2\2li\3\2\2\2mp\3\2\2\2nl\3\2\2\2no"+
		"\3\2\2\2o\17\3\2\2\2pn\3\2\2\2qr\7-\2\2r\21\3\2\2\2sw\5\26\f\2tw\5\30"+
		"\r\2uw\5\36\20\2vs\3\2\2\2vt\3\2\2\2vu\3\2\2\2w\23\3\2\2\2x\u008a\5\""+
		"\22\2y\u008a\5 \21\2z\u008a\5$\23\2{\u008a\5&\24\2|\u008a\5(\25\2}\u008a"+
		"\5*\26\2~\u008a\5\32\16\2\177\u008a\5\34\17\2\u0080\u008a\5,\27\2\u0081"+
		"\u008a\5\60\31\2\u0082\u008a\5.\30\2\u0083\u008a\5&\24\2\u0084\u008a\5"+
		"\62\32\2\u0085\u008a\5\66\34\2\u0086\u008a\58\35\2\u0087\u008a\5:\36\2"+
		"\u0088\u008a\5\64\33\2\u0089x\3\2\2\2\u0089y\3\2\2\2\u0089z\3\2\2\2\u0089"+
		"{\3\2\2\2\u0089|\3\2\2\2\u0089}\3\2\2\2\u0089~\3\2\2\2\u0089\177\3\2\2"+
		"\2\u0089\u0080\3\2\2\2\u0089\u0081\3\2\2\2\u0089\u0082\3\2\2\2\u0089\u0083"+
		"\3\2\2\2\u0089\u0084\3\2\2\2\u0089\u0085\3\2\2\2\u0089\u0086\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a\25\3\2\2\2\u008b\u0092\7\17\2"+
		"\2\u008c\u008d\7\17\2\2\u008d\u008e\7+\2\2\u008e\u0092\7+\2\2\u008f\u0090"+
		"\7\20\2\2\u0090\u0092\7*\2\2\u0091\u008b\3\2\2\2\u0091\u008c\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\27\3\2\2\2\u0093\u0094\7\21\2\2\u0094\u0095\7*\2"+
		"\2\u0095\31\3\2\2\2\u0096\u0097\7\22\2\2\u0097\u0098\7*\2\2\u0098\u0099"+
		"\7\r\2\2\u0099\u009a\7+\2\2\u009a\u009b\7\23\2\2\u009b\u009c\7+\2\2\u009c"+
		"\u009d\7\16\2\2\u009d\u00a7\7*\2\2\u009e\u009f\7\22\2\2\u009f\u00a0\7"+
		"*\2\2\u00a0\u00a1\7\r\2\2\u00a1\u00a2\7*\2\2\u00a2\u00a3\7\23\2\2\u00a3"+
		"\u00a4\7*\2\2\u00a4\u00a5\7\16\2\2\u00a5\u00a7\7*\2\2\u00a6\u0096\3\2"+
		"\2\2\u00a6\u009e\3\2\2\2\u00a7\33\3\2\2\2\u00a8\u00a9\7\24\2\2\u00a9\u00aa"+
		"\7\r\2\2\u00aa\u00ab\7+\2\2\u00ab\u00ac\7\23\2\2\u00ac\u00ad\7+\2\2\u00ad"+
		"\u00ae\7\16\2\2\u00ae\u00b7\7*\2\2\u00af\u00b0\7\25\2\2\u00b0\u00b1\7"+
		"\r\2\2\u00b1\u00b2\7*\2\2\u00b2\u00b3\7\23\2\2\u00b3\u00b4\7*\2\2\u00b4"+
		"\u00b5\7\16\2\2\u00b5\u00b7\7*\2\2\u00b6\u00a8\3\2\2\2\u00b6\u00af\3\2"+
		"\2\2\u00b7\35\3\2\2\2\u00b8\u00b9\7\26\2\2\u00b9\u00ba\7\r\2\2\u00ba\u00bb"+
		"\7+\2\2\u00bb\u00bc\7\23\2\2\u00bc\u00bd\7+\2\2\u00bd\u00be\7\16\2\2\u00be"+
		"\u00c7\7*\2\2\u00bf\u00c0\7\26\2\2\u00c0\u00c1\7\r\2\2\u00c1\u00c2\7*"+
		"\2\2\u00c2\u00c3\7\23\2\2\u00c3\u00c4\7*\2\2\u00c4\u00c5\7\16\2\2\u00c5"+
		"\u00c7\7*\2\2\u00c6\u00b8\3\2\2\2\u00c6\u00bf\3\2\2\2\u00c7\37\3\2\2\2"+
		"\u00c8\u00c9\7*\2\2\u00c9\u00ca\7\27\2\2\u00ca\u00cb\7\30\2\2\u00cb\u00cc"+
		"\7*\2\2\u00cc\u00d3\7\31\2\2\u00cd\u00ce\7*\2\2\u00ce\u00cf\7\27\2\2\u00cf"+
		"\u00d0\7\32\2\2\u00d0\u00d1\7*\2\2\u00d1\u00d3\7\31\2\2\u00d2\u00c8\3"+
		"\2\2\2\u00d2\u00cd\3\2\2\2\u00d3!\3\2\2\2\u00d4\u00d5\7\33\2\2\u00d5\u00d6"+
		"\7*\2\2\u00d6#\3\2\2\2\u00d7\u00d8\7\34\2\2\u00d8\u00d9\7+\2\2\u00d9\u00da"+
		"\7*\2\2\u00da\u00db\7\27\2\2\u00db\u00dc\7+\2\2\u00dc\u00e4\7*\2\2\u00dd"+
		"\u00de\7\34\2\2\u00de\u00df\7*\2\2\u00df\u00e0\7*\2\2\u00e0\u00e1\7\27"+
		"\2\2\u00e1\u00e2\7*\2\2\u00e2\u00e4\7*\2\2\u00e3\u00d7\3\2\2\2\u00e3\u00dd"+
		"\3\2\2\2\u00e4%\3\2\2\2\u00e5\u00e6\7\35\2\2\u00e6\u00e7\7+\2\2\u00e7"+
		"\u00e8\7*\2\2\u00e8\u00e9\7\27\2\2\u00e9\u00ea\7+\2\2\u00ea\u00f1\7*\2"+
		"\2\u00eb\u00ec\7\35\2\2\u00ec\u00ed\7*\2\2\u00ed\u00ee\7*\2\2\u00ee\u00ef"+
		"\7\27\2\2\u00ef\u00f1\7*\2\2\u00f0\u00e5\3\2\2\2\u00f0\u00eb\3\2\2\2\u00f1"+
		"\'\3\2\2\2\u00f2\u00f3\7\36\2\2\u00f3\u00f4\7\27\2\2\u00f4\u00f5\7+\2"+
		"\2\u00f5\u00fe\7*\2\2\u00f6\u00f7\7\36\2\2\u00f7\u00f8\7\27\2\2\u00f8"+
		"\u00fe\7*\2\2\u00f9\u00fa\7\36\2\2\u00fa\u00fb\7\27\2\2\u00fb\u00fc\7"+
		"*\2\2\u00fc\u00fe\7*\2\2\u00fd\u00f2\3\2\2\2\u00fd\u00f6\3\2\2\2\u00fd"+
		"\u00f9\3\2\2\2\u00fe)\3\2\2\2\u00ff\u0100\7\37\2\2\u0100\u0101\7+\2\2"+
		"\u0101\u0106\7*\2\2\u0102\u0103\7\37\2\2\u0103\u0104\7*\2\2\u0104\u0106"+
		"\7*\2\2\u0105\u00ff\3\2\2\2\u0105\u0102\3\2\2\2\u0106+\3\2\2\2\u0107\u0108"+
		"\7 \2\2\u0108\u0109\7+\2\2\u0109\u010a\7*\2\2\u010a\u010b\7\27\2\2\u010b"+
		"\u010c\7+\2\2\u010c\u0114\7*\2\2\u010d\u010e\7 \2\2\u010e\u010f\7*\2\2"+
		"\u010f\u0110\7*\2\2\u0110\u0111\7\27\2\2\u0111\u0112\7*\2\2\u0112\u0114"+
		"\7*\2\2\u0113\u0107\3\2\2\2\u0113\u010d\3\2\2\2\u0114-\3\2\2\2\u0115\u0116"+
		"\7!\2\2\u0116\u0117\7+\2\2\u0117\u0118\7*\2\2\u0118\u0119\7\27\2\2\u0119"+
		"\u011a\7+\2\2\u011a\u0121\7*\2\2\u011b\u011c\7!\2\2\u011c\u011d\7*\2\2"+
		"\u011d\u011e\7*\2\2\u011e\u011f\7\27\2\2\u011f\u0121\7*\2\2\u0120\u0115"+
		"\3\2\2\2\u0120\u011b\3\2\2\2\u0121/\3\2\2\2\u0122\u0123\7\"\2\2\u0123"+
		"\u0124\7\27\2\2\u0124\u0125\7+\2\2\u0125\u0131\7*\2\2\u0126\u0127\7#\2"+
		"\2\u0127\u0128\7*\2\2\u0128\u0129\7\27\2\2\u0129\u012a\7*\2\2\u012a\u012b"+
		"\7\r\2\2\u012b\u012c\7*\2\2\u012c\u0131\7\16\2\2\u012d\u012e\7\"\2\2\u012e"+
		"\u012f\7\27\2\2\u012f\u0131\7*\2\2\u0130\u0122\3\2\2\2\u0130\u0126\3\2"+
		"\2\2\u0130\u012d\3\2\2\2\u0131\61\3\2\2\2\u0132\u0133\7$\2\2\u0133\u0134"+
		"\7+\2\2\u0134\u0139\7*\2\2\u0135\u0136\7$\2\2\u0136\u0137\7*\2\2\u0137"+
		"\u0139\7*\2\2\u0138\u0132\3\2\2\2\u0138\u0135\3\2\2\2\u0139\63\3\2\2\2"+
		"\u013a\u013b\7%\2\2\u013b\u013c\7*\2\2\u013c\u013d\7&\2\2\u013d\u013e"+
		"\7*\2\2\u013e\u013f\7\31\2\2\u013f\65\3\2\2\2\u0140\u0141\7\'\2\2\u0141"+
		"\u0142\7*\2\2\u0142\67\3\2\2\2\u0143\u0144\7(\2\2\u0144\u0145\7+\2\2\u0145"+
		"\u014a\7*\2\2\u0146\u0147\7(\2\2\u0147\u0148\7*\2\2\u0148\u014a\7*\2\2"+
		"\u0149\u0143\3\2\2\2\u0149\u0146\3\2\2\2\u014a9\3\2\2\2\u014b\u014c\7"+
		")\2\2\u014c\u014d\7+\2\2\u014d\u0152\7*\2\2\u014e\u014f\7)\2\2\u014f\u0150"+
		"\7*\2\2\u0150\u0152\7*\2\2\u0151\u014b\3\2\2\2\u0151\u014e\3\2\2\2\u0152"+
		";\3\2\2\2\32?GQZdlnv\u0089\u0091\u00a6\u00b6\u00c6\u00d2\u00e3\u00f0\u00fd"+
		"\u0105\u0113\u0120\u0130\u0138\u0149\u0151";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}