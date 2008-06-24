// $ANTLR 3.0.1 C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g 2008-06-24 11:42:19
package grammatiche;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class descrittoreLexer extends Lexer {
    public static final int BOOL=9;
    public static final int CHAR=10;
    public static final int WHITESPACE=11;
    public static final int FLOAT=8;
    public static final int T12=12;
    public static final int Atom=6;
    public static final int T13=13;
    public static final int T14=14;
    public static final int T15=15;
    public static final int Tokens=18;
    public static final int T16=16;
    public static final int EOF=-1;
    public static final int T17=17;
    public static final int Def=7;
    public static final int Card=5;
    public static final int STRING=4;
    public descrittoreLexer() {;} 
    public descrittoreLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:4:5: ( ':' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:4:7: ':'
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
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:5:5: ( '(' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:5:7: '('
            {
            match('('); 

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
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:6:5: ( ')' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:6:7: ')'
            {
            match(')'); 

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
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:7:5: ( ',' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:7:7: ','
            {
            match(','); 

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
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
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
    // $ANTLR end T17

    // $ANTLR start Atom
    public final void mAtom() throws RecognitionException {
        try {
            int _type = Atom;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:34:6: ( ( 'str' | 'bool' | 'int' ) )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:34:8: ( 'str' | 'bool' | 'int' )
            {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:34:8: ( 'str' | 'bool' | 'int' )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 's':
                {
                alt1=1;
                }
                break;
            case 'b':
                {
                alt1=2;
                }
                break;
            case 'i':
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("34:8: ( 'str' | 'bool' | 'int' )", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:34:9: 'str'
                    {
                    match("str"); 


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:34:15: 'bool'
                    {
                    match("bool"); 


                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:34:22: 'int'
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

    // $ANTLR start Def
    public final void mDef() throws RecognitionException {
        try {
            int _type = Def;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:36:5: ( ( ( '\"' ( STRING )* '\"' ) | FLOAT | BOOL ) )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:36:8: ( ( '\"' ( STRING )* '\"' ) | FLOAT | BOOL )
            {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:36:8: ( ( '\"' ( STRING )* '\"' ) | FLOAT | BOOL )
            int alt3=3;
            switch ( input.LA(1) ) {
            case '\"':
                {
                alt3=1;
                }
                break;
            case '-':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt3=2;
                }
                break;
            case 'f':
            case 't':
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("36:8: ( ( '\"' ( STRING )* '\"' ) | FLOAT | BOOL )", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:36:9: ( '\"' ( STRING )* '\"' )
                    {
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:36:9: ( '\"' ( STRING )* '\"' )
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:36:10: '\"' ( STRING )* '\"'
                    {
                    match('\"'); 
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:36:13: ( STRING )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0=='-'||(LA2_0>='0' && LA2_0<='9')||LA2_0=='='||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:36:13: STRING
                    	    {
                    	    mSTRING(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    match('\"'); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:36:25: FLOAT
                    {
                    mFLOAT(); 

                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:36:31: BOOL
                    {
                    mBOOL(); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Def

    // $ANTLR start Card
    public final void mCard() throws RecognitionException {
        try {
            int _type = Card;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:38:6: ( ( '?' | '*' | '+' ) )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:38:8: ( '?' | '*' | '+' )
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

    // $ANTLR start STRING
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:40:8: ( ( CHAR | FLOAT )+ )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:40:10: ( CHAR | FLOAT )+
            {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:40:10: ( CHAR | FLOAT )+
            int cnt4=0;
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='='||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }
                else if ( (LA4_0=='-'||(LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:40:11: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:40:16: FLOAT
            	    {
            	    mFLOAT(); 

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
    // $ANTLR end STRING

    // $ANTLR start FLOAT
    public final void mFLOAT() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:42:16: ( ( '-' )? ( '0' .. '9' )+ )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:42:18: ( '-' )? ( '0' .. '9' )+
            {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:42:18: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:42:19: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:42:24: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:42:25: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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

        }
        finally {
        }
    }
    // $ANTLR end FLOAT

    // $ANTLR start BOOL
    public final void mBOOL() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:44:15: ( 'true' | 'false' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='t') ) {
                alt7=1;
            }
            else if ( (LA7_0=='f') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("44:10: fragment BOOL : ( 'true' | 'false' );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:44:17: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:44:24: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }
        }
        finally {
        }
    }
    // $ANTLR end BOOL

    // $ANTLR start CHAR
    public final void mCHAR() throws RecognitionException {
        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:46:15: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '=' | '_' )
            int alt8=4;
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
                alt8=1;
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
                alt8=2;
                }
                break;
            case '=':
                {
                alt8=3;
                }
                break;
            case '_':
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("46:10: fragment CHAR : ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '=' | '_' );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:46:17: ( 'a' .. 'z' )
                    {
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:46:17: ( 'a' .. 'z' )
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:46:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:46:28: ( 'A' .. 'Z' )
                    {
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:46:28: ( 'A' .. 'Z' )
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:46:29: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:46:39: '='
                    {
                    match('='); 

                    }
                    break;
                case 4 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:46:43: '_'
                    {
                    match('_'); 

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
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:48:12: ( ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+ )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:48:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:48:14: ( '\\t' | ' ' | '\\r' | '\\n' | '\\u000C' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\t' && LA9_0<='\n')||(LA9_0>='\f' && LA9_0<='\r')||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
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
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
        // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:8: ( T12 | T13 | T14 | T15 | T16 | T17 | Atom | Def | Card | STRING | WHITESPACE )
        int alt10=11;
        alt10 = dfa10.predict(input);
        switch (alt10) {
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
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:34: Atom
                {
                mAtom(); 

                }
                break;
            case 8 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:39: Def
                {
                mDef(); 

                }
                break;
            case 9 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:43: Card
                {
                mCard(); 

                }
                break;
            case 10 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:48: STRING
                {
                mSTRING(); 

                }
                break;
            case 11 :
                // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:1:55: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\1\uffff\1\22\3\uffff\1\23\3\17\2\uffff\1\11\2\17\6\uffff\5\17\1"+
        "\36\1\17\1\36\2\17\1\uffff\1\36\1\11\1\17\1\11";
    static final String DFA10_eofS =
        "\43\uffff";
    static final String DFA10_minS =
        "\1\11\1\75\3\uffff\1\55\1\164\1\157\1\156\1\uffff\1\60\1\55\1\162"+
        "\1\141\6\uffff\1\162\1\157\1\164\1\165\1\154\1\55\1\154\1\55\1\145"+
        "\1\163\1\uffff\2\55\1\145\1\55";
    static final String DFA10_maxS =
        "\1\172\1\75\3\uffff\1\172\1\164\1\157\1\156\1\uffff\1\71\1\172\1"+
        "\162\1\141\6\uffff\1\162\1\157\1\164\1\165\1\154\1\172\1\154\1\172"+
        "\1\145\1\163\1\uffff\2\172\1\145\1\172";
    static final String DFA10_acceptS =
        "\2\uffff\1\2\1\3\1\4\4\uffff\1\10\4\uffff\1\11\1\12\1\13\1\5\1\1"+
        "\1\6\12\uffff\1\7\4\uffff";
    static final String DFA10_specialS =
        "\43\uffff}>";
    static final String[] DFA10_transitionS = {
            "\2\20\1\uffff\2\20\22\uffff\1\20\1\uffff\1\11\5\uffff\1\2\1"+
            "\3\2\16\1\4\1\12\2\uffff\12\13\1\1\2\uffff\1\5\1\uffff\1\16"+
            "\1\uffff\32\17\4\uffff\1\17\1\uffff\1\17\1\7\3\17\1\15\2\17"+
            "\1\10\11\17\1\6\1\14\6\17",
            "\1\21",
            "",
            "",
            "",
            "\1\17\2\uffff\12\17\3\uffff\1\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17",
            "\1\24",
            "\1\25",
            "\1\26",
            "",
            "\12\13",
            "\1\17\2\uffff\12\13\3\uffff\1\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17",
            "\1\27",
            "\1\30",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\17\2\uffff\12\17\3\uffff\1\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17",
            "\1\37",
            "\1\17\2\uffff\12\17\3\uffff\1\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17",
            "\1\40",
            "\1\41",
            "",
            "\1\17\2\uffff\12\17\3\uffff\1\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17",
            "\1\17\2\uffff\12\17\3\uffff\1\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17",
            "\1\42",
            "\1\17\2\uffff\12\17\3\uffff\1\17\3\uffff\32\17\4\uffff\1\17"+
            "\1\uffff\32\17"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T12 | T13 | T14 | T15 | T16 | T17 | Atom | Def | Card | STRING | WHITESPACE );";
        }
    }
 

}