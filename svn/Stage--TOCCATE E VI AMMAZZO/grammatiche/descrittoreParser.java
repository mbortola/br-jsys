// $ANTLR 3.0.1 C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g 2008-07-08 17:28:36
package grammatiche;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.EarlyExitException;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "STRING", "Card", "Atom", "Def", "FLOAT", "BOOL", "CHAR", "WHITESPACE", "':'", "'('", "')'", "','", "':='", "'='"
    };
    public static final int BOOL=9;
    public static final int CHAR=10;
    public static final int WHITESPACE=11;
    public static final int FLOAT=8;
    public static final int Atom=6;
    public static final int EOF=-1;
    public static final int Def=7;
    public static final int STRING=4;
    public static final int Card=5;

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
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:1: start : ( base )+ ;
    public final start_return start() throws RecognitionException {
        start_return retval = new start_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        base_return base1 = null;



        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:7: ( ( base )+ )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:9: ( base )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:9: ( base )+
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
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:21:9: base
            	    {
            	    pushFollow(FOLLOW_base_in_start52);
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
        catch (RecognitionException error) {throw error;}    finally {
        }
        return retval;
    }
    // $ANTLR end start

    public static class base_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start base
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:1: base : STRING ':' ( list | '(' ( atom ) ( Card )? ')' ) ;
    public final base_return base() throws RecognitionException {
        base_return retval = new base_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING2=null;
        Token char_literal3=null;
        Token char_literal5=null;
        Token Card7=null;
        Token char_literal8=null;
        list_return list4 = null;

        atom_return atom6 = null;


        CommonTree STRING2_tree=null;
        CommonTree char_literal3_tree=null;
        CommonTree char_literal5_tree=null;
        CommonTree Card7_tree=null;
        CommonTree char_literal8_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:6: ( STRING ':' ( list | '(' ( atom ) ( Card )? ')' ) )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:8: STRING ':' ( list | '(' ( atom ) ( Card )? ')' )
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING2=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_base61); 
            STRING2_tree = (CommonTree)adaptor.create(STRING2);
            root_0 = (CommonTree)adaptor.becomeRoot(STRING2_tree, root_0);

            char_literal3=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_base64); 
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:20: ( list | '(' ( atom ) ( Card )? ')' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==Atom) ) {
                    alt3=2;
                }
                else if ( (LA3_1==STRING) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("23:20: ( list | '(' ( atom ) ( Card )? ')' )", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("23:20: ( list | '(' ( atom ) ( Card )? ')' )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:21: list
                    {
                    pushFollow(FOLLOW_list_in_base67);
                    list4=list();
                    _fsp--;

                    adaptor.addChild(root_0, list4.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:26: '(' ( atom ) ( Card )? ')'
                    {
                    char_literal5=(Token)input.LT(1);
                    match(input,13,FOLLOW_13_in_base69); 
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:31: ( atom )
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:32: atom
                    {
                    pushFollow(FOLLOW_atom_in_base73);
                    atom6=atom();
                    _fsp--;

                    adaptor.addChild(root_0, atom6.getTree());

                    }

                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:38: ( Card )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==Card) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:23:38: Card
                            {
                            Card7=(Token)input.LT(1);
                            match(input,Card,FOLLOW_Card_in_base76); 
                            Card7_tree = (CommonTree)adaptor.create(Card7);
                            adaptor.addChild(root_0, Card7_tree);


                            }
                            break;

                    }

                    char_literal8=(Token)input.LT(1);
                    match(input,14,FOLLOW_14_in_base79); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {throw error;}    finally {
        }
        return retval;
    }
    // $ANTLR end base

    public static class list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start list
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:25:1: list : '(' typedef ( ',' typedef )* ')' ;
    public final list_return list() throws RecognitionException {
        list_return retval = new list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal9=null;
        Token char_literal11=null;
        Token char_literal13=null;
        typedef_return typedef10 = null;

        typedef_return typedef12 = null;


        CommonTree char_literal9_tree=null;
        CommonTree char_literal11_tree=null;
        CommonTree char_literal13_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:25:6: ( '(' typedef ( ',' typedef )* ')' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:25:8: '(' typedef ( ',' typedef )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal9=(Token)input.LT(1);
            match(input,13,FOLLOW_13_in_list89); 
            pushFollow(FOLLOW_typedef_in_list92);
            typedef10=typedef();
            _fsp--;

            adaptor.addChild(root_0, typedef10.getTree());
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:25:21: ( ',' typedef )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:25:22: ',' typedef
            	    {
            	    char_literal11=(Token)input.LT(1);
            	    match(input,15,FOLLOW_15_in_list95); 
            	    pushFollow(FOLLOW_typedef_in_list98);
            	    typedef12=typedef();
            	    _fsp--;

            	    adaptor.addChild(root_0, typedef12.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            char_literal13=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_list102); 

            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {throw error;}    finally {
        }
        return retval;
    }
    // $ANTLR end list

    public static class typedef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start typedef
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:27:1: typedef : STRING ':' ( atom | ( list ) | STRING ) ( Card )? ;
    public final typedef_return typedef() throws RecognitionException {
        typedef_return retval = new typedef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING14=null;
        Token char_literal15=null;
        Token STRING18=null;
        Token Card19=null;
        atom_return atom16 = null;

        list_return list17 = null;


        CommonTree STRING14_tree=null;
        CommonTree char_literal15_tree=null;
        CommonTree STRING18_tree=null;
        CommonTree Card19_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:27:9: ( STRING ':' ( atom | ( list ) | STRING ) ( Card )? )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:27:11: STRING ':' ( atom | ( list ) | STRING ) ( Card )?
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING14=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_typedef111); 
            STRING14_tree = (CommonTree)adaptor.create(STRING14);
            root_0 = (CommonTree)adaptor.becomeRoot(STRING14_tree, root_0);

            char_literal15=(Token)input.LT(1);
            match(input,12,FOLLOW_12_in_typedef114); 
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:27:24: ( atom | ( list ) | STRING )
            int alt5=3;
            switch ( input.LA(1) ) {
            case Atom:
                {
                alt5=1;
                }
                break;
            case 13:
                {
                alt5=2;
                }
                break;
            case STRING:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("27:24: ( atom | ( list ) | STRING )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:27:25: atom
                    {
                    pushFollow(FOLLOW_atom_in_typedef118);
                    atom16=atom();
                    _fsp--;

                    adaptor.addChild(root_0, atom16.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:27:30: ( list )
                    {
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:27:30: ( list )
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:27:31: list
                    {
                    pushFollow(FOLLOW_list_in_typedef121);
                    list17=list();
                    _fsp--;

                    adaptor.addChild(root_0, list17.getTree());

                    }


                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:27:37: STRING
                    {
                    STRING18=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_typedef124); 
                    STRING18_tree = (CommonTree)adaptor.create(STRING18);
                    adaptor.addChild(root_0, STRING18_tree);


                    }
                    break;

            }

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:27:44: ( Card )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Card) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:27:44: Card
                    {
                    Card19=(Token)input.LT(1);
                    match(input,Card,FOLLOW_Card_in_typedef126); 
                    Card19_tree = (CommonTree)adaptor.create(Card19);
                    adaptor.addChild(root_0, Card19_tree);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {throw error;}    finally {
        }
        return retval;
    }
    // $ANTLR end typedef

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start atom
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:1: atom : Atom ( ( ':=' | '=' ) Def )? ;
    public final atom_return atom() throws RecognitionException {
        atom_return retval = new atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Atom20=null;
        Token string_literal21=null;
        Token char_literal22=null;
        Token Def23=null;

        CommonTree Atom20_tree=null;
        CommonTree string_literal21_tree=null;
        CommonTree char_literal22_tree=null;
        CommonTree Def23_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:6: ( Atom ( ( ':=' | '=' ) Def )? )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:8: Atom ( ( ':=' | '=' ) Def )?
            {
            root_0 = (CommonTree)adaptor.nil();

            Atom20=(Token)input.LT(1);
            match(input,Atom,FOLLOW_Atom_in_atom135); 
            Atom20_tree = (CommonTree)adaptor.create(Atom20);
            adaptor.addChild(root_0, Atom20_tree);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:13: ( ( ':=' | '=' ) Def )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=16 && LA8_0<=17)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:14: ( ':=' | '=' ) Def
                    {
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:14: ( ':=' | '=' )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==16) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==17) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("29:14: ( ':=' | '=' )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:15: ':='
                            {
                            string_literal21=(Token)input.LT(1);
                            match(input,16,FOLLOW_16_in_atom139); 

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:29:21: '='
                            {
                            char_literal22=(Token)input.LT(1);
                            match(input,17,FOLLOW_17_in_atom142); 

                            }
                            break;

                    }

                    Def23=(Token)input.LT(1);
                    match(input,Def,FOLLOW_Def_in_atom145); 
                    Def23_tree = (CommonTree)adaptor.create(Def23);
                    adaptor.addChild(root_0, Def23_tree);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {throw error;}    finally {
        }
        return retval;
    }
    // $ANTLR end atom


 

    public static final BitSet FOLLOW_base_in_start52 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_STRING_in_base61 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_base64 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_list_in_base67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_base69 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_atom_in_base73 = new BitSet(new long[]{0x0000000000004020L});
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