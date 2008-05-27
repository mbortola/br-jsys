(::)

declare variable $doc:=doc("1file.xml");


declare variable $release:= distinct-values(doc("1file.xml")//Release);

declare function local:interventi($int as element()+)as element()+{
    for $i in distinct-values($int/Release)
    let $rel := $int[Release=$i]
    return 
        if($rel)
        then <Release name='{$i}' completi='{count($rel[Stato="CO"])}' aperti='{count($rel[not(Stato="CO")])}'/>
        else ()
};

declare function local:root($root as xs:string) as element(){
    <Feature name='{$root}'>
    {
        let $int:=$doc//Intervento[Feature=$root]
        return  
	if($int) 
		then(local:interventi($int)) 
		else(),
        let $childs := $doc//Feature[@padre=$root]
        return 
	if($childs)
		then(	<Childs> {
			for $z in $childs/@name return local:root($z)}
				</Childs>)
		else()
    }
    </Feature>
};


<root> {
for $i in $doc//Feature[@padre='']/@name
return local:root($i) }
</root>

