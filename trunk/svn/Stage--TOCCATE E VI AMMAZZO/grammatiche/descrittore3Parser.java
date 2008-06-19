// $ANTLR 3.0.1 C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g 2008-06-19 12:43:10
package grammatiche;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class descrittore3Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING", "Card", "Atom", "Def", "FLOAT", "BOOL", "CHAR", "WHITESPACE", "':'", "'('", "')'", "','", "':='", "'='"
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

        public descrittore3Parser(TokenStream input) {
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
    public String getGrammarFileName() { return "C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g"; }


    public static class start_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start start
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:22:1: start : ( base )+ ;
    public final start_return start() throws RecognitionException {
        start_return retval = new start_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        base_return base1 = null;



        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:22:7: ( ( base )+ )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:22:9: ( base )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:22:9: ( base )+
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
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:22:9: base
            	    {
            	    pushFollow(FOLLOW_base_in_start50);
            	    base1=base();
            	    _fsp--;

            	    adaptor.addChild(root_0, base1.getTree());

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

    public static class base_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start base
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:24:1: base : STRING ':' ( list | '(' ( atom | STRING ) ( Card )? ')' ) ;
    public final base_return base() throws RecognitionException {
        base_return retval = new base_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING2=null;
        Token char_literal3=null;
        Token char_literal5=null;
        Token STRING7=null;
        Token Card8=null;
        Token char_literal9=null;
        list_return list4 = null;

        atom_return atom6 = null;


        CommonTree STRING2_tree=null;
        CommonTree char_literal3_tree=null;
        CommonTree char_literal5_tree=null;
        CommonTree STRING7_tree=null;
        CommonTree Card8_tree=null;
        CommonTree char_literal9_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:24:6: ( STRING ':' ( list | '(' ( atom | STRING ) ( Card )? ')' ) )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:24:8: STRING ':' ( list | '(' ( atom | STRING ) ( Card )? ')' )
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING2=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_base59); 
            STRING2_tree = (CommonTree)adaptor.create(STRING2);
            root_0 = (CommonTree)adaptor.becomeRoot(STRING2_tree, root_0);

            char_literal3=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_base62); 
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:24:20: ( list | '(' ( atom | STRING ) ( Card )? ')' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==STRING) ) {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2==12) ) {
                        alt4=1;
                    }
                    else if ( (LA4_2==Card||LA4_2==14) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("24:20: ( list | '(' ( atom | STRING ) ( Card )? ')' )", 4, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA4_1==Atom) ) {
                    alt4=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("24:20: ( list | '(' ( atom | STRING ) ( Card )? ')' )", 4, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("24:20: ( list | '(' ( atom | STRING ) ( Card )? ')' )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:24:21: list
                    {
                    pushFollow(FOLLOW_list_in_base65);
                    list4=list();
                    _fsp--;

                    adaptor.addChild(root_0, list4.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:24:26: '(' ( atom | STRING ) ( Card )? ')'
                    {
                    char_literal5=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_base67); 
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:24:31: ( atom | STRING )
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==Atom) ) {
                        alt2=1;
                    }
                    else if ( (LA2_0==STRING) ) {
                        alt2=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("24:31: ( atom | STRING )", 2, 0, input);

                        throw nvae;
                    }
                    switch (alt2) {
                        case 1 :
                            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:24:32: atom
                            {
                            pushFollow(FOLLOW_atom_in_base71);
                            atom6=atom();
                            _fsp--;

                            adaptor.addChild(root_0, atom6.getTree());

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:24:37: STRING
                            {
                            STRING7=(Token)input.LT(1);
                            match(input,STRING,FOLLOW_STRING_in_base73); 
                            STRING7_tree = (CommonTree)adaptor.create(STRING7);
                            adaptor.addChild(root_0, STRING7_tree);


                            }
                            break;

                    }

                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:24:45: ( Card )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==Card) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:24:45: Card
                            {
                            Card8=(Token)input.LT(1);
                            match(input,Card,FOLLOW_Card_in_base76); 
                            Card8_tree = (CommonTree)adaptor.create(Card8);
                            adaptor.addChild(root_0, Card8_tree);


                            }
                            break;

                    }

                    char_literal9=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_base79); 

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
    // $ANTLR end base

    public static class list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start list
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:26:1: list : '(' typedef ( ',' typedef )* ')' ;
    public final list_return list() throws RecognitionException {
        list_return retval = new list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal10=null;
        Token char_literal12=null;
        Token char_literal14=null;
        typedef_return typedef11 = null;

        typedef_return typedef13 = null;


        CommonTree char_literal10_tree=null;
        CommonTree char_literal12_tree=null;
        CommonTree char_literal14_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:26:6: ( '(' typedef ( ',' typedef )* ')' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:26:8: '(' typedef ( ',' typedef )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal10=(Token)input.LT(1);
            match(input,13,FOLLOW_13_in_list89); 
            pushFollow(FOLLOW_typedef_in_list92);
            typedef11=typedef();
            _fsp--;

            adaptor.addChild(root_0, typedef11.getTree());
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:26:21: ( ',' typedef )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:26:22: ',' typedef
            	    {
            	    char_literal12=(Token)input.LT(1);
            	    match(input,15,FOLLOW_15_in_list95); 
            	    pushFollow(FOLLOW_typedef_in_list98);
            	    typedef13=typedef();
            	    _fsp--;

            	    adaptor.addChild(root_0, typedef13.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            char_literal14=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_list102); 

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

    public static class typedef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start typedef
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:28:1: typedef : STRING ':' ( atom | ( list ) | STRING ) ( Card )? ;
    public final typedef_return typedef() throws RecognitionException {
        typedef_return retval = new typedef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING15=null;
        Token char_literal16=null;
        Token STRING19=null;
        Token Card20=null;
        atom_return atom17 = null;

        list_return list18 = null;


        CommonTree STRING15_tree=null;
        CommonTree char_literal16_tree=null;
        CommonTree STRING19_tree=null;
        CommonTree Card20_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:28:9: ( STRING ':' ( atom | ( list ) | STRING ) ( Card )? )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:28:11: STRING ':' ( atom | ( list ) | STRING ) ( Card )?
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING15=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_typedef111); 
            STRING15_tree = (CommonTree)adaptor.create(STRING15);
            root_0 = (CommonTree)adaptor.becomeRoot(STRING15_tree, root_0);

            char_literal16=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_typedef114); 
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:28:24: ( atom | ( list ) | STRING )
            int alt6=3;
            switch ( input.LA(1) ) {
            case Atom:
                {
                alt6=1;
                }
                break;
            case 13:
                {
                alt6=2;
                }
                break;
            case STRING:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("28:24: ( atom | ( list ) | STRING )", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:28:25: atom
                    {
                    pushFollow(FOLLOW_atom_in_typedef118);
                    atom17=atom();
                    _fsp--;

                    adaptor.addChild(root_0, atom17.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:28:30: ( list )
                    {
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:28:30: ( list )
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:28:31: list
                    {
                    pushFollow(FOLLOW_list_in_typedef121);
                    list18=list();
                    _fsp--;

                    adaptor.addChild(root_0, list18.getTree());

                    }


                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:28:37: STRING
                    {
                    STRING19=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_typedef124); 
                    STRING19_tree = (CommonTree)adaptor.create(STRING19);
                    adaptor.addChild(root_0, STRING19_tree);


                    }
                    break;

            }

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:28:44: ( Card )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Card) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:28:44: Card
                    {
                    Card20=(Token)input.LT(1);
                    match(input,Card,FOLLOW_Card_in_typedef126); 
                    Card20_tree = (CommonTree)adaptor.create(Card20);
                    adaptor.addChild(root_0, Card20_tree);


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
    // $ANTLR end typedef

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start atom
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:30:1: atom : Atom ( ( ':=' | '=' ) Def )? ;
    public final atom_return atom() throws RecognitionException {
        atom_return retval = new atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Atom21=null;
        Token string_literal22=null;
        Token char_literal23=null;
        Token Def24=null;

        CommonTree Atom21_tree=null;
        CommonTree string_literal22_tree=null;
        CommonTree char_literal23_tree=null;
        CommonTree Def24_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:30:6: ( Atom ( ( ':=' | '=' ) Def )? )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:30:8: Atom ( ( ':=' | '=' ) Def )?
            {
            root_0 = (CommonTree)adaptor.nil();

            Atom21=(Token)input.LT(1);
            match(input,Atom,FOLLOW_Atom_in_atom135); 
            Atom21_tree = (CommonTree)adaptor.create(Atom21);
            adaptor.addChild(root_0, Atom21_tree);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:30:13: ( ( ':=' | '=' ) Def )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=16 && LA9_0<=17)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:30:14: ( ':=' | '=' ) Def
                    {
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:30:14: ( ':=' | '=' )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==16) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==17) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("30:14: ( ':=' | '=' )", 8, 0, input);

                        throw nvae;
                    }
                    switch (alt8) {
                        case 1 :
                            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:30:15: ':='
                            {
                            string_literal22=(Token)input.LT(1);
                            match(input,16,FOLLOW_16_in_atom139); 

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore3.g:30:21: '='
                            {
                            char_literal23=(Token)input.LT(1);
                            match(input,17,FOLLOW_17_in_atom142); 

                            }
                            break;

                    }

                    Def24=(Token)input.LT(1);
                    match(input,Def,FOLLOW_Def_in_atom145); 
                    Def24_tree = (CommonTree)adaptor.create(Def24);
                    adaptor.addChild(root_0, Def24_tree);


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


 

    public static final BitSet FOLLOW_base_in_start50 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_STRING_in_base59 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_base62 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_list_in_base65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_base67 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_atom_in_base71 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_STRING_in_base73 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_Card_in_base76 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_base79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_list89 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_typedef_in_list92 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_list95 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_typedef_in_list98 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_list102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_typedef111 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_typedef114 = new BitSet(new long[]{0x0000000000002050L});
    public static final BitSet FOLLOW_atom_in_typedef118 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_list_in_typedef121 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_STRING_in_typedef124 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_Card_in_typedef126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Atom_in_atom135 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_16_in_atom139 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_17_in_atom142 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Def_in_atom145 = new BitSet(new long[]{0x0000000000000002L});

}