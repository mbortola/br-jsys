// $ANTLR 3.0.1 /../../media/sda1/ids/src/compiler/BusinessRule.g 2008-03-11 22:45:29
package brjsys.validator;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BusinessRuleLexer extends Lexer {
    public static final int Count=17;
    public static final int OpRule=4;
    public static final int BOOL=14;
    public static final int NUMBER=20;
    public static final int CHAR=18;
    public static final int WHITESPACE=23;
    public static final int Conf=5;
    public static final int FLOAT=13;
    public static final int OTHERCHAR=19;
    public static final int T25=25;
    public static final int Tokens=26;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int OpBool=11;
    public static final int Msg=7;
    public static final int Bconf=6;
    public static final int SUBFIELD=22;
    public static final int FlFun=16;
    public static final int FIELD=12;
    public static final int BoFun=15;
    public static final int OpM=10;
    public static final int OpA=9;
    public static final int STRING=8;
    public static final int UNFLOAT=21;
    public BusinessRuleLexer() {;} 
    public BusinessRuleLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "/../../media/sda1/ids/src/compiler/BusinessRule.g"; }

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:4:5: ( '(' )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:4:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:5:5: ( ')' )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:5:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start FlFun
    public final void mFlFun() throws RecognitionException {
        try {
            int _type = FlFun;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:247:7: ( 'SUM' | 'AVG' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='S') ) {
                alt1=1;
            }
            else if ( (LA1_0=='A') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("247:1: FlFun : ( 'SUM' | 'AVG' );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:247:9: 'SUM'
                    {
                    match("SUM"); 


                    }
                    break;
                case 2 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:247:15: 'AVG'
                    {
                    match("AVG"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FlFun

    // $ANTLR start BoFun
    public final void mBoFun() throws RecognitionException {
        try {
            int _type = BoFun;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:249:7: ( 'NOT' )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:249:9: 'NOT'
            {
            match("NOT"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end BoFun

    // $ANTLR start Count
    public final void mCount() throws RecognitionException {
        try {
            int _type = Count;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:251:7: ( 'COUNT' )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:251:9: 'COUNT'
            {
            match("COUNT"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Count

    // $ANTLR start Msg
    public final void mMsg() throws RecognitionException {
        try {
            int _type = Msg;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:253:5: ( 'message' )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:253:7: 'message'
            {
            match("message"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Msg

    // $ANTLR start OpRule
    public final void mOpRule() throws RecognitionException {
        try {
            int _type = OpRule;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:255:8: ( 'AND' | 'OR' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='A') ) {
                alt2=1;
            }
            else if ( (LA2_0=='O') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("255:1: OpRule : ( 'AND' | 'OR' );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:255:10: 'AND'
                    {
                    match("AND"); 


                    }
                    break;
                case 2 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:255:16: 'OR'
                    {
                    match("OR"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OpRule

    // $ANTLR start OpBool
    public final void mOpBool() throws RecognitionException {
        try {
            int _type = OpBool;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:257:8: ( '||' | '&&' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='|') ) {
                alt3=1;
            }
            else if ( (LA3_0=='&') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("257:1: OpBool : ( '||' | '&&' );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:257:10: '||'
                    {
                    match("||"); 


                    }
                    break;
                case 2 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:257:15: '&&'
                    {
                    match("&&"); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OpBool

    // $ANTLR start OpA
    public final void mOpA() throws RecognitionException {
        try {
            int _type = OpA;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:259:5: ( '+' | '-' )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
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
    // $ANTLR end OpA

    // $ANTLR start OpM
    public final void mOpM() throws RecognitionException {
        try {
            int _type = OpM;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:261:5: ( '*' | '/' )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:
            {
            if ( input.LA(1)=='*'||input.LA(1)=='/' ) {
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
    // $ANTLR end OpM

    // $ANTLR start Conf
    public final void mConf() throws RecognitionException {
        try {
            int _type = Conf;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:263:6: ( '<' | '>' | '<=' | '>=' )
            int alt4=4;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='<') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='=') ) {
                    alt4=3;
                }
                else {
                    alt4=1;}
            }
            else if ( (LA4_0=='>') ) {
                int LA4_2 = input.LA(2);

                if ( (LA4_2=='=') ) {
                    alt4=4;
                }
                else {
                    alt4=2;}
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("263:1: Conf : ( '<' | '>' | '<=' | '>=' );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:263:8: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 2 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:263:12: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 3 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:263:16: '<='
                    {
                    match("<="); 


                    }
                    break;
                case 4 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:263:21: '>='
                    {
                    match(">="); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Conf

    // $ANTLR start Bconf
    public final void mBconf() throws RecognitionException {
        try {
            int _type = Bconf;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:265:7: ( '=' | '!=' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='=') ) {
                alt5=1;
            }
            else if ( (LA5_0=='!') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("265:1: Bconf : ( '=' | '!=' );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:265:9: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:265:13: '!='
                    {
                    match("!="); 


                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end Bconf

    // $ANTLR start STRING
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:267:8: ( '\"' ( CHAR | ' ' | OTHERCHAR | NUMBER )* '\"' )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:267:10: '\"' ( CHAR | ' ' | OTHERCHAR | NUMBER )* '\"'
            {
            match('\"'); 
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:267:13: ( CHAR | ' ' | OTHERCHAR | NUMBER )*
            loop6:
            do {
                int alt6=5;
                switch ( input.LA(1) ) {
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
                case '_':
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
                    alt6=1;
                    }
                    break;
                case ' ':
                    {
                    alt6=2;
                    }
                    break;
                case '!':
                case '\'':
                case ',':
                case '-':
                case '.':
                case '?':
                case '^':
                case '~':
                case '\u00E0':
                case '\u00E8':
                case '\u00EC':
                case '\u00F2':
                case '\u00F9':
                    {
                    alt6=3;
                    }
                    break;
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
                    alt6=4;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // /../../media/sda1/ids/src/compiler/BusinessRule.g:267:14: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // /../../media/sda1/ids/src/compiler/BusinessRule.g:267:19: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 3 :
            	    // /../../media/sda1/ids/src/compiler/BusinessRule.g:267:23: OTHERCHAR
            	    {
            	    mOTHERCHAR(); 

            	    }
            	    break;
            	case 4 :
            	    // /../../media/sda1/ids/src/compiler/BusinessRule.g:267:33: NUMBER
            	    {
            	    mNUMBER(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRING

    // $ANTLR start BOOL
    public final void mBOOL() throws RecognitionException {
        try {
            int _type = BOOL;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:269:6: ( 'true' | 'false' )
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
                    new NoViableAltException("269:1: BOOL : ( 'true' | 'false' );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:269:8: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:269:15: 'false'
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

    // $ANTLR start FLOAT
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:271:7: ( ( '~' )? UNFLOAT )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:271:9: ( '~' )? UNFLOAT
            {
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:271:9: ( '~' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='~') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:271:10: '~'
                    {
                    match('~'); 

                    }
                    break;

            }

            mUNFLOAT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FLOAT

    // $ANTLR start FIELD
    public final void mFIELD() throws RecognitionException {
        try {
            int _type = FIELD;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:273:7: ( SUBFIELD ( '.' SUBFIELD )* )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:273:9: SUBFIELD ( '.' SUBFIELD )*
            {
            mSUBFIELD(); 
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:273:17: ( '.' SUBFIELD )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='.') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /../../media/sda1/ids/src/compiler/BusinessRule.g:273:18: '.' SUBFIELD
            	    {
            	    match('.'); 
            	    mSUBFIELD(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FIELD

    // $ANTLR start WHITESPACE
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:275:12: ( ( ' ' | '\\n' | '\\t' | '\\r' )+ )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:275:14: ( ' ' | '\\n' | '\\t' | '\\r' )+
            {
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:275:14: ( ' ' | '\\n' | '\\t' | '\\r' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /../../media/sda1/ids/src/compiler/BusinessRule.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

             skip();

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WHITESPACE

    // $ANTLR start OTHERCHAR
    public final void mOTHERCHAR() throws RecognitionException {
        try {
            int _type = OTHERCHAR;
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:277:11: ( ( '~' | '?' | '!' | '-' | '.' | ',' | '^' | 'à' | 'è' | 'ì' | 'ò' | 'ù' | '\\'' ) )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:277:13: ( '~' | '?' | '!' | '-' | '.' | ',' | '^' | 'à' | 'è' | 'ì' | 'ò' | 'ù' | '\\'' )
            {
            if ( input.LA(1)=='!'||input.LA(1)=='\''||(input.LA(1)>=',' && input.LA(1)<='.')||input.LA(1)=='?'||input.LA(1)=='^'||input.LA(1)=='~'||input.LA(1)=='\u00E0'||input.LA(1)=='\u00E8'||input.LA(1)=='\u00EC'||input.LA(1)=='\u00F2'||input.LA(1)=='\u00F9' ) {
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
    // $ANTLR end OTHERCHAR

    // $ANTLR start SUBFIELD
    public final void mSUBFIELD() throws RecognitionException {
        try {
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:279:19: ( CHAR ( CHAR | ( '0' .. '9' ) )* )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:279:21: CHAR ( CHAR | ( '0' .. '9' ) )*
            {
            mCHAR(); 
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:279:25: ( CHAR | ( '0' .. '9' ) )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='a' && LA11_0<='z')) ) {
                    alt11=1;
                }
                else if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // /../../media/sda1/ids/src/compiler/BusinessRule.g:279:26: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // /../../media/sda1/ids/src/compiler/BusinessRule.g:279:31: ( '0' .. '9' )
            	    {
            	    // /../../media/sda1/ids/src/compiler/BusinessRule.g:279:31: ( '0' .. '9' )
            	    // /../../media/sda1/ids/src/compiler/BusinessRule.g:279:32: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end SUBFIELD

    // $ANTLR start CHAR
    public final void mCHAR() throws RecognitionException {
        try {
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:281:15: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' )
            int alt12=3;
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
                alt12=1;
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
                alt12=2;
                }
                break;
            case '_':
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("281:10: fragment CHAR : ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:281:17: ( 'a' .. 'z' )
                    {
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:281:17: ( 'a' .. 'z' )
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:281:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:281:28: ( 'A' .. 'Z' )
                    {
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:281:28: ( 'A' .. 'Z' )
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:281:29: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:281:39: '_'
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

    // $ANTLR start UNFLOAT
    public final void mUNFLOAT() throws RecognitionException {
        try {
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:283:18: ( ( NUMBER )+ ( '.' NUMBER )? )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:283:19: ( NUMBER )+ ( '.' NUMBER )?
            {
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:283:19: ( NUMBER )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /../../media/sda1/ids/src/compiler/BusinessRule.g:283:19: NUMBER
            	    {
            	    mNUMBER(); 

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            // /../../media/sda1/ids/src/compiler/BusinessRule.g:283:26: ( '.' NUMBER )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='.') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /../../media/sda1/ids/src/compiler/BusinessRule.g:283:27: '.' NUMBER
                    {
                    match('.'); 
                    mNUMBER(); 

                    }
                    break;

            }


            }

        }
        finally {
        }
    }
    // $ANTLR end UNFLOAT

    // $ANTLR start NUMBER
    public final void mNUMBER() throws RecognitionException {
        try {
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:285:18: ( ( '0' .. '9' )+ )
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:285:19: ( '0' .. '9' )+
            {
            // /../../media/sda1/ids/src/compiler/BusinessRule.g:285:19: ( '0' .. '9' )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='0' && LA15_0<='9')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /../../media/sda1/ids/src/compiler/BusinessRule.g:285:20: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end NUMBER

    public void mTokens() throws RecognitionException {
        // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:8: ( T24 | T25 | FlFun | BoFun | Count | Msg | OpRule | OpBool | OpA | OpM | Conf | Bconf | STRING | BOOL | FLOAT | FIELD | WHITESPACE | OTHERCHAR )
        int alt16=18;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt16=1;
            }
            break;
        case ')':
            {
            alt16=2;
            }
            break;
        case 'S':
            {
            int LA16_3 = input.LA(2);

            if ( (LA16_3=='U') ) {
                int LA16_24 = input.LA(3);

                if ( (LA16_24=='M') ) {
                    int LA16_33 = input.LA(4);

                    if ( (LA16_33=='.'||(LA16_33>='0' && LA16_33<='9')||(LA16_33>='A' && LA16_33<='Z')||LA16_33=='_'||(LA16_33>='a' && LA16_33<='z')) ) {
                        alt16=16;
                    }
                    else {
                        alt16=3;}
                }
                else {
                    alt16=16;}
            }
            else {
                alt16=16;}
            }
            break;
        case 'A':
            {
            switch ( input.LA(2) ) {
            case 'V':
                {
                int LA16_25 = input.LA(3);

                if ( (LA16_25=='G') ) {
                    int LA16_34 = input.LA(4);

                    if ( (LA16_34=='.'||(LA16_34>='0' && LA16_34<='9')||(LA16_34>='A' && LA16_34<='Z')||LA16_34=='_'||(LA16_34>='a' && LA16_34<='z')) ) {
                        alt16=16;
                    }
                    else {
                        alt16=3;}
                }
                else {
                    alt16=16;}
                }
                break;
            case 'N':
                {
                int LA16_26 = input.LA(3);

                if ( (LA16_26=='D') ) {
                    int LA16_35 = input.LA(4);

                    if ( (LA16_35=='.'||(LA16_35>='0' && LA16_35<='9')||(LA16_35>='A' && LA16_35<='Z')||LA16_35=='_'||(LA16_35>='a' && LA16_35<='z')) ) {
                        alt16=16;
                    }
                    else {
                        alt16=7;}
                }
                else {
                    alt16=16;}
                }
                break;
            default:
                alt16=16;}

            }
            break;
        case 'N':
            {
            int LA16_5 = input.LA(2);

            if ( (LA16_5=='O') ) {
                int LA16_27 = input.LA(3);

                if ( (LA16_27=='T') ) {
                    int LA16_36 = input.LA(4);

                    if ( (LA16_36=='.'||(LA16_36>='0' && LA16_36<='9')||(LA16_36>='A' && LA16_36<='Z')||LA16_36=='_'||(LA16_36>='a' && LA16_36<='z')) ) {
                        alt16=16;
                    }
                    else {
                        alt16=4;}
                }
                else {
                    alt16=16;}
            }
            else {
                alt16=16;}
            }
            break;
        case 'C':
            {
            int LA16_6 = input.LA(2);

            if ( (LA16_6=='O') ) {
                int LA16_28 = input.LA(3);

                if ( (LA16_28=='U') ) {
                    int LA16_37 = input.LA(4);

                    if ( (LA16_37=='N') ) {
                        int LA16_44 = input.LA(5);

                        if ( (LA16_44=='T') ) {
                            int LA16_48 = input.LA(6);

                            if ( (LA16_48=='.'||(LA16_48>='0' && LA16_48<='9')||(LA16_48>='A' && LA16_48<='Z')||LA16_48=='_'||(LA16_48>='a' && LA16_48<='z')) ) {
                                alt16=16;
                            }
                            else {
                                alt16=5;}
                        }
                        else {
                            alt16=16;}
                    }
                    else {
                        alt16=16;}
                }
                else {
                    alt16=16;}
            }
            else {
                alt16=16;}
            }
            break;
        case 'm':
            {
            int LA16_7 = input.LA(2);

            if ( (LA16_7=='e') ) {
                int LA16_29 = input.LA(3);

                if ( (LA16_29=='s') ) {
                    int LA16_38 = input.LA(4);

                    if ( (LA16_38=='s') ) {
                        int LA16_45 = input.LA(5);

                        if ( (LA16_45=='a') ) {
                            int LA16_49 = input.LA(6);

                            if ( (LA16_49=='g') ) {
                                int LA16_53 = input.LA(7);

                                if ( (LA16_53=='e') ) {
                                    int LA16_54 = input.LA(8);

                                    if ( (LA16_54=='.'||(LA16_54>='0' && LA16_54<='9')||(LA16_54>='A' && LA16_54<='Z')||LA16_54=='_'||(LA16_54>='a' && LA16_54<='z')) ) {
                                        alt16=16;
                                    }
                                    else {
                                        alt16=6;}
                                }
                                else {
                                    alt16=16;}
                            }
                            else {
                                alt16=16;}
                        }
                        else {
                            alt16=16;}
                    }
                    else {
                        alt16=16;}
                }
                else {
                    alt16=16;}
            }
            else {
                alt16=16;}
            }
            break;
        case 'O':
            {
            int LA16_8 = input.LA(2);

            if ( (LA16_8=='R') ) {
                int LA16_30 = input.LA(3);

                if ( (LA16_30=='.'||(LA16_30>='0' && LA16_30<='9')||(LA16_30>='A' && LA16_30<='Z')||LA16_30=='_'||(LA16_30>='a' && LA16_30<='z')) ) {
                    alt16=16;
                }
                else {
                    alt16=7;}
            }
            else {
                alt16=16;}
            }
            break;
        case '&':
        case '|':
            {
            alt16=8;
            }
            break;
        case '-':
            {
            alt16=9;
            }
            break;
        case '*':
        case '/':
            {
            alt16=10;
            }
            break;
        case '<':
        case '>':
            {
            alt16=11;
            }
            break;
        case '=':
            {
            alt16=12;
            }
            break;
        case '!':
            {
            int LA16_14 = input.LA(2);

            if ( (LA16_14=='=') ) {
                alt16=12;
            }
            else {
                alt16=18;}
            }
            break;
        case '\"':
            {
            alt16=13;
            }
            break;
        case 't':
            {
            int LA16_16 = input.LA(2);

            if ( (LA16_16=='r') ) {
                int LA16_31 = input.LA(3);

                if ( (LA16_31=='u') ) {
                    int LA16_40 = input.LA(4);

                    if ( (LA16_40=='e') ) {
                        int LA16_46 = input.LA(5);

                        if ( (LA16_46=='.'||(LA16_46>='0' && LA16_46<='9')||(LA16_46>='A' && LA16_46<='Z')||LA16_46=='_'||(LA16_46>='a' && LA16_46<='z')) ) {
                            alt16=16;
                        }
                        else {
                            alt16=14;}
                    }
                    else {
                        alt16=16;}
                }
                else {
                    alt16=16;}
            }
            else {
                alt16=16;}
            }
            break;
        case 'f':
            {
            int LA16_17 = input.LA(2);

            if ( (LA16_17=='a') ) {
                int LA16_32 = input.LA(3);

                if ( (LA16_32=='l') ) {
                    int LA16_41 = input.LA(4);

                    if ( (LA16_41=='s') ) {
                        int LA16_47 = input.LA(5);

                        if ( (LA16_47=='e') ) {
                            int LA16_51 = input.LA(6);

                            if ( (LA16_51=='.'||(LA16_51>='0' && LA16_51<='9')||(LA16_51>='A' && LA16_51<='Z')||LA16_51=='_'||(LA16_51>='a' && LA16_51<='z')) ) {
                                alt16=16;
                            }
                            else {
                                alt16=14;}
                        }
                        else {
                            alt16=16;}
                    }
                    else {
                        alt16=16;}
                }
                else {
                    alt16=16;}
            }
            else {
                alt16=16;}
            }
            break;
        case '~':
            {
            int LA16_18 = input.LA(2);

            if ( ((LA16_18>='0' && LA16_18<='9')) ) {
                alt16=15;
            }
            else {
                alt16=18;}
            }
            break;
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
            alt16=15;
            }
            break;
        case 'B':
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
        case 'P':
        case 'Q':
        case 'R':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case '_':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt16=16;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt16=17;
            }
            break;
        case '+':
            {
            alt16=9;
            }
            break;
        case '\'':
        case ',':
        case '.':
        case '?':
        case '^':
        case '\u00E0':
        case '\u00E8':
        case '\u00EC':
        case '\u00F2':
        case '\u00F9':
            {
            alt16=18;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T24 | T25 | FlFun | BoFun | Count | Msg | OpRule | OpBool | OpA | OpM | Conf | Bconf | STRING | BOOL | FLOAT | FIELD | WHITESPACE | OTHERCHAR );", 16, 0, input);

            throw nvae;
        }

        switch (alt16) {
            case 1 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:10: T24
                {
                mT24(); 

                }
                break;
            case 2 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:14: T25
                {
                mT25(); 

                }
                break;
            case 3 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:18: FlFun
                {
                mFlFun(); 

                }
                break;
            case 4 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:24: BoFun
                {
                mBoFun(); 

                }
                break;
            case 5 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:30: Count
                {
                mCount(); 

                }
                break;
            case 6 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:36: Msg
                {
                mMsg(); 

                }
                break;
            case 7 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:40: OpRule
                {
                mOpRule(); 

                }
                break;
            case 8 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:47: OpBool
                {
                mOpBool(); 

                }
                break;
            case 9 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:54: OpA
                {
                mOpA(); 

                }
                break;
            case 10 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:58: OpM
                {
                mOpM(); 

                }
                break;
            case 11 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:62: Conf
                {
                mConf(); 

                }
                break;
            case 12 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:67: Bconf
                {
                mBconf(); 

                }
                break;
            case 13 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:73: STRING
                {
                mSTRING(); 

                }
                break;
            case 14 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:80: BOOL
                {
                mBOOL(); 

                }
                break;
            case 15 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:85: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 16 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:91: FIELD
                {
                mFIELD(); 

                }
                break;
            case 17 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:97: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 18 :
                // /../../media/sda1/ids/src/compiler/BusinessRule.g:1:108: OTHERCHAR
                {
                mOTHERCHAR(); 

                }
                break;

        }

    }


 

}