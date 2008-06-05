package grammar;

// $ANTLR 3.0.1 C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g 2008-06-05 12:24:08

import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.DFA;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.Lexer;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;

public class descrittoreLexer extends Lexer {
    public static final int T14=14;
    public static final int BOOL=9;
    public static final int Def=7;
    public static final int T15=15;
    public static final int EOF=-1;
    public static final int CHAR=10;
    public static final int STRING=4;
    public static final int T17=17;
    public static final int FLOAT=8;
    public static final int T12=12;
    public static final int Tokens=18;
    public static final int T16=16;
    public static final int T13=13;
    public static final int Card=5;
    public static final int Atom=6;
    public static final int WHITESPACE=11;
    public descrittoreLexer() {;} 
    public descrittoreLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:7:5: ( ':' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:7:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:8:5: ( ':=' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:8:7: ':='
            {
            match(":="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:9:5: ( '=' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:9:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:10:5: ( '(' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:10:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:11:5: ( ',' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:11:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:12:5: ( ')' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:12:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start Def
    public final void mDef() throws RecognitionException {
        try {
            int _type = Def;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:5: ( '\"' ( STRING )* '\"' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:7: '\"' ( STRING )* '\"'
            {
            match('\"'); 
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:10: ( STRING )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='-'||(LA1_0>='0' && LA1_0<='9')||(LA1_0>='<' && LA1_0<='=')||(LA1_0>='A' && LA1_0<='Z')||LA1_0=='_'||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:10: STRING
            	    {
            	    mSTRING(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Def

    // $ANTLR start Atom
    public final void mAtom() throws RecognitionException {
        try {
            int _type = Atom;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:25:6: ( ( 'str' | 'bool' | 'int' ) )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:25:8: ( 'str' | 'bool' | 'int' )
            {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:25:8: ( 'str' | 'bool' | 'int' )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 's':
                {
                alt2=1;
                }
                break;
            case 'b':
                {
                alt2=2;
                }
                break;
            case 'i':
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("25:8: ( 'str' | 'bool' | 'int' )", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:25:9: 'str'
                    {
                    match("str"); 


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:25:15: 'bool'
                    {
                    match("bool"); 


                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:25:22: 'int'
                    {
                    match("int"); 


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Atom

    // $ANTLR start Card
    public final void mCard() throws RecognitionException {
        try {
            int _type = Card;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:27:6: ( ( '?' | '*' | '+' ) )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:27:8: ( '?' | '*' | '+' )
            {
            if ( (input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='?' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Card

    // $ANTLR start FLOAT
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:7: ( ( '-' )? ( '0' .. '9' )+ )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:9: ( '-' )? ( '0' .. '9' )+
            {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:9: ( '-' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='-') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:10: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:15: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:16: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FLOAT

    // $ANTLR start BOOL
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:31:6: ( 'true' | 'false' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='t') ) {
                alt5=1;
            }
            else if ( (LA5_0=='f') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("31:1: BOOL : ( 'true' | 'false' );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:31:8: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:31:15: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BOOL

    // $ANTLR start STRING
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:33:8: ( ( CHAR | FLOAT )+ )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:33:10: ( CHAR | FLOAT )+
            {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:33:10: ( CHAR | FLOAT )+
            int cnt6=0;
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='<' && LA6_0<='=')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }
                else if ( (LA6_0=='-'||(LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:33:11: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:33:16: FLOAT
            	    {
            	    mFLOAT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRING

    // $ANTLR start CHAR
    public final void mCHAR() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:35:15: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '<' | '=' )
            int alt7=5;
            switch ( input.LA(1) ) {
            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
            case 'g':
            case 'h':
            case 'i':
            case 'j':
            case 'k':
            case 'l':
            case 'm':
            case 'n':
            case 'o':
            case 'p':
            case 'q':
            case 'r':
            case 's':
            case 't':
            case 'u':
            case 'v':
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                {
                alt7=1;
                }
                break;
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
                {
                alt7=2;
                }
                break;
            case '_':
                {
                alt7=3;
                }
                break;
            case '<':
                {
                alt7=4;
                }
                break;
            case '=':
                {
                alt7=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("35:10: fragment CHAR : ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' | '<' | '=' );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:35:17: ( 'a' .. 'z' )
                    {
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:35:17: ( 'a' .. 'z' )
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:35:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:35:28: ( 'A' .. 'Z' )
                    {
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:35:28: ( 'A' .. 'Z' )
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:35:29: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:35:39: '_'
                    {
                    match('_'); 

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:35:43: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 5 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:35:47: '='
                    {
                    match('='); 

                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end CHAR

    // $ANTLR start WHITESPACE
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:37:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:37:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:37:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\t' && LA8_0<='\n')||(LA8_0>='\f' && LA8_0<='\r')||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

             channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WHITESPACE

    public void mTokens() throws RecognitionException {
        // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:8: ( T12 | T13 | T14 | T15 | T16 | T17 | Def | Atom | Card | FLOAT | BOOL | STRING | WHITESPACE )
        int alt9=13;
        alt9 = dfa9.predict(input);
        switch (alt9) {
            case 1 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:14: T13
                {
                mT13(); 

                }
                break;
            case 3 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:18: T14
                {
                mT14(); 

                }
                break;
            case 4 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:22: T15
                {
                mT15(); 

                }
                break;
            case 5 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:26: T16
                {
                mT16(); 

                }
                break;
            case 6 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:30: T17
                {
                mT17(); 

                }
                break;
            case 7 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:34: Def
                {
                mDef(); 

                }
                break;
            case 8 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:38: Atom
                {
                mAtom(); 

                }
                break;
            case 9 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:43: Card
                {
                mCard(); 

                }
                break;
            case 10 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:48: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 11 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:54: BOOL
                {
                mBOOL(); 

                }
                break;
            case 12 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:59: STRING
                {
                mSTRING(); 

                }
                break;
            case 13 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:66: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;

        }

    }


    protected DFA9 dfa9 = new DFA9(this);
    static final String DFA9_eotS =
        "\1\uffff\1\22\1\23\4\uffff\3\17\2\uffff\1\27\2\17\5\uffff\3\17\1"+
        "\uffff\2\17\1\37\1\17\1\37\2\17\1\uffff\1\37\1\43\1\17\1\uffff\1"+
        "\43";
    static final String DFA9_eofS =
        "\45\uffff";
    static final String DFA9_minS =
        "\1\11\1\75\1\55\4\uffff\1\164\1\157\1\156\1\uffff\1\60\1\55\1\162"+
        "\1\141\5\uffff\1\162\1\157\1\164\1\uffff\1\165\1\154\1\55\1\154"+
        "\1\55\1\145\1\163\1\uffff\2\55\1\145\1\uffff\1\55";
    static final String DFA9_maxS =
        "\1\172\1\75\1\172\4\uffff\1\164\1\157\1\156\1\uffff\1\71\1\172\1"+
        "\162\1\141\5\uffff\1\162\1\157\1\164\1\uffff\1\165\1\154\1\172\1"+
        "\154\1\172\1\145\1\163\1\uffff\2\172\1\145\1\uffff\1\172";
    static final String DFA9_acceptS =
        "\3\uffff\1\4\1\5\1\6\1\7\3\uffff\1\11\4\uffff\1\14\1\15\1\2\1\1"+
        "\1\3\3\uffff\1\12\7\uffff\1\10\3\uffff\1\13\1\uffff";
    static final String DFA9_specialS =
        "\45\uffff}>";
    static final String[] DFA9_transitionS = {
            "\2\20\1\uffff\2\20\22\uffff\1\20\1\uffff\1\6\5\uffff\1\3\1\5"+
            "\2\12\1\4\1\13\2\uffff\12\14\1\1\1\uffff\1\17\1\2\1\uffff\1"+
            "\12\1\uffff\32\17\4\uffff\1\17\1\uffff\1\17\1\10\3\17\1\16\2"+
            "\17\1\11\11\17\1\7\1\15\6\17",
            "\1\21",
            "\1\17\2\uffff\12\17\2\uffff\2\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17",
            "",
            "",
            "",
            "",
            "\1\24",
            "\1\25",
            "\1\26",
            "",
            "\12\14",
            "\1\17\2\uffff\12\14\2\uffff\2\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17",
            "\1\30",
            "\1\31",
            "",
            "",
            "",
            "",
            "",
            "\1\32",
            "\1\33",
            "\1\34",
            "",
            "\1\35",
            "\1\36",
            "\1\17\2\uffff\12\17\2\uffff\2\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17",
            "\1\40",
            "\1\17\2\uffff\12\17\2\uffff\2\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17",
            "\1\41",
            "\1\42",
            "",
            "\1\17\2\uffff\12\17\2\uffff\2\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17",
            "\1\17\2\uffff\12\17\2\uffff\2\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17",
            "\1\44",
            "",
            "\1\17\2\uffff\12\17\2\uffff\2\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17"
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T12 | T13 | T14 | T15 | T16 | T17 | Def | Atom | Card | FLOAT | BOOL | STRING | WHITESPACE );";
        }
    }
 

}