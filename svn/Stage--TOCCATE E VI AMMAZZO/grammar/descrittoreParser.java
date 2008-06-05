package grammar;

// $ANTLR 3.0.1 C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g 2008-06-05 12:24:08

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

public class descrittoreParser extends Parser {
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

        public descrittoreParser(TokenStream input) {
            super(input);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g"; }


    public static class start_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start start
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:13:1: start : ( type )+ ;
    public final start_return start() throws RecognitionException {
        start_return retval = new start_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        type_return type1 = null;



        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:13:7: ( ( type )+ )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:13:9: ( type )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:13:9: ( type )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:13:9: type
            	    {
            	    pushFollow(FOLLOW_type_in_start37);
            	    type1=type();
            	    _fsp--;

            	    adaptor.addChild(root_0, type1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


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
        return retval;
    }
    // $ANTLR end start

    public static class type_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start type
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:15:1: type : STRING ( ':' ( atom | list ) ) ( Card )? ;
    public final type_return type() throws RecognitionException {
        type_return retval = new type_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING2=null;
        Token char_literal3=null;
        Token Card6=null;
        atom_return atom4 = null;

        list_return list5 = null;


        CommonTree STRING2_tree=null;
        CommonTree char_literal3_tree=null;
        CommonTree Card6_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:15:7: ( STRING ( ':' ( atom | list ) ) ( Card )? )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:15:9: STRING ( ':' ( atom | list ) ) ( Card )?
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING2=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_type47); 
            STRING2_tree = (CommonTree)adaptor.create(STRING2);
            adaptor.addChild(root_0, STRING2_tree);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:15:16: ( ':' ( atom | list ) )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:15:17: ':' ( atom | list )
            {
            char_literal3=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_type50); 
            char_literal3_tree = (CommonTree)adaptor.create(char_literal3);
            adaptor.addChild(root_0, char_literal3_tree);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:15:20: ( atom | list )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Atom) ) {
                alt2=1;
            }
            else if ( (LA2_0==15) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("15:20: ( atom | list )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:15:21: atom
                    {
                    pushFollow(FOLLOW_atom_in_type52);
                    atom4=atom();
                    _fsp--;

                    adaptor.addChild(root_0, atom4.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:15:27: list
                    {
                    pushFollow(FOLLOW_list_in_type55);
                    list5=list();
                    _fsp--;

                    adaptor.addChild(root_0, list5.getTree());

                    }
                    break;

            }


            }

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:15:34: ( Card )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Card) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:15:34: Card
                    {
                    Card6=(Token)input.LT(1);
                    match(input,Card,FOLLOW_Card_in_type59); 
                    Card6_tree = (CommonTree)adaptor.create(Card6);
                    adaptor.addChild(root_0, Card6_tree);


                    }
                    break;

            }


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
        return retval;
    }
    // $ANTLR end type

