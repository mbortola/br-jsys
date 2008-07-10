(:Progressi:)

(:Creo risorse direttamente da XQuery:)
declare namespace  xdb="http://exist-db.org/xquery/xmldb";

xdb:register-database('org.exist.xmldb.DatabaseImpl', true()),

let $isLoggedIn := xdb:login('xmldb:exist:///db', 'admin', ''),
$out := xdb:create-collection('xmldb:exist:///db', 'output') 

for $rec in (1,2,3) 

return xdb:store($out, concat($rec, '.xml'),<a>{$rec}</a>  )  

funziona anche:

declare namespace  xdb="http://exist-db.org/xquery/xmldb";

let $out := xdb:create-collection('xmldb:exist:///db', 'output') 

for $rec in (1,2,3) 

return xdb:store($out, concat($rec, '.xml'),  <a/>) 

funziona, crea sempre in db/

declare namespace  xdb="http://exist-db.org/xquery/xmldb";

for $rec in (1,2,3) 

return xdb:store('', concat($rec, '.xml'),  <a/>)  

meglio!

declare namespace  xdb="http://exist-db.org/xquery/xmldb";

for $rec in (1,2,3) 

return xdb:store('xmldb:exist:///db/stage', concat($rec, '.xml'),  <a/>)  

includo la trasformazione ci mette pochissimo (140 ms) ad elaborare, ma ci impiega circa 1 secondo ad immagazzinare il file in uscita

declare namespace  xdb="http://exist-db.org/xquery/xmldb";

let $transformed := transform:transform(doc('1file.xml'), doc('provakey2.xsl'), ())

return xdb:store('xmldb:exist:///db/stage', 'nuovo.xml',  $transformed) 