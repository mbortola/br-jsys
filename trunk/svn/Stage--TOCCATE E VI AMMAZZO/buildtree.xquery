
declare variable $doc:=doc("1file.xml");

declare variable $padre:= distinct-values(doc("1file.xml")//Release);

declare function local:build($x) as element() {
<Feature name='{$x}'>
    { for $i in $padre
    return   <Release name='{$i}' 
                                    completi='{count($doc//Intervento[Feature=$x and Release=$i and Stato="CO"])}' 
                                    aperti='{count($doc//Intervento[Feature=$x and Release=$i and Stato!="CO"])}'/> }
    <Childs>
    {for $i in $doc//Feature[@padre=$x]/@name
    return local:build($i)}
    </Childs>
</Feature>

};


<root> {
for $i in $doc//Feature[@padre='']/@name
return  local:build($i) }
</root>
