<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0" >
	<xsl:output method="xml" indent="yes"/>
	<xsl:template match="/">
		<root>
		<xsl:for-each select="root/row[PADRE='NULL']">
			<xsl:variable name="id">
				<xsl:value-of select="ID"/>
			</xsl:variable>
			<row>
				<xsl:copy-of select="ID"/>
				<xsl:copy-of select="DESCRIPTION"/>
				<xsl:apply-templates select="../row[PADRE=$id]"/>
			</row>
		</xsl:for-each>
		</root>
	</xsl:template>
	<xsl:template match="row">
		<xsl:element name="child" >
			<xsl:variable name="id">
				<xsl:value-of select="ID"/>
			</xsl:variable>
			<xsl:copy-of select="ID"/>
			<xsl:copy-of select="DESCRIPTION"/>
			<xsl:apply-templates select="../row[PADRE=$id]"/>
		</xsl:element>
	</xsl:template>	
</xsl:stylesheet>
