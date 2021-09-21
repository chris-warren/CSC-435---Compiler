// $ANTLR 3.5.2 ul.g 2021-08-01 13:20:08

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ulLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int BOOLEAN=4;
	public static final int CHAR=5;
	public static final int CHARCONST=6;
	public static final int CLOSECURLY=7;
	public static final int CLOSEPAREN=8;
	public static final int COMMENT=9;
	public static final int ELSE=10;
	public static final int EQUALITY=11;
	public static final int FALSE=12;
	public static final int FLOAT=13;
	public static final int FLOATCONST=14;
	public static final int ID=15;
	public static final int IF=16;
	public static final int INT=17;
	public static final int INTCONST=18;
	public static final int LESSTHAN=19;
	public static final int MINUS=20;
	public static final int OPENCURLY=21;
	public static final int OPENPAREN=22;
	public static final int PLUS=23;
	public static final int PRINT=24;
	public static final int PRINTLN=25;
	public static final int RETURN=26;
	public static final int SEMI=27;
	public static final int STAR=28;
	public static final int STRCONST=29;
	public static final int STRING=30;
	public static final int TRUE=31;
	public static final int VOID=32;
	public static final int WHILE=33;
	public static final int WS=34;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ulLexer() {} 
	public ulLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ulLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "ul.g"; }

	// $ANTLR start "T__35"
	public final void mT__35() throws RecognitionException {
		try {
			int _type = T__35;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:2:7: ( ',' )
			// ul.g:2:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__35"

	// $ANTLR start "T__36"
	public final void mT__36() throws RecognitionException {
		try {
			int _type = T__36;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:3:7: ( '=' )
			// ul.g:3:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__36"

	// $ANTLR start "T__37"
	public final void mT__37() throws RecognitionException {
		try {
			int _type = T__37;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:4:7: ( '[' )
			// ul.g:4:9: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__37"

	// $ANTLR start "T__38"
	public final void mT__38() throws RecognitionException {
		try {
			int _type = T__38;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:5:7: ( ']' )
			// ul.g:5:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__38"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:291:4: ( ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+ )
			// ul.g:291:6: ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+
			{
			// ul.g:291:6: ( '\\t' | ' ' | ( '\\r' | '\\n' ) )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '\t' && LA1_0 <= '\n')||LA1_0=='\r'||LA1_0==' ') ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// ul.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			 _channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:294:5: ( ';' )
			// ul.g:295:2: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "OPENPAREN"
	public final void mOPENPAREN() throws RecognitionException {
		try {
			int _type = OPENPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:298:10: ( '(' )
			// ul.g:298:11: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPENPAREN"

	// $ANTLR start "CLOSEPAREN"
	public final void mCLOSEPAREN() throws RecognitionException {
		try {
			int _type = CLOSEPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:299:11: ( ')' )
			// ul.g:299:12: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSEPAREN"

	// $ANTLR start "OPENCURLY"
	public final void mOPENCURLY() throws RecognitionException {
		try {
			int _type = OPENCURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:300:10: ( '{' )
			// ul.g:300:11: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OPENCURLY"

	// $ANTLR start "CLOSECURLY"
	public final void mCLOSECURLY() throws RecognitionException {
		try {
			int _type = CLOSECURLY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:301:11: ( '}' )
			// ul.g:301:12: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CLOSECURLY"

	// $ANTLR start "STAR"
	public final void mSTAR() throws RecognitionException {
		try {
			int _type = STAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:303:5: ( '*' )
			// ul.g:303:7: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STAR"

	// $ANTLR start "PLUS"
	public final void mPLUS() throws RecognitionException {
		try {
			int _type = PLUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:304:5: ( '+' )
			// ul.g:304:7: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PLUS"

	// $ANTLR start "MINUS"
	public final void mMINUS() throws RecognitionException {
		try {
			int _type = MINUS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:305:6: ( '-' )
			// ul.g:305:8: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MINUS"

	// $ANTLR start "EQUALITY"
	public final void mEQUALITY() throws RecognitionException {
		try {
			int _type = EQUALITY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:306:9: ( '==' )
			// ul.g:306:11: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUALITY"

	// $ANTLR start "LESSTHAN"
	public final void mLESSTHAN() throws RecognitionException {
		try {
			int _type = LESSTHAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:307:9: ( '<' )
			// ul.g:307:11: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESSTHAN"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:309:6: ( 'float' )
			// ul.g:309:7: 'float'
			{
			match("float"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:310:4: ( 'int' )
			// ul.g:310:6: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "CHAR"
	public final void mCHAR() throws RecognitionException {
		try {
			int _type = CHAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:311:5: ( 'char' )
			// ul.g:311:7: 'char'
			{
			match("char"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHAR"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:312:7: ( 'string' )
			// ul.g:312:9: 'string'
			{
			match("string"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "BOOLEAN"
	public final void mBOOLEAN() throws RecognitionException {
		try {
			int _type = BOOLEAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:313:8: ( 'boolean' )
			// ul.g:313:10: 'boolean'
			{
			match("boolean"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BOOLEAN"

	// $ANTLR start "VOID"
	public final void mVOID() throws RecognitionException {
		try {
			int _type = VOID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:314:5: ( 'void' )
			// ul.g:314:7: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VOID"

	// $ANTLR start "PRINT"
	public final void mPRINT() throws RecognitionException {
		try {
			int _type = PRINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:326:6: ( 'print' )
			// ul.g:327:2: 'print'
			{
			match("print"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINT"

	// $ANTLR start "PRINTLN"
	public final void mPRINTLN() throws RecognitionException {
		try {
			int _type = PRINTLN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:330:8: ( 'println' )
			// ul.g:331:2: 'println'
			{
			match("println"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRINTLN"

	// $ANTLR start "RETURN"
	public final void mRETURN() throws RecognitionException {
		try {
			int _type = RETURN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:334:7: ( 'return' )
			// ul.g:335:2: 'return'
			{
			match("return"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RETURN"

	// $ANTLR start "IF"
	public final void mIF() throws RecognitionException {
		try {
			int _type = IF;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:338:3: ( 'if' )
			// ul.g:339:2: 'if'
			{
			match("if"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IF"

	// $ANTLR start "ELSE"
	public final void mELSE() throws RecognitionException {
		try {
			int _type = ELSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:341:5: ( 'else' )
			// ul.g:342:2: 'else'
			{
			match("else"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ELSE"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:345:5: ( 'true' )
			// ul.g:346:2: 'true'
			{
			match("true"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "WHILE"
	public final void mWHILE() throws RecognitionException {
		try {
			int _type = WHILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:349:6: ( 'while' )
			// ul.g:350:2: 'while'
			{
			match("while"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHILE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:353:6: ( 'false' )
			// ul.g:354:2: 'false'
			{
			match("false"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "STRCONST"
	public final void mSTRCONST() throws RecognitionException {
		try {
			int _type = STRCONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:357:9: ( '\"' ( ( 'A' .. 'Z' ) | ( 'a' .. 'z' ) | ' ' | ( '0' .. '9' ) | ':' | '.' )+ '\"' )
			// ul.g:358:2: '\"' ( ( 'A' .. 'Z' ) | ( 'a' .. 'z' ) | ' ' | ( '0' .. '9' ) | ':' | '.' )+ '\"'
			{
			match('\"'); 
			// ul.g:358:5: ( ( 'A' .. 'Z' ) | ( 'a' .. 'z' ) | ' ' | ( '0' .. '9' ) | ':' | '.' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==' '||LA2_0=='.'||(LA2_0 >= '0' && LA2_0 <= ':')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// ul.g:
					{
					if ( input.LA(1)==' '||input.LA(1)=='.'||(input.LA(1) >= '0' && input.LA(1) <= ':')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRCONST"

	// $ANTLR start "FLOATCONST"
	public final void mFLOATCONST() throws RecognitionException {
		try {
			int _type = FLOATCONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:361:11: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
			// ul.g:362:2: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
			{
			// ul.g:362:2: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// ul.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			match('.'); 
			// ul.g:362:18: ( '0' .. '9' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( ((LA4_0 >= '0' && LA4_0 <= '9')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// ul.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOATCONST"

	// $ANTLR start "CHARCONST"
	public final void mCHARCONST() throws RecognitionException {
		try {
			int _type = CHARCONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:365:10: ( '\\'' ( 'a' .. 'z' ) '\\'' )
			// ul.g:366:2: '\\'' ( 'a' .. 'z' ) '\\''
			{
			match('\''); 
			if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CHARCONST"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:369:4: ( ( 'a' .. 'z' )+ )
			// ul.g:369:6: ( 'a' .. 'z' )+
			{
			// ul.g:369:6: ( 'a' .. 'z' )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( ((LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// ul.g:
					{
					if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "INTCONST"
	public final void mINTCONST() throws RecognitionException {
		try {
			int _type = INTCONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:372:10: ( ( '0' .. '9' )+ )
			// ul.g:372:12: ( '0' .. '9' )+
			{
			// ul.g:372:12: ( '0' .. '9' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// ul.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTCONST"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ul.g:374:9: ( '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' | '\\n' ) )
			// ul.g:374:11: '//' (~ ( '\\r' | '\\n' ) )* ( '\\r' | '\\n' )
			{
			match("//"); 

			// ul.g:374:16: (~ ( '\\r' | '\\n' ) )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\t')||(LA7_0 >= '\u000B' && LA7_0 <= '\f')||(LA7_0 >= '\u000E' && LA7_0 <= '\uFFFF')) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// ul.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop7;
				}
			}

			if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			 _channel = HIDDEN; 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	@Override
	public void mTokens() throws RecognitionException {
		// ul.g:1:8: ( T__35 | T__36 | T__37 | T__38 | WS | SEMI | OPENPAREN | CLOSEPAREN | OPENCURLY | CLOSECURLY | STAR | PLUS | MINUS | EQUALITY | LESSTHAN | FLOAT | INT | CHAR | STRING | BOOLEAN | VOID | PRINT | PRINTLN | RETURN | IF | ELSE | TRUE | WHILE | FALSE | STRCONST | FLOATCONST | CHARCONST | ID | INTCONST | COMMENT )
		int alt8=35;
		alt8 = dfa8.predict(input);
		switch (alt8) {
			case 1 :
				// ul.g:1:10: T__35
				{
				mT__35(); 

				}
				break;
			case 2 :
				// ul.g:1:16: T__36
				{
				mT__36(); 

				}
				break;
			case 3 :
				// ul.g:1:22: T__37
				{
				mT__37(); 

				}
				break;
			case 4 :
				// ul.g:1:28: T__38
				{
				mT__38(); 

				}
				break;
			case 5 :
				// ul.g:1:34: WS
				{
				mWS(); 

				}
				break;
			case 6 :
				// ul.g:1:37: SEMI
				{
				mSEMI(); 

				}
				break;
			case 7 :
				// ul.g:1:42: OPENPAREN
				{
				mOPENPAREN(); 

				}
				break;
			case 8 :
				// ul.g:1:52: CLOSEPAREN
				{
				mCLOSEPAREN(); 

				}
				break;
			case 9 :
				// ul.g:1:63: OPENCURLY
				{
				mOPENCURLY(); 

				}
				break;
			case 10 :
				// ul.g:1:73: CLOSECURLY
				{
				mCLOSECURLY(); 

				}
				break;
			case 11 :
				// ul.g:1:84: STAR
				{
				mSTAR(); 

				}
				break;
			case 12 :
				// ul.g:1:89: PLUS
				{
				mPLUS(); 

				}
				break;
			case 13 :
				// ul.g:1:94: MINUS
				{
				mMINUS(); 

				}
				break;
			case 14 :
				// ul.g:1:100: EQUALITY
				{
				mEQUALITY(); 

				}
				break;
			case 15 :
				// ul.g:1:109: LESSTHAN
				{
				mLESSTHAN(); 

				}
				break;
			case 16 :
				// ul.g:1:118: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 17 :
				// ul.g:1:124: INT
				{
				mINT(); 

				}
				break;
			case 18 :
				// ul.g:1:128: CHAR
				{
				mCHAR(); 

				}
				break;
			case 19 :
				// ul.g:1:133: STRING
				{
				mSTRING(); 

				}
				break;
			case 20 :
				// ul.g:1:140: BOOLEAN
				{
				mBOOLEAN(); 

				}
				break;
			case 21 :
				// ul.g:1:148: VOID
				{
				mVOID(); 

				}
				break;
			case 22 :
				// ul.g:1:153: PRINT
				{
				mPRINT(); 

				}
				break;
			case 23 :
				// ul.g:1:159: PRINTLN
				{
				mPRINTLN(); 

				}
				break;
			case 24 :
				// ul.g:1:167: RETURN
				{
				mRETURN(); 

				}
				break;
			case 25 :
				// ul.g:1:174: IF
				{
				mIF(); 

				}
				break;
			case 26 :
				// ul.g:1:177: ELSE
				{
				mELSE(); 

				}
				break;
			case 27 :
				// ul.g:1:182: TRUE
				{
				mTRUE(); 

				}
				break;
			case 28 :
				// ul.g:1:187: WHILE
				{
				mWHILE(); 

				}
				break;
			case 29 :
				// ul.g:1:193: FALSE
				{
				mFALSE(); 

				}
				break;
			case 30 :
				// ul.g:1:199: STRCONST
				{
				mSTRCONST(); 

				}
				break;
			case 31 :
				// ul.g:1:208: FLOATCONST
				{
				mFLOATCONST(); 

				}
				break;
			case 32 :
				// ul.g:1:219: CHARCONST
				{
				mCHARCONST(); 

				}
				break;
			case 33 :
				// ul.g:1:229: ID
				{
				mID(); 

				}
				break;
			case 34 :
				// ul.g:1:232: INTCONST
				{
				mINTCONST(); 

				}
				break;
			case 35 :
				// ul.g:1:241: COMMENT
				{
				mCOMMENT(); 

				}
				break;

		}
	}


	protected DFA8 dfa8 = new DFA8(this);
	static final String DFA8_eotS =
		"\2\uffff\1\40\14\uffff\13\35\1\uffff\1\57\5\uffff\3\35\1\63\11\35\2\uffff"+
		"\2\35\1\77\1\uffff\13\35\1\uffff\1\113\2\35\1\116\2\35\1\121\1\122\1\35"+
		"\1\124\1\125\1\uffff\2\35\1\uffff\1\131\1\35\2\uffff\1\133\2\uffff\1\134"+
		"\2\35\1\uffff\1\137\2\uffff\1\140\1\141\3\uffff";
	static final String DFA8_eofS =
		"\142\uffff";
	static final String DFA8_minS =
		"\1\11\1\uffff\1\75\14\uffff\1\141\1\146\1\150\1\164\2\157\1\162\1\145"+
		"\1\154\1\162\1\150\1\uffff\1\56\5\uffff\1\157\1\154\1\164\2\141\1\162"+
		"\1\157\2\151\1\164\1\163\1\165\1\151\2\uffff\1\141\1\163\1\141\1\uffff"+
		"\1\162\1\151\1\154\1\144\1\156\1\165\2\145\1\154\1\164\1\145\1\uffff\1"+
		"\141\1\156\1\145\1\141\1\164\1\162\2\141\1\145\2\141\1\uffff\1\147\1\141"+
		"\1\uffff\1\141\1\156\2\uffff\1\141\2\uffff\1\141\2\156\1\uffff\1\141\2"+
		"\uffff\2\141\3\uffff";
	static final String DFA8_maxS =
		"\1\175\1\uffff\1\75\14\uffff\1\154\1\156\1\150\1\164\2\157\1\162\1\145"+
		"\1\154\1\162\1\150\1\uffff\1\71\5\uffff\1\157\1\154\1\164\1\172\1\141"+
		"\1\162\1\157\2\151\1\164\1\163\1\165\1\151\2\uffff\1\141\1\163\1\172\1"+
		"\uffff\1\162\1\151\1\154\1\144\1\156\1\165\2\145\1\154\1\164\1\145\1\uffff"+
		"\1\172\1\156\1\145\1\172\1\164\1\162\2\172\1\145\2\172\1\uffff\1\147\1"+
		"\141\1\uffff\1\172\1\156\2\uffff\1\172\2\uffff\1\172\2\156\1\uffff\1\172"+
		"\2\uffff\2\172\3\uffff";
	static final String DFA8_acceptS =
		"\1\uffff\1\1\1\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
		"\1\17\13\uffff\1\36\1\uffff\1\40\1\41\1\43\1\16\1\2\15\uffff\1\37\1\42"+
		"\3\uffff\1\31\13\uffff\1\21\13\uffff\1\22\2\uffff\1\25\2\uffff\1\32\1"+
		"\33\1\uffff\1\20\1\35\3\uffff\1\26\1\uffff\1\34\1\23\2\uffff\1\30\1\24"+
		"\1\27";
	static final String DFA8_specialS =
		"\142\uffff}>";
	static final String[] DFA8_transitionS = {
			"\2\5\2\uffff\1\5\22\uffff\1\5\1\uffff\1\32\4\uffff\1\34\1\7\1\10\1\13"+
			"\1\14\1\1\1\15\1\uffff\1\36\12\33\1\uffff\1\6\1\16\1\2\35\uffff\1\3\1"+
			"\uffff\1\4\3\uffff\1\35\1\23\1\21\1\35\1\27\1\17\2\35\1\20\6\35\1\25"+
			"\1\35\1\26\1\22\1\30\1\35\1\24\1\31\3\35\1\11\1\uffff\1\12",
			"",
			"\1\37",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\42\12\uffff\1\41",
			"\1\44\7\uffff\1\43",
			"\1\45",
			"\1\46",
			"\1\47",
			"\1\50",
			"\1\51",
			"\1\52",
			"\1\53",
			"\1\54",
			"\1\55",
			"",
			"\1\56\1\uffff\12\33",
			"",
			"",
			"",
			"",
			"",
			"\1\60",
			"\1\61",
			"\1\62",
			"\32\35",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"",
			"",
			"\1\75",
			"\1\76",
			"\32\35",
			"",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\111",
			"\1\112",
			"",
			"\32\35",
			"\1\114",
			"\1\115",
			"\32\35",
			"\1\117",
			"\1\120",
			"\32\35",
			"\32\35",
			"\1\123",
			"\32\35",
			"\32\35",
			"",
			"\1\126",
			"\1\127",
			"",
			"\13\35\1\130\16\35",
			"\1\132",
			"",
			"",
			"\32\35",
			"",
			"",
			"\32\35",
			"\1\135",
			"\1\136",
			"",
			"\32\35",
			"",
			"",
			"\32\35",
			"\32\35",
			"",
			"",
			""
	};

	static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
	static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
	static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
	static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
	static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
	static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
	static final short[][] DFA8_transition;

	static {
		int numStates = DFA8_transitionS.length;
		DFA8_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
		}
	}

	protected class DFA8 extends DFA {

		public DFA8(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 8;
			this.eot = DFA8_eot;
			this.eof = DFA8_eof;
			this.min = DFA8_min;
			this.max = DFA8_max;
			this.accept = DFA8_accept;
			this.special = DFA8_special;
			this.transition = DFA8_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__35 | T__36 | T__37 | T__38 | WS | SEMI | OPENPAREN | CLOSEPAREN | OPENCURLY | CLOSECURLY | STAR | PLUS | MINUS | EQUALITY | LESSTHAN | FLOAT | INT | CHAR | STRING | BOOLEAN | VOID | PRINT | PRINTLN | RETURN | IF | ELSE | TRUE | WHILE | FALSE | STRCONST | FLOATCONST | CHARCONST | ID | INTCONST | COMMENT );";
		}
	}

}
