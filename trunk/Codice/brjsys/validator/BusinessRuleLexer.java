// $ANTLR 3.0.1 /media/DISK_IMG/br-jsys/Codice/BusinessRule.g 2008-03-20 20:24:09
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
    public static final int T26=26;
    public static final int T25=25;
    public static final int Tokens=27;
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
    public String getGrammarFileName() { return "/media/DISK_IMG/br-jsys/Codice/BusinessRule.g"; }

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:4:5: ( '#' )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:4:7: '#'
            {
            match('#'); 

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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:5:5: ( '(' )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:5:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:6:5: ( ')' )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:6:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start FlFun
    public final void mFlFun() throws RecognitionException {
        try {
            int _type = FlFun;
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:240:7: ( 'SUM' | 'AVG' )
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
                    new NoViableAltException("240:1: FlFun : ( 'SUM' | 'AVG' );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:240:9: 'SUM'
                    {
                    match("SUM"); 


                    }
                    break;
                case 2 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:240:15: 'AVG'
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:242:7: ( 'NOT' )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:242:9: 'NOT'
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:244:7: ( 'COUNT' )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:244:9: 'COUNT'
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:246:5: ( 'message' )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:246:7: 'message'
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:248:8: ( 'AND' | 'OR' )
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
                    new NoViableAltException("248:1: OpRule : ( 'AND' | 'OR' );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:248:10: 'AND'
                    {
                    match("AND"); 


                    }
                    break;
                case 2 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:248:16: 'OR'
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:250:8: ( '||' | '&&' )
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
                    new NoViableAltException("250:1: OpBool : ( '||' | '&&' );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:250:10: '||'
                    {
                    match("||"); 


                    }
                    break;
                case 2 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:250:15: '&&'
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:252:5: ( '+' | '-' )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:254:5: ( '*' | '/' )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:256:6: ( '<' | '>' | '<=' | '>=' )
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
                    new NoViableAltException("256:1: Conf : ( '<' | '>' | '<=' | '>=' );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:256:8: '<'
                    {
                    match('<'); 

                    }
                    break;
                case 2 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:256:12: '>'
                    {
                    match('>'); 

                    }
                    break;
                case 3 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:256:16: '<='
                    {
                    match("<="); 


                    }
                    break;
                case 4 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:256:21: '>='
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:258:7: ( '=' | '!=' )
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
                    new NoViableAltException("258:1: Bconf : ( '=' | '!=' );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:258:9: '='
                    {
                    match('='); 

                    }
                    break;
                case 2 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:258:13: '!='
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:260:8: ( '\"' ( CHAR | ' ' | OTHERCHAR | NUMBER )* '\"' )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:260:10: '\"' ( CHAR | ' ' | OTHERCHAR | NUMBER )* '\"'
            {
            match('\"'); 
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:260:13: ( CHAR | ' ' | OTHERCHAR | NUMBER )*
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
                case ':':
                case ';':
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
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:260:14: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:260:19: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 3 :
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:260:23: OTHERCHAR
            	    {
            	    mOTHERCHAR(); 

            	    }
            	    break;
            	case 4 :
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:260:33: NUMBER
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:262:6: ( 'true' | 'false' )
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
                    new NoViableAltException("262:1: BOOL : ( 'true' | 'false' );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:262:8: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:262:15: 'false'
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:264:7: ( ( '~' )? UNFLOAT )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:264:9: ( '~' )? UNFLOAT
            {
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:264:9: ( '~' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='~') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:264:10: '~'
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:266:7: ( SUBFIELD ( '.' SUBFIELD )* )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:266:9: SUBFIELD ( '.' SUBFIELD )*
            {
            mSUBFIELD(); 
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:266:17: ( '.' SUBFIELD )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='.') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:266:18: '.' SUBFIELD
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:268:12: ( ( ' ' | '\\n' | '\\t' | '\\r' )+ )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:268:14: ( ' ' | '\\n' | '\\t' | '\\r' )+
            {
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:268:14: ( ' ' | '\\n' | '\\t' | '\\r' )+
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
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:270:11: ( ( '~' | '?' | '!' | '-' | '.' | ',' | '^' | 'à' | 'è' | 'ì' | 'ò' | 'ù' | '\\'' | ';' | ':' ) )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:270:13: ( '~' | '?' | '!' | '-' | '.' | ',' | '^' | 'à' | 'è' | 'ì' | 'ò' | 'ù' | '\\'' | ';' | ':' )
            {
            if ( input.LA(1)=='!'||input.LA(1)=='\''||(input.LA(1)>=',' && input.LA(1)<='.')||(input.LA(1)>=':' && input.LA(1)<=';')||input.LA(1)=='?'||input.LA(1)=='^'||input.LA(1)=='~'||input.LA(1)=='\u00E0'||input.LA(1)=='\u00E8'||input.LA(1)=='\u00EC'||input.LA(1)=='\u00F2'||input.LA(1)=='\u00F9' ) {
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:272:19: ( CHAR ( CHAR | ( '0' .. '9' ) )* )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:272:21: CHAR ( CHAR | ( '0' .. '9' ) )*
            {
            mCHAR(); 
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:272:25: ( CHAR | ( '0' .. '9' ) )*
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
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:272:26: CHAR
            	    {
            	    mCHAR(); 

            	    }
            	    break;
            	case 2 :
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:272:31: ( '0' .. '9' )
            	    {
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:272:31: ( '0' .. '9' )
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:272:32: '0' .. '9'
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:274:15: ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' )
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
                    new NoViableAltException("274:10: fragment CHAR : ( ( 'a' .. 'z' ) | ( 'A' .. 'Z' ) | '_' );", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:274:17: ( 'a' .. 'z' )
                    {
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:274:17: ( 'a' .. 'z' )
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:274:18: 'a' .. 'z'
                    {
                    matchRange('a','z'); 

                    }


                    }
                    break;
                case 2 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:274:28: ( 'A' .. 'Z' )
                    {
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:274:28: ( 'A' .. 'Z' )
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:274:29: 'A' .. 'Z'
                    {
                    matchRange('A','Z'); 

                    }


                    }
                    break;
                case 3 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:274:39: '_'
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:276:18: ( ( NUMBER )+ ( '.' NUMBER )? )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:276:19: ( NUMBER )+ ( '.' NUMBER )?
            {
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:276:19: ( NUMBER )+
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
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:276:19: NUMBER
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

            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:276:26: ( '.' NUMBER )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0=='.') ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:276:27: '.' NUMBER
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
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:278:18: ( ( '0' .. '9' )+ )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:278:19: ( '0' .. '9' )+
            {
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:278:19: ( '0' .. '9' )+
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
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:278:20: '0' .. '9'
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
        // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:8: ( T24 | T25 | T26 | FlFun | BoFun | Count | Msg | OpRule | OpBool | OpA | OpM | Conf | Bconf | STRING | BOOL | FLOAT | FIELD | WHITESPACE | OTHERCHAR )
        int alt16=19;
        switch ( input.LA(1) ) {
        case '#':
            {
            alt16=1;
            }
            break;
        case '(':
            {
            alt16=2;
            }
            break;
        case ')':
            {
            alt16=3;
            }
            break;
        case 'S':
            {
            int LA16_4 = input.LA(2);

            if ( (LA16_4=='U') ) {
                int LA16_25 = input.LA(3);

                if ( (LA16_25=='M') ) {
                    int LA16_34 = input.LA(4);

                    if ( (LA16_34=='.'||(LA16_34>='0' && LA16_34<='9')||(LA16_34>='A' && LA16_34<='Z')||LA16_34=='_'||(LA16_34>='a' && LA16_34<='z')) ) {
                        alt16=17;
                    }
                    else {
                        alt16=4;}
                }
                else {
                    alt16=17;}
            }
            else {
                alt16=17;}
            }
            break;
        case 'A':
            {
            switch ( input.LA(2) ) {
            case 'V':
                {
                int LA16_26 = input.LA(3);

                if ( (LA16_26=='G') ) {
                    int LA16_35 = input.LA(4);

                    if ( (LA16_35=='.'||(LA16_35>='0' && LA16_35<='9')||(LA16_35>='A' && LA16_35<='Z')||LA16_35=='_'||(LA16_35>='a' && LA16_35<='z')) ) {
                        alt16=17;
                    }
                    else {
                        alt16=4;}
                }
                else {
                    alt16=17;}
                }
                break;
            case 'N':
                {
                int LA16_27 = input.LA(3);

                if ( (LA16_27=='D') ) {
                    int LA16_36 = input.LA(4);

                    if ( (LA16_36=='.'||(LA16_36>='0' && LA16_36<='9')||(LA16_36>='A' && LA16_36<='Z')||LA16_36=='_'||(LA16_36>='a' && LA16_36<='z')) ) {
                        alt16=17;
                    }
                    else {
                        alt16=8;}
                }
                else {
                    alt16=17;}
                }
                break;
            default:
                alt16=17;}

            }
            break;
        case 'N':
            {
            int LA16_6 = input.LA(2);

            if ( (LA16_6=='O') ) {
                int LA16_28 = input.LA(3);

                if ( (LA16_28=='T') ) {
                    int LA16_37 = input.LA(4);

                    if ( (LA16_37=='.'||(LA16_37>='0' && LA16_37<='9')||(LA16_37>='A' && LA16_37<='Z')||LA16_37=='_'||(LA16_37>='a' && LA16_37<='z')) ) {
                        alt16=17;
                    }
                    else {
                        alt16=5;}
                }
                else {
                    alt16=17;}
            }
            else {
                alt16=17;}
            }
            break;
        case 'C':
            {
            int LA16_7 = input.LA(2);

            if ( (LA16_7=='O') ) {
                int LA16_29 = input.LA(3);

                if ( (LA16_29=='U') ) {
                    int LA16_38 = input.LA(4);

                    if ( (LA16_38=='N') ) {
                        int LA16_45 = input.LA(5);

                        if ( (LA16_45=='T') ) {
                            int LA16_49 = input.LA(6);

                            if ( (LA16_49=='.'||(LA16_49>='0' && LA16_49<='9')||(LA16_49>='A' && LA16_49<='Z')||LA16_49=='_'||(LA16_49>='a' && LA16_49<='z')) ) {
                                alt16=17;
                            }
                            else {
                                alt16=6;}
                        }
                        else {
                            alt16=17;}
                    }
                    else {
                        alt16=17;}
                }
                else {
                    alt16=17;}
            }
            else {
                alt16=17;}
            }
            break;
        case 'm':
            {
            int LA16_8 = input.LA(2);

            if ( (LA16_8=='e') ) {
                int LA16_30 = input.LA(3);

                if ( (LA16_30=='s') ) {
                    int LA16_39 = input.LA(4);

                    if ( (LA16_39=='s') ) {
                        int LA16_46 = input.LA(5);

                        if ( (LA16_46=='a') ) {
                            int LA16_50 = input.LA(6);

                            if ( (LA16_50=='g') ) {
                                int LA16_54 = input.LA(7);

                                if ( (LA16_54=='e') ) {
                                    int LA16_55 = input.LA(8);

                                    if ( (LA16_55=='.'||(LA16_55>='0' && LA16_55<='9')||(LA16_55>='A' && LA16_55<='Z')||LA16_55=='_'||(LA16_55>='a' && LA16_55<='z')) ) {
                                        alt16=17;
                                    }
                                    else {
                                        alt16=7;}
                                }
                                else {
                                    alt16=17;}
                            }
                            else {
                                alt16=17;}
                        }
                        else {
                            alt16=17;}
                    }
                    else {
                        alt16=17;}
                }
                else {
                    alt16=17;}
            }
            else {
                alt16=17;}
            }
            break;
        case 'O':
            {
            int LA16_9 = input.LA(2);

            if ( (LA16_9=='R') ) {
                int LA16_31 = input.LA(3);

                if ( (LA16_31=='.'||(LA16_31>='0' && LA16_31<='9')||(LA16_31>='A' && LA16_31<='Z')||LA16_31=='_'||(LA16_31>='a' && LA16_31<='z')) ) {
                    alt16=17;
                }
                else {
                    alt16=8;}
            }
            else {
                alt16=17;}
            }
            break;
        case '&':
        case '|':
            {
            alt16=9;
            }
            break;
        case '-':
            {
            alt16=10;
            }
            break;
        case '*':
        case '/':
            {
            alt16=11;
            }
            break;
        case '<':
        case '>':
            {
            alt16=12;
            }
            break;
        case '=':
            {
            alt16=13;
            }
            break;
        case '!':
            {
            int LA16_15 = input.LA(2);

            if ( (LA16_15=='=') ) {
                alt16=13;
            }
            else {
                alt16=19;}
            }
            break;
        case '\"':
            {
            alt16=14;
            }
            break;
        case 't':
            {
            int LA16_17 = input.LA(2);

            if ( (LA16_17=='r') ) {
                int LA16_32 = input.LA(3);

                if ( (LA16_32=='u') ) {
                    int LA16_41 = input.LA(4);

                    if ( (LA16_41=='e') ) {
                        int LA16_47 = input.LA(5);

                        if ( (LA16_47=='.'||(LA16_47>='0' && LA16_47<='9')||(LA16_47>='A' && LA16_47<='Z')||LA16_47=='_'||(LA16_47>='a' && LA16_47<='z')) ) {
                            alt16=17;
                        }
                        else {
                            alt16=15;}
                    }
                    else {
                        alt16=17;}
                }
                else {
                    alt16=17;}
            }
            else {
                alt16=17;}
            }
            break;
        case 'f':
            {
            int LA16_18 = input.LA(2);

            if ( (LA16_18=='a') ) {
                int LA16_33 = input.LA(3);

                if ( (LA16_33=='l') ) {
                    int LA16_42 = input.LA(4);

                    if ( (LA16_42=='s') ) {
                        int LA16_48 = input.LA(5);

                        if ( (LA16_48=='e') ) {
                            int LA16_52 = input.LA(6);

                            if ( (LA16_52=='.'||(LA16_52>='0' && LA16_52<='9')||(LA16_52>='A' && LA16_52<='Z')||LA16_52=='_'||(LA16_52>='a' && LA16_52<='z')) ) {
                                alt16=17;
                            }
                            else {
                                alt16=15;}
                        }
                        else {
                            alt16=17;}
                    }
                    else {
                        alt16=17;}
                }
                else {
                    alt16=17;}
            }
            else {
                alt16=17;}
            }
            break;
        case '~':
            {
            int LA16_19 = input.LA(2);

            if ( ((LA16_19>='0' && LA16_19<='9')) ) {
                alt16=16;
            }
            else {
                alt16=19;}
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
            alt16=16;
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
            alt16=17;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt16=18;
            }
            break;
        case '+':
            {
            alt16=10;
            }
            break;
        case '\'':
        case ',':
        case '.':
        case ':':
        case ';':
        case '?':
        case '^':
        case '\u00E0':
        case '\u00E8':
        case '\u00EC':
        case '\u00F2':
        case '\u00F9':
            {
            alt16=19;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T24 | T25 | T26 | FlFun | BoFun | Count | Msg | OpRule | OpBool | OpA | OpM | Conf | Bconf | STRING | BOOL | FLOAT | FIELD | WHITESPACE | OTHERCHAR );", 16, 0, input);

            throw nvae;
        }

        switch (alt16) {
            case 1 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:10: T24
                {
                mT24(); 

                }
                break;
            case 2 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:14: T25
                {
                mT25(); 

                }
                break;
            case 3 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:18: T26
                {
                mT26(); 

                }
                break;
            case 4 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:22: FlFun
                {
                mFlFun(); 

                }
                break;
            case 5 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:28: BoFun
                {
                mBoFun(); 

                }
                break;
            case 6 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:34: Count
                {
                mCount(); 

                }
                break;
            case 7 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:40: Msg
                {
                mMsg(); 

                }
                break;
            case 8 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:44: OpRule
                {
                mOpRule(); 

                }
                break;
            case 9 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:51: OpBool
                {
                mOpBool(); 

                }
                break;
            case 10 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:58: OpA
                {
                mOpA(); 

                }
                break;
            case 11 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:62: OpM
                {
                mOpM(); 

                }
                break;
            case 12 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:66: Conf
                {
                mConf(); 

                }
                break;
            case 13 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:71: Bconf
                {
                mBconf(); 

                }
                break;
            case 14 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:77: STRING
                {
                mSTRING(); 

                }
                break;
            case 15 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:84: BOOL
                {
                mBOOL(); 

                }
                break;
            case 16 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:89: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 17 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:95: FIELD
                {
                mFIELD(); 

                }
                break;
            case 18 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:101: WHITESPACE
                {
                mWHITESPACE(); 

                }
                break;
            case 19 :
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:1:112: OTHERCHAR
                {
                mOTHERCHAR(); 

                }
                break;

        }

    }


 

}