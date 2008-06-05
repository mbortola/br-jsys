grammar descrittore;

options{
	output=AST;
	ASTLabelType=CommonTree;
	filter=WHITEPASPACE;
}

//se il tipo e' composto i suoi figli sono tra parentesi 
//tonde, altrimenti no

//Un tipo in questo caso e' dato da una 'lista di assegnazioni'
start	:	type+;

type 	:	STRING (':'(atom| list)) Card?;

ref	:	STRING Card?;

atom	:	Atom ((':='|'=') (Def|FLOAT|BOOL))?;

list	:	'(' (type|ref) (',' (type|ref))* ')';

Def	:	'"'STRING*'"';

Atom	:	('str'|'bool'|'int');

Card	:	('?'|'*'|'+');

FLOAT	:	('-')?('0'..'9')+;

BOOL	:	'true'|'false';

STRING	:	(CHAR|FLOAT)+;

fragment CHAR	:	('a'..'z')|('A'..'Z')|'_'|'<'|'=';

WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+  { $channel=HIDDEN;} ;
