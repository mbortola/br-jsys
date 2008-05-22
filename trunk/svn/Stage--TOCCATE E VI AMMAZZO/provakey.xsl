<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="xml" indent="yes"/>
	<xsl:variable name="release" select="distinct-values(/root/Interventi/Intervento/Release)"/>
	
	<xsl:key name="padre" match="/root/Features/Feature" use="@padre"/>
	
	<xsl:key name="interv" match="/root/Features/Interventi" use="Feature"/>
	
	<xsl:template match="/">
		<root>
			<xsl:apply-templates select="key('padre','')"/>
		</root>
	</xsl:template>
	
	<xsl:template match="Feature">
		<xsl:variable name="name" select="@name"/>
		<Feature name='{$name}'>
			<xsl:for-each-group select="//Intervento[Feature=$name]" group-by="Release">
				<Release name='{current-grouping-key()}' 
					completi='{count(current-group()[Stato="CO"])}'
					aperti="{count(current-group()[Stato=('NU','IN','WL','LA','TE')])}"/>
			</xsl:for-each-group>
			<Childs>
				<xsl:apply-templates select="key('padre',@name)"/>
			</Childs>
		</Feature>
	</xsl:template>
	
</xsl:stylesheet>
