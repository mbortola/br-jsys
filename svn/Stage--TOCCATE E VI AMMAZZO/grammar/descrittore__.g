lexer grammar descrittore;
options {
  filter=WHITEPASPACE;

}

T12 : ':' ;
T13 : ':=' ;
T14 : '=' ;
T15 : '(' ;
T16 : ',' ;
T17 : ')' ;

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore.g" 23
Def	:	'"'STRING*'"';

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore.g" 25
Atom	:	('str'|'bool'|'int');

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore.g" 27
Card	:	('?'|'*'|'+');

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore.g" 29
FLOAT	:	('-')?('0'..'9')+;

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore.g" 31
BOOL	:	'true'|'false';

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore.g" 33
STRING	:	(CHAR|FLOAT)+;

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore.g" 35
fragment CHAR	:	('a'..'z')|('A'..'Z')|'_'|'<'|'=';

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore.g" 37
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+  { $channel=HIDDEN;} ;