    public static class ref_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start ref
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:17:1: ref : STRING ( Card )? ;
    public final ref_return ref() throws RecognitionException {
        ref_return retval = new ref_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING7=null;
        Token Card8=null;

        CommonTree STRING7_tree=null;
        CommonTree Card8_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:17:5: ( STRING ( Card )? )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:17:7: STRING ( Card )?
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING7=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_ref68); 
            STRING7_tree = (CommonTree)adaptor.create(STRING7);
            adaptor.addChild(root_0, STRING7_tree);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:17:14: ( Card )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==Card) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:17:14: Card
                    {
                    Card8=(Token)input.LT(1);
                    match(input,Card,FOLLOW_Card_in_ref70); 
                    Card8_tree = (CommonTree)adaptor.create(Card8);
                    adaptor.addChild(root_0, Card8_tree);


                    }
                    break;

            }


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
        return retval;
    }
    // $ANTLR end ref

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start atom
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:19:1: atom : Atom ( ( ':=' | '=' ) ( Def | FLOAT | BOOL ) )? ;
    public final atom_return atom() throws RecognitionException {
        atom_return retval = new atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Atom9=null;
        Token set10=null;
        Token set11=null;

        CommonTree Atom9_tree=null;
        CommonTree set10_tree=null;
        CommonTree set11_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:19:6: ( Atom ( ( ':=' | '=' ) ( Def | FLOAT | BOOL ) )? )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:19:8: Atom ( ( ':=' | '=' ) ( Def | FLOAT | BOOL ) )?
            {
            root_0 = (CommonTree)adaptor.nil();

            Atom9=(Token)input.LT(1);
            match(input,Atom,FOLLOW_Atom_in_atom79); 
            Atom9_tree = (CommonTree)adaptor.create(Atom9);
            adaptor.addChild(root_0, Atom9_tree);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:19:13: ( ( ':=' | '=' ) ( Def | FLOAT | BOOL ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0>=13 && LA5_0<=14)) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:19:14: ( ':=' | '=' ) ( Def | FLOAT | BOOL )
                    {
                    set10=(Token)input.LT(1);
                    if ( (input.LA(1)>=13 && input.LA(1)<=14) ) {
                        input.consume();
                        adaptor.addChild(root_0, adaptor.create(set10));
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_atom82);    throw mse;
                    }

                    set11=(Token)input.LT(1);
                    if ( (input.LA(1)>=Def && input.LA(1)<=BOOL) ) {
                        input.consume();
                        adaptor.addChild(root_0, adaptor.create(set11));
                        errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recoverFromMismatchedSet(input,mse,FOLLOW_set_in_atom88);    throw mse;
                    }


                    }
                    break;

            }


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
        return retval;
    }
    // $ANTLR end atom

    public static class list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start list
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:1: list : '(' ( type | ref ) ( ',' ( type | ref ) )* ')' ;
    public final list_return list() throws RecognitionException {
        list_return retval = new list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal12=null;
        Token char_literal15=null;
        Token char_literal18=null;
        type_return type13 = null;

        ref_return ref14 = null;

        type_return type16 = null;

        ref_return ref17 = null;


        CommonTree char_literal12_tree=null;
        CommonTree char_literal15_tree=null;
        CommonTree char_literal18_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:6: ( '(' ( type | ref ) ( ',' ( type | ref ) )* ')' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:8: '(' ( type | ref ) ( ',' ( type | ref ) )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal12=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_list104); 
            char_literal12_tree = (CommonTree)adaptor.create(char_literal12);
            adaptor.addChild(root_0, char_literal12_tree);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:12: ( type | ref )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==STRING) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==Card||(LA6_1>=16 && LA6_1<=17)) ) {
                    alt6=2;
                }
                else if ( (LA6_1==12) ) {
                    alt6=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("21:12: ( type | ref )", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("21:12: ( type | ref )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:13: type
                    {
                    pushFollow(FOLLOW_type_in_list107);
                    type13=type();
                    _fsp--;

                    adaptor.addChild(root_0, type13.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:18: ref
                    {
                    pushFollow(FOLLOW_ref_in_list109);
                    ref14=ref();
                    _fsp--;

                    adaptor.addChild(root_0, ref14.getTree());

                    }
                    break;

            }

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:23: ( ',' ( type | ref ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==16) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:24: ',' ( type | ref )
            	    {
            	    char_literal15=(Token)input.LT(1);
            	    match(input,16,FOLLOW_16_in_list113); 
            	    char_literal15_tree = (CommonTree)adaptor.create(char_literal15);
            	    adaptor.addChild(root_0, char_literal15_tree);

            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:28: ( type | ref )
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==STRING) ) {
            	        int LA7_1 = input.LA(2);

            	        if ( (LA7_1==12) ) {
            	            alt7=1;
            	        }
            	        else if ( (LA7_1==Card||(LA7_1>=16 && LA7_1<=17)) ) {
            	            alt7=2;
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("21:28: ( type | ref )", 7, 1, input);

            	            throw nvae;
            	        }
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("21:28: ( type | ref )", 7, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:29: type
            	            {
            	            pushFollow(FOLLOW_type_in_list116);
            	            type16=type();
            	            _fsp--;

            	            adaptor.addChild(root_0, type16.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:34: ref
            	            {
            	            pushFollow(FOLLOW_ref_in_list118);
            	            ref17=ref();
            	            _fsp--;

            	            adaptor.addChild(root_0, ref17.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            char_literal18=(Token)input.LT(1);
            match(input,17,FOLLOW_17_in_list123); 
            char_literal18_tree = (CommonTree)adaptor.create(char_literal18);
            adaptor.addChild(root_0, char_literal18_tree);


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
        return retval;
    }
    // $ANTLR end list


 

    public static final BitSet FOLLOW_type_in_start37 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_STRING_in_type47 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_type50 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_atom_in_type52 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_list_in_type55 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_Card_in_type59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_ref68 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_Card_in_ref70 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Atom_in_atom79 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_set_in_atom82 = new BitSet(new long[]{0x0000000000000380L});
    public static final BitSet FOLLOW_set_in_atom88 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_list104 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_type_in_list107 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_ref_in_list109 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_list113 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_type_in_list116 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_ref_in_list118 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_17_in_list123 = new BitSet(new long[]{0x0000000000000002L});

}