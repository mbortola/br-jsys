// $ANTLR 3.0.1 /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g 2008-02-25 09:25:55
package brjsys.validator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;

import org.antlr.runtime.tree.*;

public class BusinessRuleParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "OpRule", "Conf", "Bconf", "Msg", "STRING", "OpA", "OpM", "OpBool", "FIELD", "FLOAT", "BOOL", "BoFun", "FlFun", "Count", "CHAR", "SUBFIELD", "WHITESPACE", "'('", "')'"
    };
    public static final int Count=17;
    public static final int OpRule=4;
    public static final int BOOL=14;
    public static final int CHAR=18;
    public static final int WHITESPACE=20;
    public static final int Conf=5;
    public static final int FLOAT=13;
    public static final int EOF=-1;
    public static final int OpBool=11;
    public static final int Msg=7;
    public static final int Bconf=6;
    public static final int SUBFIELD=19;
    public static final int FlFun=16;
    public static final int FIELD=12;
    public static final int OpM=10;
    public static final int BoFun=15;
    public static final int OpA=9;
    public static final int STRING=8;
    public static final String[] ruleNames = new String[] {
        "invalidRule", "start", "rule", "conf", "message", "exp", "opA", 
        "opB", "atom", "fun"
    };

    public int ruleLevel = 0;
    public BusinessRuleParser(TokenStream input, int port) {
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
    public BusinessRuleParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT);
    }
    public BusinessRuleParser(TokenStream input, DebugEventListener dbg) {
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
    public String getGrammarFileName() { return "/home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g"; }


    	static private String env="brjsys.businessObjects.Articolo";

    	protected void mismatch(IntStream input, int ttype, BitSet follow)throws RecognitionException{
    	    throw new MismatchedTokenException(ttype, input);
    	}
    	public void recoverFromMismatchedSet(IntStream input,RecognitionException e,BitSet follow)throws RecognitionException{
    		throw e;
    	}
    	public static Class<?> getType(String nome,String ambiente){try{
    		System.out.println(nome+' '+ambiente);
    		int index=nome.indexOf(".");
    		if(index==-1){
    			//ho un solo campo
    			return Class.forName(ambiente).getDeclaredField(nome).getType();
    		}
    		//ho piu' campi, li separo
    		String testa=nome.substring(0,index);
    		String coda=nome.substring(index+1);
    		//trovo il tipo di testa, che diventera' il nuovo ambiente
    		Class tipotesta=Class.forName(ambiente).getDeclaredField(testa).getType();
    		return getType(coda,tipotesta.getCanonicalName());
    	}catch(Exception e){e.printStackTrace();System.err.println("Exception");}
    	return null; 
    	};
    	private static Class<?> type(String nome){
    		try{
    			Class<?> cl=Class.forName(nome);
    			return cl;
    		}catch(ClassNotFoundException e){
    			System.err.println("ClassNotFound");			
    		}
    		return null;
    	}
    	private static int getDimension(Class<?> input){
    		//mi dice la "dimensione" di input
    		String inputString=input.getCanonicalName();
    		int index=inputString.indexOf("[");
    		return (index==-1?0:(inputString.length()-index)/2);
    	}
    	public static Class<?> compare(Class<?> input,Class<?> confronto,boolean reduce)throws TypeCollisionException{
    		System.out.println("COMPILE:"+input.getCanonicalName()+'-'+confronto.getCanonicalName());
    		if(getBasicType(input)==getBasicType(confronto)){//se no neanche faccio il test
    			if(input.equals(confronto))return input;//stesso identico tipo
    			//uno dei due e' una matrice
    			if(getDimension(confronto)==0){
    				return (reduce?input.getComponentType():input);
    			}if(getDimension(input)==0){
    				return (reduce?confronto.getComponentType():confronto);
    			}//tutte e due matrici di dimensioni diverse
    		}
    		throw new RecognitionException();
    	}
    	private static Class<?> getBasicType(Class<?> input){
    		//dato un oggetto Class ritorno il tipo base ossia:
    		//input->Float ritorna Float
    		//input->Float[][][] ritorna Float
    		String inputString=input.getCanonicalName();
    		int index=inputString.indexOf("[");
    		if(index==-1)return input;
    		else return type(inputString.substring(0,index));
    	}
    	


    public static class start_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start start
    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:80:1: start : rule ( OpRule rule )* ;
    public final start_return start() throws RecognitionException {
        start_return retval = new start_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OpRule2=null;
        rule_return rule1 = null;

        rule_return rule3 = null;


        CommonTree OpRule2_tree=null;

        try { dbg.enterRule("start");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(80, 1);

        try {
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:80:7: ( rule ( OpRule rule )* )
            dbg.enterAlt(1);

            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:81:2: rule ( OpRule rule )*
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(81,2);
            pushFollow(FOLLOW_rule_in_start51);
            rule1=rule();
            _fsp--;

            adaptor.addChild(root_0, rule1.getTree());
            dbg.location(82,2);
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:82:2: ( OpRule rule )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1);

                int LA1_0 = input.LA(1);

                if ( (LA1_0==OpRule) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:82:3: OpRule rule
            	    {
            	    dbg.location(82,9);
            	    OpRule2=(Token)input.LT(1);
            	    match(input,OpRule,FOLLOW_OpRule_in_start55); 
            	    OpRule2_tree = (CommonTree)adaptor.create(OpRule2);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OpRule2_tree, root_0);

            	    dbg.location(82,11);
            	    pushFollow(FOLLOW_rule_in_start58);
            	    rule3=rule();
            	    _fsp--;

            	    adaptor.addChild(root_0, rule3.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {throw error;}    finally {
        }
        dbg.location(84, 2);

        }
        finally {
            dbg.exitRule("start");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end start

    public static class rule_return extends ParserRuleReturnScope {
        public Class value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start rule
    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:86:1: rule returns [Class value] : e= exp ( conf e2= exp ) ( message )? -> ^( conf $e $e2 ( message )? ) ;
    public final rule_return rule() throws RecognitionException {
        rule_return retval = new rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        exp_return e = null;

        exp_return e2 = null;

        conf_return conf4 = null;

        message_return message5 = null;


        RewriteRuleSubtreeStream stream_message=new RewriteRuleSubtreeStream(adaptor,"rule message");
        RewriteRuleSubtreeStream stream_exp=new RewriteRuleSubtreeStream(adaptor,"rule exp");
        RewriteRuleSubtreeStream stream_conf=new RewriteRuleSubtreeStream(adaptor,"rule conf");
        try { dbg.enterRule("rule");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(86, 1);

        try {
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:86:26: (e= exp ( conf e2= exp ) ( message )? -> ^( conf $e $e2 ( message )? ) )
            dbg.enterAlt(1);

            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:87:2: e= exp ( conf e2= exp ) ( message )?
            {
            dbg.location(87,3);
            pushFollow(FOLLOW_exp_in_rule77);
            e=exp();
            _fsp--;

            stream_exp.add(e.getTree());
            dbg.location(88,2);
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:88:2: ( conf e2= exp )
            dbg.enterAlt(1);

            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:88:3: conf e2= exp
            {
            dbg.location(88,3);
            pushFollow(FOLLOW_conf_in_rule82);
            conf4=conf();
            _fsp--;

            stream_conf.add(conf4.getTree());
            dbg.location(88,10);
            pushFollow(FOLLOW_exp_in_rule86);
            e2=exp();
            _fsp--;

            stream_exp.add(e2.getTree());
            dbg.location(88,17);
            if(!input.toString(conf4.start,conf4.stop).equals("=") && !input.toString(conf4.start,conf4.stop).equals("!=")){//devono essere Float
            				retval.value =compare(e.value,compare(e2.value,new Float(0).getClass(),false),false);
            			}else {retval.value =compare(e.value,e2.value,false);}

            }

            dbg.location(91,3);
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:91:3: ( message )?
            int alt2=2;
            try { dbg.enterSubRule(2);
            try { dbg.enterDecision(2);

            int LA2_0 = input.LA(1);

            if ( (LA2_0==Msg) ) {
                alt2=1;
            }
            } finally {dbg.exitDecision(2);}

            switch (alt2) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:91:3: message
                    {
                    dbg.location(91,3);
                    pushFollow(FOLLOW_message_in_rule94);
                    message5=message();
                    _fsp--;

                    stream_message.add(message5.getTree());

                    }
                    break;

            }
            } finally {dbg.exitSubRule(2);}

            dbg.location(91,12);

            // AST REWRITE
            // elements: e2, e, conf, message
            // token labels: 
            // rule labels: retval, e, e2
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"token e",e!=null?e.tree:null);
            RewriteRuleSubtreeStream stream_e2=new RewriteRuleSubtreeStream(adaptor,"token e2",e2!=null?e2.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 91:12: -> ^( conf $e $e2 ( message )? )
            {
                dbg.location(91,14);
                // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:91:14: ^( conf $e $e2 ( message )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(91,16);
                root_1 = (CommonTree)adaptor.becomeRoot(stream_conf.nextNode(), root_1);

                dbg.location(91,21);
                adaptor.addChild(root_1, stream_e.next());
                dbg.location(91,24);
                adaptor.addChild(root_1, stream_e2.next());
                dbg.location(91,28);
                // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:91:28: ( message )?
                if ( stream_message.hasNext() ) {
                    dbg.location(91,28);
                    adaptor.addChild(root_1, stream_message.next());

                }
                stream_message.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {throw error;}    finally {
        }
        dbg.location(92, 2);

        }
        finally {
            dbg.exitRule("rule");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end rule

    public static class conf_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start conf
    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:94:1: conf : ( Conf | Bconf );
    public final conf_return conf() throws RecognitionException {
        conf_return retval = new conf_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set6=null;

        CommonTree set6_tree=null;

        try { dbg.enterRule("conf");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(94, 1);

        try {
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:94:6: ( Conf | Bconf )
            dbg.enterAlt(1);

            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(94,6);
            set6=(Token)input.LT(1);
            if ( (input.LA(1)>=Conf && input.LA(1)<=Bconf) ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set6));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_conf0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {throw error;}    finally {
        }
        dbg.location(94, 18);

        }
        finally {
            dbg.exitRule("conf");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end conf

    public static class message_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start message
    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:96:1: message : Msg '(' STRING ')' ;
    public final message_return message() throws RecognitionException {
        message_return retval = new message_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Msg7=null;
        Token char_literal8=null;
        Token STRING9=null;
        Token char_literal10=null;

        CommonTree Msg7_tree=null;
        CommonTree char_literal8_tree=null;
        CommonTree STRING9_tree=null;
        CommonTree char_literal10_tree=null;

        try { dbg.enterRule("message");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(96, 1);

        try {
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:96:9: ( Msg '(' STRING ')' )
            dbg.enterAlt(1);

            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:96:11: Msg '(' STRING ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(96,14);
            Msg7=(Token)input.LT(1);
            match(input,Msg,FOLLOW_Msg_in_message129); 
            Msg7_tree = (CommonTree)adaptor.create(Msg7);
            root_0 = (CommonTree)adaptor.becomeRoot(Msg7_tree, root_0);

            dbg.location(96,18);
            char_literal8=(Token)input.LT(1);
            match(input,21,FOLLOW_21_in_message131); 
            dbg.location(96,19);
            STRING9=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_message133); 
            STRING9_tree = (CommonTree)adaptor.create(STRING9);
            adaptor.addChild(root_0, STRING9_tree);

            dbg.location(96,28);
            char_literal10=(Token)input.LT(1);
            match(input,22,FOLLOW_22_in_message134); 

            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {throw error;}    finally {
        }
        dbg.location(96, 30);

        }
        finally {
            dbg.exitRule("message");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end message

    public static class exp_return extends ParserRuleReturnScope {
        public Class value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start exp
    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:98:1: exp returns [Class value] : e= opA ( OpA e= opA )* ;
    public final exp_return exp() throws RecognitionException {
        exp_return retval = new exp_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OpA11=null;
        opA_return e = null;


        CommonTree OpA11_tree=null;

        try { dbg.enterRule("exp");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(98, 1);

        try {
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:98:27: (e= opA ( OpA e= opA )* )
            dbg.enterAlt(1);

            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:99:2: e= opA ( OpA e= opA )*
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(99,3);
            pushFollow(FOLLOW_opA_in_exp151);
            e=opA();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            dbg.location(99,10);
            retval.value =e.value;
            dbg.location(100,2);
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:100:2: ( OpA e= opA )*
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==OpA) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:100:3: OpA e= opA
            	    {
            	    dbg.location(100,6);
            	    OpA11=(Token)input.LT(1);
            	    match(input,OpA,FOLLOW_OpA_in_exp159); 
            	    OpA11_tree = (CommonTree)adaptor.create(OpA11);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OpA11_tree, root_0);

            	    dbg.location(100,9);
            	    pushFollow(FOLLOW_opA_in_exp164);
            	    e=opA();
            	    _fsp--;

            	    adaptor.addChild(root_0, e.getTree());
            	    dbg.location(100,14);
            	    retval.value =compare(e.value,compare(retval.value,new Float(0).getClass(),false),false);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);
            } finally {dbg.exitSubRule(3);}


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {throw error;}    finally {
        }
        dbg.location(101, 4);

        }
        finally {
            dbg.exitRule("exp");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end exp

    public static class opA_return extends ParserRuleReturnScope {
        public Class value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start opA
    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:104:1: opA returns [Class value] : e= opB ( OpM e= opB )* ;
    public final opA_return opA() throws RecognitionException {
        opA_return retval = new opA_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OpM12=null;
        opB_return e = null;


        CommonTree OpM12_tree=null;

        try { dbg.enterRule("opA");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(104, 1);

        try {
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:104:25: (e= opB ( OpM e= opB )* )
            dbg.enterAlt(1);

            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:105:2: e= opB ( OpM e= opB )*
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(105,3);
            pushFollow(FOLLOW_opB_in_opA184);
            e=opB();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            dbg.location(105,9);
            retval.value =e.value;
            dbg.location(106,2);
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:106:2: ( OpM e= opB )*
            try { dbg.enterSubRule(4);

            loop4:
            do {
                int alt4=2;
                try { dbg.enterDecision(4);

                int LA4_0 = input.LA(1);

                if ( (LA4_0==OpM) ) {
                    alt4=1;
                }


                } finally {dbg.exitDecision(4);}

                switch (alt4) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:106:3: OpM e= opB
            	    {
            	    dbg.location(106,6);
            	    OpM12=(Token)input.LT(1);
            	    match(input,OpM,FOLLOW_OpM_in_opA191); 
            	    OpM12_tree = (CommonTree)adaptor.create(OpM12);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OpM12_tree, root_0);

            	    dbg.location(106,9);
            	    pushFollow(FOLLOW_opB_in_opA196);
            	    e=opB();
            	    _fsp--;

            	    adaptor.addChild(root_0, e.getTree());
            	    dbg.location(106,14);
            	    retval.value =compare(e.value,compare(retval.value,new Float(0).getClass(),false),false);

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);
            } finally {dbg.exitSubRule(4);}


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {throw error;}    finally {
        }
        dbg.location(107, 5);

        }
        finally {
            dbg.exitRule("opA");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end opA

    public static class opB_return extends ParserRuleReturnScope {
        public Class value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start opB
    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:110:1: opB returns [Class value] : e= atom ( OpBool e= atom )* ;
    public final opB_return opB() throws RecognitionException {
        opB_return retval = new opB_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OpBool13=null;
        atom_return e = null;


        CommonTree OpBool13_tree=null;

        try { dbg.enterRule("opB");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(110, 1);

        try {
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:110:27: (e= atom ( OpBool e= atom )* )
            dbg.enterAlt(1);

            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:111:2: e= atom ( OpBool e= atom )*
            {
            root_0 = (CommonTree)adaptor.nil();

            dbg.location(111,3);
            pushFollow(FOLLOW_atom_in_opB220);
            e=atom();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            dbg.location(111,10);
            retval.value =e.value;
            dbg.location(112,2);
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:112:2: ( OpBool e= atom )*
            try { dbg.enterSubRule(5);

            loop5:
            do {
                int alt5=2;
                try { dbg.enterDecision(5);

                int LA5_0 = input.LA(1);

                if ( (LA5_0==OpBool) ) {
                    alt5=1;
                }


                } finally {dbg.exitDecision(5);}

                switch (alt5) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:112:3: OpBool e= atom
            	    {
            	    dbg.location(112,9);
            	    OpBool13=(Token)input.LT(1);
            	    match(input,OpBool,FOLLOW_OpBool_in_opB227); 
            	    OpBool13_tree = (CommonTree)adaptor.create(OpBool13);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OpBool13_tree, root_0);

            	    dbg.location(112,12);
            	    pushFollow(FOLLOW_atom_in_opB232);
            	    e=atom();
            	    _fsp--;

            	    adaptor.addChild(root_0, e.getTree());
            	    dbg.location(112,18);
            	    retval.value =compare(e.value,compare(retval.value,new Boolean(true).getClass(),false),false);

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);
            } finally {dbg.exitSubRule(5);}


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {throw error;}    finally {
        }
        dbg.location(113, 4);

        }
        finally {
            dbg.exitRule("opB");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end opB

    public static class atom_return extends ParserRuleReturnScope {
        public Class value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start atom
    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:115:1: atom returns [Class value] : ( FIELD | FLOAT | BOOL | STRING | '(' e= exp ')' -> exp | z= fun -> fun );
    public final atom_return atom() throws RecognitionException {
        atom_return retval = new atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FIELD14=null;
        Token FLOAT15=null;
        Token BOOL16=null;
        Token STRING17=null;
        Token char_literal18=null;
        Token char_literal19=null;
        exp_return e = null;

        fun_return z = null;


        CommonTree FIELD14_tree=null;
        CommonTree FLOAT15_tree=null;
        CommonTree BOOL16_tree=null;
        CommonTree STRING17_tree=null;
        CommonTree char_literal18_tree=null;
        CommonTree char_literal19_tree=null;
        RewriteRuleTokenStream stream_21=new RewriteRuleTokenStream(adaptor,"token 21");
        RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
        RewriteRuleSubtreeStream stream_exp=new RewriteRuleSubtreeStream(adaptor,"rule exp");
        RewriteRuleSubtreeStream stream_fun=new RewriteRuleSubtreeStream(adaptor,"rule fun");
        try { dbg.enterRule("atom");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(115, 1);

        try {
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:115:28: ( FIELD | FLOAT | BOOL | STRING | '(' e= exp ')' -> exp | z= fun -> fun )
            int alt6=6;
            try { dbg.enterDecision(6);

            switch ( input.LA(1) ) {
            case FIELD:
                {
                alt6=1;
                }
                break;
            case FLOAT:
                {
                alt6=2;
                }
                break;
            case BOOL:
                {
                alt6=3;
                }
                break;
            case STRING:
                {
                alt6=4;
                }
                break;
            case 21:
                {
                alt6=5;
                }
                break;
            case BoFun:
            case FlFun:
            case Count:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("115:1: atom returns [Class value] : ( FIELD | FLOAT | BOOL | STRING | '(' e= exp ')' -> exp | z= fun -> fun );", 6, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(6);}

            switch (alt6) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:116:2: FIELD
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(116,2);
                    FIELD14=(Token)input.LT(1);
                    match(input,FIELD,FOLLOW_FIELD_in_atom251); 
                    FIELD14_tree = (CommonTree)adaptor.create(FIELD14);
                    adaptor.addChild(root_0, FIELD14_tree);

                    dbg.location(116,10);
                    retval.value =getType(FIELD14.getText(),env);

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:117:3: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(117,3);
                    FLOAT15=(Token)input.LT(1);
                    match(input,FLOAT,FOLLOW_FLOAT_in_atom259); 
                    FLOAT15_tree = (CommonTree)adaptor.create(FLOAT15);
                    adaptor.addChild(root_0, FLOAT15_tree);

                    dbg.location(117,11);
                    retval.value =type("java.lang.Float");

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:118:3: BOOL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(118,3);
                    BOOL16=(Token)input.LT(1);
                    match(input,BOOL,FOLLOW_BOOL_in_atom267); 
                    BOOL16_tree = (CommonTree)adaptor.create(BOOL16);
                    adaptor.addChild(root_0, BOOL16_tree);

                    dbg.location(118,10);
                    retval.value =type("java.lang.Boolean");

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:119:3: STRING
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(119,3);
                    STRING17=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_atom275); 
                    STRING17_tree = (CommonTree)adaptor.create(STRING17);
                    adaptor.addChild(root_0, STRING17_tree);

                    dbg.location(119,11);
                    retval.value =type("java.lang.String");

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:120:3: '(' e= exp ')'
                    {
                    dbg.location(120,3);
                    char_literal18=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_atom282); 
                    stream_21.add(char_literal18);

                    dbg.location(120,7);
                    pushFollow(FOLLOW_exp_in_atom285);
                    e=exp();
                    _fsp--;

                    stream_exp.add(e.getTree());
                    dbg.location(120,11);
                    char_literal19=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_atom286); 
                    stream_22.add(char_literal19);

                    dbg.location(120,15);
                    retval.value =e.value;
                    dbg.location(120,33);

                    // AST REWRITE
                    // elements: exp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 120:33: -> exp
                    {
                        dbg.location(120,35);
                        adaptor.addChild(root_0, stream_exp.next());

                    }



                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:121:3: z= fun
                    {
                    dbg.location(121,4);
                    pushFollow(FOLLOW_fun_in_atom296);
                    z=fun();
                    _fsp--;

                    stream_fun.add(z.getTree());
                    dbg.location(121,10);
                    retval.value =z.value;
                    dbg.location(121,28);

                    // AST REWRITE
                    // elements: fun
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 121:28: -> fun
                    {
                        dbg.location(121,30);
                        adaptor.addChild(root_0, stream_fun.next());

                    }



                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {throw error;}    finally {
        }
        dbg.location(123, 2);

        }
        finally {
            dbg.exitRule("atom");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end atom

    public static class fun_return extends ParserRuleReturnScope {
        public Class value;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start fun
    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:125:1: fun returns [Class value] : ( BoFun '(' e= exp ')' | FlFun '(' e= exp ')' | Count '(' e= exp ')' );
    public final fun_return fun() throws RecognitionException {
        fun_return retval = new fun_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BoFun20=null;
        Token char_literal21=null;
        Token char_literal22=null;
        Token FlFun23=null;
        Token char_literal24=null;
        Token char_literal25=null;
        Token Count26=null;
        Token char_literal27=null;
        Token char_literal28=null;
        exp_return e = null;


        CommonTree BoFun20_tree=null;
        CommonTree char_literal21_tree=null;
        CommonTree char_literal22_tree=null;
        CommonTree FlFun23_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree Count26_tree=null;
        CommonTree char_literal27_tree=null;
        CommonTree char_literal28_tree=null;

        try { dbg.enterRule("fun");
        if ( ruleLevel==0 ) {dbg.commence();}
        ruleLevel++;
        dbg.location(125, 1);

        try {
            // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:125:26: ( BoFun '(' e= exp ')' | FlFun '(' e= exp ')' | Count '(' e= exp ')' )
            int alt7=3;
            try { dbg.enterDecision(7);

            switch ( input.LA(1) ) {
            case BoFun:
                {
                alt7=1;
                }
                break;
            case FlFun:
                {
                alt7=2;
                }
                break;
            case Count:
                {
                alt7=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("125:1: fun returns [Class value] : ( BoFun '(' e= exp ')' | FlFun '(' e= exp ')' | Count '(' e= exp ')' );", 7, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(7);}

            switch (alt7) {
                case 1 :
                    dbg.enterAlt(1);

                    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:126:2: BoFun '(' e= exp ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(126,7);
                    BoFun20=(Token)input.LT(1);
                    match(input,BoFun,FOLLOW_BoFun_in_fun320); 
                    BoFun20_tree = (CommonTree)adaptor.create(BoFun20);
                    root_0 = (CommonTree)adaptor.becomeRoot(BoFun20_tree, root_0);

                    dbg.location(126,12);
                    char_literal21=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_fun323); 
                    dbg.location(126,15);
                    pushFollow(FOLLOW_exp_in_fun328);
                    e=exp();
                    _fsp--;

                    adaptor.addChild(root_0, e.getTree());
                    dbg.location(126,23);
                    char_literal22=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_fun330); 
                    dbg.location(126,26);
                    retval.value =compare(e.value,new Boolean(true).getClass(),false);

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:127:3: FlFun '(' e= exp ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(127,8);
                    FlFun23=(Token)input.LT(1);
                    match(input,FlFun,FOLLOW_FlFun_in_fun338); 
                    FlFun23_tree = (CommonTree)adaptor.create(FlFun23);
                    root_0 = (CommonTree)adaptor.becomeRoot(FlFun23_tree, root_0);

                    dbg.location(127,13);
                    char_literal24=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_fun341); 
                    dbg.location(127,16);
                    pushFollow(FOLLOW_exp_in_fun346);
                    e=exp();
                    _fsp--;

                    adaptor.addChild(root_0, e.getTree());
                    dbg.location(127,24);
                    char_literal25=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_fun348); 
                    dbg.location(127,27);
                    retval.value =compare(e.value,new Float(0).getClass(),true);

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // /home/1/2006/mbortola/br-jsys/Codice/src/brjsys/files/BusinessRule.g:128:3: Count '(' e= exp ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    dbg.location(128,8);
                    Count26=(Token)input.LT(1);
                    match(input,Count,FOLLOW_Count_in_fun356); 
                    Count26_tree = (CommonTree)adaptor.create(Count26);
                    root_0 = (CommonTree)adaptor.becomeRoot(Count26_tree, root_0);

                    dbg.location(128,13);
                    char_literal27=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_fun359); 
                    dbg.location(128,16);
                    pushFollow(FOLLOW_exp_in_fun364);
                    e=exp();
                    _fsp--;

                    adaptor.addChild(root_0, e.getTree());
                    dbg.location(128,25);
                    char_literal28=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_fun367); 
                    dbg.location(128,27);
                    retval.value =new Float(0).getClass();

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {throw error;}    finally {
        }
        dbg.location(129, 2);

        }
        finally {
            dbg.exitRule("fun");
            ruleLevel--;
            if ( ruleLevel==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end fun


 

    public static final BitSet FOLLOW_rule_in_start51 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_OpRule_in_start55 = new BitSet(new long[]{0x000000000023F100L});
    public static final BitSet FOLLOW_rule_in_start58 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_exp_in_rule77 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_conf_in_rule82 = new BitSet(new long[]{0x000000000023F100L});
    public static final BitSet FOLLOW_exp_in_rule86 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_message_in_rule94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_conf0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Msg_in_message129 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_message131 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_message133 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_message134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_opA_in_exp151 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_OpA_in_exp159 = new BitSet(new long[]{0x000000000023F100L});
    public static final BitSet FOLLOW_opA_in_exp164 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_opB_in_opA184 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_OpM_in_opA191 = new BitSet(new long[]{0x000000000023F100L});
    public static final BitSet FOLLOW_opB_in_opA196 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_atom_in_opB220 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OpBool_in_opB227 = new BitSet(new long[]{0x000000000023F100L});
    public static final BitSet FOLLOW_atom_in_opB232 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_FIELD_in_atom251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_atom259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_atom267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atom275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_atom282 = new BitSet(new long[]{0x000000000023F100L});
    public static final BitSet FOLLOW_exp_in_atom285 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_atom286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fun_in_atom296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BoFun_in_fun320 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_fun323 = new BitSet(new long[]{0x000000000023F100L});
    public static final BitSet FOLLOW_exp_in_fun328 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_fun330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FlFun_in_fun338 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_fun341 = new BitSet(new long[]{0x000000000023F100L});
    public static final BitSet FOLLOW_exp_in_fun346 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_fun348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Count_in_fun356 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_fun359 = new BitSet(new long[]{0x000000000023F100L});
    public static final BitSet FOLLOW_exp_in_fun364 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_fun367 = new BitSet(new long[]{0x0000000000000002L});

}