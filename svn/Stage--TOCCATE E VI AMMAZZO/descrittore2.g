grammar descrittore2;

options{
	output=AST;
	ASTLabelType=CommonTree;
}


@lexer::header{package grammar;}

@header{package grammar;}

//La struttura del descrittore di un file di configurazione consente varie rappresentazioni, 
//e' tuttavia consigliata la rappresentazione a 'tende alla veneziana' tipica di xml Schema
//Dove inizialmente di descrive l'elemento radice e via via si descrivono tutti i suoi elementi
//Cio e' molto pratico in ottica del riuso degli elementi, ed e' sintatticamente meglio leggibile

//Cio non toglie il poter fare una rappresentazione totalmente innestata, con un unico elemento
//radice che si sviluppa secondo un schema ad albero


start	:	typedef+;//Nessuno di questi e' un array!

typedef	:	STRING^ ':'! (array|obj);//type puo' essere un array o un oggetto non banale...non avrebbe senso

array	:	'['! (Atom|STRING) Card']'!;//un tipo solo

obj	:	'('! type (','! type)* ')'! Card?;

type	:	STRING^ ':'! (array|atom|STRING|obj) Card?;

atom	:	Atom ((':='!|'='!) Def)?;

Def	:	'"'STRING*'"'|FLOAT|BOOL;

Atom	:	('str'|'bool'|'int');

Card	:	('?'|'*'|'+');

FLOAT	:	('-')?('0'..'9')+;

BOOL	:	'true'|'false';

STRING	:	(CHAR|FLOAT)+;

fragment CHAR	:	('a'..'z')|('A'..'Z')|'_'|'<'|'=';

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+  { $channel=HIDDEN;} ;
