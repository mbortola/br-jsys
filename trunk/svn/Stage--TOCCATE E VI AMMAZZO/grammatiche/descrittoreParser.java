// $ANTLR 3.0.1 C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g 2008-06-24 11:42:19
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
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:24:1: start : ( base )+ ;
    public final start_return start() throws RecognitionException {
        start_return retval = new start_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        base_return base1 = null;



        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:24:7: ( ( base )+ )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:24:9: ( base )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:24:9: ( base )+
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
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:24:9: base
            	    {
            	    pushFollow(FOLLOW_base_in_start54);
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
        	catch (RecognitionException error) {
        			throw error;}    finally {
        }
        return retval;
    }
    // $ANTLR end start

    public static class base_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start base
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:26:1: base : STRING ':' ( list | '(' ( atom ) ( Card )? ')' ) ;
    public final base_return base() throws RecognitionException {
        base_return retval = new base_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING2=null;
        Token Card7=null;
        list_return list4 = null;

        atom_return atom6 = null;


        CommonTree STRING2_tree=null;
        CommonTree Card7_tree=null;
        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:26:6: ( STRING ':' ( list | '(' ( atom ) ( Card )? ')' ) )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:26:8: STRING ':' ( list | '(' ( atom ) ( Card )? ')' )
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING2=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_base63); 
            STRING2_tree = (CommonTree)adaptor.create(STRING2);
            root_0 = (CommonTree)adaptor.becomeRoot(STRING2_tree, root_0);

            match(input,12,FOLLOW_12_in_base66); 
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:26:20: ( list | '(' ( atom ) ( Card )? ')' )
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
                        new NoViableAltException("26:20: ( list | '(' ( atom ) ( Card )? ')' )", 3, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("26:20: ( list | '(' ( atom ) ( Card )? ')' )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:26:21: list
                    {
                    pushFollow(FOLLOW_list_in_base69);
                    list4=list();
                    _fsp--;

                    adaptor.addChild(root_0, list4.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:26:26: '(' ( atom ) ( Card )? ')'
                    {
                    match(input,13,FOLLOW_13_in_base71); 
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:26:31: ( atom )
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:26:32: atom
                    {
                    pushFollow(FOLLOW_atom_in_base75);
                    atom6=atom();
                    _fsp--;

                    adaptor.addChild(root_0, atom6.getTree());

                    }

                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:26:38: ( Card )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==Card) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:26:38: Card
                            {
                            Card7=(Token)input.LT(1);
                            match(input,Card,FOLLOW_Card_in_base78); 
                            Card7_tree = (CommonTree)adaptor.create(Card7);
                            adaptor.addChild(root_0, Card7_tree);


                            }
                            break;

                    }

                    match(input,14,FOLLOW_14_in_base81); 

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        	catch (RecognitionException error) {
        			throw error;}    finally {
        }
        return retval;
    }
    // $ANTLR end base

    public static class list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start list
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:28:1: list : '(' typedef ( ',' typedef )* ')' ;
    public final list_return list() throws RecognitionException {
        list_return retval = new list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        typedef_return typedef10 = null;

        typedef_return typedef12 = null;


        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:28:6: ( '(' typedef ( ',' typedef )* ')' )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:28:8: '(' typedef ( ',' typedef )* ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            match(input,13,FOLLOW_13_in_list91); 
            pushFollow(FOLLOW_typedef_in_list94);
            typedef10=typedef();
            _fsp--;

            adaptor.addChild(root_0, typedef10.getTree());
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:28:21: ( ',' typedef )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:28:22: ',' typedef
            	    {
            	    match(input,15,FOLLOW_15_in_list97); 
            	    pushFollow(FOLLOW_typedef_in_list100);
            	    typedef12=typedef();
            	    _fsp--;

            	    adaptor.addChild(root_0, typedef12.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_list104); 

            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        	catch (RecognitionException error) {
        			throw error;}    finally {
        }
        return retval;
    }
    // $ANTLR end list

    public static class typedef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start typedef
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:30:1: typedef : STRING ':' ( atom | ( list ) | STRING ) ( Card )? ;
    public final typedef_return typedef() throws RecognitionException {
        typedef_return retval = new typedef_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING14=null;
        Token STRING18=null;
        Token Card19=null;
        atom_return atom16 = null;

        list_return list17 = null;


        CommonTree STRING14_tree=null;
        CommonTree STRING18_tree=null;
        CommonTree Card19_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:30:9: ( STRING ':' ( atom | ( list ) | STRING ) ( Card )? )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:30:11: STRING ':' ( atom | ( list ) | STRING ) ( Card )?
            {
            root_0 = (CommonTree)adaptor.nil();

            STRING14=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_typedef113); 
            STRING14_tree = (CommonTree)adaptor.create(STRING14);
            root_0 = (CommonTree)adaptor.becomeRoot(STRING14_tree, root_0);

            match(input,12,FOLLOW_12_in_typedef116); 
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:30:24: ( atom | ( list ) | STRING )
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
                    new NoViableAltException("30:24: ( atom | ( list ) | STRING )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:30:25: atom
                    {
                    pushFollow(FOLLOW_atom_in_typedef120);
                    atom16=atom();
                    _fsp--;

                    adaptor.addChild(root_0, atom16.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:30:30: ( list )
                    {
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:30:30: ( list )
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:30:31: list
                    {
                    pushFollow(FOLLOW_list_in_typedef123);
                    list17=list();
                    _fsp--;

                    adaptor.addChild(root_0, list17.getTree());

                    }


                    }
                    break;
                case 3 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:30:37: STRING
                    {
                    STRING18=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_typedef126); 
                    STRING18_tree = (CommonTree)adaptor.create(STRING18);
                    adaptor.addChild(root_0, STRING18_tree);


                    }
                    break;

            }

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:30:44: ( Card )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Card) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:30:44: Card
                    {
                    Card19=(Token)input.LT(1);
                    match(input,Card,FOLLOW_Card_in_typedef128); 
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
        	catch (RecognitionException error) {
        			throw error;}    finally {
        }
        return retval;
    }
    // $ANTLR end typedef

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start atom
    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:32:1: atom : Atom ( ( ':=' | '=' ) Def )? ;
    public final atom_return atom() throws RecognitionException {
        atom_return retval = new atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Atom20=null;
        Token Def23=null;

        CommonTree Atom20_tree=null;
        CommonTree Def23_tree=null;

        try {
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:32:6: ( Atom ( ( ':=' | '=' ) Def )? )
            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:32:8: Atom ( ( ':=' | '=' ) Def )?
            {
            root_0 = (CommonTree)adaptor.nil();

            Atom20=(Token)input.LT(1);
            match(input,Atom,FOLLOW_Atom_in_atom137); 
            Atom20_tree = (CommonTree)adaptor.create(Atom20);
            adaptor.addChild(root_0, Atom20_tree);

            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:32:13: ( ( ':=' | '=' ) Def )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=16 && LA8_0<=17)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:32:14: ( ':=' | '=' ) Def
                    {
                    // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:32:14: ( ':=' | '=' )
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
                            new NoViableAltException("32:14: ( ':=' | '=' )", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:32:15: ':='
                            {
                            match(input,16,FOLLOW_16_in_atom141); 

                            }
                            break;
                        case 2 :
                            // C:\\Documents and Settings\\Administrator\\Desktop\\Stage\\br-jsys\\svn\\Stage--TOCCATE E VI AMMAZZO\\descrittore.g:32:21: '='
                            {
                            match(input,17,FOLLOW_17_in_atom144); 

                            }
                            break;

                    }

                    Def23=(Token)input.LT(1);
                    match(input,Def,FOLLOW_Def_in_atom147); 
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
        	catch (RecognitionException error) {
        			throw error;}    finally {
        }
        return retval;
    }
    // $ANTLR end atom


 

    public static final BitSet FOLLOW_base_in_start54 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_STRING_in_base63 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_base66 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_list_in_base69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_base71 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_atom_in_base75 = new BitSet(new long[]{0x0000000000004020L});
    public static final BitSet FOLLOW_Card_in_base78 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_base81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_list91 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_typedef_in_list94 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_list97 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_typedef_in_list100 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_list104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_typedef113 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_typedef116 = new BitSet(new long[]{0x0000000000002050L});
    public static final BitSet FOLLOW_atom_in_typedef120 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_list_in_typedef123 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_STRING_in_typedef126 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_Card_in_typedef128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Atom_in_atom137 = new BitSet(new long[]{0x0000000000030002L});
    public static final BitSet FOLLOW_16_in_atom141 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_17_in_atom144 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Def_in_atom147 = new BitSet(new long[]{0x0000000000000002L});

}