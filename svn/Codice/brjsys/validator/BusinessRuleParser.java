// $ANTLR 3.0.1 /media/DISK_IMG/br-jsys/Codice/BusinessRule.g 2008-03-20 20:24:08
package brjsys.validator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class BusinessRuleParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "OpRule", "Conf", "Bconf", "Msg", "STRING", "OpA", "OpM", "OpBool", "FIELD", "FLOAT", "BOOL", "BoFun", "FlFun", "Count", "CHAR", "OTHERCHAR", "NUMBER", "UNFLOAT", "SUBFIELD", "WHITESPACE", "'#'", "'('", "')'"
    };
    public static final int Count=17;
    public static final int OpRule=4;
    public static final int NUMBER=20;
    public static final int BOOL=14;
    public static final int CHAR=18;
    public static final int WHITESPACE=23;
    public static final int Conf=5;
    public static final int FLOAT=13;
    public static final int OTHERCHAR=19;
    public static final int EOF=-1;
    public static final int OpBool=11;
    public static final int Msg=7;
    public static final int Bconf=6;
    public static final int SUBFIELD=22;
    public static final int FlFun=16;
    public static final int FIELD=12;
    public static final int OpM=10;
    public static final int BoFun=15;
    public static final int OpA=9;
    public static final int UNFLOAT=21;
    public static final int STRING=8;

        public BusinessRuleParser(TokenStream input) {
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
    public String getGrammarFileName() { return "/media/DISK_IMG/br-jsys/Codice/BusinessRule.g"; }


    static private Class env=null;

    	/**Rappresenta il tipo del business object associato*/
    	protected void mismatch(IntStream input, int ttype, BitSet follow) 
    	throws RecognitionException {
    		throw new MismatchedTokenException(ttype, input);
    	}

    	public void recoverFromMismatchedSet(IntStream input, 
    			RecognitionException e,	BitSet follow)throws RecognitionException {
    		throw e;
    	}
    	
    	/**Ritorna il tipo di un campo dati del business object associato al quale
    	 * viene fatto riferimento nella business rule
    	 * 
    	 * @return Il tipo del campo dati in ingresso
    	 * */
    	public static Class getType(String nome,Class ambiente)
    	throws TypeCollisionException {
    		try {
    			int index=nome.indexOf(".");
    			if (index==-1) {
    				//ho un solo campo
    				return ambiente.getDeclaredField(nome).getType();
    			}
    			//ho piu' campi, li separo
    			String testa=nome.substring(0,index);
    			String coda=nome.substring(index+1);
    			//trovo il tipo di testa, che diventera' il nuovo ambiente
    			Class tipotesta=ambiente.getDeclaredField(testa).getType();
    			try {
    				return getType(coda,tipotesta);
    			} catch (TypeCollisionException e) {
    				throw new TypeCollisionException("Campo dati "
    						+nome+" non trovato.");
    			} 
    		} catch (SecurityException e) {
    			throw new TypeCollisionException("Security Exception");
    		} catch (NoSuchFieldException e) {
    			throw new TypeCollisionException("Campo dati "
    					+nome+" non trovato.");
    		}
    	}

    	/**Ritorna il tipo che viene rappresentato dal parametro in ingresso.
    	 * Funzione interna ausiliaria.
    	 * 
    	 * @param nome Nome del tipo in ingresso.
    	 * 
    	 * @return La classe che rappresenta il tipo del parametro in ingresso.
    	 * */
    	private static Class type(String nome) throws RecognitionException {
    		try{
    			Class cl=Class.forName(nome);
    			return cl;
    		} catch (ClassNotFoundException e) {
    			throw new TypeCollisionException("Classe "+nome+" non trovata");
    		}
    	}

    	/**Ritorna il numero di dimensioni del camo dati in ingresso.
    	 * String ritorna 0
    	 * int[] ritorna 1
    	 * char[][][] ritorna 3
    	 * 
    	 * @param input Il tipo da controllare.
    	 * */
    	private static int getDimension(Class input){
    		//mi dice la "dimensione" di input
    		String inputString=input.getCanonicalName();
    		int index=inputString.indexOf("[");
    		return (index==-1?0:(inputString.length()-index)/2);
    	}

    	
    	/**
    	 * Confronta due tipi in ingresso e dice se sono di tipo cmpatibile per una 
    	 * operazione.
    	 * 
    	 * @param stream Flusso di token letto in ingresso, necessario per una 
    	 * corretta visualizzazione degli errori.
    	 * @param input Primo input per il confronto
    	 * @param confronto Secondo input per il confronto
    	 * 
    	 * @param reduce Indica se devo ritornare un tipo ridotto di una dimensione 
    	 * rispetto a input oppure se lo devo lasciare invariato.
    	 * 
    	 *@return Il tipo di ritorno dell'operazione.
    	 *
    	 * @exception RecognitionException L'operazione tra i due dati in ingresso 
    	 * non e' possibile. 
    	 * 
    	 * */
    	public static Class compare(TokenStream stream, Class input,
    			Class confronto, boolean reduce)throws RecognitionException {

    		if (getBasicType(input)==getBasicType(confronto)) {
    			if (input.equals(confronto)) {
    				//stesso identico tipo
    				return input;
    			}
    			if (getDimension(confronto)==0) {
    				//uno dei due e' una matrice
    				return (reduce?input.getComponentType():input);
    			}
    			if (getDimension(input)==0) {
    				return (reduce?confronto.getComponentType():confronto);
    			}
    			//tutte e due matrici di dimensioni diverse
    		}
    		throw new TypeCollisionException("Operazione non consentita:\n"+input+
    				" != "+confronto+":\n "+printTSNew(stream, 0, stream.index()-1)+
    				"\nValidazione interrotta");
    	}
    	/**
    	 * Dato un oggetto Class ritorno il tipo base ossia:
    	 * getBasicType(Float) ritorna Float
    	 * getBasicTyp(Float[][][]) ritorna Float
    	 * 
    	 * @param input Il tipo in ingresso.
    	 * 
    	 * @return La classe base di quel tipo.
    	 * 
    	 * @exception RecognitionException Tipo in ingresso inesistente. 
    	 * */
    	private static Class getBasicType(Class input) throws RecognitionException {
    		String inputString=input.getCanonicalName();
    		int index=inputString.indexOf("[");
    		if (index==-1) {
    			return input;
    		}
    		else {
    			return type(inputString.substring(0,index));
    		}
    	}

    	/**
    	 * Costruttore.
    	 * 
    	 * @param associated Nome dell'oggetto business associato.
    	 * 
    	 * @param input Stream di input.
    	 * \
    	 * @exception RecognitionException Associated non fa riferimento a nessun business object esistente.
    	 * 
    	 * */
    	public BusinessRuleParser(String associated,CommonTokenStream input)throws RecognitionException{
    		super(input);
    		try {
    			env=Class.forName("brjsys.validator.businessobjects."+associated);
    		} catch (SecurityException e) {
    			throw new TypeCollisionException("Security Exception");
    		} catch (ClassNotFoundException e) {
    			throw new TypeCollisionException("Oggetto associato "+associated+" inesistente");
    		}
    	}

    	public static String printTSNew(TokenStream stream, int start, int stop){
    		String result="";
    		for (int index=start; index<=stop; index++) {
    			result+=stream.get(index).getText()+' ';
    		}
    		return result;
    	}



    public static class start_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start start
    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:189:1: start : rule ( OpRule rule )* '#' ;
    public final start_return start() throws RecognitionException {
        start_return retval = new start_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OpRule2=null;
        Token char_literal4=null;
        rule_return rule1 = null;

        rule_return rule3 = null;


        CommonTree OpRule2_tree=null;
        CommonTree char_literal4_tree=null;

        try {
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:189:7: ( rule ( OpRule rule )* '#' )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:190:2: rule ( OpRule rule )* '#'
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_rule_in_start51);
            rule1=rule();
            _fsp--;

            adaptor.addChild(root_0, rule1.getTree());
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:191:2: ( OpRule rule )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==OpRule) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:191:3: OpRule rule
            	    {
            	    OpRule2=(Token)input.LT(1);
            	    match(input,OpRule,FOLLOW_OpRule_in_start55); 
            	    OpRule2_tree = (CommonTree)adaptor.create(OpRule2);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OpRule2_tree, root_0);

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

            char_literal4=(Token)input.LT(1);
            match(input,24,FOLLOW_24_in_start64); 

            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {
        		error.printStackTrace();
        		if(error instanceof TypeCollisionException){}
        		else{throw new TypeCollisionException("Errore sintattico:\n"+printTSNew(input,0,input.index()-1)+"\nValidazione interrotta");
        		}
        		throw error;}    finally {
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
    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:195:1: rule returns [Class value] : e= exp ( conf e2= exp ) ( message )? -> ^( conf $e $e2 ( message )? ) ;
    public final rule_return rule() throws RecognitionException {
        rule_return retval = new rule_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        exp_return e = null;

        exp_return e2 = null;

        conf_return conf5 = null;

        message_return message6 = null;


        RewriteRuleSubtreeStream stream_message=new RewriteRuleSubtreeStream(adaptor,"rule message");
        RewriteRuleSubtreeStream stream_exp=new RewriteRuleSubtreeStream(adaptor,"rule exp");
        RewriteRuleSubtreeStream stream_conf=new RewriteRuleSubtreeStream(adaptor,"rule conf");
        try {
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:195:26: (e= exp ( conf e2= exp ) ( message )? -> ^( conf $e $e2 ( message )? ) )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:196:2: e= exp ( conf e2= exp ) ( message )?
            {
            pushFollow(FOLLOW_exp_in_rule80);
            e=exp();
            _fsp--;

            stream_exp.add(e.getTree());
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:197:2: ( conf e2= exp )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:197:3: conf e2= exp
            {
            pushFollow(FOLLOW_conf_in_rule85);
            conf5=conf();
            _fsp--;

            stream_conf.add(conf5.getTree());
            pushFollow(FOLLOW_exp_in_rule89);
            e2=exp();
            _fsp--;

            stream_exp.add(e2.getTree());
            if(!input.toString(conf5.start,conf5.stop).equals("=") && !input.toString(conf5.start,conf5.stop).equals("!=")){//devono essere Float
            				retval.value =compare(input,e.value,compare(input,e2.value,new Float(0).getClass(),false),false);
            			}else {retval.value =compare(input,e.value,e2.value,false);}

            }

            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:200:3: ( message )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Msg) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:200:3: message
                    {
                    pushFollow(FOLLOW_message_in_rule97);
                    message6=message();
                    _fsp--;

                    stream_message.add(message6.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: message, conf, e, e2
            // token labels: 
            // rule labels: retval, e2, e
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_e2=new RewriteRuleSubtreeStream(adaptor,"token e2",e2!=null?e2.tree:null);
            RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"token e",e!=null?e.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 200:13: -> ^( conf $e $e2 ( message )? )
            {
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:200:15: ^( conf $e $e2 ( message )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_conf.nextNode(), root_1);

                adaptor.addChild(root_1, stream_e.next());
                adaptor.addChild(root_1, stream_e2.next());
                // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:200:29: ( message )?
                if ( stream_message.hasNext() ) {
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
        catch (RecognitionException error) {
        		error.printStackTrace();
        		if(error instanceof TypeCollisionException){}
        		else{throw new TypeCollisionException("Errore sintattico:\n"+printTSNew(input,0,input.index()-1)+"\nValidazione interrotta");
        		}
        		throw error;}    finally {
        }
        return retval;
    }
    // $ANTLR end rule

    public static class conf_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start conf
    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:203:1: conf : ( Conf | Bconf );
    public final conf_return conf() throws RecognitionException {
        conf_return retval = new conf_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set7=null;

        CommonTree set7_tree=null;

        try {
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:203:6: ( Conf | Bconf )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set7=(Token)input.LT(1);
            if ( (input.LA(1)>=Conf && input.LA(1)<=Bconf) ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set7));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_conf0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {
        		error.printStackTrace();
        		if(error instanceof TypeCollisionException){}
        		else{throw new TypeCollisionException("Errore sintattico:\n"+printTSNew(input,0,input.index()-1)+"\nValidazione interrotta");
        		}
        		throw error;}    finally {
        }
        return retval;
    }
    // $ANTLR end conf

    public static class message_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start message
    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:205:1: message : Msg '(' STRING ')' ;
    public final message_return message() throws RecognitionException {
        message_return retval = new message_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Msg8=null;
        Token char_literal9=null;
        Token STRING10=null;
        Token char_literal11=null;

        CommonTree Msg8_tree=null;
        CommonTree char_literal9_tree=null;
        CommonTree STRING10_tree=null;
        CommonTree char_literal11_tree=null;

        try {
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:205:9: ( Msg '(' STRING ')' )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:205:11: Msg '(' STRING ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            Msg8=(Token)input.LT(1);
            match(input,Msg,FOLLOW_Msg_in_message133); 
            Msg8_tree = (CommonTree)adaptor.create(Msg8);
            root_0 = (CommonTree)adaptor.becomeRoot(Msg8_tree, root_0);

            char_literal9=(Token)input.LT(1);
            match(input,25,FOLLOW_25_in_message135); 
            STRING10=(Token)input.LT(1);
            match(input,STRING,FOLLOW_STRING_in_message137); 
            STRING10_tree = (CommonTree)adaptor.create(STRING10);
            adaptor.addChild(root_0, STRING10_tree);

            char_literal11=(Token)input.LT(1);
            match(input,26,FOLLOW_26_in_message138); 

            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {
        		error.printStackTrace();
        		if(error instanceof TypeCollisionException){}
        		else{throw new TypeCollisionException("Errore sintattico:\n"+printTSNew(input,0,input.index()-1)+"\nValidazione interrotta");
        		}
        		throw error;}    finally {
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
    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:207:1: exp returns [Class value] : e= opA ( OpA e= opA )* ;
    public final exp_return exp() throws RecognitionException {
        exp_return retval = new exp_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OpA12=null;
        opA_return e = null;


        CommonTree OpA12_tree=null;

        try {
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:207:27: (e= opA ( OpA e= opA )* )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:208:2: e= opA ( OpA e= opA )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_opA_in_exp155);
            e=opA();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            retval.value =e.value;
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:209:2: ( OpA e= opA )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==OpA) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:209:3: OpA e= opA
            	    {
            	    OpA12=(Token)input.LT(1);
            	    match(input,OpA,FOLLOW_OpA_in_exp163); 
            	    OpA12_tree = (CommonTree)adaptor.create(OpA12);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OpA12_tree, root_0);

            	    pushFollow(FOLLOW_opA_in_exp168);
            	    e=opA();
            	    _fsp--;

            	    adaptor.addChild(root_0, e.getTree());
            	    retval.value =compare(input,e.value,compare(input,retval.value,new Float(0).getClass(),false),false);

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {
        		error.printStackTrace();
        		if(error instanceof TypeCollisionException){}
        		else{throw new TypeCollisionException("Errore sintattico:\n"+printTSNew(input,0,input.index()-1)+"\nValidazione interrotta");
        		}
        		throw error;}    finally {
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
    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:213:1: opA returns [Class value] : e= opB ( OpM e= opB )* ;
    public final opA_return opA() throws RecognitionException {
        opA_return retval = new opA_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OpM13=null;
        opB_return e = null;


        CommonTree OpM13_tree=null;

        try {
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:213:25: (e= opB ( OpM e= opB )* )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:214:2: e= opB ( OpM e= opB )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_opB_in_opA188);
            e=opB();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            retval.value =e.value;
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:215:2: ( OpM e= opB )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==OpM) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:215:3: OpM e= opB
            	    {
            	    OpM13=(Token)input.LT(1);
            	    match(input,OpM,FOLLOW_OpM_in_opA195); 
            	    OpM13_tree = (CommonTree)adaptor.create(OpM13);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OpM13_tree, root_0);

            	    pushFollow(FOLLOW_opB_in_opA200);
            	    e=opB();
            	    _fsp--;

            	    adaptor.addChild(root_0, e.getTree());
            	    retval.value =compare(input,e.value,compare(input, retval.value,new Float(0).getClass(),false),false);

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {
        		error.printStackTrace();
        		if(error instanceof TypeCollisionException){}
        		else{throw new TypeCollisionException("Errore sintattico:\n"+printTSNew(input,0,input.index()-1)+"\nValidazione interrotta");
        		}
        		throw error;}    finally {
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
    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:219:1: opB returns [Class value] : e= atom ( OpBool e= atom )* ;
    public final opB_return opB() throws RecognitionException {
        opB_return retval = new opB_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token OpBool14=null;
        atom_return e = null;


        CommonTree OpBool14_tree=null;

        try {
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:219:27: (e= atom ( OpBool e= atom )* )
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:220:2: e= atom ( OpBool e= atom )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_atom_in_opB224);
            e=atom();
            _fsp--;

            adaptor.addChild(root_0, e.getTree());
            retval.value =e.value;
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:221:2: ( OpBool e= atom )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==OpBool) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:221:3: OpBool e= atom
            	    {
            	    OpBool14=(Token)input.LT(1);
            	    match(input,OpBool,FOLLOW_OpBool_in_opB231); 
            	    OpBool14_tree = (CommonTree)adaptor.create(OpBool14);
            	    root_0 = (CommonTree)adaptor.becomeRoot(OpBool14_tree, root_0);

            	    pushFollow(FOLLOW_atom_in_opB236);
            	    e=atom();
            	    _fsp--;

            	    adaptor.addChild(root_0, e.getTree());
            	    retval.value =compare(input,e.value,compare(input,retval.value,new Boolean(true).getClass(),false),false);

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {
        		error.printStackTrace();
        		if(error instanceof TypeCollisionException){}
        		else{throw new TypeCollisionException("Errore sintattico:\n"+printTSNew(input,0,input.index()-1)+"\nValidazione interrotta");
        		}
        		throw error;}    finally {
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
    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:224:1: atom returns [Class value] : ( FIELD | FLOAT | BOOL | STRING | '(' e= exp ')' -> exp | z= fun -> fun );
    public final atom_return atom() throws RecognitionException {
        atom_return retval = new atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token FIELD15=null;
        Token FLOAT16=null;
        Token BOOL17=null;
        Token STRING18=null;
        Token char_literal19=null;
        Token char_literal20=null;
        exp_return e = null;

        fun_return z = null;


        CommonTree FIELD15_tree=null;
        CommonTree FLOAT16_tree=null;
        CommonTree BOOL17_tree=null;
        CommonTree STRING18_tree=null;
        CommonTree char_literal19_tree=null;
        CommonTree char_literal20_tree=null;
        RewriteRuleTokenStream stream_25=new RewriteRuleTokenStream(adaptor,"token 25");
        RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
        RewriteRuleSubtreeStream stream_exp=new RewriteRuleSubtreeStream(adaptor,"rule exp");
        RewriteRuleSubtreeStream stream_fun=new RewriteRuleSubtreeStream(adaptor,"rule fun");
        try {
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:224:28: ( FIELD | FLOAT | BOOL | STRING | '(' e= exp ')' -> exp | z= fun -> fun )
            int alt6=6;
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
            case 25:
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
                    new NoViableAltException("224:1: atom returns [Class value] : ( FIELD | FLOAT | BOOL | STRING | '(' e= exp ')' -> exp | z= fun -> fun );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:225:2: FIELD
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    FIELD15=(Token)input.LT(1);
                    match(input,FIELD,FOLLOW_FIELD_in_atom255); 
                    FIELD15_tree = (CommonTree)adaptor.create(FIELD15);
                    adaptor.addChild(root_0, FIELD15_tree);

                    retval.value =getType(FIELD15.getText(),env);

                    }
                    break;
                case 2 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:226:3: FLOAT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    FLOAT16=(Token)input.LT(1);
                    match(input,FLOAT,FOLLOW_FLOAT_in_atom263); 
                    FLOAT16_tree = (CommonTree)adaptor.create(FLOAT16);
                    adaptor.addChild(root_0, FLOAT16_tree);

                    retval.value =type("java.lang.Float");

                    }
                    break;
                case 3 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:227:3: BOOL
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    BOOL17=(Token)input.LT(1);
                    match(input,BOOL,FOLLOW_BOOL_in_atom271); 
                    BOOL17_tree = (CommonTree)adaptor.create(BOOL17);
                    adaptor.addChild(root_0, BOOL17_tree);

                    retval.value =type("java.lang.Boolean");

                    }
                    break;
                case 4 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:228:3: STRING
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    STRING18=(Token)input.LT(1);
                    match(input,STRING,FOLLOW_STRING_in_atom279); 
                    STRING18_tree = (CommonTree)adaptor.create(STRING18);
                    adaptor.addChild(root_0, STRING18_tree);

                    retval.value =type("java.lang.String");

                    }
                    break;
                case 5 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:229:3: '(' e= exp ')'
                    {
                    char_literal19=(Token)input.LT(1);
                    match(input,25,FOLLOW_25_in_atom286); 
                    stream_25.add(char_literal19);

                    pushFollow(FOLLOW_exp_in_atom289);
                    e=exp();
                    _fsp--;

                    stream_exp.add(e.getTree());
                    char_literal20=(Token)input.LT(1);
                    match(input,26,FOLLOW_26_in_atom290); 
                    stream_26.add(char_literal20);

                    retval.value =e.value;

                    // AST REWRITE
                    // elements: exp
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 229:33: -> exp
                    {
                        adaptor.addChild(root_0, stream_exp.next());

                    }



                    }
                    break;
                case 6 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:230:3: z= fun
                    {
                    pushFollow(FOLLOW_fun_in_atom300);
                    z=fun();
                    _fsp--;

                    stream_fun.add(z.getTree());
                    retval.value =z.value;

                    // AST REWRITE
                    // elements: fun
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 230:28: -> fun
                    {
                        adaptor.addChild(root_0, stream_fun.next());

                    }



                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {
        		error.printStackTrace();
        		if(error instanceof TypeCollisionException){}
        		else{throw new TypeCollisionException("Errore sintattico:\n"+printTSNew(input,0,input.index()-1)+"\nValidazione interrotta");
        		}
        		throw error;}    finally {
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
    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:234:1: fun returns [Class value] : ( BoFun '(' e= exp ')' | FlFun '(' e= exp ')' | Count '(' e= exp ')' );
    public final fun_return fun() throws RecognitionException {
        fun_return retval = new fun_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token BoFun21=null;
        Token char_literal22=null;
        Token char_literal23=null;
        Token FlFun24=null;
        Token char_literal25=null;
        Token char_literal26=null;
        Token Count27=null;
        Token char_literal28=null;
        Token char_literal29=null;
        exp_return e = null;


        CommonTree BoFun21_tree=null;
        CommonTree char_literal22_tree=null;
        CommonTree char_literal23_tree=null;
        CommonTree FlFun24_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree char_literal26_tree=null;
        CommonTree Count27_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree char_literal29_tree=null;

        try {
            // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:234:26: ( BoFun '(' e= exp ')' | FlFun '(' e= exp ')' | Count '(' e= exp ')' )
            int alt7=3;
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
                    new NoViableAltException("234:1: fun returns [Class value] : ( BoFun '(' e= exp ')' | FlFun '(' e= exp ')' | Count '(' e= exp ')' );", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:235:2: BoFun '(' e= exp ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    BoFun21=(Token)input.LT(1);
                    match(input,BoFun,FOLLOW_BoFun_in_fun324); 
                    BoFun21_tree = (CommonTree)adaptor.create(BoFun21);
                    root_0 = (CommonTree)adaptor.becomeRoot(BoFun21_tree, root_0);

                    char_literal22=(Token)input.LT(1);
                    match(input,25,FOLLOW_25_in_fun327); 
                    pushFollow(FOLLOW_exp_in_fun332);
                    e=exp();
                    _fsp--;

                    adaptor.addChild(root_0, e.getTree());
                    char_literal23=(Token)input.LT(1);
                    match(input,26,FOLLOW_26_in_fun334); 
                    retval.value =compare(input,e.value,new Boolean(true).getClass(),false);

                    }
                    break;
                case 2 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:236:3: FlFun '(' e= exp ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    FlFun24=(Token)input.LT(1);
                    match(input,FlFun,FOLLOW_FlFun_in_fun342); 
                    FlFun24_tree = (CommonTree)adaptor.create(FlFun24);
                    root_0 = (CommonTree)adaptor.becomeRoot(FlFun24_tree, root_0);

                    char_literal25=(Token)input.LT(1);
                    match(input,25,FOLLOW_25_in_fun345); 
                    pushFollow(FOLLOW_exp_in_fun350);
                    e=exp();
                    _fsp--;

                    adaptor.addChild(root_0, e.getTree());
                    char_literal26=(Token)input.LT(1);
                    match(input,26,FOLLOW_26_in_fun352); 
                    retval.value =compare(input,e.value,new Float(0).getClass(),true);

                    }
                    break;
                case 3 :
                    // /media/DISK_IMG/br-jsys/Codice/BusinessRule.g:237:3: Count '(' e= exp ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    Count27=(Token)input.LT(1);
                    match(input,Count,FOLLOW_Count_in_fun360); 
                    Count27_tree = (CommonTree)adaptor.create(Count27);
                    root_0 = (CommonTree)adaptor.becomeRoot(Count27_tree, root_0);

                    char_literal28=(Token)input.LT(1);
                    match(input,25,FOLLOW_25_in_fun363); 
                    pushFollow(FOLLOW_exp_in_fun368);
                    e=exp();
                    _fsp--;

                    adaptor.addChild(root_0, e.getTree());
                    char_literal29=(Token)input.LT(1);
                    match(input,26,FOLLOW_26_in_fun371); 
                    retval.value =new Float(0).getClass();

                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException error) {
        		error.printStackTrace();
        		if(error instanceof TypeCollisionException){}
        		else{throw new TypeCollisionException("Errore sintattico:\n"+printTSNew(input,0,input.index()-1)+"\nValidazione interrotta");
        		}
        		throw error;}    finally {
        }
        return retval;
    }
    // $ANTLR end fun


 

    public static final BitSet FOLLOW_rule_in_start51 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_OpRule_in_start55 = new BitSet(new long[]{0x000000000203F100L});
    public static final BitSet FOLLOW_rule_in_start58 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_24_in_start64 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exp_in_rule80 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_conf_in_rule85 = new BitSet(new long[]{0x000000000203F100L});
    public static final BitSet FOLLOW_exp_in_rule89 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_message_in_rule97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_conf0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Msg_in_message133 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_message135 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_STRING_in_message137 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_message138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_opA_in_exp155 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_OpA_in_exp163 = new BitSet(new long[]{0x000000000203F100L});
    public static final BitSet FOLLOW_opA_in_exp168 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_opB_in_opA188 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_OpM_in_opA195 = new BitSet(new long[]{0x000000000203F100L});
    public static final BitSet FOLLOW_opB_in_opA200 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_atom_in_opB224 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_OpBool_in_opB231 = new BitSet(new long[]{0x000000000203F100L});
    public static final BitSet FOLLOW_atom_in_opB236 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_FIELD_in_atom255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_atom263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOL_in_atom271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_atom279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_atom286 = new BitSet(new long[]{0x000000000203F100L});
    public static final BitSet FOLLOW_exp_in_atom289 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_atom290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_fun_in_atom300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BoFun_in_fun324 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_fun327 = new BitSet(new long[]{0x000000000203F100L});
    public static final BitSet FOLLOW_exp_in_fun332 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_fun334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FlFun_in_fun342 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_fun345 = new BitSet(new long[]{0x000000000203F100L});
    public static final BitSet FOLLOW_exp_in_fun350 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_fun352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Count_in_fun360 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_fun363 = new BitSet(new long[]{0x000000000203F100L});
    public static final BitSet FOLLOW_exp_in_fun368 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_fun371 = new BitSet(new long[]{0x0000000000000002L});

}