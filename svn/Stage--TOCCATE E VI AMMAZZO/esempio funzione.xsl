<?xml version="1.0" encoding="UTF-8"?>
<!-- Prova della funzionalita di XSLT 2.0 che permette la generazione di funzioni, consentendo di avere parametri di ritorno da esse(cosa che i template non fanno) -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0"
	xmlns:str="http://example.com/namespace" exclude-result-prefixes="str">
	<xsl:output method="xml" indent="yes"/>
	<xsl:key name="padreID" match="//FIELD[@NAME='Release']" use="."/>
	<xsl:function name="str:ffuwn" as="item()*">
		<xsl:variable name="var">
			<xsl:value-of select="concat(2,2,3,4,5,6)"></xsl:value-of>
		</xsl:variable>
		<xsl:value-of select="$var"/>
	</xsl:function>
	<xsl:template match="/">
		<report>
			<xsl:value-of select="str:ffuwn()"/>
			<!--<xsl:for-each select="//MktSegCode[generate-id()=generate-id(key('distinct-segcode',.))]">-->
			<xsl:for-each select="//RECORD[generate-id(FIELD[@NAME='Release'])=generate-id(key('padreID',FIELD[@NAME='Release'])) ]" >
				<a>
					<xsl:value-of select="str:ffuwn()"/>
				</a>
			</xsl:for-each>
		</report>
	</xsl:template>
</xsl:stylesheet>