package Ex1TP;

// Generated from TextMan.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TextManLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, STRING=5, ID=6, INT=7, NL=8, WS=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "STRING", "ID", "INT", "NL", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "':'", "'print'", "'print input'", "': input'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "STRING", "ID", "INT", "NL", "WS"
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


	public TextManLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TextMan.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13\\\b\1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\7\6\64\n\6\f\6\16\6\67\13"+
		"\6\3\6\3\6\3\7\7\7<\n\7\f\7\16\7?\13\7\3\7\6\7B\n\7\r\7\16\7C\3\7\7\7"+
		"G\n\7\f\7\16\7J\13\7\3\b\6\bM\n\b\r\b\16\bN\3\t\5\tR\n\t\3\t\3\t\3\n\6"+
		"\nW\n\n\r\n\16\nX\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\3\2\6\3\2$$\5\2C\\aac|\3\2\62;\4\2\13\13\"\"\2b\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5\27\3\2\2\2\7\35\3\2\2\2\t)\3\2"+
		"\2\2\13\61\3\2\2\2\r=\3\2\2\2\17L\3\2\2\2\21Q\3\2\2\2\23V\3\2\2\2\25\26"+
		"\7<\2\2\26\4\3\2\2\2\27\30\7r\2\2\30\31\7t\2\2\31\32\7k\2\2\32\33\7p\2"+
		"\2\33\34\7v\2\2\34\6\3\2\2\2\35\36\7r\2\2\36\37\7t\2\2\37 \7k\2\2 !\7"+
		"p\2\2!\"\7v\2\2\"#\7\"\2\2#$\7k\2\2$%\7p\2\2%&\7r\2\2&\'\7w\2\2\'(\7v"+
		"\2\2(\b\3\2\2\2)*\7<\2\2*+\7\"\2\2+,\7k\2\2,-\7p\2\2-.\7r\2\2./\7w\2\2"+
		"/\60\7v\2\2\60\n\3\2\2\2\61\65\7$\2\2\62\64\n\2\2\2\63\62\3\2\2\2\64\67"+
		"\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\289\7$\2"+
		"\29\f\3\2\2\2:<\5\17\b\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>A\3\2"+
		"\2\2?=\3\2\2\2@B\t\3\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DH\3\2"+
		"\2\2EG\5\17\b\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\16\3\2\2\2JH"+
		"\3\2\2\2KM\t\4\2\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\20\3\2\2\2"+
		"PR\7\17\2\2QP\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7\f\2\2T\22\3\2\2\2UW\t\5"+
		"\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z[\b\n\2\2[\24\3"+
		"\2\2\2\n\2\65=CHNQX\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}