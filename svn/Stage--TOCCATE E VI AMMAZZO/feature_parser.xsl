<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0"
	xmlns:str="http://example.com/namespace" exclude-result-prefixes="str">
	<xsl:output method="xml" indent="yes"/>
	<!--Nome di tutte le release -->
	<xsl:variable name="seq3" select="distinct-values(//FIELD[@NAME='Release'])"/>
	<xsl:template match="/" name="main">
		<xsl:call-template name="ReleaseTemplate">
			<xsl:with-param name="index" select="1" />
		</xsl:call-template>
	</xsl:template>
	<!--Questo template agisce differenziando in base al nome release-->
	<xsl:template name="ReleaseTemplate" >
		<xsl:param name="index"/>
		<xsl:variable name="nameRelease">
			<xsl:value-of select="$seq3[$index]"/>
		</xsl:variable>
		<xsl:element name="Release">
			<xsl:attribute name="name">
				<xsl:value-of select="$nameRelease"/>
			</xsl:attribute>
			<xsl:apply-templates select="//RECORD[FIELD[@NAME='Release']=$nameRelease and not(string(FIELD[@NAME='padre']))]">
				<xsl:with-param name="id" select="$nameRelease"/>
				<xsl:with-param name="list" select="distinct-values(//RECORD[FIELD[@NAME='Release']=$nameRelease and not(string(FIELD[@NAME='padre']))]/FIELD[@NAME='Features di riferimento'])"/>
				<xsl:with-param name="index2" select="number('1')"/>
			</xsl:apply-templates>		
		</xsl:element>
		<xsl:if test="not(empty($seq3[$index+1]))">
			<xsl:call-template name="ReleaseTemplate">
				<xsl:with-param name="index" select="$index+1"/>				
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	<!-- costruisce un albero da zero -->
	<!-- mi viene passato il nome release e la lista dei riferimenti che appartengono alla release e che sono radice  -->
	<xsl:template name="buildTreeBase" match="RECORD">
		<xsl:param name="id"/>
		<xsl:param name="list"/>
		<xsl:param name="index2"/>
	<!-- costruisco la radice -->
		<xsl:element name="IDFeatures">
			<xsl:value-of select="$list[$index2]"/>
		</xsl:element>
		<xsl:if test="not(empty($list[$index2+1]))">
			<!-- ricorsione -->
		</xsl:if>
	</xsl:template>
</xsl:stylesheet>