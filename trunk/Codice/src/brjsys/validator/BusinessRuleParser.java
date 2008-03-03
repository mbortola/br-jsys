//$ANTLR 3.0.1 /../../media/sda1/ids/src/compiler/BusinessRule.g 2008-03-03 11:04:14
package brjsys.validator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;
public class BusinessRuleParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "OpRule", "Conf", "Bconf", "Msg", "STRING", "OpA", "OpM", "OpBool", "FIELD", "FLOAT", "BOOL", "BoFun", "FlFun", "Count", "CHAR", "OTHERCHAR", "SUBFIELD", "WHITESPACE", "'('", "')'"
	};
	public static final int Count=17;
	public static final int OpRule=4;
	public static final int BOOL=14;
	public static final int CHAR=18;
	public static final int WHITESPACE=21;
	public static final int Conf=5;
	public static final int FLOAT=13;
	public static final int OTHERCHAR=19;
	public static final int EOF=-1;
	public static final int OpBool=11;
	public static final int Msg=7;
	public static final int Bconf=6;
	public static final int SUBFIELD=20;
	public static final int FlFun=16;
	public static final int FIELD=12;
	public static final int OpM=10;
	public static final int BoFun=15;
	public static final int OpA=9;
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
	public String getGrammarFileName() { return "/../../media/sda1/ids/src/compiler/BusinessRule.g"; }


	static private Class env=null;

	protected void mismatch(IntStream input, int ttype, BitSet follow)throws RecognitionException{
		throw new MismatchedTokenException(ttype, input);
	}

	public void recoverFromMismatchedSet(IntStream input,RecognitionException e,BitSet follow)throws RecognitionException{
		throw e;
	}

	public static Class getType(String nome,Class ambiente)throws TypeCollisionException {
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
				throw new TypeCollisionException("Campo dati "+nome+" non trovato.");
			} 
		} catch (SecurityException e) {
			throw new TypeCollisionException("Security Exception");
		} catch (NoSuchFieldException e) {
			throw new TypeCollisionException("Campo dati "+nome+" non trovato.");
		}
	}

	private static Class type(String nome) throws RecognitionException {
		try{
			Class cl=Class.forName(nome);
			return cl;
		} catch (ClassNotFoundException e) {
			throw new TypeCollisionException("Classe "+nome+" non trovata");
		}
	}

	private static int getDimension(Class input){
		//mi dice la "dimensione" di input
		String inputString=input.getCanonicalName();
		int index=inputString.indexOf("[");
		return (index==-1?0:(inputString.length()-index)/2);
	}

	public static Class compare(TokenStream stream,Class input,Class confronto,boolean reduce)throws RecognitionException{

		if(getBasicType(input)==getBasicType(confronto)){//se no neanche faccio il test
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
		throw new TypeCollisionException("Operazione non consentita:\n"+input+" != "+confronto+"\n "+printTSNew(stream, 0, stream.index()-1)+"\nValidazione interrotta");
	}

	private static Class getBasicType(Class input) throws RecognitionException {
		/*dato un oggetto Class ritorno il tipo base ossia:
		 *input->Float ritorna Float
		 *input->Float[][][] ritorna Float
		 */
		String inputString=input.getCanonicalName();
		int index=inputString.indexOf("[");
		if (index==-1) {
			return input;
		}
		else {
			return type(inputString.substring(0,index));
		}
	}

	public BusinessRuleParser(String associated,CommonTokenStream input)throws TypeCollisionException{
		super(input);
		try {
			env=Class.forName("brjsys.validator.businessobjects."+associated);
		} catch (SecurityException e) {
			throw new TypeCollisionException("Security Exception");
		} catch (ClassNotFoundException e) {
			throw new TypeCollisionException("Oggetto Associato Inesistente");
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
	// /../../media/sda1/ids/src/compiler/BusinessRule.g:128:1: start : rule ( OpRule rule )* ;
	public final start_return start() throws RecognitionException {
		start_return retval = new start_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OpRule2=null;
		rule_return rule1 = null;

		rule_return rule3 = null;


		CommonTree OpRule2_tree=null;

		try {
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:128:7: ( rule ( OpRule rule )* )
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:129:2: rule ( OpRule rule )*
			{
				root_0 = (CommonTree)adaptor.nil();

				pushFollow(FOLLOW_rule_in_start51);
				rule1=rule();
				_fsp--;

				adaptor.addChild(root_0, rule1.getTree());
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:130:2: ( OpRule rule )*
				loop1:
					do {
						int alt1=2;
						int LA1_0 = input.LA(1);

						if ( (LA1_0==OpRule) ) {
							alt1=1;
						}


						switch (alt1) {
						case 1 :
							// /../../media/sda1/ids/src/compiler/BusinessRule.g:130:3: OpRule rule
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


			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException error) {
			System.out.println("Index:"+input.index());
			Token x=input.get(input.index()-1);
			String s=(x==null?"nulla":x.getText());
			System.out.println(">>>>"+s);
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
	// /../../media/sda1/ids/src/compiler/BusinessRule.g:134:1: rule returns [Class value] : e= exp ( conf e2= exp ) ( message )? -> ^( conf $e $e2 ( message )? ) ;
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
		try {
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:134:26: (e= exp ( conf e2= exp ) ( message )? -> ^( conf $e $e2 ( message )? ) )
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:135:2: e= exp ( conf e2= exp ) ( message )?
			{
				pushFollow(FOLLOW_exp_in_rule77);
				e=exp();
				_fsp--;

				stream_exp.add(e.getTree());
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:136:2: ( conf e2= exp )
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:136:3: conf e2= exp
				{
					pushFollow(FOLLOW_conf_in_rule82);
					conf4=conf();
					_fsp--;

					stream_conf.add(conf4.getTree());
					pushFollow(FOLLOW_exp_in_rule86);
					e2=exp();
					_fsp--;

					stream_exp.add(e2.getTree());
					if(!input.toString(conf4.start,conf4.stop).equals("=") && !input.toString(conf4.start,conf4.stop).equals("!=")){//devono essere Float
						retval.value =compare(input,e.value,compare(input,e2.value,new Float(0).getClass(),false),false);
					}else {retval.value =compare(input,e.value,e2.value,false);}

				}

				// /../../media/sda1/ids/src/compiler/BusinessRule.g:139:3: ( message )?
				int alt2=2;
				int LA2_0 = input.LA(1);

				if ( (LA2_0==Msg) ) {
					alt2=1;
				}
				switch (alt2) {
				case 1 :
					// /../../media/sda1/ids/src/compiler/BusinessRule.g:139:3: message
				{
					pushFollow(FOLLOW_message_in_rule94);
					message5=message();
					_fsp--;

					stream_message.add(message5.getTree());

				}
				break;

				}


				// AST REWRITE
				// elements: conf, e, e2, message
				// token labels: 
				// rule labels: retval, e2, e
				// token list labels: 
				// rule list labels: 
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);
				RewriteRuleSubtreeStream stream_e2=new RewriteRuleSubtreeStream(adaptor,"token e2",e2!=null?e2.tree:null);
				RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"token e",e!=null?e.tree:null);

				root_0 = (CommonTree)adaptor.nil();
				// 139:12: -> ^( conf $e $e2 ( message )? )
				{
					// /../../media/sda1/ids/src/compiler/BusinessRule.g:139:14: ^( conf $e $e2 ( message )? )
					{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_conf.nextNode(), root_1);

						adaptor.addChild(root_1, stream_e.next());
						adaptor.addChild(root_1, stream_e2.next());
						// /../../media/sda1/ids/src/compiler/BusinessRule.g:139:28: ( message )?
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
			System.out.println("Index:"+input.index());
			Token x=input.get(input.index()-1);
			String s=(x==null?"nulla":x.getText());
			System.out.println(">>>>"+s);
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
	// /../../media/sda1/ids/src/compiler/BusinessRule.g:142:1: conf : ( Conf | Bconf );
	public final conf_return conf() throws RecognitionException {
		conf_return retval = new conf_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set6=null;

		CommonTree set6_tree=null;

		try {
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:142:6: ( Conf | Bconf )
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:
			{
				root_0 = (CommonTree)adaptor.nil();

				set6=(Token)input.LT(1);
				if ( (input.LA(1)>=Conf && input.LA(1)<=Bconf) ) {
					input.consume();
					adaptor.addChild(root_0, adaptor.create(set6));
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
			System.out.println("Index:"+input.index());
			Token x=input.get(input.index()-1);
			String s=(x==null?"nulla":x.getText());
			System.out.println(">>>>"+s);
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
	// /../../media/sda1/ids/src/compiler/BusinessRule.g:144:1: message : Msg '(' STRING ')' ;
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

		try {
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:144:9: ( Msg '(' STRING ')' )
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:144:11: Msg '(' STRING ')'
			{
				root_0 = (CommonTree)adaptor.nil();

				Msg7=(Token)input.LT(1);
				match(input,Msg,FOLLOW_Msg_in_message129); 
				Msg7_tree = (CommonTree)adaptor.create(Msg7);
				root_0 = (CommonTree)adaptor.becomeRoot(Msg7_tree, root_0);

				char_literal8=(Token)input.LT(1);
				match(input,22,FOLLOW_22_in_message131); 
				STRING9=(Token)input.LT(1);
				match(input,STRING,FOLLOW_STRING_in_message133); 
				STRING9_tree = (CommonTree)adaptor.create(STRING9);
				adaptor.addChild(root_0, STRING9_tree);

				char_literal10=(Token)input.LT(1);
				match(input,23,FOLLOW_23_in_message134); 

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException error) {
			System.out.println("Index:"+input.index());
			Token x=input.get(input.index()-1);
			String s=(x==null?"nulla":x.getText());
			System.out.println(">>>>"+s);
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
	// /../../media/sda1/ids/src/compiler/BusinessRule.g:146:1: exp returns [Class value] : e= opA ( OpA e= opA )* ;
	public final exp_return exp() throws RecognitionException {
		exp_return retval = new exp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OpA11=null;
		opA_return e = null;


		CommonTree OpA11_tree=null;

		try {
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:146:27: (e= opA ( OpA e= opA )* )
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:147:2: e= opA ( OpA e= opA )*
			{
				root_0 = (CommonTree)adaptor.nil();

				pushFollow(FOLLOW_opA_in_exp151);
				e=opA();
				_fsp--;

				adaptor.addChild(root_0, e.getTree());
				retval.value =e.value;
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:148:2: ( OpA e= opA )*
				loop3:
					do {
						int alt3=2;
						int LA3_0 = input.LA(1);

						if ( (LA3_0==OpA) ) {
							alt3=1;
						}


						switch (alt3) {
						case 1 :
							// /../../media/sda1/ids/src/compiler/BusinessRule.g:148:3: OpA e= opA
						{
							OpA11=(Token)input.LT(1);
							match(input,OpA,FOLLOW_OpA_in_exp159); 
							OpA11_tree = (CommonTree)adaptor.create(OpA11);
							root_0 = (CommonTree)adaptor.becomeRoot(OpA11_tree, root_0);

							pushFollow(FOLLOW_opA_in_exp164);
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
			System.out.println("Index:"+input.index());
			Token x=input.get(input.index()-1);
			String s=(x==null?"nulla":x.getText());
			System.out.println(">>>>"+s);
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
	// /../../media/sda1/ids/src/compiler/BusinessRule.g:152:1: opA returns [Class value] : e= opB ( OpM e= opB )* ;
	public final opA_return opA() throws RecognitionException {
		opA_return retval = new opA_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OpM12=null;
		opB_return e = null;


		CommonTree OpM12_tree=null;

		try {
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:152:25: (e= opB ( OpM e= opB )* )
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:153:2: e= opB ( OpM e= opB )*
			{
				root_0 = (CommonTree)adaptor.nil();

				pushFollow(FOLLOW_opB_in_opA184);
				e=opB();
				_fsp--;

				adaptor.addChild(root_0, e.getTree());
				retval.value =e.value;
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:154:2: ( OpM e= opB )*
				loop4:
					do {
						int alt4=2;
						int LA4_0 = input.LA(1);

						if ( (LA4_0==OpM) ) {
							alt4=1;
						}


						switch (alt4) {
						case 1 :
							// /../../media/sda1/ids/src/compiler/BusinessRule.g:154:3: OpM e= opB
						{
							OpM12=(Token)input.LT(1);
							match(input,OpM,FOLLOW_OpM_in_opA191); 
							OpM12_tree = (CommonTree)adaptor.create(OpM12);
							root_0 = (CommonTree)adaptor.becomeRoot(OpM12_tree, root_0);

							pushFollow(FOLLOW_opB_in_opA196);
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
			System.out.println("Index:"+input.index());
			Token x=input.get(input.index()-1);
			String s=(x==null?"nulla":x.getText());
			System.out.println(">>>>"+s);
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
	// /../../media/sda1/ids/src/compiler/BusinessRule.g:158:1: opB returns [Class value] : e= atom ( OpBool e= atom )* ;
	public final opB_return opB() throws RecognitionException {
		opB_return retval = new opB_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OpBool13=null;
		atom_return e = null;


		CommonTree OpBool13_tree=null;

		try {
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:158:27: (e= atom ( OpBool e= atom )* )
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:159:2: e= atom ( OpBool e= atom )*
			{
				root_0 = (CommonTree)adaptor.nil();

				pushFollow(FOLLOW_atom_in_opB220);
				e=atom();
				_fsp--;

				adaptor.addChild(root_0, e.getTree());
				retval.value =e.value;
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:160:2: ( OpBool e= atom )*
				loop5:
					do {
						int alt5=2;
						int LA5_0 = input.LA(1);

						if ( (LA5_0==OpBool) ) {
							alt5=1;
						}


						switch (alt5) {
						case 1 :
							// /../../media/sda1/ids/src/compiler/BusinessRule.g:160:3: OpBool e= atom
						{
							OpBool13=(Token)input.LT(1);
							match(input,OpBool,FOLLOW_OpBool_in_opB227); 
							OpBool13_tree = (CommonTree)adaptor.create(OpBool13);
							root_0 = (CommonTree)adaptor.becomeRoot(OpBool13_tree, root_0);

							pushFollow(FOLLOW_atom_in_opB232);
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
			System.out.println("Index:"+input.index());
			Token x=input.get(input.index()-1);
			String s=(x==null?"nulla":x.getText());
			System.out.println(">>>>"+s);
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
	// /../../media/sda1/ids/src/compiler/BusinessRule.g:163:1: atom returns [Class value] : ( FIELD | FLOAT | BOOL | STRING | '(' e= exp ')' -> exp | z= fun -> fun );
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
		RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
		RewriteRuleTokenStream stream_23=new RewriteRuleTokenStream(adaptor,"token 23");
		RewriteRuleSubtreeStream stream_exp=new RewriteRuleSubtreeStream(adaptor,"rule exp");
		RewriteRuleSubtreeStream stream_fun=new RewriteRuleSubtreeStream(adaptor,"rule fun");
		try {
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:163:28: ( FIELD | FLOAT | BOOL | STRING | '(' e= exp ')' -> exp | z= fun -> fun )
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
			case 22:
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
					new NoViableAltException("163:1: atom returns [Class value] : ( FIELD | FLOAT | BOOL | STRING | '(' e= exp ')' -> exp | z= fun -> fun );", 6, 0, input);

			throw nvae;
			}

			switch (alt6) {
			case 1 :
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:164:2: FIELD
			{
				root_0 = (CommonTree)adaptor.nil();

				FIELD14=(Token)input.LT(1);
				match(input,FIELD,FOLLOW_FIELD_in_atom251); 
				FIELD14_tree = (CommonTree)adaptor.create(FIELD14);
				adaptor.addChild(root_0, FIELD14_tree);

				retval.value =getType(FIELD14.getText(),env);

			}
			break;
			case 2 :
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:165:3: FLOAT
			{
				root_0 = (CommonTree)adaptor.nil();

				FLOAT15=(Token)input.LT(1);
				match(input,FLOAT,FOLLOW_FLOAT_in_atom259); 
				FLOAT15_tree = (CommonTree)adaptor.create(FLOAT15);
				adaptor.addChild(root_0, FLOAT15_tree);

				retval.value =type("java.lang.Float");

			}
			break;
			case 3 :
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:166:3: BOOL
			{
				root_0 = (CommonTree)adaptor.nil();

				BOOL16=(Token)input.LT(1);
				match(input,BOOL,FOLLOW_BOOL_in_atom267); 
				BOOL16_tree = (CommonTree)adaptor.create(BOOL16);
				adaptor.addChild(root_0, BOOL16_tree);

				retval.value =type("java.lang.Boolean");

			}
			break;
			case 4 :
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:167:3: STRING
			{
				root_0 = (CommonTree)adaptor.nil();

				STRING17=(Token)input.LT(1);
				match(input,STRING,FOLLOW_STRING_in_atom275); 
				STRING17_tree = (CommonTree)adaptor.create(STRING17);
				adaptor.addChild(root_0, STRING17_tree);

				retval.value =type("java.lang.String");

			}
			break;
			case 5 :
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:168:3: '(' e= exp ')'
			{
				char_literal18=(Token)input.LT(1);
				match(input,22,FOLLOW_22_in_atom282); 
				stream_22.add(char_literal18);

				pushFollow(FOLLOW_exp_in_atom285);
				e=exp();
				_fsp--;

				stream_exp.add(e.getTree());
				char_literal19=(Token)input.LT(1);
				match(input,23,FOLLOW_23_in_atom286); 
				stream_23.add(char_literal19);

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
				// 168:33: -> exp
				{
					adaptor.addChild(root_0, stream_exp.next());

				}



			}
			break;
			case 6 :
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:169:3: z= fun
			{
				pushFollow(FOLLOW_fun_in_atom296);
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
				// 169:28: -> fun
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
			System.out.println("Index:"+input.index());
			Token x=input.get(input.index()-1);
			String s=(x==null?"nulla":x.getText());
			System.out.println(">>>>"+s);
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
	// /../../media/sda1/ids/src/compiler/BusinessRule.g:173:1: fun returns [Class value] : ( BoFun '(' e= exp ')' | FlFun '(' e= exp ')' | Count '(' e= exp ')' );
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

		try {
			// /../../media/sda1/ids/src/compiler/BusinessRule.g:173:26: ( BoFun '(' e= exp ')' | FlFun '(' e= exp ')' | Count '(' e= exp ')' )
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
					new NoViableAltException("173:1: fun returns [Class value] : ( BoFun '(' e= exp ')' | FlFun '(' e= exp ')' | Count '(' e= exp ')' );", 7, 0, input);

			throw nvae;
			}

			switch (alt7) {
			case 1 :
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:174:2: BoFun '(' e= exp ')'
			{
				root_0 = (CommonTree)adaptor.nil();

				BoFun20=(Token)input.LT(1);
				match(input,BoFun,FOLLOW_BoFun_in_fun320); 
				BoFun20_tree = (CommonTree)adaptor.create(BoFun20);
				root_0 = (CommonTree)adaptor.becomeRoot(BoFun20_tree, root_0);

				char_literal21=(Token)input.LT(1);
				match(input,22,FOLLOW_22_in_fun323); 
				pushFollow(FOLLOW_exp_in_fun328);
				e=exp();
				_fsp--;

				adaptor.addChild(root_0, e.getTree());
				char_literal22=(Token)input.LT(1);
				match(input,23,FOLLOW_23_in_fun330); 
				retval.value =compare(input,e.value,new Boolean(true).getClass(),false);

			}
			break;
			case 2 :
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:175:3: FlFun '(' e= exp ')'
			{
				root_0 = (CommonTree)adaptor.nil();

				FlFun23=(Token)input.LT(1);
				match(input,FlFun,FOLLOW_FlFun_in_fun338); 
				FlFun23_tree = (CommonTree)adaptor.create(FlFun23);
				root_0 = (CommonTree)adaptor.becomeRoot(FlFun23_tree, root_0);

				char_literal24=(Token)input.LT(1);
				match(input,22,FOLLOW_22_in_fun341); 
				pushFollow(FOLLOW_exp_in_fun346);
				e=exp();
				_fsp--;

				adaptor.addChild(root_0, e.getTree());
				char_literal25=(Token)input.LT(1);
				match(input,23,FOLLOW_23_in_fun348); 
				retval.value =compare(input,e.value,new Float(0).getClass(),true);

			}
			break;
			case 3 :
				// /../../media/sda1/ids/src/compiler/BusinessRule.g:176:3: Count '(' e= exp ')'
			{
				root_0 = (CommonTree)adaptor.nil();

				Count26=(Token)input.LT(1);
				match(input,Count,FOLLOW_Count_in_fun356); 
				Count26_tree = (CommonTree)adaptor.create(Count26);
				root_0 = (CommonTree)adaptor.becomeRoot(Count26_tree, root_0);

				char_literal27=(Token)input.LT(1);
				match(input,22,FOLLOW_22_in_fun359); 
				pushFollow(FOLLOW_exp_in_fun364);
				e=exp();
				_fsp--;

				adaptor.addChild(root_0, e.getTree());
				char_literal28=(Token)input.LT(1);
				match(input,23,FOLLOW_23_in_fun367); 
				retval.value =new Float(0).getClass();

			}
			break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException error) {
			System.out.println("Index:"+input.index());
			Token x=input.get(input.index()-1);
			String s=(x==null?"nulla":x.getText());
			System.out.println(">>>>"+s);
			if(error instanceof TypeCollisionException){}
			else{throw new TypeCollisionException("Errore sintattico:\n"+printTSNew(input,0,input.index()-1)+"\nValidazione interrotta");
			}
			throw error;}    finally {
			}
			return retval;
	}
	// $ANTLR end fun




	public static final BitSet FOLLOW_rule_in_start51 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_OpRule_in_start55 = new BitSet(new long[]{0x000000000043F100L});
	public static final BitSet FOLLOW_rule_in_start58 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_exp_in_rule77 = new BitSet(new long[]{0x0000000000000060L});
	public static final BitSet FOLLOW_conf_in_rule82 = new BitSet(new long[]{0x000000000043F100L});
	public static final BitSet FOLLOW_exp_in_rule86 = new BitSet(new long[]{0x0000000000000082L});
	public static final BitSet FOLLOW_message_in_rule94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_conf0 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Msg_in_message129 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_message131 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_STRING_in_message133 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_message134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_opA_in_exp151 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_OpA_in_exp159 = new BitSet(new long[]{0x000000000043F100L});
	public static final BitSet FOLLOW_opA_in_exp164 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_opB_in_opA184 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_OpM_in_opA191 = new BitSet(new long[]{0x000000000043F100L});
	public static final BitSet FOLLOW_opB_in_opA196 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_atom_in_opB220 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_OpBool_in_opB227 = new BitSet(new long[]{0x000000000043F100L});
	public static final BitSet FOLLOW_atom_in_opB232 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_FIELD_in_atom251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_atom259 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BOOL_in_atom267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_in_atom275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_atom282 = new BitSet(new long[]{0x000000000043F100L});
	public static final BitSet FOLLOW_exp_in_atom285 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_atom286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fun_in_atom296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BoFun_in_fun320 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_fun323 = new BitSet(new long[]{0x000000000043F100L});
	public static final BitSet FOLLOW_exp_in_fun328 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_fun330 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FlFun_in_fun338 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_fun341 = new BitSet(new long[]{0x000000000043F100L});
	public static final BitSet FOLLOW_exp_in_fun346 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_fun348 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Count_in_fun356 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_fun359 = new BitSet(new long[]{0x000000000043F100L});
	public static final BitSet FOLLOW_exp_in_fun364 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_fun367 = new BitSet(new long[]{0x0000000000000002L});

}