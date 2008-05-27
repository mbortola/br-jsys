(::)

declare variable $doc:=doc("1file.xml");

declare variable $release:= distinct-values(doc("1file.xml")//Release);

declare function local:interventi($int as element()+)as element()+{
    for $i in $release
    let $rel := $int[Release=$i]
    return 
        if(empty($rel))
        then()
        else <Release name='{$i}' completi='{count($int[Stato="CO"])}' aperti='{count($int[Stato!="CO"])}'/>
};

declare function local:root($root as xs:string) as element(){
    <Feature name='{$root}'>
    {
        let $int:=$doc//Intervento[Feature=$root]
        return  
			if(count($int)>0) 
				then(local:interventi($int)) 
				else(),

        let $childs := $doc//Feature[@padre=$root]
        return 
			if(not(empty($childs)))
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

