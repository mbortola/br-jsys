lexer grammar descrittore2;
options {
  filter=WHITESPACE;

}

T12 : ':' ;
T13 : ':=' ;
T14 : '=' ;
T15 : '(' ;
T16 : ',' ;
T17 : ')' ;

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore2.g" 27
Def	:	'"'STRING*'"';

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore2.g" 29
Atom	:	('str'|'bool'|'int');

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore2.g" 31
Card	:	('?'|'*'|'+');

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore2.g" 33
FLOAT	:	('-')?('0'..'9')+;

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore2.g" 35
BOOL	:	'true'|'false';

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore2.g" 37
STRING	:	(CHAR|FLOAT)+;

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore2.g" 39
fragment CHAR	:	('a'..'z')|('A'..'Z')|'_'|'<'|'=';

// $ANTLR src "C:\Documents and Settings\Administrator\Desktop\Stage\br-jsys\svn\Stage--TOCCATE E VI AMMAZZO\descrittore2.g" 41
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+  { $channel=HIDDEN;} ;
