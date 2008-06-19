grammar descrittore3;

options{
	output=AST;
	ASTLabelType=CommonTree;
}


@lexer::header{package grammatiche;}

@header{package grammatiche;}

//La struttura del descrittore di un file di configurazione consente varie rappresentazioni, 
//e' tuttavia consigliata la rappresentazione a 'tende alla veneziana' tipica di xml Schema
//Dove inizialmente di descrive l'elemento radice e via via si descrivono tutti i suoi elementi
//Cio e' molto pratico in ottica del riuso degli elementi, ed e' sintatticamente meglio leggibile

//Cio non toglie il poter fare una rappresentazione totalmente innestata, con un unico elemento
//radice che si sviluppa secondo un schema ad albero


start	:	base+;

base	:	STRING^ ':'!(list|'('! (atom|STRING) Card? ')'!);

list	:	'('! typedef (','! typedef)* ')'!;

typedef	:	STRING^ ':'! (atom|(list)|STRING)Card?;

atom	:	Atom ((':='!|'='!)Def)?;

Atom	:	('str'|'bool'|'int');

Def	:	 (('"'STRING*'"')|FLOAT|BOOL);

Card	:	('?'|'*'|'+');

STRING	:	(CHAR|FLOAT)+;

fragment FLOAT	:	('-')?('0'..'9')+;

fragment BOOL	:	'true'|'false';

fragment CHAR	:	('a'..'z')|('A'..'Z');

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+  { $channel=HIDDEN;} ;
