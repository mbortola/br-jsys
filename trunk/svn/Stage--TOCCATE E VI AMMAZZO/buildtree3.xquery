
(::)

declare variable $doc:=doc("1file.xml");

declare variable $release:= distinct-values(doc("1file.xml")//Release);

declare function local:interventi($int as element()+)as element()+{
    for $i in $release
    let $rel := $int[Release=$i]
    return 
        if($rel)
        then <Release name='{$i}' completi='{count($rel[Stato="CO"])}' aperti='{count($rel[not(Stato="CO")])}'/>
        else ()
};

declare function local:root($root as element()) as element(){
    <Feature name='{$root/@name}'>
    {
        let $int:=$doc//Intervento[Feature=$root/@name]
        return  
	if($int) 
		then(local:interventi($int)) 
		else(),

        let $childs := $doc//Feature[@padre=$root/@name]
        return 
	if($childs)
		then(	<Childs> {
			for $z in $childs return local:root($z)}
				</Childs>)
		else()
    }
    </Feature>
};


<root> {
for $i in $doc//Feature[@padre='']
return local:root($i) }
</root>

