<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="xml" indent="yes"/>
	<xsl:variable name="release" select="distinct-values(/root/Interventi/Intervento/Release)"/>
	
	<xsl:key name="padre" match="/root/Features/Feature" use="@padre"/>
	
	<xsl:key name="interv" match="/root/Features/Interventi" use="Feature"/>
	
	<xsl:template match="/">
		<root>
			<xsl:apply-templates select="root/Features/key('padre','')"/>
		</root>
	</xsl:template>
	
	<xsl:template match="Feature">
		<Feature name='{@name}'>
			<xsl:for-each select="(1,2,3)">
				<Childs>
					<xsl:apply-templates select="key('padre',@name)"/>				
				</Childs>
			</xsl:for-each>
		</Feature>
	</xsl:template>
	
</xsl:stylesheet>
