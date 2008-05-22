<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
	<xsl:output method="xml" indent="yes"/>
	<!-- A quanto pare funziona con Saxon9B-->
	<!-- lista delle releases -->
	<xsl:variable name="release" select="distinct-values(//FIELD[@NAME='Release'])"/>
	
	<xsl:key name="padre" match="//RECORD" use="FIELD[@NAME='Codice padre']"/>
	<xsl:key name="intervento" match="//RECORD[string(FIELD[@NAME='Codice'])]" use="FIELD[@NAME='Feature']"/>
	
	<xsl:template match="/">
		<xsl:element name="root">
			<xsl:call-template name="rFeat">
				<xsl:with-param name="feature" select="distinct-values(key('padre','')/FIELD[@NAME='Feature'])"/>
			</xsl:call-template>
		</xsl:element>
	</xsl:template>
	
	<xsl:template name="rFeat">
		<!-- feature e' la lista delle feature da scorrere senza doppioni -->
		<xsl:param name="feature"/>
		
		<xsl:if test="count($feature)>0">
			<xsl:for-each select="$feature" >
				<xsl:element name="Feature">
					<xsl:attribute name="name" select="."/>
					<xsl:call-template name="forRelease">
						<xsl:with-param name="feature" select="."/>
					</xsl:call-template>
					<xsl:if test="count(key('intervento',.))">
						
					</xsl:if>
				</xsl:element>
			</xsl:for-each>	
		</xsl:if>
	</xsl:template>
	
	<xsl:template name="forRelease" match="RECORD">
		<!-- ho una feature della quale devo suddividere gli interventi in base alle release -->
		<xsl:param name="feature"/>
		<!-- ho tutti gli interventi legati alla feature -->
		<xsl:variable name="Interv" select="key('intervento',$feature)" />
		<xsl:for-each select="$release">
			<xsl:if test="some $x in $Interv satisfies $x[FIELD[@NAME='Release']=.]">
				<xsl:element name="Release">
					<xsl:attribute name="name" select="."/>
				</xsl:element>
			</xsl:if>
		</xsl:for-each>
	</xsl:template>
</xsl:stylesheet>
