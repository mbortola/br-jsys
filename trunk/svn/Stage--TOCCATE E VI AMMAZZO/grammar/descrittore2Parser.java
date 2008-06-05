// $ANTLR 3.0.1 C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g 2008-06-05 16:22:47
package grammar;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;

import org.antlr.runtime.tree.*;

public class descrittore2Parser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING", "Card", "Atom", "Def", "FLOAT", "BOOL", "CHAR", "WHITESPACE", "':'", "':='", "'='", "'('", "','", "')'"
    };
    public static final int BOOL=9;
    public static final int Def=7;
    public static final int EOF=-1;
    public static final int CHAR=10;
    public static final int STRING=4;
    public static final int FLOAT=8;
    public static final int Card=5;
    public static final int WHITESPACE=11;
    public static final int Atom=6;
    public static final String[] ruleNames = new String[] {
        "invalidRule", "start", "typedef", "type", "atom", "list", "el"
    };

    public int ruleLevel = 0;
    public descrittore2Parser(TokenStream input, int port) {
            super(input, port);
            DebugEventSocketProxy proxy =
                new DebugEventSocketProxy(this, port, adaptor);
            setDebugListener(proxy);
            adaptor.setDebugEventListener(proxy);
            try {
                proxy.handshake();
            }
            catch (IOException ioe) {
                reportError(ioe);
            }

    }
    public descrittore2Parser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT);
    }
    public descrittore2Parser(TokenStream input, DebugEventListener dbg) {
        super(input, dbg);
        adaptor.setDebugEventListener(dbg);
    }

    protected boolean evalPredicate(boolean result, String predicate) {
        dbg.semanticPredicate(result, predicate);
        return result;
    }

    protected DebugTreeAdaptor adaptor =
    	  new DebugTreeAdaptor(null,new CommonTreeAdaptor());
    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = new DebugTreeAdaptor(dbg,adaptor);
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }


    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g"; }


    public static class start_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start start
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:15:1: start : ( typedef )+ ;
    public final start_return start() throws RecognitionException {
        start_return retval = new start_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        typedef_return typedef1 = null;



        try { dbg.enterRule("start");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(15, 1);

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:15:7: ( ( typedef )+ )
            dbg.enterAlt(1);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:15:9: ( typedef )+
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(15,9);
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:15:9: ( typedef )+
            int cnt1=0;
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==STRING) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:15:9: typedef
            	    {
            	    dbg.location(15,9);
            	    pushFollow(FOLLOW_typedef_in_start42);
            	    typedef1=typedef();
            	    _fsp--;

            	    adaptor.addChild(root_0, typedef1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt1++;
            } while (true);
            } finally {dbg.exitSubRule(1);}


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(15, 17);

        }
        finally {
            dbg.exitRule("start");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end start

    public static class typedef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start typedef
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:17:1: typedef : STRING ':' type ;
    public final typedef_return typedef() throws RecognitionException {
        typedef_return retval = new typedef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING2=null;
        Token char_literal3=null;
        type_return type4 = null;


        CommonTree STRING2_tree=null;
        CommonTree char_literal3_tree=null;

        try { dbg.enterRule("typedef");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(17, 1);

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:17:9: ( STRING ':' type )
            dbg.enterAlt(1);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:17:11: STRING ':' type
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(17,11);
            STRING2=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_typedef51); 
            STRING2_tree = (CommonTree)adaptor.create(STRING2);
            adaptor.addChild(root_0, STRING2_tree);

            dbg.location(17,18);
            char_literal3=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_typedef53); 
            char_literal3_tree = (CommonTree)adaptor.create(char_literal3);
            adaptor.addChild(root_0, char_literal3_tree);

            dbg.location(17,22);
            pushFollow(FOLLOW_type_in_typedef55);
            type4=type();
            _fsp--;

            adaptor.addChild(root_0, type4.getTree());

            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(17, 26);

        }
        finally {
            dbg.exitRule("typedef");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end typedef

    public static class type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start type
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:19:1: type : ( atom | list ) ( Card )? ;
    public final type_return type() throws RecognitionException {
        type_return retval = new type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Card7=null;
        atom_return atom5 = null;

        list_return list6 = null;


        CommonTree Card7_tree=null;

        try { dbg.enterRule("type");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(19, 1);

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:19:7: ( ( atom | list ) ( Card )? )
            dbg.enterAlt(1);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:19:9: ( atom | list ) ( Card )?
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(19,9);
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:19:9: ( atom | list )
            int alt2=2;
            try { dbg.enterSubRule(2);
            try { dbg.enterDecision(2);

            int LA2_0 = input.LA(1);

            if ( (LA2_0==Atom) ) {
                alt2=1;
            }
            else if ( (LA2_0==15) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("19:9: ( atom | list )", 2, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:19:10: atom
                    {
                    dbg.location(19,10);
                    pushFollow(FOLLOW_atom_in_type65);
                    atom5=atom();
                    _fsp--;

                    adaptor.addChild(root_0, atom5.getTree());

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:19:16: list
                    {
                    dbg.location(19,16);
                    pushFollow(FOLLOW_list_in_type68);
                    list6=list();
                    _fsp--;

                    adaptor.addChild(root_0, list6.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(2);}

            dbg.location(19,22);
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:19:22: ( Card )?
            int alt3=2;
            try { dbg.enterSubRule(3);
            try { dbg.enterDecision(3);

            int LA3_0 = input.LA(1);

            if ( (LA3_0==Card) ) {
                alt3=1;
            }
            } finally {dbg.exitDecision(3);}

            switch (alt3) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:19:22: Card
                    {
                    dbg.location(19,22);
                    Card7=(Token)input.LT(1);
                    match(input,Card,FOLLOW_Card_in_type71); 
                    Card7_tree = (CommonTree)adaptor.create(Card7);
                    adaptor.addChild(root_0, Card7_tree);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(3);}


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(19, 27);

        }
        finally {
            dbg.exitRule("type");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end type

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start atom
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:21:1: atom : Atom ( ( ':=' | '=' ) ( Def | FLOAT | BOOL ) )? ;
    public final atom_return atom() throws RecognitionException {
        atom_return retval = new atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Atom8=null;
        Token set9=null;
        Token set10=null;

        CommonTree Atom8_tree=null;
        CommonTree set9_tree=null;
        CommonTree set10_tree=null;

        try { dbg.enterRule("atom");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(21, 1);

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:21:6: ( Atom ( ( ':=' | '=' ) ( Def | FLOAT | BOOL ) )? )
            dbg.enterAlt(1);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:21:8: Atom ( ( ':=' | '=' ) ( Def | FLOAT | BOOL ) )?
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(21,8);
            Atom8=(Token)input.LT(1);
            match(input,Atom,FOLLOW_Atom_in_atom80); 
            Atom8_tree = (CommonTree)adaptor.create(Atom8);
            adaptor.addChild(root_0, Atom8_tree);

            dbg.location(21,13);
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:21:13: ( ( ':=' | '=' ) ( Def | FLOAT | BOOL ) )?
            int alt4=2;
            try { dbg.enterSubRule(4);
            try { dbg.enterDecision(4);

            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=13 && LA4_0<=14)) ) {
                alt4=1;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:21:14: ( ':=' | '=' ) ( Def | FLOAT | BOOL )
                    {
                    dbg.location(21,14);
                    set9=(Token)input.LT(1);
                    if ( (input.LA(1)>=13 && input.LA(1)<=14) ) {
                        input.consume();
                        adaptor.addChild(root_0, adaptor.create(set9));
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        dbg.recognitionException(mse);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_atom83);    throw mse;
                    }

                    dbg.location(21,25);
                    set10=(Token)input.LT(1);
                    if ( (input.LA(1)>=Def && input.LA(1)<=BOOL) ) {
                        input.consume();
                        adaptor.addChild(root_0, adaptor.create(set10));
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        dbg.recognitionException(mse);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_atom89);    throw mse;
                    }


                    }
                    break;

            }
            } finally {dbg.exitSubRule(4);}


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(21, 43);

        }
        finally {
            dbg.exitRule("atom");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end atom

    public static class list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start list
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:23:1: list : '(' el ( ',' el )* ')' ;
    public final list_return list() throws RecognitionException {
        list_return retval = new list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal11=null;
        Token char_literal13=null;
        Token char_literal15=null;
        el_return el12 = null;

        el_return el14 = null;


        CommonTree char_literal11_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree char_literal15_tree=null;

        try { dbg.enterRule("list");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(23, 1);

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:23:6: ( '(' el ( ',' el )* ')' )
            dbg.enterAlt(1);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:23:8: '(' el ( ',' el )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(23,8);
            char_literal11=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_list105); 
            char_literal11_tree = (CommonTree)adaptor.create(char_literal11);
            adaptor.addChild(root_0, char_literal11_tree);

            dbg.location(23,12);
            pushFollow(FOLLOW_el_in_list107);
            el12=el();
            _fsp--;

            adaptor.addChild(root_0, el12.getTree());
            dbg.location(23,15);
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:23:15: ( ',' el )*
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=2;
                try { dbg.enterDecision(5);

                int LA5_0 = input.LA(1);

                if ( (LA5_0==16) ) {
                    alt5=1;
                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:23:16: ',' el
            	    {
            	    dbg.location(23,16);
            	    char_literal13=(Token)input.LT(1);
            	    match(input,16,FOLLOW_16_in_list110); 
            	    char_literal13_tree = (CommonTree)adaptor.create(char_literal13);
            	    adaptor.addChild(root_0, char_literal13_tree);

            	    dbg.location(23,19);
            	    pushFollow(FOLLOW_el_in_list111);
            	    el14=el();
            	    _fsp--;

            	    adaptor.addChild(root_0, el14.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);
            } finally {dbg.exitSubRule(5);}

            dbg.location(23,25);
            char_literal15=(Token)input.LT(1);
            match(input,17,FOLLOW_17_in_list116); 
            char_literal15_tree = (CommonTree)adaptor.create(char_literal15);
            adaptor.addChild(root_0, char_literal15_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(23, 28);

        }
        finally {
            dbg.exitRule("list");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end list

    public static class el_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start el
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:25:1: el : STRING ( ( Card )? | ':' type ) ;
    public final el_return el() throws RecognitionException {
        el_return retval = new el_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING16=null;
        Token Card17=null;
        Token char_literal18=null;
        type_return type19 = null;


        CommonTree STRING16_tree=null;
        CommonTree Card17_tree=null;
        CommonTree char_literal18_tree=null;

        try { dbg.enterRule("el");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(25, 1);

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:25:4: ( STRING ( ( Card )? | ':' type ) )
            dbg.enterAlt(1);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:25:6: STRING ( ( Card )? | ':' type )
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(25,6);
            STRING16=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_el124); 
            STRING16_tree = (CommonTree)adaptor.create(STRING16);
            adaptor.addChild(root_0, STRING16_tree);

            dbg.location(25,13);
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:25:13: ( ( Card )? | ':' type )
            int alt7=2;
            try { dbg.enterSubRule(7);
            try { dbg.enterDecision(7);

            int LA7_0 = input.LA(1);

            if ( (LA7_0==Card||(LA7_0>=16 && LA7_0<=17)) ) {
                alt7=1;
            }
            else if ( (LA7_0==12) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("25:13: ( ( Card )? | ':' type )", 7, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(7);}

            switch (alt7) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:25:14: ( Card )?
                    {
                    dbg.location(25,14);
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:25:14: ( Card )?
                    int alt6=2;
                    try { dbg.enterSubRule(6);
                    try { dbg.enterDecision(6);

                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==Card) ) {
                        alt6=1;
                    }
                    } finally {dbg.exitDecision(6);}

                    switch (alt6) {
                        case 1 :
                            dbg.enterAlt(1);

                            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:25:14: Card
                            {
                            dbg.location(25,14);
                            Card17=(Token)input.LT(1);
                            match(input,Card,FOLLOW_Card_in_el127); 
                            Card17_tree = (CommonTree)adaptor.create(Card17);
                            adaptor.addChild(root_0, Card17_tree);


                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(6);}


                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore2.g:25:20: ':' type
                    {
                    dbg.location(25,20);
                    char_literal18=(Token)input.LT(1);
                    match(input,12,FOLLOW_12_in_el130); 
                    char_literal18_tree = (CommonTree)adaptor.create(char_literal18);
                    adaptor.addChild(root_0, char_literal18_tree);

                    dbg.location(25,24);
                    pushFollow(FOLLOW_type_in_el132);
                    type19=type();
                    _fsp--;

                    adaptor.addChild(root_0, type19.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(7);}


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(25, 29);

        }
        finally {
            dbg.exitRule("el");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end el


 

    public static final BitSet FOLLOW_typedef_in_start42 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_STRING_in_typedef51 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_typedef53 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_type_in_typedef55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_type65 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_list_in_type68 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_Card_in_type71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Atom_in_atom80 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_set_in_atom83 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_set_in_atom89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_list105 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_el_in_list107 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_list110 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_el_in_list111 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_list116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_el124 = new BitSet(new long[]{0x0000000000001022L});
    public static final BitSet FOLLOW_Card_in_el127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_el130 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_type_in_el132 = new BitSet(new long[]{0x0000000000000002L});

}