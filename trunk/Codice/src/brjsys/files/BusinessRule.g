grammar BusinessRule;

options{
	output=AST;
	ASTLabelType=CommonTree;
}

@lexer::header{package brjsys.validator;}

@header{package brjsys.validator;
}

@members{
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
	
}

@rulecatch{catch (RecognitionException error) {throw error;}}

start	:
	rule
	(OpRule^ rule
	)*
	;
//In teoria non dovrei ritornare nulla, controllo solo gli exp
rule	returns[Class value]:
	e=exp 
	(conf e2=exp 	 {if(!$conf.text.equals("=") && !$conf.text.equals("!=")){//devono essere Float
				$value=compare($e.value,compare($e2.value,new Float(0).getClass(),false),false);
			}else {$value=compare($e.value,$e2.value,false);}}
	)message?	->^(conf $e $e2 message?)
	;
//nessun controllo
conf	:	Conf|Bconf;

message	:	Msg^'('!STRING')'!	;
//controllo che ritorni tipo Float se estendo con operatori + o -
exp	returns [Class value]	:
	e=opA 		{$value=$e.value;}
	(OpA^ e=opA	{$value=compare($e.value,compare($value,new Float(0).getClass(),false),false);}
	)*;

//come sopra
opA	returns[Class value]:
	e=opB		{$value=$e.value;}
	(OpM^ e=opB	{$value=compare($e.value,compare($value,new Float(0).getClass(),false),false);}
	 )*;
//come sopra solo che deve essere Boolean
//consento operazioni tra bool e bool di qualsiasi dimensione e tra bool di pari dimensione
opB 	returns [Class value]:	
	e=atom		{$value=$e.value;}
	(OpBool^ e=atom	{$value=compare($e.value,compare($value,new Boolean(true).getClass(),false),false);}
	)*;
//ritorno il tipo del dato
atom returns [Class value]	:
	FIELD 		{$value=getType($FIELD.text,env);}
	|FLOAT 		{$value=type("java.lang.Float");}
	|BOOL 		{$value=type("java.lang.Boolean");}
	|STRING 	{$value=type("java.lang.String");}
	|'('e=exp')'	{$value=$e.value;}->exp
	|z=fun		{$value=$z.value;}->fun
			
	;
//ritorno in oppure Boolean a seconda delle operazioni(attenzione anche alle matrici)
fun returns[Class value]	:	
	BoFun^ '('! e=exp ')'!		{$value=compare($e.value,new Boolean(true).getClass(),false);}
	|FlFun^ '('! e=exp ')'!		{$value=compare($e.value,new Float(0).getClass(),true);}
	|Count^ '('! e=exp  ')'!	{$value=new Float(0).getClass();}
	;

FlFun	:	'SUM'|'AVG';

BoFun	:	'NOT';

Count	:	'COUNT';

Msg	:	'message';

OpRule	:	'AND'|'OR';

OpBool	:	'||'|'&&';

OpA	:	'+'|'-';

OpM	:	'*'|'/';

Conf	:	'<'|'>'|'<='|'>=';

Bconf	:	'='|'!=';

STRING	:	'"'(CHAR|' ')*'"';

BOOL	:	'true'|'false';

FLOAT	:	('~')?('0'..'9')+('.'('0'..'9')+)?;

FIELD	:	SUBFIELD('.'SUBFIELD)*;

WHITESPACE	:	(' '|'\n'|'\t'|'\r')+{ skip();};

fragment SUBFIELD	:	CHAR(CHAR|('0'..'9'))*;

fragment CHAR	:	('a'..'z')|('A'..'Z')|'_';
