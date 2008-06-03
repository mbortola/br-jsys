grammar descrittore;

options{
	output=AST;
	ASTLabelType=CommonTree;
}

//se il tipo e' composto i suoi fiogli sono tra parentesi 
//tonde, altrimenti no

start	:	base (';'base+);

base 	:	STRING':' (atom|list) Card?;

atom	:	Atom (KeyWord (STRING|FLOAT))?;

list	:	'(' base (',' base)* ')';

Atom	:	('str'|'bool'|'int');

Card	:	('?'|'*'|'+');

FLOAT	:	('-')?('0'..'9')+;

BOOL	:	'TRUE'|'FALSE';

KeyWord	:	':='|'=';

STRING	:	(CHAR|FLOAT)+;

fragment CHAR	:	('a'..'z')|('A'..'Z')|'_';
