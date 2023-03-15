// Generated from SimpleExpr.g4 by ANTLR 4.7.1

    package org.exa.antlr.parser;  //指定package

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, INCA=14, EXCA=15, INC=16, EXC=17, 
		EQS=18, NEQ=19, REG=20, LT=21, GT=22, LE=23, GE=24, EQ=25, NE=26, MUL=27, 
		DIV=28, ADD=29, SUB=30, ID=31, INT=32, STRING=33, ESC=34, NEWLINE=35, 
		COMMENT=36, WS=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "INCA", "EXCA", "INC", "EXC", "EQS", 
		"NEQ", "REG", "LT", "GT", "LE", "GE", "EQ", "NE", "MUL", "DIV", "ADD", 
		"SUB", "ID", "INT", "STRING", "ESC", "NEWLINE", "COMMENT", "WS", "DIGIT", 
		"LETTER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'!'", "'<'", "'>'", "'&&'", "'||'", "'('", "')'", "'return'", 
		"';'", "'['", "','", "']'", "'INCA'", "'EXCA'", "'INC'", "'EXC'", "'EQS'", 
		"'NEQ'", "'REG'", "'LT'", "'GT'", "'<='", "'>='", "'=='", "'!='", "'*'", 
		"'/'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "INCA", "EXCA", "INC", "EXC", "EQS", "NEQ", "REG", "LT", "GT", 
		"LE", "GE", "EQ", "NE", "MUL", "DIV", "ADD", "SUB", "ID", "INT", "STRING", 
		"ESC", "NEWLINE", "COMMENT", "WS"
	};
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


	    void startFile() {} // 空实现
	    void finishFile() {}
	    void defineProperty(Token name, Token value) {}


	public SimpleExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleExpr.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u00e4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \6 \u00ac\n \r \16 \u00ad"+
		"\3!\6!\u00b1\n!\r!\16!\u00b2\3\"\3\"\3\"\7\"\u00b8\n\"\f\"\16\"\u00bb"+
		"\13\"\3\"\3\"\3#\3#\3#\3#\5#\u00c3\n#\3$\5$\u00c6\n$\3$\3$\5$\u00ca\n"+
		"$\3%\3%\3%\3%\7%\u00d0\n%\f%\16%\u00d3\13%\3%\3%\3%\3%\3%\3&\6&\u00db"+
		"\n&\r&\16&\u00dc\3&\3&\3\'\3\'\3(\3(\4\u00b9\u00d1\2)\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M\2O\2\3\2\6\5\2C\\aac|\4\2\13\13\"\"\3\2\62;\5\2\62;C\\c|\2\u00ea\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\2K\3\2\2\2\3Q\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\tW\3\2\2\2\13"+
		"Y\3\2\2\2\r\\\3\2\2\2\17_\3\2\2\2\21a\3\2\2\2\23c\3\2\2\2\25j\3\2\2\2"+
		"\27l\3\2\2\2\31n\3\2\2\2\33p\3\2\2\2\35r\3\2\2\2\37w\3\2\2\2!|\3\2\2\2"+
		"#\u0080\3\2\2\2%\u0084\3\2\2\2\'\u0088\3\2\2\2)\u008c\3\2\2\2+\u0090\3"+
		"\2\2\2-\u0093\3\2\2\2/\u0096\3\2\2\2\61\u0099\3\2\2\2\63\u009c\3\2\2\2"+
		"\65\u009f\3\2\2\2\67\u00a2\3\2\2\29\u00a4\3\2\2\2;\u00a6\3\2\2\2=\u00a8"+
		"\3\2\2\2?\u00ab\3\2\2\2A\u00b0\3\2\2\2C\u00b4\3\2\2\2E\u00c2\3\2\2\2G"+
		"\u00c9\3\2\2\2I\u00cb\3\2\2\2K\u00da\3\2\2\2M\u00e0\3\2\2\2O\u00e2\3\2"+
		"\2\2QR\7?\2\2R\4\3\2\2\2ST\7#\2\2T\6\3\2\2\2UV\7>\2\2V\b\3\2\2\2WX\7@"+
		"\2\2X\n\3\2\2\2YZ\7(\2\2Z[\7(\2\2[\f\3\2\2\2\\]\7~\2\2]^\7~\2\2^\16\3"+
		"\2\2\2_`\7*\2\2`\20\3\2\2\2ab\7+\2\2b\22\3\2\2\2cd\7t\2\2de\7g\2\2ef\7"+
		"v\2\2fg\7w\2\2gh\7t\2\2hi\7p\2\2i\24\3\2\2\2jk\7=\2\2k\26\3\2\2\2lm\7"+
		"]\2\2m\30\3\2\2\2no\7.\2\2o\32\3\2\2\2pq\7_\2\2q\34\3\2\2\2rs\7K\2\2s"+
		"t\7P\2\2tu\7E\2\2uv\7C\2\2v\36\3\2\2\2wx\7G\2\2xy\7Z\2\2yz\7E\2\2z{\7"+
		"C\2\2{ \3\2\2\2|}\7K\2\2}~\7P\2\2~\177\7E\2\2\177\"\3\2\2\2\u0080\u0081"+
		"\7G\2\2\u0081\u0082\7Z\2\2\u0082\u0083\7E\2\2\u0083$\3\2\2\2\u0084\u0085"+
		"\7G\2\2\u0085\u0086\7S\2\2\u0086\u0087\7U\2\2\u0087&\3\2\2\2\u0088\u0089"+
		"\7P\2\2\u0089\u008a\7G\2\2\u008a\u008b\7S\2\2\u008b(\3\2\2\2\u008c\u008d"+
		"\7T\2\2\u008d\u008e\7G\2\2\u008e\u008f\7I\2\2\u008f*\3\2\2\2\u0090\u0091"+
		"\7N\2\2\u0091\u0092\7V\2\2\u0092,\3\2\2\2\u0093\u0094\7I\2\2\u0094\u0095"+
		"\7V\2\2\u0095.\3\2\2\2\u0096\u0097\7>\2\2\u0097\u0098\7?\2\2\u0098\60"+
		"\3\2\2\2\u0099\u009a\7@\2\2\u009a\u009b\7?\2\2\u009b\62\3\2\2\2\u009c"+
		"\u009d\7?\2\2\u009d\u009e\7?\2\2\u009e\64\3\2\2\2\u009f\u00a0\7#\2\2\u00a0"+
		"\u00a1\7?\2\2\u00a1\66\3\2\2\2\u00a2\u00a3\7,\2\2\u00a38\3\2\2\2\u00a4"+
		"\u00a5\7\61\2\2\u00a5:\3\2\2\2\u00a6\u00a7\7-\2\2\u00a7<\3\2\2\2\u00a8"+
		"\u00a9\7/\2\2\u00a9>\3\2\2\2\u00aa\u00ac\t\2\2\2\u00ab\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae@\3\2\2\2"+
		"\u00af\u00b1\5M\'\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b0"+
		"\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3B\3\2\2\2\u00b4\u00b9\7$\2\2\u00b5\u00b8"+
		"\5E#\2\u00b6\u00b8\13\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\u00bb\3\2\2\2\u00b9\u00ba\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bc\3\2"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7$\2\2\u00bdD\3\2\2\2\u00be\u00bf"+
		"\7^\2\2\u00bf\u00c3\7$\2\2\u00c0\u00c1\7^\2\2\u00c1\u00c3\7^\2\2\u00c2"+
		"\u00be\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3F\3\2\2\2\u00c4\u00c6\7\17\2\2"+
		"\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00ca"+
		"\7\f\2\2\u00c8\u00ca\7=\2\2\u00c9\u00c5\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca"+
		"H\3\2\2\2\u00cb\u00cc\7\61\2\2\u00cc\u00cd\7,\2\2\u00cd\u00d1\3\2\2\2"+
		"\u00ce\u00d0\13\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4"+
		"\u00d5\7,\2\2\u00d5\u00d6\7\61\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\b%"+
		"\2\2\u00d8J\3\2\2\2\u00d9\u00db\t\3\2\2\u00da\u00d9\3\2\2\2\u00db\u00dc"+
		"\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00df\b&\2\2\u00dfL\3\2\2\2\u00e0\u00e1\t\4\2\2\u00e1N\3\2\2\2\u00e2"+
		"\u00e3\t\5\2\2\u00e3P\3\2\2\2\f\2\u00ad\u00b2\u00b7\u00b9\u00c2\u00c5"+
		"\u00c9\u00d1\u00dc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}