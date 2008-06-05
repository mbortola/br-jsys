grammar descrittore2;

options{
	output=AST;
	ASTLabelType=CommonTree;
	filter=WHITESPACE;
}

@header{package grammar;}

//se il tipo e' composto i suoi figli sono tra parentesi 
//tonde, altrimenti no

//Un tipo in questo caso e' dato da una 'lista di assegnazioni'
start	:	typedef+;

typedef	:	STRING ':' type;

type 	:	(atom| list) Card?;

atom	:	Atom ((':='|'=') (Def|FLOAT|BOOL))?;

list	:	'(' el (','el)*  ')';

el	:	STRING (Card?|':' type);

Def	:	'"'STRING*'"';

Atom	:	('str'|'bool'|'int');

Card	:	('?'|'*'|'+');

FLOAT	:	('-')?('0'..'9')+;

BOOL	:	'true'|'false';

STRING	:	(CHAR|FLOAT)+;

fragment CHAR	:	('a'..'z')|('A'..'Z')|'_'|'<'|'=';

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+  { $channel=HIDDEN;} ;
