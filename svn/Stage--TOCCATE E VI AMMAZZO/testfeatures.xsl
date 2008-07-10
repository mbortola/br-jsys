<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	
	
	<xsl:output method="text" indent="no"/>
	
	<xsl:template match="/">
		<xsl:call-template name="corrispondenza"/>
		<xsl:call-template name="testpadre"/>
		<xsl:text>Finito</xsl:text>
	</xsl:template>
	<!-- Test che controlla se esiste una corrispondenza tra le due rappresentazioni dele features -->
	<xsl:template name="corrispondenza">

		<xsl:if test="some $i in root/Tree//Feature/@name satisfies 
			empty(root/Features/Feature/@name[.=$i])">
			<xsl:text>Test 1 fallito.
</xsl:text>
		</xsl:if>
		
		<xsl:if test="some $i in root/Features/Feature/@name satisfies 
			empty(root/Tree//Feature/@name[.=$i])">
			<xsl:text>Test 2 fallito.
</xsl:text>
		</xsl:if>
		
	</xsl:template>
	<!-- Test per vedere se esistono features con padri inesistenti -->
	<xsl:template name="testpadre">
		
		<xsl:variable name="tree" select="root/Tree//Feature"/>
		<xsl:variable name="plain" select="root/Features//Feature"/>
		<xsl:text>Test 2
		</xsl:text>
		
		<xsl:if test="some $i in $plain
			satisfies $i/@padre != $tree[@name=$i/@name]/../../@name">
			<xsl:text>Test padre fallito</xsl:text>
		</xsl:if>
	</xsl:template>
	
</xsl:stylesheet>
